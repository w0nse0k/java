package kr.mjc.jacob.spring.day1.class04;


import kr.mjc.jacob.spring.day1.class02.TV;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TVUserUsingJavaConfig {

  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);

    TV samsungTV = context.getBean(SamsungTV.class);
    samsungTV.volumeUp();
    TV lgTV = context.getBean(LgTV.class);
    lgTV.volumeDown();
  }
}
