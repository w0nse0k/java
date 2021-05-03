package kr.mjc.jacob.spring.midterm;

import kr.mjc.jacob.java.jdbc.article.Article;
import kr.mjc.jacob.java.jdbc.article.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleDaoImpl implements ArticleDao {

  private static final String LIST_ARTICLES = """
      select articleId, title, userId, name, left(cdate,16) cdate
      from article order by articleId desc limit ?,?""";

  private static final String ADD_ARTICLE =
      "insert article(title, content, userId, name) values(:title, :content, :userId, :name)";

  private static final String GET_ARTICLE = """
      select articleId, title, content, userId, name, left(cdate,16) cdate, left(udate,16) udate
      from article where articleId=?""";

  private static final String UPDATE_ARTICLE = """
      update article set title=:title, content=:content
      where articleId=:articleId and userId=:userId""";

  private static final String DELETE_ARTICLE =
      "delete from article where articleId=? and userId=?";

  private JdbcTemplate jdbcTemplate;

  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  private RowMapper<Article> rowMapper =
      new BeanPropertyRowMapper<>(Article.class);

  @Autowired
  public ArticleDaoImpl(JdbcTemplate jdbcTemplate,
                        NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  }

  @Override
  public List<Article> listArticles(int offset, int count) {
    return jdbcTemplate.query(LIST_ARTICLES, rowMapper, offset, count);
  }

  @Override
  public Article getArticle(int articleId) {
    return jdbcTemplate.queryForObject(GET_ARTICLE, rowMapper, articleId);
  }

  @Override
  public void addArticle(Article article) {
    SqlParameterSource params = new BeanPropertySqlParameterSource(article);
    namedParameterJdbcTemplate.update(ADD_ARTICLE, params);
  }

  @Override
  public int updateArticle(Article article) {
    return namedParameterJdbcTemplate
        .update(UPDATE_ARTICLE, new BeanPropertySqlParameterSource(article));
  }

  @Override
  public int deleteArticle(int articleId, int userId) {
    return jdbcTemplate.update(DELETE_ARTICLE, articleId, userId);
  }
}

