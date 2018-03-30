# 前端开发模板

### 1. 概述
本项目是一个使用微服务架构开发的前端系统模板，旨在帮助用户使用VUE快速开发系统前端功能。

系统特点：
- 用户界面Vue+ElementUI



系统组成：

|微服务名称  |代码         |描述                                |
|------------|-------------|------------------------------------|



### 运用到的工具：
> webpack3 + babel

### 运用到的库或框架：
> vue2 + vue-router + ElementUI + axios + axios-mock-adapter

## 注意事项
1. JS风格使用`JavaScript Standard Style`，建议使用VSCode作为js/vue的编辑器，并安装以下插件`EditorConfig for VSCode`,`Prettier-Standard - JavaScript formatter`,`JavaScript Standard Style`,`stylefmt`,`Vetur`。
1. 在开发界面时使用`ElementUI`提供的栅格系统（24列），对界面进行响应式布局，以便移动端访问。
1. 不要使用`ElementUI`提供的图标组件，使用`Font Awesome` 图标。
1. 界面参考设计稿，因为使用第三方控件库，所以不要求界面完全相同（控件的大小可与设计略有不同），但要布局类似（控件的位置，和控件间的留白类似）。
1. 后端接口符合RESTful规范
1. 注意后端返回前端的数据，字段名同数据库中的字段名，并转为小写，构造mock数据时也要注意这一点。
1. 工程编译时，`source`目录下的`lib`、`assets`目录下的文件会被直接复制到`dist`目录下。
1. 不要提交`node_modules`和`dist`目录到配置管理工具
在`Eclipse`的资源管理里排除 `node_modules` 目录:
工程上右键 -> Properties -> Resource -> Resource Filters -> Add Filter ->Exclude all + Folders 填写 node_modules
在`Git`客户端排除 `node_modules` 目录:
在工程根目录下的 `.gitignore` 文件中添加 `node_modules`
1. `vue-loader 13.0.x` 有bug，不能正常编译vue文件，所以暂时用 `vue-loader 12.2.2`。如要升级`vue-loader`，一定要先作测试确认能正常编译vue文件。


## 目录说明
目录结构类似 https://github.com/kenberkeley/vue-demo/tree/master/src 有调整。

```
source
│  index.html                主入口静态页
│  app.js                    主入口js
│
├─components                 公共组件
├─config                     一些全局配置
├─directives                 自定义指令
├─filters                    自定义过滤器
├─mixins                     公共mixins
├─router                     路由配置
├─store                      状态管理
├─utils                      公共js工具方法/类
├─lib                        第三方库，供页面直接用<script>标签引入
│    vue.min.js
│    vue-router.min.js
│    axios.min.js
│     ......
└─views                      所有页面视图
    │  main.vue              app主视图组件
    │
    ├─feature1               功能1
    │  ├─api                 接口（统一管理 XHR 请求）
    │  ├─components          本功能模块下各子模块的共用组件
    │  └─mock                mock数据目录
    ├─feature2               功能2
    │  ├─api                 接口（统一管理 XHR 请求）
    │  ├─components          功能2模块下各子模块的共用组件
    │  ├─mixins              功能2模块下各子模块的共用mixins
    │  └─mock                mock数据目录
    ├─feature3               功能3
    │  ├─api
    │  └─mock
    └─error                  404、505等错误提示视图

静态资源：
static                       资源目录
├─css                        公共样式及第三方样式库
├─fonts                      图标字体
└─images                     图片
```

## 开始工作

### 环境准备
建议使用npm5或以上版本。windows下安装nodejs8.9.4以上版本即可。

```bash
# 使用研发网的npm仓库镜像
npm config set registry https://npm-repo.rd.domain.com:8443/repository/npm-public/

# 更新npm到最新版
npm install npm@latest -g

# 安装 api-designer 到全局
npm install -g api-designer

# 使用 api-designer 编辑raml格式接口文档，编辑时是暂存在浏览器本地缓存中的，需要导出或复制到工程根目录下API.raml文件
api-designer

# 安装 raml2html 到全局
npm install -g raml2html

```

### 建立新项目
1. 拷贝本目录到新的工作环境
2. 重命名项目名称等有关信息。修改package.json文件中，

```json
{
	"name": "*项目名称*",
	"version": "1.0.0",
	"description": "项目描述",
	"author": "lizhipeng <lizhipeng@gmail.com>"
}
```

### 开发
```bash
# 安装依赖
npm install

# 进入开发模式，启动前台应用，localhost:8080 。监听vue文件改动自动刷新浏览器
npm run dev

# 构建文件到dist目录供发布
npm run build

# 构建raml格式接口文档为html格式接口文档
raml2html API.raml -o API.html
```

## 链接
VUE 2 文档
https://cn.vuejs.org/v2/api/

Vue Router 2 文档
https://router.vuejs.org/zh-cn/

ElementUI 文档
http://element.eleme.io/#/zh-CN/component/layout

axios 介绍
https://github.com/mzabriskie/axios/blob/master/README.md

Font Awesome 图标
http://fontawesome.io/icons/

RAML 1.0 文档
https://github.com/raml-org/raml-spec/blob/master/versions/raml-10/raml-10.md
