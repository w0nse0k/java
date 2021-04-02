package kr.mjc.jacob.java.exceptions;

import java.util.Scanner;

/**
 * p.151. 예제 3-14
 */
public class DivideByZero {

  public static void main(String[] args) {
    try {
      new DivideByZero().go();
    } catch (ArithmeticException e) {
      System.out.println("나눗수가 0입니다.");
    }
  }

  public void go() {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("나뉨수를 입력하세요 : ");
      int dividend = scanner.nextInt();
      System.out.print("나눗수를 입력하세요 : ");
      int divisor = scanner.nextInt();

      int share = dividend / divisor;
      System.out.format("몫은 %d 입니다.\n", share);
      System.out.println("프로그램을 정상적으로 종료합니다.");
    }
  }
}
