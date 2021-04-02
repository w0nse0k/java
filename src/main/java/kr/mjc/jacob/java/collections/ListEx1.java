package kr.mjc.jacob.java.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * p.402 예제 7-1 VectorEx 수정<br>
 * Vector는 동기화되어 있다. thread-safe가 필요없으면 ArrayList를 사용한다.
 */
public class ListEx1 {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(); // 정수 리스트
    list.add(5); // 5 삽입
    list.add(4); // 4 삽입
    list.add(-1); // -1 삽입
    System.out.println(list); // [5,4,-1]

    // 리스트 중간에 삽입하기
    list.add(2, 100); // index 2에 100 삽입
    System.out.println(list); // [5, 4, 100, -1]
    System.out.println("리스트의 엘리먼트 갯수 : " + list.size());

    // 특정 위치의 element 찾기
    System.out.println(list.get(3)); // -1

    // 모든 엘리먼트 하나씩 꺼내기
    for (Integer m : list) {
      System.out.format("%d ", m);
    }
    System.out.println();
  }
}
