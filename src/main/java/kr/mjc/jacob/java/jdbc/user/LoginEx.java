package kr.mjc.jacob.java.jdbc.user;

public class LoginEx {
  public static void main(String[] args) {
    UserDao userDao = new UserDaoImplUsingDbUtils();
    User user = userDao.login("byung@daum.net", "b");
    if (user != null) {
      System.out.format("%s님 로그인 했습니다.\n", user.getName());
    } else {
      System.out.println("이메일이나 비밀번호가 틀립니다.");
    }
  }
}
