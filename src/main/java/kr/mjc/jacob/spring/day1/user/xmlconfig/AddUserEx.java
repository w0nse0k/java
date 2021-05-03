package kr.mjc.jacob.spring.day1.user.xmlconfig;

import kr.mjc.jacob.java.jdbc.DataAccessException;
import kr.mjc.jacob.java.jdbc.user.User;
import kr.mjc.jacob.java.jdbc.user.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddUserEx {
  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("applicationContext-user.xml");
    UserDao userDao = context.getBean("userDao", UserDao.class);

    User user = new User();
    user.setEmail("david@daum.net");
    user.setName("David");
    user.setPassword("x");

    try {
      userDao.addUser(user);
      System.out.println("user를 추가했습니다.");
    } catch (DataAccessException e) {
      e.printStackTrace();
    }
  }
}
