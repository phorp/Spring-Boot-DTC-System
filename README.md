# 基于 Spring Boot 的车企 DTC 数字化系统设计与实现

## 项目简介

本项目是一个基于 Spring Boot + Vue + MySQL 的车企 DTC 数字化系统，适合作为 Java Web 毕业设计、课程设计、Spring Boot 实战项目、前后端分离项目参考。

关键词：Spring Boot、Vue、MySQL、Java Web、毕业设计、课程设计、汽车销售系统、DTC 系统、前后端分离、后台管理系统。

本项目是一个基于 Spring Boot 的车企 DTC 数字化系统，面向汽车企业直连用户运营场景，旨在帮助车企构建集车辆展示、用户管理、订单管理、售后服务、论坛交流和后台管理于一体的数字化平台。

系统采用前后端分离架构，后端基于 Spring Boot 框架开发，使用 MySQL 数据库存储业务数据；前端基于 Vue 框架实现交互式页面。通过该系统，普通用户可以在线浏览车辆信息、加入购物车、提交订单、申请预约试驾或售后服务，并参与论坛交流；管理员可以对车辆、公告、用户、订单、售后申请和论坛内容进行统一管理。

---

## 项目功能

### 普通用户功能

- 用户注册与登录
- 查看系统公告
- 浏览汽车品牌与车辆信息
- 查看车辆详情、图片、价格等信息
- 添加车辆到购物车
- 提交订单与查看个人订单
- 预约试驾
- 预约保养或维修
- 修改个人资料、头像和密码
- 浏览论坛帖子
- 发布帖子、评论和点赞

### 管理员功能

- 管理用户信息
- 发布、修改和删除系统公告
- 管理汽车品牌信息
- 管理汽车详细信息
- 查看和处理订单
- 审核预约试驾、保养和维修申请
- 管理论坛帖子
- 删除违规内容
- 维护系统基础数据

---

## 技术栈

### 后端技术

- Java
- Spring Boot
- Spring MVC
- MyBatis / MyBatis-Plus
- MySQL
- Maven

### 前端技术

- Vue.js
- JavaScript
- HTML
- CSS
- Element UI / 前端组件库

### 开发工具

- IntelliJ IDEA
- Visual Studio Code
- MySQL
- Navicat / 数据库管理工具
- Git / GitHub

---

## 项目结构

推荐项目结构如下：

```text
spring-boot-dtc-system/
├── Backend/
│   └── carsystems/
│       ├── src/
│       ├── pom.xml
│       ├── pom-war.xml
│       ├── carsystems.sql
│       └── .gitignore
│
├── Frontend/
│   ├── public/
│   ├── src/
│   ├── package.json
│   ├── package-lock.json
│   ├── babel.config.js
│   ├── vue.config.js
│   └── .gitignore
│
└── README.md
```

---

## 系统模块说明

| 模块           | 功能说明                                                     |
| -------------- | ------------------------------------------------------------ |
| 公告管理模块   | 管理员发布系统公告、优惠活动、通知信息，普通用户可以查看公告 |
| 汽车管理模块   | 管理汽车品牌、车辆名称、型号、价格、库存、图片和详细介绍     |
| 用户管理模块   | 支持普通用户注册、登录、修改资料，管理员可管理用户信息       |
| 售后管理模块   | 支持预约试驾、预约保养、预约维修，管理员可审核和处理申请     |
| 购物车管理模块 | 普通用户可添加车辆到购物车，修改数量并进行结算               |
| 订单管理模块   | 支持用户查看订单状态，管理员可管理和处理订单                 |
| 论坛管理模块   | 用户可发帖、评论、点赞，管理员可管理帖子和删除违规内容       |

---

## 环境要求

### 后端环境

```text
JDK：1.8
Maven：3.x
MySQL：5.7 或以上
Spring Boot：以项目 pom.xml 为准
```

### 前端环境

```text
Node.js：建议 14.x 或 16.x
npm：建议 6.x 或以上
Vue：以 package.json 为准
```

---

## 数据库配置

1.创建 MySQL 数据库，例如：

```sql
CREATE DATABASE carsystems DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
```

2.修改后端配置文件中的数据库连接信息。

通常配置文件位置为：

```text
Backend/carsystems/src/main/resources/application.yml
```

或：

```text
Backend/carsystems/src/main/resources/application.properties
```

根据自己的数据库用户名和密码修改：

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/carsystems?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
spring.datasource.username=root
spring.datasource.password=你的数据库密码
```

---

## 后端运行方法

进入后端项目目录：

```bash
cd Backend/carsystems
```

使用 Maven 安装依赖：

```bash
mvn clean install
```

运行 Spring Boot 项目：

```bash
mvn spring-boot:run
```

或者在 IntelliJ IDEA 中打开 `Backend/carsystems` 目录，找到启动类后直接运行。

后端启动成功后，默认访问地址一般为：

```text
http://localhost:8080
```

具体端口以项目配置文件为准。

---

## 前端运行方法

进入前端项目目录：

```bash
cd Frontend
```

安装依赖：

```bash
npm install
```

启动前端项目：

```bash
npm run serve
```

前端启动成功后，浏览器访问：

```text
http://localhost:8081
```

具体端口以终端输出为准。

---

## 项目运行流程

1. 启动 MySQL 数据库
2. 创建数据库并导入 `carsystems.sql`
3. 修改后端数据库连接配置
4. 启动 Spring Boot 后端服务
5. 启动 Vue 前端项目
6. 在浏览器中访问前端页面
7. 使用普通用户或管理员账号登录系统

---

## 系统特色

- 采用前后端分离架构，便于维护和扩展
- 后端基于 Spring Boot，开发效率高，结构清晰
- 前端基于 Vue，页面交互友好
- 使用 MySQL 进行数据持久化管理
- 覆盖车企 DTC 场景中的车辆展示、订单、售后、论坛等核心业务
- 支持管理员和普通用户两类角色
- 功能模块划分清晰，具有较好的可维护性

## License

本项目仅用于学习、课程设计和毕业设计参考。
