package kr.mjc.jacob.java.threads.homework;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 과제 2. 여러 개의 사이트를 멀티 스레드 다운로드
 */
public class GetContent {

  final String[] SITES = {"google.com", "youtube.com", "facebook.com",
      "instagram.com", "netflix.com", "twitter.com", "wikipedia.org",
      "imdb.com"};

  public static void main(String[] args) {
    new GetContent().come();
  }

  /**
   * 순차 다운로드
   */
  public void go() {
    final long start = System.currentTimeMillis(); // 시작 시간
    for (int i = 0; i < SITES.length; i++) {
      try {
        FileUtils.copyURLToFile(new URL("https://" + SITES[i]),
            new File("out/" + SITES[i]));
        System.out.format("%s : %d ms\n", SITES[i],
            System.currentTimeMillis() - start); // 다운로드 완료시간
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * 멀티 스레드 다운로드 (스레드 1개가 사이트 1개 다운로드)
   * 사이트 갯수만큼 워커 스레드 생성
   */
  public void come() {
    // 스레드 풀 생성. 워커 스레드가 동작한다.
    ExecutorService service = Executors.newFixedThreadPool(SITES.length);
    final long start = System.currentTimeMillis();
    for (int i = 0; i < SITES.length; i++) {
      final int N = i;  // final 변수로 선언해서 스레드에 넣는다.
      service.execute(() -> {
        try {
          FileUtils.copyURLToFile(new URL("https://" + SITES[N]),
              new File("out/" + SITES[N]));
          System.out.format("%s : %d ms\n", SITES[N],
              System.currentTimeMillis() - start);
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
    }
    service.shutdown(); // 모든 스레드의 작업을 종료하면 shutdown.
  }
}
