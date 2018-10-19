# 主要技术及工具

1. JDK 1.8+
2. maven 3.5 + springboot1.5.11 + mybatis + junit4 + sonarLint
3. google guava (依赖包)
4. 开发工具 Eclipse，lombok

# 环境安装说明
0. jdk 1.8.151 地址：\\file.rd.domain.com\software\develop\jdk-8u151-windows-x64.exe
1. eclipse、Spring Tools Suit, 研发网地址：[\\file.rd.domain.com\software\develop\IDE\](file:\\file.rd.domain.com\software\develop\IDE\)
2. 安装 `lombok` 插件(直接双击lombok.jar)，地址：\\file.rd.domain.com\software\develop\IDE\lombok.jar
3. 代码风格 `google java style`，文件eclipse-java-google-style.xml，开发工具安装google代码风格操作如下

   eclipse:  select Java/Code Style/Formatter. Import the settings file by selecting Import
  
   idea: Copy it into your config/codestyles folder in your IntelliJ settings folder. Under Settings -> Editor -> Code Style select the google-styleguide as current code style for the Metanome project.

4. maven，研发网maven仓库地址： [http://maven-repo.rd.domain.com:8081/nexus/](http://maven-repo.rd.domain.com:8081/nexus/)，或者直接拷贝` \\file.rd.domain.com\software\develop\conf\.m2\settings.xml`覆盖当前用户的settings.xml

5. 注释格式，codetemplate.xml，地址：[\\file.rd.domain.com\software\develop\conf](\\file.rd.domain.com\software\develop\conf)
6. git，参见附录
7. 本地注册中心，consul，地址：[\\file.rd.domain.com\software\develop\consul\consul.exe](\\file.rd.domain.com\software\develop\consul\consul.exe)，直接执行该目录下的startConsul.bat即可。
8. 示例工程代码地址:\\file.rd.domain.com\software\develop\example\sample20180422.zip


# 注意事项
1. 代码风格, google java style，统一进行格式化操作
2. 层次关系：controller->service->dao，**不允许** 逆向或跨层调用
3. 业务逻辑应在service层进行封装，对于写数据库等操作，应在service层 **启用事务**。

4. pojo内，通过注解的方式对参数进行约束，如@NotNull等
5. controller: 简单对参数校验，调用service层实现
5. service：进行业务逻辑处理，启用事务
6. dao：进行数据库操作


# 命名规范
##	命名方式
根据代码中标识类型的不同，主要使用下列几种命名方式：

1.	Pascal命名
标识的每个单词首字母大写；
示例：BackColor、EntryHead
2.	Camel命名
标识的首个单词首字母小写，其余的单词均首字母大写；
示例：backColor、entryHead
3.	Upper命名
标识的每个字母均大写；
示例：IO、ENTRYHEAD
4.	Lower命名
标识的每个字母均小写。
示例：io、entryhead

##	命名约定
1. 项目名，统一采用“项目缩写-子模块”方式命名，如“税管中心-风险处置”，项目名为“tmc-risk-disposition”，项目名同时也是spirng.application.name,需要配置到bootstrap.yml文件中
2. 包名,全部采用小写字母，命名规则如下：统一采用cn.gov.customs.h2018为整个项目的包名前缀，然后是项目缩写和子模块名缩写，如“税管中心-风险处置”的包名：“cn.gov.customs.h2018.tmc.trd”，以下依次是controller、service、pojo、dao等包。
2.	Class 的命名,Class 的名字采用Pascal方式命名，例如：DataFile或InfoParser。
3. 数据库表名及字段命名，采用全大写，用下划线分隔的方式命名，如“ENTRY_HEAD”"ENTRY_ID"等
4. Class 变量的命名，变量的名字采用Camel方式命名，如“userName”、“declPort”等
3.	方法的命名。方法的命名采用Camel方式，建议采用动宾结构词组，如checkEntry、rejectEms等。
5.	常量，Static Final 变量的命名。Static Final 变量的名字采用Upper方式命名，并且指出完整含义，例如：MAX_UPLOAD_FILE_SIZE=1024。
6.	参数的命名。参数的名字和变量的命名规范一致。
7.	数组的命名。数组应该总是用下面的方式来命名：
byte[] buffer;
而不是：
byte buffer[];
8.	接口与接口实现的命名。
接口命名与类命名一致，采用Pascal命名方式，接口的实现类采用接口名+Impl或其他有意义的类名称命名。如接口 `Bussiness`，实现 `BussinessImpl`。

# 前后端接口规范
1. url统一使用小写字母，多个单词之间采用中划线（-）进行分割，如"http://****.customs.gov.cn/parameter-service/dict/get-name?key=country&code=502"
2. 如果通过网关调用某服务时，url中域名之后的第一部分为服务名，如1中，"parameter-service"为微服务名。
2. 前后端调用时，暂只使用post和get两种请求方法
  - GET：从服务器取出资源（一项或多项）。如：GET "http://****.customs.gov.cn/parameter-service/dict/country" 获取国别代码表
  - POST：更新服务器端资源或执行需要更新数据的操作。
2. 后端正常返回情况下，`http_status_code`为200，出错的情况下，返回值不为200，根据情况，返回401（无权限）、500等错误。
3. 有如下数据，结构如下

```
@Data
public class Country {
  
  private String code;
  private String name;
  
  private Long version;
  private LocalDateTime createdTime;
  private LocalDateTime lastUpdateTime;  
}
```

单条数据的返回值：

```
{
    "code": "110",
    "name": "日本",
    "version": null,
    "createdTime": null,
    "lastUpdateTime": null
}
```

分页的返回值, *注意排序的返回方式*

```
{
    "content": [
        {
            "code": "110",
            "name": "日本",
            "version": null,
            "createdTime": null,
            "lastUpdateTime": null
        }
    ],
    "totalPages": 1,
    "totalElements": 1,
    "last": true,
    "number": 0,
    "size": 20,
    "sort": [
        {
            "direction": "ASC",
            "property": "code",
            "ignoreCase": false,
            "nullHandling": "NATIVE",
            "ascending": true,
            "descending": false
        },
        {
            "direction": "DESC",
            "property": "name",
            "ignoreCase": false,
            "nullHandling": "NATIVE",
            "ascending": false,
            "descending": true
        }
    ],
    "first": true,
    "numberOfElements": 1
}
```

# 注意事项
2. 日期类型，使用`java8`的`LocalDate LocalDateTime`等进行定义，不允许使用`java.util.Date`类
3. 公共函数，首选JDK自带，在JDK不能满足要求的情况下，首选google guava库里的各种函数，最后才考虑自行封装公共函数
4. log统一使用`Slf4j`，在使用lombok的情况下，在类的前面加`@Slf4j`注解，然后在类的函数里直接使用如下方式记录日志。目前只记录如下4种，具体使用场景见描述。底层log实现使用spring boot默认的log back，在资源目录下增加`src/main/resources/logback-spring.xml`配置文件即可。
5. 不允许随意引入第三方库

```
	log.trace(……);  // 在需要时打开，可以用于细粒度的定位项目中问题的位置
	log.debug(……);  // 在需要时打开，可以定位应用系统出现问题的位置
	log.info(……);   // 一般信息，一般记录项目活动状态，不能每个请求都记录info日志
	log.error(……);  // 错误信息，一般性错误，记得记录错误堆栈
	log.fatal(……);  // 异常情况，系统出现此错误情况下可能已经无法正常工作
```

5. 错误处理：	
 
   - 在异常时，应在原始异常的基础上，附加异常的现场信息，如关键单证编号、传入的上下文及参数等等关键信息，以便后续生产环境快速定位问题原因。
   - 在底层只处理自己应该处理的错误，对于已知的业务异常情况，应该抛出自定义的业务异常，自定义异常应包含错误号、关键业务单证号、简单错误描述等信息。由于其他异常引发的异常，在补充错误号、关键业务单证号、简单错误描述等信息的基础上，将底层的异常包装后再次抛出。底层异常不记录log日志（否则会重复记录log）。
   - 在DAO层，产生的异常类型有很多，如无法用细粒度异常进行catch，可使用catch(Exception e)方式，并throw new DaoException(e)，不需要打印日志，因为错误在Service层一定需要捕获并打到日志文件中去，因此底层不需要重复，只将异常包装后抛出即可。
   - Service层应处理各种异常情况，保证业务调用方能得到足够的异常信息，同时，在Service层应记录详细log信息，在系统上线后能通过service层的log信息排查错误。
   -  Controller因为已经处于顶层，无继续处理异常，因此由框架提供统一的异常处理机制，因此一般情况下不需要处理异常。
   - 没有权限的异常统一返回 NoPermissionExcepition，并通过message说明具体需要的权限id  
   
```
   {
    "exception": {
        "code": "CONTRY_ERROR_CODE_001",
        "bussinessId": "testid",
        "message": "some error",
        "detail": "top.h2000.utils.Custo……" （数据量太大，视情况提供）
        }
   }
```

8. 数据库设计，每个表在业务字段之外，增加如下三个字段

```
  @Version
  @Column(name="VERSION")
  private Long version;  //数据版本号，每次数据更新时，version=version+1
  
  //
  @Column(name = "CREATE_TIME", updatable=false)
  @CreationTimestamp
  private LocalDateTime createdTime;  // 数据的创建时间，在第一次insert时取系统时间，后续不再更新

  @Column(name = "LAST_UPDATE_TIME")
  @UpdateTimestamp
  private LocalDateTime lastUpdateTime;  //每次更新时取系统时间
```

6. 缓存：（todo）
7. 权限：（todo）

# 工作步骤
1. 从git上拣出代码
3. 将项目导入到开发工具中，可以工作了

# 项目目录结构

方式一：
```
root
|   .gitignore
|   alaudaci.yml
|   Dockerfile
|   pom.xml
+---src
   \---main
       +---java
       |   \---cn.gov.customs.h2018
       |     |   ApplicationStarter.java
       |     \---tmc
       |         \---sample
       |             +---config
       |             +---constant
       |             |       SampleError.java
       |             +---controller
       |             |       CountryController.java
       |             |       EntryController.java
       |             +---dao
       |             |       CountryRepo.java
       |             |       EntryHeadRepository.java
       |             |       EntryListRepository.java
       |             +---exception
       |             |       ValidationException.java
       |             |
       |             +---pojo
       |             |       BaseEntity.java
       |             |       Country.java
       |             |       Entry.java
       |             |       EntryHead.java
       |             |       EntryList.java
       |             +---proxy
       |             +---service
       |             |   |   EntryService.java
       |             |   \---impl
       |             |           CountryServiceImpl.java
       |             |           EntryServiceImpl.java
       |             |
       |             \---util
       \---resources
               bootstrap.yml


```

方式二：

```
root
|   .gitignore
|   alaudaci.yml
|   Dockerfile
|   pom.xml
|
\---src
    +---main
    |   +---java
    |   |   \---cn.customs.h2018.examp
    |   |                   |   Application.java
    |   |                   +---business1
    |   |                   |   |   Article.java
    |   |                   |   |   ArticleController.java
    |   |                   |   |   ArticleRepository.java
    |   |                   |   |   ArticleService.java
    |   |                   +---business2
    |   |                   +---config
    |   |                   |       ProjectConfiguration.java
    |   |                   \---utils
    |   \---resources
    |       |   application.yml
    \---test
        \---java
            \---cn.customs.h2018.example
                            |   ApplicationTests.java
                            +---bussiness1
                            |       ArticleControllerTests.java
                            |       ArticleRepositoryTests.java
                            |       ArticleServiceTests.java
                            |       ArticleTests.java
                            +---bussiness2
                            \---utils
```

# 附录：git使用
gitlab地址: http://10.200.15.118:5002
建立用户，记住自己的用户名密码
建议使用研发网的邮件地址，一般是: username@rd.domain.com

在gitlab上登陆后，访问如下地址：http://10.200.15.118:5002/profile/keys
按照 http://10.200.15.118:5002/help/ssh/README 的指引，建立自己的ssh keys并上传

本地执行如下命令
$ git config --global user.name "用户名"
$ git config --global user.email 邮件地址，建议使用研发网的邮件地址，一般是: username@rd.domain.com

转到自己的用户目录：
一般是 C:\Users\用户名.ssh 目录，将 \\10.200.15.37\software\develop\conf.ssh 目录中的config文件拷贝过来

配置完成，现在可以创建项目并push pull了。

# 附录
亚马逊军规：
1. 所有的团队都要以服务接口的方式，提供数据和各种功能。
2. 团队之间必须通过接口来通信。
3. 不允许任何其他形式的互操作：不允许直接链接，不允许直接读其他团队的数据，不允许共享内存，不允许任何形式的后门。唯一许可的通信方式，就是通过网络调用服务。
4. 具体的实现技术不做规定，HTTP、Corba、PubSub、自定义协议皆可。
5. 所有的服务接口，必须从一开始就以可以公开作为设计导向，没有例外。这就是说，在设计接口的时候，就默认这个接口可以对外部人员开放，没有讨价还价的余地。
