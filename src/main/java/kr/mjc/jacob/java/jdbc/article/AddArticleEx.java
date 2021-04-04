package kr.mjc.jacob.java.jdbc.article;

public class AddArticleEx {
  public static void main(String[] args) {
    ArticleDao articleDao = new ArticleDaoImpl();
    Article article = new Article();
    article.setTitle("내곡동 식당주인 \"오세훈, 2005년 6월에 와 생태탕 먹어\"");
    article.setContent(
        "안OO 식당 주인 A씨는 2일 오전 tbs 라디오 '김어준의 뉴스공장'에 출연해 '경작인 김씨는 2005년 6월 측량이 있었던 날 오 후보 장인, 그리고 오 후보와 함께 안OO 식당에서 생태탕을 먹었다고 주장하는데 기억하나'란 질문에 \"네. 오셨다. 기억한다\"라고 확인했다.");
    article.setUserId(2);
    article.setName("아이유");
    articleDao.addArticle(article);
    System.out.println("글을 추가했습니다.");
  }
}
