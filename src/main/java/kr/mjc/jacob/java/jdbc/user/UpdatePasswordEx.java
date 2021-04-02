package kr.mjc.jacob.java.jdbc.user;

public class UpdatePasswordEx {
  public static void main(String[] args) {
    UserDao userDao = new UserDaoImplUsingDbUtils();
    int updatedRows = userDao.updatePassword(3, "1", "xxxx");

    if (updatedRows > 0)
      System.out.println("비밀번호를 업데이트 했습니다.");
    else
      System.out.println("사용자가 없거나 비밀번호가 틀립니다.");
  }
}
