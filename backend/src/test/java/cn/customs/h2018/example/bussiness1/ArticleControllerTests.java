package cn.customs.h2018.example.bussiness1;

import java.time.LocalDateTime;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import cn.customs.h2018.example.business1.Article;
import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class ArticleControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper mapper;

  @Test
  public void exampleTestGreeting() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/article/greeting").accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content()
            .string(Matchers.equalTo("Greetings from Spring Boot!")));
  }

  @Test
  public void articleAdd() throws Exception {

    Article temp = new Article();
    temp.setBody("test body");
    temp.setTitle("test title");
    temp.setPublishDate(LocalDateTime.now());

    String json = mapper.writeValueAsString(temp);

    ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("/article")
        .contentType(MediaType.APPLICATION_JSON).content(json));
    action.andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(temp.getTitle()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.publishDate")
            .value(temp.getPublishDate().toString()));
  }

  @Test
  public void articleGet() throws Exception {

    ResultActions action = mockMvc
        .perform(MockMvcRequestBuilders.get("/article/1").contentType(MediaType.APPLICATION_JSON));
    action.andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
  }

  @Test
  public void articleGetAll() throws Exception {

    MvcResult result = mockMvc
        .perform(
            MockMvcRequestBuilders.get("/article/articles").contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value(1))
        .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

    String response = result.getResponse().getContentAsString();

    log.info(response);

  }

}
