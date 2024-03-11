package com.example.quarzt.configuration;

import com.example.quarzt.service.QuartzService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuartzCommandLineRunner implements CommandLineRunner {
  private final QuartzService quartzService;

  @Override
  public void run(String... args) throws Exception {
    quartzService.schedulePrintTimeJob("0 * * ? * *");
  }
}
