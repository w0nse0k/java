package kr.mjc.jacob.java.lambdaexpression;

public class Person {
  String name;
  int birthyear;
  String email;

  public Person(String name, int birthyear, String email) {
    this.name = name;
    this.birthyear = birthyear;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public int getBirthyear() {
    return birthyear;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "Person{" + "name='" + name + '\'' + ", birthday=" + birthyear +
        ", email='" + email + '\'' + '}';
  }
}
