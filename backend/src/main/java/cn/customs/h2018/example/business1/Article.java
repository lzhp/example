package cn.customs.h2018.example.business1;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "Article")
@Data
@ToString
public class Article {
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="ID")
  private Long id;

  @Column(name="TITLE")  
  private String title;
  
  @Column(name="BODY")  
  private String body;

  @Column(name="AUTHOR")
  private String author;
  
  @Column(name="PUBLISH_DATE")  
  private Date publishDate;
  
  @Column(name="SIZE")  
  private Long size;  

  public Article() {}

  public Article(Long id, String title, String body) {
    this.id = id;
    this.title = title;
    this.body = body;
  }
  
  public Article(Long id, String title, String body, String author, Date publishDate) {
    this.id = id;
    this.title = title;
    this.body = body;
    this.author = author;
    this.publishDate = publishDate;
  }  
}
