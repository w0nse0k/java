package kr.mjc.jacob.java.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbUtils {

  private DataSource dataSource;

  /**
   * 데이터베이스 쿼리를 실행하는 helper 클래스
   */
  public DbUtils(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  /**
   * 추가, 수정, 삭제를 실행하는 helper 메서드
   */
  public int update(String sql, Object... params) throws DataAccessException {
    try (Connection con = dataSource.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
      setParams(ps, params);
      return ps.executeUpdate();
    } catch (SQLException e) {
      throw new DataAccessException(e);
    }
  }

  /**
   * 목록 가져오기를 실행하는 helper 메서드
   */
  public <T> List<T> list(String sql, ResultSetHandler<T> h, Object... params)
      throws DataAccessException {
    try (Connection con = dataSource.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
      setParams(ps, params);
      ResultSet rs = ps.executeQuery();
      List<T> list = new ArrayList<>();
      while (rs.next()) {
        list.add(h.handle(rs));
      }
      return list;
    } catch (SQLException e) {
      throw new DataAccessException(e);
    }
  }

  /**
   * 한건 가져오기를 실행하는 helper 메서드
   */
  public <T> T get(String sql, ResultSetHandler<T> h, Object... params)
      throws DataAccessException {
    try (Connection con = dataSource.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
      setParams(ps, params);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        return h.handle(rs);
      }
      return null;
    } catch (SQLException e) {
      throw new DataAccessException(e);
    }
  }

  /**
   * preparedStatement에 parameters를 넣는다.
   */
  private void setParams(PreparedStatement ps, Object... params)
      throws SQLException {
    if (params != null) {
      for (int i = 0; i < params.length; i++) {
        ps.setObject(i + 1, params[i]);
      }
    }
  }
}
