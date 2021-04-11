package kr.mjc.jacob.java.collections;

import java.util.Objects;

/**
 * p.403 예제 7-2. Point 클래스 수정
 */
public class Point {
  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return "Point{" + "x=" + x + ", y=" + y + '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Point) {
      Point p = (Point) obj;
      return this.x == p.getX() && this.y == p.getY();
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
