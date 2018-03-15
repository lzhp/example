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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.google.common.collect.Lists;

@CrossOrigin(origins = "*", allowCredentials = "true", maxAge = 4800)
@RestController
@RequestMapping("/article")
public class ArticleController {


  @Autowired
  private ArticleService articleService;

  @RequestMapping("/")
  public Object getData() {

    Iterable<Article> result = articleService.getAllArticles();
    return result;
  }

  @RequestMapping("/t")
  public Object getData2() {

    List<Article> result = Lists.newArrayList();

    result.add(new Article(1L, "ttitle1", "bod3232221"));
    result.add(new Article(2L, "ttit3le2", "body23342222"));
    result.add(new Article(3L, "tti4tle3", "body2234223"));
    result.add(new Article(4L, "ttit3le4", "body2342224"));
    result.add(new Article(5L, "tt3itle5", "body2223425"));
    result.add(new Article(6L, "tti3tle6", "body224226"));

    return result;
  }

  @RequestMapping("/t1")
  public Object getData3() {

    List<Article> result = Lists.newArrayList();

    result.add(new Article(1L, "t1", "body2223421"));
    result.add(new Article(2L, "ttit4le2", "body2222"));
    result.add(new Article(3L, "ttit34le3", "body242223"));
    result.add(new Article(4L, "tti243tle4", "body224224"));
    result.add(new Article(5L, "tti4tle5", "body224225"));
    result.add(new Article(6L, "ttitl4e6", "body2223426"));

    return result;
  }

  @RequestMapping("/t2")
  public Object getData4() {

    List<Article> result = Lists.newArrayList();

    result.add(new Article(1L, "t2", "bod42y2221"));
    result.add(new Article(2L, "tti234tle2", "bod24y2222"));
    result.add(new Article(3L, "tti234tle3", "bod234y2223"));
    result.add(new Article(4L, "tti234tle4", "bod24y2224"));
    result.add(new Article(5L, "ttit234le5", "bod234y2225"));
    result.add(new Article(6L, "ttit234le6", "bod24y2226"));

    return result;
  }

  @RequestMapping("/greeting")
  public String greeting() {
    return "Greetings from Spring Boot!";
  }

  @GetMapping("article/{id}")
  public ResponseEntity<Article> getArticleById(@PathVariable("id") Long id) {
    Article article = articleService.getArticleById(id);
    return new ResponseEntity<>(article, HttpStatus.OK);
  }

  @GetMapping("articles")
  public ResponseEntity<Iterable<Article>> getAllArticles() {
    Iterable<Article> list = articleService.getAllArticles();
    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  @PostMapping("article")
  public ResponseEntity<Void> addArticle(@RequestBody Article article,
      UriComponentsBuilder builder) {
    boolean flag = articleService.addArticle(article);
    if (flag == false) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    return new ResponseEntity<>(HttpStatus.OK);

  }

  @PutMapping("article")
  public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
    articleService.updateArticle(article);
    return new ResponseEntity<>(article, HttpStatus.OK);
  }

  @DeleteMapping("article/{id}")
  public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
    articleService.deleteArticle(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
