package kr.mjc.jacob.java.threads;

/**
 * p.699 예제 코드를 lambda expression 을 사용하는 것으로 수정
 */
public class TestRunnableUsingLambdaExpression {
  public static void main(String[] args) {
    new Thread(() -> {
      for (int i = 0; i < 4; i++) {
        System.out.println(i);
        try {
          Thread.sleep(1000);  // 1000ms(1초) 동안 휴식
        } catch (InterruptedException e) {
        }
      }
    }).start();
  }
}
