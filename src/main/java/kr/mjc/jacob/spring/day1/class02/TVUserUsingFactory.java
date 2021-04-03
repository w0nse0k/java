package kr.mjc.jacob.spring.day1.class02;

import java.util.Scanner;

/**
 * p.45 TVUser 수정
 */
public class TVUserUsingFactory {

  public static void main(String[] args) {
    BeanFactory factory = new BeanFactory(); // 빈을 미리 생성해 둔다.

    System.out.print("Input bean's name : ");

    // try-with-resources 구문.
    // AutoCloseable 인터페이스를 구현한 클래스들을 자동으로 close()한다.
    // finally 블럭에 scanner.close(); 한 것과 동일한 효과
    try (Scanner scanner = new Scanner(System.in)) {
      String beanName = scanner.next();
      TV tv = (TV) factory.getBean(beanName); // 빈을 꺼낸다.
      tv.powerOn();
    }
  }
}
