package kr.mjc.jacob.java.generics;

/**
 * 참조 : https://docs.oracle.com/javase/tutorial/java/generics/methods.html
 */
public class UtilTest {
  public static void main(String[] args) {

    Pair<Integer, String> p1 = new Pair<>(1, "apple");
    Pair<Integer, String> p2 = new Pair<>(1, "apple");
    boolean isSame = Util.compare(p1, p2); // type inference (타입 추정)

    System.out.println(isSame);
  }
}
