package kr.mjc.jacob.java.jdbc.article;

import java.util.List;

public interface ArticleDao {

  /**
   * 글 목록
   */
  List<Article> listArticles(int offset, int count);

  /**
   * 글 보기
   */
  default Article getArticle(int articleId) {
    return null;
  }

  /**
   * 글 쓰기
   */
  void addArticle(Article article);

  /**
   * 글 수정
   */
  default int updateArticle(Article article) {
    return 0;
  }

  /**
   * 글 삭제
   */
  default int deleteArticle(int articleId, int userId) {
    return 0;
  }
}
