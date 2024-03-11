//package com.example.quarzt.configuration;
//
//import com.example.quarzt.job.JobTest;
//import org.quartz.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class QuartzConfig {
//
//  @Bean
//  public JobDetail helloJobDetail() {
//    return JobBuilder.newJob(JobTest.class)
//          .withIdentity("HelloJob")
//          .storeDurably()
//          .build();
//  }
//
//  @Bean
//  public Trigger helloJobTrigger(JobDetail jobDetail) {
//    return TriggerBuilder.newTrigger()
//          .forJob(jobDetail)
//          .withIdentity("HelloJobTrigger")
//          .withSchedule(CronScheduleBuilder.cronSchedule("0 * * ? * *")) // Chạy vào đầu mỗi phút
//          .build();
//  }
//}