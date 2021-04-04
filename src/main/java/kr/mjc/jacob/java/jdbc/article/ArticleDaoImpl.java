package kr.mjc.jacob.java.jdbc.article;

import kr.mjc.jacob.java.jdbc.DbUtils;
import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class ArticleDaoImpl implements ArticleDao {

  private static final String LIST_ARTICLES =
      "select articleId, title, userId, name, left(cdate,16) cdate " +
          "from article order by articleId desc limit ?,?";

  private static final String GET_ARTICLE =
      "select articleId, title, content, userId, name, " +
          "left(cdate,16) cdate, left(udate,16) udate " +
          "from article where articleId=?";

  private static final String ADD_ARTICLE
      = "insert article(title, content, userId, name) values(?,?,?,?)";

  private static final String UPDATE_ARTICLE =
      "update article set title=?, content=? " +
          "where articleId=? and userId=?";

  private static final String DELETE_ARTICLE
      = "delete from article where articleId=? and userId=?";

  private DbUtils dbUtils;

  public ArticleDaoImpl() {
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
  public List<Article> listArticles(int offset, int count) {
    return dbUtils.list(LIST_ARTICLES, rs -> {
      Article article = new Article();
      article.setArticleId(rs.getInt("articleId"));
      article.setTitle(rs.getString("title"));
      article.setUserId(rs.getInt("userId"));
      article.setName(rs.getString("name"));
      article.setCdate(rs.getString("cdate"));
      return article;
    }, offset, count);
  }

  @Override
  public Article getArticle(int articleId) {
    return dbUtils.get(GET_ARTICLE, rs -> {
      Article article = new Article();
      article.setArticleId(rs.getInt("articleId"));
      article.setTitle(rs.getString("title"));
      article.setTitle(rs.getString("content"));
      article.setUserId(rs.getInt("userId"));
      article.setName(rs.getString("name"));
      article.setCdate(rs.getString("cdate"));
      article.setCdate(rs.getString("udate"));
      return article;
    }, articleId);
  }

  @Override
  public void addArticle(Article article) {
    dbUtils.update(ADD_ARTICLE, article.getTitle(), article.getContent(),
        article.getUserId(), article.getName());
  }

  @Override
  public int updateArticle(Article article) {
    return dbUtils
        .update(UPDATE_ARTICLE, article.getTitle(), article.getContent(),
            article.getArticleId(), article.getUserId());
  }

  @Override
  public int deleteArticle(int articleId, int userId) {
    return dbUtils.update(DELETE_ARTICLE, articleId, userId);
  }
}
