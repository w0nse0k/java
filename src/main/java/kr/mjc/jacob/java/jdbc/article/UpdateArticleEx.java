package kr.mjc.jacob.java.jdbc.article;

public class UpdateArticleEx {
  public static void main(String[] args) {
    ArticleDao articleDao = new ArticleDaoImpl();
    Article article = new Article();
    article.setArticleId(52);
    article.setTitle("제목 수정");
    article.setContent("내용 수정");
    article.setUserId(2);
    if (articleDao.updateArticle(article) > 0) {
      System.out.println("글을 수정했습니다.");
    } else {
      System.out.println("글을 수정하지 못했습니다.");
    }
  }
}
