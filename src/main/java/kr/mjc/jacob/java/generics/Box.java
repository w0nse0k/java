package kr.mjc.jacob.java.generics;

/**
 * 참조 : https://docs.oracle.com/javase/tutorial/java/generics/types.html
 */
public class Box<T> {

  private T t;

  public void set(T t) {
    this.t = t;
  }

  public T get() {
    return t;
  }
}
