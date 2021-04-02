package kr.mjc.jacob.java.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * Set 예제 2. Set Of Point
 */
public class SetEx2 {
  public static void main(String[] args) {
    // 두 점이 같은지 아닌지 판단하려면 Point에 hashCode()와 equals() 메서드를
    // 구현해야 한다. hashCode() 값이 같고 equals()가 true이면 같은 오브젝트이다.
    Set<Point> points = new HashSet<>();
    Point p1 = new Point(3, 4);
    Point p2 = new Point(1, 2);
    Point p3 = new Point(1, 2);
    points.add(p1);
    points.add(p2);
    points.add(p3);
    System.out.println(points);

    System.out.println(p2.equals(p3));
    System.out.format("p2.hashCode()=%d, p3.hashCode()=%d\n", p2.hashCode(),
        p3.hashCode());
  }
}
