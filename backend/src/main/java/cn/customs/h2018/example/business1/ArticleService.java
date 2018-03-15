package cn.customs.h2018.example.business1;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    if (temp.isPresent()) {
      return temp.get();
    } else {
      return null;
    }
  }

  public boolean addArticle(Article article) {
    repo.save(article);
    return true;
  }

  public void updateArticle(Article article) {
    repo.save(article);
  }

  public void deleteArticle(Long articleId) {
    repo.deleteById(articleId); 
  }
}
