package kr.mjc.jacob.java.collections.homework;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 과제 1. p.436 연습문제 5. (1)
 */
public class ListOfStudentEx {

  List<Student> studentList = new ArrayList<>();

  public static void main(String[] args) {
    ListOfStudentEx ex = new ListOfStudentEx();
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
        studentList.add(student);
      }
    }

    for (Student student : studentList)
      System.out.println(student);
  }

  public void search() {
    try (Scanner sc = new Scanner(System.in)) {
      System.out.print("\n학번을 입력하세요 : ");
      String id = sc.next();  // 학번을 입력받음.
      for (Student student : studentList) {
        if (student.getId().equals(id)) {
          System.out.println(student);
          break;
        }
      }
    }
  }
}
