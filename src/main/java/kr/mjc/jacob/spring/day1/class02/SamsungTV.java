package kr.mjc.jacob.spring.day1.class02;

import org.springframework.stereotype.Component;

/**
 * p.42 수정
 */
@Component
public class SamsungTV implements TV {

  public SamsungTV() {
    System.out.println("SamsungTV is created.");
  }
}
