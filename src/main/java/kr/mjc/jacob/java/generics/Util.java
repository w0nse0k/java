package kr.mjc.jacob.java.generics;

/**
 * 참조 : https://docs.oracle.com/javase/tutorial/java/generics/methods.html
 */
public class Util {

  /**
   * 제네릭 메서드. 리턴 타입 앞에 타입 파라미터를 쓴다.
   */
  public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
    return p1.getKey().equals(p2.getKey()) &&
        p1.getValue().equals(p2.getValue());
  }
}
