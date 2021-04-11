package kr.mjc.jacob.spring.day2.class06;

import kr.mjc.jacob.java.jdbc.user.User;
import kr.mjc.jacob.java.jdbc.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * jdbcTemplate과 namedParameterJdbcTemplate을 모두 사용하는 DAO
 */
@Component("userDaoImpl")
public class UserDaoImpl implements UserDao {

  private static final String LIST_USERS
      = "select userId, email, name from user order by userId desc limit ?,?";

  private static final String ADD_USER
      = "insert user(email, password, name) values(:email, sha2(:password,256), :name)";

  private static final String LOGIN
      = "select userId, email, name from user where (email, password) = (?, sha2(?,256))";

  private static final String GET_USER
      = "select userId, email, name from user where userId=?";

  private static final String UPDATE_EMAIL
      = "update user set email=:email where userId=:userId";

  private static final String UPDATE_PASSWORD
      = "update user set password=sha2(:newPassword,256) where userId=:userId and password=sha2(:password,256)";

  private JdbcTemplate jdbcTemplate;

  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  private RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);

  @Autowired
  public UserDaoImpl(JdbcTemplate jdbcTemplate,
                     NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  }

  @Override
  public List<User> listUsers(int offset, int count) {
    return jdbcTemplate.query(LIST_USERS, rowMapper, offset, count);
  }

  @Override
  public User login(String email, String password) {
    return jdbcTemplate.queryForObject(LOGIN, rowMapper, email, password);
  }

  @Override
  public User getUser(int userId) {
    return jdbcTemplate.queryForObject(GET_USER, rowMapper, userId);
  }

  @Override
  public void addUser(User user) {
    namedParameterJdbcTemplate
        .update(ADD_USER, new BeanPropertySqlParameterSource(user));
  }

  @Override
  public int updateEmail(int userId, String email) {
    Map<String, Object> params = new HashMap<>();
    params.put("userId", userId);
    params.put("email", email);
    return namedParameterJdbcTemplate.update(UPDATE_EMAIL, params);
  }

  @Override
  public int updatePassword(int userId, String password, String newPassword) {
    Map<String, Object> params = new HashMap<>();
    params.put("userId", userId);
    params.put("password", password);
    params.put("newPassword", newPassword);
    return namedParameterJdbcTemplate.update(UPDATE_PASSWORD, params);
  }
}
