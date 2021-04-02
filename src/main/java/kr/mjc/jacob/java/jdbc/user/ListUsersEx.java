package kr.mjc.jacob.java.jdbc.user;

import java.util.List;

public class ListUsersEx {
  public static void main(String[] args) {
    UserDao userDao = new UserDaoImplUsingDbUtils();
    List<User> userList = userDao.listUsers(0, 10);
    for (User user : userList) {
      System.out.println(user);
    }
  }
}
