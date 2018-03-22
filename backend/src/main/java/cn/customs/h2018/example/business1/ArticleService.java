package cn.customs.h2018.example.business1;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.base.Preconditions;

@Service
@Transactional
public class ArticleService {

  @Autowired
  private ArticleRepository repo;

  public Iterable<Article> getAllArticles() {
    return repo.findAll();
  }

  public Article getArticleById(Long articleId) {
    Optional<Article> temp = repo.findById(articleId);
    return temp.isPresent() ? temp.get() : null;
  }


  /**
   * 发表文章
   * @Title: postArticle   .
   * @Description: 如果文章存在，则更新文章，如果文章不存在，则插入文章   
   *  
   * Date: 2018-03-18 01:18:09 
   * @author lizhipeng 
   *
   * @param article
   * @return
   */
  public Article postArticle(Article article) {
    Preconditions.checkNotNull(article);
    return repo.save(article);
  }

  /**
   * @Title: deleteArticle .
   * @Description: 根据id删除一个文章
   * 
   *               Date: 2018-03-18 01:05:41
   * @author lizhipeng
   *
   * @param articleId
   */
  public void deleteArticle(Long articleId) {
    Preconditions.checkNotNull(articleId);
    if (repo.existsById(articleId)) {
      repo.deleteById(articleId);
    }
  }
}
