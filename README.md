# Elm 外卖系统 - Spring Boot + MyBatis Plus 后端项目

## 项目概述

这是一个基于 Spring Boot 3.x 和 MyBatis Plus 开发的外卖系统后端项目，提供完整的用户管理、商家管理、购物车、订单管理等核心功能。

## 技术栈

### 后端技术

- **Spring Boot 3.5.6** - 快速开发框架
- **MyBatis Plus 3.5.14** - ORM框架，简化数据库操作
- **MySQL 9.4.0** - 关系型数据库
- **Java 24** - 编程语言
- **Knife4j 4.5.0** - API文档生成工具
- **Lombok 1.18.42** - 简化Java代码

### 前端技术

- **Vue 3** - 前端框架
- **Element Plus** - UI组件库
- **Axios** - HTTP客户端

## 项目结构

```txt
src/main/java/ynu/edu/
├── common/                    # 通用工具类
│   └── TokenStore.java       # Token存储管理
├── config/                    # 配置类
│   ├── Knife4jConfig.java    # Knife4j配置
│   └── WebMvcConfig.java     # Web MVC配置（CORS+拦截器）
├── controller/               # 控制器层
│   ├── UserController.java           # 用户管理
│   ├── BusinessController.java       # 商家管理
│   ├── CartController.java           # 购物车管理
│   ├── DeliveryAddressController.java # 地址管理
│   ├── FoodController.java           # 食品管理
│   └── OrdersController.java         # 订单管理
├── dao/                      # 数据访问层接口
│   ├── IUserDao.java
│   ├── IBusinessDao.java
│   ├── ICartDao.java
│   └── ...
├── entity/                   # 实体类
│   ├── User.java
│   ├── Business.java
│   ├── Cart.java
│   └── ...
├── interceptor/              # 拦截器
│   └── AuthInterceptor.java  # Token认证拦截器
├── service/                  # 服务层接口
│   ├── IUserService.java
│   ├── IBusinessService.java
│   └── ...
└── service/impl/            # 服务层实现
    ├── UserServiceImpl.java
    ├── BusinessServiceImpl.java
    └── ...
```

## 核心功能模块

### 1. 用户管理模块

- 用户登录/注册
- 个人信息管理
- Token身份认证
- 密码加密存储

### 2. 商家管理模块

- 商家信息查询
- 商家分类管理
- 商家菜品展示

### 3. 购物车模块

- 添加商品到购物车
- 购物车商品管理
- 数量修改和删除

### 4. 订单管理模块

- 订单创建和提交
- 订单状态管理
- 订单详情查询
- 订单支付流程

### 5. 地址管理模块

- 收货地址管理
- 默认地址设置
- 地址信息维护

## API接口文档

项目集成了 Knife4j，启动后可访问：

- **Swagger UI**: `http://localhost:8085/doc.html`
- **OpenAPI JSON**: `http://localhost:8085/v3/api-docs`

### 主要API接口

#### 用户相关

- `POST /UserController/getUserByIdByPass` - 用户登录（返回Token）
- `POST /UserController/getUserById` - 检查用户是否存在
- `POST /UserController/saveUser` - 用户注册

#### 订单相关

- `POST /OrdersController/createOrders` - 创建订单
- `POST /OrdersController/listOrdersByUserId` - 查询用户订单
- `POST /OrdersController/getOrdersById` - 根据订单ID查询订单

#### 购物车相关

- `POST /CartController/saveCart` - 添加到购物车
- `POST /CartController/listCart` - 查询购物车列表
- `POST /CartController/updateCart` - 更新购物车

## 身份认证机制

项目采用基于 Token 的身份认证机制：

### Token 认证流程

1. **用户登录** → 后端验证用户名密码
2. **生成Token** → 使用UUID生成唯一Token
3. **存储Token** → TokenStore缓存中存储Token-用户ID映射
4. **请求验证** → 每次请求携带`Authorization: Bearer {token}`头
5. **拦截器校验** → AuthInterceptor验证Token有效性

### 请求头格式

```txt
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

### 受保护接口

- 所有非公开接口都需要Token认证
- 公开接口：登录、注册、检查用户是否存在、API文档

## 数据库设计

### 主要数据表

1. **user** - 用户表
2. **business** - 商家表
3. **food** - 食品表
4. **cart** - 购物车表
5. **orders** - 订单表
6. **orderdetailet** - 订单明细表
7. **deliveryaddress** - 配送地址表

## 环境配置

### 1. 数据库配置

修改 `src/main/resources/application.yml`：

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/elm?useSSL=false&serverTimezone=Asia/Shanghai
    username: root
    password: your_password
```

### 2. 服务器配置

```yaml
server:
  port: 8085
  servlet:
    context-path: /elm_api
```

## 快速开始

### 1. 环境要求

- JDK 24 或更高版本
- Maven 3.6+
- MySQL 8.0+

### 2. 数据库初始化

1. 创建数据库：`CREATE DATABASE elm CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;`
2. 执行SQL脚本创建表结构（项目已包含Mapper文件）

### 3. 项目构建

```bash
# 克隆项目
git clone <repository-url>

# 进入项目目录
cd Elm_Mybatis_Plus

# 编译项目
mvn clean compile

# 打包
mvn clean package
```

### 4. 运行项目

```bash
# 方式1：使用Maven运行
mvn spring-boot:run

# 方式2：运行打包后的JAR
java -jar target/Elm_Mybatis_Plus-1.0-SNAPSHOT.jar
```

### 5. 访问项目

- 后端API地址：`http://localhost:8085/elm_api`
- API文档地址：`http://localhost:8085/doc.html`
- 前端项目地址：`http://localhost:8086`（需单独部署）

## 开发指南

### 1. 添加新API接口

1. 在对应的Controller中添加方法
2. 使用`@PostMapping`或`@GetMapping`注解定义路径
3. 使用`@Operation`注解添加API文档说明
4. 在Service层实现业务逻辑

### 2. 数据库操作

1. 在`entity`包创建实体类
2. 在`dao`包创建Mapper接口继承`BaseMapper`
3. 在`resources/mapper`目录创建XML映射文件
4. 使用MyBatis Plus的通用方法或自定义SQL

### 3. Token认证开发

- 需要认证的接口会自动被拦截器保护
- 不需要认证的接口需在`AuthInterceptor`和`WebMvcConfig`中排除

## 常见问题

### 1. 端口冲突

修改`application.yml`中的`server.port`配置

### 2. 数据库连接失败

- 检查MySQL服务是否启动
- 检查数据库连接配置
- 确保数据库用户有访问权限

### 3. Token认证失败

- 检查请求头是否包含正确的`Authorization`头
- 确认Token没有过期（TokenStore中是否存在）
- 检查拦截器排除路径是否正确

### 4. 跨域问题

项目已配置CORS，如果仍有问题可调整`WebMvcConfig`中的CORS配置

## 部署说明

### 生产环境部署

1. 修改数据库配置为生产环境数据库
2. 配置日志级别和输出路径
3. 设置合适的JVM参数
4. 使用Nginx作为反向代理
5. 配置HTTPS证书

### 性能优化建议

1. 使用连接池（如HikariCP）
2. 启用MyBatis二级缓存
3. 使用Redis缓存热点数据
4. 优化数据库索引

## 项目特点

1. **前后端分离**：RESTful API设计，与前端完全解耦
2. **安全可靠**：Token认证机制，防止未授权访问
3. **文档完善**：集成Knife4j，提供完整的API文档
4. **易于扩展**：模块化设计，便于功能扩展和维护
5. **性能优化**：使用MyBatis Plus提高开发效率

## 许可证

本项目基于 MIT 许可证 - 查看 [LICENSE](LICENSE) 文件了解详情

