package kr.mjc.jacob.java.collections.homework;

public class Student {
  String id;  // 학번
  String name;  //이름
  String major; // 전공 (학과)
  double score;   // 학점

  public Student(String str) {
    String[] token = str.split("\t"); // 탭으로 분리
    id = token[0];
    name = token[1];
    major = token[2];
    score = Double.parseDouble(token[3]);
  }

  public String getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Student{" + "id='" + id + '\'' + ", name='" + name + '\'' +
        ", major='" + major + '\'' + ", score=" + score + '}';
  }
}
