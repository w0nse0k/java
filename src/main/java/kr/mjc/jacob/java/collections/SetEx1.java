package kr.mjc.jacob.java.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * Set 예제 1. Set of String
 */
public class SetEx1 {
  public static void main(String[] args) {
    Set<String> words = new HashSet<>(); // Set은 순서가 없다.
    words.add("java");
    words.add("database");
    words.add("java"); // 중복 데이터를 넣으면 안들어간다.

    System.out.println(words); // [database, java]
    System.out.println(words.contains("java")); // true

    for (String element : words) {
      System.out.println(element);
    }
  }
}
