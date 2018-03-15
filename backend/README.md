# 主要技术及工具

1. JDK 1.8+
2. maven 3.5+
springboot2 + jpa(mybatis) + maven3 + junit4
3. google guava (依赖包)

# 环境说明
1. eclipse或ideal，安装 `lombok` 插件(直接双击lombok.jar)
2. 代码风格 `google java style`

   eclipse:  select Java/Code Style/Formatter. Import the settings file by selecting Import
  
   idea: Copy it into your config/codestyles folder in your IntelliJ settings folder. Under Settings -> Editor -> Code Style select the google-styleguide as current code style for the Metanome project.

2. maven，研发网maven仓库地址： [http://10.200.15.65:8081/nexus/](http://10.200.15.65:8081/nexus/)

# 注意事项
1. 代码风格, google java style

# 编码规范
1. 接口及实现的风格，接口 `Interface`，实现 `InterfaceImpl`

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
                          │      Bussiness1RepositoryTest.java  数据库访问单元测试
                          │      Bussiness1ServiceTest.java     业务逻辑单元测试
                          │      Bussiness1Test.java            pojo单元测试
                          ├─bussiness2                       业务2
                          │      Bussiness2RepositoryTest.java 
                          │      Bussiness2ServiceTest.java
                          │      Bussiness2Test.java
                          └─utils                             工具类测试
```

