package kr.mjc.jacob.java.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MethodCallStack {
  public void go() {
    try (FileReader in = new FileReader("src/main/resources/alphabet.txt");
         BufferedReader reader = new BufferedReader(in)) {
      String str = reader.readLine();
      System.out.println(str);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void come() {
    go();
  }

  public static void main(String[] args) {
    new MethodCallStack().come();
  }
}
