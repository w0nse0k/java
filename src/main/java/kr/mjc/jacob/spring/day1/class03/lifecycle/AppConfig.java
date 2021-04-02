package kr.mjc.jacob.spring.day1.class03.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  @Bean(initMethod = "init")
  public SamsungTVWithLifeCycleCallbacks samsungTV() {
    return new SamsungTVWithLifeCycleCallbacks();
  }
}
