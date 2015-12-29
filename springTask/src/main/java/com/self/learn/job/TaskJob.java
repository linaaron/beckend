package com.self.learn.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TaskJob {
    private static final Logger LOG = LoggerFactory.getLogger(TaskJob.class);

    @Scheduled(cron = "${jobOne}")
    public void jobOne() {
        LOG.info("==========================jobOne");
    }

    //    @Scheduled(fixedRate = 1000 * 3)
    @Scheduled(cron = "${jobTwo}")
    public void print() {
        LOG.info("==========================jobTwo");
    }
}
