package cn.customs.h2018.example.business1;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Article")
@Data
@Builder
@AllArgsConstructor    //need for builder
@NoArgsConstructor     //need for jpa
public class Article implements Serializable {

  private static final long serialVersionUID = -4652551192069887737L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Long id;

  @Column(name = "TITLE")
  private String title;

  @Column(name = "BODY")
  private String body;

  @Column(name = "AUTHOR")
  private String author;

  @Column(name = "PUBLISH_DATE")
  private LocalDateTime publishDate;

  @Column(name = "SIZE")
  private Long size;
  
  @Version
  @Column(name = "VERSION")
  private Long version;  

}
