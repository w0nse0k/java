package kr.mjc.jacob.java.jdbc.user;

import kr.mjc.jacob.java.jdbc.DataAccessException;

public class UpdateEmailEx {
  public static void main(String[] args) {
    UserDao userDao = new UserDaoImplUsingDbUtils();
    try {
      int updatedRows = userDao.updateEmail(2, "iu@daum.net");

      if (updatedRows > 0)
        System.out.println("이메일을 업데이트 했습니다.");
      else
        System.out.println("사용자가 없습니다.");
    } catch (DataAccessException e) {
      System.err.println(e.getMessage());
    }
  }
}
