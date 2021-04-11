package kr.mjc.jacob.java.collections.homework;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 과제 1. p.436 연습문제 5. (2)
 */
public class MapOfStudentEx {

  Map<String, Student> studentMap = new HashMap<>();

  public static void main(String[] args) {
    MapOfStudentEx ex = new MapOfStudentEx();
    try {
      ex.read();
      ex.search();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void read() throws Exception {
    try (
        Scanner sc = new Scanner(new File("src/main/resources/students.txt"))) {

      while (sc.hasNextLine()) {
        Student student = new Student(sc.nextLine());
        studentMap.put(student.getId(), student);
      }
    }

    for (Map.Entry<String, Student> entry : studentMap.entrySet())
      System.out.println(entry.getValue());

  }

  public void search() {
    try (Scanner sc = new Scanner(System.in)) {
      System.out.print("\n학번을 입력하세요 : ");
      String id = sc.next(); // 학번을 입력받는다.
      Student student = studentMap.get(id); // 키로 검색
      System.out.println(student);
    }
  }
}
