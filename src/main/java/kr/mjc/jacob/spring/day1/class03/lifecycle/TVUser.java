package kr.mjc.jacob.spring.day1.class03.lifecycle;

import kr.mjc.jacob.spring.day1.class02.SamsungTV;
import kr.mjc.jacob.spring.day1.class02.TV;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TVUser {

  public static void main(String[] args) {

    // @Configuration 클래스의 @Bean으로 정의된 빈들을 모두 생성해서
    // context에 넣는다.
    ConfigurableApplicationContext context
        = new AnnotationConfigApplicationContext(AppConfig.class);

    TV samsungTV = context.getBean(SamsungTV.class);
    samsungTV.powerOn();
    samsungTV.powerOff();
    context.close();
  }
}
