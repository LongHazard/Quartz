package com.example.quarzt.service;

import org.quartz.SchedulerException;

public interface QuartzService {
  void schedulePrintTimeJob(String cronExpression) throws SchedulerException;
}
