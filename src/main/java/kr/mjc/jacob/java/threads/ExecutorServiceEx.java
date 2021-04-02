package kr.mjc.jacob.java.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 스레드 풀 예제
 */
public class ExecutorServiceEx {
  public static void main(String[] args) {
    RestRoom restRoom = new RestRoom();
    // 화장실을 사용하는 runnable task;
    Runnable r = () -> restRoom.use();

    // worker thread가 2개 있는 thread pool 생성
    ExecutorService service = Executors.newFixedThreadPool(2);

    // 2개의 worker thread가 4개의 스레드 실행
    service.execute(r);
    service.execute(r);
    service.execute(r);
    service.execute(r);

    // 진행 중인 태스크 종료 후에 서비스 종료
    // ExecutorService는 shutdown() 하지 않으면 끝나지 않는다.
    service.shutdown();
  }
}
