package kr.mjc.jacob.java.threads;

public class SharedRestRoomEx {
  public static void main(String[] args) {
    RestRoom restRoom = new RestRoom();

    // Runnable task
    Runnable r = () -> restRoom.use();

    // task를 수행하는 스레드 3개
    new Thread(r).start();
    new Thread(r).start();
    new Thread(r).start();
  }
}
