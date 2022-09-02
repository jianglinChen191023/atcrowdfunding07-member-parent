- [十六 会员系统-搭建环境](#十六-会员系统-搭建环境)
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
        - [7.5 新建 `application.yml` 配置](#75-新建-applicationyml-配置)
        - [7.6 测试类](#76-测试类)
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

- [十七 会员注册](#十七-会员注册)
    - [1. 调用第三方短信接口](#1-调用第三方短信接口)
        - [1.1 追加依赖【`common`工程】](#11-追加依赖common工程)
        - [1.2 新建 `HttpUtils` 类【`common`工程】](#12-新建-httputils-类common工程)
        - [1.3 新建 `CrowdTest` 测试类【`auth` 工程】](#13-新建-crowdtest-测试类auth-工程)
            - [1.3.1 前置: 追加依赖](#131-前置-追加依赖)
        - [1.4 `CrowdUtil` 追加方法【`common`工程】](#14-crowdutil-追加方法common工程)
    - [2. 发送验证码【`auth` 工程】](#2-发送验证码auth-工程)
        - [2.1 配置跳转路径和对应的页面](#21-配置跳转路径和对应的页面)
            - [2.1.1 新建 `CrowdWebMvcConfig` 类](#211-新建-crowdwebmvcconfig-类)
        - [2.2 修改代码 `portal.html`](#22-修改代码-portalhtml)
        - [2.3 新建 `member-reg.html` 注册页面](#23-新建-member-reghtml-注册页面)
            - [2.3.1 添加 `layer`到 `static` 下 📎layer.zip](#231-添加-layer到-static-下-layerzip)
        - [2.4 追加依赖](#24-追加依赖)
        - [2.5 新建 `ShortMessageProperties` 类](#25-新建-shortmessageproperties-类)
        - [2.6 追加配置](#26-追加配置)
        - [2.7 新建 `MemberHandler` 发送短信](#27-新建-memberhandler-发送短信)
        - [2.8 追加代码 `CrowdConstant`【`common`】](#28-追加代码-crowdconstantcommon)
    - [3. 执行注册流程](#3-执行注册流程)
        - [3.1 追加代码 `MySQLRemoteService`【`API` 工程】](#31-追加代码-mysqlremoteserviceapi-工程)
        - [3.2 `MySQL` 项目](#32-mysql-项目)
            - [3.2.1 追加代码 `MemberProviderHandler`](#321-追加代码-memberproviderhandler)
            - [3.2.2 追加代码 `MemberService`](#322-追加代码-memberservice)
            - [3.2.3 追加代码 `MemberServiceImpl`](#323-追加代码-memberserviceimpl)
        - [3.3 测试 `http://localhost:2000/save/member/remote`](#33-测试-httplocalhost2000savememberremote)
        - [3.4 `Entity` 工程](#34-entity-工程)
            - [3.4.1 新建 `MemberVO` 封装表单数据](#341-新建-membervo-封装表单数据)
        - [3.5 `Auth` 项目](#35-auth-项目)
            - [3.5.1 追加代码 `MemberHandler`](#351-追加代码-memberhandler)
            - [3.5.2 登录页面 `member-login.html`](#352-登录页面-member-loginhtml)
        - [3.6 `Common` 工程](#36-common-工程)
            - [3.6.1 追加代码 `CrowdContant`](#361-追加代码-crowdcontant)

- [十八 会员登录](#十八-会员登录)
    - [1. 登录流程](#1-登录流程)
        - [1.1 `Entity`](#11-entity)
            - [1.1.1 新建 `MemberLoginVO`](#111-新建-memberloginvo)
        - [1.2 `Auth` 工程](#12-auth-工程)
            - [1.2.1 修改代码 `member-login.html`](#121-修改代码-member-loginhtml)
            - [1.2.2 追加代码 `MemberHandler`](#122-追加代码-memberhandler)
            - [1.2.3 追加代码 `CrowdWebMvcConfig` 设置跳转页面](#123-追加代码-crowdwebmvcconfig-设置跳转页面)
            - [1.2.4 新建页面 `member-conter.html`](#124-新建页面-member-conterhtml)
    - [2. 会员退出登录](#2-会员退出登录)
        - [2.1 `auth` 工程](#21-auth-工程)
            - [2.1.1 修改代码`member-conter.html`](#211-修改代码member-conterhtml)
            - [2.1.2 追加代码 `MemberHandler`](#212-追加代码-memberhandler)
    - [3. 知识点: Session 共享, 解决 Session 不互通的问题](#3-知识点-session-共享-解决-session-不互通的问题)
        - [3.1 会话控制回顾](#31-会话控制回顾)
            - [3.1.1 Cookie 的工作机制](#311-cookie-的工作机制)
            - [3.1.2 Session 的工作机制](#312-session-的工作机制)
        - [3.2 解决方案探索](#32-解决方案探索)
            - [3.2.1 Session 同步](#321-session-同步)
            - [3.2.2 将 `Session` 数据存储在 `Cookie` 中](#322-将-session-数据存储在-cookie-中)
            - [3.2.3 反向代理 `hash` 一致性](#323-反向代理-hash-一致性)
            - [3.2.4 后端统一存储 Session 数据](#324-后端统一存储-session-数据)
        - [3.3 `SpringSession` 使用](#33-springsession-使用)
            - [3.3.1 共同代码](#331-共同代码)
                - [3.3.1.1 引入依赖](#3311-引入依赖)
                - [3.3.1.2 新建 `MainClass` 主启动类](#3312-新建-mainclass-主启动类)
                - [3.3.1.3 新建 `application.yml` 配置](#3313-新建-applicationyml-配置)
            - [3.3.2 `pro18-spring-session-a`](#332-pro18-spring-session-a)
                - [3.3.2.1 新建 `HelloHandler` 类](#3321-新建-hellohandler-类)
            - [3.3.3 `pro18-spring-session-b`](#333-pro18-spring-session-b)
                - [3.3.3.1 新建`HelloHandler`类](#3331-新建hellohandler类)
        - [3.4 `SpringSession` 基本原理](#34-springsession-基本原理)
            - [3.4.1 `SpringSession` 需要完成的任务](#341-springsession-需要完成的任务)
            - [3.4.2 `SessionRepositoryFilter`](#342-sessionrepositoryfilter)
    - [4. 星图/架构图](#4-星图架构图)
    - [5. 登录检查](#5-登录检查)
        - [5.1 代码: 设置 `Session` 共享](#51-代码-设置-session-共享)
            - [5.1.1 `zuul、auth` 工程](#511-zuulauth-工程)
        - [5.2 代码: 准备不需要登录检查的资源](#52-代码-准备不需要登录检查的资源)
            - [5.2.1 新建 `AccessPassResources` 类](#521-新建-accesspassresources-类)
        - [5.3 代码: `zuul` 工程](#53-代码-zuul-工程)
            - [5.3.1 新建 `CrowdAccessFilter` 类](#531-新建-crowdaccessfilter-类)
            - [5.3.2 追加依赖](#532-追加依赖)
        - [5.4 `auth` 工程](#54-auth-工程)
            - [5.4.1 追加代码 `member-login.html`](#541-追加代码-member-loginhtml)
    - [6 修改重定向地址, 使用 `zuul`](#6-修改重定向地址-使用-zuul)
        - [6.1 因为 `Cookie` 问题不能使用重定向跨项目跳转, 所以集中访问 `zuul` 来进行重定向](#61-因为-cookie-问题不能使用重定向跨项目跳转-所以集中访问-zuul-来进行重定向)
        - [6.2 前端重定向地址, 使用 Session 共享存储 `zuul` 地址解决](#62-前端重定向地址-使用-session-共享存储-zuul-地址解决)
            - [6.2.1 项目启动自动存储 `zuul` 地址](#621-项目启动自动存储-zuul-地址)
            - [6.2.2 追加代码 `CrowdConstant` 【`common`工程】](#622-追加代码-crowdconstant-common工程)
            - [6.2.3 前端重定向可以使用 `${session.zuulPath}`获取地址](#623-前端重定向可以使用-sessionzuulpath获取地址)


# 十六 会员系统-搭建环境

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

### 7.5 新建 `application.yml` 配置

```yaml
server:
  port: 3000

spring:
  application:
    name: atguigu-crowd-redis
  redis:
    host: 127.0.0.1

eureka:
  client:
    service-url:
      defaultZone: http://localhost:1000/eureka
```



### 7.6 测试类

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
    @RequestMapping("/set/redis/key/value/remote")
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
    @RequestMapping("/set/redis/key/value/remote/with/timeout")
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
    @RequestMapping("get/redis/key/value/by/key")
    ResultEntity<String> getRedisKeyValueByKey(@RequestParam("key") String key);

    /**
     * 根据 Key 删除
     *
     * @param key
     * @return
     */
    @RequestMapping("remove/redis/key/remote")
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

<!-- 作为客户端访问 Eureka 注册中心 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

<!-- 为了能够使用工具类 -->
<dependency>
    <groupId>com.atguigu.crowd</groupId>
    <artifactId>atcrowdfunding05-common-util</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>

<!-- 为能够使用实体类 -->
<dependency>
    <groupId>com.atguigu.crowd</groupId>
    <artifactId>atcrowdfunding09-member-entity</artifactId>
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
    @RequestMapping("/set/redis/key/value/remote")
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
    @RequestMapping("/set/redis/key/value/remote/with/timeout")
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
    @RequestMapping("get/redis/key/value/by/key")
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
    @RequestMapping("remove/redis/key/remote")
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


# 十七 会员注册

>  `git checkout -b 17.0.0_member_reg`

## 1. 调用第三方短信接口

- [云市场](https://market.aliyun.com/?spm=5176.product-detail.J_3207526240.2.2ba07b9d1oPiiz)

### 1.1 追加依赖【`common`工程】

```xml
<!-- 以下是发送短信时调用第三方 API 所需的依赖 -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.15</version>
</dependency>

<dependency>
    <groupId>org.apache.httpcomponents</groupId>
    <artifactId>httpclient</artifactId>
    <version>4.5.9</version>
</dependency>

<dependency>
    <groupId>org.eclipse.jetty</groupId>
    <artifactId>jetty-util</artifactId>
    <version>9.4.19.v20190610</version>
</dependency>

<dependency>
    <groupId>commons-lang</groupId>
    <artifactId>commons-lang</artifactId>
    <version>2.6</version>
</dependency>
```



### 1.2 新建 `HttpUtils` 类【`common`工程】

```java
package com.aliyun.api.gateway.demo.util;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 陈江林
 * @date 2022/8/29 09:27
 */
public class HttpUtils {

    /**
     * get
     *
     * @param host
     * @param path
     * @param method
     * @param headers
     * @param querys
     * @return
     * @throws Exception
     */
    public static HttpResponse doGet(String host, String path, String method,
                                     Map<String, String> headers,
                                     Map<String, String> querys)
            throws Exception {
        HttpClient httpClient = wrapClient(host);

        HttpGet request = new HttpGet(buildUrl(host, path, querys));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }

        return httpClient.execute(request);
    }

    /**
     * post form
     *
     * @param host
     * @param path
     * @param method
     * @param headers
     * @param querys
     * @param bodys
     * @return
     * @throws Exception
     */
    public static HttpResponse doPost(String host, String path, String method,
                                      Map<String, String> headers,
                                      Map<String, String> querys,
                                      Map<String, String> bodys)
            throws Exception {
        HttpClient httpClient = wrapClient(host);

        HttpPost request = new HttpPost(buildUrl(host, path, querys));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }

        if (bodys != null) {
            List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();

            for (String key : bodys.keySet()) {
                nameValuePairList.add(new BasicNameValuePair(key, bodys.get(key)));
            }
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nameValuePairList, "utf-8");
            formEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
            request.setEntity(formEntity);
        }

        return httpClient.execute(request);
    }

    /**
     * Post String
     *
     * @param host
     * @param path
     * @param method
     * @param headers
     * @param querys
     * @param body
     * @return
     * @throws Exception
     */
    public static HttpResponse doPost(String host, String path, String method,
                                      Map<String, String> headers,
                                      Map<String, String> querys,
                                      String body)
            throws Exception {
        HttpClient httpClient = wrapClient(host);

        HttpPost request = new HttpPost(buildUrl(host, path, querys));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }

        if (StringUtils.isNotBlank(body)) {
            request.setEntity(new StringEntity(body, "utf-8"));
        }

        return httpClient.execute(request);
    }

    /**
     * Post stream
     *
     * @param host
     * @param path
     * @param method
     * @param headers
     * @param querys
     * @param body
     * @return
     * @throws Exception
     */
    public static HttpResponse doPost(String host, String path, String method,
                                      Map<String, String> headers,
                                      Map<String, String> querys,
                                      byte[] body)
            throws Exception {
        HttpClient httpClient = wrapClient(host);

        HttpPost request = new HttpPost(buildUrl(host, path, querys));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }

        if (body != null) {
            request.setEntity(new ByteArrayEntity(body));
        }

        return httpClient.execute(request);
    }

    /**
     * Put String
     *
     * @param host
     * @param path
     * @param method
     * @param headers
     * @param querys
     * @param body
     * @return
     * @throws Exception
     */
    public static HttpResponse doPut(String host, String path, String method,
                                     Map<String, String> headers,
                                     Map<String, String> querys,
                                     String body)
            throws Exception {
        HttpClient httpClient = wrapClient(host);

        HttpPut request = new HttpPut(buildUrl(host, path, querys));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }

        if (StringUtils.isNotBlank(body)) {
            request.setEntity(new StringEntity(body, "utf-8"));
        }

        return httpClient.execute(request);
    }

    /**
     * Put stream
     *
     * @param host
     * @param path
     * @param method
     * @param headers
     * @param querys
     * @param body
     * @return
     * @throws Exception
     */
    public static HttpResponse doPut(String host, String path, String method,
                                     Map<String, String> headers,
                                     Map<String, String> querys,
                                     byte[] body)
            throws Exception {
        HttpClient httpClient = wrapClient(host);

        HttpPut request = new HttpPut(buildUrl(host, path, querys));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }

        if (body != null) {
            request.setEntity(new ByteArrayEntity(body));
        }

        return httpClient.execute(request);
    }

    /**
     * Delete
     *
     * @param host
     * @param path
     * @param method
     * @param headers
     * @param querys
     * @return
     * @throws Exception
     */
    public static HttpResponse doDelete(String host, String path, String method,
                                        Map<String, String> headers,
                                        Map<String, String> querys)
            throws Exception {
        HttpClient httpClient = wrapClient(host);

        HttpDelete request = new HttpDelete(buildUrl(host, path, querys));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }

        return httpClient.execute(request);
    }

    private static String buildUrl(String host, String path, Map<String, String> querys) throws UnsupportedEncodingException {
        StringBuilder sbUrl = new StringBuilder();
        sbUrl.append(host);
        if (!StringUtils.isBlank(path)) {
            sbUrl.append(path);
        }
        if (null != querys) {
            StringBuilder sbQuery = new StringBuilder();
            for (Map.Entry<String, String> query : querys.entrySet()) {
                if (0 < sbQuery.length()) {
                    sbQuery.append("&");
                }
                if (StringUtils.isBlank(query.getKey()) && !StringUtils.isBlank(query.getValue())) {
                    sbQuery.append(query.getValue());
                }
                if (!StringUtils.isBlank(query.getKey())) {
                    sbQuery.append(query.getKey());
                    if (!StringUtils.isBlank(query.getValue())) {
                        sbQuery.append("=");
                        sbQuery.append(URLEncoder.encode(query.getValue(), "utf-8"));
                    }
                }
            }
            if (0 < sbQuery.length()) {
                sbUrl.append("?").append(sbQuery);
            }
        }

        return sbUrl.toString();
    }

    private static HttpClient wrapClient(String host) {
        HttpClient httpClient = new DefaultHttpClient();
        if (host.startsWith("https://")) {
            sslClient(httpClient);
        }

        return httpClient;
    }

    private static void sslClient(HttpClient httpClient) {
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] xcs, String str) {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] xcs, String str) {

                }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx);
            ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            ClientConnectionManager ccm = httpClient.getConnectionManager();
            SchemeRegistry registry = ccm.getSchemeRegistry();
            registry.register(new Scheme("https", 443, ssf));
        } catch (KeyManagementException ex) {
            throw new RuntimeException(ex);
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }
}
```



### 1.3 新建 `CrowdTest` 测试类【`auth` 工程】

#### 1.3.1 前置: 追加依赖

```xml
<!-- SpringBoot 测试 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <version>2.1.6.RELEASE</version>
    <scope>test</scope>
</dependency>
```

------

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661739650139-ba5aeaa8-0737-4890-9b90-9f38ba8a388d.png)

```java
package com.atguigu.crowd.test;

import com.aliyun.api.gateway.demo.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈江林
 * @date 2022/8/29 09:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CrowdTest {

    @Test
    public void testSendMessage() {
        String host = "https://dfsns.market.alicloudapi.com";
        String path = "/data/send_sms";
        String method = "POST";
        String appcode = "1948fa6afc674ea3bc2fea47f36e1108";
        Map<String, String> headers = new HashMap<>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<>();
        Map<String, String> bodys = new HashMap<>();
        bodys.put("content", "code:1234");
        bodys.put("phone_number", "185xxxx5080");
        bodys.put("template_id", "TPL_0000");

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            // System.out.println(response.toString());
            // 获取response的body
            // {"status":"OK","request_id":"TIDef01a498c96747a19aa166cd81f9279d"}
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 1.4 `CrowdUtil` 追加方法【`common`工程】

```java
/**
 * 给远程第三方接口发送请求把验证码发送到用户手机上
 *
 * @param appCode     用来调用第三方短信 API 的 AppCode
 * @param templateId  模板的编号
 * @param host        短信接口调用的 URL 地址
 * @param path        具体发送短信功能的地址
 * @param method      请求方式
 * @param phoneNumber 接收短信的手机号码
 * @return 成功返回: 验证码
 */
public static ResultEntity<String> sendShortMessage(String appCode, String templateId, String host, String path, String method, String phoneNumber) {
    // 生成验证码
    StringBuilder code = new StringBuilder();
    for (int i = 0; i < 4; i++) {
        int random = (int) (Math.random() * 10);
        code.append(random);
    }

    Map<String, String> headers = new HashMap<>();
    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
    headers.put("Authorization", "APPCODE " + appCode);
    //根据API的要求，定义相对应的Content-Type
    headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
    Map<String, String> querys = new HashMap<>();
    Map<String, String> bodys = new HashMap<>();

    bodys.put("content", "code:" + code);
    bodys.put("phone_number", phoneNumber);
    if (templateId == null) {
        // 测试模板的 Id
        bodys.put("template_id", "TPL_0000");
    } else {
        bodys.put("template_id", templateId);
    }

    try {
        /**
         * 重要提示如下:
         * HttpUtils请从
         * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
         * 下载
         *
         * 相应的依赖请参照
         * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
         */
        HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
        System.out.println(response.toString());
        //获取response的body
        //System.out.println(EntityUtils.toString(response.getEntity()));

        StatusLine statusLine = response.getStatusLine();
        // 状态码: [{200: 正常}, {400: 请求参数错误}, {403: 套餐余额用完}, {500: 服务器内部错误}]
        int statusCode = statusLine.getStatusCode();
        String reasonPhrase = statusLine.getReasonPhrase();

        if (statusCode == 200) {
            return ResultEntity.successWithData(code.toString());
        } else {
            return ResultEntity.failed(reasonPhrase);
        }
    } catch (Exception e) {
        return ResultEntity.failed(e.getMessage());
    }
}
```



## 2. 发送验证码【`auth` 工程】

- 将验证码发送到用户手机上
- 将验证码存入 `Redis` 中

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661752982629-d2f728d5-2193-4e09-9e26-1238e5862231.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661303711451-a1e90c90-61a4-4c8c-8822-806ebac12970.png)



### 2.1 配置跳转路径和对应的页面

#### 2.1.1 新建 `CrowdWebMvcConfig` 类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661741337449-58492ae4-ac1b-41d9-9555-3ce4f4267504.png)

```java
package com.atguigu.crowd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 陈江林
 * @date 2022/8/29 10:48
 */
@Configuration
public class CrowdWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/auth/member/to/reg/page").setViewName("member-reg");
        registry.addViewController("/auth/member/to/login/page").setViewName("member-login");
    }

}
```



### 2.2 修改代码 `portal.html`

```html
<!--                        <li><a href="login.html">登录</a></li>-->
<!--                        <li><a href="reg.html">注册</a></li>-->
<li><a th:href="@{/auth/member/to/login/page}">登录</a></li>
<li><a th:href="@{/auth/member/to/reg/page}">注册</a></li>
```



### 2.3 新建 `member-reg.html` 注册页面

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661742933900-febbd4fc-ff6d-4b2a-9904-f8b58fbfeb3c.png)

```html
<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="https://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <base th:href="@{/}">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/login.css">
    <script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript">
        // layer.msg("aaa...");

        $(function () {
            $("#sendBtn").click(function () {
                // 1. 获取接送短信的手机号码
                let phoneNum = $.trim($("[name=phoneNum]").val());

                // 2. 发送请求
                $.ajax({
                    url: "auth/member/send/short/message.json",
                    type: "post",
                    data: {
                        phoneNum: phoneNum
                    },
                    dataType: "json",
                    success: function (response) {
                        var result = response.result;
                        if ("SUCCESS" === result) {
                            layer.msg("发送成功")
                        }

                        if ("FAILED" === result) {
                            layer.msg("发送失败, 请重试")
                        }
                    },
                    error: function (response) {
                        layer.msg(response.status + " " + response.statusText);
                    }
                })
            })
        })
    </script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" th:href="@{/}" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
    </div>
</nav>

<div class="container">

    <form action="/auth/do/member/register" method="post" class="form-signin" role="form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 用户注册</h2>
        <p th:text="${message}">这里显示从请求域取出的提示消息</p>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="loginacct" name="loginacct" placeholder="请输入登录账号" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="userpswd" name="userpswd" placeholder="请输入登录密码"
                   style="margin-top:10px;">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="username" name="username" placeholder="请输入登录昵称" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱地址"
                   style="margin-top:10px;">
            <span class="glyphicon glyphicon glyphicon-envelope form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="phoneNum" name="phoneNum" placeholder="请输入手机号"
                   style="margin-top:10px;">
            <span class="glyphicon glyphicon glyphicon-earphone form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="code" name="code" placeholder="请输入验证码" style="margin-top:10px;">
            <span class="glyphicon glyphicon glyphicon-comment form-control-feedback"></span>
        </div>
        <button id="sendBtn" type="button" class="btn btn-lg btn-success btn-block"> 获取验证码</button>
        <button type="submit" class="btn btn-lg btn-success btn-block"> 注册</button>
    </form>

</div>

</body>
</html>
```



#### 2.3.1 添加 `layer`到 `static` 下 [📎layer.zip](https://www.yuque.com/attachments/yuque/0/2022/zip/12811585/1661304823359-ba71611a-3f5d-482b-ad14-5451941d27a6.zip)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661741626640-e781ac6d-c56d-4fe4-b722-59e628c8b5d9.png)



### 2.4 追加依赖

```xml
<!-- 导入配置文件处理器, 配置文件进行绑定 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```



### 2.5 新建 `ShortMessageProperties` 类

```java
package com.atguigu.crowd.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 第三方短信接口属性
 *
 * @author 陈江林
 * @date 2022/8/29 11:24
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@ConfigurationProperties(prefix = "short.message")
public class ShortMessageProperties {

    private String appCode;
    private String templateId;
    private String host;
    private String method;
    private String path;

}
```



### 2.6 追加配置

```yaml
# 第三方短信接口
short:
  message:
    app-code: 1948fa6afc674ea3bc2fea47f36e1108
    host: https://dfsns.market.alicloudapi.com
    path: /data/send_sms
    method: POST
```



### 2.7 新建 `MemberHandler` 发送短信

```java
package com.atguigu.crowd.handler;

import com.atguigu.crowd.api.RedisRemoteService;
import com.atguigu.crowd.config.ShortMessageProperties;
import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * @author 陈江林
 * @date 2022/8/29 11:21
 */
@Controller
public class MemberHandler {

    @Autowired
    private ShortMessageProperties shortMessageProperties;

    @Autowired
    private RedisRemoteService redisRemoteService;

    /**
     * 发送短信验证码
     *
     * @param phoneNum 手机号码
     * @return
     */
    @ResponseBody
    @RequestMapping("/auth/member/send/short/message.json")
    public ResultEntity<String> sendMessage(
            @RequestParam("phoneNum") String phoneNum) {
        try {
            // 1. 发送验证码
            ResultEntity<String> sendMessageResultEntity = CrowdUtil.sendShortMessage(
                    shortMessageProperties.getAppCode(),
                    shortMessageProperties.getTemplateId(),
                    shortMessageProperties.getHost(),
                    shortMessageProperties.getPath(),
                    shortMessageProperties.getMethod(),
                    phoneNum
            );

            // 2. 判断发送结果
            if(ResultEntity.SUCCESS.equals(sendMessageResultEntity.getResult())) {
                // 3. 成功: 将验证码存入 Redis
                String code = sendMessageResultEntity.getData();
                String key = CrowdConstant.REDIS_CODE_PREFIX + phoneNum;
                ResultEntity<String> saveCodeResultEntity = redisRemoteService.setRedisKeyValueRemoteWithTimeout(key, code, 15, TimeUnit.MINUTES);
                if(ResultEntity.SUCCESS.equals(saveCodeResultEntity.getResult())) {
                    return ResultEntity.successWithoutData();
                } else {
                    return saveCodeResultEntity;
                }
            } else {
                return sendMessageResultEntity;
            }
        } catch (Exception e){
            return ResultEntity.failed(e.getMessage());
        }
    }
}
```



### 2.8 追加代码 `CrowdConstant`【`common`】

```java
public static final String REDIS_CODE_PREFIX = "REDIS_CODE_PREFIX_";
```



## 3. 执行注册流程

- 如果针对注册操作所做的各项验证能够通过, 则将 Member 信息存入数据库

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661318337459-34acb207-e4f6-442c-bcc7-d6535d5bcc1c.png)



- **操作**: 给 `t_member` 表中字段 `loginacct` 设置唯一

### 3.1 追加代码 `MySQLRemoteService`【`API` 工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661753173442-0bc49c95-f1ee-40e2-8638-f9fe7685858c.png)

```java
/**
 * 保存
 *
 * @param memberPO 会员实体类
 * @return
 */
@RequestMapping("/save/member/remote")
ResultEntity<String> saveMember(@RequestBody MemberPO memberPO);
```



### 3.2 `MySQL` 项目

#### 3.2.1 追加代码 `MemberProviderHandler`

```java
/**
 * 保存
 *
 * @param memberPO 会员实体类
 * @return
 */
@RequestMapping("/save/member/remote")
public ResultEntity<String> saveMember(@RequestBody MemberPO memberPO) {
    try {
        memberService.saveMember(memberPO);
        return ResultEntity.successWithoutData();
    } catch (Exception e) {
        if (e instanceof DuplicateKeyException) {
            return ResultEntity.failed(CrowdConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
        }

        return ResultEntity.failed(e.getMessage());
    }
}
```



#### 3.2.2 追加代码 `MemberService`

```java
/**
 * 保存
 *
 * @param memberPO 会员实体类
 * @return
 */
void saveMember(MemberPO memberPO);
```



#### 3.2.3 追加代码 `MemberServiceImpl`

```java
@Transactional(
    propagation = Propagation.REQUIRES_NEW, 
    rollbackFor = Exception.class
)
@Override
public void saveMember(MemberPO memberPO) {
    memberPOMapper.insert(memberPO);
}
```



### 3.3 测试 `http://localhost:2000/save/member/remote`

- `body`: `{"loginacct": "tom","userpswd": "123"}`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661762061989-533b9ba6-7d23-46bc-aecb-164a9a1e141e.png)

- `Content-Type`: `application/json;charset=utf-8`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661319471006-2d33c481-848c-4fc9-b2d2-47390293465e.png)

- 结果

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661762078859-d289e693-501b-4702-837c-6bfdbef7310c.png)



### 3.4 `Entity` 工程

#### 3.4.1 新建 `MemberVO` 封装表单数据

```java
package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 陈江林
 * @date 2022/8/29 16:35
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberVO {

    private String loginacct;

    private String userpswd;

    private String username;

    private String email;

    private String phoneNum;

    private String code;

}
```



### 3.5 `Auth` 项目

#### 3.5.1 追加代码 `MemberHandler`

```java
@RequestMapping("/auth/do/member/register")
public String register(MemberVO memberVO, ModelMap modelMape) {
    // 1. 获取用户输入的手机号码
    String phoneNum = memberVO.getPhoneNum();
    
    // 2. 拼 Redis 中存储验证码的 Key
    String key = CrowdConstant.REDIS_CODE_PREFIX + phoneNum;
    
    // 3. 从 Redis 读取 Key 对应的 Value
    ResultEntity<String> resultEntity = redisRemoteService.getRedisStringValue(key);
    
    // 4. 检查查询操作是否有效
    String result = resultEntity.getResult();
    if(resultEntity.FAILD.equals(result)) {
        // ATTR_NAME_MESSAGE = message;
        modelMape.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, resultEntity.getMessage());
        return "member-reg";
    }
        
    String redisCode = resultEntity.getData();
    
    if(redisCode == null) {
        // MESSAGE_CODE_NOT_EXISTS = 验证码已过期!请检查手机号码是否正确或重新发送!
        modelMape.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_CODE_NOT_EXISTS);
        return "member-reg";
    }
    
    // 5. 如果从 Redis 能够查询到 Value 则比较表单的验证码和 Redis 的验证码
    String formCode = memberVO.getCode();
    
    if(!Object.equals(formCode, redisCode)) {
        // MESSAGE_CODE_INVALID = 验证码不正确!
        modelMape.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_CODE_INVALID);
        return "member-reg";
    }
    
    // 6. 如果验证码一致则从 Redis 删除
    redisRemoteService.removeRedisKeyRemote(key);
    
    // 7. 执行密码加密
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    String userpswdBeforeEncode = memberVO.getUserpswd();
    String userpswdAfterEncode = bCryptPasswordEncoder.encode(userpswdBeforeEncode);
    
    memberVO.serUserpswd(userpswdAfterEncode);
    // 8. 执行保存
    // 8.1 创建空的 memberPO 对象
    MemberPO memberPO = new MemberPO();
    
    // 8.2 复制属性
    BeanUtils.copyProperties(memberVO, memberPO);
    
    // 8.3 调用远程的方法
    ResultEntity<String> saveMemberResultEntity = mysqlRemoteService.saveMember(memberPO);
    if(saveMemberResultEntity.FAILD.equals(result)) {
        modelMape.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, saveMemberResultEntity.getMessage());
        return "member-reg";
    }
    
    // 使用重定向避免刷新浏览器导致重新执行注册流程
    return "redirect:/auth/member/to/login/page";
}
```



#### 3.5.2 登录页面 `member-login.html`

```html
<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="https://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <base th:href="@{/}">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/login.css">
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" th:href="@{/}" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
    </div>
</nav>

<div class="container">

    <form class="form-signin" role="form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 用户登录</h2>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="loginacct" name="loginacct" placeholder="请输入登录账号" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="userpswd" name="userpswd" placeholder="请输入登录密码"
                   style="margin-top:10px;">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="checkbox" style="text-align:right;"><a th:href="@{/auth/member/to/reg/page}">我要注册</a></div>
        <button type="submit" class="btn btn-lg btn-success btn-block">登录</button>
    </form>
</div>

</body>
</html>
```



### 3.6 `Common` 工程

#### 3.6.1 追加代码 `CrowdContant`

```java
public static final String MESSAGE_CODE_NOT_EXISTS = "验证码已过期!请检查手机号码是否正确或重新发送!";
public static final String MESSAGE_CODE_INVALID = "验证码不正确!";

public static final String REDIS_CODE_PREFIX = "REDIS_CODE_PREFIX_";
public static final String ATTR_NAME_MESSAGE = "message";
```




# 十八 会员登录

```
git checkout -b 18.0.0_member_login
```

## 1. 登录流程

- 检查账号密码正确后将用户信息存入 `Session`, 表示用户已登录

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661501170375-e4fa33c7-9564-4a02-8e2e-6f8988022eef.png)



### 1.1 `Entity`

#### 1.1.1 新建 `MemberLoginVO`

```java
package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 陈江林
 * @date 2022/8/29 21:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberLoginVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String username;

    private String email;

}
```





### 1.2 `Auth` 工程

#### 1.2.1 修改代码 `member-login.html`

```html
<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="https://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <base th:href="@{/}">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/login.css">
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" th:href="@{/}" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
    </div>
</nav>

<div class="container">
    <form action="/auth/member/do/login" method="post" class="form-signin" role="form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 用户登录</h2>
        <p th:text="${message}">这里显示从请求域取出的提示消息</p>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="loginacct" name="loginacct" placeholder="请输入登录账号" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="userpswd" name="userpswd" placeholder="请输入登录密码"
                   style="margin-top:10px;">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="checkbox" style="text-align:right;"><a th:href="@{/auth/member/to/reg/page}">我要注册</a></div>
        <button type="submit" class="btn btn-lg btn-success btn-block">登录</button>
    </form>
</div>

</body>
</html>
```



#### 1.2.2 追加代码 `MemberHandler`

```java
/**
 * 会员登录
 *
 * @param loginacct 账户
 * @param userpswd 密码
 * @param modelMap
 * @param session
 * @return
 */
@RequestMapping("/auth/member/do/login")
public String doLogin(
        @RequestParam("loginacct") String loginacct,
        @RequestParam("userpswd") String userpswd,
        ModelMap modelMap,
        HttpSession session) {
    ResultEntity<MemberPO> resultEntity = mySQLRemoteService.getMemberPOByLoginAcctRemote(loginacct);
    if (ResultEntity.FAILED.equals(resultEntity.getResult())) {
        modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, resultEntity.getMessage());
        return "member-login";
    }

    MemberPO memberPO = resultEntity.getData();
    if (memberPO == null) {
        modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_LOGIN_FAILED);
        return "member-login";
    }

    // 2. 比较密码
    String userpswdDataBase = memberPO.getUserpswd();

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    bCryptPasswordEncoder.matches(userpswd, userpswdDataBase);

    // 3. 创建 MemberLoginVO 对象传入 Session 域
    MemberLoginVO memberLoginVO = new MemberLoginVO(memberPO.getId(), memberPO.getUsername(), memberPO.getEmail());
    // ATTR_NAME_LOGIN_MEMBER = loginMember
    session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER, memberLoginVO);

    return "redirect:/auth/member/to/conter/page";
}
```



#### 1.2.3 追加代码 `CrowdWebMvcConfig` 设置跳转页面

```java
registry.addViewController("/auth/member/to/conter/page").setViewName("member-conter");
```



#### 1.2.4 新建页面 `member-conter.html`

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
    <link rel="stylesheet" href="css/theme.css">
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="script/docs.min.js"></script>
    <script src="script/back-to-top.js"></script>
    <script src="script/echarts.js"></script>
    <style>
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

    </style>
</head>
<body>
<div class="navbar-wrapper">
    <div class="container">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" th:href="@{/}" style="font-size:32px;">尚筹网-创意产品众筹平台</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse" style="float:right;">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                                    class="glyphicon glyphicon-user"></i> [[${session.loginMember.username}]]<span
                                    class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="member.html"><i class="glyphicon glyphicon-scale"></i> 会员中心</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
                                <li class="divider"></li>
                                <li><a href="index.html"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

    </div>
</div>
<div class="container">
    <div class="row clearfix">
        <div class="col-sm-3 col-md-3 column">
            <div class="row">
                <div class="col-md-12">
                    <div class="thumbnail" style="    border-radius: 0px;">
                        <img src="img/services-box1.jpg" class="img-thumbnail" alt="">
                        <div class="caption" style="text-align:center;">
                            <h3>
                                [[${session.loginMember.username}]]
                            </h3>
                            <span class="label label-danger" style="cursor:pointer;"
                                  onclick="window.location.href='accttype.html'">未实名认证</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="list-group">
                <div class="list-group-item active">
                    资产总览<span class="badge"><i class="glyphicon glyphicon-chevron-right"></i></span>
                </div>
                <div class="list-group-item " style="cursor:pointer;"
                     onclick="window.location.href='minecrowdfunding.html'">
                    我的众筹<span class="badge"><i class="glyphicon glyphicon-chevron-right"></i></span>
                </div>
            </div>
        </div>
        <div class="col-sm-9 col-md-9 column">
            <blockquote style="border-left: 5px solid #f60;color:#f60;padding: 0 0 0 20px;">
                <b>
                    我的钱包
                </b>
            </blockquote>
            <div id="main" style="width: 600px;height:400px;"></div>
            <blockquote style="border-left: 5px solid #f60;color:#f60;padding: 0 0 0 20px;">
                <b>
                    理财
                </b>
            </blockquote>
            <div id="main1" style="width: 600px;height:400px;"></div>
            <blockquote style="border-left: 5px solid #f60;color:#f60;padding: 0 0 0 20px;">
                <b>
                    比例
                </b>
            </blockquote>
            <div id="main2" style="width: 600px;height:400px;"></div>
        </div>
    </div>
</div>
<div class="container" style="margin-top:20px;">
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

<script>
    $('#myTab a').click(function (e) {
        e.preventDefault()
        $(this).tab('show')
    })
    $('#myTab1 a').click(function (e) {
        e.preventDefault()
        $(this).tab('show')
    })

    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    option = {
        title: {
            text: '七日年化收益率(%)'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['基金', '股票']
        },
        toolbox: {
            show: false,
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                dataView: {readOnly: false},
                magicType: {type: ['line', 'bar']},
                restore: {},
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: ['2017-05-16', '2017-05-17', '2017-05-18', '2017-05-19', '2017-05-20', '2017-05-21', '2017-05-22']
        },
        yAxis: {
            type: 'value',
            axisLabel: {
                formatter: '{value} '
            }
        },
        series: [
            {
                name: '基金',
                type: 'line',
                data: [1, 1, 5, 3, 2, 3, 2],
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
            },
            {
                name: '股票',
                type: 'line',
                data: [1, -2, 2, 5, 3, 2, 4],
                markPoint: {
                    data: [
                        {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'},
                        [{
                            symbol: 'none',
                            x: '90%',
                            yAxis: 'max'
                        }, {
                            symbol: 'circle',
                            label: {
                                normal: {
                                    position: 'start',
                                    formatter: '最大值'
                                }
                            },
                            type: 'max',
                            name: '最高点'
                        }]
                    ]
                }
            }
        ]
    };
    myChart.setOption(option);
    var myChart1 = echarts.init(document.getElementById('main1'));

    // 指定图表的配置项和数据
    option1 = {
        color: ['#3398DB'],
        tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                data: ['基金', '票据', '定期理财', '变现贷'],
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '直接访问',
                type: 'bar',
                barWidth: '60%',
                data: [10, 52, 200, 334, 390, 330, 220]
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart1.setOption(option1);

    var myChart2 = echarts.init(document.getElementById('main2'));

    // 指定图表的配置项和数据
    option2 = {
        title: {
            text: '某站点用户访问来源',
            subtext: '纯属虚构',
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎']
        },
        series: [
            {
                name: '访问来源',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: [
                    {value: 335, name: '直接访问'},
                    {value: 310, name: '邮件营销'},
                    {value: 234, name: '联盟广告'},
                    {value: 135, name: '视频广告'},
                    {value: 1548, name: '搜索引擎'}
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart2.setOption(option2);
</script>
</body>
</html>
```



## 2. 会员退出登录

### 2.1 `auth` 工程

#### 2.1.1 修改代码`member-conter.html`

```html
<!--<li><a href="index.html"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>-->
<li><a th:href="@{/auth/member/logout}"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
```



#### 2.1.2 追加代码 `MemberHandler`

```java
/**
 * 退出登录
 * 
 * @param session
 * @return
 */
@RequestMapping("/auth/member/logout")
public String logout(HttpSession session) {

    session.invalidate();

    return "redirect:/";
}
```



## 3. 知识点: Session 共享, 解决 Session 不互通的问题

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661512959472-2c320b0f-fa66-49a7-b6ef-2c79c3ac8131.png)

- 在分布式和集群环境下,  每个具体模块运行在单独的 Tomcat 上, 而 Session 是被不同 Tomcat 所 "区隔" 的, 所以不能互通, 会导致程序运行时, 用户会话发生错误

    - 有的服务器上有, 有的服务器上没有

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661514510084-6df436b4-7639-49f6-ba64-5b695c7f1e5e.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661514533002-7fbb4bb6-851d-41c1-84c5-3158fd1f0c62.png)

### 3.1 会话控制回顾

- 浏览器: 发送 `Cookie` 数据
- 服务器: 解析 `Cookie` 数据
- 服务器: 查找对应的 `Session`, 如果没有则新建
- 服务器: 把新建的 `Session` 存入 `Redis`

========= ========

- 浏览器: 请求要求在原有的 `Session` 中存入新数据
- 服务器: 根据 `Cookie` 把旧的 `Session` 找到, 存入数据, 存回 Redis



#### 3.1.1 Cookie 的工作机制

- 服务器端返回 `Cookie` 信息给浏览器

    - `Java` 代码: `response.addCookie(cookie 对象);`
    - `Http` 响应消息头: `Set-Cookie`: `Cookie` 的名字 = `Cookie` 的值, 浏览器接收到服务器端返回的 `Cookie`, 以后的每一次请求都会把 `Cookie` 带上
    - Http 请求消息头: `Cookie`: `Cookie` 的名字 = `Cookie` 的值



#### 3.1.2 Session 的工作机制

- 获取 `Session` 对象:` request.getSession();`

    - 检查当前请求是否携带了 `JSESSIONID` 这个 `Cookie`

        - 带了: 根据这个 `JSESSIONID` 在服务器端查找对应的 `Session` 对象

            - 能找到: 就把找到的 `Seesion` 对象返回
            - 没找到: 新建 `Session` 对象返回, 同时返回 `JSESSIONID` 的 `Cookie`

        - 没带: 新建 `Session` 对象返回, 同时返回 `JSESSIONID` 的 `Cookie`



### 3.2 解决方案探索

#### 3.2.1 Session 同步

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661514573168-4b3e0b73-8e36-4e2b-bb18-aedb5fbf8c9d.png)![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661514589044-b0761750-12b5-478f-80cc-14ca350a0d0c.png)

- 问题1: 造成 `Session` 在各个服务器上 "同量" 保存

    - `TomcatA` 保存了 1G 的 `Session` 数据, `TomcatB` 也需要保存 1G 的 `Session` 数据
    - 数据量太大的会导致 `Tomcat` 性能下降

- 问题2: 数据同步对性能有一定影响
- 问题3: 对应集群外的服务器无效



#### 3.2.2 将 `Session` 数据存储在 `Cookie` 中

- 做法: 所有会话数据在浏览器端使用 `Cookie` 保存, 服务器端不存储如何会话手机

    - 好处: 服务器端大大减轻了数据存储的压力。不会有 `Session` 不一致的问题
    - 缺点:

        - `Cookie` 能够存储的数据非常有限。一般是 4KB。不能存储丰富的数据
        - `Cookie` 数据在浏览器端存储, 很大程度上不受服务器端的控制, 如果浏览器端清理 `Cookie`, 相关数据会丢失



#### 3.2.3 反向代理 `hash` 一致性

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661515160158-b2f4d58a-0d86-4c34-ae32-29b465222cd1.png)

- 问题1: 具体一个浏览器, 专门访问某一个具体服务器, 如果浏览器宕机, 会丢失数据。存在单点故障风险
- 问题2: 仅仅适用于集群范围内, 超出集群范围, 负载均衡服务器无效



#### 3.2.4 后端统一存储 Session 数据

- 后端存储 Session 数据时, 一般需要使用 Redis 这样的内存数据库，而一般不采用 MySQL 这样的关系型数据库。原因如下

    - Session 数据存取比较频繁。内存访问速度快
    - Session 有过期时间, Redis 这样的内存数据库能够比较方便实现过期释放

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661515652333-64a76e2d-ec08-4925-8421-60f8b830804e.png)

- 优点:

    - 访问速度比较快。虽然需要经过网络访问, 但是现在硬件条件已经能够达到网络访问比硬盘访问还要快

        - 硬盘访问速度: 200M/s
        - 网络访问速度: 1G/s

    - Redis 可以配置主从复制集群, 不担心单点故障



### 3.3 `SpringSession` 使用

- 装饰模式
- `SpringSession` 使得支持集群会话变得微不足道，而无需绑定到应用程序容器特定的解决方案
- 以下文档针对在 `SpringBoot` 环境下使用
- 实现跨项目存取 Session

    - 独立项目测试使用
    - `pro18-spring-session-a` 存

        - 端口 8181

    - `pro18-spring-session-b` 取

        - 端口 8182

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661562452557-a4def515-53a9-4974-972d-387a2df677af.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661562486613-e72c7a45-663f-4a40-b18c-3b56142e5b51.png)



![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661562475253-0123cd9b-2e29-48d1-8f97-dc590cb7db6b.png)

#### 3.3.1 共同代码

##### 3.3.1.1 引入依赖

```xml
父引用 springboot
<dependencies>
  <dependency>  
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <!-- 引入 SpringBoot & Redis 场景 -->
  <dependency>  
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
  </dependency>
  <!-- 引入 SpringBoot & SpringSeesion 场景 -->
  <dependency>  
    <groupId>org.springframework.session</groupId>
    <artifactId>spring-session-data-redis</artifactId>
  </dependency>
</dependencies>
```



##### 3.3.1.2 新建 `MainClass` 主启动类

```java
@SpringBootApplication
public class MainClass {

    public static void main(String[] args) {
        SpringApplication.run(MainClass.class, args);
    }

}
```



##### 3.3.1.3 新建 `application.yml` 配置

```yaml
server:
  port: 8181

# Redis 配置
spring:
  redis:
    host: 127.0.0.1

# SpringSession 配置
  session:
    store-type: redis
```

- 注意: 存入 `Session` 域的实体类对象需要支持序列化



#### 3.3.2 `pro18-spring-session-a`

##### 3.3.2.1 新建 `HelloHandler` 类

```java
@RestController
public class HelloHandler {
    
   @RequestMapping("/test/spring/session")
   public String testSession(HttpSession session) {
       session.setAttribute("king", "hello-king");
       
       return "数据存入 Session 域";
   }
   
}
```



#### 3.3.3 `pro18-spring-session-b`

##### 3.3.3.1 新建`HelloHandler`类

```java
@RestController
public class HelloHandler {
    
   @RequestMapping("/test/spring/session/retrieve")
   public String testSession(HttpSession session) {
       String value = session.getAttribute("king");
       
       return value;
   }
   
}
```



### 3.4 `SpringSession` 基本原理

- 概况: `SpringSession` 从底层全方位"接管"了 `Tomcat` 对 `Session` 的管理

#### 3.4.1 `SpringSession` 需要完成的任务

- 包装 `Request` 对象
- 找 `Session` 的时候访问 `Redis` 找
- 找到包装以后得  `Session`
- 传给 `Handler`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661562248532-8636c529-6b69-41e3-95c8-5622afa8431d.png)



#### 3.4.2 `SessionRepositoryFilter`

- 利用 Filter 原理, 在每次请求到达目标方法之前, 将原生 `HttpSeesionRequest`/`HttpServletResponse` 对象包装成为 `SessoinRepositoryRequest`/`ResponseWrapper`
- 包装 `request` 对象时要做到: 包装后和包装前的**类型兼容**

    - 所谓类型兼容: "包装得到的对象 `instanceof` 包装前类型" 返回 `true`

- 只有做到了类型的兼容, 后面使用包装过的对象才能保持使用方法不变。

    - 包装过的对象类型兼容、使用方法不变, 才能实现 "偷梁换柱"

- 但是如果直接实现 `HttpServletRequest` 接口, 我们又知道如何实现各个抽象方法

    - 这个问题可以借助原始被包装的对象来解决

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661563117912-1161408d-478c-4841-96f9-11fd6d9b33ff.png)



## 4. 星图/架构图

- 单一架构

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661567926586-fc92341c-87aa-4487-9c4e-c39f58c1c430.png)

- 分布式架构

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661568221042-fe361def-4fa5-4e74-a848-e0e23ff48873.png)



## 5. 登录检查

- 把项目中必须登录才能访问的功能保护起来, 如果没有登录就访问则跳转到登录页面

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661569729881-d91ee6df-526d-4670-adff-0f4789518180.png)



### 5.1 代码: 设置 `Session` 共享

#### 5.1.1 `zuul、auth` 工程

- 追加依赖

```xml
<!-- 引入 SpringBoot & Redis 场景 -->
<dependency>  
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>

<!-- 引入 SpringBoot & SpringSession 场景 -->
<dependency>  
  <groupId>org.springframework.session</groupId>
  <artifactId>spring-session-data-redis</artifactId>
</dependency>
```

- 追加配置

```yaml
spring:
  redis:
    host: localhost
  session:
    store-type: redis
```



### 5.2 代码: 准备不需要登录检查的资源

#### 5.2.1 新建 `AccessPassResources` 类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661822425179-cc305e7e-eb17-4b6f-8e2f-7f898f653c69.png)

```java
package com.atguigu.crowd.constant;

import java.util.HashSet;
import java.util.Set;

/**
 * 特定请求地址和静态资源
 *
 * @author 陈江林
 * @date 2022/8/30 09:19
 */
public class AccessPassResources {

    public static final Set<String> PASS_RES_SET = new HashSet<>();

    static {
        PASS_RES_SET.add("/");
        PASS_RES_SET.add("/auth/member/to/reg/page");
        PASS_RES_SET.add("/auth/member/to/login/page");
        PASS_RES_SET.add("/auth/member/logout");
        PASS_RES_SET.add("/auth/member/do/login");
        PASS_RES_SET.add("/auth/do/member/register");
        PASS_RES_SET.add("/auth/member/send/short/message.json");
    }

    public static final Set<String> STATIC_RES_SET = new HashSet<>();

    static {
        STATIC_RES_SET.add("bootstrap");
        STATIC_RES_SET.add("css");
        STATIC_RES_SET.add("fonts");
        STATIC_RES_SET.add("img");
        STATIC_RES_SET.add("jquery");
        STATIC_RES_SET.add("layer");
        STATIC_RES_SET.add("script");
        STATIC_RES_SET.add("ztree");
    }

    /**
     * 用于判断某个 ServletPath 值是否对应一个静态资源
     *
     * @param servletPath
     * @return true 是静态资源 false 不是静态资源
     */
    public static boolean judgeCurrentServletPathWetherStaticResource(String servletPath) {
        // 1. 排除字符串无效的情况
        if (servletPath == null || servletPath.length() == 0) {
            throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
        }

        // 2. 根据 "/" 拆分 ServletPath 字符串
        String[] split = servletPath.split("/");

        // 3. 考虑第一个斜杠左边经过拆分后得到有个空字符串是数组的第一个元素, 所以需要使用下标 1 取第二个元素
        String firstLevelPath = split[1];

        // 4. 判断是否在这个集合中
        return STATIC_RES_SET.contains(firstLevelPath);
    }

    public static void main(String[] args) {
        String servletPath = "/css/aaa/ccc";
        boolean result = judgeCurrentServletPathWetherStaticResource(servletPath);
        System.out.println(result);
    }

}
```



### 5.3 代码: `zuul` 工程

- (已配置) 配置 `zuul.sensitive-headers: "*" `# 在 zuul 向其他微服务重定向时保持原本的头信息（请求头、响应头）



#### 5.3.1 新建 `CrowdAccessFilter` 类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661823427261-a52e6cab-3061-489f-9c37-0350a4692914.png)

```java
package com.atguigu.crowd.filter;

import com.atguigu.crowd.constant.AccessPassResources;
import com.atguigu.crowd.constant.CrowdConstant;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 陈江林
 * @date 2022/8/30 09:24
 */
@Component
public class CrowdAccessFilter extends ZuulFilter {

    @Override
    public boolean shouldFilter() {
        // 1. 获取 RequestContext 对象
        RequestContext requestContext = RequestContext.getCurrentContext();

        // 2. 通过 RequestContext 对象获取当前请求对象
        //（框架底层是借助 ThreadLocal 从当前线程上获取事先绑定的 Request 对象）
        HttpServletRequest request = requestContext.getRequest();

        // 3. 获取 ServletPath
        String servletPath = request.getServletPath();

        // 4. 根据 servletPath 判断当前请求是否对应可以直接放行的特定请求
        boolean containsResult = AccessPassResources.PASS_RES_SET.contains(servletPath);
        if (containsResult) {
            // 如果当前请求是可以直接放行的特定功能请求则返回 false 放行
            return false;
        }

        // 判断当前请求是否为静态资源
        // 工具方法返回 true: 说明当前请求是静态资源请求, 取反为 false（表示放行不做登录检查）
        // 工具方法返回 false: 表示当前请求表示可以放行的特定请求也不是静态资源, 取反为 true（表示需要做登录检查）
        return !AccessPassResources.judgeCurrentServletPathWetherStaticResource(servletPath);
    }

    /**
     * 登录检查
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // 1. 获取当前请求对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        // 2. 获取当前 Session 对象
        HttpSession session = request.getSession();

        // 3. 尝试从 Session 对象中获取已登录的用户
        Object loginMember = session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER);

        // 4. 判断 loginMember 是否为空
        if (loginMember == null) {
            // 5. 未登录状态, 跳转至登录页面
            // 从 requestContext 对象中获取 Response 对象
            HttpServletResponse response = requestContext.getResponse();

            // 6. 将提示消息存入 Session 域
            session.setAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_ACCESS_FORBIDEN);

            // 7. 重定向到 auth 工程中的登录页面
            try {
                response.sendRedirect("/auth/member/to/login/page");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public String filterType() {
        // 这里返回 pre 意思是在目标微服务前执行过滤
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

}
```



#### 5.3.2 追加依赖

```xml
<!-- 为了能够使用工具类 -->
<dependency>
    <groupId>com.atguigu.crowd</groupId>
    <artifactId>atcrowdfunding05-common-util</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>

<!-- 为能够使用实体类 -->
<dependency>
    <groupId>com.atguigu.crowd</groupId>
    <artifactId>atcrowdfunding09-member-entity</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```



### 5.4 `auth` 工程

#### 5.4.1 追加代码 `member-login.html`

```html
<p th:text="${session.message}">这里显示的是登录检查后发现不允许访问时的提示消息</p>
```



## 6 修改重定向地址, 使用 `zuul`

### 6.1 因为 `Cookie` 问题不能使用重定向跨项目跳转, 所以集中访问 `zuul` 来进行重定向

- 描述问题: `http://localhost:4000` 和 `http://localhost:80` 是两个不同的网站, 浏览器工作时不会使用相同 `Cookie`
- 解决: 重定向的地址都按照通过 `Zuul` 访问的方式写地址



1. 追加代码 `CrowdConstant` 存储地址 【`common` 工程】

```java
public static final String ZUUL_PATH_VALUE = "http://localhost";
```

1. 修改 `redirect` 代码 `MemberHandler`【`auth` 工程】

```java
package com.atguigu.crowd.handler;

import com.atguigu.crowd.api.MySQLRemoteService;
import com.atguigu.crowd.api.RedisRemoteService;
import com.atguigu.crowd.config.ShortMessageProperties;
import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.po.MemberPO;
import com.atguigu.crowd.entity.vo.MemberLoginVO;
import com.atguigu.crowd.entity.vo.MemberVO;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author 陈江林
 * @date 2022/8/29 11:21
 */
@Controller
public class MemberHandler {

    @Autowired
    private ShortMessageProperties shortMessageProperties;

    @Autowired
    private RedisRemoteService redisRemoteService;

    @Autowired
    private MySQLRemoteService mySQLRemoteService;

    /**
     * 退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping("/auth/member/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:" + CrowdConstant.ZUUL_PATH_VALUE + "/";
    }

    /**
     * 会员登录
     *
     * @param loginacct 账户
     * @param userpswd  密码
     * @param modelMap
     * @param session
     * @return
     */
    @RequestMapping("/auth/member/do/login")
    public String doLogin(
            @RequestParam("loginacct") String loginacct,
            @RequestParam("userpswd") String userpswd,
            ModelMap modelMap,
            HttpSession session) {
        ResultEntity<MemberPO> resultEntity = mySQLRemoteService.getMemberPOByLoginAcctRemote(loginacct);
        if (ResultEntity.FAILED.equals(resultEntity.getResult())) {
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, resultEntity.getMessage());
            return "member-login";
        }

        MemberPO memberPO = resultEntity.getData();
        if (memberPO == null) {
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_LOGIN_FAILED);
            return "member-login";
        }

        // 2. 比较密码
        String userpswdDataBase = memberPO.getUserpswd();

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        bCryptPasswordEncoder.matches(userpswd, userpswdDataBase);

        // 3. 创建 MemberLoginVO 对象传入 Session 域
        MemberLoginVO memberLoginVO = new MemberLoginVO(memberPO.getId(), memberPO.getUsername(), memberPO.getEmail());
        // ATTR_NAME_LOGIN_MEMBER = loginMember
        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER, memberLoginVO);

        return "redirect:" + CrowdConstant.ZUUL_PATH_VALUE + "/auth/member/to/conter/page";
    }

    /**
     * 执行注册
     *
     * @param memberVO
     * @param modelMape
     * @return
     */
    @RequestMapping("/auth/do/member/register")
    public String register(MemberVO memberVO, ModelMap modelMape) {
        // 1. 获取用户输入的手机号码
        String phoneNum = memberVO.getPhoneNum();

        // 2. 拼 Redis 中存储验证码的 Key
        String key = CrowdConstant.REDIS_CODE_PREFIX + phoneNum;

        // 3. 从 Redis 读取 Key 对应的 Value
        ResultEntity<String> resultEntity = redisRemoteService.getRedisKeyValueByKey(key);

        // 4. 检查查询操作是否有效
        String result = resultEntity.getResult();
        if (ResultEntity.FAILED.equals(result)) {
            modelMape.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, resultEntity.getMessage());
            return "member-reg";
        }

        String redisCode = resultEntity.getData();

        if (redisCode == null) {
            // MESSAGE_CODE_NOT_EXISTS = 验证码已过期!请检查手机号码是否正确或重新发送!
            modelMape.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_CODE_NOT_EXISTS);
            return "member-reg";
        }

        // 5. 如果从 Redis 能够查询到 Value 则比较表单的验证码和 Redis 的验证码
        String formCode = memberVO.getCode();

        if (!Objects.equals(formCode, redisCode)) {
            // MESSAGE_CODE_INVALID = 验证码不正确!
            modelMape.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_CODE_INVALID);
            return "member-reg";
        }

        // 6. 如果验证码一致则从 Redis 删除
        redisRemoteService.removeRedisKeyRemote(key);

        // 7. 执行密码加密
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String userpswdBeforeEncode = memberVO.getUserpswd();
        String userpswdAfterEncode = bCryptPasswordEncoder.encode(userpswdBeforeEncode);

        memberVO.setUserpswd(userpswdAfterEncode);
        // 8. 执行保存
        // 8.1 创建空的 memberPO 对象
        MemberPO memberPO = new MemberPO();

        // 8.2 复制属性
        BeanUtils.copyProperties(memberVO, memberPO);

        // 8.3 调用远程的方法
        ResultEntity<String> saveMemberResultEntity = mySQLRemoteService.saveMember(memberPO);
        if (ResultEntity.FAILED.equals(saveMemberResultEntity.getResult())) {
            modelMape.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, saveMemberResultEntity.getMessage());
            return "member-reg";
        }

        // 使用重定向避免刷新浏览器导致重新执行注册流程
        return "redirect:" + CrowdConstant.ZUUL_PATH_VALUE + "/auth/member/to/login/page";
    }

    /**
     * 发送短信验证码
     *
     * @param phoneNum 手机号码
     * @return
     */
    @ResponseBody
    @RequestMapping("/auth/member/send/short/message.json")
    public ResultEntity<String> sendMessage(
            @RequestParam("phoneNum") String phoneNum) {
        try {
            // 1. 发送验证码
            ResultEntity<String> sendMessageResultEntity = CrowdUtil.sendShortMessage(
                    shortMessageProperties.getAppCode(),
                    shortMessageProperties.getTemplateId(),
                    shortMessageProperties.getHost(),
                    shortMessageProperties.getPath(),
                    shortMessageProperties.getMethod(),
                    phoneNum
            );

            // 2. 判断发送结果
            if (ResultEntity.SUCCESS.equals(sendMessageResultEntity.getResult())) {
                // 3. 成功: 将验证码存入 Redis
                String code = sendMessageResultEntity.getData();
                String key = CrowdConstant.REDIS_CODE_PREFIX + phoneNum;
                ResultEntity<String> saveCodeResultEntity = redisRemoteService.setRedisKeyValueRemoteWithTimeout(key, code, 15, TimeUnit.MINUTES);
                if (ResultEntity.SUCCESS.equals(saveCodeResultEntity.getResult())) {
                    return ResultEntity.successWithoutData();
                } else {
                    return saveCodeResultEntity;
                }
            } else {
                return sendMessageResultEntity;
            }
        } catch (Exception e) {
            return ResultEntity.failed(e.getMessage());
        }
    }
}
```



### 6.2 前端重定向地址, 使用 Session 共享存储 `zuul` 地址解决

#### 6.2.1 项目启动自动存储 `zuul` 地址

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661859079702-404e4150-be6c-49cb-bef0-8f5b1ddbd4f0.png)

```java
package com.atguigu.crowd.filter;

import com.atguigu.crowd.constant.AccessPassResources;
import com.atguigu.crowd.constant.CrowdConstant;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 陈江林
 * @date 2022/8/30 09:24
 */
@Component
public class CrowdAccessFilter extends ZuulFilter {

    @Override
    public boolean shouldFilter() {
        // 1. 获取 RequestContext 对象
        RequestContext requestContext = RequestContext.getCurrentContext();

        // 2. 通过 RequestContext 对象获取当前请求对象
        //（框架底层是借助 ThreadLocal 从当前线程上获取事先绑定的 Request 对象）
        HttpServletRequest request = requestContext.getRequest();

        setSessionValue(request.getSession());

        // 3. 获取 ServletPath
        String servletPath = request.getServletPath();

        // 4. 根据 servletPath 判断当前请求是否对应可以直接放行的特定请求
        boolean containsResult = AccessPassResources.PASS_RES_SET.contains(servletPath);
        if (containsResult) {
            // 如果当前请求是可以直接放行的特定功能请求则返回 false 放行
            return false;
        }

        // 判断当前请求是否为静态资源
        // 工具方法返回 true: 说明当前请求是静态资源请求, 取反为 false（表示放行不做登录检查）
        // 工具方法返回 false: 表示当前请求表示可以放行的特定请求也不是静态资源, 取反为 true（表示需要做登录检查）
        return !AccessPassResources.judgeCurrentServletPathWetherStaticResource(servletPath);
    }

    /**
     * 存储 zuul 地址
     *
     * @param session
     */
    public void setSessionValue(HttpSession session) {
        if (!(CrowdConstant.ZUUL_PATH_VALUE.equals(session.getAttribute(CrowdConstant.ZUUL_PATH_KEY)))) {
            session.setAttribute(CrowdConstant.ZUUL_PATH_KEY, CrowdConstant.ZUUL_PATH_VALUE);
        }
    }

    /**
     * 登录检查
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // 1. 获取当前请求对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        // 2. 获取当前 Session 对象
        HttpSession session = request.getSession();

        // 3. 尝试从 Session 对象中获取已登录的用户
        Object loginMember = session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER);

        // 4. 判断 loginMember 是否为空
        if (loginMember == null) {
            // 5. 未登录状态, 跳转至登录页面
            // 从 requestContext 对象中获取 Response 对象
            HttpServletResponse response = requestContext.getResponse();

            // 6. 将提示消息存入 Session 域
            session.setAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_ACCESS_FORBIDEN);

            // 7. 重定向到 auth 工程中的登录页面
            try {
                response.sendRedirect("/auth/member/to/login/page");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public String filterType() {
        // 这里返回 pre 意思是在目标微服务前执行过滤
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

}
```





#### 6.2.2 追加代码 `CrowdConstant` 【`common`工程】

```java
public static final String ZUUL_PATH_KEY = "zuulPath";
public static final String ZUUL_PATH_VALUE = "http://localhost";
```



#### 6.2.3 前端重定向可以使用 `${session.zuulPath}`获取地址

