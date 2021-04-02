package kr.mjc.jacob.java.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * p.416 예제 7-5 HashMapDicEx 수정
 */
public class MapEx1 {
  public static void main(String[] args) {
    Map<String, String> dic = new HashMap<>(); // 해시맵 생성

    // 3개의 (key, value) 쌍을 dic에 저장
    dic.put("baby", "아기"); // "baby"는 key, "아기"는 value
    dic.put("love", "사랑");
    dic.put("apple", "사과");
    System.out.println(dic);

    System.out.println(dic.get("baby"));
    System.out.println(dic.get("love"));
    System.out.println(dic.get("apple"));
  }
}
