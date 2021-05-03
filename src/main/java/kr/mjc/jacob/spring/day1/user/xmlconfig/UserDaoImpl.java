package kr.mjc.jacob.spring.day1.user.xmlconfig;

import kr.mjc.jacob.java.jdbc.DbUtils;
import kr.mjc.jacob.java.jdbc.ResultSetHandler;
import kr.mjc.jacob.java.jdbc.user.User;
import kr.mjc.jacob.java.jdbc.user.UserDao;

import java.util.List;

public class UserDaoImpl implements UserDao {

  private static final String LIST_USERS =
      "select userId, email, name from user order by userId desc limit ?,?";

  private static final String ADD_USER =
      "insert user(email, password, name) values(?, sha2(?,256), ?)";

  private static final String LOGIN =
      "select userId, email, name from user where (email, password) = (?, sha2(?,256))";

  private static final String GET_USER =
      "select userId, email, name from user where userId=?";

  private static final String UPDATE_EMAIL =
      "update user set email=? where userId=?";

  private static final String UPDATE_PASSWORD =
      "update user set password=sha2(?,256) where userId=? and password=sha2(?,256)";

  private DbUtils dbUtils;
  private ResultSetHandler<User> h = (rs) -> {
    User user = new User();
    user.setUserId(rs.getInt("userId"));
    user.setEmail(rs.getString("email"));
    user.setName(rs.getString("name"));
    return user;
  };

  public UserDaoImpl(DbUtils dbUtils) {
    this.dbUtils = dbUtils;
  }

  @Override
  public List<User> listUsers(int offset, int count) {
    return dbUtils.list(LIST_USERS, h, offset, count);
  }

  @Override
  public User login(String email, String password) {
    return dbUtils.get(LOGIN, h, email, password);
  }

  @Override
  public User getUser(int userId) {
    return dbUtils.get(GET_USER, h, userId);
  }

  @Override
  public void addUser(User user) {
    dbUtils
        .update(ADD_USER, user.getEmail(), user.getPassword(), user.getName());
  }

  @Override
  public int updateEmail(int userId, String email) {
    return dbUtils.update(UPDATE_EMAIL, email, userId);
  }

  @Override
  public int updatePassword(int userId, String password, String newPassword) {
    return dbUtils.update(UPDATE_PASSWORD, newPassword, userId, password);
  }
}
