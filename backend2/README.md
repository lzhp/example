# 主要技术及工具

1. JDK 1.8+
2. maven 3.5 + springboot1.5.* + jpa(mybatis) + junit4 + sonarLint
3. google guava (依赖包)
4. 开发工具 Eclipse，lombok

# 环境安装说明
0. jdk 1.8.151 地址：\\file.rd.domain.com\software\develop\jdk-8u151-windows-x64.exe
1. eclipse, 研发网地址：[\\file.rd.domain.com\software\develop\IDE\](file:\\file.rd.domain.com\software\develop\IDE\)
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
1. 代码风格, google java style
2. 层次关系：controller->service->dao，**不允许** 逆向或跨层调用
3. 业务逻辑应在service层进行封装，对于写数据库等操作，应在service层 **启用事务**。


# 编码规范
1. 接口及实现的风格，接口 `Bussiness`，实现 `BussinessImpl`，或者不定义接口，只将实现放在在`Bussiness`中
2. 日期类型，使用`java8`的`LocalDate LocalDateTime`等进行定义，不允许使用`java.util.Date`类
3. 公共函数，首选JDK自带，在JDK不能满足要求的情况下，首选google guava库里的各种函数，最后才考虑自行封装公共函数
4. log统一使用`Slf4j`，在使用lombok的情况下，在类的前面加`@Slf4j`注解，然后在类的函数里直接使用如下方式记录日志。目前只记录如下4种，具体使用场景见描述。底层log实现使用spring boot默认的log back，在资源目录下增加`src/main/resources/logback-spring.xml`配置文件即可。
5. 不允许随意引入第三方库

```
	log.debug(……);  // 在需要时打开，可以定位应用系统出现问题的位置
	log.info(……);   // 一般信息，一般记录项目中
	log.error(……);  // 错误信息，一般性错误，记得记录错误堆栈
	log.fatal(……);  // 异常情况，系统出现此错误情况下可能已经无法正常工作
```

5. 错误处理：	
 
   - 在异常时，应附加异常的现场信息，如关键单证编号、传入的参数、当前的环节等等关键信息，以便快速定位问题原因。
   - 在底层只处理自己应该处理的错误，对于已知的业务异常情况，应该抛出自定义的业务异常，异常应包含错误号、关键业务单证号、简单错误描述等信息，对于有嵌套异常的情况，应该将底层的异常包装上述内容后向上层抛出。底层异常不记录log日志（否则会重复记录log）。
   - Service层应处理各种异常情况，保证业务调用方能得到足够的异常信息，同时，在Service层应记录详细log信息，在系统上线后能通过service层的log信息排查错误。
   -  Controller提供统一的异常处理机制，因此一般情况下不需要处理异常。
   - 【推荐】对外的 http/api 开放接口必须使用“错误码”，进行正常返回；而应用内部推荐异常抛出;跨应用间 RPC 调用优先考虑使用 Result 方式，出错时封 装 exception、“错误码”、“错误简短信息”、“错误详细信息”，调用方判断是否包含错误结构，然后进行正常处理。
   
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

方法一：

```
root
│  pom.xml
│  README.md
├─src
│  ├─main
│  │  ├─java
│  │  │  └─cn.customs.h2018.project
│  │  │     │  Application.java                根目录
│  │  │     ├─business1                        业务1目录
│  │  │     │  │  Bussiness1.java                业务的pojo
│  │  │     │  │  Bussiness1Controller.java      业务的controller
│  │  │     │  │  Bussiness1Repository.java      业务的数据库封装
│  │  │     │  │  Bussiness1Service.java         业务的逻辑接口定义（可选）
│  │  │     │  │  Bussiness1ServiceImpl.java     业务的逻辑实现
│  │  │     │  └─config                          业务的自身配置信息
│  │  │     ├─business2                        业务2目录
│  │  │     │  │  Bussiness2.java                业务的pojo
│  │  │     │  │  Bussiness2Controller.java      业务的controller
│  │  │     │  │  Bussiness2Repository.java      业务的数据库封装
│  │  │     │  │  Bussiness2Service.java         业务的逻辑封装
│  │  │     │  └─config                          业务的自身配置信息
│  │  │     ├─config                            整个应用的配置信息目录
│  │  │     │      ProjectConfiguration.java     应用的配置信息
│  │  │     └─utils                            整个应用公用的工具类
│  │  │           CustomBussinessRuntimeException.java 自定义业务错误
│  │  └─resources                                 资源目录
│  │      │  application.yml                        应用的配置，建议使用yaml文件
│  │      ├─static                                静态资源
│  │      └─templates                             模板等
└─ └─test                                         单元测试相关
      └─java
          └─cn.customs.h2018.example
              │  ApplicationTests.java            主程序测试
              ├─bussiness1                        业务1
              │      Bussiness1RepositoryTests.java  数据库访问单元测试
              │      Bussiness1ServiceTests.java     业务逻辑单元测试
              │      Bussiness1Tests.java            pojo单元测试
              ├─bussiness2                       业务2
              │      Bussiness2RepositoryTests.java 
              │      Bussiness2ServiceTests.java
              │      Bussiness2Tests.java
              └─utils                             工具类测试
                                                           
```


方式二：

```
root
|   pom.xml
|
+---src
|   +---main
|   |   +---java
|   |   |   \---cn.customs.h2018.sample
|   |   |       |   Application.java                  主程序
|   |   |       |   ApplicationConfig.java            配置
|   |   |       +---controller                        Controller
|   |   |       |       BussinessController.java        业务controller 
|   |   |       +---dao                               Dao数据库访问
|   |   |       |       BussinessRepository.java        jpa方式访问，其他方式（mybatis）也放这个包内 
|   |   |       +---pojo                              pojo实体
|   |   |       |       Bussiness.java                  业务实体定义   
|   |   |       +---service                           服务
|   |   |       |       BussinessService.java           业务服务类
|   |   |       \---utils                             工具类
|   |   |               CustomBussinessRuntimeException.java  自定义业务错误  
|   |   \---resources                               资源目录
|   |       |   application.yml                       配置文件，推荐yaml
|   |       |   logback-spring.xml                    日志配置文件
|   |       +---static                                静态资源
|   |       \---templates                             模板
\-  \---test                                          测试代码
       \---java
           \---cn.customs.h2018.sample
                  |   TemplateApplicationTests.java    主程序测试相关
                  +---controller
                  |       BussinessControllerTests.java业务controller测试
                  \---service  
                          BussinessServiceTests.java   业务service类测试
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
