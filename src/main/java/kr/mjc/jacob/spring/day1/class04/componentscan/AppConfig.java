package kr.mjc.jacob.spring.day1.class04.componentscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "kr.mjc.jacob.spring.day1.class04.componentscan")
public class AppConfig {
  // component scan은 클래스들에서 annotation을 사용해서 구성한다.
}
