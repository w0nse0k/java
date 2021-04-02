package kr.mjc.jacob.java.threads;

/**
 * p.694 예제 코드
 */
class TimerThread extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 4; i++) {
      System.out.println(i);
      try {
        Thread.sleep(1000);  // 1000ms(1초) 동안 휴식
      } catch (InterruptedException e) {
      }
    }
  }
}

public class TestThread {
  public static void main(String[] args) {
    Thread th = new TimerThread();
    th.start();
  }
}
