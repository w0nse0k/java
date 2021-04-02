package kr.mjc.jacob.spring.day1.class02;

/**
 * p.42
 */
public interface TV {

  default void powerOn() {
    System.out.format("%s power on.\n", getClass().getSimpleName());
  }

  default void powerOff() {
    System.out.format("%s power off.\n", getClass().getSimpleName());
  }

  default void volumeUp() {
    System.out.format("%s volume up.\n", getClass().getSimpleName());
  }

  default void volumeDown() {
    System.out.format("%s volume down.\n", getClass().getSimpleName());
  }
}
