package kr.mjc.jacob.spring.day1.class03.lifecycle;

import kr.mjc.jacob.spring.day1.class02.SamsungTV;

/**
 * p.60 init와 destroy 메서드가 추가된 SamsungTV
 */
public class SamsungTVWithLifeCycleCallbacks extends SamsungTV {

  public void init() {
    System.out.println("samsungTV is initialized.");
  }

  public void close() {
    System.out.println("samsungTV is destroyed.");
  }
}
