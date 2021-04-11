package kr.mjc.jacob.spring.day1.class04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * p.71, 82 xml 구성을 Java-based 구성으로
 */
@Configuration
public class AppConfig {

  @Bean
  public SonySpeaker sonySpeaker() {
    return new SonySpeaker();
  }

  @Bean
  public AppleSpeaker appleSpeaker() {
    return new AppleSpeaker();
  }

  /**
   * Constructor-based dependency injection
   */
  @Bean
  public SamsungTV samsungTV() {
    return new SamsungTV(sonySpeaker());
  }

  /**
   * Setter-based dependency injection
   */
  @Bean
  public LgTV lgTV() {
    LgTV lgTV = new LgTV();
    lgTV.setSpeaker(appleSpeaker());
    return lgTV;
  }
}
