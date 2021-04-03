package kr.mjc.jacob.spring.day1.class03;

import kr.mjc.jacob.spring.day1.class02.LgTV;
import kr.mjc.jacob.spring.day1.class02.SamsungTV;
import kr.mjc.jacob.spring.day1.class02.TV;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * p.53
 */
public class TVUserUsingXmlBasedConfiguration {

  public static void main(String[] args) {

    // xml의 <bean ...>으로 정의되어 있는 빈들을 모두 미리 생성해서 context에 넣는다.
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "applicationContext03.xml");

    // by-name lookup. 이름으로 찾는다.
    // 빨리 찾는다. id를 잘못쓰면 런타임에 에러가 날 수 있다.
    TV samsungTV = context.getBean("samsungTV", SamsungTV.class);
    samsungTV.powerOn();
    samsungTV.powerOff();

    // by-type lookup. 타입으로 찾는다.
    // 속도가 느리다. 컴파일 타임에 오류를 발견할 수 있다.
    TV lgTV = context.getBean(LgTV.class);
    lgTV.powerOn();
    lgTV.powerOff();
  }
}