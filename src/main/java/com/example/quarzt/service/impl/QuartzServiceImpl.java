package com.example.quarzt.service.impl;

import com.example.quarzt.job.JobTest;
import com.example.quarzt.service.QuartzService;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class QuartzServiceImpl implements QuartzService {
  private final Scheduler scheduler;
  @Override
  public void schedulePrintTimeJob(String cronExpression) throws SchedulerException {
    String jobName = "printTimeGroup: " + new Date().getTime();
    String jobGroup = "printTimeGroup" + new Date().getTime();

    Map<String, String> jobData = new HashMap<>();
    jobData.put("someKey", "someValue");

    JobDataMap jobDataMap = new JobDataMap(jobData);

    JobDetail jobDetail = JobBuilder.newJob(JobTest.class)
          .withIdentity(jobName, jobGroup)
          .usingJobData(jobDataMap)
          .storeDurably()
          .build();

    CronTrigger cronTrigger = TriggerBuilder.newTrigger()
          .withIdentity(jobName, jobGroup)
          .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
          .build();

    scheduler.scheduleJob(jobDetail, cronTrigger);

  }
}
