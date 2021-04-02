package kr.mjc.jacob.java.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * p.424 예제 7-9 MyStack 수정<br>
 * Queue와 Deque를 구현한 ArrayDeque 테스트
 */
public class DequeEx {
  public static void main(String[] args) {

    // 1. Queue 테스트
    Queue<String> queue = new ArrayDeque<>(); // First In First Out
    queue.offer("Seoul");
    queue.offer("Busan");
    queue.offer("LA");
    System.out.println(queue); // [Seoul, Busan, LA]

    System.out.println(queue.poll()); // Seoul
    System.out.println(queue.poll()); // Busan
    System.out.println(queue); // [LA]

    // 2. Deque 테스트 1
    Deque<String> stack = new ArrayDeque<>(); // 양방향으로 넣고 뺄수 있음
    stack.offer("Seoul");
    stack.offer("Busan");
    stack.offer("LA");
    System.out.println(stack); // [Seoul, Busan, LA]

    System.out.println(stack.pollLast()); // LA
    System.out.println(stack.pollLast()); // Busan
    System.out.println(stack); // [Seoul]

    // 3. Deque 테스트 2
    Deque<String> deque = new ArrayDeque<>();
    deque.offer("Seoul"); // [Seoul]
    deque.offer("Busan"); // [Seoul, Busan]
    deque.offerFirst("LA"); // [LA, Seoul, Busan]
    System.out.println(deque);

    System.out.println(deque.poll()); // LA
    System.out.println(deque.pollLast()); // Busan
    System.out.println(deque);  // [Seoul]
  }
}
