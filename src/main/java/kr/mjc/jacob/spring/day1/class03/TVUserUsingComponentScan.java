package kr.mjc.jacob.spring.day1.class03;

import kr.mjc.jacob.spring.day1.class02.LgTV;
import kr.mjc.jacob.spring.day1.class02.SamsungTV;
import kr.mjc.jacob.spring.day1.class02.TV;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * p.53을 component scan으로 수정
 */
public class TVUserUsingComponentScan {

  public static void main(String[] args) {

    // @ComponentScan의 basePackage에서 @Component로 정의된 빈들을 생성
    // Java-based configuration에서 component scan
    ApplicationContext context = new AnnotationConfigApplicationContext(
        AppConfigUsingComponentScan.class);

    // XML-based configuration에서 component scan
    // ApplicationContext context = new ClassPathXmlApplicationContext(
    // "applicationContext03-cs.xml");

    TV samsungTV = context.getBean(SamsungTV.class);
    samsungTV.powerOn();
    samsungTV.powerOff();

    TV lgTV = context.getBean(LgTV.class);
    lgTV.powerOn();
    lgTV.powerOff();
  }
}
