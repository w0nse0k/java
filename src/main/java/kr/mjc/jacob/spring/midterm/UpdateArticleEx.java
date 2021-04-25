package kr.mjc.jacob.spring.midterm;

import kr.mjc.jacob.java.jdbc.article.Article;
import kr.mjc.jacob.java.jdbc.article.ArticleDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class UpdateArticleEx {
  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);
    ArticleDao articleDao = context.getBean(ArticleDao.class);

    Article article = new Article();
    article.setArticleId(1000);
    article.setTitle("이 타이틀을 수정합니다.");
    article.setContent("이 컨텐트를 수정합니다.");
    article.setUserId(348);

    int updatedRows = articleDao.updateArticle(article);
    if (updatedRows > 0)
      log.debug("업데이트 했습니다.");
    else
      log.debug("업데이트 실패");
  }
}
