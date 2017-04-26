package com.yonyou.test.quartzConfig;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * Created by xinggq on 17-3-29.
 */

/**
 * 作用：job参数设置
 * 1.JobDetail表示一个具体的可执行的调度程序，Job是这个可执行的调度程序的内容，
 *     同时JobDetail还包括了这个任务调度的方案和策略
 *
 * 2.Trigger代表一个调度参数的配置，什么时候去调。
 *
 * 3.Scheduler代表调度容器，一个调度容器中可以注册多个JobDetail和Trigger，当JobDetail和Trigger组合后
 *      就可以被Scheduler调度了
 *
 */
@Component
public class MyScheduler {

    @Autowired
    //调度容器工厂
    SchedulerFactoryBean schedulerFactoryBean;

    /**
     * 调度job
     * @throws SchedulerException
     */
    public void scheduleJobs() throws SchedulerException {
        //获取一个scheduler容器
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        startJob1(scheduler);
       //startJob2(scheduler);
    }

    //启动一个任务
    private void startJob1(Scheduler scheduler) throws SchedulerException{

        //通过JobBuilder创建一个JobDetail
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob.class) .withIdentity("job1", "group1").build();
        //设置调度时间
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        //创建一个Trigger，并将调度时间装配进去
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1") .withSchedule(scheduleBuilder).build();
        //将JobDetail和Trigger装配到一块放入scheduler容器中
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }
//    private void startJob2(Scheduler scheduler) throws SchedulerException{
//        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob2.class) .withIdentity("job2", "group1").build();
//        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");
//        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group1") .withSchedule(scheduleBuilder).build();
//        scheduler.scheduleJob(jobDetail,cronTrigger);
//    }
}
