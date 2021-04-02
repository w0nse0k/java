package kr.mjc.jacob.spring.day1.class02;

import java.util.HashMap;
import java.util.Map;

/**
 * p45 BeanFactory 수정.
 */
public class BeanFactory {

  Map<String, Object> map = new HashMap<>();

  /**
   * 컨스트럭터에서 인스턴스(빈)를 미리 생성해서 맵에 저장한다.
   */
  public BeanFactory() {
    map.put("samsung", new SamsungTV());
    map.put("lg", new LgTV());
    System.out.println("beanFactory가 빈들을 생성했습니다.");
  }

  /**
   * 미리 생성해 놓은 빈을 리턴한다.
   */
  public Object getBean(String name) {
    return map.get(name);
  }
}
