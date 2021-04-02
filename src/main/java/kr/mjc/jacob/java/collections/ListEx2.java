package kr.mjc.jacob.java.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * p.403 예제 7-2 PointVectorEx 수정<br>
 * Vector 대신 ArrayList로 한다.
 */
public class ListEx2 {
  public static void main(String[] args) {
    List<Point> list = new ArrayList<>();

    // 3 개의 Point 객체 삽입
    list.add(new Point(2, 3));
    list.add(new Point(-5, 20));
    list.add(new Point(30, -8));
    System.out.println(list);
    // [Point{x=2, y=3}, Point{x=-5, y=20}, Point{x=30, y=-8}]

    list.remove(1); // 인덱스 1의 Point(-5, 20) 객체 삭제
    System.out.println(list); // [Point{x=2, y=3}, Point{x=30, y=-8}]

    // 특정 위치의 element 찾기
    Point p1 = list.get(1); // index 1의 element
    System.out.println(p1); // Point{x=30, y=-8}

    // 모든 엘리먼트 꺼내기
    for (Point p : list) {
      System.out.println(p);
    }
  }
}