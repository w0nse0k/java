package kr.mjc.jacob.java.jdbc.user;

public class GetUserEx {
  public static void main(String[] args) {
    UserDao userDao = new UserDaoImplUsingDbUtils();
    User user = userDao.getUser(1);
    System.out.println(user);
  }
}
