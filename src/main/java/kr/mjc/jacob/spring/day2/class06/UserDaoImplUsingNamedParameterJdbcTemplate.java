package kr.mjc.jacob.spring.day2.class06;

import kr.mjc.jacob.java.jdbc.user.User;
import kr.mjc.jacob.java.jdbc.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("userDaoNamed")
public class UserDaoImplUsingNamedParameterJdbcTemplate implements UserDao {

  private static final String LIST_USERS =
      "select userId, email, name from user order by userId desc limit :offset,:count";

  private static final String ADD_USER =
      "insert user(email, password, name) values(:email, sha2(:password,256), :name)";

  private static final String LOGIN =
      "select userId, email, name from user where (email, password) = (:email, sha2(:password,256))";

  private static final String GET_USER =
      "select userId, email, name from user where userId=:userId";

  private static final String UPDATE_EMAIL =
      "update user set email=:email where userId=:userId";

  private static final String UPDATE_PASSWORD =
      "update user set password=sha2(:newPassword,256) where userId=:userId and password=sha2(:password,256)";

  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Autowired
  public UserDaoImplUsingNamedParameterJdbcTemplate(
      NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  }

  private RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);

  @Override
  public List<User> listUsers(int offset, int count) {
    // 파마미터로 Map을 사용
    Map<String, Object> params = new HashMap<>();
    params.put("offset", offset);
    params.put("count", count);
    return namedParameterJdbcTemplate.query(LIST_USERS, params, rowMapper);
  }

  @Override
  public User login(String email, String password) {
    Map<String, Object> params = new HashMap<>();
    params.put("email", email);
    params.put("password", password);
    return namedParameterJdbcTemplate.queryForObject(LOGIN, params, rowMapper);
  }

  @Override
  public User getUser(int userId) {
    // 파라미터로 MapSqlParameterSource를 사용
    SqlParameterSource params = new MapSqlParameterSource("userId", userId);
    return namedParameterJdbcTemplate
        .queryForObject(GET_USER, params, rowMapper);
  }

  @Override
  public void addUser(User user) {
    // 파라미터로 BeanPropertySqlParameterSource를 사용
    SqlParameterSource params = new BeanPropertySqlParameterSource(user);
    namedParameterJdbcTemplate.update(ADD_USER, params);
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
    params.put("newPassword", newPassword);
    params.put("userId", userId);
    params.put("password", newPassword);
    return namedParameterJdbcTemplate.update(UPDATE_PASSWORD, params);
  }
}
