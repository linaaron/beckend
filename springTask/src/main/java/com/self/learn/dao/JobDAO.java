package com.self.learn.dao;

import com.self.learn.bean.Job;

import java.util.ArrayList;
import java.util.List;

public class JobDAO {
    /**
     * 计划任务map
     */
    public static List<Job> jobList = new ArrayList<Job>();

    static {
//        for (int i = 0; i < 5; i++) {
            Job job = new Job();
            job.setJobId("10001");
            job.setJobName("data_import_1");
            job.setTargetObject("com.self.learn.job.TaskJob");
            job.setTargetMethod("jobOne");
            job.setJobGroup("dataWork");
            job.setJobStatus("1");
            job.setCronExpression("0/5 * * * * ?");
//            job.setDesc("date load success ........");
            addJob(job);

        Job job2 = new Job();
        job2.setJobId("10002");
        job2.setJobName("data_import_2");
        job2.setTargetObject("com.self.learn.job.TaskJob");
        job2.setTargetMethod("jobTwo");
        job2.setJobGroup("dataWork");
        job2.setJobStatus("1");
        job2.setCronExpression("0/5 * * * * ?");
//            job.setDesc("date load success ........");
        addJob(job2);
//        }
    }

    /**
     * 添加任务
     *
     * @param scheduleJob
     */
    public static void addJob(Job scheduleJob) {
        jobList.add(scheduleJob);
    }
}
