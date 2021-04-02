package kr.mjc.jacob.java.threads;

/**
 * 공유 자원 프린터
 */
public class Printer {
  /**
   * 문자열을 출력한다. 한 글자당 1ms 소요
   */
  public synchronized void println(String str) {
    for (char c : str.toCharArray()) {
      System.out.print(c);
      try { // thread interference를 확인하기 위해 10ms의 휴식을 한다.
        Thread.sleep(10);
      } catch (InterruptedException e) {
      }
    }
    System.out.print('\n');
  }
}

