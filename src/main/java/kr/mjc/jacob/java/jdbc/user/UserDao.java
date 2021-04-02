package kr.mjc.jacob.java.jdbc.user;

import java.util.List;

public interface UserDao {

  /**
   * 사용자 목록
   *
   * @param offset 시작 위치
   * @param count  갯수
   */
  List<User> listUsers(int offset, int count);

  /**
   * 회원 가입
   */
  void addUser(User user);

  /**
   * 로그인
   */
  User login(String email, String password);

  /**
   * 개인 정보 조회
   */
  User getUser(int userId);

  /**
   * 이메일 수정
   */
  int updateEmail(int userId, String email);

  /**
   * 비밀번호 수정
   */
  int updatePassword(int userId, String oldPassword, String newPassword);
}
