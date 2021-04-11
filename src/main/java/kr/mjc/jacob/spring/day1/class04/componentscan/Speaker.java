package kr.mjc.jacob.spring.day1.class04.componentscan;

public interface Speaker {

  default void volumeUp() {
    System.out.format("%s - volume Up.\n", getClass().getSimpleName());
  }

  default void volumeDown() {
    System.out.format("%s - volume Down.\n", getClass().getSimpleName());
  }
}