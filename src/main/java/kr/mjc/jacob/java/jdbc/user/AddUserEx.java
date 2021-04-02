package kr.mjc.jacob.java.jdbc.user;

import kr.mjc.jacob.java.jdbc.DataAccessException;

public class AddUserEx {
  public static void main(String[] args) {
    UserDao userDao = new UserDaoImplUsingDbUtils();
    User user = new User();
    user.setEmail("byung@daum.net");
    user.setPassword("b");
    user.setName("이병헌");
    try {
      userDao.addUser(user);
      System.out.format("사용자를 추가했습니다 : %s\n", user);
    } catch (DataAccessException e) {
      System.err.println(e.getMessage());
    }
  }
}
