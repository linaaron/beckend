package com.self.learn.main;

import org.quartz.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class JobMain {

    private static ApplicationContext context = null;
    static final String[] path = {"classpath:spring.xml"};
    static final String[] classpath = {"spring.xml"};

    private static void init() {
        try {
            context = new FileSystemXmlApplicationContext(path);
        } catch (Exception e) {
            try {
                context = new FileSystemXmlApplicationContext(classpath);
            } catch (Exception e2) {
                try {
                    context = new ClassPathXmlApplicationContext(classpath);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws SchedulerException {
        init();
        /*Scheduler scheduler = (Scheduler)context.getBean("schedulerFactoryBean");

        System.out.println(context);

        System.out.println(scheduler);        //这里获取任务信息数据
        List<ScheduleJob> jobList = new ArrayList<ScheduleJob>();
        for (int i = 0; i < 3; i++) {
            ScheduleJob job = new ScheduleJob();
            job.setJobId("10001" + i);
            job.setJobName("JobName_" + i);
            job.setJobGroup("dataWork");
            job.setJobStatus("1");
            job.setCronExpression("0/5 * * * * ?");
            job.setDesc("数据导入任务");
            jobList.add(job);
        }        for (ScheduleJob job : jobList) {

            TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
            //获取trigger，即在spring配置文件中定义的 bean id="myTrigger"
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);            //不存在，创建一个
            if (null == trigger) {
                JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactory.class)
                        .withIdentity(job.getJobName(), job.getJobGroup()).build();
                jobDetail.getJobDataMap().put("scheduleJob", job);
                //表达式调度构建器
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job
                        .getCronExpression());
                //按新的cronExpression表达式构建一个新的trigger
                trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();
                scheduler.scheduleJob(jobDetail, trigger);
            } else {                // Trigger已存在，那么更新相应的定时设置                //表达式调度构建器
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job
                        .getCronExpression());
                //按新的cronExpression表达式重新构建trigger
                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey)
                        .withSchedule(scheduleBuilder).build();
                //按新的trigger重新设置job执行                scheduler.rescheduleJob(triggerKey, trigger);
            }
        }*/
    }

}
