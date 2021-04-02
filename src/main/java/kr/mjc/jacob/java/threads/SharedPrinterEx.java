package kr.mjc.jacob.java.threads;

public class SharedPrinterEx {
  public static void main(String[] args) {
    Printer printer = new Printer();

    // 프린터를 사용하는 스레드들
    new Thread(() -> printer.println("ABCDE")).start();

    new Thread(() -> printer.println("abcde")).start();
  }
}
