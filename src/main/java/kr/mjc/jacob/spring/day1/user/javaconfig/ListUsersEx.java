package kr.mjc.jacob.spring.day1.user.javaconfig;

import kr.mjc.jacob.java.jdbc.user.User;
import kr.mjc.jacob.java.jdbc.user.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ListUsersEx {
  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);

    UserDao userDao = context.getBean("userDao", UserDao.class);
    List<User> userList = userDao.listUsers(0, 10);
    for (User user : userList) {
      System.out.println(user);
    }
  }
}
