package kr.mjc.jacob.spring.midterm;

import kr.mjc.jacob.java.jdbc.article.Article;
import kr.mjc.jacob.java.jdbc.article.ArticleDao;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class AddArticleEx {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    ArticleDao articleDao = context.getBean(ArticleDao.class);

    Article article = new Article();
    article.setTitle("중간고사 제목입니다.");
    article.setContent("""
        내용은 목록을 출력합니다.
        다른 내용은 글을 저장합니다.""");
    article.setUserId(2);
    article.setName("아이유");
    articleDao.addArticle(article);

    log.debug("글을 저장했습니다. title={}", article.getTitle());
  }
}
