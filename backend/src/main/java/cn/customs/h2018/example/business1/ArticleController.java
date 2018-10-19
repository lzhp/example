package cn.customs.h2018.example.business1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*", allowCredentials = "true", maxAge = 4800)
@RestController
@RequestMapping("/article")
@Slf4j
public class ArticleController {

  @Autowired
  private ArticleService articleService;

  /**
   * 
   */
  @RequestMapping("/t")
  public Object getData2() {
    log.info("my test");

    return initData();

  }

  private List<Article> initData() {
    List<Article> result = Lists.newArrayList();

    result.add(Article.builder().id(1L).title("1 tkjljl").body("body t wrwr atest safd").build());
    result.add(Article.builder().id(1L).title("2 tkjljl").body("body wfrwr atest safd").build());
    result.add(Article.builder().id(1L).title("3 tkjljl").body("body wrswr atest safd").build());
    result.add(Article.builder().id(1L).title("4 tkjljl").body("body wrwer atest safd").build());
    return result;
  }

  @RequestMapping("/t1")
  public Object getData3() {

    return initData();
  }

  @RequestMapping("/t2")
  public Object getData4() {

    return initData();
  }

  @RequestMapping("/greeting")
  public String greeting() {
    log.info("my test");
    return "Greetings from Spring Boot!";
  }

  @GetMapping("/{id}")
  public ResponseEntity<Article> getArticleById(@PathVariable("id") Long id) {
    Article article = articleService.getArticleById(id);
    log.debug(article.toString());
    return new ResponseEntity<>(article, HttpStatus.OK);
  }

  @GetMapping("/articles")
  public ResponseEntity<Iterable<Article>> getAllArticles() {
    Iterable<Article> list = articleService.getAllArticles();
    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<Article> postArticle(@RequestBody Article article, UriComponentsBuilder builder) {

    log.debug("in add article");
    Article result = articleService.postArticle(article);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
    articleService.deleteArticle(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
