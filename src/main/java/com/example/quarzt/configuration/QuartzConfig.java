package com.example.quarzt.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class QuartzConfig {

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

  @Autowired
  private DataSource dataSource;

  @Bean
  public SchedulerFactoryBean scheduler() {
    SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();

    Properties properties = new Properties();

    properties.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.PostgreSQLDelegate");
    schedulerFactory.setQuartzProperties(properties);
    schedulerFactory.setDataSource(dataSource);

    schedulerFactory.setWaitForJobsToCompleteOnShutdown(true);

    return schedulerFactory;
  }
}