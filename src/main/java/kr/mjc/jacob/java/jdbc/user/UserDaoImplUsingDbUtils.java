package kr.mjc.jacob.java.jdbc.user;

import kr.mjc.jacob.java.jdbc.DbUtils;
import kr.mjc.jacob.java.jdbc.ResultSetHandler;
import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class UserDaoImplUsingDbUtils implements UserDao {

  private static final String LIST_USERS
      = "select userId, email, name from user order by userId desc limit ?,?";

  private static final String ADD_USER
      = "insert user(email, password, name) values(?, sha2(?,256), ?)";

  private static final String LOGIN
      = "select userId, email, name from user where (email, password) = (?, sha2(?,256))";

  private static final String GET_USER
      = "select userId, email, name from user where userId=?";

  private static final String UPDATE_EMAIL
      = "update user set email=? where userId=?";

  private static final String UPDATE_PASSWORD
      = "update user set password=sha2(?,256) where userId=? and password=sha2(?,256)";
  ResultSetHandler<User> h = (rs) -> {
    User user = new User();
    user.setUserId(rs.getInt("userId"));
    user.setEmail(rs.getString("email"));
    user.setName(rs.getString("name"));
    return user;
  };
  private DbUtils dbUtils;

  public UserDaoImplUsingDbUtils() {
    Properties props = new Properties();
    try (InputStream in = getClass().getClassLoader()
        .getResourceAsStream("db.properties")) { // 클래스패스에서 읽음
      props.load(in);
      DataSource dataSource = new MariaDbDataSource(
          props.getProperty("db.url"));
      dbUtils = new DbUtils(dataSource);
    } catch (IOException e) {
      e.printStackTrace();
    }
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
