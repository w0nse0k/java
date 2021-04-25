package kr.mjc.jacob.spring.midterm;

import kr.mjc.jacob.java.jdbc.article.ArticleDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class DeleteArticleEx {
  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);
    ArticleDao articleDao = context.getBean(ArticleDao.class);

    int updatedRows = articleDao.deleteArticle(1000, 358);
    if (updatedRows > 0)
      log.debug("삭제했습니다.");
    else
      log.error("삭제 실패");
  }
}
