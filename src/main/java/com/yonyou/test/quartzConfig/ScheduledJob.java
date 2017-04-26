package com.yonyou.test.quartzConfig;

import com.yonyou.test.service.UserService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xinggq on 17-3-29.
 */

/**
 * job的具体实现
 * Job表示一个工作，要执行的具体内容，Job接口中只有一个execute方法
 */

public class ScheduledJob implements Job {

    @Autowired
    UserService userService;

    private SimpleDateFormat dateFormat() {
        return new SimpleDateFormat("HH:mm:ss");
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("AAAA: The time is now " + dateFormat().format(new Date()));

       // System.out.println(userService.selectById("1"));
    }
}