package com.self.learn.job;

import com.self.learn.bean.Job;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@DisallowConcurrentExecution  //表示有状态的Job,不加表示无状态
public class QuartzJobFactory implements org.quartz.Job {
    private static final Logger LOG = LoggerFactory.getLogger(QuartzJobFactory.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("job begin......");
        Job scheduleJob = (Job) context.getMergedJobDataMap().get("scheduleJob");
        try {
            Class<?> taskJob = Class.forName(scheduleJob.getTargetObject());
            Method[] methods = taskJob.getMethods();
            for (Method method : methods) {
                if (method.getName().equals(scheduleJob.getTargetMethod())) {
                    method.invoke(taskJob.newInstance(), null);
                    break;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        System.out.println("job end = [" + scheduleJob.getJobName() + "]");
    }
}
