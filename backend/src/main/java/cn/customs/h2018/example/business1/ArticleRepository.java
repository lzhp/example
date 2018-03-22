package cn.customs.h2018.example.business1;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {

  Optional<Article> findById(Long id);
  
  Iterable<Article> findByAuthorAndTitle(String author, String title);

}
