package kr.mjc.jacob.java.lambdaexpression;

/**
 * Person을 테스트해서 true 또는 false를 리턴한다.
 */
@FunctionalInterface
public interface CheckPerson {
  boolean test(Person p);
}
