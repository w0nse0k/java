package kr.mjc.jacob.spring.day1.class02;

import java.util.Scanner;

/**
 * p.45 TVUser 수정
 */
public class TVUserUsingFactory {

  public static void main(String[] args) {
    BeanFactory factory = new BeanFactory(); // 빈을 미리 생성해 둔다.

    System.out.print("Input bean's name : ");
    try (Scanner scanner = new Scanner(System.in)) {
      String beanName = scanner.next();
      TV tv = (TV) factory.getBean(beanName); // 빈을 꺼낸다.
      tv.powerOn();
    }
  }
}
