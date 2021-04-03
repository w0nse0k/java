package kr.mjc.jacob.spring.day1.class02;

import org.springframework.stereotype.Component;

/**
 * p.43 수정
 */
@Component
public class LgTV implements TV {

  public LgTV() {
    System.out.println("LgTV is created.");
  }
}
