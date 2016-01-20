package com.self.learn.service;

import com.self.learn.bean.Job;
import com.self.learn.dao.JobDAO;
import com.self.learn.job.QuartzJobFactory;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private static final Logger LOG = LoggerFactory.getLogger(ScheduleService.class);

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    public void scheduleBuild() throws SchedulerException, ClassNotFoundException, NoSuchMethodException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();

        //这里从DB获取任务信息数据
        List<Job> jobList = JobDAO.jobList;

        for (Job job : jobList) {
            TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());

            //获取trigger，即在spring配置文件中定义的 bean id="myTrigger"
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

            if (null == trigger) {
                createTrigger(scheduler, job);
            } else {
                updateTrigger(scheduler, trigger, triggerKey, job);
            }
        }
    }

    private void createTrigger(Scheduler scheduler, Job job) {
        //定义jobDetail
        JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactory.class)
                .withIdentity(job.getJobName(), job.getJobGroup()).build();
        jobDetail.getJobDataMap().put("scheduleJob", job);

        //表达式调度构建器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job
                .getCronExpression());

        //按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();

        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            LOG.error("ScheduleService.createTrigger: {}", e.getMessage());
        }
    }

    private void updateTrigger(Scheduler scheduler, CronTrigger trigger, TriggerKey triggerKey, Job job) {
        //表达式调度构建器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job
                .getCronExpression());

        //按新的cronExpression表达式重新构建trigger
        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey)
                .withSchedule(scheduleBuilder).build();

        //按新的trigger重新设置job执行
        try {
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException e) {
            LOG.error("ScheduleService.updateTrigger: {}", e.getMessage());
        }
    }

}
