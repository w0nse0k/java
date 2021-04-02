package kr.mjc.jacob.java.generics;

@SuppressWarnings("all")
public class GenericTest {

  public static void main(String[] args) {

    // 1. 제네릭을 사용하지 않는다.
    SimpleBox box = new SimpleBox();
    box.set(5); // promotion. Integer -> Object
    Integer n1 = (Integer) box.get(); // type casting. Object -> Integer

    box.set("iu");
    String s1 = (String) box.get();

    // 2. 제네렉을 사용한다.
    // Integer : type argument
    // Box<Integer> : Box of Integer. parameterized type
    Box<Integer> integerBox = new Box<Integer>();
    integerBox.set(5);
    Integer n2 = integerBox.get(); // type casting이 필요 없음

    Box<String> stringBox = new Box<>(); // type inference (타입 추정)
    stringBox.set("iu");
    String s2 = stringBox.get();

    // 3. 제네릭에 타입 인자를 넣지 않는 것을 raw type이라 한다.
    // 원래부터 제네릭이 아닌 것은 raw type이 아니다.
    // raw type을 사용할 수는 있지만 안쓰는 것이 좋다.
    Box rawBox = new Box();
    rawBox.set(5);
    Integer n3 = (Integer) rawBox.get();
  }
}
