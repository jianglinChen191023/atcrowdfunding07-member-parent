# atcrowdfunding07-member-parent
尚筹网会员系统

- [十六 会员系统-搭建环境](#十六-会员系统-搭建环境)
    - [扩展: SpringBoot 热部署](#扩展-springboot-热部署)
    - [1. 尚筹网会员系统总目标](#1-尚筹网会员系统总目标)
    - [2. 会员系统架构](#2-会员系统架构)
        - [2.1 架构图](#21-架构图)
        - [2.2 需要创建的工程](#22-需要创建的工程)
            - [2.2.1 创建父工程](#221-创建父工程)
            - [2.2.2 创建子工程模块](#222-创建子工程模块)
            - [2.2.3 确保 `github` 上项目结构的完整](#223-确保-github-上项目结构的完整)
            - [2.2.4 删除父项目下的 `src` 目录](#224-删除父项目下的-src-目录)
    - [3. 父工程环境](#3-父工程环境)
    - [4. `Eureka` 工程](#4-eureka-工程)
        - [4.1 依赖](#41-依赖)
        - [4.2 主启动类](#42-主启动类)
        - [4.3 配置](#43-配置)
    - [5. `Entity` 工程](#5-entity-工程)
        - [5.1 实体类的进一步细分](#51-实体类的进一步细分)
            - [5.1.1 `VO`](#511-vo)
            - [5.1.2 `PO`](#512-po)
            - [5.1.3 `DO`](#513-do)
            - [5.1.4 `DTO`](#514-dto)
        - [5.2 创建包](#52-创建包)
        - [5.3 `Lombok`](#53-lombok)
            - [5.3.1 `lombok` 原理](#531-lombok-原理)
            - [5.3.2 `Lombok` 依赖](#532-lombok-依赖)
    - [5. `MySQL` 工程](#5-mysql-工程)
        - [5.1 依赖](#51-依赖)
        - [5.2 主启动类](#52-主启动类)
        - [5.3 配置](#53-配置)
        - [5.4 测试类](#54-测试类)
            - [5.4.1 测试 `connection`](#541-测试-connection)
            - [5.4.2 测试 `Mapper`](#542-测试-mapper)
    - [6. `Api` 工程](#6-api-工程)
        - [6.1 依赖](#61-依赖)
        - [6.2 接口](#62-接口)
        - [6.3 `MySQL`工程对外暴露服务](#63-mysql工程对外暴露服务)
            - [6.3.1 `Hnadler` 代码](#631-hnadler-代码)
            - [6.3.2 `Service` 接口](#632-service-接口)
            - [6.3.3 `Service` 类的代码](#633-service-类的代码)
    - [7. `Redis` 工程](#7-redis-工程)
        - [7.1 `Linux` 自动安装 `Redis`](#71-linux-自动安装-redis)
        - [7.2 Reids 命令列表](#72-reids-命令列表)
            - [7.2.1 查看 `Redis`](#721-查看-redis)
        - [7.3 工程依赖](#73-工程依赖)
        - [7.4 主启动类](#74-主启动类)
        - [7.5 测试类](#75-测试类)
    - [8. `Redis` 工程对外暴露服务](#8-redis-工程对外暴露服务)
        - [8.1 `API` 工程](#81-api-工程)
            - [8.1.1 新建 `RedisRemoteService`接口](#811-新建-redisremoteservice接口)
        - [8.2 `Redis` 工程](#82-redis-工程)
            - [8.2.1 对外暴露服务 追加依赖](#821-对外暴露服务-追加依赖)
            - [8.2.2 追加 `RedisTest` 测试方法](#822-追加-redistest-测试方法)
            - [8.2.3 新建 `handler` 包, 新建 `RedisHandler` 类](#823-新建-handler-包-新建-redishandler-类)
    - [9. `authentication` 会员中心工程](#9-authentication-会员中心工程)
        - [9.1 依赖](#91-依赖)
        - [9.2 新建 `CrowdMainClass` 主启动类](#92-新建-crowdmainclass-主启动类)
        - [9.3 新建 `application.yml` 配置](#93-新建-applicationyml-配置)
            - [9.3.1 新建包 `templates`、`static`](#931-新建包-templatesstatic)
        - [9.4 新建 `PortalHandler` 类](#94-新建-portalhandler-类)
        - [9.5 新建 `portal.html` 首页](#95-新建-portalhtml-首页)
        - [9.6 `static` 资源](#96-static-资源)
    - [10. `Zuul` 网关项目](#10-zuul-网关项目)
        - [10.1 依赖](#101-依赖)
        - [10.2 新建 `CrowdMainClass` 主启动类](#102-新建-crowdmainclass-主启动类)
        - [10.3 新建 `application.yml` 配置](#103-新建-applicationyml-配置)
    - [11. 关于第一次请求超时](#11-关于第一次请求超时)

# 十六 会员系统-搭建环境

## 扩展: SpringBoot 热部署

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <actifactId>spring-boot-devtools</actifactId>
</dependency>

<dependency>
  <groupId>org.springframework.boot</groupId>
  <actifactId>spring-boot-loader</actifactId>
</dependency>
```



## 1. 尚筹网会员系统总目标

- 搭建环境
- 会员登录注册
- 发起众筹项目
- 展示众筹项目
- 支持众筹项目
- 订单
- 支付



## 2. 会员系统架构

### 2.1 架构图

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1660761992125-e76f9523-8539-4e87-809f-523efdb400ba.jpeg)



### 2.2 需要创建的工程

| **工程**         | **工程名称**                                      | **端口号** |
| ---------------- | ------------------------------------------------- | ---------- |
| 父工程、聚合工程 | `atcrowdfunding07-member-parent`                  |            |
| 注册中心         | `atcrowdfunding08-member-eureka`                  | 1000       |
| 实体类模块       | `atcrowdfunding09-member-entity`                  |            |
| MySQL 数据服务   | `atcrowdfunding10-member-mysql-provider`          | 2000       |
| Redis 数据服务   | `atcrowdfunding11-member-redis-provider`          | 3000       |
| 会员中心         | `atcrowdfunding12-member-authentication-consumer` | 4000       |
| 项目维护         | `atcrowdfunding13-member-project-consumer`        | 5000       |
| 订单维护         | `atcrowdfunding14-member-order-consumer`          | 7000       |
| 支付功能         | `atcrowdfunding15-member-pay-consumer`            | 8000       |
| 网关             | `atcrowdfunding16-member-zuul`                    | 80         |
| API 模块         | `atcrowdfunding17-member-api`                     |            |



#### 2.2.1 创建父工程

- 父工程、聚合工程: `atcrowdfunding07-member-parent`(唯一的 `pom` 工程)

    - `groupId`: `com.atguigu.crowd`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660707430789-dd0a8cba-3455-4555-bfd3-6e09c1873e07.png)

1. 忽略某些文件

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660707703340-661f1278-d781-4f9d-9036-6cebddd3bb89.png)

```latex
### Java template
# Compiled class file
*.class

# Log file
*.log

# BlueJ files
*.ctxt

# Mobile Tools for Java (J2ME)
.mtj.tmp/

# Package Files #
*.jar
*.war
*.nar
*.ear
*.zip
*.tar.gz
*.rar

# virtual machine crash logs, see http://www.java.com/en/download/help/error_hotspot.xml
hs_err_pid*

# IntelliJ project files
.idea
*.iml
out
gen

*/target/
.gitignore
```



1. 上传到 Github

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660707610301-75ac1d1f-a18b-4b04-b631-d9508b3d7823.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660752238786-a7b567fe-f0a7-44a7-a4b6-128da88463ee.png)



1. 获取令牌

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660708042836-1497af56-4f8b-43cd-b963-3fa01013619b.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660708053831-2fc3084a-fdbb-4523-8d31-90861c211974.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660708068382-832697e0-2707-449c-b4a0-6b29fc2f0fd8.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660708079398-a4ebb822-9277-4fc0-86e8-5e3096bf2623.png)



1. 使用令牌

此处为语雀加密文本卡片，点击链接查看：https://www.yuque.com/lingchen-bf1rc/hoahc6/rkxxg5#Fpv7c

```bash
git remote set-url origin https://令牌@github.com/用户名/atcrowdfunding07-member-parent.git
```

- 用户名: [https://github.com/](https://github.com/jianglinChen191023)用户名

1. 到 GitHub 上创建 `README.md` 文件: `Add a README`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660752398366-57894d6d-ce0b-4107-9606-86ee518b0b09.png)



1. 更新到本地: `git pull`



#### 2.2.2 创建子工程模块

分支: `git checkout -b 16.0.0_build_environment`



- 注册中心: `atcrowdfunding08-member-eureka`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660748801355-aa089955-2b04-4c61-bb35-ee124e0793a1.png)



- 实体类模块: `atcrowdfunding09-member-entity`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660749600504-abcace78-e006-4ea6-b24c-5f456a3ba6aa.png)



- MySQL 数据服务: `atcrowdfunding10-member-mysql-provider`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660749646155-51baeb1e-8d18-4ae4-82f6-fb8f83f992c6.png)



- Redis 数据服务: `atcrowdfunding11-member-redis-provider`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660749689336-fe15aac4-f87d-40a5-ba8b-33aed63ec078.png)



- 会员中心: `atcrowdfunding12-member-authentication-consumer`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660749736843-deb054d8-b097-4b28-86a0-4c884c4fcd47.png)



- 项目维护: `atcrowdfunding13-member-project-consumer`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660749794116-95648241-955c-4750-a8af-c61feb4f9777.png)



- 订单维护: `atcrowdfunding14-member-order-consumer`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660749819591-ac051a78-eedc-44fe-a28f-55f740754f71.png)



- 支付功能: `atcrowdfunding15-member-pay-consumer`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660749894730-b5fb2891-df3a-4713-8e26-a0086f86fb39.png)



- 网关: `atcrowdfunding16-member-zuul`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660760529179-834536c1-0845-4cbe-8f04-f5bde543a909.png)



- API 模块: `atcrowdfunding17-member-api`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660762061884-37abcf11-b193-46aa-b3ef-9824a3abcbff.png)



#### 2.2.3 确保 `github` 上项目结构的完整

- 因为 `github` 上不能保存空文件夹, 所以要在项目空文件夹下创建文件, 确保 `github` 上的项目结构的完整

```bash
find . \( -type d -empty \) -exec touch {}/.gitxxx \;
```



#### 2.2.4 删除父项目下的 `src` 目录



## 3. 父工程环境

- 依赖管理

```xml
<!-- 配置在父工程中要管理的依赖 -->
<dependencyManagement>
    <dependencies>
        <!-- 导入 SpringCloud 需要使用的依赖信息 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Greenwich.SR2</version>
            <type>pom</type>
            <!-- import 依赖范围表示将 spring-cloud-dependencies 包中的依赖信息导入 -->
            <scope>import</scope>
        </dependency>
        <!-- 导入 SpringBoot 需要使用的依赖信息 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-dependencies</artifactId>
            <version>2.1.6.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.1</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.17</version>
        </dependency>
     </dependencies>
</dependencyManagement>
```



## 4. `Eureka` 工程

### 4.1 依赖

```xml
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!-- 这个插件将 SpringBoot 应用打包成一个可执行的 jar 包 -->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```



### 4.2 主启动类

```java
package com.atguigu.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author chenjianglin
 * @date 2022/8/18 02:05
 */
@EnableEurekaServer
@SpringBootApplication
public class CrowdMainClass {

    public static void main(String[] args) {
        SpringApplication.run(CrowdMainClass.class, args);
    }
    
}
```



### 4.3 配置

```yaml
server:
  port: 1000

spring:
  application:
    name: atguigu-crowd-eureka

eureka:
  instance:
    hostname: location
  client:
    # 自己就是注册中心, 所以自己不注册自己
    register-with-eureka: false
    # 自己就是注册中心, 所以不需要"从注册中心取回信息"
    fetch-registry: false
    # 客户端访问 Eureka 时使用的地址
    service-url:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka
```



## 5. `Entity` 工程

### 5.1 实体类的进一步细分

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1660763085899-37674a6e-4e2a-4634-95c3-1a37e84771bd.jpeg)

- 使用 `org.springframework.beans.BeanUtils.copyProperties(Object, Object)` 在不同实体类之间复制属性
- `MemberVO` -> 复制属性 -> `MemberPO`

------

#### 5.1.1 `VO`

- `View Object` 视图对象

    - 用途1: 封装浏览器表单提交的数据为 `VO` 对象

        - **接送**浏览器发送过来的数据

    - 用途2: 后端程序将数据封装为 `VO` 对象后发送到浏览器显示

        - 把数据**发送**给浏览器去显示



#### 5.1.2 `PO`

- `Persistent Object` 持久化对象

    - 用途1: 将数据封装到 `PO` 对象存入数据库
    - 用途2: 将数据库数据查询出来存入 `PO` 对象

- 所以 `PO` 对象是和数据库表对应, 一个数据库表对应一个 `PO` 对象



#### 5.1.3 `DO`

- `Data Object` 数据对象

    - 用途1: 从 `Redis` 查询得到数据封装为 `DO` 对象
    - 用途2: 从 `ElasticSearch` 查询得到数据封装为 `DO` 对象
    - 用途3: 从 `Solr` 查询得到数据封装为 `DO` 对象

- 从中间件或其他第三方接口查询到的数据封装为 `DO` 对象



#### 5.1.4 `DTO`

- `Data Transfer Object` 数据传输对象

    - 用途1: 从 `Consumer` 发送数据到 `Provider`
    - 用途2: `Provider` 返回数据给 `Consumer`



### 5.2 创建包

- `con.atguigu.crowd.entity.po`
- `con.atguigu.crowd.entity.vo`



### 5.3 `Lombok`

| **注解**              | **说明**                                   |
| --------------------- | ------------------------------------------ |
| `@Data`               | get set equals hashCodetoString()构造器... |
| `@Setter`             |                                            |
| `@Getter`             |                                            |
| `@ToString`           |                                            |
| `@EqualsAndHashCode`  |                                            |
| `@AllArgsConstructor` | 有参构造器                                 |
| `@NoArgsConstructor`  | 无参构造器                                 |

- 组合使用 `@Data` `@AllArgsConstructor` `@NoArgsConstructor`



#### 5.3.1 `lombok` 原理

- 根据注解确定要生成的代码， 然后将生成的代码侵入到字节码文件中

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1660854421832-f3271bb0-ac5a-40d7-bfbf-810af7fcbcfb.jpeg)



#### 5.3.2 `Lombok` 依赖

```xml
<dependencies>
  <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
  </dependency>
</dependencies>
```



## 5. `MySQL` 工程

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660866025697-5e59e7d5-494c-4865-901d-073d7e47b115.png)

------

### 5.1 依赖

```xml
 <dependencies>
    <!-- 为能够使用实体类 -->
    <dependency>
        <groupId>com.atguigu.crowd</groupId>
        <artifactId>atcrowdfunding09-member-entity</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>

    <!-- 为了能够使用工具类 -->
    <dependency>
        <groupId>com.atguigu.crowd</groupId>
        <artifactId>atcrowdfunding05-common-util</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>

    <!-- 整合 MyBatis -->
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
    </dependency>

    <!-- MySQL 驱动-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>

    <!-- 整合数据库连接池 -->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid-spring-boot-starter</artifactId>
    </dependency>

    <!-- SpringBoot 测试 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
   
    <!-- 对外暴露服务 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- 作为客户端访问 Eureka 注册中心 -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
</dependencies>

<build>
    <plugins>
        <!-- 这个插件将 SpringBoot 应用打包成一个可执行的 jar 包 -->
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <executions>
                <execution>
                    <goals>
                        <goal>repackage</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```



### 5.2 主启动类

```java
package com.atguigu.crowd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenjianglin
 * @date 2022/8/19 05:02
 */
@MapperScan("com.atguigu.crowd.mapper")
@SpringBootApplication
public class CrowdMainClass {

    public static void main(String[] args) {
        SpringApplication.run(CrowdMainClass.class, args);
    }

}
```



### 5.3 配置

```yaml
server:
  port: 2000

eureka:
  client:
    service-url:
      defaultZone: http://localhost:1000/eureka

# 生成的公钥
public-key: MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAMNXQuj4GCqDt+t3ex6W9u5hf50/o/JZKS6C0lKlzzUXvWHqAhJxqWoa3C2+Jp+CUtJhugMtTpeLMf5+Acokg8ECAwEAAQ==

spring:
  application:
    name: atguigu-crowd-mysql
  datasource:
    name: mydb
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://175.178.174.83:3306/project_crowd ?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false
    username: root
    # 生成的加密后的密码
    password: lEdXTUweRH6bqzFKEy07vHkzKrziXqkHBQNwjK6FohatpabGU+2uxc73RZftE1vD3F5GDPZDhNg6vebNTNAOcA==
    # 配置 connection-properties，启用加密，配置公钥。
    druid:
      connection-properties: config.decrypt=true;config.decrypt.key=${public-key}
      # 启用ConfigFilter
      filter:
        config:
          enabled: true

mybatis:
  mapper-locations: classpath*:/mybatis/mapper/*Mapper.xml
logging:
  level:
    com.atguigu.crowd.mapper: debug
    com.atguigu.crowd.test: debug
```



### 5.4 测试类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660856789891-4bd1e4c5-f0ed-497e-8f97-267a05013a8c.png)

#### 5.4.1 测试 `connection`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660862236306-3a6ca70e-f178-4e01-8ade-cce8523d43c8.png)

------

```java
package com.atguigu.crowd.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author chenjianglin
 * @date 2022/8/19 05:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisTest {

    @Autowired
    private DataSource dataSource;

    private Logger logger = LoggerFactory.getLogger(MyBatisTest.class);
    
    @Test
    public void test() throws SQLException {
        Connection connection = dataSource.getConnection();
        logger.debug("connection: " + connection.toString());
    }

}
```



#### 5.4.2 测试 `Mapper`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660865495253-13248331-5fb0-482c-a1a9-1bbbb874f79e.png)

------

- `testMember` 方法

```java
package com.atguigu.crowd.test;

import com.atguigu.crowd.entity.po.MemberPO;
import com.atguigu.crowd.mapper.MemberPOMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author chenjianglin
 * @date 2022/8/19 05:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisTest {

    @Autowired
    private DataSource dataSource;

    private Logger logger = LoggerFactory.getLogger(MyBatisTest.class);

    @Autowired
    private MemberPOMapper memberPOMapper;

    @Test
    public void test() throws SQLException {
        Connection connection = dataSource.getConnection();
        logger.debug("connection: " + connection.toString());
    }

    @Test
    public void testMember() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String source = "123123";
        String encode = bCryptPasswordEncoder.encode(source);
        MemberPO memberPO = new MemberPO(null, "jack", encode, "杰克", "jack@qq.com", 1, 1, "杰克", "430626220104045821", 2);
        memberPOMapper.insert(memberPO);
    }

}
```

- 使用 `atcrowdfunding06-common-reverse` 创建 `MemberPO`实体类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660863785162-764b1423-8866-464d-8d7d-ca889f23ddc8.png)

- 复制到 项目中

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660864037860-e37c0937-a893-4bab-b631-17ec5f6ff591.png)



```java
package com.atguigu.crowd.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberPO {
    private Integer id;

    private String loginacct;

    private String userpswd;

    private String username;

    private String email;

    private Integer authstatus;

    private Integer usertype;

    private String realname;

    private String cardnum;

    private Integer accttype;
}
package com.atguigu.crowd.entity.po;

import java.util.ArrayList;
import java.util.List;

public class MemberPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberPOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLoginacctIsNull() {
            addCriterion("loginacct is null");
            return (Criteria) this;
        }

        public Criteria andLoginacctIsNotNull() {
            addCriterion("loginacct is not null");
            return (Criteria) this;
        }

        public Criteria andLoginacctEqualTo(String value) {
            addCriterion("loginacct =", value, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctNotEqualTo(String value) {
            addCriterion("loginacct <>", value, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctGreaterThan(String value) {
            addCriterion("loginacct >", value, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctGreaterThanOrEqualTo(String value) {
            addCriterion("loginacct >=", value, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctLessThan(String value) {
            addCriterion("loginacct <", value, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctLessThanOrEqualTo(String value) {
            addCriterion("loginacct <=", value, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctLike(String value) {
            addCriterion("loginacct like", value, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctNotLike(String value) {
            addCriterion("loginacct not like", value, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctIn(List<String> values) {
            addCriterion("loginacct in", values, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctNotIn(List<String> values) {
            addCriterion("loginacct not in", values, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctBetween(String value1, String value2) {
            addCriterion("loginacct between", value1, value2, "loginacct");
            return (Criteria) this;
        }

        public Criteria andLoginacctNotBetween(String value1, String value2) {
            addCriterion("loginacct not between", value1, value2, "loginacct");
            return (Criteria) this;
        }

        public Criteria andUserpswdIsNull() {
            addCriterion("userpswd is null");
            return (Criteria) this;
        }

        public Criteria andUserpswdIsNotNull() {
            addCriterion("userpswd is not null");
            return (Criteria) this;
        }

        public Criteria andUserpswdEqualTo(String value) {
            addCriterion("userpswd =", value, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdNotEqualTo(String value) {
            addCriterion("userpswd <>", value, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdGreaterThan(String value) {
            addCriterion("userpswd >", value, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdGreaterThanOrEqualTo(String value) {
            addCriterion("userpswd >=", value, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdLessThan(String value) {
            addCriterion("userpswd <", value, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdLessThanOrEqualTo(String value) {
            addCriterion("userpswd <=", value, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdLike(String value) {
            addCriterion("userpswd like", value, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdNotLike(String value) {
            addCriterion("userpswd not like", value, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdIn(List<String> values) {
            addCriterion("userpswd in", values, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdNotIn(List<String> values) {
            addCriterion("userpswd not in", values, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdBetween(String value1, String value2) {
            addCriterion("userpswd between", value1, value2, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUserpswdNotBetween(String value1, String value2) {
            addCriterion("userpswd not between", value1, value2, "userpswd");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andAuthstatusIsNull() {
            addCriterion("authstatus is null");
            return (Criteria) this;
        }

        public Criteria andAuthstatusIsNotNull() {
            addCriterion("authstatus is not null");
            return (Criteria) this;
        }

        public Criteria andAuthstatusEqualTo(Integer value) {
            addCriterion("authstatus =", value, "authstatus");
            return (Criteria) this;
        }

        public Criteria andAuthstatusNotEqualTo(Integer value) {
            addCriterion("authstatus <>", value, "authstatus");
            return (Criteria) this;
        }

        public Criteria andAuthstatusGreaterThan(Integer value) {
            addCriterion("authstatus >", value, "authstatus");
            return (Criteria) this;
        }

        public Criteria andAuthstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("authstatus >=", value, "authstatus");
            return (Criteria) this;
        }

        public Criteria andAuthstatusLessThan(Integer value) {
            addCriterion("authstatus <", value, "authstatus");
            return (Criteria) this;
        }

        public Criteria andAuthstatusLessThanOrEqualTo(Integer value) {
            addCriterion("authstatus <=", value, "authstatus");
            return (Criteria) this;
        }

        public Criteria andAuthstatusIn(List<Integer> values) {
            addCriterion("authstatus in", values, "authstatus");
            return (Criteria) this;
        }

        public Criteria andAuthstatusNotIn(List<Integer> values) {
            addCriterion("authstatus not in", values, "authstatus");
            return (Criteria) this;
        }

        public Criteria andAuthstatusBetween(Integer value1, Integer value2) {
            addCriterion("authstatus between", value1, value2, "authstatus");
            return (Criteria) this;
        }

        public Criteria andAuthstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("authstatus not between", value1, value2, "authstatus");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNull() {
            addCriterion("usertype is null");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNotNull() {
            addCriterion("usertype is not null");
            return (Criteria) this;
        }

        public Criteria andUsertypeEqualTo(Integer value) {
            addCriterion("usertype =", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotEqualTo(Integer value) {
            addCriterion("usertype <>", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThan(Integer value) {
            addCriterion("usertype >", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("usertype >=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThan(Integer value) {
            addCriterion("usertype <", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThanOrEqualTo(Integer value) {
            addCriterion("usertype <=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeIn(List<Integer> values) {
            addCriterion("usertype in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotIn(List<Integer> values) {
            addCriterion("usertype not in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeBetween(Integer value1, Integer value2) {
            addCriterion("usertype between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotBetween(Integer value1, Integer value2) {
            addCriterion("usertype not between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("realname is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("realname is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("realname =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("realname <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("realname >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("realname >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("realname <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("realname <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("realname like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("realname not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("realname in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("realname not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("realname between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("realname not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andCardnumIsNull() {
            addCriterion("cardnum is null");
            return (Criteria) this;
        }

        public Criteria andCardnumIsNotNull() {
            addCriterion("cardnum is not null");
            return (Criteria) this;
        }

        public Criteria andCardnumEqualTo(String value) {
            addCriterion("cardnum =", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotEqualTo(String value) {
            addCriterion("cardnum <>", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumGreaterThan(String value) {
            addCriterion("cardnum >", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumGreaterThanOrEqualTo(String value) {
            addCriterion("cardnum >=", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumLessThan(String value) {
            addCriterion("cardnum <", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumLessThanOrEqualTo(String value) {
            addCriterion("cardnum <=", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumLike(String value) {
            addCriterion("cardnum like", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotLike(String value) {
            addCriterion("cardnum not like", value, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumIn(List<String> values) {
            addCriterion("cardnum in", values, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotIn(List<String> values) {
            addCriterion("cardnum not in", values, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumBetween(String value1, String value2) {
            addCriterion("cardnum between", value1, value2, "cardnum");
            return (Criteria) this;
        }

        public Criteria andCardnumNotBetween(String value1, String value2) {
            addCriterion("cardnum not between", value1, value2, "cardnum");
            return (Criteria) this;
        }

        public Criteria andAccttypeIsNull() {
            addCriterion("accttype is null");
            return (Criteria) this;
        }

        public Criteria andAccttypeIsNotNull() {
            addCriterion("accttype is not null");
            return (Criteria) this;
        }

        public Criteria andAccttypeEqualTo(Integer value) {
            addCriterion("accttype =", value, "accttype");
            return (Criteria) this;
        }

        public Criteria andAccttypeNotEqualTo(Integer value) {
            addCriterion("accttype <>", value, "accttype");
            return (Criteria) this;
        }

        public Criteria andAccttypeGreaterThan(Integer value) {
            addCriterion("accttype >", value, "accttype");
            return (Criteria) this;
        }

        public Criteria andAccttypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("accttype >=", value, "accttype");
            return (Criteria) this;
        }

        public Criteria andAccttypeLessThan(Integer value) {
            addCriterion("accttype <", value, "accttype");
            return (Criteria) this;
        }

        public Criteria andAccttypeLessThanOrEqualTo(Integer value) {
            addCriterion("accttype <=", value, "accttype");
            return (Criteria) this;
        }

        public Criteria andAccttypeIn(List<Integer> values) {
            addCriterion("accttype in", values, "accttype");
            return (Criteria) this;
        }

        public Criteria andAccttypeNotIn(List<Integer> values) {
            addCriterion("accttype not in", values, "accttype");
            return (Criteria) this;
        }

        public Criteria andAccttypeBetween(Integer value1, Integer value2) {
            addCriterion("accttype between", value1, value2, "accttype");
            return (Criteria) this;
        }

        public Criteria andAccttypeNotBetween(Integer value1, Integer value2) {
            addCriterion("accttype not between", value1, value2, "accttype");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
```



![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660864374028-937103e0-8bf3-491d-9ef4-b5f55a61c046.png)

```java
package com.atguigu.crowd.mapper;

import com.atguigu.crowd.entity.po.MemberPO;
import com.atguigu.crowd.entity.po.MemberPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberPOMapper {
    int countByExample(MemberPOExample example);

    int deleteByExample(MemberPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberPO record);

    int insertSelective(MemberPO record);

    List<MemberPO> selectByExample(MemberPOExample example);

    MemberPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberPO record, @Param("example") MemberPOExample example);

    int updateByExample(@Param("record") MemberPO record, @Param("example") MemberPOExample example);

    int updateByPrimaryKeySelective(MemberPO record);

    int updateByPrimaryKey(MemberPO record);
}
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.atguigu.crowd.mapper.MemberPOMapper" >
  <resultMap id="BaseResultMap" type="com.atguigu.crowd.entity.po.MemberPO" >
    <id column="id" property="id" jdbcType="INTEGER" />
    <result column="loginacct" property="loginacct" jdbcType="VARCHAR" />
    <result column="userpswd" property="userpswd" jdbcType="VARCHAR" />
    <result column="username" property="username" jdbcType="VARCHAR" />
    <result column="email" property="email" jdbcType="VARCHAR" />
    <result column="authstatus" property="authstatus" jdbcType="INTEGER" />
    <result column="usertype" property="usertype" jdbcType="INTEGER" />
    <result column="realname" property="realname" jdbcType="VARCHAR" />
    <result column="cardnum" property="cardnum" jdbcType="VARCHAR" />
    <result column="accttype" property="accttype" jdbcType="INTEGER" />
  </resultMap>
  <sql id="Example_Where_Clause" >
    <where >
      <foreach collection="oredCriteria" item="criteria" separator="or" >
        <if test="criteria.valid" >
          <trim prefix="(" suffix=")" prefixOverrides="and" >
            <foreach collection="criteria.criteria" item="criterion" >
              <choose >
                <when test="criterion.noValue" >
                  and ${criterion.condition}
                </when>
                <when test="criterion.singleValue" >
                  and ${criterion.condition} #{criterion.value}
                </when>
                <when test="criterion.betweenValue" >
                  and ${criterion.condition} #{criterion.value} and #{criterion.secondValue}
                </when>
                <when test="criterion.listValue" >
                  and ${criterion.condition}
                  <foreach collection="criterion.value" item="listItem" open="(" close=")" separator="," >
                    #{listItem}
                  </foreach>
                </when>
              </choose>
            </foreach>
          </trim>
        </if>
      </foreach>
    </where>
  </sql>
  <sql id="Update_By_Example_Where_Clause" >
    <where >
      <foreach collection="example.oredCriteria" item="criteria" separator="or" >
        <if test="criteria.valid" >
          <trim prefix="(" suffix=")" prefixOverrides="and" >
            <foreach collection="criteria.criteria" item="criterion" >
              <choose >
                <when test="criterion.noValue" >
                  and ${criterion.condition}
                </when>
                <when test="criterion.singleValue" >
                  and ${criterion.condition} #{criterion.value}
                </when>
                <when test="criterion.betweenValue" >
                  and ${criterion.condition} #{criterion.value} and #{criterion.secondValue}
                </when>
                <when test="criterion.listValue" >
                  and ${criterion.condition}
                  <foreach collection="criterion.value" item="listItem" open="(" close=")" separator="," >
                    #{listItem}
                  </foreach>
                </when>
              </choose>
            </foreach>
          </trim>
        </if>
      </foreach>
    </where>
  </sql>
  <sql id="Base_Column_List" >
    id, loginacct, userpswd, username, email, authstatus, usertype, realname, cardnum, 
    accttype
  </sql>
  <select id="selectByExample" resultMap="BaseResultMap" parameterType="com.atguigu.crowd.entity.po.MemberPOExample" >
    select
    <if test="distinct" >
      distinct
    </if>
    <include refid="Base_Column_List" />
    from t_member
    <if test="_parameter != null" >
      <include refid="Example_Where_Clause" />
    </if>
    <if test="orderByClause != null" >
      order by ${orderByClause}
    </if>
  </select>
  <select id="selectByPrimaryKey" resultMap="BaseResultMap" parameterType="java.lang.Integer" >
    select 
    <include refid="Base_Column_List" />
    from t_member
    where id = #{id,jdbcType=INTEGER}
  </select>
  <delete id="deleteByPrimaryKey" parameterType="java.lang.Integer" >
    delete from t_member
    where id = #{id,jdbcType=INTEGER}
  </delete>
  <delete id="deleteByExample" parameterType="com.atguigu.crowd.entity.po.MemberPOExample" >
    delete from t_member
    <if test="_parameter != null" >
      <include refid="Example_Where_Clause" />
    </if>
  </delete>
  <insert id="insert" parameterType="com.atguigu.crowd.entity.po.MemberPO" >
    insert into t_member (id, loginacct, userpswd, 
      username, email, authstatus, 
      usertype, realname, cardnum, 
      accttype)
    values (#{id,jdbcType=INTEGER}, #{loginacct,jdbcType=VARCHAR}, #{userpswd,jdbcType=VARCHAR}, 
      #{username,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{authstatus,jdbcType=INTEGER}, 
      #{usertype,jdbcType=INTEGER}, #{realname,jdbcType=VARCHAR}, #{cardnum,jdbcType=VARCHAR}, 
      #{accttype,jdbcType=INTEGER})
  </insert>
  <insert id="insertSelective" parameterType="com.atguigu.crowd.entity.po.MemberPO" >
    insert into t_member
    <trim prefix="(" suffix=")" suffixOverrides="," >
      <if test="id != null" >
        id,
      </if>
      <if test="loginacct != null" >
        loginacct,
      </if>
      <if test="userpswd != null" >
        userpswd,
      </if>
      <if test="username != null" >
        username,
      </if>
      <if test="email != null" >
        email,
      </if>
      <if test="authstatus != null" >
        authstatus,
      </if>
      <if test="usertype != null" >
        usertype,
      </if>
      <if test="realname != null" >
        realname,
      </if>
      <if test="cardnum != null" >
        cardnum,
      </if>
      <if test="accttype != null" >
        accttype,
      </if>
    </trim>
    <trim prefix="values (" suffix=")" suffixOverrides="," >
      <if test="id != null" >
        #{id,jdbcType=INTEGER},
      </if>
      <if test="loginacct != null" >
        #{loginacct,jdbcType=VARCHAR},
      </if>
      <if test="userpswd != null" >
        #{userpswd,jdbcType=VARCHAR},
      </if>
      <if test="username != null" >
        #{username,jdbcType=VARCHAR},
      </if>
      <if test="email != null" >
        #{email,jdbcType=VARCHAR},
      </if>
      <if test="authstatus != null" >
        #{authstatus,jdbcType=INTEGER},
      </if>
      <if test="usertype != null" >
        #{usertype,jdbcType=INTEGER},
      </if>
      <if test="realname != null" >
        #{realname,jdbcType=VARCHAR},
      </if>
      <if test="cardnum != null" >
        #{cardnum,jdbcType=VARCHAR},
      </if>
      <if test="accttype != null" >
        #{accttype,jdbcType=INTEGER},
      </if>
    </trim>
  </insert>
  <select id="countByExample" parameterType="com.atguigu.crowd.entity.po.MemberPOExample" resultType="java.lang.Integer" >
    select count(*) from t_member
    <if test="_parameter != null" >
      <include refid="Example_Where_Clause" />
    </if>
  </select>
  <update id="updateByExampleSelective" parameterType="map" >
    update t_member
    <set >
      <if test="record.id != null" >
        id = #{record.id,jdbcType=INTEGER},
      </if>
      <if test="record.loginacct != null" >
        loginacct = #{record.loginacct,jdbcType=VARCHAR},
      </if>
      <if test="record.userpswd != null" >
        userpswd = #{record.userpswd,jdbcType=VARCHAR},
      </if>
      <if test="record.username != null" >
        username = #{record.username,jdbcType=VARCHAR},
      </if>
      <if test="record.email != null" >
        email = #{record.email,jdbcType=VARCHAR},
      </if>
      <if test="record.authstatus != null" >
        authstatus = #{record.authstatus,jdbcType=INTEGER},
      </if>
      <if test="record.usertype != null" >
        usertype = #{record.usertype,jdbcType=INTEGER},
      </if>
      <if test="record.realname != null" >
        realname = #{record.realname,jdbcType=VARCHAR},
      </if>
      <if test="record.cardnum != null" >
        cardnum = #{record.cardnum,jdbcType=VARCHAR},
      </if>
      <if test="record.accttype != null" >
        accttype = #{record.accttype,jdbcType=INTEGER},
      </if>
    </set>
    <if test="_parameter != null" >
      <include refid="Update_By_Example_Where_Clause" />
    </if>
  </update>
  <update id="updateByExample" parameterType="map" >
    update t_member
    set id = #{record.id,jdbcType=INTEGER},
      loginacct = #{record.loginacct,jdbcType=VARCHAR},
      userpswd = #{record.userpswd,jdbcType=VARCHAR},
      username = #{record.username,jdbcType=VARCHAR},
      email = #{record.email,jdbcType=VARCHAR},
      authstatus = #{record.authstatus,jdbcType=INTEGER},
      usertype = #{record.usertype,jdbcType=INTEGER},
      realname = #{record.realname,jdbcType=VARCHAR},
      cardnum = #{record.cardnum,jdbcType=VARCHAR},
      accttype = #{record.accttype,jdbcType=INTEGER}
    <if test="_parameter != null" >
      <include refid="Update_By_Example_Where_Clause" />
    </if>
  </update>
  <update id="updateByPrimaryKeySelective" parameterType="com.atguigu.crowd.entity.po.MemberPO" >
    update t_member
    <set >
      <if test="loginacct != null" >
        loginacct = #{loginacct,jdbcType=VARCHAR},
      </if>
      <if test="userpswd != null" >
        userpswd = #{userpswd,jdbcType=VARCHAR},
      </if>
      <if test="username != null" >
        username = #{username,jdbcType=VARCHAR},
      </if>
      <if test="email != null" >
        email = #{email,jdbcType=VARCHAR},
      </if>
      <if test="authstatus != null" >
        authstatus = #{authstatus,jdbcType=INTEGER},
      </if>
      <if test="usertype != null" >
        usertype = #{usertype,jdbcType=INTEGER},
      </if>
      <if test="realname != null" >
        realname = #{realname,jdbcType=VARCHAR},
      </if>
      <if test="cardnum != null" >
        cardnum = #{cardnum,jdbcType=VARCHAR},
      </if>
      <if test="accttype != null" >
        accttype = #{accttype,jdbcType=INTEGER},
      </if>
    </set>
    where id = #{id,jdbcType=INTEGER}
  </update>
  <update id="updateByPrimaryKey" parameterType="com.atguigu.crowd.entity.po.MemberPO" >
    update t_member
    set loginacct = #{loginacct,jdbcType=VARCHAR},
      userpswd = #{userpswd,jdbcType=VARCHAR},
      username = #{username,jdbcType=VARCHAR},
      email = #{email,jdbcType=VARCHAR},
      authstatus = #{authstatus,jdbcType=INTEGER},
      usertype = #{usertype,jdbcType=INTEGER},
      realname = #{realname,jdbcType=VARCHAR},
      cardnum = #{cardnum,jdbcType=VARCHAR},
      accttype = #{accttype,jdbcType=INTEGER}
    where id = #{id,jdbcType=INTEGER}
  </update>
</mapper>
```



## 6. `Api` 工程

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660873057527-e33e6a90-37b3-4e46-96c7-df60ed3138fe.png)

------

### 6.1 依赖

```xml
<dependencies>
    <dependency>
        <groupId>com.atguigu.crowd</groupId>
        <artifactId>atcrowdfunding05-common-util</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
    <dependency>
        <groupId>com.atguigu.crowd</groupId>
        <artifactId>atcrowdfunding09-member-entity</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-openfeign</artifactId>
    </dependency>
</dependencies>
```



### 6.2 接口

```java
package com.atguigu.crowd.api;

import com.atguigu.crowd.entity.po.MemberPO;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chenjianglin
 * @date 2022/8/19 09:05
 */
@FeignClient("atguigu-crowd-mysql")
public interface MySQLRemoteService {

    /**
     * 根据账号查询
     * 
     * @param loginacc 账号
     * @return
     */
    @RequestMapping("/get/memberpo/login/acct/remote")
    ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(@RequestParam("loginacc") String loginacc);

}
```



### 6.3 `MySQL`工程对外暴露服务

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660874434538-669f0b42-a24d-4844-8b9a-0ab06d2df13d.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660872968226-313cbd18-aebb-4ca0-becc-7fdcaebd4f4c.png)

------

#### 6.3.1 `Hnadler` 代码

```java
package com.atguigu.crowd.handler;

import com.atguigu.crowd.entity.po.MemberPO;
import com.atguigu.crowd.service.api.MemberService;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjianglin
 * @date 2022/8/19 09:11
 */
@RestController
public class MemberProviderHandler {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/get/memberpo/login/acct/remote")
    public ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(@RequestParam("loginacct") String loginacct) {
        try {
            // 调用本地 Service 完成查询
            MemberPO memberPO = memberService.getMemberPOByLoginAcct(loginacct);
            // 如果没有抛异常, 那么就返回成功的结果
            return ResultEntity.successWithData(memberPO);
        } catch (Exception e){
            // 如果捕获到异常则返回失败的结果
            return ResultEntity.failed(e.getMessage());
        }
    }
}
```

#### 6.3.2 `Service` 接口

```java
package com.atguigu.crowd.service.api;

import com.atguigu.crowd.entity.po.MemberPO;

/**
 * @author chenjianglin
 * @date 2022/8/19 09:15
 */
public interface MemberService {

    /**
     * 根据账号查询
     *
     * @param loginacct 账号
     * @return
     */
    MemberPO getMemberPOByLoginAcct(String loginacct);

}
```

#### 6.3.3 `Service` 类的代码

```java
package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.entity.po.MemberPO;
import com.atguigu.crowd.entity.po.MemberPOExample;
import com.atguigu.crowd.mapper.MemberPOMapper;
import com.atguigu.crowd.service.api.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ## 1.在类上使用 @Transactional(readOnly = true)
 * - 针对查询操作设置事务属性
 *
 * @author chenjianglin
 * @date 2022/8/19 09:16
 */
@Transactional(readOnly = true)
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberPOMapper memberPOMapper;

    @Override
    public MemberPO getMemberPOByLoginAcct(String loginacct) {
        // 创建 Example 对象
        MemberPOExample memberPOExample = new MemberPOExample();

        // 创建 Criteria 对象
        MemberPOExample.Criteria criteria = memberPOExample.createCriteria();

        // 封装查询条件
        criteria.andLoginacctEqualTo(loginacct);

        // 执行查询
        List<MemberPO> list = memberPOMapper.selectByExample(memberPOExample);

        // 5.获取结果
        if(list == null || list.size() == 0) {
            return null;
        }
        
        return list.get(0);
    }
}
```



## 7. `Redis` 工程

- 目标: 抽取项目中所有访问 `Redis` 的操作

### 7.1 `Linux` 自动安装 `Redis`

```bash
wget -c http://mirrors.linuxeye.com/oneinstack-full.tar.gz && tar xzf oneinstack-full.tar.gz && ./oneinstack/install.sh --redis 
```

- 修改redis的配置文件: `redis.conf`, 注释掉配置文件里的这一行: `bind 127.0.0.1`
- 将`protected-mode yes `改成:`protected-mode no` 意思是不使用密码登录

### 7.2 Reids 命令列表

| 命令                                                         | 说明                    |
| ------------------------------------------------------------ | ----------------------- |
| `/usr/local/redis/bin/redis-server /usr/local/redis/etc/redis.conf` | 启动 `Linux` 的 `Redis` |
| `ps -ef | grep redis | grep -v grep`                         | 查看 `Redis`            |
| `/usr/local/redis/bin/redis-cli -h 127.0.0.1`                | 登录 `Redis`            |
| `keys *`                                                     | 查看所有                |
|                                                              |                         |

#### 7.2.1 查看 `Redis`

```bash
ps -ef | grep redis | grep -v grep
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660876054593-ee6dedc3-0f21-4ca4-bc8a-9f4e8b3c5b27.png)



### 7.3 工程依赖

```xml
<dependencies>
    <!-- 整合 Redis -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>

    <!-- SpringBoot 测试 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>

<build>
    <plugins>
        <!-- 这个插件将 SpringBoot 应用打包成一个可执行的 jar 包 -->
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <executions>
                <execution>
                    <goals>
                        <goal>repackage</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```



### 7.4 主启动类

```java
package com.atguigu.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenjianglin
 * @date 2022/8/19 11:05
 */
@SpringBootApplication
public class CrowdMainClass {

    public static void main(String[] args) {
        SpringApplication.run(CrowdMainClass.class, args);
    }

}
```



### 7.5 测试类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1660955755275-432e9dd7-f4ca-4f41-9b66-7bf765b03458.png)

------

```java
package com.atguigu.crowd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chenjianglin
 * @date 2022/8/19 11:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    // private Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testSet(){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();

        operations.set("apple", "red");
    }

}
```



## 8. `Redis` 工程对外暴露服务

### 8.1 `API` 工程

#### 8.1.1 新建 `RedisRemoteService`接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661693533381-25454274-ea82-4072-b4ff-8ecfe4a2e96b.png)

```java
package com.atguigu.crowd.api;

import com.atguigu.crowd.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.TimeUnit;

/**
 * @author 陈江林
 * @date 2022/8/28 21:30
 */
@FeignClient("atguigu-crowd-redis")
public interface RedisRemoteService {

    /**
     * 保存
     * 
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("/set/Redis/Key/Value/Remote")
    ResultEntity<String> setRedisKeyValueRemote(
            @RequestParam("key") String key,
            @RequestParam("value") String value);

    /**
     * 设置带超时时间的
     * 
     * @param key
     * @param value
     * @param time  时间
     * @param timeUnit 时间单位
     * @return
     */
    @RequestMapping("/set/Redis/Key/Value/Remote/With/Timeout")
    ResultEntity<String> setRedisKeyValueRemoteWithTimeout(
            @RequestParam("key") String key,
            @RequestParam("value") String value,
            @RequestParam("time") long time,
            @RequestParam("timeUnit") TimeUnit timeUnit);

    /**
     * 根据 Key 获取
     * 
     * @param key
     * @return
     */
    @RequestMapping("get/Redis/Key/Value/By/Key")
    ResultEntity<String> getRedisKeyValueByKey(@RequestParam("key") String key);

    /**
     * 根据 Key 删除
     * 
     * @param key
     * @return
     */
    @RequestMapping("remove/Redis/Key/Remote")
    ResultEntity<String> removeRedisKeyRemote(@RequestParam("key") String key);

}
```



### 8.2 `Redis` 工程

#### 8.2.1 对外暴露服务 追加依赖

```xml
<!-- 对外暴露服务 -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- 为了能够使用工具类 -->
<dependency>
    <groupId>com.atguigu.crowd</groupId>
    <artifactId>atcrowdfunding05-common-util</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```



#### 8.2.2 追加 `RedisTest` 测试方法

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661693754588-d693a971-4c03-43d9-825c-6b35203fe027.png)

------

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661693807950-a6dd3c89-2645-47d4-878e-7499353994af.png)

```java
@Test 
public void testExSet() {
    ValueOperations<String, String> operations = redisTemplate.opsForValue();
    
    // 存活 5000 秒
    operations.set("banana", "yellow", 5000, TimeUnit.SECONDS);
}
```



#### 8.2.3 新建 `handler` 包, 新建 `RedisHandler` 类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661694452017-1143ea90-2378-45f8-9751-dfb107d6265a.png)

```java
package com.atguigu.crowd.handler;

import com.atguigu.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author 陈江林
 * @date 2022/8/28 21:39
 */
@RestController
public class RedisHandler {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 保存
     * 
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("/set/Redis/Key/Value/Remote")
    ResultEntity<String> setRedisKeyValueRemote(
            @RequestParam("key") String key,
            @RequestParam("value") String value) {
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key, value);

            return ResultEntity.successWithoutData();
        } catch(Exception e) {
            return ResultEntity.failed(e.getMessage());
        }
    }

    /**
     * 设置带超时时间的
     * 
     * @param key
     * @param value
     * @param time 时间
     * @param timeUnit 时间单位
     * @return
     */
    @RequestMapping("/set/Redis/Key/Value/Remote/With/Timeout")
    ResultEntity<String> setRedisKeyValueRemoteWithTimeout(
            @RequestParam("key") String key,
            @RequestParam("value") String value,
            @RequestParam("time") long time,
            @RequestParam("timeUnit") TimeUnit timeUnit) {
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key, value, time, timeUnit);

            return ResultEntity.successWithoutData();
        } catch(Exception e) {
            return ResultEntity.failed(e.getMessage());
        }
    }

    /**
     * 根据 Key 获取
     * 
     * @param key
     * @return
     */
    @RequestMapping("get/Redis/Key/Value/By/Key")
    ResultEntity<String> getRedisKeyValueByKey(@RequestParam("key") String key) {
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            String value = operations.get(key);

            return ResultEntity.successWithData(value);
        } catch(Exception e) {
            return ResultEntity.failed(e.getMessage());
        }
    }

    /**
     * 根据 Key 删除
     * 
     * @param key
     * @return
     */
    @RequestMapping("remove/Redis/Key/Remote")
    ResultEntity<String> removeRedisKeyRemote(@RequestParam("key") String key) {
        try {
            redisTemplate.delete(key);

            return ResultEntity.successWithoutData();
        } catch(Exception e) {
            return ResultEntity.failed(e.getMessage());
        }
    }
}
```



## 9. `authentication` 会员中心工程

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661697476147-0cd37190-ad03-45fc-b846-7f553c6858a4.png)

------

### 9.1 依赖

```xml
<dependencies>
  <!-- 对外暴露服务 -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  
  <!-- 整合视图 -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
  </dependency>
  
  <!-- 作为客户端访问 Eureka 注册中心 -->
  <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
  </dependency>
  
  <dependency>
      <groupId>com.atguigu.crowd</groupId>
      <artifactId>atcrowdfunding17-member-api</artifactId>
      <version>1.0-SNAPSHOT</version>
  </dependency>
</dependencies>

<build>
    <plugins>
        <!-- 这个插件将 SpringBoot 应用打包成一个可执行的 jar 包 -->
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <executions>
                <execution>
                    <goals>
                        <goal>repackage</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```



### 9.2 新建 `CrowdMainClass` 主启动类

```java
package com.atguigu.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * `@EnableFeignClients` 启用 Feign 客户端功能
 * `@EnableDiscoveryClient` 当前版本可以不写
 *
 * @author 陈江林
 * @date 2022/8/28 21:51
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class CrowdMainClass {

    public static void main(String[] args) {
        SpringApplication.run(CrowdMainClass.class, args);
    }

}
```



### 9.3 新建 `application.yml` 配置

```yaml
server:
  port: 4000

spring:
  application:
    name: atguigu-crowd-auth

eureka:
  client:
    service-url:
      defaultZone: http://localhost:1000/eureka

ribbon:
  # 10秒 - 处理请求的超时时间，默认为5秒
  ReadTimeout: 10000
  # 10秒 - 连接建立的超时时长，默认5秒
  ConnectTimeout: 10000
```



#### 9.3.1 新建包 `templates`、`static`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661696005316-59625806-3823-456f-a226-213501b49623.png)



### 9.4 新建 `PortalHandler` 类

```java
package com.atguigu.crowd.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 陈江林
 * @date 2022/8/28 22:14
 */
@Controller
public class PortalHandler {

    /**
     * 显示首页
     * 
     * @return
     */
    @RequestMapping("/")
    public String toPortalPage() {
        // 这里实际开发中需要获取数据

        return "portal";
    }

}
```



### 9.5 新建 `portal.html` 首页

```html
<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="https://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <base th:href="@{/}">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/carousel.css">
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="script/docs.min.js"></script>
    <script src="script/back-to-top.js"></script>
    <script>
        $(".thumbnail img").css("cursor", "pointer");
        $(".thumbnail img").click(function () {
            window.location.href = "project.html";
        });
    </script>
    <style>
        h3 {
            font-weight: bold;
        }

        #footer {
            padding: 15px 0;
            background: #fff;
            border-top: 1px solid #ddd;
            text-align: center;
        }

        #topcontrol {
            color: #fff;
            z-index: 99;
            width: 30px;
            height: 30px;
            font-size: 20px;
            background: #222;
            position: relative;
            right: 14px !important;
            bottom: 11px !important;
            border-radius: 3px !important;
        }

        #topcontrol:after {
            /*top: -2px;*/
            left: 8.5px;
            content: "\f106";
            position: absolute;
            text-align: center;
            font-family: FontAwesome;
        }

        #topcontrol:hover {
            color: #fff;
            background: #18ba9b;
            -webkit-transition: all 0.3s ease-in-out;
            -moz-transition: all 0.3s ease-in-out;
            -o-transition: all 0.3s ease-in-out;
            transition: all 0.3s ease-in-out;
        }

        /* 侧栏导航 */
        .sideBox {
            padding: 10px;
            height: 220px;
            background: #fff;
            margin-bottom: 10px;
            overflow: hidden;
        }

        .sideBox .hd {
            height: 30px;
            line-height: 30px;
            background: #f60;
            padding: 0 10px;
            text-align: center;
            overflow: hidden;
        }

        .sideBox .hd .more {
            color: #fff;
        }

        .sideBox .hd h3 span {
            font-weight: bold;
            font-size: 14px;
            color: #fff;
        }

        .sideBox .bd {
            padding: 5px 0 0;
        }

        #sideMenu .bd li {
            margin-bottom: 2px;
            height: 30px;
            line-height: 30px;
            text-align: center;
            overflow: hidden;
        }

        #sideMenu .bd li a {
            display: block;
            background: #EAE6DD;
        }

        #sideMenu .bd li a:hover {
            background: #D5CFBF;
        }

        /* 列表页 */
        #mainBox {
            margin-bottom: 10px;
            padding: 10px;
            background: #fff;
            overflow: hidden;
        }

        #mainBox .mHd {
            border-bottom: 2px solid #09c;
            height: 30px;
            line-height: 30px;
        }

        #mainBox .mHd h3 {
            display: initial;
            *display: inline;
            zoom: 1;
            padding: 0 15px;
            background: #09c;
            color: #fff;
        }

        #mainBox .mHd h3 span {
            color: #fff;
            font-size: 14px;
            font-weight: bold;
        }

        #mainBox .path {
            float: right;
        }

        /* 位置导航 */
        .path {
            height: 30px;
            line-height: 30px;
            padding-left: 10px;
        }

        .path a, .path span {
            margin: 0 5px;
        }

        /* 文章列表 */
        .newsList {
            padding: 10px;
            text-align: left;
        }

        .newsList li {
            background: url("../images/share/point.png") no-repeat 2px 14px;
            padding-left: 10px;
            height: 30px;
            line-height: 30px;
        }

        .newsList li a {
            display: inline-block;
            *display: inline;
            zoom: 1;
            font-size: 14px;
        }

        .newsList li .date {
            float: right;
            color: #999;
        }

        .newsList li.split {
            margin-bottom: 10px;
            padding-bottom: 10px;
            border-bottom: 1px dotted #ddd;
            height: 0px;
            line-height: 0px;
            overflow: hidden;
        }

        /* 通用带图片的信息列表_普通式 */
        .picList {
            padding: 10px;
            text-align: left;
        }

        .picList li {
            margin: 0 5px;
            height: 190px;
        }

        h3.break {
            font-size: 16px;
            display: block;
            white-space: nowrap;
            word-wrap: normal;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        h3.break > a {
            text-decoration: none;
        }

    </style>
</head>
<body>
<div class="navbar-wrapper">
    <div class="container">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse" style="float:right;">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="login.html">登录</a></li>
                        <li><a href="reg.html">注册</a></li>
                        <li><a>|</a></li>
                        <li><a href="admin-login.html">管理员入口</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>


<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active" onclick="window.location.href='project.html'" style="cursor:pointer;">
            <img src="img/carousel-1.jpg" alt="First slide">
        </div>
        <div class="item" onclick="window.location.href='project.html'" style="cursor:pointer;">
            <img src="img/carousel-2.jpg" alt="Second slide">
        </div>
        <div class="item" onclick="window.location.href='project.html'" style="cursor:pointer;">
            <img src="img/carousel-3.jpg" alt="Third slide">
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
        <span class="sr-only">Next</span>
    </a>
</div><!-- /.carousel -->


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            <img class="img-circle" src="img/p1.jpg" alt="Generic placeholder image"
                 style="width: 140px; height: 140px;">
            <h2>智能高清监控机器人</h2>
            <p>可爱的造型，摄像安防远程互联的全能设计，让你随时随地守护您的家人，陪伴你的生活。</p>
            <p><a class="btn btn-default" href="project.html" role="button">项目详情 &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle" src="img/p2.jpg" alt="Generic placeholder image"
                 style="width: 140px; height: 140px;">
            <h2>NEOKA智能手环</h2>
            <p>要运动更要安全，这款、名为“蝶舞”的NEOKA-V9100智能运动手环为“安全运动而生”。</p>
            <p><a class="btn btn-default" href="project.html" role="button">项目详情 &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle" src="img/p3.png" alt="Generic placeholder image"
                 style="width: 140px; height: 140px;">
            <h2>驱蚊扣</h2>
            <p>随处使用的驱蚊纽扣，<br>解决夏季蚊虫问题。</p>
            <p><a class="btn btn-default" href="project.html" role="button">项目详情 &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="box ui-draggable" id="mainBox">
                    <div class="mHd" style="">
                        <div class="path">
                            <a href="projects.html">更多...</a>
                        </div>
                        <h3>
                            科技 <small style="color:#FFF;">开启智慧未来</small>
                        </h3>
                    </div>
                    <div class="mBd" style="padding-top:10px;">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="thumbnail">
                                    <img alt="300x200" src="img/product-1.jpg"/>
                                    <div class="caption">
                                        <h3 class="break">
                                            <a href="project.html">活性富氢净水直饮机</a>
                                        </h3>
                                        <p>
                                        <div style="float:left;"><i class="glyphicon glyphicon-screenshot"
                                                                    title="目标金额"></i> $20,000
                                        </div>
                                        <div style="float:right;"><i title="截至日期"
                                                                     class="glyphicon glyphicon-calendar"></i>
                                            2017-20-20
                                        </div>
                                        </p>
                                        <br>
                                        <div class="progress" style="margin-bottom: 4px;">
                                            <div class="progress-bar progress-bar-success" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 40%">
                                                <span>40% </span>
                                            </div>
                                        </div>
                                        <div><span style="float:right;"><i
                                                class="glyphicon glyphicon-star-empty"></i></span> <span><i
                                                class="glyphicon glyphicon-user" title="支持人数"></i> 12345</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="thumbnail">
                                    <img alt="300x200" src="img/product-2.gif"/>
                                    <div class="caption">
                                        <h3 class="break">
                                            <a href="project.html">酷驰触控龙头，智享厨房黑科技</a>
                                        </h3>
                                        <p>
                                        <div style="float:left;"><i class="glyphicon glyphicon-screenshot"
                                                                    title="目标金额"></i> $20,000
                                        </div>
                                        <div style="float:right;"><i title="截至日期"
                                                                     class="glyphicon glyphicon-calendar"></i>
                                            2017-20-20
                                        </div>
                                        </p>
                                        <br>
                                        <div class="progress" style="margin-bottom: 4px;">
                                            <div class="progress-bar progress-bar-success" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 40%">
                                                <span>40% </span>
                                            </div>
                                        </div>
                                        <div><span style="float:right;"><i
                                                class="glyphicon glyphicon-star-empty"></i></span> <span><i
                                                class="glyphicon glyphicon-user" title="支持人数"></i> 12345</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="thumbnail">
                                    <img alt="300x200" src="img/product-3.png"/>
                                    <div class="caption">
                                        <h3 class="break">
                                            <a href="project.html">小熊猫鱼眼全景安防摄像机</a>
                                        </h3>
                                        <p>
                                        <div style="float:left;"><i class="glyphicon glyphicon-screenshot"
                                                                    title="目标金额"></i> $20,000
                                        </div>
                                        <div style="float:right;"><i title="截至日期"
                                                                     class="glyphicon glyphicon-calendar"></i>
                                            2017-20-20
                                        </div>
                                        </p>
                                        <br>
                                        <div class="progress" style="margin-bottom: 4px;">
                                            <div class="progress-bar progress-bar-success" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 40%">
                                                <span>40% </span>
                                            </div>
                                        </div>
                                        <div><span style="float:right;"><i
                                                class="glyphicon glyphicon-star-empty"></i></span> <span><i
                                                class="glyphicon glyphicon-user" title="支持人数"></i> 12345</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="thumbnail">
                                    <img alt="300x200" src="img/product-4.jpg"/>
                                    <div class="caption">
                                        <h3 class="break">
                                            <a href="project.html">一款精致的机械表</a>
                                        </h3>
                                        <p>
                                        <div style="float:left;"><i class="glyphicon glyphicon-screenshot"
                                                                    title="目标金额"></i> $20,000
                                        </div>
                                        <div style="float:right;"><i title="截至日期"
                                                                     class="glyphicon glyphicon-calendar"></i>
                                            2017-20-20
                                        </div>
                                        </p>
                                        <br>
                                        <div class="progress" style="margin-bottom: 4px;">
                                            <div class="progress-bar progress-bar-success" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 40%">
                                                <span>40% </span>
                                            </div>
                                        </div>
                                        <div><span style="float:right;"><i
                                                class="glyphicon glyphicon-star-empty"></i></span> <span><i
                                                class="glyphicon glyphicon-user" title="支持人数"></i> 12345</span></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="box ui-draggable" id="mainBox">
                    <div class="mHd" style="">
                        <div class="path">
                            <a href="projects.html">更多...</a>
                        </div>
                        <h3>
                            设计 <small style="color:#FFF;">创意改变生活</small>
                        </h3>
                    </div>
                    <div class="mBd" style="padding-top:10px;">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="thumbnail">
                                    <img alt="300x200" src="img/product-5.jpg"/>
                                    <div class="caption">
                                        <h3 class="break">
                                            <a href="project.html">活性富氢净水直饮机</a>
                                        </h3>
                                        <p>
                                        <div style="float:left;"><i class="glyphicon glyphicon-screenshot"
                                                                    title="目标金额"></i> $20,000
                                        </div>
                                        <div style="float:right;"><i title="截至日期"
                                                                     class="glyphicon glyphicon-calendar"></i>
                                            2017-20-20
                                        </div>
                                        </p>
                                        <br>
                                        <div class="progress" style="margin-bottom: 4px;">
                                            <div class="progress-bar progress-bar-success" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 40%">
                                                <span>40% </span>
                                            </div>
                                        </div>
                                        <div><span style="float:right;"><i
                                                class="glyphicon glyphicon-star-empty"></i></span> <span><i
                                                class="glyphicon glyphicon-user" title="支持人数"></i> 12345</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="thumbnail">
                                    <img alt="300x200" src="img/product-6.jpg"/>
                                    <div class="caption">
                                        <h3 class="break">
                                            <a href="project.html">酷驰触控龙头，智享厨房黑科技</a>
                                        </h3>
                                        <p>
                                        <div style="float:left;"><i class="glyphicon glyphicon-screenshot"
                                                                    title="目标金额"></i> $20,000
                                        </div>
                                        <div style="float:right;"><i title="截至日期"
                                                                     class="glyphicon glyphicon-calendar"></i>
                                            2017-20-20
                                        </div>
                                        </p>
                                        <br>
                                        <div class="progress" style="margin-bottom: 4px;">
                                            <div class="progress-bar progress-bar-success" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 40%">
                                                <span>40% </span>
                                            </div>
                                        </div>
                                        <div><span style="float:right;"><i
                                                class="glyphicon glyphicon-star-empty"></i></span> <span><i
                                                class="glyphicon glyphicon-user" title="支持人数"></i> 12345</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="thumbnail">
                                    <img alt="300x200" src="img/product-7.jpg"/>
                                    <div class="caption">
                                        <h3 class="break">
                                            <a href="project.html">小熊猫鱼眼全景安防摄像机</a>
                                        </h3>
                                        <p>
                                        <div style="float:left;"><i class="glyphicon glyphicon-screenshot"
                                                                    title="目标金额"></i> $20,000
                                        </div>
                                        <div style="float:right;"><i title="截至日期"
                                                                     class="glyphicon glyphicon-calendar"></i>
                                            2017-20-20
                                        </div>
                                        </p>
                                        <br>
                                        <div class="progress" style="margin-bottom: 4px;">
                                            <div class="progress-bar progress-bar-success" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 40%">
                                                <span>40% </span>
                                            </div>
                                        </div>
                                        <div><span style="float:right;"><i
                                                class="glyphicon glyphicon-star-empty"></i></span> <span><i
                                                class="glyphicon glyphicon-user" title="支持人数"></i> 12345</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="thumbnail">
                                    <img alt="300x200" src="img/product-8.jpg"/>
                                    <div class="caption">
                                        <h3 class="break">
                                            <a href="project.html">一款精致的机械表</a>
                                        </h3>
                                        <p>
                                        <div style="float:left;"><i class="glyphicon glyphicon-screenshot"
                                                                    title="目标金额"></i> $20,000
                                        </div>
                                        <div style="float:right;"><i title="截至日期"
                                                                     class="glyphicon glyphicon-calendar"></i>
                                            2017-20-20
                                        </div>
                                        </p>
                                        <br>
                                        <div class="progress" style="margin-bottom: 4px;">
                                            <div class="progress-bar progress-bar-success" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 40%">
                                                <span>40% </span>
                                            </div>
                                        </div>
                                        <div><span style="float:right;"><i
                                                class="glyphicon glyphicon-star-empty"></i></span> <span><i
                                                class="glyphicon glyphicon-user" title="支持人数"></i> 12345</span></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="box ui-draggable" id="mainBox">
                    <div class="mHd" style="">
                        <div class="path">
                            <a href="projects.html">更多...</a>
                        </div>
                        <h3>
                            农业 <small style="color:#FFF;">网络天下肥美</small>
                        </h3>
                    </div>
                    <div class="mBd" style="padding-top:10px;">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="thumbnail">
                                    <img alt="300x200" src="img/product-9.jpg"/>
                                    <div class="caption">
                                        <h3 class="break">
                                            <a href="project.html">活性富氢净水直饮机</a>
                                        </h3>
                                        <p>
                                        <div style="float:left;"><i class="glyphicon glyphicon-screenshot"
                                                                    title="目标金额"></i> $20,000
                                        </div>
                                        <div style="float:right;"><i title="截至日期"
                                                                     class="glyphicon glyphicon-calendar"></i>
                                            2017-20-20
                                        </div>
                                        </p>
                                        <br>
                                        <div class="progress" style="margin-bottom: 4px;">
                                            <div class="progress-bar progress-bar-success" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 40%">
                                                <span>40% </span>
                                            </div>
                                        </div>
                                        <div><span style="float:right;"><i
                                                class="glyphicon glyphicon-star-empty"></i></span> <span><i
                                                class="glyphicon glyphicon-user" title="支持人数"></i> 12345</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="thumbnail">
                                    <img alt="300x200" src="img/product-2.gif"/>
                                    <div class="caption">
                                        <h3 class="break">
                                            <a href="project.html">酷驰触控龙头，智享厨房黑科技</a>
                                        </h3>
                                        <p>
                                        <div style="float:left;"><i class="glyphicon glyphicon-screenshot"
                                                                    title="目标金额"></i> $20,000
                                        </div>
                                        <div style="float:right;"><i title="截至日期"
                                                                     class="glyphicon glyphicon-calendar"></i>
                                            2017-20-20
                                        </div>
                                        </p>
                                        <br>
                                        <div class="progress" style="margin-bottom: 4px;">
                                            <div class="progress-bar progress-bar-success" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 40%">
                                                <span>40% </span>
                                            </div>
                                        </div>
                                        <div><span style="float:right;"><i
                                                class="glyphicon glyphicon-star-empty"></i></span> <span><i
                                                class="glyphicon glyphicon-user" title="支持人数"></i> 12345</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="thumbnail">
                                    <img alt="300x200" src="img/product-3.png"/>
                                    <div class="caption">
                                        <h3 class="break">
                                            <a href="project.html">小熊猫鱼眼全景安防摄像机</a>
                                        </h3>
                                        <p>
                                        <div style="float:left;"><i class="glyphicon glyphicon-screenshot"
                                                                    title="目标金额"></i> $20,000
                                        </div>
                                        <div style="float:right;"><i title="截至日期"
                                                                     class="glyphicon glyphicon-calendar"></i>
                                            2017-20-20
                                        </div>
                                        </p>
                                        <br>
                                        <div class="progress" style="margin-bottom: 4px;">
                                            <div class="progress-bar progress-bar-success" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 40%">
                                                <span>40% </span>
                                            </div>
                                        </div>
                                        <div><span style="float:right;"><i
                                                class="glyphicon glyphicon-star-empty"></i></span> <span><i
                                                class="glyphicon glyphicon-user" title="支持人数"></i> 12345</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="thumbnail">
                                    <img alt="300x200" src="img/product-4.jpg"/>
                                    <div class="caption">
                                        <h3 class="break">
                                            <a href="project.html">一款精致的机械表</a>
                                        </h3>
                                        <p>
                                        <div style="float:left;"><i class="glyphicon glyphicon-screenshot"
                                                                    title="目标金额"></i> $20,000
                                        </div>
                                        <div style="float:right;"><i title="截至日期"
                                                                     class="glyphicon glyphicon-calendar"></i>
                                            2017-20-20
                                        </div>
                                        </p>
                                        <br>
                                        <div class="progress" style="margin-bottom: 4px;">
                                            <div class="progress-bar progress-bar-success" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 40%">
                                                <span>40% </span>
                                            </div>
                                        </div>
                                        <div><span style="float:right;"><i
                                                class="glyphicon glyphicon-star-empty"></i></span> <span><i
                                                class="glyphicon glyphicon-user" title="支持人数"></i> 12345</span></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="box ui-draggable" id="mainBox">
                    <div class="mHd" style="">
                        <div class="path">
                            <a href="projects.html">更多...</a>
                        </div>
                        <h3>
                            其他 <small style="color:#FFF;">发现更多惊喜</small>
                        </h3>
                    </div>
                    <div class="mBd" style="padding-top:10px;">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="thumbnail">
                                    <img alt="300x200" src="img/product-1.jpg"/>
                                    <div class="caption">
                                        <h3 class="break">
                                            <a href="project.html">活性富氢净水直饮机</a>
                                        </h3>
                                        <p>
                                        <div style="float:left;"><i class="glyphicon glyphicon-screenshot"
                                                                    title="目标金额"></i> $20,000
                                        </div>
                                        <div style="float:right;"><i title="截至日期"
                                                                     class="glyphicon glyphicon-calendar"></i>
                                            2017-20-20
                                        </div>
                                        </p>
                                        <br>
                                        <div class="progress" style="margin-bottom: 4px;">
                                            <div class="progress-bar progress-bar-success" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 40%">
                                                <span>40% </span>
                                            </div>
                                        </div>
                                        <div><span style="float:right;"><i
                                                class="glyphicon glyphicon-star-empty"></i></span> <span><i
                                                class="glyphicon glyphicon-user" title="支持人数"></i> 12345</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="thumbnail">
                                    <img alt="300x200" src="img/product-2.gif"/>
                                    <div class="caption">
                                        <h3 class="break">
                                            <a href="project.html">酷驰触控龙头，智享厨房黑科技</a>
                                        </h3>
                                        <p>
                                        <div style="float:left;"><i class="glyphicon glyphicon-screenshot"
                                                                    title="目标金额"></i> $20,000
                                        </div>
                                        <div style="float:right;"><i title="截至日期"
                                                                     class="glyphicon glyphicon-calendar"></i>
                                            2017-20-20
                                        </div>
                                        </p>
                                        <br>
                                        <div class="progress" style="margin-bottom: 4px;">
                                            <div class="progress-bar progress-bar-success" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 40%">
                                                <span>40% </span>
                                            </div>
                                        </div>
                                        <div><span style="float:right;"><i
                                                class="glyphicon glyphicon-star-empty"></i></span> <span><i
                                                class="glyphicon glyphicon-user" title="支持人数"></i> 12345</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="thumbnail">
                                    <img alt="300x200" src="img/product-3.png"/>
                                    <div class="caption">
                                        <h3 class="break">
                                            <a href="project.html">小熊猫鱼眼全景安防摄像机</a>
                                        </h3>
                                        <p>
                                        <div style="float:left;"><i class="glyphicon glyphicon-screenshot"
                                                                    title="目标金额"></i> $20,000
                                        </div>
                                        <div style="float:right;"><i title="截至日期"
                                                                     class="glyphicon glyphicon-calendar"></i>
                                            2017-20-20
                                        </div>
                                        </p>
                                        <br>
                                        <div class="progress" style="margin-bottom: 4px;">
                                            <div class="progress-bar progress-bar-success" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 40%">
                                                <span>40% </span>
                                            </div>
                                        </div>
                                        <div><span style="float:right;"><i
                                                class="glyphicon glyphicon-star-empty"></i></span> <span><i
                                                class="glyphicon glyphicon-user" title="支持人数"></i> 12345</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="thumbnail">
                                    <img alt="300x200" src="img/product-4.jpg"/>
                                    <div class="caption">
                                        <h3 class="break">
                                            <a href="project.html">一款精致的机械表</a>
                                        </h3>
                                        <p>
                                        <div style="float:left;"><i class="glyphicon glyphicon-screenshot"
                                                                    title="目标金额"></i> $20,000
                                        </div>
                                        <div style="float:right;"><i title="截至日期"
                                                                     class="glyphicon glyphicon-calendar"></i>
                                            2017-20-20
                                        </div>
                                        </p>
                                        <br>
                                        <div class="progress" style="margin-bottom: 4px;">
                                            <div class="progress-bar progress-bar-success" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 40%">
                                                <span>40% </span>
                                            </div>
                                        </div>
                                        <div><span style="float:right;"><i
                                                class="glyphicon glyphicon-star-empty"></i></span> <span><i
                                                class="glyphicon glyphicon-user" title="支持人数"></i> 12345</span></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <!-- FOOTER -->
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div id="footer">
                    <div class="footerNav">
                        <a rel="nofollow" href="http://www.atguigu.com">关于我们</a> | <a rel="nofollow"
                                                                                      href="http://www.atguigu.com">服务条款</a>
                        | <a rel="nofollow" href="http://www.atguigu.com">免责声明</a> | <a rel="nofollow"
                                                                                        href="http://www.atguigu.com">网站地图</a>
                        | <a rel="nofollow" href="http://www.atguigu.com">联系我们</a>
                    </div>
                    <div class="copyRight">
                        Copyright ?2017-2017atguigu.com 版权所有
                    </div>
                </div>

            </div>
        </div>
    </div>

</div><!-- /.container -->
</body>
</html>
```

- `<baseth:href="@{/}">`

    - 就算配置 `server.servlet.context-path: /aaa`, 也可以正常访问



### 9.6 `static` 资源

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661696345312-26f74d50-297f-46d8-b470-3a3ea367f66a.png)

- `SpringBoot` 要求在 `static` 中存放静态资源 ,复制到 `static` 文件夹中

    - 资源包:  [📎static.zip](https://www.yuque.com/attachments/yuque/0/2022/zip/12811585/1660963709173-585dad43-5a60-45b4-9fa2-97457f611bcf.zip)



## 10. `Zuul` 网关项目

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661699552724-09ee472d-28b1-43c6-ad01-170e80d058f0.png)

------

### 10.1 依赖

```xml
<dependencies>
    <!-- 作为客户端访问 Eureka 注册中心 -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
    
    <!-- 整合 Zuul 网关 -->
  	<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-zuul</artifactId>
		</dependency>
</dependencies>

<build>
    <plugins>
        <!-- 这个插件将 SpringBoot 应用打包成一个可执行的 jar 包 -->
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <executions>
                <execution>
                    <goals>
                        <goal>repackage</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```



### 10.2 新建 `CrowdMainClass` 主启动类

```java
package com.atguigu.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * `@EnableZuulProxy` 启动 zuul 代理功能
 * 
 * @author 陈江林
 * @date 2022/8/28 22:26
 */
@EnableZuulProxy
@SpringBootApplication
public class CrowdMainClass {

    public static void main(String[] args) {
        SpringApplication.run(CrowdMainClass.class, args);
    }

}
```



### 10.3 新建 `application.yml` 配置

```yaml
server:
  port: 80

spring:
  application:
    name: atguigu-crowd-zuul

eureka:
  client:
    service-url:
      defaultZone: http://localhost:1000/eureka

zuul:
  # 忽略原本的微服务名称
  ignored-services: "*"
  # 在 zuul 中其他微服务重定向时保持原本的头信息（请求头、响应头）
  sensitive-headers: "*"
  routes:
    crowd-portal:
      service-id: atguigu-crowd-auth
      path: /**

ribbon:
  # 10秒 - 处理请求的超时时间，默认为5秒
  ReadTimeout: 10000
  # 10秒 - 连接建立的超时时长，默认5秒
  ConnectTimeout: 10000
```



## 11. 关于第一次请求超时

- 由于在第一次请求中需要建立缓存、建立连接, 操作较多, 所以比较耗时
- 如果按照默认的 `ribbon` 超时时间来工作, 第一次请求会超过这个时间导致超时报错
- 为了避免这个问题, 把 `ribbon` 的超时时间延长
- `application.yml` 中配置

```yaml
ribbon:
  # 10秒 - 处理请求的超时时间，默认为5秒
  ReadTimeout: 10000
  # 10秒 - 连接建立的超时时长，默认5秒
  ConnectTimeout: 10000
```