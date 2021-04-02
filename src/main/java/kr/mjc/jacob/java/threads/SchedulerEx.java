package kr.mjc.jacob.java.threads;

import java.util.concurrent.*;

public class SchedulerEx {
  public static void main(String[] args) {
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    Runnable beeper = () -> System.out.print("beep ");

    // (task, initialDeday, period, unit)
    // beeper 태스크를 1초 후부터 1초 간격으로 실행
    scheduler.scheduleAtFixedRate(beeper, 1, 1, TimeUnit.SECONDS);
  }
}
