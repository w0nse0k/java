package kr.mjc.jacob.spring.midterm;

import kr.mjc.jacob.java.jdbc.article.Article;
import kr.mjc.jacob.java.jdbc.article.ArticleDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@Slf4j
public class ListArticleEx {
  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);
    ArticleDao articleDao = context.getBean(ArticleDao.class);
    List<Article> articleList = articleDao.listArticles(0, 100);
    for (Article article : articleList) {
      log.debug(article.toString());
    }
  }
}
