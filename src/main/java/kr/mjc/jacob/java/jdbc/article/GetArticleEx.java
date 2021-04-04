package kr.mjc.jacob.java.jdbc.article;

public class GetArticleEx {
  public static void main(String[] args) {
    ArticleDao articleDao = new ArticleDaoImpl();
    Article article = articleDao.getArticle(4);
    System.out.println(article);
  }
}
