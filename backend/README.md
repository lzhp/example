# 主要技术及工具

1. JDK 1.8+
2. maven 3.5 + springboot2 + jpa(mybatis) + junit4 + sonarLint
3. google guava (依赖包)

spring boot 2

```
<parent>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-parent</artifactId>
	<version>2.0.0.RELEASE</version>
	<relativePath /> <!-- lookup parent from repository -->
</parent>
```
	
junit4不需要直接引用，直接引用spring-boot-starter-test即可
	
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
</dependency>
```

guava，版本

```
		<dependency>
			<groupId>com.google.guava</groupId>
			<artifactId>guava</artifactId>
			<version>24.0-jre</version>
		</dependency>
```

# 环境说明
eclipse或ideal, 研发网地址：[\\file.rd.domain.com\software\develop\IDE\](file:\\file.rd.domain.com\software\develop\IDE\)

1. 安装 `lombok` 插件(直接双击lombok.jar)
2. 代码风格 `google java style`，文件eclipse-java-google-style.xml，开发工具安装google代码风格操作如下

   eclipse:  select Java/Code Style/Formatter. Import the settings file by selecting Import
  
   idea: Copy it into your config/codestyles folder in your IntelliJ settings folder. Under Settings -> Editor -> Code Style select the google-styleguide as current code style for the Metanome project.

3. maven，研发网maven仓库地址： [http://maven-repo.rd.domain.com:8081/nexus/](http://maven-repo.rd.domain.com:8081/nexus/)，或者直接拷贝` \\file.rd.domain.com\software\develop\conf\.m2\settings.xml`覆盖当前用户的settings.xml
4. 空白后端的开发模板

# 注意事项
1. 代码风格, google java style
2. 层次关系：controller->service->repository，**不允许** 逆向或跨层调用
3. 业务逻辑应在service层进行封装，对于写数据库等操作，应在service层 **启用事务**。
4. 

# 编码规范
1. 接口及实现的风格，接口 `Bussiness`，实现 `BussinessImpl`
2. 日期类型，使用`java8`的`LocalDate LocalDateTime`等进行定义
3. 公共函数，首选JDK自带，在JDK不能满足要求的情况下，首选google guava库里的各种函数，最后才考虑自行封装公共函数
4. 

# 目录结构

```
root
│  pom.xml
│  README.md
├─src
│  ├─main
│  │  ├─java
│  │  │  └─cn.customs.h2018.project
│  │  │                  │  Application.java                根目录
│  │  │                  ├─business1                        业务1目录
│  │  │                  │  │  Bussiness1.java                业务的pojo
│  │  │                  │  │  Bussiness1Controller.java      业务的controller
│  │  │                  │  │  Bussiness1Repository.java      业务的数据库封装
│  │  │                  │  │  Bussiness1Service.java         业务的逻辑接口定义（可选）
│  │  │                  │  │  Bussiness1ServiceImpl.java     业务的逻辑实现
│  │  │                  │  └─config                          业务的自身配置信息
│  │  │                  ├─business2                        业务2目录
│  │  │                  │  │  Bussiness2.java                业务的pojo
│  │  │                  │  │  Bussiness2Controller.java      业务的controller
│  │  │                  │  │  Bussiness2Repository.java      业务的数据库封装
│  │  │                  │  │  Bussiness2Service.java         业务的逻辑封装
│  │  │                  │  └─config                          业务的自身配置信息
│  │  │                  ├─config                            整个应用的配置信息目录
│  │  │                  │      ProjectConfiguration.java     应用的配置信息
│  │  │                  └─utils                            整个应用公用的工具类
│  │  └─resources                                           资源目录
│  │      │  application.yml                                  应用的配置，建议使用yaml文件
│  │      ├─static                                            静态资源
│  │      └─templates                                         模板等
└─ └─test                                                    单元测试相关
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

