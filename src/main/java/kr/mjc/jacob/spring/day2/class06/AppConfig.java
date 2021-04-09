package kr.mjc.jacob.spring.day2.class06;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "kr.mjc.jacob.spring.day2.class06")
@PropertySource("classpath:db.properties")
public class AppConfig {

  @Bean
  public DataSource dataSource(@Value("${db.url}") String dbUrl) {
    return new MariaDbDataSource(dbUrl);
  }

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  @Bean
  public NamedParameterJdbcTemplate namedParameterJdbcTemplate(
      DataSource dataSource) {
    return new NamedParameterJdbcTemplate(dataSource);
  }
}
