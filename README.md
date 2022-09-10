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

- [十九 OSS](#十九-oss)
    - [1. 阿里云的 OSS 对象存储](#1-阿里云的-oss-对象存储)
        - [1.1 提出问题](#11-提出问题)
            - [1.1.1 以前上传文件时保持位置](#111-以前上传文件时保持位置)
            - [1.1.2 问题1: Web 应用重新部署导致文件丢失](#112-问题1-web-应用重新部署导致文件丢失)
            - [1.1.3 问题2: 集群环境下文件难以同步](#113-问题2-集群环境下文件难以同步)
            - [1.1.4 问题3: Tomcat 被拖垮](#114-问题3-tomcat-被拖垮)
            - [1.1.5 问题4: 服务器存储自动扩容问题](#115-问题4-服务器存储自动扩容问题)
        - [1.2 解决方案介绍](#12-解决方案介绍)
            - [1.2.1 自己搭建文件服务器](#121-自己搭建文件服务器)
            - [1.2.2 使用第三方云服务](#122-使用第三方云服务)
        - [1.3 开通 OSS 服务步骤](#13-开通-oss-服务步骤)
        - [1.4 使用 `OSS`](#14-使用-oss)
        - [1.5 Java 程序调用 OSS 服务接口](#15-java-程序调用-oss-服务接口)
            - [1.5.1 参考文档地址](#151-参考文档地址)
            - [1.5.2 官网介绍](#152-官网介绍)
            - [1.5.3 创建访问秘钥 `AccessKey`](#153-创建访问秘钥-accesskey)
            - [1.5.4 创建子账号 `AK` 的操作](#154-创建子账号-ak-的操作)
            - [1.5.5 OSS 依赖](#155-oss-依赖)
        - [1.6 将 `OSS` 引入 `project` 项目](#16-将-oss-引入-project-项目)
            - [1.6.1 `config` 包: `OSSProperties`](#161-config-包-ossproperties)
            - [1.6.2 依赖](#162-依赖)
            - [1.6.3 新建 `CrowdMainClass`主启动类](#163-新建-crowdmainclass主启动类)
            - [1.6.4 新建 `application.yml` 配置](#164-新建-applicationyml-配置)
        - [1.7 `common` 工程](#17-common-工程)
            - [1.7.1 追加依赖](#171-追加依赖)
            - [1.7.2 工具类 `CrowdUtil` 中追加方法](#172-工具类-crowdutil-中追加方法)
            - [1.7.3 测试 OSS](#173-测试-oss)
            - [1.7.4 如果报错: `Error: A JNI error has occurred, please check your installation and try agai`](#174-如果报错-error-a-jni-error-has-occurred-please-check-your-installation-and-try-agai)

- [二十 发起项目](#二十-发起项目)
    - [1. 发起项目 建模/准备](#1-发起项目-建模准备)
        - [1.1 创建数据库](#11-创建数据库)
            - [1.1.1 分类表](#111-分类表)
            - [1.1.2 项目分类中间表](#112-项目分类中间表)
            - [1.1.3 标签表](#113-标签表)
            - [1.1.4 项目标签中间表](#114-项目标签中间表)
            - [1.1.5 项目表](#115-项目表)
            - [1.1.6 项目表项目详情图片表](#116-项目表项目详情图片表)
            - [1.1.7 项目发起人信息表](#117-项目发起人信息表)
            - [1.1.8 回报信息表](#118-回报信息表)
            - [1.1.9 发起人确认信息表](#119-发起人确认信息表)
        - [1.2. 逆向工程](#12-逆向工程)
        - [1.3. `Mysql` 工程](#13-mysql-工程)
            - [1.3.1 新建 `ProjectProviderHandler`](#131-新建-projectproviderhandler)
            - [1.3.2 新建 `ProjectService`](#132-新建-projectservice)
            - [1.3.1 新建 `ProjectServiceImpl`](#131-新建-projectserviceimpl)
        - [1.4. 创建 `VO` 对象](#14-创建-vo-对象)
            - [1.4.1 新建 `ProjcetVO`](#141-新建-projcetvo)
            - [1.4.2 新建 `MemberLauchInfoVO`](#142-新建-memberlauchinfovo)
            - [1.4.3 新建 `ReturnVO`](#143-新建-returnvo)
            - [1.4.4 新建 `MemberConfirmInfoVO`](#144-新建-memberconfirminfovo)
        - [1.5 修改 PO, 记得加 `@NoArgsConstructor`, `@AllArgsConstructor`, `@Data`](#15-修改-po-记得加-noargsconstructor-allargsconstructor-data)
            - [1.5.1 修改 `ProjectPO`](#151-修改-projectpo)
    - [2. 发起项目](#2-发起项目)
        - [2.1 总目标](#21-总目标)
        - [2.2 思路](#22-思路)
        - [2.3 跳转`发起众筹`的表单页面](#23-跳转发起众筹的表单页面)
            - [2.3.1 点击 "我的众筹"`member-conter.html`【`auth` 工程】](#231-点击-我的众筹member-conterhtmlauth-工程)
            - [2.3.2 追加代码 `CrowdWebMvcConfig`【`auth` 工程】](#232-追加代码-crowdwebmvcconfigauth-工程)
            - [2.3.3 新建我的众筹页面 `member-crowd.html`【`auth` 工程】](#233-新建我的众筹页面-member-crowdhtmlauth-工程)
            - [2.3.4 追加配置 `application.yml`【`zuul` 工程】](#234-追加配置-applicationymlzuul-工程)
            - [2.3.5 新建 `CrowdWebMvcConfig` 配置类【`project` 工程】](#235-新建-crowdwebmvcconfig-配置类project-工程)
            - [2.3.5 页面上写地址需要注意](#235-页面上写地址需要注意)
            - [2.3.6 新建 `templates` >`project-agree.html`【`project` 工程】](#236-新建-templates-project-agreehtmlproject-工程)
            - [2.3.7 新建 `project-launch.html`【`project` 工程】](#237-新建-project-launchhtmlproject-工程)
        - [2.4 处理 `1. 项目及发起人信息` 的表单请求](#24-处理-1-项目及发起人信息-的表单请求)
            - [2.4.1 新建 `ProjectConsumerHandler` 类 【`project` 工程】](#241-新建-projectconsumerhandler-类-project-工程)
            - [2.4.2 追加跳转代码 `CrowdWebMvcConfig` 【`project` 工程】](#242-追加跳转代码-crowdwebmvcconfig-project-工程)
            - [2.4.3 新建  `project-return.html`页面`2. 回报设置`【`project` 工程】](#243-新建--project-returnhtml页面2-回报设置project-工程)
        - [2.5 处理  `2. 回报设置` 页面的表单请求](#25-处理--2-回报设置-页面的表单请求)
            - [2.5.1 追加图片上传代码 `ProjectConsumerHandler 类` 【`project` 工程】](#251-追加图片上传代码-projectconsumerhandler-类-project-工程)
            - [2.5.2 追加 `添加回报信息` 代码 `ProjectConsumerHandler 类` 【`project` 工程】](#252-追加-添加回报信息-代码-projectconsumerhandler-类-project-工程)
        - [2.6 处理3: 第三步 `确认信息` 页面 【`project` 工程】](#26-处理3-第三步-确认信息-页面-project-工程)
            - [2.6.1 添加 `view-comtorller` 代码](#261-添加-view-comtorller-代码)
            - [](#)
            - [2.6.2 新建 `project-confirm.html` 第三步: 确认信息页面](#262-新建-project-confirmhtml-第三步-确认信息页面)
            - [2.6.3 追加处理 `确认信息表单提交` 的代码](#263-追加处理-确认信息表单提交-的代码)
            - [2.6.4 追加跳转完成页面的代码](#264-追加跳转完成页面的代码)
            - [2.6.5 新建完成页面 `project-success.html`](#265-新建完成页面-project-successhtml)
        - [2.7 保存会员发起的众筹信息](#27-保存会员发起的众筹信息)
            - [2.7.1 追加 `mysql 的 Feign 接口` 代码【`api` 工程】](#271-追加-mysql-的-feign-接口-代码api-工程)
            - [2.7.2 保存会员发起的众筹信息 【`mysql` 工程】](#272-保存会员发起的众筹信息-mysql-工程)

- [二十一 前台-首页显示项目](#二十一-前台-首页显示项目)
    - [1. 首页显示项目](#1-首页显示项目)
        - [1.1 目标](#11-目标)
        - [1.2 思路](#12-思路)
        - [1.3 数据库](#13-数据库)
            - [1.3.1 分类表数据](#131-分类表数据)
            - [1.3.2 标签表数据](#132-标签表数据)
            - [1.3.3 数据库备份](#133-数据库备份)
        - [1.4 代码](#14-代码)
            - [1.4.1 新建 `PortalTypeVO` 实体类【`entity` 工程】](#141-新建-portaltypevo-实体类entity-工程)
            - [1.4.2 新建 `PortalProjectVO` 实体类【`entity` 工程】](#142-新建-portalprojectvo-实体类entity-工程)
            - [1.4.3  暴露数据查询的接口【`mysql` 工程】](#143--暴露数据查询的接口mysql-工程)
            - [1.4.4 声明一个 Feign 的接口 【`api` 工程】](#144-声明一个-feign-的接口-api-工程)
            - [1.4.5 调用 `mysql` 暴露的接口拿到数据存入到模型 【`auth` 工程】](#145-调用-mysql-暴露的接口拿到数据存入到模型-auth-工程)
            - [1.4.6 在 `portal.html` 中显示模型中的数据【`auth` 工程】](#146-在-portalhtml-中显示模型中的数据auth-工程)
    - [2. 显示项目详情](#2-显示项目详情)
        - [2.1 目标](#21-目标)
        - [2.2 思路](#22-思路)
        - [2.3 代码](#23-代码)
            - [2.3.1 创建 `DetailProjectVO`实体类【`entity` 工程】](#231-创建-detailprojectvo实体类entity-工程)
            - [2.3.2 创建 `DetailReturnVO`实体类【`entity` 工程】](#232-创建-detailreturnvo实体类entity-工程)
            - [2.3.3 暴露数据查询的接口【`mysql` 工程】](#233-暴露数据查询的接口mysql-工程)
            - [2.3.4 声明一个 Feign 的接口 【`api` 工程】](#234-声明一个-feign-的接口-api-工程)
            - [2.3.5 首页跳转到项目详情 `portal.html`【`auth` 工程】](#235-首页跳转到项目详情-portalhtmlauth-工程)
            - [2.3.6 调用 `mysql` 暴露的接口拿到数据存入到模型 【`project` 工程】](#236-调用-mysql-暴露的接口拿到数据存入到模型-project-工程)
            - [2.3.7 新建 `project-show-detail.html` 中显示模型中的数据【`project` 工程】](#237-新建-project-show-detailhtml-中显示模型中的数据project-工程)

- [二十二 前台-支付案例](#二十二-前台-支付案例)
    - [1. 支付宝开放平台](#1-支付宝开放平台)
    - [2. 电脑网站支付](#2-电脑网站支付)
        - [2.1 总体步骤参考](#21-总体步骤参考)
        - [2.2 应用](#22-应用)
        - [2.3 加密](#23-加密)
            - [2.3.1 对称加密](#231-对称加密)
            - [2.3.2 非对称加密](#232-非对称加密)
            - [2.3.3 调用支付宝接口时使用的秘钥](#233-调用支付宝接口时使用的秘钥)
            - [2.3.4 生成秘钥工具](#234-生成秘钥工具)
                - [2.3.5 生成商户秘钥](#235-生成商户秘钥)
        - [2.4 支付流程](#24-支付流程)
    - [3. 内网穿透](#3-内网穿透)
        - [3.1 上网的常规方式](#31-上网的常规方式)
        - [3.2 项目发布的常规方式](#32-项目发布的常规方式)
        - [3.3 现在面临的特殊情况](#33-现在面临的特殊情况)
        - [3.4 内网穿透](#34-内网穿透)
        - [3.5 内网穿透工具 `natapp`](#35-内网穿透工具-natapp)
            - [3.5.1 下载客户端工具](#351-下载客户端工具)
            - [3.5.2 注册购买隧道](#352-注册购买隧道)
            - [3.5.3 `Mac` 用户使用 `natapp`](#353-mac-用户使用-natapp)
            - [3.5.4 测试](#354-测试)
    - [4. 沙箱环境](#4-沙箱环境)
        - [4.1 进入沙箱环境](#41-进入沙箱环境)
        - [4.2 沙箱应用](#42-沙箱应用)
        - [4.3 沙箱测试 APP](#43-沙箱测试-app)
    - [5. 电脑网站支付 Demo](#5-电脑网站支付-demo)
        - [5.1 下载 Demo](#51-下载-demo)
    - [6. 使用 `Eclipse` 导入 `Demo`](#6-使用-eclipse-导入-demo)
    - [7. 使用 `Idea` 打开支付案例 `Demo`](#7-使用-idea-打开支付案例-demo)
        - [7.1 配置依赖 `command + ;`](#71-配置依赖-command--)
        - [7.2 配置 `Web` 和 `Tamcat Server`](#72-配置-web-和-tamcat-server)
        - [7.3 修改配置文件](#73-修改配置文件)
        - [7.4 启动 `Tomcat`](#74-启动-tomcat)
        - [7.5 测试](#75-测试)

- [二十三 前台-订单](#二十三-前台-订单)
    - [1. 搭建 `order` 开发环境](#1-搭建-order-开发环境)
        - [1.1 追加代码 `pom.xml`](#11-追加代码-pomxml)
        - [1.2 新建 `application.yml` 配置文件](#12-新建-applicationyml-配置文件)
        - [1.3 新建 `CrowdMainClass` 主启动类](#13-新建-crowdmainclass-主启动类)
    - [2. 配置 `zuul`](#2-配置-zuul)
        - [2.1 追加路由规则 `application.yml`](#21-追加路由规则-applicationyml)
    - [3. 建模](#3-建模)
        - [3.1 结构](#31-结构)
        - [3.2 物理建模](#32-物理建模)
            - [3.2.1 订单表](#321-订单表)
            - [3.2.2 收货地址表](#322-收货地址表)
            - [3.2.3 项目信息表](#323-项目信息表)
    - [4. 生成实体类, 逆向工程【reverse】工程](#4-生成实体类-逆向工程reverse工程)
        - [4.1 追加配置](#41-追加配置)
        - [4.2 将生成的文件移动到对应的位置](#42-将生成的文件移动到对应的位置)
    - [5. 目标1: 确认回报内容](#5-目标1-确认回报内容)
        - [5.1 思路](#51-思路)
        - [5.2 操作起点](#52-操作起点)
        - [5.3 新建 `OrderProjectVO`](#53-新建-orderprojectvo)
        - [5.4 新建 `OderHandler`](#54-新建-oderhandler)
        - [5.5 追加接口 【`api` 工程】](#55-追加接口-api-工程)
        - [5.6 完成接口【`mysql` 工程】](#56-完成接口mysql-工程)
        - [5.7 页面显示](#57-页面显示)
            - [5.7.1 新建 `confirm_return.html`](#571-新建-confirm_returnhtml)
    - [6. 目标2: 确认订单](#6-目标2-确认订单)
        - [6.1 思路](#61-思路)
        - [6.2 新建 `AddressVO`【`entity` 工程】](#62-新建-addressvoentity-工程)
        - [6.3 追加代码, Session 域合并回报数量【`order` 工程】](#63-追加代码-session-域合并回报数量order-工程)
        - [6.4 新建 confirm_order.html](#64-新建-confirm_orderhtml)
        - [6.5 追加代码: 获取用户的收货地址【`api` 工程】](#65-追加代码-获取用户的收货地址api-工程)
        - [6.6 追加代码【`mysql` 工程】](#66-追加代码mysql-工程)
        - [6.7 新增收货地址](#67-新增收货地址)
            - [6.7.1 思路](#671-思路)
            - [6.7.2 发起请求](#672-发起请求)
            - [6.7.3 `OrderHandler` 远程调用接口](#673-orderhandler-远程调用接口)
            - [6.7.4 `OrderProviderHandler`: 保存收货地址【`mysql` 工程】](#674-orderproviderhandler-保存收货地址mysql-工程)
            - [6.7.5 启用服务熔断机制【`mysql` 工程】](#675-启用服务熔断机制mysql-工程)
            - [6.7.6 启用服务降级机制](#676-启用服务降级机制)
    - [7. `Hystrix` 扩展](#7-hystrix-扩展)
        - [7.1 服务熔断机制](#71-服务熔断机制)
            - [7.1.1 `MemberProviderHandler` 的](#711-memberproviderhandler-的)
            - [7.1.2 `OrderProviderHandler`的](#712-orderproviderhandler的)
            - [7.1.3 `ProjectProviderHandler` 的](#713-projectproviderhandler-的)
            - [7.1.4 `redis` 工程整合 `Hystrix`](#714-redis-工程整合-hystrix)
        - [7.2 服务降级机制](#72-服务降级机制)
            - [7.2.1 新建 `RedisFallBackFactory`](#721-新建-redisfallbackfactory)
            - [7.2.2 使用 `RedisFallBackFactory`](#722-使用-redisfallbackfactory)

- [二十四 前台-支付](#二十四-前台-支付)
    - [1. 思路](#1-思路)
    - [2. 操作一: 搭建 `pay` 工程环境](#2-操作一-搭建-pay-工程环境)
        - [2.1 追加依赖和插件](#21-追加依赖和插件)
        - [2.2 新建 `CrowdMainClass`](#22-新建-crowdmainclass)
        - [2.3 新建 `PayProperties`](#23-新建-payproperties)
        - [2.4 新建 `application.yml`](#24-新建-applicationyml)
        - [2.5 新建 `OrderVO`【`entity` 工程】](#25-新建-ordervoentity-工程)
        - [2.6 追加路由规则【`zuul`工程】](#26-追加路由规则zuul工程)
    - [3. 操作二: 提交订单表单](#3-操作二-提交订单表单)
        - [3.1 提交表单 <关键代码>](#31-提交表单-关键代码)
        - [3.2 调用支付接口](#32-调用支付接口)
            - [3.2.1 新建 `PayHandler`](#321-新建-payhandler)
            - [3.2.2 `out_trade_no`（商户订单号）参数说明](#322-out_trade_no商户订单号参数说明)
    - [4. 操作三: `returnUrl`方法](#4-操作三-returnurl方法)
        - [4.1 追加代码](#41-追加代码)
    - [5. 操作四: `notifyUrl`方法](#5-操作四-notifyurl方法)
        - [5.1 追加代码](#51-追加代码)
        - [5.2 触发通知类型](#52-触发通知类型)
    - [6. 操作五: 订单信息保存到数据库](#6-操作五-订单信息保存到数据库)
        - [6.1 思路](#61-思路)
        - [6.2 `return` 方法](#62-return-方法)
        - [6.3 声明接口](#63-声明接口)
            - [6.3.1 对应的降级机制](#631-对应的降级机制)
        - [6.4 追加代码【`mysql` 工程】](#64-追加代码mysql-工程)




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
import org.junit.runner.RunWithimport org.slf4j.LoggerFactory;
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



# 十九 OSS

```
git checkout -b 19.0.0_oss
```

## 1. 阿里云的 OSS 对象存储

### 1.1 提出问题

#### 1.1.1 以前上传文件时保持位置

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661590226415-d1c0ea66-801e-4043-bd1e-0501ea065afe.png)



#### 1.1.2 问题1: Web 应用重新部署导致文件丢失

- 重新部署 Web 应用时, 卸载（删除）旧的 Web 应用, 连同用户上传的文件一起删除, 重新加载新的 Web 应用后, 以前用户上传的文件不会自动回复
- 危害总结: Web 应用重新部署会导致用户上传的文件丢失



#### 1.1.3 问题2: 集群环境下文件难以同步

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661590410265-6af2bd84-cab7-4565-837f-1268f7d5bf9a.png)



#### 1.1.4 问题3: Tomcat 被拖垮

- 用户上传的文件如果数据量膨胀到了一个非常庞大的体积, 那么就会严重影响 Tomcat 的运行效率



#### 1.1.5 问题4: 服务器存储自动扩容问题

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661591010244-37666a6d-9100-4b25-b6b5-f6d5f9dd3fc8.png)

- 危害总结: 手动对服务器进行扩容, 有可能导致项目中其他地方需要连带修改



### 1.2 解决方案介绍

#### 1.2.1 自己搭建文件服务器

- 举例: `FastDFS`
- 好处: 服务器可以自己维护、自己定制
- 缺点: 需要投入的人力、物力更多
- 适用: 规模比较大的项目, 要存储海量的文件



#### 1.2.2 使用第三方云服务

- 举例: 阿里云提供的 `OSS` 对象存储服务
- 好处: 不必自己维护服务器的软硬件资源。直接调用相关 `API` 即可操作, 更加轻量级
- 缺点: 数据不在自己手里。服务器不由自己维护
- 适用: 较小规模的应用, 文件数据不是绝对私密



### 1.3 开通 OSS 服务步骤

1. 注册阿里云账号
2. 完成实名认证
3. 找到 `对象存储 OSS`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661596511496-e7985f9e-38ec-499f-ab9f-c4a09da821b8.png)



1. 点击 **立即开通**

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661596572303-c6b1afc4-a2dd-428e-8f9f-5f027f68f002.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661596616072-e966a9e4-5b95-4d43-adc0-3989cfc25ec2.png)



### 1.4 使用 `OSS`

1. 打开 `OSS` 控制台

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661596723883-30eb12f7-d758-4ecb-984c-84a868556f91.png)



1. 创建 `Bucket`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661597404537-0acfe3e8-8f9c-4024-8338-e6acf773b181.png)



1. 新建目录

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661597690537-70d6688d-f123-4305-8ebb-6870dc1bf86c.png)



1. 上传文件

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661598175618-19b59af3-1782-4a95-9c09-3ed37267851f.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661598344400-9f6df9d0-35ef-4627-be47-1ee4d1699bb2.png)



1. 路径组成 `https://域名/图片路径`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661598451082-5eb9ba28-8ceb-47a1-9f3f-5f8b0ec257df.png)





### 1.5 Java 程序调用 OSS 服务接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661598711691-84e9b057-5c13-4342-b64d-ea3449e9682e.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661601017330-abbff1f9-cef8-4cf2-802f-d14e248e77f0.png)

#### 1.5.1 参考文档地址

https://help.aliyun.com/product/31815.html



#### 1.5.2 官网介绍

阿里云对象存储OSS（Object Storage Service）是一款海量、安全、低成本、高可靠的云存储服务，可提供99.9999999999%（12个9）的数据持久性，99.995%的数据可用性。多种存储类型供选择，全面优化存储成本。



#### 1.5.3 创建访问秘钥 `AccessKey`

- `AccessKey` -> `Java` 程序登录 `OSS` 进行操作
- 访问秘钥 `AccessKey（AK）`用于程序方式调用云服务 `API`
- 可以使用 `AccessKey` 构造一个 API 请求（或者使用云服务 SDK）来操作资源
- `AccessKey` 包括 `AccessKeyId` 和 `AccessKeySecret`
- 警告: 禁止使用主账号 `AK`,  因为主账号 `AK` 泄露会威胁您所有资源的安全。请使用子账号（`RAM` 用户）`AK` 进行登录, 可有效降低 `AK` 泄露的风险



#### 1.5.4 创建子账号 `AK` 的操作

1. 使用主账号登录 `RAM` 管理控制台
2. 如果未创建 `RAM` 用户, 在**左侧导航栏**, 搜索**访问控制**

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661599826708-19abe8c3-cc77-48cc-ae26-7babcba2feda.png)



1. 然后点击**用户**, **创建用户**

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661599947651-64ee55fd-c990-45a2-a771-3458339e7d04.png)

此处为语雀加密文本卡片，点击链接查看：https://www.yuque.com/lingchen-bf1rc/hoahc6/mrsgsa#lI0qc



1. 配置权限 `AliyunOSSFullAccess`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661600659680-8cb94a47-66d1-4e8d-ae6f-d2b119cf99a9.png)



#### 1.5.5 OSS 依赖

```xml
<!-- OSS Java SDK -->
<dependency>
    <groupId>com.aliyun.oss</groupId>
    <artifactId>aliyun-sdk-oss</artifactId>
    <version>3.5.0</version>
</dependency>
```



### 1.6 将 `OSS` 引入 `project` 项目

#### 1.6.1 `config` 包: `OSSProperties`

```java
package com.atguigu.crowd.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 陈江林
 * @date 2022/8/30 20:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class OSSProperties {

    /**
     * Bucket 名称
     */
    private String bucketName;

    /**
     * 地域节点
     */
    private String endPoint;

    /**
     * Bucket 域名
     */
    private String bucketDomain;

    /**
     * 访问标识
     */
    private String accessKeyId;

    /**
     * 访问秘钥
     */
    private String accessKeySecret;

}
```



#### 1.6.2 依赖

```xml
<dependencies>
    <dependency>
        <groupId>com.atguigu.crowd</groupId>
        <artifactId>atcrowdfunding17-member-api</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>

    <!-- 导入配置文件处理器, 配置文件进行绑定 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-configuration-processor</artifactId>
        <optional>true</optional>
    </dependency>

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

    <!-- SpringBoot 测试 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>

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



#### 1.6.3 新建 `CrowdMainClass`主启动类

```java
package com.atguigu.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 陈江林
 * @date 2022/8/30 23:09
 */
@EnableFeignClients
@SpringBootApplication
public class CrowdMainClass {

    public static void main(String[] args) {
        SpringApplication.run(CrowdMainClass.class, args);
    }

}
```



#### 1.6.4 新建 `application.yml` 配置

```yaml
server:
  port: 5000

spring:
  application:
    name: atguigu-crowd-project
  session:
    store-type: redis

eureka:
  client:
    service-url:
      defaultZone: http://localhost:1000/eureka

ribbon:
  # 10秒 - 处理请求的超时时间，默认为5秒
  ReadTimeout: 10000
  # 10秒 - 连接建立的超时时长，默认5秒
  ConnectTimeout: 10000

# 阿里云 oss 对象存储
aliyun:
  oss:
    bucket-name: atguigu220827
    end-point: oss-cn-guangzhou.aliyuncs.com
    bucket-domain: atguigu220827.oss-cn-guangzhou.aliyuncs.com
    access-key-id: LTAI5t5vpW9Fcqk8qBW7nvcV
    access-key-secret: fWxGZing02E6uZKE4NNV9W8RrzjjCT
```



### 1.7 `common` 工程

#### 1.7.1 追加依赖

```xml
<!-- OSS Java SDK -->
<dependency>
    <groupId>com.aliyun.oss</groupId>
    <artifactId>aliyun-sdk-oss</artifactId>
    <version>3.5.0</version>
</dependency>
```



#### 1.7.2 工具类 `CrowdUtil` 中追加方法

```java
/**
     * 专门负责上传文件到 OSS 服务器的工具方法
     *
     * @param bucketName
     * @param endpoint
     * @param bucketDomain
     * @param accessKeyId
     * @param accessKeySecret
     * @param inputStream     要上传文件的输入流
     * @param originalName    要上传文件的原始文件名
     * @return
     */
    public static ResultEntity<String> uploadFilterOss(
            String bucketName,
            String endpoint,
            String bucketDomain,
            String accessKeyId,
            String accessKeySecret,
            InputStream inputStream,
            String originalName) {
        // 创建 OSSClient 实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 生成生成文件的目录
        String folderName = new SimpleDateFormat("yyyyMMdd").format(new Date());

        // 生成生成文件在 OSS 服务器上保存时的文件名
        // 原始文件名: beaufulgirl.jpg
        // 生成文件名: wer234234efwer235346457dfswet346235.jpg
        // 使用 UUID 生成文件主体名称
        String fileMainName = UUID.randomUUID().toString().replace("_", "");

        // 从原始文件名中获取文件扩展名
        String extensionName = originalName.substring(originalName.lastIndexOf("."));

        // 使用目录、文件主体名称、文件扩展名称拼接得到对象名称
        String objectName = folderName + "/" + fileMainName + extensionName;

        try {
            // 调用 OSS 客户端对象的方法生成文件并获取响应结果数据
            // 上传文件
            PutObjectResult putObjectResult = ossClient.putObject(bucketName, objectName, inputStream);

            // 从响应结果中获取具体响应消息
            ResponseMessage responseMessage = putObjectResult.getResponse();

            // 根据响应状态码判断请求是否成功
            if (responseMessage == null) {
                // 成功
                // 拼接访问刚刚上传的文件路径
                String ossFileAccessPath = bucketDomain + "/" + objectName;

                return ResultEntity.successWithData(ossFileAccessPath);
            } else {
                // 获取响应状态码
                int staticCode = responseMessage.getStatusCode();

                // 如果请求没有成功, 获取错误消息
                String errorMessage = responseMessage.getErrorResponseAsString();

                // 当前方法返回失败
                return ResultEntity.failed("当前响应状态码: " + staticCode + "错误消息: " + errorMessage);
            }
        } catch (Exception e) {
            return ResultEntity.failed(e.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
```



#### 1.7.3 测试 OSS

```java
public static void main(String[] args) throws FileNotFoundException {
    FileInputStream inputStream = new FileInputStream("/Users/chenjianglin/Desktop/333.jpg");
    // ResultEntity{result='SUCCESS', message='null', data=atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220830/837093df-ee43-4370-8c44-48180fcb59eb.jpg}
    System.out.println(uploadFilterOss("atguigu220827",
            "oss-cn-guangzhou.aliyuncs.com",
            "atguigu220827.oss-cn-guangzhou.aliyuncs.com",
            "LTAI5t5vpW9Fcqk8qBW7nvcV",
            "fWxGZing02E6uZKE4NNV9W8RrzjjCT",
            inputStream,
            "333.jpg"));
}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661871136021-a5e2cf75-5624-433d-9921-3219af6548b0.png)



#### 1.7.4 如果报错: `Error: A JNI error has occurred, please check your installation and try agai`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661871030772-b4841106-bd85-4339-a44e-21f1061259eb.png)

- 解决

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661870974600-b84e3c3a-887a-4c88-a465-3c018a9a6c63.png)



# 二十 发起项目

```
git checkout -b 20.0.0_initiating_project
```

- 扩展: 实体类为什么要序列化: 要存入 Seesion 中所以需要序列化

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661672488857-1d6f3b3d-deae-4fa1-94fd-083ffcc4c308.png)



## 1. 发起项目 建模/准备

### 1.1 创建数据库

```sql
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '分类说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类表';

DROP TABLE IF EXISTS `t_project_type`;
CREATE TABLE `t_project_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectid` int(11) DEFAULT NULL COMMENT 't_project 标识',
  `typeid` int(11) DEFAULT NULL COMMENT 't_type 标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目和分类中间表';

DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '标签名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签表';

DROP TABLE IF EXISTS `t_project_tag`;
CREATE TABLE `t_project_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectid` int(11) DEFAULT NULL COMMENT 't_project 标识',
  `tagid` int(11) DEFAULT NULL COMMENT 't_tag 标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目标签中间表';

DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `project_description` varchar(255) DEFAULT NULL COMMENT '项目描述',
  `money` bigint(11) DEFAULT NULL COMMENT '筹集金额',
  `day` int(11) DEFAULT NULL COMMENT '筹集天数',
  `status` int(4) DEFAULT NULL COMMENT '[{0: 即将开始}, {1: 众筹中}, {2: 众筹成功}, {3: 众筹失败}]',
  `deploydate` varchar(255) DEFAULT NULL COMMENT '项目发起时间',
  `supportmoney` bigint(11) DEFAULT NULL COMMENT '已筹集到的金额',
  `supporter` int(11) DEFAULT NULL COMMENT '支持人数',
  `completion` int(3) DEFAULT NULL COMMENT '百分比完成度',
  `memberid` int(11) DEFAULT NULL COMMENT '发起人的会员标识',
  `createdate` varchar(19) DEFAULT NULL COMMENT '项目创建时间',
  `follower` int(11) DEFAULT NULL COMMENT '关注人数',
  `header_picture_path` varchar(255) DEFAULT NULL COMMENT '头图路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目表';

DROP TABLE IF EXISTS `t_project_item_pic`;
CREATE TABLE `t_project_item_pic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectid` int(11) DEFAULT NULL COMMENT 't_project 标识',
  `item_pic_path` varchar(255) DEFAULT NULL COMMENT '图片名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目表项目详情图片表';

DROP TABLE IF EXISTS `t_member_launch_info`;
CREATE TABLE `t_member_launch_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `memberid` int(11) DEFAULT NULL COMMENT 't_member 会员标识',
  `description_simple` varchar(255) DEFAULT NULL COMMENT '自我介绍',
  `description_detail` varchar(255) DEFAULT NULL COMMENT '详细介绍',
  `phone_num` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `service_num` varchar(255) DEFAULT NULL COMMENT '客服电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目发起人信息表';

DROP TABLE IF EXISTS `t_return`;
CREATE TABLE `t_return` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectid` int(11) DEFAULT NULL COMMENT 't_projcet 项目标识',
  `type` int(4) DEFAULT NULL COMMENT '[{0: 实物回报}, {1: 虚拟物品回报}]',
  `supportmoney` int(11) DEFAULT NULL COMMENT '支持金额',
  `content` varchar(255) DEFAULT NULL COMMENT '回报内容',
  `count` int(11) DEFAULT NULL COMMENT '回报产品限额 {0: 不限额回报数量}',
  `signalpurchase` int(11) DEFAULT NULL COMMENT '是否设置单笔限购',
  `purchase` int(11) DEFAULT NULL COMMENT '具体限购数量',
  `freight` int(11) DEFAULT NULL COMMENT '运费 {0: 包邮}',
  `invoice` int(4) DEFAULT NULL COMMENT '[{0: 不开发票}, {1: 开发票}]',
  `returndate` int(11) DEFAULT NULL COMMENT '项目结束后多少天向支持者发送回报',
  `describ_pic_path` varchar(255) DEFAULT NULL COMMENT '说明图片路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回报信息表';

DROP TABLE IF EXISTS `t_member_confirm_info`;
CREATE TABLE `t_member_confirm_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `memberid` int(11) DEFAULT NULL COMMENT 't_member 会员标识',
  `paynum` varchar(255) DEFAULT NULL COMMENT '易付宝企业账号',
  `cardnum` varchar(255) DEFAULT NULL COMMENT '法人身份证号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发起人确认信息表';
```



#### 1.1.1 分类表

```sql
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '分类说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类表';
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661656856456-11f99189-7280-4e72-9526-194d3a320cba.png)



#### 1.1.2 项目分类中间表

```sql
DROP TABLE IF EXISTS `t_project_type`;
CREATE TABLE `t_project_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectid` int(11) DEFAULT NULL COMMENT 't_project 标识',
  `typeid` int(11) DEFAULT NULL COMMENT 't_type 标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目和分类中间表';
```



#### 1.1.3 标签表

```sql
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '标签名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签表';
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661656985493-8a12fd3f-a72e-49e4-ad4b-ccb066f006bb.png)



#### 1.1.4 项目标签中间表

```sql
DROP TABLE IF EXISTS `t_project_tag`;
CREATE TABLE `t_project_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectid` int(11) DEFAULT NULL COMMENT 't_project 标识',
  `tagid` int(11) DEFAULT NULL COMMENT 't_tag 标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目标签中间表';
```



#### 1.1.5 项目表

```sql
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `project_description` varchar(255) DEFAULT NULL COMMENT '项目描述',
  `money` bigint(11) DEFAULT NULL COMMENT '筹集金额',
  `day` int(11) DEFAULT NULL COMMENT '筹集天数',
  `status` int(4) DEFAULT NULL COMMENT '[{0: 即将开始}, {1: 众筹中}, {2: 众筹成功}, {3: 众筹失败}]',
  `deploydate` varchar(255) DEFAULT NULL COMMENT '项目发起时间',
  `supportmoney` bigint(11) DEFAULT NULL COMMENT '已筹集到的金额',
  `supporter` int(11) DEFAULT NULL COMMENT '支持人数',
  `completion` int(3) DEFAULT NULL COMMENT '百分比完成度',
  `memberid` int(11) DEFAULT NULL COMMENT '发起人的会员标识',
  `createdate` varchar(19) DEFAULT NULL COMMENT '项目创建时间',
  `follower` int(11) DEFAULT NULL COMMENT '关注人数',
  `header_picture_path` varchar(255) DEFAULT NULL COMMENT '头图路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目表';
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661657194856-b126002e-e1bf-49ef-8c75-c4cd131a51fe.png)



#### 1.1.6 项目表项目详情图片表

```sql
DROP TABLE IF EXISTS `t_project_item_pic`;
CREATE TABLE `t_project_item_pic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectid` int(11) DEFAULT NULL COMMENT 't_project 标识',
  `item_pic_path` varchar(255) DEFAULT NULL COMMENT '图片名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目表项目详情图片表';
```



#### 1.1.7 项目发起人信息表

```sql
DROP TABLE IF EXISTS `t_member_launch_info`;
CREATE TABLE `t_member_launch_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `memberid` int(11) DEFAULT NULL COMMENT 't_member 会员标识',
  `description_simple` varchar(255) DEFAULT NULL COMMENT '自我介绍',
  `description_detail` varchar(255) DEFAULT NULL COMMENT '详细介绍',
  `phone_num` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `service_num` varchar(255) DEFAULT NULL COMMENT '客服电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目发起人信息表';
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661657828250-53d24dae-a4d9-4661-912f-2e363ce54028.png)



#### 1.1.8 回报信息表

```sql
DROP TABLE IF EXISTS `t_return`;
CREATE TABLE `t_return` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectid` int(11) DEFAULT NULL COMMENT 't_projcet 项目标识',
  `type` int(4) DEFAULT NULL COMMENT '[{0: 实物回报}, {1: 虚拟物品回报}]',
  `supportmoney` int(11) DEFAULT NULL COMMENT '支持金额',
  `content` varchar(255) DEFAULT NULL COMMENT '回报内容',
  `count` int(11) DEFAULT NULL COMMENT '回报产品限额 {0: 不限额回报数量}',
  `signalpurchase` int(11) DEFAULT NULL COMMENT '是否设置单笔限购',
  `purchase` int(11) DEFAULT NULL COMMENT '具体限购数量',
  `freight` int(11) DEFAULT NULL COMMENT '运费 {0: 包邮}',
  `invoice` int(4) DEFAULT NULL COMMENT '[{0: 不开发票}, {1: 开发票}]',
  `returndate` int(11) DEFAULT NULL COMMENT '项目结束后多少天向支持者发送回报',
  `describ_pic_path` varchar(255) DEFAULT NULL COMMENT '说明图片路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回报信息表';
```



#### 1.1.9 发起人确认信息表

```sql
DROP TABLE IF EXISTS `t_member_confirm_info`;
CREATE TABLE `t_member_confirm_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `memberid` int(11) DEFAULT NULL COMMENT 't_member 会员标识',
  `paynum` varchar(255) DEFAULT NULL COMMENT '易付宝企业账号',
  `cardnum` varchar(255) DEFAULT NULL COMMENT '法人身份证号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发起人确认信息表';
```





### 1.2. 逆向工程

- 追加配置 `generatorConfig.xml` 除中间表

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661666791177-397b1252-94f2-430c-961e-2333f17b01bb.png)

```xml
<table tableName="t_type" domainObjectName="TypePO"/>
<table tableName="t_tag" domainObjectName="TagPO"/>
<table tableName="t_project" domainObjectName="ProjectPO"/>
<table tableName="t_project_item_pic" domainObjectName="ProjectItemPicPO"/>
<table tableName="t_member_launch_info" domainObjectName="MemberLaunchInfoPO"/>
<table tableName="t_return" domainObjectName="ReturnPO"/>
<table tableName="t_member_confirm_info" domainObjectName="MemberConfirmInfoPO"/>
```

- 将生成的文件复制到相应的位置



### 1.3. `Mysql` 工程

#### 1.3.1 新建 `ProjectProviderHandler`

```java
package com.atguigu.crowd.handler;

import com.atguigu.crowd.service.api.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈江林
 * @date 2022/8/31 11:49
 */
@RestController
public class ProjectProviderHandler {
    
    @Autowired
    private ProjectService projectService;
    
}
```



#### 1.3.2 新建 `ProjectService`

```java
package com.atguigu.crowd.service.api;

/**
 * @author 陈江林
 * @date 2022/8/31 11:49
 */
public interface ProjectService {
}
```



#### 1.3.1 新建 `ProjectServiceImpl`

```java
package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.service.api.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 陈江林
 * @date 2022/8/31 11:49
 */
@Transactional(readOnly = true)
@Service
public class ProjectServiceImpl implements ProjectService {
}
```



### 1.4. 创建 `VO` 对象

#### 1.4.1 新建 `ProjcetVO`

```java
package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author 陈江林
 * @date 2022/8/31 11:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分类 id 集合
     */
    private List<Integer> typeIdList;

    /**
     * 标签 id 集合
     */
    private List<Integer> tagIdList;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目描述
     */
    private String projectDescription;

    /**
     * 计划筹集的金额
     */
    private Integer money;

    /**
     * 计划筹集的天数
     */
    private Integer day;

    /**
     * 创建项目的日期
     */
    private String createdate;

    /**
     * 头图的路径
     */
    private String headerPicturePath;

    /**
     * 详情图片的路径
     */
    private List<String> detailPicturePathList;

    /**
     * 发起人信息
     */
    private MemberLauchInfoVO memberLauchInfoVO;

    /**
     * 回报信息集合
     */
    private List<ReturnVO> returnVOList;

    /**
     * 发起人确认信息
     */
    private MemberConfirmInfoVO memberConfirmInfoVO;

}
```



#### 1.4.2 新建 `MemberLauchInfoVO`

```java
package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 项目发起人信息表
 *
 * @author 陈江林
 * @date 2022/8/31 13:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberLauchInfoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自我介绍
     */
    private String descriptionSimple;

    /**
     * 详细介绍
     */
    private String descriptionDetail;

    /**
     * 联系电话
     */
    private String phoneNum;

    /**
     * 客服电话
     */
    private String serviceNum;

}
```



#### 1.4.3 新建 `ReturnVO`

```java
package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 回报信息表
 *
 * @author 陈江林
 * @date 2022/8/31 13:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * t_projcet 项目标识
     */
    private Integer projectid;

    /**
     * [{0: 实物回报}, {1: 虚拟物品回报}]
     */
    private Integer type;

    /**
     * 支持金额
     */
    private Integer supportmoney;

    /**
     * 回报内容
     */
    private String content;

    /**
     * 回报产品限额 {0: 不限额回报数量}
     */
    private Integer count;

    /**
     * 是否设置单笔限购
     */
    private Integer signalpurchase;

    /**
     * 具体限购数量
     */
    private Integer purchase;

    /**
     * 运费 {0: 包邮}
     */
    private Integer freight;

    /**
     * [{0: 不开发票}, {1: 开发票}]
     */
    private Integer invoice;

    /**
     * 项目结束后多少天向支持者发送回报
     */
    private Integer returndate;

    /**
     * 说明图片路径
     */
    private String describPicPath;

}
```



#### 1.4.4 新建 `MemberConfirmInfoVO`

```java
package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 发起人确认信息表
 *
 * @author 陈江林
 * @date 2022/8/31 13:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberConfirmInfoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 易付宝企业账号
     */
    private String paynum;

    /**
     * 法人身份证号
     */
    private String cardnum;

}
```



### 1.5 修改 PO, 记得加 `@NoArgsConstructor`, `@AllArgsConstructor`, `@Data`

#### 1.5.1 修改 `ProjectPO`

- `private Long money;` 修改为 `private Integer money;` 并修改对应的

```java
package com.atguigu.crowd.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectPO {
    private Integer id;

    private String projectName;

    private String projectDescription;

    private Integer money;

    private Integer day;

    private Integer status;

    private String deploydate;

    private Long supportmoney;

    private Integer supporter;

    private Integer completion;

    private Integer memberid;

    private String createdate;

    private Integer follower;

    private String headerPicturePath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription == null ? null : projectDescription.trim();
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDeploydate() {
        return deploydate;
    }

    public void setDeploydate(String deploydate) {
        this.deploydate = deploydate == null ? null : deploydate.trim();
    }

    public Long getSupportmoney() {
        return supportmoney;
    }

    public void setSupportmoney(Long supportmoney) {
        this.supportmoney = supportmoney;
    }

    public Integer getSupporter() {
        return supporter;
    }

    public void setSupporter(Integer supporter) {
        this.supporter = supporter;
    }

    public Integer getCompletion() {
        return completion;
    }

    public void setCompletion(Integer completion) {
        this.completion = completion;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public Integer getFollower() {
        return follower;
    }

    public void setFollower(Integer follower) {
        this.follower = follower;
    }

    public String getHeaderPicturePath() {
        return headerPicturePath;
    }

    public void setHeaderPicturePath(String headerPicturePath) {
        this.headerPicturePath = headerPicturePath == null ? null : headerPicturePath.trim();
    }
}
```

## 2. 发起项目

### 2.1 总目标

- 将各个表单页面提交的数据汇总到一起保存到数据库



### 2.2 思路

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1661670258820-a7dd2744-82b2-4cef-844d-5f4c48fb9319.jpeg)



### 2.3 跳转`发起众筹`的表单页面

- 示例图:  ![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661913260478-304b6872-4e9f-4620-a57c-95aaa952dd2b.png)
- 从 `auth` 项目重定向到 `project` 项目, 使用 `/project/**` 访问



#### 2.3.1 点击 "我的众筹"`member-conter.html`【`auth` 工程】

```html
<div class="list-group-item " style="cursor:pointer;">
    <a th:href="@{/member/my/crowd}">我的众筹</a>
    <span class="badge"><i class="glyphicon glyphicon-chevron-right"></i></span>
</div>
```



#### 2.3.2 追加代码 `CrowdWebMvcConfig`【`auth` 工程】

```java
registry.addViewController("/member/my/crowd").setViewName("member-crowd");
```



#### 2.3.3 新建我的众筹页面 `member-crowd.html`【`auth` 工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661649775922-695e468c-a439-4107-8306-a40f98b93698.png)

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
    <script>
        $(function() {
            $('#myTab1 a').click(function (e) {
                e.preventDefault()
                $(this).tab('show')
            })
        })
    </script>
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
                                <li><a th:href="@{/auth/member/logout}"><i class="glyphicon glyphicon-off"></i> 退出系统</a>
                                </li>
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
                        <img src="img/services-box1.jpg" class="img-thumbnail"
                             alt="A generic square placeholder image with a white border around it, making it resemble a photograph taken with an old instant camera">
                        <div class="caption" style="text-align:center;">
                            <h3>
                                [[${session.loginMember.username}]]
                            </h3>
                            <span class="label label-danger" style="cursor:pointer;"
                                  onclick="window.location.href='cert.html'">未实名认证</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="list-group">
                <div class="list-group-item" style="cursor:pointer;" onclick="window.location.href='member.html'">
                    资产总览<span class="badge"><i class="glyphicon glyphicon-chevron-right"></i></span>
                </div>
                <div class="list-group-item active">
                    我的众筹<span class="badge"><i class="glyphicon glyphicon-chevron-right"></i></span>
                </div>
            </div>
        </div>
        <div class="col-sm-9 col-md-9 column">
            <ul id="myTab" style="" class="nav nav-pills" role="tablist">
                <li role="presentation" class="active"><a href="#home" role="tab" data-toggle="tab" aria-controls="home"
                                                          aria-expanded="true">我的众筹</a></li>
                <li role="presentation"><a href="#profile">众筹资产</a></li>
            </ul>
            <div id="myTabContent" class="tab-content" style="margin-top:10px;">
                <div role="tabpanel" class="tab-pane fade active in" id="home" aria-labelledby="home-tab">

                    <ul id="myTab1" class="nav nav-tabs">
                        <li role="presentation" class="active"><a href="#support">我支持的</a></li>
                        <li role="presentation"><a href="#attension">我关注的</a></li>
                        <li role="presentation"><a href="#add">我发起的</a></li>
                        <li class=" pull-right">
                            <script type="text/javascript">
                                $(function () {
                                    $("#launchCrowdBtn").click(function () {
                                        window.location.href = "[[${session.zuulPath}]]/project/agree/protocol/page";
                                    })
                                })
                            </script>
                            <button type="button" class="btn btn-warning" id="launchCrowdBtn">发起众筹</button>
                        </li>
                    </ul>
                    <div class="tab-content" style="margin-top:10px;">
                        <div role="tabpanel" class="tab-pane fade active in" id="support" aria-labelledby="home-tab">
                            <div class="container-fluid">
                                <div class="row clearfix">
                                    <div class="col-md-12 column">
                                        <span class="label label-warning">全部</span> <span class="label"
                                                                                          style="color:#000;">已支付</span>
                                        <span class="label " style="color:#000;">未支付</span>
                                    </div>
                                    <div class="col-md-12 column" style="margin-top:10px;padding:0;">
                                        <table class="table table-bordered" style="text-align:center;">
                                            <thead>
                                            <tr style="background-color:#ddd;">
                                                <td>项目信息</td>
                                                <td width="90">支持日期</td>
                                                <td width="120">支持金额（元）</td>
                                                <td width="80">回报数量</td>
                                                <td width="80">交易状态</td>
                                                <td width="120">操作</td>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td style="vertical-align:middle;">
                                                    <div class="thumbnail">
                                                        <div class="caption">
                                                            <h3>
                                                                活性富氢净水直饮机
                                                            </h3>
                                                            <p>
                                                                订单编号:2x002231111
                                                            </p>
                                                            <p>
                                                            <div style="float:left;"><i
                                                                    class="glyphicon glyphicon-screenshot"
                                                                    title="目标金额"></i> 已完成 100%
                                                            </div>
                                                            <div style="float:right;"><i title="截至日期"
                                                                                         class="glyphicon glyphicon-calendar"></i>
                                                                剩余8天
                                                            </div>
                                                            </p>
                                                            <br>
                                                            <div class="progress" style="margin-bottom: 4px;">
                                                                <div class="progress-bar progress-bar-danger"
                                                                     role="progressbar" aria-valuenow="40"
                                                                     aria-valuemin="0" aria-valuemax="100"
                                                                     style="width: 40%">
                                                                    <span>众筹中</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td style="vertical-align:middle;">2017-05-23 11:31:22</td>
                                                <td style="vertical-align:middle;">1.00<br>(运费：0.00 )</td>
                                                <td style="vertical-align:middle;">1</td>
                                                <td style="vertical-align:middle;">交易关闭</td>
                                                <td style="vertical-align:middle;">
                                                    <div class="btn-group-vertical" role="group"
                                                         aria-label="Vertical button group">
                                                        <button type="button" class="btn btn-default">删除订单</button>
                                                        <button type="button" class="btn btn-default">交易详情</button>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="vertical-align:middle;">
                                                    <div class="thumbnail">
                                                        <div class="caption">
                                                            <h3>
                                                                BAVOSN便携折叠移动电源台灯
                                                            </h3>
                                                            <p>
                                                                订单编号:2x002231111
                                                            </p>
                                                            <p>
                                                            <div style="float:left;"><i
                                                                    class="glyphicon glyphicon-screenshot"
                                                                    title="目标金额"></i> 已完成 100%
                                                            </div>
                                                            <div style="float:right;"><i title="截至日期"
                                                                                         class="glyphicon glyphicon-calendar"></i>
                                                                剩余8天
                                                            </div>
                                                            </p>
                                                            <br>
                                                            <div class="progress" style="margin-bottom: 4px;">
                                                                <div class="progress-bar progress-bar-success"
                                                                     role="progressbar" aria-valuenow="40"
                                                                     aria-valuemin="0" aria-valuemax="100"
                                                                     style="width: 40%">
                                                                    <span>众筹成功</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td style="vertical-align:middle;">2017-05-23 11:31:22</td>
                                                <td style="vertical-align:middle;">1.00<br>(运费：0.00 )</td>
                                                <td style="vertical-align:middle;">1</td>
                                                <td style="vertical-align:middle;">交易关闭</td>
                                                <td style="vertical-align:middle;">
                                                    <div class="btn-group-vertical" role="group"
                                                         aria-label="Vertical button group">
                                                        <button type="button" class="btn btn-default">删除订单</button>
                                                        <button type="button" class="btn btn-default">交易详情</button>
                                                    </div>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane fade" id="attension" aria-labelledby="attension-tab">
                            <div class="container-fluid">
                                <div class="row clearfix">
                                    <div class="col-md-12 column" style="padding:0;">
                                        <table class="table table-bordered" style="text-align:center;">
                                            <thead>
                                            <tr style="background-color:#ddd;">
                                                <td>项目信息</td>
                                                <td width="120">支持人数</td>
                                                <td width="120">关注人数</td>
                                                <td width="120">操作</td>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td style="vertical-align:middle;">
                                                    <div class="thumbnail">
                                                        <div class="caption">
                                                            <p>
                                                                BAVOSN便携折叠移动电源台灯
                                                            </p>
                                                            <p>
                                                                <i class="glyphicon glyphicon-jpy"></i> 已筹集 1000.0元
                                                            </p>
                                                            <p>
                                                            <div style="float:left;"><i
                                                                    class="glyphicon glyphicon-screenshot"
                                                                    title="目标金额"></i> 已完成 100%
                                                            </div>
                                                            <div style="float:right;"><i
                                                                    class="glyphicon glyphicon-calendar"></i> 剩余2天
                                                            </div>
                                                            </p>
                                                            <br>
                                                            <div class="progress" style="margin-bottom: 4px;">
                                                                <div class="progress-bar progress-bar-success"
                                                                     role="progressbar" aria-valuenow="40"
                                                                     aria-valuemin="0" aria-valuemax="100"
                                                                     style="width: 40%">
                                                                    <span>众筹中</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td style="vertical-align:middle;">1</td>
                                                <td style="vertical-align:middle;">1</td>
                                                <td style="vertical-align:middle;">
                                                    <div class="btn-group-vertical" role="group"
                                                         aria-label="Vertical button group">
                                                        <button type="button" class="btn btn-default">取消关注</button>
                                                    </div>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane fade  " id="add" aria-labelledby="add-tab">
                            <div class="container-fluid">
                                <div class="row clearfix">
                                    <div class="col-md-12 column">
                                        <span class="label label-warning">全部</span> <span class="label"
                                                                                          style="color:#000;">众筹中</span>
                                        <span class="label " style="color:#000;">众筹成功</span> <span class="label "
                                                                                                   style="color:#000;">众筹失败</span>
                                    </div>
                                    <div class="col-md-12 column" style="padding:0;margin-top:10px;">
                                        <table class="table table-bordered" style="text-align:center;">
                                            <thead>
                                            <tr style="background-color:#ddd;">
                                                <td>项目信息</td>
                                                <td width="120">募集金额（元）</td>
                                                <td width="80">当前状态</td>
                                                <td width="120">操作</td>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td style="vertical-align:middle;">
                                                    <div class="thumbnail">
                                                        <div class="caption">
                                                            <p>
                                                                BAVOSN便携折叠移动电源台灯
                                                            </p>
                                                            <p>
                                                            <div style="float:left;"><i
                                                                    class="glyphicon glyphicon-screenshot"
                                                                    title="目标金额"></i> 已完成 100%
                                                            </div>
                                                            <div style="float:right;"><i title="截至日期"
                                                                                         class="glyphicon glyphicon-calendar"></i>
                                                                剩余8天
                                                            </div>
                                                            </p>
                                                            <br>
                                                            <div class="progress" style="margin-bottom: 4px;">
                                                                <div class="progress-bar progress-bar-success"
                                                                     role="progressbar" aria-valuenow="40"
                                                                     aria-valuemin="0" aria-valuemax="100"
                                                                     style="width: 40%">
                                                                    <span>众筹中</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td style="vertical-align:middle;">1.00<br>(运费：0.00 )</td>
                                                <td style="vertical-align:middle;">草稿</td>
                                                <td style="vertical-align:middle;">
                                                    <div class="btn-group-vertical" role="group"
                                                         aria-label="Vertical button group">
                                                        <button type="button" class="btn btn-default">项目预览</button>
                                                        <button type="button" class="btn btn-default">修改项目</button>
                                                        <button type="button" class="btn btn-default">删除项目</button>
                                                        <button type="button" class="btn btn-default">问题管理</button>
                                                    </div>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <div role="tabpanel" class="tab-pane fade" id="profile" aria-labelledby="profile-tab">
                    众筹资产
                </div>
            </div>
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


</body>
</html>
```



#### 2.3.4 追加配置 `application.yml`【`zuul` 工程】

```yaml
zuul:
  routers:
    crowd-project:
      service-id: atguigu-crowd-project
      path: /project/**
```



#### 2.3.5 新建 `CrowdWebMvcConfig` 配置类【`project` 工程】

```java
package com.atguigu.crowd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 陈江林
 * @date 2022/8/31 14:12
 */
@Configuration
public class CrowdWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // view-controller 是在 project-consumer 内部定义的, 所以这里是一个不仅过 zuul 访问的地址
        registry.addViewController("/agree/protocol/page").setViewName("project-agree");
        registry.addViewController("/launch/protocol/page").setViewName("project-launch");
    }

}
```

- `project-agree`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661913850513-54dc9336-714b-47b6-8f75-70bd4fb599e8.png)

- `project-launch`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661916452699-fbca0129-75f4-4cf0-b87f-5c7a7721214b.png)



#### 2.3.5 页面上写地址需要注意

- 前面要写上域名（如果没有配置域名写 `localhost` 一样）, 确保通过 zuul 访问具体功能
- 因为必须通过 `zuul` 访问具体功能才能保持 `Cookie`, 进而保持 `Session` 一致

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661914227431-e4f3c4ef-6168-4582-b4f0-94093112092f.png)



#### 2.3.6 新建 `templates` >`project-agree.html`【`project` 工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661928891990-19965d78-7118-455b-af21-c7ebe3ece103.png)

```html
<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="https://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
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
    <script>
        $('#myTab a').click(function (e) {
            e.preventDefault()
            $(this).tab('show')
        })
    </script>
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

        .label-type, .label-status, .label-order {
            background-color: #fff;
            color: #f60;
            padding: 5px;
            border: 1px #f60 solid;
        }

        #typeList :not(:first-child) {
            margin-top: 20px;
        }

        .label-text {
            margin: 0 10px;
        }

        .panel {
            border-radius: 0;
        }
    </style>
</head>
<body>
<div class="navbar-wrapper">
    <div class="container">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.html" style="font-size: 32px;">尚筹网-创意产品众筹平台</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse"
                     style="float: right;">
                    <ul class="nav navbar-nav">
                        <li class="dropdown"><a href="#" class="dropdown-toggle"
                                                data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i>
                            [[${session.loginMember.username}]]<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="member.html"><i
                                        class="glyphicon glyphicon-scale"></i> 会员中心</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-comment"></i>
                                    消息</a></li>
                                <li class="divider"></li>
                                <li><a th:href="@{/auth/member/logout}"><i
                                        class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>

<div class="container theme-showcase" role="main">

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li>
                                <a rel="nofollow" href="index.html"><i class="glyphicon glyphicon-home"></i> 众筹首页</a>
                            </li>
                            <li>
                                <a rel="nofollow" href="projects.html"><i class="glyphicon glyphicon-th-large"></i> 项目总览</a>
                            </li>
                            <li class="active">
                                <a rel="nofollow" href="javascript:;"><i class="glyphicon glyphicon-edit"></i> 发起项目</a>
                            </li>
                            <li>
                                <a rel="nofollow" href="minecrowdfunding.html"><i class="glyphicon glyphicon-user"></i>
                                    我的众筹</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>


    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="panel panel-default">
                    <div class="panel-heading" style="text-align:center;">
                        <h3>
                            众筹平台项目发起人协议
                        </h3>
                    </div>
                    <div class="panel-body" style="height:400px;overflow-y:auto;padding:10px;">
                        <div class="test-box">
                            <p><b>在发起人使用尚筹网众筹平台提供的服务之前，请务必认真阅读本协议的全部内容。阅读本协议的过程中，如您不同意本协议或其中任何条款约定，您应立即停止注册（如：点击确认等后续操作），撤销注册流程。本协议一经发起人点击确认并同意接受，即产生法律效力。
                            </b></p>
                            <h5>第1条 签约主体</h5>
                            <p>
                                本协议由尚筹网网站（包括但不限于www.atcrowd.com及尚筹网众筹平台）的所有者及其关联公司（以下简称为“尚筹网”），在尚筹网众筹平台（zc.atcrowd.com）与登录、使用尚筹网众筹平台的项目发起人（以下简称
                                “发起人”）共同签署（签约地：江苏省南京市）。</p>
                            <h5>第2条 定 义</h5>
                            <p>2.1
                                尚筹网众筹平台：尚筹网众筹平台是一个可以让发起人的项目计划变为现实的梦想平台，是“致力于中国创造，实现创新创业者梦想”的平台，发起人可以在尚筹网众筹平台上发起创新项目的筹款需求，并承诺提供不同形式的回报给项目的支持者，支持者可通过预购发起人的项目成果或相关产品来表达对发起人的支持。</p>
                            <p>2.2发起人：指在尚筹网众筹平台上发起项目的法人。</p>
                            <p>2.3支持者：指对发起人的项目表示支持的尚筹网用户，支持者通过支付一定金额的预购款的方式，预购项目的衍生成果及/或相关产品。</p>
                            <p>2.4筹款成功：指在发起人设定的时间内，发起人与支持者订立的以项目成果及/或相关产品为回报标的的合同金额达到或超过了发起人设定的筹款金额。</p>
                            <p>2.5项目成功：指项目筹款成功后，发起人执行项目计划并最终形成项目成果，并按照支持者预购订单的约定向支持者交付项目成果及/或相关产品。</p>
                            <p>
                            </p><h5>第3条 立约背景</h5>
                            <p>3.1为保护支持者的合法权益，规范发起人的行为，维护尚筹网众筹平台的秩序，特拟定本协议。</p>
                            <p>
                                3.2尚筹网为发起人与支持者之间的交易行为提供平台网络空间、技术服务和支持，尚筹网并不是发起人或支持者中的任何一方，所有交易仅存在于发起人和支持者之间，使用尚筹网众筹平台产生的法律后果由发起人与支持者自行承担。</p>
                            <p>
                                3.3尚筹网会对所发起的项目的合理性、项目内容与回报的匹配度等进行形式审核，审核通过后才可发布到尚筹网众筹平台，但是项目通过尚筹网的审核并不代表尚筹网保证项目合法或不侵犯任何第三方的权利，发起人仍需对所发起的项目独立承担法律责任。</p>
                            <h5>第4条 协议生效和适用范围</h5>
                            <p>4.1本协议内容包括协议正文以及尚筹网网站已经发布的或将来可能发布的各类规则、操作流程。所有规则为本协议不可分割的一部分，与协议正文具有同等的法律效力。</p>
                            <p>
                                4.2当发起人在尚筹网众筹平台发起项目时，通过网络页面点击确认或以其他方式选择接受本协议，即表示与尚筹网达成协议并接受本协议的全部约定内容，本协议自发起人通过网络页面点击确认或以其他方式选择接受本协议之时起生效。本协议生效后，发起人不应以未阅读或不接受本协议的内容为由，主张本协议无效或要求撤销本协议。</p>
                            <p>
                                4.3尚筹网有权根据需要不定时修改本协议或各类规则、操作流程，如本协议有任何变更，尚筹网将在网站上以公示形式通知，且无需征得发起人的事先同意。修改后的协议及规则一经公示即生效，成为本协议的一部分。如发起人继续登录或使用尚筹网众筹平台的，即视为已阅读并接受修改后的协议。</p>
                            <p>
                                4.4发起人应该按照本协议约定行使权利并履行义务。如不能接受本协议的约定，包括但不限于不能接受修订后的协议及各类规则，则应立即停止使用尚筹网众筹平台提供的服务。如发起人继续使用服务，则表示同意并接受本协议及各类规则的约束。</p>
                            <h5>第5条 项目发起人资格</h5>
                            <p>5.1项目发起人应为尚筹网众筹平台的注册用户，完全理解并接受本协议。</p>
                            <p>5.2发起人可以为法人或其他组织且应是在中国境内合法成立、注册可独立承担法律责任的法律实体。</p>
                            <p>
                                5.3发起人在发起项目前，应通过尚筹网易付宝完成必要的身份认证和资质认证，包括但不限于营业执照、法人身份证等的实名认证。发起人在发起项目时同意并授权尚筹网众筹平台公示认证信息。</p>
                            <p>5.4发起人应按照尚筹网的要求开立账户，以接收支持者的支持款。</p>
                            <p>5.5如发起人申请发起的项目为带有公益性质的项目，则发起人应是合法成立的公益组织或与合法成立的公益组织共同发起项目。</p>
                            <p>5.6尚筹网众筹平台将根据申请发起的项目类型不同，对发起人需要满足的其他资格进行限定和要求。</p>
                            <h5>第6条 项目内容规范</h5>
                            <p>
                                6.1在尚筹网众筹平台上发起的项目应为具有创新性质且具有可执行性的项目，且项目目标须是明确、具体、可衡量的，如制作一个实物产品、拍一部微电影或完成一件艺术创作等。不得在无实质项目内容的情况下纯粹为公益组织发起募捐或以发起类似“资助奖学金”、“资助我去旅游”等为满足发起人个人需求之目的筹款。</p>
                            <p>6.2项目内容须符合法律法规及尚筹网网站的相关规定；尚筹网众筹平台有权对项目提出特殊要求。不得抄袭、盗用他人的成果发起众筹项目，创意类产品必须为原创。</p>
                            <p>
                                6.3项目的内容必须包含“我想要做什么事情”、“项目风险”、“项目回报”、“为什么需要支持”等信息。同时，应向项目支持者充分说明项目存在的风险及挑战，以便于项目支持者对项目有全面充分的了解，从而独立慎重做出是否投资的决定。</p>
                            <p>
                                6.4项目内容及发起人上传的相关项目信息（包含但不限于文字、图片、视频等）须为发起人原创，如非发起人原创，则发起人应已获得权利人的相应授权，且权利人允许发起人转授权给尚筹网及尚筹网的关联公司在尚筹网网站及尚筹网关联公司的其他官方网站及线下媒体出于宣传尚筹网众筹平台的目的而进行永久的免费宣传、推广、使用。</p>
                            <p>6.5项目不得含有攻击性、侮辱性言论，不得含有违反国家法律法规、政策的内容及其他尚筹网认为不适宜的内容。包括但不限于以下内容：</p>
                            <p>6.5.1违反国家法律规定的违禁品，如毒品、枪支弹药及管制刀具相关；</p>
                            <p>6.5.2非法、色情、淫秽、赌博、暴力、恐怖、反动、政治与宗教相关；</p>
                            <p>6.5.3开办公司、网站、店铺等相关；</p>
                            <p>6.5.4其他国家法律规定和尚筹网网站规定的禁限售等违禁品信息。</p>
                            <p>6.6项目回报发放完成前不允许对已经完成生产的商品进行销售，公益相关项目除外。</p>
                            <p>6.7 项目的排他性，项目在尚筹网众筹平台募集期内不得在其他任意平台同时发起类似项目或进行销售。一经发现，项目强行下架，并追究违约责任。</p>
                            <p>6.8尚筹网众筹平台对项目的审核仅针对项目的合理性、项目内容与回报的匹配度等进行审核，发起人应保证发起的项目内容合法，且不侵犯他人合法权益。</p>
                            <p>
                                6.9在尚筹网众筹平台上发起项目时，应明确众筹开始时间和结束时间，以及项目众筹成功后的回报时间。截止项目结束时间，如项目众筹金额等于或大于预定众筹金额，则项目众筹成功；如项目众筹金额低于预定众筹金额，则项目众筹失败。</p>
                            <h5>第7条 项目回报规范</h5>
                            <p>7.1项目回报必须与项目具有关联性。回报应为项目进行过程中发起人产出的衍生成果或相关商品，公益相关项目除外。</p>
                            <p>7.2
                                发起人承诺，如项目众筹成功，及时兑现对项目支持者承诺的回报；如项目众筹失败，同意尚筹网将众筹款项及时退还项目支持者，并由发起人就项目众筹失败的原因等对项目支持者做出解释。</p>
                            <p>7.3项目回报产品在尚筹网众筹平台设置的最高单价应低于项目成功结束后<b>两个月内</b>的产品市场售价的<b>90%</b> ，否则应将售价差额发还支持者。</p>
                            <p>7.4项目回报为实物的，产品量产后，应最先发放给尚筹网众筹平台支持该项目的支持者，否则将视为发起人违约，需承担违约责任及罚金。</p>
                            <p>7.5如发起人与项目支持者在兑现回报过程中发生纠纷，一切责任由发起人承担，如因此给尚筹网造成经济或名誉损失，发起人应赔偿尚筹网相关损失。</p>
                            <p>7.6如发起人在兑现对项目支持者的回报的过程中，与第三方（包括但不限于物流公司）发生纠纷，一切责任由发起人承担。</p>
                            <h5>第8条 发起人行为规范</h5>
                            <p>8.1项目审核通过后，发起人除可修改项目启动时间外，不得编辑、修改其他项目内容。</p>
                            <p>8.2项目筹款成功前，发起人如因故需取消项目的，需向尚筹网众筹平台提交取消申请，尚筹网众筹平台审核通过后项目取消，所有筹集到的款项由尚筹网退回给支持者。</p>
                            <p>8.3项目筹款成功后，发起人应严格按照项目计划执行，并在项目计划执行过程中积极与支持者互动。</p>
                            <p>
                                8.4项目筹款成功后，如项目因故延期或无法按原定项目计划执行的，或者因任何主观或客观因素导致项目最终无法完成的，发起人应第一时间通知尚筹网众筹平台，并及时通过尚筹网众筹平台及其他途径告知支持者，向支持者支付违约金，全额退还未履行订单的项目支持款。</p>
                            <p>8.5发起人在项目募集期间，不能以任何形式在其他平台上发起该项目。如违反该规定，尚筹网有权对发起人追究责任。</p>
                            <p>
                                8.6发起人应按照承诺发放项目回报（项目衍生成果及/或相关商品），发放的项目回报应无质量或权利瑕疵，如因项目回报发生纠纷，参照国家相关法规处理(例如:《消费者权益保护法》)。</p>
                            <p>8.7发起人在项目回报日前未完成回报，且无合理理由的，视为项目延期。<b>项目延期30天（含）以上的，视为项目失败</b>。尚筹网众筹平台有权通过系统直接向未确认收货的支持者退还支持款，发起人应当将支持款全额返还尚筹网众筹平台。
                            </p>
                            <p>8.8公益相关项目发起人应在完成项目后的合理时间内上传筹款项用于公益用途的相关凭证。</p>
                            <p>8.9发起人应提交真实、准确的项目信息（项目信息如有任何更新，应及时向尚筹网众筹平台提交更新后的信息），并自主上传、提交项目。</p>
                            <p>8.10发起人应自行承担准备或提交、完成项目而发生的费用，自行缴纳因从事本协议项下行为而产生的相应税款。</p>
                            <p>
                                8.11发起人应妥善保管尚筹网众筹平台的账号和密码，任何情况下发起人须对在该账号下发生的所有活动（包括但不限于信息披露、发布信息、上传图片或视频、网上点击同意或提交各类规则协议等）承担法律责任。</p>
                            <p>8.12发起人了解并同意，不得自行或允许任何第三方使用发起人的账号通过尚筹网众筹平台从事任何违反法律法规或侵犯第三方权利的行为，包含但不限于：</p>
                            <p>8.12.1侵犯任何第三方的专利、商标、著作权、商业秘密或其他合法权利，或违反任何法律或合同的；</p>
                            <p>8.12.2发起人的行为或项目信息是虚假的、误导性的、不准确的；</p>
                            <p>8.12.3发起人的行为或项目信息涉嫌非法、威胁、辱骂、骚扰、诽谤、中伤、欺骗、欺诈、侵权、淫秽、冒犯、亵渎或侵犯他人隐私的；</p>
                            <p>8.12.4未经接收方允许而向接收方发布任何邮件、宣传材料或广告信息；</p>
                            <p>8.12.5进行任何危害信息网络安全的行为，故意传播恶意程序或病毒以及其他破坏、干扰正常网络信息服务的行为。</p>
                            <p>8.13对于发起人通过尚筹网众筹平台发布的涉嫌违法或涉嫌侵犯他人合法权利或违反本协议的信息，尚筹网有权依据尚筹网的判断不经通知发起人即予以修改、编辑、删除等。</p>
                            <p>8.14实物回报类项目上线之前，发起人有义务主动提供样品进行评估审核，且项目一经上线无论众筹成功与否，样机不予退还。</p>
                            <p>
                                8.15发起人承诺不得未经尚筹网众筹平台同意擅自使用尚筹网众筹及其关联公司的任何知识产权。特别地，除非经尚筹网众筹平台书面批准，发起人在任何情形下都不在任何国家或地区将尚筹网众筹及其关联公司的商标及其类似商标、标识的全部或部分单独地或与其他任何商标、商号、文字或符号、域名合并使用或进行申请、注册等权力化行为。合作过程中，发起人应当在其知晓任何第三方可能侵犯尚筹网众筹平台知识产权时及时通知尚筹网众筹平台。</p>
                            <p>8.16发起人违反上述行为规范对任何第三方造成损害的，发起人均应当以自己的名义独立承担所有的法律责任，并赔偿尚筹网因此产生的损失或费用，包括但不限于商誉损失等。</p>
                            <h5>第9条 支持款交付及平台服务费</h5>
                            <p>9.1尚筹网众筹平台对支持款的交付及平台服务费的收取均通过第三方支付平台<b>尚筹网易付宝</b>进行收付。</p>
                            <p>9.2发起人使用尚筹网众筹平台服务，尚筹网将向发起人收取募集总金额3%的平台服务费，发起人与尚筹网另有约定的除外。</p>
                            <p>
                                9.3筹款成功后尚筹网众筹平台将在<b>3</b>个工作日内将募集总金额扣除平台服务费以及质量保证金（如有）后剩余款项的<b>60%</b>交付给发起人，并预留余下的<b>40%</b>作为确保项目成功并保证支持者获得回报的保证金(以下简称“保证金”)。在项目成功、无纠纷且所有支持者得到承诺回报的情况下，尚筹网将把这部分款项交付给发起人。发起人与尚筹网另有约定的除外。
                            </p>
                            <p>
                                9.4根据市场与技术的发展，尚筹网保留变更保证金及平台服务费比例的权利。在变更前，尚筹网将以适当的方式通知发起人变更情况，包括但不限于在尚筹网网站上公示。发起人有权选择接受或拒绝接受，如果发起人选择拒绝的，应立即停止使用尚筹网众筹平台的服务；发起人继续使用尚筹网众筹平台的，即视为发起人同意尚筹网的费用变更。变更后的收费比例对已经发布的项目无溯及力。</p>
                            <h5>第10条 知识产权</h5>
                            <p>10.1发起人承诺，对于通过尚筹网众筹平台发布、上传的所有内容均拥有合法权利，不侵犯任何第三方的肖像权、隐私权、专利权、商标权、著作权等合法权利及其他合同权利。</p>
                            <p>
                                10.2发起人通过尚筹网众筹平台发布、上传的任何内容，发起人授予尚筹网及其关联公司非独家的、可转授权的、不可撤销的、全球通用的、永久的、免费的许可使用权利，并可对上述内容进行修改、改写、改编、发行、翻译、创造衍生性内容及/或可以将前述部分或全部内容加以传播、表演、展示，及/或可以将前述部分或全部内容放入任何现在已知和未来开发出的以任何形式、媒体或科技承载的作品当中。</p>
                            <p>
                                10.3尚筹网众筹平台向发起人提供的服务含有受到相关知识产权及其他法律保护的专有保密资料或信息，亦可能受到著作权、商标、专利等相关法律的保护。未经尚筹网或相关权利人书面授权，发起人不得修改、出售、传播部分或全部该等信息，或加以制作衍生服务或软件，或通过进行还原工程、反向组译及其他方式破译原代码。</p>
                            <h5>第11条 纠纷处理</h5>
                            <p>11.1虚拟类回报不支持退换货，也不支持退款，如有发货错误、漏发或支持者收到的虚拟类回报存在质量问题的，发起人应在七日内免费予以重发或补发。</p>
                            <p>11.2实物类回报如有错发、漏发的，发起人应在七日内免费予以重发或补发，发起人无法重发或补发的，应退相应款项给支持者。</p>
                            <p>11.3项目回报有质量问题的，参照国家相关法规处理(例如:《消费者权益保护法》)。</p>
                            <p>
                                11.4发起人怠于处理纠纷或处理纠纷不符合尚筹网相关规定的，尚筹网众筹平台有权利用预留的保证金/质保金处理支持者纠纷。如保证金不足以处理纠纷，发起人有义务向尚筹网支付处理纠纷所产生的费用。</p>
                            <h5>第12条 违规处理</h5>
                            <p>12.1对于违反本协议或尚筹网网站规则的发起人，尚筹网有权进行违规处理，涉及的罚款可以从保证金/质保金中扣除。</p>
                            <p>12.2如发起人在筹款时间截止前非因不可抗力主动取消项目的，则发起人在一个月内不得再次发起项目。</p>
                            <p>
                                12.3如发起人在项目筹款成功后、发放回报前，非因不可抗力宣布项目失败或因项目延期而被认定为项目失败的，则发起人在三个月内不得再次发起项目，但如发起人已将支持者所支付的款项全额退回的，再次发起项目的时间可以不受限制。</p>
                            <p>12.4尚筹网有权对发起人是否涉嫌违规做出单方认定，并根据单方认定结果中止、终止对发起人的平台使用许可或采取其他限制措施。</p>
                            <p>12.5如发起人严重违反本协议、尚筹网网站规则或违反国家法律法规规定的，将被清退出尚筹网众筹平台，涉嫌犯罪的尚筹网将移送司法机关处理。</p>
                            <h5>第13条 违约责任</h5>
                            <p>
                                13.1如发起人涉嫌违反有关法律或者本协议之约定，使尚筹网及/或尚筹网的关联公司遭受任何损失，或受到任何第三方的索赔，或受到任何行政管理部门的处罚，发起人应当赔偿尚筹网因此遭受的损失及/或发生的费用，包括合理的律师费用、调查取证费用等，相关费用尚筹网有权从保证金/质保金中扣除，不足部分，由发起人另行支付补足。</p>
                            <p>
                                13.2任何一方违反其于本协议项下的陈述、保证或承诺，而使另一方遭受任何诉讼、纠纷、索赔、处罚等的，违约方应负责解决，使另一方发生任何费用、额外责任或遭受经济损失的，应当负责赔偿。如一方发生违约行为，守约方可以书面通知方式要求违约方在指定的时限内停止违约行为，要求其消除影响。如违约方未能按时停止违约行为，则守约方有权立即终止本协议。如因尚筹网自身原因造成发起人的损失，尚筹网向发起人承担的最大总体责任和赔偿限额不应超过在本协议项下尚筹网已向发起人收取的服务费总额。</p>
                            <p>13.3对于发起人应当承担的违约金，尚筹网有权从保证金/质保金中扣除，不予返还。</p>
                            <h5>第14条 协议终止及争议解决</h5>
                            <p>14.1在下列情况下，尚筹网可以随时无须承担任何义务和责任地全部或部分暂停、中止或终止履行本协议的义务或提供本协议项下的服务，直至解除本协议，且无须征得发起人的同意：</p>
                            <p>14.1.1发起的项目违反尚筹网众筹平台使用规则或本协议约定条款；</p>
                            <p>14.1.2发起人不同意接受本协议约定（含尚筹网发布的各类规则），且已停止使用尚筹网众筹平台针对项目发起人提供的服务；</p>
                            <p>14.1.3发起人不符合本协议约定的项目发起人应具备的资格的；</p>
                            <p>14.1.4发起的项目违反法律法规、监管政策或其他相关规定；</p>
                            <p>14.1.5发起的项目将引发或可能引发尚筹网运营的重大风险；</p>
                            <p>14.1.6发起的项目存在或可能存在明显危害支持者利益的风险；</p>
                            <p>14.1.7因不可归责于尚筹网的原因造成项目无法继续进行或项目回报无法实现的。</p>
                            <p>14.2因不可归责于尚筹网的原因造成协议终止，在协议终止前的行为所导致的任何赔偿和责任，发起人必须完全且独立地承担责任。</p>
                            <p>14.3无论本协议因何种原因终止，并不影响本协议终止前已经筹款成功项目的效力，发起人均应将筹款成功的项目履行完毕，或依照约定或本协议的规定对支持者承担责任。</p>
                            <p>14.4本协议及本协议项下的所有行为均适用中华人民共和国法律。</p>
                            <p>14.5协议各方因本协议的签订、履行或解释发生争议的，各方应友好协商解决。如协商不成，任何一方均应向合同签订地法院（即：南京市玄武区人民法院）提起诉讼。</p>
                            <p>14.6本协议的解释权归尚筹网众筹平台所有。</p>
                            <p>
                                <b>附件：</b>
                            </p>
                            <h5>《尚筹网众筹回报服务协议》</h5>
                            <h5>（注：本协议只适用于尚筹网众筹平台发布的科技、设计类众筹）</h5>
                            <p>鉴于：</p>
                            <p>
                                发起人在隶属于尚筹网（www.atcrowd.com）网站旗下尚筹网众筹平台（以下简称“尚筹网”）上发起项目筹款需求，并承诺给项目支持者提供回报。为保护支持者的合法权益，规范发起人的行为，维护众筹平台秩序，特拟定本协议。发起人承诺严格履行本协议约定，按照项目承诺为客户提供回报及相关服务。</p>
                            <h5>1、 回报产品的退换服务</h5>
                            <p>
                                1.1发起人承诺自支持者收到回报产品的15天内提供无理由退换货服务，退换货过程中产生的快递费用，由发起人承担。如支持者选择退货的，发起人应于收到退回货物之日起3个工作日内为支持者全额退款。如支持者选择换货的，发起人应于收到更换货物之日起5个工作日内完成换货处理。</p>
                            <p>
                                1.2发起人承诺自支持者收到回报产品的第16天至1年内，提供免费维修或换新服务。如回报产品出现质量问题或因非人为原因无法正常使用，发起人应在收到支持者所更换货物之日起5个工作日内完成换货处理。货物更换过程中产生的快递费用，由发起人承担。</p>
                            <p>1.3以下产品不适用于无理由退换货:</p>
                            <p class="indent">1.3.1 个人定做类产品；</p>
                            <p class="indent">1.3.2 文化类产品；</p>
                            <p class="indent">1.3.3 在线下载或者已经拆封的音像制品，计算机软件等数字化商品；</p>
                            <p class="indent">1.3.4 交付的报纸期刊类商品；</p>
                            <p class="indent">1.3.5
                                未经授权的维修、误用、碰撞、疏忽、滥用、进液、事故、改动、不正确的安装所造成的产品质量问题，或撕毁、涂改标贴、机器序号、防伪标记；</p>
                            <p class="indent">1.3.6其他根据产品性质不适宜退换货，或在众筹项目发起时已经明确表示不适用退换货的产品。</p>

                            <p>1.4为保证产品在<strong><u>1年保修期</u></strong>内的售后服务质量，发起人须向尚筹网缴纳质量保证金（简称“质保金”），作为尚筹网处理客户投诉或产品质量问题用：
                            </p>
                            <p> 若发起人为尚筹网（或尚筹网关联公司）已有合作方的，与已有合作业务关联，以尚筹网（或尚筹网关联公司）对发起人的应付账款作为质押，包括但不限于货款、保证金等。
                            </p>
                            <p>若发起人非尚筹网（或尚筹网关联公司）已有合作方的，在项目筹款成功后，尚筹网从项目所筹得款项中自动扣取下述约定金额作为质量保证金，自所有支持者收到回报产品<strong><u>
                                1年</u></strong>以后，且发起人已经妥善处理所有客户投诉后，尚筹网将此质保金返还发起人，具体金额要求如下：</p>
                            <table class="table-initiate">
                                <tbody>
                                <tr>
                                    <th align="center"><strong>众筹项目分类 </strong></th>
                                    <th align="center"><strong>质保金 </strong></th>
                                    <th align="center"><strong>质保金上下限 </strong></th>
                                </tr>
                                <tr>
                                    <td>手机、电脑、数码、办公设备、网络设备、智能设备等</td>
                                    <td rowspan="2">所筹金额×2.5%</td>
                                    <td rowspan="9">下限：1000元<br>
                                        上限：10万元<br>
                                        （即：最低收取1000元，最高收取10万元）
                                    </td>
                                </tr>
                                <tr>
                                    <td>孕婴用品、儿童用品（童装、童鞋、玩具）等</td>
                                </tr>
                                <tr>
                                    <td>空调、电视、冰箱、洗衣机、影音产品等</td>
                                    <td rowspan="4">所筹金额×2%</td>
                                </tr>
                                <tr>
                                    <td>厨卫大家电、厨房小家电、西式厨房电器、生活小家电、个人护理等</td>
                                </tr>
                                <tr>
                                    <td>户外装备、体育器材、骑行装备、健身器材、垂钓用品、车载电器、汽车配件等</td>
                                </tr>
                                <tr>
                                    <td>家纺、家具、灯具、建材、厨房卫浴用品、清洁用品、餐厨用具、生活日用、成人用品、宠物用品等</td>
                                </tr>
                                <tr>
                                    <td>日化用品（美妆、护肤、洗护用品）等</td>
                                    <td rowspan="3">所筹金额×1%</td>
                                </tr>
                                <tr>
                                    <td>图书、文化用品类</td>
                                </tr>
                                <tr>
                                    <td>其它</td>
                                </tr>
                                </tbody>
                            </table>
                            <h5>2、 延迟回报（发货）补偿</h5>
                            <p>
                                众筹项目成功后，发起人应确保按照项目承诺及时为支持者提供回报。如出现回报延迟或未及时发货的情况，发起人应按照以下标准对支持者进行补偿。除项目失败造成的全额退款的情形外，其余情况的补偿金支付时间不得晚于支持者收到货物的时间。</p>
                            <p>
                            </p>
                            <table class="table-initiate">
                                <tbody>
                                <tr>
                                    <th>延迟发货天数（单位：日）</th>
                                    <th>延迟交付违约金/其他处理措施</th>
                                </tr>
                                <tr>
                                    <td>X≤30</td>
                                    <td>违约金为：未履行订单总金额的5%</td>
                                </tr>
                                <tr>
                                    <td>X&gt;30</td>
                                    <td>项目失败，按照已履行订单总金额的5%支付违约金，并全额退还未履行订单的众筹款给支持者，未履行订单取消</td>
                                </tr>
                                </tbody>
                            </table>
                            <p></p>
                            <p>
                                X为延迟发货天数，自承诺回报期限的最后一天的次日起算。如延迟天数达到30日，即视为发起人已经无法提供回报，项目失败，发起人应向所有支持者发表致歉声明或阐述说明，并在3日内完成未履行订单的退款。若发起人在延迟天数未满30天时，与支持者达成一致，并另行约定发货时间的除外。</p>
                            <h5>3、 服务响应时效</h5>
                            <p>
                                在项目回报过程中，发起人应积极响应支持者、尚筹网或尚筹网众筹平台提出的各项问题和需求。对于提问邮件或各项需求邮件，应于2个工作日内回复处理意见或对申请进行处理。如发起人未按以上规定时间回复意见或进行相应处理，尚筹网或尚筹网众筹平台均有权从客户为先理念角度代发起人回复或处理，发起人应按照尚筹网或尚筹网众筹平台的处理意见为客户提供相关服务，因此造成的损失或产生的费用由发起人承担。</p>
                            <h5>4、 违约责任</h5>
                            <p>
                                4.1如发起人涉嫌违反有关法律或者本协议之约定，使尚筹网或尚筹网众筹平台遭受任何损失包括但不限于，受到任何第三方的诉讼、纠纷、索赔，受到任何行政管理部门的处罚，发起人应当赔偿尚筹网或尚筹网众筹平台因此遭受的损失及/或发生的费用，包括合理的律师费用、调查取证费用等。</p>
                            <p>4.2对于发起人应当承担的违约金，尚筹网或尚筹网众筹平台有权从发起人的保证金及质保金或其他由尚筹网或尚筹网众筹平台控制的款项中直接抵扣，不予返还。<b>保证金及质保金不足以支付的，尚筹网或尚筹网众筹平台均有权继续向发起人追偿。</b>
                            </p>
                            <h5>5、 其他</h5>
                            <p>
                                5.1发起人同意遵守尚筹网网站（www.atcrowd.com）及其旗下任何网站已经发布的或将来可能发布的各类规则、操作流程。对违反约定或规定给客户造成损失的，发起人愿意接受尚筹网或尚筹网众筹平台的各项处罚。</p>
                            <p>5.2凡因本协议引起的或与本协议有关的任何争议，由双方友好协商解决。协商不成时，任何一方均应向合同签订地法院（即：南京市玄武区人民法院）提起诉讼。</p>
                        </div>
                    </div>
                    <div class="panel-footer" style="text-align:center;">
                        <script type="text/javascript">
                            $(function () {
                                $("#toLaunchPage").click(function () {
                                    window.location.href = '[[${session.zuulPath}]]/project/launch/protocol/page';
                                })
                            })
                        </script>
                        <button type="button" class="btn  btn-warning btn-lg"
                                id="toLaunchPage">阅读并同意协议
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="container" style="margin-top:20px;">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div id="footer">
                    <div class="footerNav">
                        <a rel="nofollow" href="http://www.layoutit.cn">关于我们</a> | <a rel="nofollow"
                                                                                      href="http://www.layoutit.cn">服务条款</a>
                        | <a rel="nofollow" href="http://www.layoutit.cn">免责声明</a> | <a rel="nofollow"
                                                                                        href="http://www.layoutit.cn">网站地图</a>
                        | <a rel="nofollow" href="http://www.layoutit.cn">联系我们</a>
                    </div>
                    <div class="copyRight">
                        Copyright ?2017-2017layoutit.cn 版权所有
                    </div>
                </div>

            </div>
        </div>
    </div>

</div> <!-- /container -->

</body>
</html>
```



#### 2.3.7 新建 `project-launch.html`【`project` 工程】

```html
<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="https://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
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
    <script type="text/javascript" src="layer/layer.js"></script>
    <script>
        function checkExitsts(arr, id) {
            for (var i = 0; i < arr.length; i++) {
                if (arr[i] === id) {
                    // 从数组中删除元素, i是元素索引, 1是删除数量
                    arr.splice(i, 1)
                    return;
                }
            }

            // 将当前标签的 id 加入大户组
            arr.push(id);
        }

        // 声明全局变量用于存储选中的标签的 id
        var tagIdList = [];

        $(function () {
            var message = "[[${message}]]";
            if (message !== "") {
                layer.msg(message);
            }

            $('#myTab a').click(function (e) {
                e.preventDefault()
                $(this).tab('show')
            })

            $(".tagLable").click(function () {
                // 标签文本显示框如果有 selected 就去掉, 如果没有就加上
                $(this).toggleClass("selected");

                // 获取当前文本显示框的 id （也就是标签的 id）
                var tagId = this.id;

                // 判定 tagId 是否在数组中, 如果在则删除, 如果不在则添加
                checkExitsts(tagIdList, tagId);
            })

            // 上传图片按钮 触发 文件选择框
            $("#uploadHeadBtn").click(function () {
                // 调用  click() 函数, 相当于被单击了一下
                $("[name=headerPicture]").click();
            })

            // 【项目头图】文件选择框, 只选择头一个文件
            $("[name=headerPicture]").change(function (event) {
                // 获取用户选中的文件
                var files = event.target.files;

                // 获取小标 0, 选择唯一的一个文件
                var file = files[0];

                // 获取 URL 对象
                var url = window.url || window.webkitURL;

                // 调用 url 对象额 createObjectURL() 方法获取当选中的文件在系统的路径
                var path = url.createObjectURL(file);

                // 使用 path 修改 img 标签的 src 属性
                $(this).next().next().next().next().attr("src", path).show();
            })

            //【项目详情】 点击上传详情按钮 触发 文件选择框
            $("#uploadDetailBtn").click(function () {
                $("[name=detailPictureList]").click();
            })

            // 文件选择框, 可以选择多个文件
            $("[name=detailPictureList]").change(function (event) {
                $("#showDetailPicture").empty();

                // 获取用户选中的文件
                var files = event.target.files;

                // 获取 URL 对象
                var url = window.url || window.webkitURL;

                for (var i = 0; i < files.length; i++) {
                    var file = files[i];

                    var path = url.createObjectURL(file);

                    var imgHtml = "<img src='" + path + "' /><br/>";

                    $("#showDetailPicture").append(imgHtml);
                }
            })

            // 点击下一步按钮提交表单
            $("#submitBtn").click(function () {
                // 将表单中标签 id 的值组成的数组转换成表单内的隐藏域
                for (var i = 0; i < tagIdList.length; i++) {
                    var tagId = tagIdList[i];

                    var hiddenInputHTML = "<input type='hidden' name='tagIdList' value='" + tagId + "'/>";

                    $("#projectForm").append(hiddenInputHTML);
                }

                // 提交表单
                $("#projectForm").submit();
            })
        })
    </script>
    <style>
        .selected {
            color: yellow;
            background-color: green;
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

        .label-type, .label-status, .label-order {
            background-color: #fff;
            color: #f60;
            padding: 5px;
            border: 1px #f60 solid;
        }

        #typeList :not(:first-child) {
            margin-top: 20px;
        }

        .label-txt {
            margin: 10px 10px;
            border: 1px solid #ddd;
            padding: 4px;
            font-size: 14px;
        }

        .panel {
            border-radius: 0;
        }

        .progress-bar-default {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<div class="navbar-wrapper">
    <div class="container">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.html" style="font-size: 32px;">尚筹网-创意产品众筹平台</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse"
                     style="float: right;">
                    <ul class="nav navbar-nav">
                        <li class="dropdown"><a href="#" class="dropdown-toggle"
                                                data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i>
                            [[${session.loginMember.username}]]<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="member.html"><i
                                        class="glyphicon glyphicon-scale"></i> 会员中心</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-comment"></i>
                                    消息</a></li>
                                <li class="divider"></li>
                                <li><a th:href="@{/auth/member/logout}"><i
                                        class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>

<div class="container theme-showcase" role="main">

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="collapse navbar-collapse"
                         id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a rel="nofollow" href="index.html"><i
                                    class="glyphicon glyphicon-home"></i> 众筹首页</a></li>
                            <li><a rel="nofollow" href="projects.html"><i
                                    class="glyphicon glyphicon-th-large"></i> 项目总览</a></li>
                            <li class="active"><a rel="nofollow" href="javascript:;"><i
                                    class="glyphicon glyphicon-edit"></i> 发起项目</a></li>
                            <li><a rel="nofollow" href="minecrowdfunding.html"><i
                                    class="glyphicon glyphicon-user"></i> 我的众筹</a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <form id="projectForm" th:action="@{/project/create/project/information}" method="post"
                      enctype="multipart/form-data" class="form-horizontal">
                    <p th:text="${message}"></p>
                    <div class="panel panel-default">
                        <div class="panel-heading" style="text-align: center;">
                            <div class="container-fluid">
                                <div class="row clearfix">
                                    <div class="col-md-3 column">
                                        <div class="progress"
                                             style="height: 50px; border-radius: 0; position: absolute; width: 75%; right: 49px;">
                                            <div class="progress-bar progress-bar-success"
                                                 role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                                 aria-valuemax="100" style="width: 100%; height: 50px;">
                                                <div style="font-size: 16px; margin-top: 15px;">1.
                                                    项目及发起人信息
                                                </div>
                                            </div>
                                        </div>
                                        <div
                                                style="right: 0; border: 10px solid #ddd; border-left-color: #88b7d5; border-width: 25px; position: absolute; border-left-color: rgba(92, 184, 92, 1); border-top-color: rgba(92, 184, 92, 0); border-bottom-color: rgba(92, 184, 92, 0); border-right-color: rgba(92, 184, 92, 0);">
                                        </div>
                                    </div>
                                    <div class="col-md-3 column">
                                        <div class="progress"
                                             style="height: 50px; border-radius: 0; position: absolute; width: 75%; right: 49px;">
                                            <div class="progress-bar progress-bar-default"
                                                 role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                                 aria-valuemax="100" style="width: 100%; height: 50px;">
                                                <div style="font-size: 16px; margin-top: 15px;">2.
                                                    回报设置
                                                </div>
                                            </div>
                                        </div>
                                        <div
                                                style="right: 0; border: 10px solid #ddd; border-left-color: #88b7d5; border-width: 25px; position: absolute; border-left-color: rgba(221, 221, 221, 1); border-top-color: rgba(221, 221, 221, 0); border-bottom-color: rgba(221, 221, 221, 0); border-right-color: rgba(221, 221, 221, 0);">
                                        </div>
                                    </div>
                                    <div class="col-md-3 column">
                                        <div class="progress"
                                             style="height: 50px; border-radius: 0; position: absolute; width: 75%; right: 49px;">
                                            <div class="progress-bar progress-bar-default"
                                                 role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                                 aria-valuemax="100" style="width: 100%; height: 50px;">
                                                <div style="font-size: 16px; margin-top: 15px;">3.
                                                    确认信息
                                                </div>
                                            </div>
                                        </div>
                                        <div
                                                style="right: 0; border: 10px solid #ddd; border-left-color: #88b7d5; border-width: 25px; position: absolute; border-left-color: rgba(221, 221, 221, 1); border-top-color: rgba(221, 221, 221, 0); border-bottom-color: rgba(221, 221, 221, 0); border-right-color: rgba(221, 221, 221, 0);">
                                        </div>
                                    </div>
                                    <div class="col-md-3 column">
                                        <div class="progress" style="height: 50px; border-radius: 0;">
                                            <div class="progress-bar progress-bar-default"
                                                 role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                                 aria-valuemax="100" style="width: 100%; height: 50px;">
                                                <div style="font-size: 16px; margin-top: 15px;">4. 完成</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-body">
                            <div class="container-fluid">
                                <div class="row clearfix">
                                    <div class="col-md-12 column">
                                        <blockquote
                                                style="border-left: 5px solid #f60; color: #f60; padding: 0 0 0 20px;">
                                            <b> 项目及发起人信息 </b>
                                        </blockquote>
                                    </div>
                                    <div class="col-md-12 column">
                                        <div class="page-header" style="border-bottom-style: dashed;">
                                            <h3>项目信息</h3>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">分类信息</label>
                                            <div class="col-sm-10">
                                                <label class="radio-inline">
                                                    <input type="checkbox" name="typeIdList"
                                                           id="inlineRadio1"
                                                           value="1"> 科技
                                                </label>
                                                <label class="radio-inline">
                                                    <input
                                                            type="checkbox" name="typeIdList"
                                                            id="inlineRadio2" value="2" checked="checked"> 设计
                                                </label>
                                                <label class="radio-inline">
                                                    <input
                                                            type="checkbox" name="typeIdList"
                                                            id="inlineRadio3" value="3"> 公益
                                                </label>
                                                <label class="radio-inline">
                                                    <input
                                                            type="checkbox" name="typeIdList"
                                                            id="inlineRadio4" value="4" checked="checked"> 农业
                                                </label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">标签</label>
                                            <div class="col-sm-10">
                                                <ul style="list-style: none; padding-left: 0;">
                                                    <li style="margin: 10px 0">[手机] <span
                                                            class="tagLable label-txt" id="4">大屏</span> <span
                                                            class="tagLable label-txt" id="5">美颜</span> <span
                                                            class="tagLable label-txt" id="6">续航</span>
                                                    </li>
                                                    <li style="margin: 10px 0">[数码] <span
                                                            class="tagLable label-txt" id="7">高解析度</span> <span
                                                            class="tagLable label-txt" id="8">高清</span>
                                                    </li>
                                                    <li style="margin: 10px 0">[电脑] <span
                                                            class="tagLable label-txt" id="9">大内存</span> <span
                                                            class="tagLable label-txt" id="10">固态</span>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">项目名称</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="projectName" value="brotherMao"
                                                       class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">一句话简介</label>
                                            <div class="col-sm-10">
                                                <textarea name="projectDescription" class="form-control"
                                                          rows="5">就是帅！</textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">筹资金额（元）</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="money" value="100000" class="form-control"
                                                       style="width: 100px;"> <label
                                                    class="control-label">筹资金额不能低于100元,不能高于1000000000元</label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">筹资天数（天）</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="day" value="30" class="form-control"
                                                       style="width: 100px;"> <label
                                                    class="control-label">一般10-90天，建议30天</label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">项目头图</label>
                                            <div class="col-sm-10">
                                                <input type="file" name="headerPicture"
                                                       style="display: none;"/>
                                                <button id="uploadHeadBtn" type="button"
                                                        class="btn btn-primary btn-lg active">上传图片
                                                </button>
                                                <label class="control-label">图片上无文字,支持jpg、jpeg、png、gif格式，大小不超过2M，建议尺寸：740*457px</label>
                                                <br/><img style="display: none;"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">项目详情</label>
                                            <div class="col-sm-10">
                                                <input type="file" multiple="multiple" name="detailPictureList"
                                                       style="display: none;"/>
                                                <button id="uploadDetailBtn" type="button"
                                                        class="btn btn-primary btn-lg active">上传图片
                                                </button>
                                                <label class="control-label">支持jpg、jpeg、png、gif格式，大小不超过2M，建议尺寸：宽740px</label>
                                                <div id="showDetailPicture"></div>
                                            </div>
                                        </div>
                                        <!-- </form> -->
                                    </div>
                                    <div class="col-md-12 column">
                                        <div class="page-header" style="border-bottom-style: dashed;">
                                            <h3>发起人信息</h3>
                                        </div>
                                        <!-- <form class="form-horizontal"> -->
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">自我介绍</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="memberLauchInfoVO.descriptionSimple"
                                                       value="i am mao" class="form-control"
                                                       placeholder="一句话自我介绍，不超过40字">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">详细自我介绍</label>
                                            <div class="col-sm-10">
													<textarea name="memberLauchInfoVO.descriptionDetail"
                                                              class="form-control" rows="5"
                                                              placeholder="向支持者详细介绍你自己或你的团队及项目背景，让支持者在最短时间内了解你，不超过160字">我是猫哥</textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">联系电话</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="memberLauchInfoVO.phoneNum" value="123456"
                                                       class="form-control"
                                                       placeholder="此信息不会显示在项目页面">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">客服电话</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="memberLauchInfoVO.serviceNum" value="654321"
                                                       class="form-control"
                                                       placeholder="此信息显示在项目页面">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer" style="text-align: center;">
                            <!--<a  href="http://localhost:80/project/return/info/page" type="button" class="btn  btn-warning btn-lg">下一步</a>-->
                            <button id="submitBtn" type="button" class="btn  btn-warning btn-lg">下一步</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="container" style="margin-top:20px;">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div id="footer">
                    <div class="footerNav">
                        <a rel="nofollow" href="http://www.layoutit.cn">关于我们</a> | <a rel="nofollow"
                                                                                      href="http://www.layoutit.cn">服务条款</a>
                        | <a rel="nofollow" href="http://www.layoutit.cn">免责声明</a> | <a rel="nofollow"
                                                                                        href="http://www.layoutit.cn">网站地图</a>
                        | <a rel="nofollow" href="http://www.layoutit.cn">联系我们</a>
                    </div>
                    <div class="copyRight">
                        Copyright ?2017-2017layoutit.cn 版权所有
                    </div>
                </div>

            </div>
        </div>
    </div>

</div> <!-- /container -->

</body>
</html>
```





### 2.4 处理 `1. 项目及发起人信息` 的表单请求

#### 2.4.1 新建 `ProjectConsumerHandler` 类 【`project` 工程】

```java
package com.atguigu.crowd.handler;

import com.atguigu.crowd.config.OSSProperties;
import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.vo.ProjectVO;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈江林
 * @date 2022/8/31 16:25
 */
@Controller
public class ProjectConsumerHandler {

    @Autowired
    private OSSProperties ossProperties;

    /**
     * @param projectVO         接收除了上传图片之外的其他put普通数据
     * @param headerPicture     上传的头图
     * @param detailPictureList 上传的详情图片
     * @param session           用来将收集了一部分数据的 ProjectVO 对象存入 session 域
     * @param modelMap          用来在当前操作失败后返回上一个表单页面时携带提示消息
     * @return
     */
    @RequestMapping("/create/project/information")
    public String saveProjectBasicInfo(
            ProjectVO projectVO,
            MultipartFile headerPicture,
            List<MultipartFile> detailPictureList,
            HttpSession session,
            ModelMap modelMap) {
        try {
            // 1. 处理 projectVO 头图, 完成头图上传
            boolean headerPictureEmpty = headerPicture.isEmpty();

            // 1.1 如果没有头图
            if (headerPictureEmpty) {
                // 如果没有头图则返回到表单页面并显示提示消息
                modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_HEADER_PIC_EMPTY);
                return "project-launch";
            }

            // 1.2 如果有头图, 则执行上传
            if (!headerPictureEmpty) {
                ResultEntity<String> uploadHeaderPictureResultEntity = CrowdUtil.uploadFilterOss(ossProperties.getBucketName(),
                        ossProperties.getEndPoint(),
                        ossProperties.getBucketDomain(),
                        ossProperties.getAccessKeyId(),
                        ossProperties.getAccessKeySecret(),
                        headerPicture.getInputStream(),
                        headerPicture.getOriginalFilename());

                String result = uploadHeaderPictureResultEntity.getResult();

                // 1.2.1 判断头图是否上传成功
                if (ResultEntity.SUCCESS.equals(result)) {
                    // 1.2.2 从返回的数据中获取图片访问路径
                    String headerPicturePath = uploadHeaderPictureResultEntity.getData();

                    // 1.2.3 存入 ProjectVO 对象中
                    projectVO.setHeaderPicturePath(headerPicturePath);
                } else {
                    // 1.2.4 如果上传失败则返回到表单页面, 返回提示消息
                    modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_HEADER_PIC_UPLOAD_FAILED);
                    return "project-launch";
                }
            }

            // 2. 处理 projectVO 类中的 detailPicturePathList 详情图片的路径
            // 创建一个用来存放详情图片路径的集合
            List<String> detailPicturePathList = new ArrayList<>();

            // 2.1 如果集合为空
            if (!(detailPictureList != null && detailPictureList.size() > 0)) {
                modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_DETAIL_PIC_EMPTY);
                return "project-launch";
            }

            // 2.2 如果集合不为空则遍历集合
            for (MultipartFile detailPicture : detailPictureList) {
                // 2.2.1 如果为空
                if (detailPicture.isEmpty()) {
                    // 检测到详情图片中单个文件为空则返回错误信息
                    modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_DETAIL_PIC_EMPTY);
                    return "project-launch";
                }

                // 2.2.2 如果不为空
                if (!detailPicture.isEmpty()) {
                    // 2.2.3 执行上传
                    ResultEntity<String> detailUploadResultEntity = CrowdUtil.uploadFilterOss(ossProperties.getBucketName(),
                            ossProperties.getEndPoint(),
                            ossProperties.getBucketDomain(),
                            ossProperties.getAccessKeyId(),
                            ossProperties.getAccessKeySecret(),
                            detailPicture.getInputStream(),
                            detailPicture.getOriginalFilename());

                    // 2.2.4 检查上传结果
                    String detailUploadResult = detailUploadResultEntity.getResult();
                    if (ResultEntity.SUCCESS.equals(detailUploadResult)) {
                        String detailPicturePath = detailUploadResultEntity.getData();
                        // 2.2.5 将上传成功的图片的访问路径存入集合中
                        detailPicturePathList.add(detailPicturePath);
                    } else {
                        // 如果上传失败则返回到表单页面并显示提示消息
                        modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_DETAIL_PIC_UPLOAD_FAILED);
                        return "project-launch";
                    }
                }
            }

            // 2.3 将处理好的集合存入 projectVO 中
            projectVO.setDetailPicturePathList(detailPicturePathList);

            // 3. 将收集的部分数据存入 session 中
            session.setAttribute(CrowdConstant.ATTR_NAME_TEMPLE_PROJECT, projectVO);
        } catch (IOException e) {
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, e.getMessage());
            return "project-launch";
        }

        // 以完整的路径前往下一个 `2. 回报设置` 的页面
        return "redirect:" + CrowdConstant.ZUUL_PATH_VALUE + "/project/return/info/page";
    }

}
```



#### 2.4.2 追加跳转代码 `CrowdWebMvcConfig` 【`project` 工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661944068010-b0be7c3e-61a4-4e4e-bb7b-2bf948b01e5b.png)

```html
registry.addViewController("/return/info/page").setViewName("project-return");
    
```



#### 2.4.3 新建  `project-return.html`页面`2. 回报设置`【`project` 工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1661944165910-50f4e71a-21af-48b4-98c7-23994994e0c9.png)



```html
<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="https://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
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
    <script type="text/javascript" src="layer/layer.js"></script>
    <script>
        // 声明一个全局的 returnObj 对象用于存储整个表单的数据（包括上传到 OSS 的图片访问路径）
        var returnObj = {};

        $(function () {
            // 回报信息的表单部分隐藏
            $(".returnFormDiv").hide();

            $('#myTab a').click(function (e) {
                e.preventDefault()
                $(this).tab('show')
            })

            // 点击 添加回报按钮 切换表单部分的形式状态
            $("#addReturnBtn").click(function () {
                // toggle 把显示的元素隐藏, 把显示的元素显示
                $(".returnFormDiv").toggle();
            })

            // 点击上传图片按钮打开文件选择框
            $("#uploadBtn").click(function () {
                // toggle 把显示的元素隐藏, 把显示的元素显示
                // <input type="file" name="returnPicture" style="display: none;" />
                $("[name=returnPicture]").click();
            })

            // 在文件上传框的值改变事件响应函数中预览并上传图片
            $("[name=returnPicture]").change(function (event) {
                var file = event.target.files[0];

                var url = window.url || window.webkitURL;

                var path = url.createObjectURL(file);

                $(this).next().next().next().next().attr("src", path).show();;

                // 将上传的文件封装到 FormData 对象中
                var formData = new FormData();
                formData.append("returnPicture", file);

                // 发生 Ajax 请求上传文件
                $.ajax({
                    "url": "[[@{/project/create/upload/return/picture.json}]]",
                    "type": "post",
                    "data": formData,
                    "contentType": false,
                    "processData": false,
                    "dataType": "json",
                    "success": function (response) {
                        var result = response.result;
                        if (result === "SUCCESS") {
                            layer.msg("上传成功!");

                            // 如果上传成功, 则从响应体数据中获取
                            returnObj.describPicPath = response.data;
                        }

                        if (result === "FAILED") {
                            layer.msg(response.message);
                        }
                    },
                    "error": function (response) {
                        layer.msg(response.status + " " + response.statusText);
                    }
                })
            })

            // 说明序号保存表格中数据的序号
            var order = 0;

            // 点击确认按钮, 绑定绑定单击响应函数
            $("#okBtn").click(function () {
                // 1. 收集表单数据
                returnObj.type = $("[name=type]:checked").val();
                returnObj.supportmoney = $("[name=supportmoney]").val();
                returnObj.content = $("[name=content]").val();
                returnObj.count = $("[name=count]").val();
                returnObj.signalpurchase = $("[name=signalpurchase]:checked").val();
                returnObj.purchase = $("[name=purchase]").val();
                returnObj.freight = $("[name=freight]").val();
                returnObj.invoice = $("[name=invoice]:checked").val();
                returnObj.returndate = $("[name=returndate]").val();

                // 2. 发送 Ajax 请求
                $.ajax({
                    "url": "[[@{/project/create/save/return.json}]]",
                    "type": "post",
                    "data": returnObj,
                    "dataType": "json",
                    "success": function (response) {
                        var result = response.result;
                        if (result === "SUCCESS") {
                            layer.msg("这一条保存成功!!");

                            // 使用 returnObj 填充表格
                            var orderId = "<td>" + (++order) + "</td>";
                            var supportmoneyId = "<td>" + returnObj.supportmoney + "</td>";
                            var countId = "<td>" + returnObj.count + "</td>";
                            var signalpurchaseId = "<td>" + (returnObj.signalpurchase === 0 ? "不限购" : ("限购" + returnObj.purchase)) + "</td>";
                            var contentId = "<td>" + returnObj.content + "</td>";
                            var returndateId = "<td>" + returnObj.returndate + "天以后返还</td>";
                            var freightId = "<td>" + (returnObj.freight === 0 ? "包邮" : returnObj.freight) + "</td>";
                            var operationTd = "<td><button type='button' class='btn btn-primary btn-xs'><i class=' glyphicon glyphicon-pencil'></i></button>&nbsp;<button type='button' class='btn btn-danger btn-xs'><i class=' glyphicon glyphicon-remove'></i></button></td>";
                            var trHTML = "<tr>" + orderId + supportmoneyId + countId + signalpurchaseId + contentId + returndateId + freightId + operationTd + "</tr>";

                            $("#returnTableBody").append(trHTML);

                            $("#returnPictureImage").hide();
                        }

                        if (result === "FAILED") {
                            layer.msg("这一条保存失败!");
                        }

                        // 后续操作
                        // 仅仅调用 click() 函数而不传入回调函数表示点击一下这个按钮
                        $("#resetBtn").click();

                        // 将表单部分 div 隐藏
                        $(".returnFormDiv").hide();

                    },
                    "error": function () {
                        layer.msg(response.status + " " + response.statusText);
                    }
                })
            })
        })
    </script>
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

        .label-type, .label-status, .label-order {
            background-color: #fff;
            color: #f60;
            padding: 5px;
            border: 1px #f60 solid;
        }

        #typeList :not(:first-child) {
            margin-top: 20px;
        }

        .label-txt {
            margin: 10px 10px;
            border: 1px solid #ddd;
            padding: 4px;
            font-size: 14px;
        }

        .panel {
            border-radius: 0;
        }

        .progress-bar-default {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<div class="navbar-wrapper">
    <div class="container">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.html" style="font-size: 32px;">尚筹网-创意产品众筹平台</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse"
                     style="float: right;">
                    <ul class="nav navbar-nav">
                        <li class="dropdown"><a href="#" class="dropdown-toggle"
                                                data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i>
                            [[${session.loginMember.username}]]<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="member.html"><i
                                        class="glyphicon glyphicon-scale"></i> 会员中心</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-comment"></i>
                                    消息</a></li>
                                <li class="divider"></li>
                                <li><a th:href="@{/auth/member/logout}"><i
                                        class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>

<div class="container theme-showcase" role="main">

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="collapse navbar-collapse"
                         id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a rel="nofollow" href="index.html"><i
                                    class="glyphicon glyphicon-home"></i> 众筹首页</a></li>
                            <li><a rel="nofollow" href="projects.html"><i
                                    class="glyphicon glyphicon-th-large"></i> 项目总览</a></li>
                            <li class="active"><a rel="nofollow" href="javascript:;"><i
                                    class="glyphicon glyphicon-edit"></i> 发起项目</a></li>
                            <li><a rel="nofollow" href="minecrowdfunding.html"><i
                                    class="glyphicon glyphicon-user"></i> 我的众筹</a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>


    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="panel panel-default">
                    <div class="panel-heading" style="text-align: center;">
                        <div class="container-fluid">
                            <div class="row clearfix">
                                <div class="col-md-3 column">
                                    <div class="progress"
                                         style="height: 50px; border-radius: 0; position: absolute; width: 75%; right: 49px;">
                                        <div class="progress-bar progress-bar-default"
                                             role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                             aria-valuemax="100" style="width: 100%; height: 50px;">
                                            <div style="font-size: 16px; margin-top: 15px;">1.
                                                项目及发起人信息
                                            </div>
                                        </div>
                                    </div>
                                    <div
                                            style="right: 0; border: 10px solid #ddd; border-left-color: #88b7d5; border-width: 25px; position: absolute; border-left-color: rgba(221, 221, 221, 1); border-top-color: rgba(221, 221, 221, 0); border-bottom-color: rgba(221, 221, 221, 0); border-right-color: rgba(221, 221, 221, 0);">
                                    </div>
                                </div>
                                <div class="col-md-3 column">
                                    <div class="progress"
                                         style="height: 50px; border-radius: 0; position: absolute; width: 75%; right: 49px;">
                                        <div class="progress-bar progress-bar-success"
                                             role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                             aria-valuemax="100" style="width: 100%; height: 50px;">
                                            <div style="font-size: 16px; margin-top: 15px;">2.
                                                回报设置
                                            </div>
                                        </div>
                                    </div>
                                    <div
                                            style="right: 0; border: 10px solid #ddd; border-left-color: #88b7d5; border-width: 25px; position: absolute; border-left-color: rgba(92, 184, 92, 1); border-top-color: rgba(92, 184, 92, 0); border-bottom-color: rgba(92, 184, 92, 0); border-right-color: rgba(92, 184, 92, 0);">
                                    </div>
                                </div>
                                <div class="col-md-3 column">
                                    <div class="progress"
                                         style="height: 50px; border-radius: 0; position: absolute; width: 75%; right: 49px;">
                                        <div class="progress-bar progress-bar-default"
                                             role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                             aria-valuemax="100" style="width: 100%; height: 50px;">
                                            <div style="font-size: 16px; margin-top: 15px;">3.
                                                确认信息
                                            </div>
                                        </div>
                                    </div>
                                    <div
                                            style="right: 0; border: 10px solid #ddd; border-left-color: #88b7d5; border-width: 25px; position: absolute; border-left-color: rgba(221, 221, 221, 1); border-top-color: rgba(221, 221, 221, 0); border-bottom-color: rgba(221, 221, 221, 0); border-right-color: rgba(221, 221, 221, 0);">
                                    </div>
                                </div>
                                <div class="col-md-3 column">
                                    <div class="progress" style="height: 50px; border-radius: 0;">
                                        <div class="progress-bar progress-bar-default"
                                             role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                             aria-valuemax="100" style="width: 100%; height: 50px;">
                                            <div style="font-size: 16px; margin-top: 15px;">4. 完成</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">

                        <div class="container-fluid">
                            <div class="row clearfix">
                                <div class="col-md-12 column">
                                    <blockquote
                                            style="border-left: 5px solid #f60; color: #f60; padding: 0 0 0 20px;">
                                        <b> 回报设置 </b>
                                    </blockquote>
                                </div>
                                <div class="col-md-12 column">
                                    <table class="table table-bordered"
                                           style="text-align: center;">
                                        <thead>
                                        <tr style="background-color: #ddd;">
                                            <td>序号</td>
                                            <td>支付金额</td>
                                            <td>名额</td>
                                            <td>单笔限购</td>
                                            <td>回报内容</td>
                                            <td>回报时间</td>
                                            <td>运费</td>
                                            <td>操作</td>
                                        </tr>
                                        </thead>
                                        <tbody id="returnTableBody">
                                        <!-- <tr>
                                            <td scope="row">1</td>
                                            <td>￥1.00</td>
                                            <td>无限制</td>
                                            <td>1</td>
                                            <td>1</td>
                                            <td>项目结束后的30天</td>
                                            <td>包邮</td>
                                            <td>
                                                <button type="button" class="btn btn-primary btn-xs">
                                                    <i class=" glyphicon glyphicon-pencil"></i>
                                                </button>
                                                <button type="button" class="btn btn-danger btn-xs">
                                                    <i class=" glyphicon glyphicon-remove"></i>
                                                </button>
                                            </td>
                                        </tr> -->
                                        </tbody>
                                    </table>
                                    <button id="addReturnBtn" type="button" class="btn btn-primary btn-lg">
                                        <i class="glyphicon glyphicon-plus"></i> 添加回报
                                    </button>
                                    <div class="returnFormDiv"
                                         style="border: 10px solid #f60; border-bottom-color: #eceeef; border-width: 10px; width: 20px; margin-left: 20px; border-left-color: rgba(221, 221, 221, 0); border-top-color: rgba(221, 221, 221, 0); border-right-color: rgba(221, 221, 221, 0);"></div>
                                    <div class="panel panel-default returnFormDiv"
                                         style="border-style: dashed; background-color: #eceeef">
                                        <div class="panel-body">

                                            <div class="col-md-12 column">
                                                <form class="form-horizontal">
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">回报类型</label>
                                                        <div class="col-sm-10">
                                                            <label class="radio-inline"> <input type="radio"
                                                                                                name="type"
                                                                                                id="inlineRadio1"
                                                                                                value="0"> 实物回报
                                                            </label> <label class="radio-inline"> <input
                                                                type="radio" name="type"
                                                                id="inlineRadio2" value="1"> 虚拟物品回报
                                                        </label>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">支持金额（元）</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="supportmoney" value="10"
                                                                   class="form-control"
                                                                   style="width: 100px;">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">回报内容</label>
                                                        <div class="col-sm-10">
																<textarea class="form-control" name="content" rows="5"
                                                                          placeholder="简单描述回报内容，不超过200字">以身相许</textarea>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">说明图片</label>
                                                        <div class="col-sm-10">
                                                            <input type="file" name="returnPicture" style="display: none;"/>
                                                            <button type="button" id="uploadBtn" class="btn btn-primary btn-lg active">上传图片
                                                            </button>
                                                            <label class="control-label">支持jpg、jpeg、png、gif格式，大小不超过2M，建议尺寸：760*510px选择文件</label>
                                                            <br/>
                                                            <img style="display: none"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">回报数量（名）</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="count" value="5"
                                                                   class="form-control"
                                                                   style="width: 100px; display: inline"> <label
                                                                class="control-label">“0”为不限回报数量</label>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">单笔限购</label>
                                                        <div class="col-sm-10">
                                                            <label class="radio-inline"> <input type="radio"
                                                                                                name="signalpurchase"
                                                                                                id="inlineRadio3"
                                                                                                value="0"> 不限购
                                                            </label> <label class="radio-inline"> <input
                                                                type="radio" name="signalpurchase"
                                                                id="inlineRadio4" value="1"> 限购
                                                        </label> <input type="text" name="purchase" value="8"
                                                                        class="form-control"
                                                                        style="width: 100px; display: inline"> <label
                                                                class="radio-inline">默认数量为1，且不超过上方已设置的回报数量</label>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">运费(元)</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="freight" value="0"
                                                                   class="form-control"
                                                                   style="width: 100px; display: inline">
                                                            <label class="control-label">“0”为包邮</label>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">发票</label>
                                                        <div class="col-sm-10">
                                                            <label class="radio-inline"> <input type="radio"
                                                                                                name="invoice"
                                                                                                id="inlineRadio5"
                                                                                                value="0"> 不可开发票
                                                            </label> <label class="radio-inline"> <input
                                                                type="radio" name="invoice"
                                                                id="inlineRadio6" value="1">
                                                            可开发票（包括个人发票和自定义抬头发票）
                                                        </label>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">回报时间</label>
                                                        <div class="col-sm-10">
                                                            <label class="radio-inline"> 项目结束后 </label> <input
                                                                type="text" name="returndate" value="15"
                                                                class="form-control"
                                                                style="width: 100px; display: inline"> <label
                                                                class="radio-inline">天，向支持者发送回报</label>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label"></label>
                                                        <div class="col-sm-10">
                                                            <button type="button" class="btn btn-primary" id="okBtn">
                                                                确定
                                                            </button>
                                                            <button type="button" class="btn btn-default">取消</button>
                                                        </div>
                                                    </div>

                                                </form>
                                            </div>


                                        </div>
                                    </div>
                                </div>

                                <div class="container">
                                    <div class="row clearfix">
                                        <div class="col-md-12 column">
                                            <blockquote>
                                                <p>
                                                    <i class="glyphicon glyphicon-info-sign"
                                                       style="color: #2a6496;"></i> 提示
                                                </p>
                                                <small>
                                                    3个以上的回报：多些选择能提高项目的支持率。几十、几百、上千元的支持：3个不同档次的回报，能让你的项目更快成功。回报最好是项目的衍生品：<br>与项目内容有关的回报更能吸引到大家的支持。
                                                </small>
                                            </blockquote>
                                        </div>
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                    <div class="panel-footer" style="text-align: center;">
                        <button type="button" class="btn  btn-default btn-lg"
                                onclick="window.location.href='start-step-1.html'">上一步
                        </button>
                        <!-- <button type="button" class="btn  btn-warning btn-lg"
                            onclick="window.location.href='start-step-3.html'">下一步</button> -->
                        <a th:href="@{/project/create/confirm/page}" class="btn btn-warning btn-lg">下一步</a>
                        <a class="btn"> 预览 </a>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="container" style="margin-top: 20px;">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div id="footer">
                    <div class="footerNav">
                        <a rel="nofollow" href="http://www.layoutit.cn">关于我们</a> | <a
                            rel="nofollow" href="http://www.layoutit.cn">服务条款</a> | <a
                            rel="nofollow" href="http://www.layoutit.cn">免责声明</a> | <a
                            rel="nofollow" href="http://www.layoutit.cn">网站地图</a> | <a
                            rel="nofollow" href="http://www.layoutit.cn">联系我们</a>
                    </div>
                    <div class="copyRight">Copyright ?2017-2017layoutit.cn 版权所有
                    </div>
                </div>

            </div>
        </div>
    </div>

</div>

</body>
</html>
```



### 2.5 处理  `2. 回报设置` 页面的表单请求

#### 2.5.1 追加图片上传代码 `ProjectConsumerHandler 类` 【`project` 工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662012728299-55bb2f49-f2c8-4302-88da-9fcdc9794bc1.png)

```java
    /**
     * JavaScript 代码: formData.append("returnPicture", file);
     * - returnPicture: 是请求参数的名字
     * - file 是请求参数的值, 也就是要上传的文件
     *
     * @param returnPicture 接收用户上传的文件
     * @return
     */
    @ResponseBody
    @RequestMapping("/create/upload/return/picture.json")
    public ResultEntity<String> uploadReturnPicture(
            @RequestParam("returnPicture") MultipartFile returnPicture
    ) {
        try {
            // 1. 执行文件上传
            ResultEntity<String> returnPictureResultEntity = CrowdUtil.uploadFilterOss(ossProperties.getBucketName(),
                    ossProperties.getEndPoint(),
                    ossProperties.getBucketDomain(),
                    ossProperties.getAccessKeyId(),
                    ossProperties.getAccessKeySecret(),
                    returnPicture.getInputStream(),
                    returnPicture.getOriginalFilename());

            // 2. 返回上传的结果
            return returnPictureResultEntity;
        } catch (IOException e) {
            return ResultEntity.failed(e.getMessage());
        }
    }
```



#### 2.5.2 追加 `添加回报信息` 代码 `ProjectConsumerHandler 类` 【`project` 工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662012733051-00581c66-6175-4581-85b0-572b3c634749.png)

```java
    /**
     * 向 ProjectVO 对象存入回报信息
     *
     * @param returnVO
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/create/save/return.json")
    public ResultEntity<String> returnPicture(
            ReturnVO returnVO,
            HttpSession session
    ) {
        try {
            // 从 session 域中获取之前缓存的 ProjectVO 对象
            ProjectVO projectVO = (ProjectVO) session.getAttribute(CrowdConstant.ATTR_NAME_TEMPLE_PROJECT);
            if (null == projectVO) {
                // MESSAGE_TEMPLE_PROJECT_MISSING = 临时存储的 projectVO 对象丢失
                return ResultEntity.failed(CrowdConstant.MESSAGE_TEMPLE_PROJECT_MISSING);
            }

            // 从 projectVO 对象中存储回报信息的集合
            List<ReturnVO> returnVOList = projectVO.getReturnVOList();

            // 判断 returnVOList 集合是否有效
            if (returnVOList == null) {
                returnVOList = new ArrayList<>();
            }

            returnVOList.add(returnVO);

            projectVO.setReturnVOList(returnVOList);
            // 将数据有变化的 ProjectVO 对象重新存入 session 域, 以确保新的数据最终能够存入 Redis
            session.setAttribute(CrowdConstant.ATTR_NAME_TEMPLE_PROJECT, projectVO);
            return ResultEntity.successWithoutData();
        } catch (Exception e) {
            return ResultEntity.failed(e.getMessage());
        }
    }
```



### 2.6 处理3: 第三步 `确认信息` 页面 【`project` 工程】

#### 2.6.1 添加 `view-comtorller` 代码

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662026729062-60115985-3b91-4399-92f0-4ee846aa8f58.png)

```java
registry.addViewController("/create/confirm/page").setViewName("project-confirm");
```

#### 

#### 2.6.2 新建 `project-confirm.html` 第三步: 确认信息页面

```html
<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="https://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <base th:href="@{/}"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/theme.css">
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

        .label-type, .label-status, .label-order {
            background-color: #fff;
            color: #f60;
            padding : 5px;
            border: 1px #f60 solid;
        }
        #typeList  :not(:first-child) {
            margin-top:20px;
        }
        .label-txt {
            margin:10px 10px;
            border:1px solid #ddd;
            padding : 4px;
            font-size:14px;
        }
        .panel {
            border-radius:0;
        }

        .progress-bar-default {
            background-color: #ddd;
        }
    </style>
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="script/docs.min.js"></script>
    <script src="script/back-to-top.js"></script>
    <script>
        $(function() {
            var message = "[[${message}]]";
            if (message !== "") {
                layer.msg(message);
            }

            $('#myTab a').click(function (e) {
                e.preventDefault()
                $(this).tab('show')
            })
        })
    </script>
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
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i> [[${session.loginMember.username}]]<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="member.html"><i class="glyphicon glyphicon-scale"></i> 会员中心</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
                                <li class="divider"></li>
                                <li><a th:href="@{/auth/member/logout}"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>

<div class="container theme-showcase" role="main">

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li>
                                <a rel="nofollow" href="index.html"><i class="glyphicon glyphicon-home"></i> 众筹首页</a>
                            </li>
                            <li >
                                <a rel="nofollow" href="projects.html"><i class="glyphicon glyphicon-th-large"></i> 项目总览</a>
                            </li>
                            <li class="active">
                                <a rel="nofollow" href="javascript:;"><i class="glyphicon glyphicon-edit"></i> 发起项目</a>
                            </li>
                            <li>
                                <a rel="nofollow" href="minecrowdfunding.html"><i class="glyphicon glyphicon-user"></i> 我的众筹</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>


    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="panel panel-default" >
                    <div class="panel-heading" style="text-align:center;">
                        <div class="container-fluid">
                            <div class="row clearfix">
                                <div class="col-md-3 column">
                                    <div class="progress" style="height:50px;border-radius:0;    position: absolute;width: 75%;right:49px;">
                                        <div class="progress-bar progress-bar-default" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 100%;height:50px;">
                                            <div style="font-size:16px;margin-top:15px;">1. 项目及发起人信息</div>
                                        </div>
                                    </div>
                                    <div style="right: 0;border:10px solid #ddd;border-left-color: #88b7d5;border-width: 25px;position: absolute;
                                             border-left-color: rgba(221, 221, 221, 1);
                                             border-top-color: rgba(221, 221, 221, 0);
                                             border-bottom-color: rgba(221, 221, 221, 0);
                                             border-right-color: rgba(221, 221, 221, 0);
                                        ">
                                    </div>
                                </div>
                                <div class="col-md-3 column">
                                    <div class="progress" style="height:50px;border-radius:0;position: absolute;width: 75%;right:49px;">
                                        <div class="progress-bar progress-bar-default" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 100%;height:50px;">
                                            <div style="font-size:16px;margin-top:15px;">2. 回报设置</div>
                                        </div>
                                    </div>
                                    <div style="right: 0;border:10px solid #ddd;border-left-color: #88b7d5;border-width: 25px;position: absolute;
                                             border-left-color: rgba(221, 221, 221, 1);
                                             border-top-color: rgba(221, 221, 221, 0);
                                             border-bottom-color: rgba(221, 221, 221, 0);
                                             border-right-color: rgba(221, 221, 221, 0);
                                        ">
                                    </div>
                                </div>
                                <div class="col-md-3 column">
                                    <div class="progress" style="height:50px;border-radius:0;position: absolute;width: 75%;right:49px;">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 100%;height:50px;">
                                            <div style="font-size:16px;margin-top:15px;">3. 确认信息</div>
                                        </div>
                                    </div>
                                    <div style="right: 0;border:10px solid #ddd;border-left-color: #88b7d5;border-width: 25px;position: absolute;
                                             border-left-color: rgba(92, 184, 92, 1);
                                             border-top-color: rgba(92, 184, 92, 0);
                                             border-bottom-color: rgba(92, 184, 92, 0);
                                             border-right-color: rgba(92, 184, 92, 0);
                                        ">
                                    </div>
                                </div>
                                <div class="col-md-3 column">
                                    <div class="progress" style="height:50px;border-radius:0;">
                                        <div class="progress-bar progress-bar-default" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 100%;height:50px;">
                                            <div style="font-size:16px;margin-top:15px;">4. 完成</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">

                        <div class="container-fluid">
                            <div class="row clearfix">
                                <div class="col-md-12 column">
                                    <blockquote style="border-left: 5px solid #f60;color:#f60;padding: 0 0 0 20px;">
                                        <b>
                                            确认信息（请填写易付宝企业账号用于收款及身份核实）
                                        </b>
                                    </blockquote>
                                </div>
                                <div class="col-md-12 column">


                                    <div class="row clearfix">
                                        <div class="col-md-6 column">
                                            <form id="confirmFomr" th:action="@{/project/create/confirm}" method="post" role="form">
                                                <div class="form-group">
                                                    <label for="exampleInputEmail1">易付宝企业账号：</label><input type="email" name="paynum" class="form-control" id="exampleInputEmail1" />
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleInputPassword1">法人身份证号：</label><input type="password" name="cardnum" class="form-control" id="exampleInputPassword1" />
                                                </div>
                                            </form>
                                        </div>
                                        <div class="col-md-6 column">
                                            <div class="panel panel-default">
                                                <div class="panel-body" style="padding:40px;">
                                                    <i class="glyphicon glyphicon-user"></i> 易购账户名：18801282948<br><br><span style="margin-left:60px;">您正在使用该账号发起众筹项目</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer" style="text-align:center;">
                        <button type="button" class="btn  btn-default btn-lg">上一步</button>

                        <script type="text/javascript">
                            $(function(){
                                $("#submitBtn").click(function(){
                                    $("#confirmFomr").submit();
                                });
                            });
                        </script>
                        <button type="button" id="submitBtn" class="btn  btn-warning btn-lg">提交</button>
                        <a class="btn" > 保存草稿 </a>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="container" style="margin-top:20px;">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div id="footer">
                    <div class="footerNav">
                        <a rel="nofollow" href="http://www.layoutit.cn">关于我们</a> | <a rel="nofollow" href="http://www.layoutit.cn">服务条款</a> | <a rel="nofollow" href="http://www.layoutit.cn">免责声明</a> | <a rel="nofollow" href="http://www.layoutit.cn">网站地图</a> | <a rel="nofollow" href="http://www.layoutit.cn">联系我们</a>
                    </div>
                    <div class="copyRight">
                        Copyright ?2017-2017layoutit.cn 版权所有
                    </div>
                </div>

            </div>
        </div>
    </div>

</div> <!-- /container -->
</body>
</html>
```



#### 2.6.3 追加处理 `确认信息表单提交` 的代码

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662029120299-9e8f1a6e-5d34-4dfe-9706-bc13c3d58b59.png)

```java
    /**
     * 保存会员发起的众筹信息
     *
     * @param memberConfirmInfoVO
     * @param session
     * @param modelMap
     * @return
     */
    @RequestMapping("/create/confirm")
    public String saveConfirm(
            MemberConfirmInfoVO memberConfirmInfoVO,
            HttpSession session,
            ModelMap modelMap
    ) {
        // 从 Session 域读取之前临时存储的 ProjectVO 对象
        ProjectVO projectVO = (ProjectVO) session.getAttribute(CrowdConstant.ATTR_NAME_TEMPLE_PROJECT);

        // 判断 projectVO
        if (projectVO == null) {
            // 如果为空跳转到第一步
            // MESSAGE_DETAIL_CONFIRM = "确认信息失败! 请先填写项目及发起人信息"
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_DETAIL_CONFIRM);
            return "project-launch";
        }

        // 将确认信息数据存储到 ProjectVO 对象中
        projectVO.setMemberConfirmInfoVO(memberConfirmInfoVO);

        // 从 session 中读取当前登录的用户
        MemberLoginVO memberLoginVO = (MemberLoginVO) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER);
        Integer memberId = memberLoginVO.getId();

        // 调用远程方法保存数据
        ResultEntity<String> saveResultEntity = mySQLRemoteService.saveProjectVORemote(projectVO, memberId);
        // 判断远程的保存操作是否成功
        if (ResultEntity.FAILED.equals(saveResultEntity.getResult())) {
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, saveResultEntity.getMessage());
            return "project-confirm";
        }

        // 将临时的 ProjectVO 对象从 session 中移除
        session.removeAttribute(CrowdConstant.ATTR_NAME_TEMPLE_PROJECT);

        // 跳转到完成页面
        return "redirect:" + CrowdConstant.ZUUL_PATH_VALUE + "/project/create/success";
    }
```



#### 2.6.4 追加跳转完成页面的代码

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662029242099-4cdfa5cb-74ec-4681-bd02-063c18d3affb.png)

```java
registry.addViewController("/create/success").setViewName("project-success");
```



#### 2.6.5 新建完成页面 `project-success.html`

```html
<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <base th:href="@{/}"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/theme.css">
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="script/docs.min.js"></script>
    <script src="script/back-to-top.js"></script>
    <script>
        $(function () {
            $('#myTab a').click(function (e) {
                e.preventDefault()
                $(this).tab('show')
            })
        })
    </script>
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

        .label-type, .label-status, .label-order {
            background-color: #fff;
            color: #f60;
            padding: 5px;
            border: 1px #f60 solid;
        }

        #typeList :not(:first-child) {
            margin-top: 20px;
        }

        .label-txt {
            margin: 10px 10px;
            border: 1px solid #ddd;
            padding: 4px;
            font-size: 14px;
        }

        .panel {
            border-radius: 0;
        }

        .progress-bar-default {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<div class="navbar-wrapper">
    <div class="container">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.html" style="font-size: 32px;">尚筹网-创意产品众筹平台</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse"
                     style="float: right;">
                    <ul class="nav navbar-nav">
                        <li class="dropdown"><a href="#" class="dropdown-toggle"
                                                data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i>
                            [[${session.loginMember.username}]]<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="member.html"><i
                                        class="glyphicon glyphicon-scale"></i> 会员中心</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-comment"></i>
                                    消息</a></li>
                                <li class="divider"></li>
                                <li><a th:href="@{/auth/member/logout}"><i
                                        class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>

<div class="container theme-showcase" role="main">

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li>
                                <a rel="nofollow" href="index.html"><i class="glyphicon glyphicon-home"></i> 众筹首页</a>
                            </li>
                            <li>
                                <a rel="nofollow" href="projects.html"><i class="glyphicon glyphicon-th-large"></i> 项目总览</a>
                            </li>
                            <li class="active">
                                <a rel="nofollow" href="javascript:;"><i class="glyphicon glyphicon-edit"></i> 发起项目</a>
                            </li>
                            <li>
                                <a rel="nofollow" href="minecrowdfunding.html"><i class="glyphicon glyphicon-user"></i>
                                    我的众筹</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>


    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="panel panel-default">
                    <div class="panel-heading" style="text-align:center;">
                        <div class="container-fluid">
                            <div class="row clearfix">
                                <div class="col-md-3 column">
                                    <div class="progress"
                                         style="height:50px;border-radius:0;    position: absolute;width: 75%;right:49px;">
                                        <div class="progress-bar progress-bar-default" role="progressbar"
                                             aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
                                             style="width: 100%;height:50px;">
                                            <div style="font-size:16px;margin-top:15px;">1. 项目及发起人信息</div>
                                        </div>
                                    </div>
                                    <div style="right: 0;border:10px solid #ddd;border-left-color: #88b7d5;border-width: 25px;position: absolute;
                                             border-left-color: rgba(221, 221, 221, 1);
                                             border-top-color: rgba(221, 221, 221, 0);
                                             border-bottom-color: rgba(221, 221, 221, 0);
                                             border-right-color: rgba(221, 221, 221, 0);
                                        ">
                                    </div>
                                </div>
                                <div class="col-md-3 column">
                                    <div class="progress"
                                         style="height:50px;border-radius:0;position: absolute;width: 75%;right:49px;">
                                        <div class="progress-bar progress-bar-default" role="progressbar"
                                             aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
                                             style="width: 100%;height:50px;">
                                            <div style="font-size:16px;margin-top:15px;">2. 回报设置</div>
                                        </div>
                                    </div>
                                    <div style="right: 0;border:10px solid #ddd;border-left-color: #88b7d5;border-width: 25px;position: absolute;
                                             border-left-color: rgba(221, 221, 221, 1);
                                             border-top-color: rgba(221, 221, 221, 0);
                                             border-bottom-color: rgba(221, 221, 221, 0);
                                             border-right-color: rgba(221, 221, 221, 0);
                                        ">
                                    </div>
                                </div>
                                <div class="col-md-3 column">
                                    <div class="progress"
                                         style="height:50px;border-radius:0;position: absolute;width: 75%;right:49px;">
                                        <div class="progress-bar progress-bar-default" role="progressbar"
                                             aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
                                             style="width: 100%;height:50px;">
                                            <div style="font-size:16px;margin-top:15px;">3. 确认信息</div>
                                        </div>
                                    </div>
                                    <div style="right: 0;border:10px solid #ddd;border-left-color: #88b7d5;border-width: 25px;position: absolute;
                                              border-left-color: rgba(221, 221, 221, 1);
                                             border-top-color: rgba(221, 221, 221, 0);
                                             border-bottom-color: rgba(221, 221, 221, 0);
                                             border-right-color: rgba(221, 221, 221, 0);
                                        ">
                                    </div>
                                </div>
                                <div class="col-md-3 column">
                                    <div class="progress" style="height:50px;border-radius:0;">
                                        <div class="progress-bar progress-bar-success" role="progressbar"
                                             aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
                                             style="width: 100%;height:50px;">
                                            <div style="font-size:16px;margin-top:15px;">4. 完成</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">

                        <div class="container-fluid">
                            <div class="row clearfix">
                                <div class="col-md-12 column">
                                    <blockquote style="border-left: 5px solid #f60;color:#f60;padding: 0 0 0 20px;">
                                        <b>
                                            完成
                                        </b>
                                    </blockquote>
                                </div>
                                <div class="col-md-12 column">


                                    <div class="row clearfix">
                                        <div class="col-md-12 column">
                                            <div class="panel panel-default">
                                                <div class="panel-body" style="padding:60px;">
                                                    <i class="glyphicon glyphicon-ok"
                                                       style="color:green;font-size:40px;"></i> <span
                                                        style="margin-left:20px;">你发起的众筹项目信息已经提交完毕，我们会在5~7个工作日内对项目进行审核，请耐心等候</span>
                                                    <p style="margin-left:60px;">你能在会员中心-我的众筹- 发起的项目中查看</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer" style="text-align:center;">
                        <script type="text/javascript">
                            $(function () {
                                $("#toMyCrowd").click(function () {
                                    window.location.href = '[[${session.zuulPath}]]/member/my/crowd';
                                })
                            })
                        </script>
                        <button type="button" class="btn  btn-warning btn-lg"
                                id="toMyCrowd">我的众筹
                        </button>
                    </div>
                </div>
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

</div> <!-- /container -->

</body>
</html>
```



### 2.7 保存会员发起的众筹信息

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662029874401-11a46787-659f-494d-b5b8-1d6c4b8cf463.png)



#### 2.7.1 追加 `mysql 的 Feign 接口` 代码【`api` 工程】

- 实体类一定要加 `@RequestBody`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662029387821-25c5b3cc-5a52-487c-8289-7fa6a88b1f0b.png)

```java
    /**
     * 保存会员发起的众筹信息
     *
     * @param projectVO 众筹信息
     * @param memberId  会员 id
     * @return
     */
    @RequestMapping("/save/project/vo/remote")
    ResultEntity<String> saveProjectVORemote(@RequestBody ProjectVO projectVO, @RequestParam("memberId") Integer memberId);
```



#### 2.7.2 保存会员发起的众筹信息 【`mysql` 工程】

- `handler`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662032361779-d274a66b-ad86-4895-a3c7-8cdba8435b5d.png)

```java
package com.atguigu.crowd.handler;

import com.atguigu.crowd.entity.vo.ProjectVO;
import com.atguigu.crowd.service.api.ProjectService;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈江林
 * @date 2022/8/31 11:49
 */
@RestController
public class ProjectProviderHandler {

    @Autowired
    private ProjectService projectService;

    /**
     * 保存会员发起的众筹信息
     *
     * @param projectVO 众筹信息
     * @param memberId 会员 id
     * @return
     */
    @RequestMapping("/save/project/vo/remote")
    public ResultEntity<String> saveProjectVORemote(@RequestBody ProjectVO projectVO, @RequestParam("memberId") Integer memberId) {
        try {
            projectService.saveProject(projectVO, memberId);
            return ResultEntity.successWithoutData();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

}
```



- `service`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662032390044-ccafda11-9428-413c-8576-42ca993fd02c.png)

```java
package com.atguigu.crowd.service.api;

import com.atguigu.crowd.entity.vo.ProjectVO;

/**
 * @author 陈江林
 * @date 2022/8/31 11:49
 */
public interface ProjectService {

    /**
     * 保存会员发起的众筹信息
     *
     * @param projectVO 众筹信息
     * @param memberId 会员 id
     * @return
     */
    void saveProject(ProjectVO projectVO, Integer memberId);

}
```



- `serviceimpl`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662032404320-3323940e-dd39-4e4e-ac53-8fc4e84f729e.png)

```java
package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.entity.po.MemberConfirmInfoPO;
import com.atguigu.crowd.entity.po.MemberLaunchInfoPO;
import com.atguigu.crowd.entity.po.ProjectPO;
import com.atguigu.crowd.entity.po.ReturnPO;
import com.atguigu.crowd.entity.vo.MemberConfirmInfoVO;
import com.atguigu.crowd.entity.vo.MemberLauchInfoVO;
import com.atguigu.crowd.entity.vo.ProjectVO;
import com.atguigu.crowd.entity.vo.ReturnVO;
import com.atguigu.crowd.mapper.*;
import com.atguigu.crowd.service.api.ProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 陈江林
 * @date 2022/8/31 11:49
 */
@Transactional(readOnly = true)
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectPOMapper projectPOMapper;

    @Autowired
    private ProjectItemPicPOMapper projectItemPicPOMapper;

    @Autowired
    private MemberLaunchInfoPOMapper memberLaunchInfoPOMapper;

    @Autowired
    private MemberConfirmInfoPOMapper memberConfirmInfoPOMapper;

    @Autowired
    private ReturnPOMapper returnPOMapper;

    @Transactional(
            propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class
    )
    @Override
    public void saveProject(ProjectVO projectVO, Integer memberId) {
        // 一、保存 ProjectPO 对象
        // 1. 创建 ProjectPO 对象
        ProjectPO projectPO = new ProjectPO();

        // 2. 把 projectVO 中的属性复制到 ProjectPO 中
        BeanUtils.copyProperties(projectVO, projectPO);

        // 把 memberId 存储到 projectPO 中
        projectPO.setMemberid(memberId);
        // 存储创建时间
        String createdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        projectPO.setCreatedate(createdate);
        // status=0 即将开始
        projectPO.setStatus(0);

        // 3. 保存 projectPO
        // 3.1 为了能够获取到 projectPO 保存后的主键, 需要到 ProjectPOMapper.xml 文件中进行相关的设置
        // 3.1.1 追加 useGeneratedKeys="true" keyProperty="id"
        // - <insert id="insertSelective" useGeneratedKeys="true" keyProperty="id"
        projectPOMapper.insertSelective(projectPO);

        // 4. 获取 projectPO 的 id
        Integer projectId = projectPO.getId();

        // 二、保存项目分类的关联关系信息
        // 1. 从 ProjectVO 对象获取 typeIdList
        List<Integer> typeIdList = projectVO.getTypeIdList();
        projectPOMapper.insertTypeRelationship(typeIdList, projectId);

        // 三、保存项目标签关联关系信息
        List<Integer> tagIdList = projectVO.getTagIdList();
        projectPOMapper.insertTagRelationship(tagIdList, projectId);

        // 四、保存项目中详情图片路径信息
        List<String> detailPicturePathList = projectVO.getDetailPicturePathList();
        projectItemPicPOMapper.insertPathList(detailPicturePathList, projectId);

        // 五、项目发起人信息
        MemberLauchInfoVO memberLauchInfoVO = projectVO.getMemberLauchInfoVO();
        MemberLaunchInfoPO memberLaunchInfoPO = new MemberLaunchInfoPO();
        BeanUtils.copyProperties(memberLauchInfoVO, memberLaunchInfoPO);
        memberLaunchInfoPO.setMemberid(memberId);
        memberLaunchInfoPOMapper.insertSelective(memberLaunchInfoPO);

        // 六、保存项目回报信息
        List<ReturnVO> returnVOList = projectVO.getReturnVOList();
        List<ReturnPO> returnPOList = new ArrayList<>();
        for (ReturnVO returnVO : returnVOList) {
            ReturnPO returnPO = new ReturnPO();
            BeanUtils.copyProperties(returnVO, returnPO);
            returnPOList.add(returnPO);
        }

        returnPOMapper.insertReturnPOBatch(returnPOList, projectId);

        // 七、保存项目确认信息
        MemberConfirmInfoVO memberConfirmInfoVO = projectVO.getMemberConfirmInfoVO();
        MemberConfirmInfoPO memberConfirmInfoPO = new MemberConfirmInfoPO();
        BeanUtils.copyProperties(memberConfirmInfoVO, memberConfirmInfoPO);
        memberConfirmInfoPO.setMemberid(memberId);
        memberConfirmInfoPOMapper.insert(memberConfirmInfoPO);
    }

}
```



- 追加代码 `ProjectPOMapper`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662032418420-db72a50b-121b-4ff6-bf90-d1bddc09ee8e.png)

```java
    /**
     * 保存 项目分类中间表 数据
     *
     * @param typeIdList
     * @param projectId
     */
    void insertTypeRelationship(
            @Param("typeIdList") List<Integer> typeIdList,
            @Param("projectId") Integer projectId
    );

    /**
     * 保存 项目标签中间表 数据
     *
     * @param tagIdList
     * @param projectId
     */
    void insertTagRelationship(
            @Param("tagIdList") List<Integer> tagIdList,
            @Param("projectId") Integer projectId
    );
```



- 追加代码 `ProjectPOMapper.xml`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662032454179-38c0a261-b9d3-47ac-b975-1c594978ea84.png)

```xml
  <!--
    void insertTypeRelationship(
         @Param("typeIdList") List<Integer> typeIdList,
         @Param("projectId") Integer projectId
    );
  -->
  <insert id="insertTypeRelationship">
    insert into t_project_type (projectid, typeid) values
    <foreach collection="typeIdList" item="typeId" separator=",">
       (#{projectId}, #{typeId})
    </foreach>
  </insert>

  <!--
    void insertTagRelationship(
         @Param("tagIdList") List<Integer> tagIdList,
         @Param("projectId") Integer projectId
    );
  -->
  <insert id="insertTagRelationship">
    insert into t_project_tag (projectid, tagid) values
    <foreach collection="tagIdList" item="tagId" separator=",">
      (#{projectId}, #{tagId})
    </foreach>
  </insert>
```



- 追加代码 `ProjectItemPicPOMapper`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662035245026-b8176d55-87dc-484e-9d35-04212d992942.png)

```java
    /**
     * 保存 项目表项目详情图片表 数据
     *
     * @param detailPicturePathList
     * @param projectId
     */
    void insertPathList(
            @Param("detailPicturePathList") List<String> detailPicturePathList,
            @Param("projectId") Integer projectId
    );
```



- 追加代码 `ProjectItemPicPOMapper.xml`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662035288065-1097a76f-66d9-47cd-bfe3-12879519a427.png)

```xml
    <!--
        void insertPathList(
              @Param("detailPicturePathList") List<String> detailPicturePathList,
              @Param("projectId") Integer projectId
      );
    -->
    <insert id="insertPathList">
        insert into t_project_item_pic (item_pic_path ,projectid) values
        <foreach collection="detailPicturePathList" item="detailPicturePath" separator=",">
            (#{detailPicturePath}, #{projectId})
        </foreach>
    </insert>
```



- 追加代码 `ReturnPOMapper`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662035594047-979b8a5b-af05-429c-93f7-050f8f5307b2.png)

```java
    /**
     * 保存 回报信息表 数据
     *
     * @param returnPOList
     * @param projectId
     */
    void insertReturnPOBatch(
            @Param("returnPOList") List<ReturnPO> returnPOList,
            @Param("projectId") Integer projectId
    );
```



- 追加代码 `ReturnPOMapper.xml`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662035517426-a583b1de-af9b-49f8-9c2a-bbce193a55b0.png)

```xml
    <!--
        void insertReturnPOBatch(
              @Param("returnPOList") List<ReturnPO> returnPOList,
              @Param("projectId") Integer projectId
      );
    -->
    <insert id="insertReturnPOBatch">
        insert into t_return (
        projectid,
        type,
        supportmoney,
        content,
        count,
        signalpurchase,
        purchase,
        freight,
        invoice,
        returndate,
        describ_pic_path) values
        <foreach collection="returnPOList" item="returnPO" separator=",">
            (
            #{projectId},
            #{returnPO.type},
            #{returnPO.supportmoney},
            #{returnPO.content},
            #{returnPO.count},
            #{returnPO.signalpurchase},
            #{returnPO.purchase},
            #{returnPO.freight},
            #{returnPO.invoice},
            #{returnPO.returndate},
            #{returnPO.describPicPath}
            )
        </foreach>
    </insert>
```

# 二十一 前台-首页显示项目

```
git checkout -b 21.0.0_show_project
```

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1662398142885-802924ba-8cb7-4a81-943e-8864a80d408f.jpeg)



## 1. 首页显示项目

### 1.1 目标

- 在首页上加载真实保存到数据库的项目数据, 按分类显示

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662126573723-a2bef104-c20d-4ab7-b42f-305e54ed86a7.png)



### 1.2 思路

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1662127706792-3bce335e-7868-4c90-a9a1-e71f5f34d4fa.jpeg)



### 1.3 数据库

#### 1.3.1 分类表数据

```plsql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '分类说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='分类表';

-- ----------------------------
-- Records of t_type
-- ----------------------------
BEGIN;
INSERT INTO `t_type` (`id`, `name`, `remark`) VALUES (1, '科技', '开启科技未来');
INSERT INTO `t_type` (`id`, `name`, `remark`) VALUES (2, '设计', '创建改变未来');
INSERT INTO `t_type` (`id`, `name`, `remark`) VALUES (3, '公益', '汇集点点爱心');
INSERT INTO `t_type` (`id`, `name`, `remark`) VALUES (4, '农业', '网络天下肥美');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
```



#### 1.3.2 标签表数据

```plsql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '标签名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='标签表';

-- ----------------------------
-- Records of t_tag
-- ----------------------------
BEGIN;
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (1, NULL, '手机');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (2, NULL, '数码');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (3, NULL, '电脑');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (4, 1, '大屏');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (5, 1, '美颜');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (6, 1, '续航');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (7, 2, '高解析度');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (8, 2, '高清');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (9, 3, '大内存');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (10, 3, '固态');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
```



#### 1.3.3 数据库备份

```plsql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for inner_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `inner_admin_role`;
CREATE TABLE `inner_admin_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户和权限中间表';

-- ----------------------------
-- Records of inner_admin_role
-- ----------------------------
BEGIN;
INSERT INTO `inner_admin_role` (`id`, `admin_id`, `role_id`) VALUES (1, 2, 2);
INSERT INTO `inner_admin_role` (`id`, `admin_id`, `role_id`) VALUES (2, 2, 4);
INSERT INTO `inner_admin_role` (`id`, `admin_id`, `role_id`) VALUES (3, 1, 1);
INSERT INTO `inner_admin_role` (`id`, `admin_id`, `role_id`) VALUES (4, 1, 3);
INSERT INTO `inner_admin_role` (`id`, `admin_id`, `role_id`) VALUES (5, 7, 5);
COMMIT;

-- ----------------------------
-- Table structure for inner_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `inner_role_auth`;
CREATE TABLE `inner_role_auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `auth_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色和权限中间表';

-- ----------------------------
-- Records of inner_role_auth
-- ----------------------------
BEGIN;
INSERT INTO `inner_role_auth` (`id`, `role_id`, `auth_id`) VALUES (1, 3, 4);
INSERT INTO `inner_role_auth` (`id`, `role_id`, `auth_id`) VALUES (2, 4, 6);
INSERT INTO `inner_role_auth` (`id`, `role_id`, `auth_id`) VALUES (3, 4, 3);
COMMIT;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_acct` varchar(255) NOT NULL,
  `user_pswd` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
BEGIN;
INSERT INTO `t_admin` (`id`, `login_acct`, `user_pswd`, `user_name`, `email`, `create_time`) VALUES (1, 'adminOperator', '$2a$10$YlFApwsuOTRxvVlzIKJ1IO20wPftE57QovWuBsKoh2NEYZWKLT6jK', '经理', '1@qq.com', '2022-08-06 15:50:25');
INSERT INTO `t_admin` (`id`, `login_acct`, `user_pswd`, `user_name`, `email`, `create_time`) VALUES (2, 'roleOperator', '$2a$10$YlFApwsuOTRxvVlzIKJ1IO20wPftE57QovWuBsKoh2NEYZWKLT6jK', '部长', '2@qq.com', '2022-08-06 15:50:25');
INSERT INTO `t_admin` (`id`, `login_acct`, `user_pswd`, `user_name`, `email`, `create_time`) VALUES (3, 'admin01', '$2a$10$YlFApwsuOTRxvVlzIKJ1IO20wPftE57QovWuBsKoh2NEYZWKLT6jK', '路人甲', '3@qq.com', '2022-08-06 15:50:25');
INSERT INTO `t_admin` (`id`, `login_acct`, `user_pswd`, `user_name`, `email`, `create_time`) VALUES (4, 'admin02', '2a$10$YlFApwsuOTRxvVlzIKJ1IO20wPftE57QovWuBsKoh2NEYZWKLT6jK', '路人甲', '3@qq.com', '2022-08-06 15:50:25');
INSERT INTO `t_admin` (`id`, `login_acct`, `user_pswd`, `user_name`, `email`, `create_time`) VALUES (5, 'admin03', '$2a$10$YlFApwsuOTRxvVlzIKJ1IO20wPftE57QovWuBsKoh2NEYZWKLT6jK', '路人甲', '3@qq.com', '2022-08-06 15:50:25');
INSERT INTO `t_admin` (`id`, `login_acct`, `user_pswd`, `user_name`, `email`, `create_time`) VALUES (6, 'CS3', '$2a$10$elqat0c.KxAlnRV58VOBfuCMboRRNnKG4Qs1bcc4qJDAQTqPLDRTi', '测试3', '1912623646@qq.com', '2022-08-08 01:46:56');
INSERT INTO `t_admin` (`id`, `login_acct`, `user_pswd`, `user_name`, `email`, `create_time`) VALUES (7, 'root', '$2a$10$YlFApwsuOTRxvVlzIKJ1IO20wPftE57QovWuBsKoh2NEYZWKLT6jK', '超级管理员', '0@qq.com', '2022-08-08 03:10:44');
COMMIT;

-- ----------------------------
-- Table structure for t_auth
-- ----------------------------
DROP TABLE IF EXISTS `t_auth`;
CREATE TABLE `t_auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of t_auth
-- ----------------------------
BEGIN;
INSERT INTO `t_auth` (`id`, `name`, `title`, `category_id`) VALUES (1, '', '用户模块', NULL);
INSERT INTO `t_auth` (`id`, `name`, `title`, `category_id`) VALUES (2, 'user:delete', '删除', 1);
INSERT INTO `t_auth` (`id`, `name`, `title`, `category_id`) VALUES (3, 'user:get', '查询', 1);
INSERT INTO `t_auth` (`id`, `name`, `title`, `category_id`) VALUES (4, 'user:save', '保存', 1);
INSERT INTO `t_auth` (`id`, `name`, `title`, `category_id`) VALUES (5, '', '角色模块', NULL);
INSERT INTO `t_auth` (`id`, `name`, `title`, `category_id`) VALUES (6, 'role:delete', '删除', 4);
INSERT INTO `t_auth` (`id`, `name`, `title`, `category_id`) VALUES (7, 'role:get', '查询', 4);
INSERT INTO `t_auth` (`id`, `name`, `title`, `category_id`) VALUES (8, 'role:save', '保存', 4);
COMMIT;

-- ----------------------------
-- Table structure for t_member
-- ----------------------------
DROP TABLE IF EXISTS `t_member`;
CREATE TABLE `t_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginacct` varchar(255) NOT NULL,
  `userpswd` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `authstatus` int(4) DEFAULT NULL COMMENT '实名认证状态 [{0: 未实名认证}, {1: 实名认证申请中}, {2: 已实名认证}]',
  `usertype` int(4) DEFAULT NULL COMMENT '[{0: 个人}, {1: 企业}]',
  `realname` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `cardnum` varchar(255) DEFAULT NULL COMMENT '卡号',
  `accttype` int(4) DEFAULT NULL COMMENT '[{0: 企业}, {1: 个体}, {2: 个人}, {3: 政府}]',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_member_pk` (`loginacct`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_member
-- ----------------------------
BEGIN;
INSERT INTO `t_member` (`id`, `loginacct`, `userpswd`, `username`, `email`, `authstatus`, `usertype`, `realname`, `cardnum`, `accttype`) VALUES (1, 'jack', '$2a$10$L/7qsHMpVsCRePdhzF7mbuGw2VBCbPd4oOR7I3W6TF04DFHUyb3Qe', '杰克', 'jack@qq.com', 1, 1, '杰克', '430626220104045821', 2);
INSERT INTO `t_member` (`id`, `loginacct`, `userpswd`, `username`, `email`, `authstatus`, `usertype`, `realname`, `cardnum`, `accttype`) VALUES (5, 'tom', '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_member` (`id`, `loginacct`, `userpswd`, `username`, `email`, `authstatus`, `usertype`, `realname`, `cardnum`, `accttype`) VALUES (6, 'qq', '$2a$10$qX4Dk3KHBnLo.AnkY4ngaeFkn0FBJcX3a3IWmFIjdFsv1rTifePD6', 'user', '123456@qq.com', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_member` (`id`, `loginacct`, `userpswd`, `username`, `email`, `authstatus`, `usertype`, `realname`, `cardnum`, `accttype`) VALUES (9, 'www', '$2a$10$fiOPIrd3LqtgpGxnAuPbsu0NUoz02RQLomTUCBLmsH/aqSHvDPEqO', 'eav', '123123@qq.com', NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_member_confirm_info
-- ----------------------------
DROP TABLE IF EXISTS `t_member_confirm_info`;
CREATE TABLE `t_member_confirm_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `memberid` int(11) DEFAULT NULL COMMENT 't_member 会员标识',
  `paynum` varchar(255) DEFAULT NULL COMMENT '易付宝企业账号',
  `cardnum` varchar(255) DEFAULT NULL COMMENT '法人身份证号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='发起人确认信息表';

-- ----------------------------
-- Records of t_member_confirm_info
-- ----------------------------
BEGIN;
INSERT INTO `t_member_confirm_info` (`id`, `memberid`, `paynum`, `cardnum`) VALUES (1, 1, '24123', '41234123');
INSERT INTO `t_member_confirm_info` (`id`, `memberid`, `paynum`, `cardnum`) VALUES (2, 1, '3123432', '31241324');
INSERT INTO `t_member_confirm_info` (`id`, `memberid`, `paynum`, `cardnum`) VALUES (3, 1, '4535', '3453453');
INSERT INTO `t_member_confirm_info` (`id`, `memberid`, `paynum`, `cardnum`) VALUES (4, 1, 'jack', '123123');
INSERT INTO `t_member_confirm_info` (`id`, `memberid`, `paynum`, `cardnum`) VALUES (5, 1, '234234', '23423423423');
INSERT INTO `t_member_confirm_info` (`id`, `memberid`, `paynum`, `cardnum`) VALUES (6, 1, '312312', '123123');
COMMIT;

-- ----------------------------
-- Table structure for t_member_copy1
-- ----------------------------
DROP TABLE IF EXISTS `t_member_copy1`;
CREATE TABLE `t_member_copy1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginacct` varchar(255) NOT NULL,
  `userpswd` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `authstatus` int(4) DEFAULT NULL COMMENT '实名认证状态 [{0: 未实名认证}, {1: 实名认证申请中}, {2: 已实名认证}]',
  `usertype` int(4) DEFAULT NULL COMMENT '[{0: 个人}, {1: 企业}]',
  `realname` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `cardnum` varchar(255) DEFAULT NULL COMMENT '卡号',
  `accttype` int(4) DEFAULT NULL COMMENT '[{0: 企业}, {1: 个体}, {2: 个人}, {3: 政府}]',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_member_pk` (`loginacct`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_member_copy1
-- ----------------------------
BEGIN;
INSERT INTO `t_member_copy1` (`id`, `loginacct`, `userpswd`, `username`, `email`, `authstatus`, `usertype`, `realname`, `cardnum`, `accttype`) VALUES (1, 'jack', '$2a$10$L/7qsHMpVsCRePdhzF7mbuGw2VBCbPd4oOR7I3W6TF04DFHUyb3Qe', '杰克', 'jack@qq.com', 1, 1, '杰克', '430626220104045821', 2);
INSERT INTO `t_member_copy1` (`id`, `loginacct`, `userpswd`, `username`, `email`, `authstatus`, `usertype`, `realname`, `cardnum`, `accttype`) VALUES (5, 'tom', '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_member_copy1` (`id`, `loginacct`, `userpswd`, `username`, `email`, `authstatus`, `usertype`, `realname`, `cardnum`, `accttype`) VALUES (6, 'qq', '$2a$10$qX4Dk3KHBnLo.AnkY4ngaeFkn0FBJcX3a3IWmFIjdFsv1rTifePD6', 'user', '123456@qq.com', NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_member_launch_info
-- ----------------------------
DROP TABLE IF EXISTS `t_member_launch_info`;
CREATE TABLE `t_member_launch_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `memberid` int(11) DEFAULT NULL COMMENT 't_member 会员标识',
  `description_simple` varchar(255) DEFAULT NULL COMMENT '自我介绍',
  `description_detail` varchar(255) DEFAULT NULL COMMENT '详细介绍',
  `phone_num` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `service_num` varchar(255) DEFAULT NULL COMMENT '客服电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='项目发起人信息表';

-- ----------------------------
-- Records of t_member_launch_info
-- ----------------------------
BEGIN;
INSERT INTO `t_member_launch_info` (`id`, `memberid`, `description_simple`, `description_detail`, `phone_num`, `service_num`) VALUES (9, 1, 'i am mao', '我是猫哥', '123456', '654321');
INSERT INTO `t_member_launch_info` (`id`, `memberid`, `description_simple`, `description_detail`, `phone_num`, `service_num`) VALUES (10, 1, 'i am mao', '我是猫哥', '123456', '654321');
INSERT INTO `t_member_launch_info` (`id`, `memberid`, `description_simple`, `description_detail`, `phone_num`, `service_num`) VALUES (11, 1, 'i am mao', '我是猫哥', '123456', '654321');
INSERT INTO `t_member_launch_info` (`id`, `memberid`, `description_simple`, `description_detail`, `phone_num`, `service_num`) VALUES (12, 1, 'i am mao', '我是猫哥', '123456', '654321');
INSERT INTO `t_member_launch_info` (`id`, `memberid`, `description_simple`, `description_detail`, `phone_num`, `service_num`) VALUES (13, 1, 'i am mao', '我是猫哥', '123456', '654321');
INSERT INTO `t_member_launch_info` (`id`, `memberid`, `description_simple`, `description_detail`, `phone_num`, `service_num`) VALUES (14, 1, 'i am mao', '我是猫哥', '123456', '654321');
COMMIT;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `icon` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
BEGIN;
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (1, NULL, '系统权限菜单', NULL, 'glyphicon glyphicon-th-list');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (2, 1, ' 控 制 面 板 ', 'main.htm', 'glyphicon glyphicon-dashboard');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (3, 1, '权限管理', NULL, 'glyphicon glyphicon glyphicon-tasks');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (4, 3, ' 用 户 维 护 ', 'user/index.htm', 'glyphicon glyphicon-user');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (5, 3, ' 角 色 维 护 ', 'role/index.htm', 'glyphicon glyphicon-king');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (6, 3, ' 菜 单 维 护 ', 'permission/index.htm', 'glyphicon glyphicon-lock');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (7, 1, ' 业 务 审 核 ', NULL, 'glyphicon glyphicon-ok');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (8, 7, ' 实 名 认 证 审 核 ', 'auth_cert/index.htm', 'glyphicon glyphicon-check');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (9, 7, ' 广 告 审 核 ', 'auth_adv/index.htm', 'glyphicon glyphicon-check');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (10, 7, ' 项 目 审 核 ', 'auth_project/index.htm', 'glyphicon glyphicon-check');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (11, 1, ' 业 务 管 理 ', NULL, 'glyphicon glyphicon-th-large');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (12, 11, ' 资 质 维 护 ', 'cert/index.htm', 'glyphicon glyphicon-picture');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (13, 11, ' 分 类 管 理 ', 'certtype/index.htm', 'glyphicon glyphicon-equalizer');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (14, 11, ' 流 程 管 理 ', 'process/index.htm', 'glyphicon glyphicon-random');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (15, 11, ' 广 告 管 理 ', 'advert/index.htm', 'glyphicon glyphicon-hdd');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (16, 11, ' 消 息 模 板 ', 'message/index.htm', 'glyphicon glyphicon-comment');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (17, 11, ' 项 目 分 类 ', 'projectType/index.htm', 'glyphicon glyphicon-list');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (18, 11, ' 项 目 标 签 ', 'tag/index.htm', 'glyphicon glyphicon-tags');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (19, 1, ' 参 数 管 理 ', 'param/index.htm', 'glyphicon glyphicon-list-alt');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (20, 1, 'A', 'A', 'glyphicon glyphicon-list-alt');
COMMIT;

-- ----------------------------
-- Table structure for t_project
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `project_description` varchar(255) DEFAULT NULL COMMENT '项目描述',
  `money` bigint(11) DEFAULT NULL COMMENT '筹集金额',
  `day` int(11) DEFAULT NULL COMMENT '筹集天数',
  `status` int(4) DEFAULT NULL COMMENT '[{0: 审核中}, {1: 众筹中}, {2: 众筹成功}, {3: 众筹失败}]',
  `deploydate` varchar(255) DEFAULT NULL COMMENT '项目发起时间',
  `supportmoney` bigint(11) DEFAULT NULL COMMENT '已筹集到的金额',
  `supporter` int(11) DEFAULT NULL COMMENT '支持人数',
  `completion` int(3) DEFAULT NULL COMMENT '百分比完成度',
  `memberid` int(11) DEFAULT NULL COMMENT '发起人的会员标识',
  `createdate` varchar(19) DEFAULT NULL COMMENT '项目创建时间',
  `follower` int(11) DEFAULT NULL COMMENT '关注人数',
  `header_picture_path` varchar(255) DEFAULT NULL COMMENT '头图路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='项目表';

-- ----------------------------
-- Records of t_project
-- ----------------------------
BEGIN;
INSERT INTO `t_project` (`id`, `project_name`, `project_description`, `money`, `day`, `status`, `deploydate`, `supportmoney`, `supporter`, `completion`, `memberid`, `createdate`, `follower`, `header_picture_path`) VALUES (15, 'brotherMao', '就是帅！', 100, 30, 0, '2022-09-04', 11, 1, 11, 1, '2022-09-03', 11, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/4fcaa821-f0b7-46f8-aebc-825bb1e208b2.jpg');
INSERT INTO `t_project` (`id`, `project_name`, `project_description`, `money`, `day`, `status`, `deploydate`, `supportmoney`, `supporter`, `completion`, `memberid`, `createdate`, `follower`, `header_picture_path`) VALUES (16, 'brotherMao', '就是帅！', 100, 30, 0, '2022-09-04', 11, 2, 11, 1, '2022-09-03', 12, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/4fcaa821-f0b7-46f8-aebc-825bb1e208b2.jpg');
INSERT INTO `t_project` (`id`, `project_name`, `project_description`, `money`, `day`, `status`, `deploydate`, `supportmoney`, `supporter`, `completion`, `memberid`, `createdate`, `follower`, `header_picture_path`) VALUES (17, 'brotherMao', '就是帅！', 100, 30, 0, '2022-09-04', 11, 3, 11, 1, '2022-09-03', 13, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/4fcaa821-f0b7-46f8-aebc-825bb1e208b2.jpg');
INSERT INTO `t_project` (`id`, `project_name`, `project_description`, `money`, `day`, `status`, `deploydate`, `supportmoney`, `supporter`, `completion`, `memberid`, `createdate`, `follower`, `header_picture_path`) VALUES (18, 'brotherMao', '就是帅！', 100, 30, 0, '2022-09-04', 11, 4, 11, 1, '2022-09-03', 14, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/4fcaa821-f0b7-46f8-aebc-825bb1e208b2.jpg');
INSERT INTO `t_project` (`id`, `project_name`, `project_description`, `money`, `day`, `status`, `deploydate`, `supportmoney`, `supporter`, `completion`, `memberid`, `createdate`, `follower`, `header_picture_path`) VALUES (19, 'brotherMao', '就是帅！', 100, 30, 0, '2022-09-01', 11, 5, 11, 1, '2022-09-03', 15, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/4fcaa821-f0b7-46f8-aebc-825bb1e208b2.jpg');
INSERT INTO `t_project` (`id`, `project_name`, `project_description`, `money`, `day`, `status`, `deploydate`, `supportmoney`, `supporter`, `completion`, `memberid`, `createdate`, `follower`, `header_picture_path`) VALUES (20, 'brotherMao', '就是帅！', 100, 30, 0, '2022-09-04', 11, 6, 11, 1, '2022-09-04', 16, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/4fcaa821-f0b7-46f8-aebc-825bb1e208b2.jpg');
COMMIT;

-- ----------------------------
-- Table structure for t_project_item_pic
-- ----------------------------
DROP TABLE IF EXISTS `t_project_item_pic`;
CREATE TABLE `t_project_item_pic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectid` int(11) DEFAULT NULL COMMENT 't_project 标识',
  `item_pic_path` varchar(255) DEFAULT NULL COMMENT '图片名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='项目表项目详情图片表';

-- ----------------------------
-- Records of t_project_item_pic
-- ----------------------------
BEGIN;
INSERT INTO `t_project_item_pic` (`id`, `projectid`, `item_pic_path`) VALUES (9, 15, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/deb8461d-cdb4-4652-9aed-096a63671bdb.jpg');
INSERT INTO `t_project_item_pic` (`id`, `projectid`, `item_pic_path`) VALUES (10, 16, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/deb8461d-cdb4-4652-9aed-096a63671bdb.jpg');
INSERT INTO `t_project_item_pic` (`id`, `projectid`, `item_pic_path`) VALUES (11, 17, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/deb8461d-cdb4-4652-9aed-096a63671bdb.jpg');
INSERT INTO `t_project_item_pic` (`id`, `projectid`, `item_pic_path`) VALUES (12, 18, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/deb8461d-cdb4-4652-9aed-096a63671bdb.jpg');
INSERT INTO `t_project_item_pic` (`id`, `projectid`, `item_pic_path`) VALUES (13, 19, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/deb8461d-cdb4-4652-9aed-096a63671bdb.jpg');
INSERT INTO `t_project_item_pic` (`id`, `projectid`, `item_pic_path`) VALUES (14, 20, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/deb8461d-cdb4-4652-9aed-096a63671bdb.jpg');
COMMIT;

-- ----------------------------
-- Table structure for t_project_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_project_tag`;
CREATE TABLE `t_project_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectid` int(11) DEFAULT NULL COMMENT 't_project 标识',
  `tagid` int(11) DEFAULT NULL COMMENT 't_tag 标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='项目标签中间表';

-- ----------------------------
-- Records of t_project_tag
-- ----------------------------
BEGIN;
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (19, 15, 4);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (20, 15, 7);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (21, 16, 9);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (22, 16, 7);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (23, 17, 4);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (24, 17, 7);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (25, 17, 9);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (26, 18, 7);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (27, 18, 9);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (28, 18, 7);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (29, 18, 9);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (30, 18, 7);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (31, 18, 9);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (32, 19, 4);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (33, 19, 7);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (34, 19, 9);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (35, 20, 6);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (36, 20, 8);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (37, 20, 10);
COMMIT;

-- ----------------------------
-- Table structure for t_project_type
-- ----------------------------
DROP TABLE IF EXISTS `t_project_type`;
CREATE TABLE `t_project_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectid` int(11) DEFAULT NULL COMMENT 't_project 标识',
  `typeid` int(11) DEFAULT NULL COMMENT 't_type 标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='项目和分类中间表';

-- ----------------------------
-- Records of t_project_type
-- ----------------------------
BEGIN;
INSERT INTO `t_project_type` (`id`, `projectid`, `typeid`) VALUES (29, 15, 2);
INSERT INTO `t_project_type` (`id`, `projectid`, `typeid`) VALUES (30, 15, 4);
INSERT INTO `t_project_type` (`id`, `projectid`, `typeid`) VALUES (31, 16, 2);
INSERT INTO `t_project_type` (`id`, `projectid`, `typeid`) VALUES (32, 16, 4);
INSERT INTO `t_project_type` (`id`, `projectid`, `typeid`) VALUES (33, 17, 2);
INSERT INTO `t_project_type` (`id`, `projectid`, `typeid`) VALUES (34, 17, 4);
INSERT INTO `t_project_type` (`id`, `projectid`, `typeid`) VALUES (35, 18, 2);
INSERT INTO `t_project_type` (`id`, `projectid`, `typeid`) VALUES (36, 18, 4);
INSERT INTO `t_project_type` (`id`, `projectid`, `typeid`) VALUES (37, 19, 1);
INSERT INTO `t_project_type` (`id`, `projectid`, `typeid`) VALUES (38, 20, 3);
COMMIT;

-- ----------------------------
-- Table structure for t_return
-- ----------------------------
DROP TABLE IF EXISTS `t_return`;
CREATE TABLE `t_return` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectid` int(11) DEFAULT NULL COMMENT 't_projcet 项目标识',
  `type` int(4) DEFAULT NULL COMMENT '[{0: 实物回报}, {1: 虚拟物品回报}]',
  `supportmoney` int(11) DEFAULT NULL COMMENT '支持金额',
  `content` varchar(255) DEFAULT NULL COMMENT '回报内容',
  `count` int(11) DEFAULT NULL COMMENT '回报产品限额 {0: 不限额回报数量}',
  `signalpurchase` int(11) DEFAULT NULL COMMENT '是否设置单笔限购',
  `purchase` int(11) DEFAULT NULL COMMENT '具体限购数量',
  `freight` int(11) DEFAULT NULL COMMENT '运费 {0: 包邮}',
  `invoice` int(4) DEFAULT NULL COMMENT '[{0: 不开发票}, {1: 开发票}]',
  `returndate` int(11) DEFAULT NULL COMMENT '项目结束后多少天向支持者发送回报',
  `describ_pic_path` varchar(255) DEFAULT NULL COMMENT '说明图片路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='回报信息表';

-- ----------------------------
-- Records of t_return
-- ----------------------------
BEGIN;
INSERT INTO `t_return` (`id`, `projectid`, `type`, `supportmoney`, `content`, `count`, `signalpurchase`, `purchase`, `freight`, `invoice`, `returndate`, `describ_pic_path`) VALUES (1, 15, 1, 10, '以身相许', 5, 1, 8, 0, 1, 15, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/56c4d3ca-cb1f-4cfb-9bff-64fec98e131b.jpg');
INSERT INTO `t_return` (`id`, `projectid`, `type`, `supportmoney`, `content`, `count`, `signalpurchase`, `purchase`, `freight`, `invoice`, `returndate`, `describ_pic_path`) VALUES (2, 16, 1, 10, '以身相许', 5, 1, 8, 0, 1, 15, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/56c4d3ca-cb1f-4cfb-9bff-64fec98e131b.jpg');
INSERT INTO `t_return` (`id`, `projectid`, `type`, `supportmoney`, `content`, `count`, `signalpurchase`, `purchase`, `freight`, `invoice`, `returndate`, `describ_pic_path`) VALUES (3, 17, 0, 10, '以身相许', 5, 1, 8, 0, 1, 15, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/56c4d3ca-cb1f-4cfb-9bff-64fec98e131b.jpg');
INSERT INTO `t_return` (`id`, `projectid`, `type`, `supportmoney`, `content`, `count`, `signalpurchase`, `purchase`, `freight`, `invoice`, `returndate`, `describ_pic_path`) VALUES (4, 18, 0, 10, '以身相许', 5, 1, 8, 0, 1, 15, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/56c4d3ca-cb1f-4cfb-9bff-64fec98e131b.jpg');
INSERT INTO `t_return` (`id`, `projectid`, `type`, `supportmoney`, `content`, `count`, `signalpurchase`, `purchase`, `freight`, `invoice`, `returndate`, `describ_pic_path`) VALUES (5, 19, 0, 10, '以身相许', 5, 1, 8, 0, 1, 15, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/56c4d3ca-cb1f-4cfb-9bff-64fec98e131b.jpg');
INSERT INTO `t_return` (`id`, `projectid`, `type`, `supportmoney`, `content`, `count`, `signalpurchase`, `purchase`, `freight`, `invoice`, `returndate`, `describ_pic_path`) VALUES (6, 20, 1, 10, '以身相许', 5, 1, 8, 0, 1, 15, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/56c4d3ca-cb1f-4cfb-9bff-64fec98e131b.jpg');
COMMIT;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色 ID',
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
BEGIN;
INSERT INTO `t_role` (`id`, `name`) VALUES (1, '经理');
INSERT INTO `t_role` (`id`, `name`) VALUES (2, '部长');
INSERT INTO `t_role` (`id`, `name`) VALUES (3, '经理操作者');
INSERT INTO `t_role` (`id`, `name`) VALUES (4, '部长操作者');
INSERT INTO `t_role` (`id`, `name`) VALUES (5, 'Admin');
COMMIT;

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '标签名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='标签表';

-- ----------------------------
-- Records of t_tag
-- ----------------------------
BEGIN;
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (1, NULL, '手机');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (2, NULL, '数码');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (3, NULL, '电脑');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (4, 1, '大屏');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (5, 1, '美颜');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (6, 1, '续航');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (7, 2, '高解析度');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (8, 2, '高清');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (9, 3, '大内存');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (10, 3, '固态');
COMMIT;

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '分类说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='分类表';

-- ----------------------------
-- Records of t_type
-- ----------------------------
BEGIN;
INSERT INTO `t_type` (`id`, `name`, `remark`) VALUES (1, '科技', '开启科技未来');
INSERT INTO `t_type` (`id`, `name`, `remark`) VALUES (2, '设计', '创建改变未来');
INSERT INTO `t_type` (`id`, `name`, `remark`) VALUES (3, '公益', '汇集点点爱心');
INSERT INTO `t_type` (`id`, `name`, `remark`) VALUES (4, '农业', '网络天下肥美');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
```



### 1.4 代码

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1662176485334-62e21d4d-9c93-4d28-97af-0ae006c0c9cf.jpeg)

#### 1.4.1 新建 `PortalTypeVO` 实体类【`entity` 工程】

```java
package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 首页展示数据
 *
 * @author 陈江林
 * @date 2022/9/3 20:10
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PortalTypeVO {

    private Integer id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 分类说明
     */
    private String remark;

    /**
     * 首页展示数据-分类中的项目信息
     */
    private List<PortalProjectVO> portalProjectVO;

}
```



#### 1.4.2 新建 `PortalProjectVO` 实体类【`entity` 工程】

```java
package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 首页展示数据-分类中的项目信息
 *
 * @author 陈江林
 * @date 2022/9/3 20:11
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PortalProjectVO {

    private Integer projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 头图路径
     */
    private String headerPicturePath;

    /**
     * 筹集金额
     */
    private Integer money;

    /**
     * 项目发起时间
     */
    private String deployDate;

    /**
     * 已筹集到的金额/筹集金额 百分比
     */
    private String percentage;

    /**
     * 支持人数
     */
    private Integer supporter;

}
```



#### 1.4.3  暴露数据查询的接口【`mysql` 工程】

- `ProjectPOMapper.xml` 中编写查询数据的 SQL 语句

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662208001634-ae6cf459-d1ff-482b-9fb2-89654506e57c.png)

```xml
    <!-- 首页数据 start -->
    <select id="selectPortalTypeVOList" resultMap="LoadPortalProjectListResultMap">
        select id, name, remark
        from t_type
    </select>

    <resultMap type="com.atguigu.crowd.entity.vo.PortalTypeVO" id="LoadPortalProjectListResultMap">
        <!-- 分类数据的常规属性 -->
        <id column="id" property="id"/>
        <id column="name" property="name"/>
        <id column="remark" property="remark"/>

        <!-- 分类数据中包含的项目数据的 List -->
        <!-- property 属性: 对应 PortalTypeVO 中分类数据中项目数据的 List 属性 -->
        <!-- column 属性: 接下来查询项目时需要用到的分类 id, 就是通过 column 属性把值传入 -->
        <!-- ofType 属性: 项目数据的实体类型 PortalProjectVO -->
        <collection
                property="portalProjectVO"
                column="id"
                ofType="com.atguigu.crowd.entity.vo.PortalProjectVO"
                select="com.atguigu.crowd.mapper.ProjectPOMapper.selectPortalProjectVOList"
        >
        </collection>
    </resultMap>

    <select id="selectPortalProjectVOList" resultType="com.atguigu.crowd.entity.vo.PortalProjectVO">
        SELECT t_project.id                         projectId,
               project_name                         projectName,
               header_picture_path                  headerPicturePath,
               money,
               deploydate                           deployDate,
               supportmoney / t_project.money * 100 percentage,
               supporter
        FROM t_project
                 LEFT JOIN t_project_type ON t_project.id = t_project_type.projectid
        WHERE t_project_type.typeid = #{id}
        ORDER BY t_project.id DESC
        LIMIT 0,4
    </select>
    <!-- 首页数据 end -->
```



- 在 `ProjectPOMapper` 接口中声明查询数据的方法

```java
    /**
     * 查询首页数据
     * 
     * @return
     */
    List<PortalTypeVO> selectPortalTypeVOList();
```



- 测试

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662208785344-d0c14f89-795c-49f3-bf73-e22a5ce4270a.png)

```java
    @Autowired
    private ProjectPOMapper projectPOMapper;

	/**
     * 测试首页数据
     */
    @Test
    public void testPortData() {
        List<PortalTypeVO> typeVOList = projectPOMapper.selectPortalTypeVOList();
        typeVOList.forEach(portalTypeVO -> {
            String name = portalTypeVO.getName();
            String remark = portalTypeVO.getRemark();
            logger.info("name = " + name + " remark = " + remark);

            List<PortalProjectVO> portalProjectVOList = portalTypeVO.getPortalProjectVO();
            portalProjectVOList.forEach(portalProjectVO -> {
                logger.info(portalProjectVO.toString());
            });
        });
    }
```



- 在 `ProjectService` 中调用 `Mapper` 方法, 拿到数据

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662208933835-f945684c-4106-46f3-ae7f-7ff61007b375.png)

```java
    /**
     * 查询首页数据
     * 
     * @return
     */
    List<PortalTypeVO> getPortalTypeVO();
```

- `ProjectServiceImpl`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662208945520-8b10835b-0cec-4bc6-832b-a79294ff9638.png)

```java
    @Override
    public List<PortalTypeVO> getPortalTypeVO() {
        return projectPOMapper.selectPortalTypeVOList();
    }
```



- 在 `ProjectHandler` 中调用 `Service` 方法拿到数据

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662208957489-7ed49363-95d9-4d8e-b4ca-ca60395a5e3e.png)

```java
    @RequestMapping("/get/portal/type/project/data/remote")
    public ResultEntity<List<PortalTypeVO>> getPortalTypeProjectDataRemote() {

        try {
            List<PortalTypeVO> portalTypeVOList = projectService.getPortalTypeVO();
            return ResultEntity.successWithData(portalTypeVOList);
        } catch (Exception e) {
            return ResultEntity.failed(e.getMessage());
        }

    }
```



#### 1.4.4 声明一个 Feign 的接口 【`api` 工程】

```java
    /**
     * 查询首页数据
     * 
     * @return
     */
    @RequestMapping("/get/portal/type/project/data/remote")
    ResultEntity<List<PortalTypeVO>> getPortalTypeProjectDataRemote();
```



#### 1.4.5 调用 `mysql` 暴露的接口拿到数据存入到模型 【`auth` 工程】

```java
package com.atguigu.crowd.handler;

import com.atguigu.crowd.api.MySQLRemoteService;
import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.vo.PortalTypeVO;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 陈江林
 * @date 2022/8/28 22:14
 */
@Controller
public class PortalHandler {

    @Autowired
    private MySQLRemoteService mySQLRemoteService;

    /**
     * 显示首页
     *
     * @return
     */
    @RequestMapping("/")
    public String toPortalPage(Model model) {
        // 查询首页要显示的数据
        ResultEntity<List<PortalTypeVO>> resultEntity = mySQLRemoteService.getPortalTypeProjectDataRemote();

        // 检查查询结果
        String result = resultEntity.getResult();
        if(ResultEntity.SUCCESS.equals(result)) {
            // 获取查询结果数据
            List<PortalTypeVO> list = resultEntity.getData();

            // 存入模型中
            // ATTR_NAME_PORTAL_DATA = portal_data
            model.addAttribute(CrowdConstant.ATTR_NAME_PORTAL_DATA, list);
        }

        return "portal";
    }

}
```



#### 1.4.6 在 `portal.html` 中显示模型中的数据【`auth` 工程】

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
        $(function () {
            $(".thumbnail img").css("cursor", "pointer");
            $(".thumbnail img").click(function () {
                window.location.href = "project.html";
            });
        })
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
                        <!--                        <li><a href="login.html">登录</a></li>-->
                        <!--                        <li><a href="reg.html">注册</a></li>-->
                        <li><a th:href="@{/auth/member/to/login/page}">登录</a></li>
                        <li><a th:href="@{/auth/member/to/reg/page}">注册</a></li>
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

    <div th:if="${#lists.isEmpty(portal_data)}">该分类下还没有任何的项目</div>
    <div th:unless="${#lists.isEmpty(portal_data)}">
        <div th:each="type : ${portal_data}" class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="box ui-draggable">
                        <div class="mHd" style="">
                            <div class="path">
                                <a href="projects.html">更多...</a>
                            </div>
                            <h3>
                                <label th:text="${type.name}">科技</label>
                                <small th:text="${type.remark}" style="color:#FFF;">开启智慧未来</small>
                            </h3>
                        </div>
                        <div class="mBd" style="padding-top:10px;">
                            <div class="row">
                                <div th:if="${#lists.isEmpty(type.portalProjectVO)}">该分类下还没有任何的项目</div>
                                <div th:unless="${#lists.isEmpty(type.portalProjectVO)}">
                                    <div th:each="project : ${type.portalProjectVO}" class="col-md-3">
                                        <div class="thumbnail">
                                            <img alt="300x200" th:src="${project.headerPicturePath}"
                                                 src="img/product-1.jpg"/>
                                            <div class="caption">
                                                <h3 class="break">
                                                    <!--                                                    <a th:href="@{'/portal/show/project/detail/'+${project.projectId}}"-->
                                                    <a th:href="@{/portal/show/project/detail/{projectId}(projectId=${project.projectId})}"
                                                       th:text="${project.projectName}">活性富氢净水直饮机</a>
                                                </h3>
                                                <p>
                                                <div style="float:left;">
                                                    <i class="glyphicon glyphicon-screenshot" title="目标金额"></i>
                                                    $<span th:text="${project.money}">20,000</span>
                                                </div>
                                                <div style="float:right;">
                                                    <i title="截至日期" class="glyphicon glyphicon-calendar"></i>
                                                    <span th:text="${project.deployDate}">2017-20-20</span>
                                                </div>
                                                </p>
                                                <br>
                                                <div class="progress" style="margin-bottom: 4px;">
                                                    <div class="progress-bar progress-bar-success" role="progressbar"
                                                         th:aria-valuenow="${project.percentage}" aria-valuemin="0"
                                                         aria-valuemax="100"
                                                         th:style="'width: ' + ${project.percentage} + '%'">
                                                        <span th:text="${project.percentage} + '%'">40%</span>
                                                    </div>
                                                </div>
                                                <div><span style="float:right;">
                                                    <i class="glyphicon glyphicon-star-empty"></i>
                                                </span>
                                                    <span>
                                                        <i class="glyphicon glyphicon-user" title="支持人数"></i>
                                                    <span th:text="${project.supporter}">12345</span>
                                                </span>
                                                </div>
                                            </div>
                                        </div>
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



## 2. 显示项目详情

### 2.1 目标

- 在首页点击项目名称跳转显示项目详情信息

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662398003558-d70971de-47a7-4c79-adec-f44893069965.png)



### 2.2 思路

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662288003965-54f5ca25-780e-496e-b189-5e610e94aafa.png)



### 2.3 代码

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1662400650709-e17e108b-5698-45c0-9db8-002c9b01ad6f.jpeg)



#### 2.3.1 创建 `DetailProjectVO`实体类【`entity` 工程】

```java
package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 项目数据:
 * - 首页 > 项目详情页面 {项目数据: [回报数据]}
 *
 * @author 陈江林
 * @date 2022/9/4 21:52
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DetailProjectVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目主键
     */
    private Integer projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目简介
     */
    private String projectDesc;

    /**
     * 多少人关注
     */
    private Integer followerCount;

    /**
     * 筹集天数
     */
    private Integer day;

    /**
     * [{0: 审核中}, {1: 众筹中}, {2: 众筹成功}, {3: 众筹失败}]
     */
    private Integer status;

    /**
     * 对应 status 对象值
     */
    private String statusText;

    /**
     * 筹集多少钱
     */
    private Integer money;

    /**
     * 已经筹集多少钱
     */
    private Integer supportMoney;

    /**
     * 筹集百分比
     */
    private Integer percentage;

    /**
     * 项目发起时间
     */
    private String deployDate;

    /**
     * 还剩多少天
     */
    private Integer lastDay;

    /**
     * 有多少人支持
     */
    private Integer supporterCount;

    /**
     * 头图路径
     */
    private String headerPicturePath;

    /**
     * 详情图片路径
     */
    private List<String> detailPicturePathList;

    /**
     * 回报信息
     */
    private List<DetailReturnVO> detailReturnVOList;

}
```



#### 2.3.2 创建 `DetailReturnVO`实体类【`entity` 工程】

```java
package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 回报数据:
 * - 首页 > 项目详情页面 {项目数据: [回报数据]}
 *
 * @author 陈江林
 * @date 2022/9/4 21:47
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DetailReturnVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 回报信息主键
     */
    private Integer returnId;

    /**
     * 当前档位需支持的金额
     */
    private Integer supportMoney;

    /**
     * 单笔限购, [{0: 无限额}, {1, 有限额}]
     */
    private Integer signalPurchase;

    /**
     * 具体限额数量
     */
    private Integer purchase;

    /**
     * 当前该档位支持者数量
     */
    private Integer supporterCount;

    /**
     * 运费, 取值为0时包邮
     */
    private Integer freight;

    /**
     * 众筹成功后多少天发货
     */
    private Integer returnDate;

    /**
     * 回报内容
     */
    private String content;

}
```



#### 2.3.3 暴露数据查询的接口【`mysql` 工程】

- `ProjectPOMapper.xml` 中编写查询数据的 SQL 语句

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662302982594-eec98638-41f4-44cd-8af8-8359e992fb31.png)

```xml
    <!-- 首页 > 项目详情页面数据 start -->
    <!--
        create table t_project
        (
            id                  int auto_increment primary key,
            project_name        varchar(255) null comment '项目名称',
            project_description varchar(255) null comment '项目描述',
            money               bigint(11)   null comment '筹集金额',
            day                 int          null comment '筹集天数',
            status              int(4)       null comment '[{0: 审核中}, {1: 众筹中}, {2: 众筹成功}, {3: 众筹失败}]',
            deploydate          varchar(255) null comment '项目发起时间',
            supportmoney        bigint(11)   null comment '已筹集到的金额',
            supporter           int          null comment '支持人数',
            completion          int(3)       null comment '百分比完成度',
            memberid            int          null comment '发起人的会员标识',
            createdate          varchar(19)  null comment '项目创建时间',
            follower            int          null comment '关注人数',
            header_picture_path varchar(255) null comment '头图路径'
        ) comment '项目表';
     -->
    <select id="selectDetailProjectVO" resultMap="loadPortalProjectListResultMap">
        select id ,
        project_name ,
        project_description ,
        money ,
               day,
        status ,
        deploydate ,
        supportmoney ,
        supporter ,
        supportmoney/money*100 percentage,
        follower ,
        header_picture_path
        <!--List<String> detailPicturePathList-->
        <!-- List<DetailReturnVO> detailReturnVOList-->
        from t_project where id = #{id}
    </select>

    <resultMap id="loadPortalProjectListResultMap" type="com.atguigu.crowd.entity.vo.DetailProjectVO">
        <id column="id" property="projectId"/>
        <result column="project_name" property="projectName"/>
        <result column="project_description" property="projectDesc"/>
        <result column="money" property="money"/>
        <result column="day" property="day"/>
        <result column="status" property="status"/>
        <result column="deploydate" property="deployDate"/>
        <result column="supportmoney" property="supportMoney"/>
        <result column="supporter" property="supporterCount"/>
        <result column="percentage" property="percentage"/>
        <result column="follower" property="followerCount"/>
        <result column="header_picture_path" property="headerPicturePath"/>
        <collection property="detailPicturePathList" select="com.atguigu.crowd.mapper.ProjectPOMapper.selectDetailPicturePathList"
                    column="id"/>
        <collection property="detailReturnVOList" select="com.atguigu.crowd.mapper.ProjectPOMapper.selectDetailReturnVOList"
                    column="id"/>
    </resultMap>

    <!-- 首页 > 项目详情中 > 详情图片 -->
    <select id="selectDetailPicturePathList" resultType="string">
        select item_pic_path
        from t_project_item_pic
        where projectid = #{id}
    </select>

    <!-- 首页 > 项目详情中 > 回报数据 -->
    <!--
        create table t_return
        (
            id               int auto_increment primary key,
            projectid        int          null comment 't_projcet 项目标识',
            type             int(4)       null comment '[{0: 实物回报}, {1: 虚拟物品回报}]',
            supportmoney     int          null comment '支持金额',
            content          varchar(255) null comment '回报内容',
            count            int          null comment '回报产品限额 {0: 不限额回报数量}',
            signalpurchase   int          null comment '是否设置单笔限购  [{0: 无限额}, {1, 有限额}]',
            purchase         int          null comment '具体限购数量',
            freight          int          null comment '运费 {0: 包邮}',
            invoice          int(4)       null comment '[{0: 不开发票}, {1: 开发票}]',
            returndate       int          null comment '项目结束后多少天向支持者发送回报',
            describ_pic_path varchar(255) null comment '说明图片路径'
        ) comment '回报信息表';
    -->
    <select id="selectDetailReturnVOList" resultType="com.atguigu.crowd.entity.vo.DetailReturnVO">
        select id             returnId,
               supportmoney   supportMoney,
               content,
               signalpurchase signalPurchase,
               purchase,
               freight,
               returndate     returnDate
        from t_return
        where projectid = #{id}
    </select>
    <!-- 首页 > 项目详情页面数据 end -->
```

- 在 `ProjectPOMapper` 接口中声明查询数据的方法

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662303219782-c27506a9-40e2-4051-9706-8163d3598446.png)

```java
    /**
     * 查询首页 > 项目详情页面数据
     *
     * @param projectId
     * @return
     */
    DetailProjectVO selectDetailProjectVO(Integer projectId);

    /**
     * 首页 > 项目详情中 > 详情图片
     *
     * @param projectId
     * @return
     */
    List<String> selectDetailPicturePathList(Integer projectId);

    /**
     * 首页 > 项目详情中 > 回报数据
     *
     * @param projectId
     * @return
     */
    List<DetailReturnVO> selectDetailReturnVOList(Integer projectId);
```

- 测试

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662208785344-d0c14f89-795c-49f3-bf73-e22a5ce4270a.png)

```java
    /**
     * 测试 首页 > 项目详情页面 数据
     */
    @Test
    public void testSelectDetailProjectVO() {
        DetailProjectVO detailProjectVO = projectPOMapper.selectDetailProjectVO(20);
        logger.info(detailProjectVO.getProjectId() + "");
        logger.info(detailProjectVO.getProjectName() + "");
        logger.info(detailProjectVO.getProjectDesc() + "");
        logger.info(detailProjectVO.getFollowerCount() + "");
        logger.info(detailProjectVO.getStatus() + "");
        logger.info(detailProjectVO.getMoney() + "");
        logger.info(detailProjectVO.getSupportMoney() + "");
        logger.info(detailProjectVO.getPercentage() + "");
        logger.info(detailProjectVO.getDeployDate() + "");
        logger.info(detailProjectVO.getLastDay() + "");
        logger.info(detailProjectVO.getSupporterCount() + "");
        logger.info(detailProjectVO.getHeaderPicturePath() + "");

        detailProjectVO.getDetailPicturePathList().forEach(detailPicturePath -> logger.info("详情图片路径: " + detailPicturePath));
        detailProjectVO.getDetailReturnVOList().forEach(detailReturnVO -> {
            logger.info("" + detailReturnVO.getReturnId());
            logger.info("" + detailReturnVO.getSupportMoney());
            logger.info("" + detailReturnVO.getSignalPurchase());
            logger.info("" + detailReturnVO.getPurchase());
            logger.info("" + detailReturnVO.getSupporterCount());
            logger.info("" + detailReturnVO.getFreight());
            logger.info("" + detailReturnVO.getReturnDate());
            logger.info("" + detailReturnVO.getContent());
        });
    }
```

- 在 `ProjectService` 中调用 `Mapper` 方法, 拿到数据

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662208933835-f945684c-4106-46f3-ae7f-7ff61007b375.png)

```java
    /**
     * 查询首页 > 项目详情页面数据
     *
     * @param projectId
     * @return
     */
    DetailProjectVO getDetailProjectVO(Integer projectId);
```

- `ProjectServiceImpl`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662208945520-8b10835b-0cec-4bc6-832b-a79294ff9638.png)

```java
    @Override
    public DetailProjectVO getDetailProjectVO(Integer projectId) {
        // 查询得到 DetailProjectVO 对象
        DetailProjectVO detailProjectVO = projectPOMapper.selectDetailProjectVO(projectId);
        // 根据 status 确定 statusText
        Integer status = detailProjectVO.getStatus();
        switch (status) {
            case 0:
                detailProjectVO.setStatusText("审核中");
                break;
            case 1:
                detailProjectVO.setStatusText("众筹中");
                break;
            case 2:
                detailProjectVO.setStatusText("众筹成功");
                break;
            case 3:
                detailProjectVO.setStatusText("众筹失败");
                break;
            default:
                break;
        }

        // 3. 根据 deployDate 计算 lastDay
        // 格式: xxxx-xx-xx
        String deployDate = detailProjectVO.getDeployDate();

        // 获取当前日期
        Date currentDay = new Date();

        // 把众筹日期解析成 Date 类型
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date deployDay = format.parse(deployDate);

            // 获取当前日期的时间戳
            long currentTimeStamp = currentDay.getTime();

            // 获取众筹日期的时间戳
            long deployTimeStamp = deployDay.getTime();

            // 两个时间戳相减计算当前已经过去的时间
            long pastDays = (currentTimeStamp - deployTimeStamp) / 1000 / 60 / 60 / 24;

            // 获取总的众筹天数
            Integer totalDays = detailProjectVO.getDay();

            // 使用总的众筹天数减去已经过去的天数得到剩余天数
            Integer lastDay = (int) (totalDays - pastDays);
            detailProjectVO.setLastDay(lastDay);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return detailProjectVO;
    }
```



- 在 `ProjectHandler` 中调用 `Service` 方法拿到数据

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662208957489-7ed49363-95d9-4d8e-b4ca-ca60395a5e3e.png)

```java
    @RequestMapping("/get/project/detail/remote/{projectId}")
    ResultEntity<DetailProjectVO> getDetailProjectVORemote(@PathVariable("projectId") Integer projectId) {

        try {
            DetailProjectVO detailProjectVOById = projectService.getDetailProjectVO(projectId);
            return ResultEntity.successWithData(detailProjectVOById);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }

    }
```



#### 2.3.4 声明一个 Feign 的接口 【`api` 工程】

```java
    /**
     * 查询首页 > 项目详情页面数据
     *
     * @param projectId 项目 id
     * @return
     */
    @RequestMapping("/get/project/detail/remote/{projectId}")
    ResultEntity<DetailProjectVO> getDetailProjectVORemote(@PathVariable("projectId") Integer projectId);
```



#### 2.3.5 首页跳转到项目详情 `portal.html`【`auth` 工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662400497019-db5493ae-a5cf-4643-ab68-88ee4edec8ee.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662346354370-64276f32-c193-4edc-b81f-9bf1bf0baf03.png)

```html
<!DOCTYPE html>
<html lang="zh-CN" xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
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
        $(function () {
            $(".thumbnail img").css("cursor", "pointer");
            $(".thumbnail img").click(function () {
                window.location.href = "project.html";
            });
        })
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
                        <!--                        <li><a href="login.html">登录</a></li>-->
                        <!--                        <li><a href="reg.html">注册</a></li>-->
                        <li><a th:href="@{/auth/member/to/login/page}">登录</a></li>
                        <li><a th:href="@{/auth/member/to/reg/page}">注册</a></li>
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

    <div th:if="${#lists.isEmpty(portal_data)}">该分类下还没有任何的项目</div>
    <div th:unless="${#lists.isEmpty(portal_data)}">
        <div th:each="type : ${portal_data}" class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="box ui-draggable">
                        <div class="mHd" style="">
                            <div class="path">
                                <a href="projects.html">更多...</a>
                            </div>
                            <h3>
                                <label th:text="${type.name}">科技</label>
                                <small th:text="${type.remark}" style="color:#FFF;">开启智慧未来</small>
                            </h3>
                        </div>
                        <div class="mBd" style="padding-top:10px;">
                            <div class="row">
                                <div th:if="${#lists.isEmpty(type.portalProjectVO)}">该分类下还没有任何的项目</div>
                                <div th:unless="${#lists.isEmpty(type.portalProjectVO)}">
                                    <div th:each="project : ${type.portalProjectVO}" class="col-md-3">
                                        <div class="thumbnail">
                                            <img alt="300x200" th:src="${project.headerPicturePath}"
                                                 src="img/product-1.jpg"/>
                                            <div class="caption">
                                                <h3 class="break">
                                                    <!--                                                    <a th:href="@{${session.zuulPath}+'/portal/show/project/detail/'+${project.projectId}}"-->
                                                    <a th:href="@{{zuulPath}/project/get/project/detail/{projectId}(projectId=${project.projectId}, zuulPath=${session.zuulPath})}"
                                                       th:text="${project.projectName}">活性富氢净水直饮机</a>
                                                </h3>
                                                <p>
                                                <div style="float:left;">
                                                    <i class="glyphicon glyphicon-screenshot" title="目标金额"></i>
                                                    $<span th:text="${project.money}">20,000</span>
                                                </div>
                                                <div style="float:right;">
                                                    <i title="截至日期" class="glyphicon glyphicon-calendar"></i>
                                                    <span th:text="${project.deployDate}">2017-20-20</span>
                                                </div>
                                                </p>
                                                <br>
                                                <div class="progress" style="margin-bottom: 4px;">
                                                    <div class="progress-bar progress-bar-success" role="progressbar"
                                                         th:aria-valuenow="${project.percentage}" aria-valuemin="0"
                                                         aria-valuemax="100"
                                                         th:style="'width: ' + ${project.percentage} + '%'">
                                                        <span th:text="${project.percentage} + '%'">40%</span>
                                                    </div>
                                                </div>
                                                <div><span style="float:right;">
                                                    <i class="glyphicon glyphicon-star-empty"></i>
                                                </span>
                                                    <span>
                                                        <i class="glyphicon glyphicon-user" title="支持人数"></i>
                                                    <span th:text="${project.supporter}">12345</span>
                                                </span>
                                                </div>
                                            </div>
                                        </div>
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



#### 2.3.6 调用 `mysql` 暴露的接口拿到数据存入到模型 【`project` 工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662346333525-b2facdbf-382a-4cfc-ab43-fca139a5d46b.png)

```java
    /**
     * 首页 > 项目详情页面
     *
     * @param projectId
     * @return
     */
    @RequestMapping("/get/project/detail/{projectId}")
    public String getProjectDetail(@PathVariable("projectId") Integer projectId, Model model) {
        ResultEntity<DetailProjectVO> resultEntity = mySQLRemoteService.getDetailProjectVORemote(projectId);

        if(ResultEntity.SUCCESS.equals(resultEntity.getResult())) {
            DetailProjectVO detailProjectVO = resultEntity.getData();
            model.addAttribute("detailProjectVO", detailProjectVO);
        }

        return "project-show-detail";
    }
```



#### 2.3.7 新建 `project-show-detail.html` 中显示模型中的数据【`project` 工程】

```html
<!DOCTYPE html>
<html lang="zh-CN" xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <base th:href="@{/}"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/theme.css">
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="script/docs.min.js"></script>
    <script src="script/back-to-top.js"></script>
    <script>
        $(function () {
            $(".prjtip img").css("cursor", "pointer");
            $(".prjtip img").click(function () {
                window.location.href = 'project.html';
            });
        })
    </script>
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

        .nav-tabs > li.active > a, .nav-tabs > li.active > a:focus, .nav-tabs > li.active > a:hover {
            border-bottom-color: #ddd;
        }

        .nav-tabs > li > a {
            border-radius: 0;
        }
    </style>
</head>
<body>
<div class="navbar-wrapper">
    <div class="container">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#" style="font-size: 32px;">尚筹网-创意产品众筹平台</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse"
                     style="float: right;">
                    <ul class="nav navbar-nav">
                        <li class="dropdown"><a href="#" class="dropdown-toggle"
                                                data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i>
                            [[${session.loginMember.username}]]<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="member.html"><i class="glyphicon glyphicon-scale"></i> 会员中心</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-comment"></i>
                                    消息</a></li>
                                <li class="divider"></li>
                                <li><a th:href="@{/auth/member/logout}"><i
                                        class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>

<div class="container theme-showcase" role="main">

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="collapse navbar-collapse"
                         id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a rel="nofollow" href="index.html"><i
                                    class="glyphicon glyphicon-home"></i> 众筹首页</a></li>
                            <li><a rel="nofollow" href="projects.html"><i
                                    class="glyphicon glyphicon-th-large"></i> 众筹项目</a></li>
                            <li><a rel="nofollow" href="start.html"><i
                                    class="glyphicon glyphicon-edit"></i> 发起众筹</a></li>
                            <li><a rel="nofollow" href="minecrowdfunding.html"><i
                                    class="glyphicon glyphicon-user"></i> 我的众筹</a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>

    <div th:if="${#arrays.isEmpty(detailProjectVO)}">查询项目详情信息失败！</div>
    <div th:unless="${#arrays.isEmpty(detailProjectVO)}">
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="jumbotron nofollow" style="padding-top: 10px;">
                        <h3 th:text="${detailProjectVO.projectName}">酷驰触控龙头，智享厨房黑科技</h3>
                        <div style="float: left; width: 70%;" th:text="${detailProjectVO.projectDesc}">
                            智能时代，酷驰触控厨房龙头，让煮妇解放双手，触发更多烹饪灵感，让美味信手拈来。
                        </div>
                        <div style="float: right;">
                            <button type="button" class="btn btn-default">
                                <i style="color: #f60" class="glyphicon glyphicon-heart"></i>
                                关注[[${detailProjectVO.followerCount}]]
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="row clearfix">
                        <div class="col-md-8 column" th:if="${#lists.isEmpty(detailProjectVO.detailPicturePathList)}">
                            加载详情信息失败
                        </div>
                        <div class="col-md-8 column" th:unless="${#lists.isEmpty(detailProjectVO.detailPicturePathList)}">
                            <img alt="140x140" width="740" src="img/product_detail_head.jpg"
                                 th:src="${detailProjectVO.headerPicturePath}"/>
                            <img alt="140x140" width="740" src="img/product_detail_body.jpg"
                                 th:each="detailPicturePath : ${detailProjectVO.detailPicturePathList}"
                                 th:src="${detailPicturePath}"/>
                        </div>
                        <div class="col-md-4 column">
                            <div class="panel panel-default" style="border-radius: 0px;">
                                <div class="panel-heading"
                                     style="background-color: #fff; border-color: #fff;">
										<span class="label label-success"><i
                                                class="glyphicon glyphicon-tag"></i> [[${detailProjectVO.statusText}]]</span>
                                </div>
                                <div class="panel-body">
                                    <h3>已筹资金：￥[[${detailProjectVO.supportMoney}]]</h3>
                                    <p>
                                        <span>目标金额 ： [[${detailProjectVO.money}]]</span><span style="float: right;">达成
												： [[${detailProjectVO.percentage}]]%</span>
                                    </p>
                                    <div class="progress"
                                         style="height: 10px; margin-bottom: 5px;">
                                        <div class="progress-bar progress-bar-success"
                                             role="progressbar" aria-valuenow="[[${detailProjectVO.percentage}]]"
                                             aria-valuemin="0"
                                             aria-valuemax="100" style="width: 60%;"
                                             th:style="'width: '+${detailProjectVO.percentage}+'%;'"></div>
                                    </div>
                                    <p>剩余 [[${detailProjectVO.lastDay}]] 天</p>
                                    <div>
                                        <p>
                                            <span>已有[[${detailProjectVO.supporterCount}]]人支持该项目</span>
                                        </p>
                                        <button type="button"
                                                class="btn  btn-warning btn-lg btn-block"
                                                data-toggle="modal" data-target="#myModal">立即支持
                                        </button>
                                    </div>
                                </div>
                                <div class="panel-footer"
                                     style="background-color: #fff; border-top: 1px solid #ddd; border-bottom-right-radius: 0px; border-bottom-left-radius: 0px;">
                                    <div class="container-fluid">
                                        <div class="row clearfix">
                                            <div class="col-md-3 column" style="padding: 0;">
                                                <img alt="140x140" src="img/services-box2.jpg"
                                                     data-holder-rendered="true"
                                                     style="width: 80px; height: 80px;">
                                            </div>
                                            <div class="col-md-9 column">
                                                <div class="">
                                                    <h4>
                                                        <b>福建省南安厨卫</b> <span
                                                            style="float: right; font-size: 12px;"
                                                            class="label label-success">已认证</span>
                                                    </h4>
                                                    <p style="font-size: 12px">
                                                        酷驰是一家年轻的厨卫科技公司，我们有一支朝气蓬勃，有激情、有想法、敢实践的团队。</p>
                                                    <p style="font-size: 12px">客服电话:0595-86218855</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div th:if="${#lists.isEmpty(detailProjectVO.detailReturnVOList)}">没有加载到项目回报信息</div>
                            <div th:unless="${#lists.isEmpty(detailProjectVO.detailReturnVOList)}">
                                <div th:each="return : ${detailProjectVO.detailReturnVOList}"
                                     class="panel panel-default" style="border-radius: 0px;">
                                    <div class="panel-heading">
                                        <h3>
                                            ￥[[${return.supportMoney}]]
                                            <span th:if="${return.signalPurchase == 0}"
                                                  style="float: right; font-size: 12px;">无限额，447位支持者</span>
                                            <span th:if="${return.signalPurchase == 1}"
                                                  style="float: right; font-size: 12px;">限额[[${return.purchase}]]位，剩余1966位</span>
                                        </h3>
                                    </div>
                                    <div class="panel-body">
                                        <p th:if="${return.freight == 0}">配送费用：包邮</p>
                                        <p th:if="${return.freight > 0}">配送费用：[[${return.freight}]]</p>
                                        <p>预计发放时间：项目筹款成功后的[[${return.returnDate}]]天内</p>
                                        <a th:href="@{{zuulPath}/order/confirm/return/info/{projectId}/{returnId}(zuulPath=${session.zuulPath}, projectId=${detailProjectVO.projectId}, returnId=${return.returnId})}"
                                           class="btn btn-warning btn-lg">支持</a>
                                        <br>
                                        <br>
                                        <p th:text="${return.content}">
                                            感谢您的支持，在众筹开始后，您将以79元的优惠价格获得“遇见彩虹?”智能插座一件（参考价208元）。</p>
                                    </div>
                                </div>
                            </div>
                            <div class=" panel panel-default" style="border-radius: 0px;">
                                <div class="panel-heading">
                                    <h3>风险提示</h3>
                                </div>
                                <div class="panel-body">
                                    <p>
                                        1.众筹并非商品交易，存在一定风险。支持者根据自己的判断选择、支持众筹项目，与发起人共同实现梦想并获得发起人承诺的回报。<br>
                                        2.众筹平台仅提供平台网络空间及技术支持等中介服务，众筹仅存在于发起人和支持者之间，使用众筹平台产生的法律后果由发起人与支持者自行承担。<br>
                                        3.本项目必须在2017-06-09之前达到￥10000.00
                                        的目标才算成功，否则已经支持的订单将取消。订单取消或募集失败的，您支持的金额将原支付路径退回。<br>
                                        4.请在支持项目后15分钟内付款，否则您的支持请求会被自动关闭。<br>
                                        5.众筹成功后由发起人统一进行发货，售后服务由发起人统一提供；如果发生发起人无法发放回报、延迟发放回报、不提供回报后续服务等情况，您需要直接和发起人协商解决。<br>
                                        6.如您不同意上述风险提示内容，您有权选择不支持；一旦选择支持，视为您已确认并同意以上提示内容。
                                    </p>
                                </div>
                            </div>

                            <div>
                                <h2>为你推荐</h2>
                                <hr>
                            </div>
                            <div class="prjtip panel panel-default"
                                 style="border-radius: 0px;">
                                <div class="panel-body">
                                    <img src="img/product-3.png" width="100%" height="100%">
                                </div>
                            </div>

                            <div class="prjtip panel panel-default"
                                 style="border-radius: 0px;">
                                <div class="panel-body">
                                    <img src="img/product-4.jpg" width="100%" height="100%">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="container" style="margin-top: 20px;">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div id="footer">
                    <div class="footerNav">
                        <a rel="nofollow" href="http://www.atguigu.com">关于我们</a> | <a
                            rel="nofollow" href="http://www.atguigu.com">服务条款</a> | <a
                            rel="nofollow" href="http://www.atguigu.com">免责声明</a> | <a
                            rel="nofollow" href="http://www.atguigu.com">网站地图</a> | <a
                            rel="nofollow" href="http://www.atguigu.com">联系我们</a>
                    </div>
                    <div class="copyRight">Copyright ?2010-2014atguigu.com 版权所有
                    </div>
                </div>

            </div>
        </div>
    </div>

</div>
<!-- /container -->


<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel">
    <div class="modal-dialog " style="width: 960px; height: 400px;"
         role="document">
        <div class="modal-content" data-spy="scroll"
             data-target="#myScrollspy">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">选择支持项</h4>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row clearfix">
                        <div class="col-sm-3 col-md-3 column" id="myScrollspy">
                            <ul class="nav nav-tabs nav-stacked">
                                <li class="active"><a href="#section-1">￥1.00</a></li>
                                <li class="active"><a href="#section-2">￥149.00</a></li>
                                <li class="active"><a href="#section-3">￥249.00</a></li>
                                <li class="active"><a href="#section-4">￥549.00</a></li>
                                <li class="active"><a href="#section-5">￥1999.00</a></li>
                            </ul>
                        </div>
                        <div id="navList" class="col-sm-9 col-md-9 column"
                             style="height: 400px; overflow-y: auto;">
                            <h2 id="section-1" style="border-bottom: 1px dashed #ddd;">
                                <span style="font-size: 20px; font-weight: bold;">￥1.00</span><span
                                    style="font-size: 12px; margin-left: 60px;">无限额，223位支持者</span>
                            </h2>
                            <p>配送费用：全国包邮</p>
                            <p>预计发放时间：项目筹款成功后的30天内</p>
                            <button type="button" class="btn  btn-warning btn-lg "
                                    onclick="window.location.href='pay-step-1.html'">支持
                            </button>
                            <br>
                            <br>
                            <p>每满1750人抽取一台活性富氢净水直饮机，至少抽取一台。抽取名额（小数点后一位四舍五入）=参与人数÷1750人，由苏宁官方抽取。</p>
                            <hr>
                            <h2 id="section-2" style="border-bottom: 1px dashed #ddd;">
                                <span style="font-size: 20px; font-weight: bold;">￥149.00</span><span
                                    style="font-size: 12px; margin-left: 60px;">无限额，223位支持者</span>
                            </h2>
                            <p>配送费用：全国包邮</p>
                            <p>预计发放时间：项目筹款成功后的30天内</p>
                            <button type="button" class="btn  btn-warning btn-lg "
                                    onclick="window.location.href='pay-step-1.html'">支持
                            </button>
                            <br>
                            <br>
                            <p>每满1750人抽取一台活性富氢净水直饮机，至少抽取一台。抽取名额（小数点后一位四舍五入）=参与人数÷1750人，由苏宁官方抽取。</p>
                            <hr>
                            <h2 id="section-3" style="border-bottom: 1px dashed #ddd;">
                                <span style="font-size: 20px; font-weight: bold;">￥249.00</span><span
                                    style="font-size: 12px; margin-left: 60px;">无限额，223位支持者</span>
                            </h2>
                            <p>配送费用：全国包邮</p>
                            <p>预计发放时间：项目筹款成功后的30天内</p>
                            <button type="button" class="btn  btn-warning btn-lg "
                                    onclick="window.location.href='pay-step-1.html'">支持
                            </button>
                            <br>
                            <br>
                            <p>每满1750人抽取一台活性富氢净水直饮机，至少抽取一台。抽取名额（小数点后一位四舍五入）=参与人数÷1750人，由苏宁官方抽取。</p>
                            <hr>
                            <h2 id="section-4" style="border-bottom: 1px dashed #ddd;">
                                <span style="font-size: 20px; font-weight: bold;">￥549.00</span><span
                                    style="font-size: 12px; margin-left: 60px;">无限额，223位支持者</span>
                            </h2>
                            <p>配送费用：全国包邮</p>
                            <p>预计发放时间：项目筹款成功后的30天内</p>
                            <button type="button" class="btn  btn-warning btn-lg "
                                    onclick="window.location.href='pay-step-1.html'">支持
                            </button>
                            <br>
                            <br>
                            <p>每满1750人抽取一台活性富氢净水直饮机，至少抽取一台。抽取名额（小数点后一位四舍五入）=参与人数÷1750人，由苏宁官方抽取。</p>
                            <hr>
                            <h2 id="section-5" style="border-bottom: 1px dashed #ddd;">
                                <span style="font-size: 20px; font-weight: bold;">￥1999.00</span><span
                                    style="font-size: 12px; margin-left: 60px;">无限额，223位支持者</span>
                            </h2>
                            <p>配送费用：全国包邮</p>
                            <p>预计发放时间：项目筹款成功后的30天内</p>
                            <button type="button" class="btn  btn-warning btn-lg "
                                    onclick="window.location.href='pay-step-1.html'">支持
                            </button>
                            <br>
                            <br>
                            <p>每满1750人抽取一台活性富氢净水直饮机，至少抽取一台。抽取名额（小数点后一位四舍五入）=参与人数÷1750人，由苏宁官方抽取。</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>


</body>
</html>
```


# 二十二 前台-支付案例
```
git checkout -b 22.0.0_pay_demo
```

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1662449474458-a1c597b3-a9cd-4215-b264-5e89ebbfacc5.jpeg)

## 1. 支付宝开放平台

- 首页: https://open.alipay.com/
- 文档指引: https://opendocs.alipay.com/open/01bxlm



## 2. 电脑网站支付

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1662449638305-0ef9c0e4-1416-4358-886c-040c627dab29.jpeg)

### 2.1 总体步骤参考

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662442908428-8b1c84f5-0153-45a6-b66f-4e450a349321.png)



### 2.2 应用

- 开发工程中使用开发平台提供的沙箱环境进行调试, 沙箱环境中的应用已经创建好了, 不需要执行创建流程
- 功能开发完成, 项目上线时再创建应用

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662443523631-60789be5-53ec-4382-ac49-56f8f0c9c6e5.png)



### 2.3 加密

#### 2.3.1 对称加密

- 明文 -> 加密 -> 密文

    - 密文 -> 解密 -> 明文

- 如果知道密文可以反推明文



#### 2.3.2 非对称加密

密码学

- 公钥加密私钥解密/私钥加密公钥解密

    - 用公钥加密的不能用公钥在解密
    - 用私钥加密的也不能用私钥再解密

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662444328243-9d61a568-a1f8-49ea-9486-9face050f87e.png)

- 公钥生成的密文, 用私钥去解密



#### 2.3.3 调用支付宝接口时使用的秘钥

- 商户和支付宝都要提供公钥和私钥

    - 商户需要调用支付宝接口
    - 支付宝也需要调用商户接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662444764985-c75edd6c-739e-4749-a14d-82d0bcb6a535.png)

- 在支付宝开放平台的应用中设置商户公钥
- 在支付宝开放平台的应用中获取支付宝的公钥



- 在我们调用支付宝接口的程序中设置

    - 支付宝公钥
    - 商户的私钥



#### 2.3.4 生成秘钥工具

- https://opendocs.alipay.com/open/02nlga

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662445179524-2175d7b3-e462-4095-9de4-c1f036f6a914.png)

- 开发者可通过如下工具生成 **公、私钥对** 或 **CSR 文件**（用于申请证书）。

    - WINDOWS: https://ideservice.alipay.com/ide/getPluginUrl.htm?clientType=assistant&platform=win&channelType=WEB
    - MAC: https://ideservice.alipay.com/ide/getPluginUrl.htm?clientType=assistant&platform=mac&channelType=WEB



##### 2.3.5 生成商户秘钥

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662445501348-481d0e3a-8765-424c-bb26-97d4644ba15d.png)

- 私钥

```latex
MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDFEqMLulY2vw9PZX3XCdleB6ri6I6+0eTBQM5gqLafaibUdEc7LwyPaFBQD5ScsRcgDP13g4h/LeUMMwtkb/0wmiKs75piCxELxiT1erGvFLm2wZK7GtXHizjDyUWxtLOVOCWj7ZvoJt/gCTmKeCSaaAVdxLuXsolZVZfml7OifwribATsvLKSGeMcSp4KX32bdQkPnpkR0J9RBAS6Yw1/mYmCiEeFgX7lMfeKhwiAEWrKup6cibJLwZ7GX1WyDfmrWQ0Z5SwSBvdo3VGAqNqoPUwggM7d0uOdYRN179jAMcQtGApg+xCQY7IaKSjLd307ZH/0ofja+1dpZhpgaKG/AgMBAAECggEAR1w3RADmRQ6sCZDzn1FGr4DRRTb2sWwpjDzePiv5bQIwK1ArluezgZ5BLqxloNOTTxzFD2jGnV7OCLvXDThsExRNKBfe7E+bjYrjSSxzeLVlhiLT8gKGlKn6FRMltHJ9cLQTFSfuA4NIH8TXXCejAXJXNxwM3aJdj8apqWsXNehs90HCP8urTkSeLsUMiU8Iee/OgwTL6xdwUEh7xFS+eWnIGxhJeJPScq+XTKKevcRPVmPJopTwjhTv61cp3i/IkaXBmRizbfI9tOO6R1EqBvWGj6b0b3+tog15Go0nCv/GRsAU1shTF23cGIRkB5O2fZsAvNcCXQ8GnoSnqBnbUQKBgQD9nqWZMTnpPgGJHGlSiM/dErjB0tb8serdl2wceXkLCf9PJAg15x5HdZL8T+AdED+fC5UH82AH9mFUqDitcyRBCl5WinC2Sr/IEFLl6e8fO1fSp50zG3bqkiLZIN1gqlEFkWwfDy7L7d4LKbtUer7iW9inOyMvCfGhEOLVsDAjaQKBgQDG7CEFLgWbNlgD1cCHnxSbnYUjXB1Dz07HvJVvtFMrRGA//aUpRDuM48U7+UT245dbw5nKwsQp3/Ky0aqLO/M9DW8kC4qMH5ExBDspgOtGmDac8Jqj66cjpZ955zryzaVxOR+Iu7rsTEwo0UpzdDnOm2VUy1Gu7CHTdJ9K5NN+5wKBgQDdsXrhsRUFHE1tU+eA3NSOU5oq2ylQFBnQf1digJBdJO0GeeGvdIqUPmMwqIWoAhcK6K3qGES+URD9VlrMy1RKgky6ayNhRW/k6tf734RFkbMQEbIpBX3qR7msgLzijZ5rNpYDhFsMqa2ppl34157Z8R0t+VSk/pU3jLIrxmod2QKBgHhBGXkrKEJ7qNuwpfKXDftBT9JfhmWO9r4y2FguODUo4dLtgKIg2KtEquClwbZLQh48ckWsVrBF7U+DBsmjVVmsPGsa+wfYsYpjV2ywvgrwS9u2bJX6CRG4t18XlYBhJ8n50YF0k/zz5vqqA4smUSgAs1J+k4Pexlgx4XaCPQUzAoGBAI/NuQpFHXueJucmSww83cEF6zf79ikFbIK5OfHVkxWaYB/EcNZNRi1MFSl+uHP3tPTT/520VMkPnO4EinviWA23roSKHQIB6XlUiOeHOkKqpnA49ivI/Gj5PqRRXSfDcqMc6HCrMVQFmV61l1gZ8jdOpp4R3GcojiE53X3P7+b0
```

- 公钥

```plain
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxRKjC7pWNr8PT2V91wnZXgeq4uiOvtHkwUDOYKi2n2om1HRHOy8Mj2hQUA+UnLEXIAz9d4OIfy3lDDMLZG/9MJoirO+aYgsRC8Yk9XqxrxS5tsGSuxrVx4s4w8lFsbSzlTglo+2b6Cbf4Ak5ingkmmgFXcS7l7KJWVWX5pezon8K4mwE7LyykhnjHEqeCl99m3UJD56ZEdCfUQQEumMNf5mJgohHhYF+5TH3iocIgBFqyrqenImyS8Gexl9Vsg35q1kNGeUsEgb3aN1RgKjaqD1MIIDO3dLjnWETde/YwDHELRgKYPsQkGOyGikoy3d9O2R/9KH42vtXaWYaYGihvwIDAQAB
```



### 2.4 支付流程

- https://opendocs.alipay.com/open/270/105899

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662445860622-a16346bc-653a-4619-bd7f-9a366a50d180.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662445878102-9a80ebfb-7453-407c-ba1e-87e201fc07f6.png)



## 3. 内网穿透

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1662449637333-6f471537-585f-46b9-90e3-4c43f7bf4fad.jpeg)

### 3.1 上网的常规方式

- 在内网中访问外网

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662446432888-24ee4252-07f6-482d-bb5d-5aefeb7f1c34.png)



### 3.2 项目发布的常规方式

- 先在内网环境中完成开发, 在部署到位于外网的生成服务器上

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662446785204-8c5ff3ac-2f63-41ab-89df-e8c5191c6d08.png)



### 3.3 现在面临的特殊情况

- 我们现在在内网开发环境下, 需要让支付宝来调用内网中的项目
- 如果不用特殊的处理这种情况是访问不到内网的



### 3.4 内网穿透

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662447088258-42f22d42-4393-4d4d-9d65-24a1727cb981.png)



### 3.5 内网穿透工具 `natapp`

- https://natapp.cn/

#### 3.5.1 下载客户端工具

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662447678360-d303a2eb-ce0b-44cc-bd4d-d09f0d6f0d53.png)

- mac 64: [📎natapp_darwin_amd64_2_3_9.zip](https://www.yuque.com/attachments/yuque/0/2022/zip/12811585/1662447992127-8d532e1a-a7ea-478a-82fe-875f7ed3e3bc.zip)
- mac 判断64还是32: 终端: `uname -a`显示 `X86_**64**` 就是64



#### 3.5.2 注册购买隧道

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662447611040-8c7f48a1-3492-44ed-99f8-5ece5bf6607d.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662450198769-b4d531f8-44e5-447f-bd2f-869033d6722e.png)



#### 3.5.3 `Mac` 用户使用 `natapp`

- 解压得到 `natapp` 文件
- 配置文件 `config.ini`, 配置 `authtoken` -> 在我的渠道中

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662450305789-444a1db8-61d6-4e05-a112-fb6164600c35.png)

```shell
#将本文件放置于natapp同级目录 程序将读取 [default] 段
#在命令行参数模式如 natapp -authtoken=xxx 等相同参数将会覆盖掉此配置
#命令行参数 -config= 可以指定任意config.ini文件
[default]
authtoken=                      #对应一条隧道的authtoken
clienttoken=                    #对应客户端的clienttoken,将会忽略authtoken,若无请留空,
log=none                        #log 日志文件,可指定本地文件, none=不做记录,stdout=直接屏幕输出 ,默认为none
loglevel=ERROR                  #日志等级 DEBUG, INFO, WARNING, ERROR 默认为 DEBUG
http_proxy=                     #代理设置 如 http://10.123.10.10:3128 非代理上网用户请务必留空
```

此处为语雀加密文本卡片，点击链接查看：https://www.yuque.com/lingchen-bf1rc/hoahc6/lt8vyw#Kaaa1

- 在`Linux/Mac` 下 需要先给执行权限

```bash
chmod a+x natapp
```

- 然后再运行

```bash
./natapp
```



#### 3.5.4 测试

1. 安装 `nginx`

```bash
brew install ngixn
```



1. 修改 `nginx.conf`, 将端口改为 `80`

```bash
vi /usr/local/etc/nginx/nginx.conf
```



1. 重启 nginx

```bash
brew services restart nginx
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662450035067-01b88d46-7eb7-4cd8-8dcc-95388e877af6.png)



1. 启动 natapp

```bash
./natapp
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662450058435-1dd4cb01-063b-4459-9877-44ce9a22cc5c.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662450072123-e30158f1-3388-4e3b-b24b-00e855cb43f4.png)





## 4. 沙箱环境

### 4.1 进入沙箱环境

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662454969504-60be2a35-7b79-4a21-b373-fc579dd30835.png)



### 4.2 沙箱应用

- 启用公钥模式: 自动生成应用公钥/私钥和支付宝公钥

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662458519142-0840e618-bbf3-4a33-97e0-fc693f1299cb.png)

- 查看

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662467822180-3731f25a-5197-46a4-95eb-87ab6015515c.png)



### 4.3 沙箱测试 APP

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662471711403-aa5ab977-c315-4809-9fc9-1fa77c30b2ae.png)



## 5. 电脑网站支付 Demo

### 5.1 下载 Demo

- `Demo` 附件: [📎alipay.trade.page.pay-JAVA-UTF-8.zip](https://www.yuque.com/attachments/yuque/0/2022/zip/12811585/1662450537769-30d5c266-56ab-4ad9-aa85-90c9b5c9dd4d.zip)
- https://opendocs.alipay.com/open/270/106291

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662450489249-93d9f947-10ba-48ec-b5b3-49fa1ff4d569.png)



## 6. 使用 `Eclipse` 导入 `Demo`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662454632236-cdcfc73a-4f4d-4784-b442-11dc4cbfda8c.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662454610801-8b9e060a-013c-4139-a6e2-bc8cd9f35848.png)



## 7. 使用 `Idea` 打开支付案例 `Demo`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662474766428-4101e3ef-7176-4e2b-8dea-e50b01367037.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662474756975-144f7439-720f-4de4-bd14-3ef85576d887.png)

### 7.1 配置依赖 `command + ;`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662453269136-19a0a4b6-b89b-4d32-9a06-cfda6f35799e.png)

1. 去掉红色依赖
2. 添加依赖包

- 点击 `+` 号, 选择

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662453380538-812876f6-5ff2-4b03-a9e8-a015410315da.png)

- 加入依赖, 一个一个选择

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662469931753-3e02820b-e92b-4586-be5a-8313b8a107f9.png)\![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662469942955-2b647dfc-b65c-4176-9a00-f578990285f8.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662475321209-76fd20e1-044c-427a-82ea-a5fd8ad2e7d9.png)



### 7.2 配置 `Web` 和 `Tamcat Server`

1. 添加 `Web`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662470234078-d004f779-c85d-4b3f-886f-c78f3888d7b7.png)



1. 减去 Web.xml

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662470301375-680b2b0c-374f-4222-8d5a-9bc9070dba57.png)



1. 修改 `web` 目录

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662470323751-ea3ed674-ecd3-4161-ad60-1405cf4efb80.png)



1. 点击 `Create Artifact`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662470347334-3c685cd1-c9b8-4b84-892f-f1f5abf83da6.png)



1. 右键添加

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662470399143-a35eb462-2811-4a46-adc2-eb7ca3774778.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662470443570-c66a2994-6391-4c1a-ae66-81afd560e6ac.png)

- 记得点击 `Apply`

1. 打开运行配置

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662470484680-0d2eaa47-7657-4d1a-bda2-637d8bd0ffbd.png)



1. 添加 `Tomcat Server`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662470738432-319a8d4b-55e3-4be7-8b7c-f92bb8d506e6.png)



1. 将 `Artifact` 添加进入

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662470609797-1e26eb7b-74e9-476b-840e-65e8b8c81043.png)



### 7.3 修改配置文件

- 将文件格式改为 `GBK` 再改为 `UTF-8`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662453146503-32e333bc-c062-4533-a948-179021144b72.png)

```java
package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    // 使用沙箱环境的 APPID
    public static String app_id = "2016100100642012";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCSW8OKd+By+Ea7UP9yCbWtlhvr7QvgAfiG9joMwbZ+Zma2/YMOWaAPD6NowrnaNaNd9gWZB/qJ1oe5QAXUi4bi/J1n+1+T1giRSaFtpkfDeRBvKmTiSyYCeGk7aeT0FWODWQB7ZnPD9R6KCeJCVhzN2YmurNFHftiM1fFcRHUNb5Daw0m7xKrOebQwMIk7K3at5a/Yd5nMUcOqoUOKTXMjxXSW6CnFXMCirPhg/e5aAMD+GiOUOIKx/DTtnZjVBv5UF0MJ7Xg1/wtrkHi4k3ZPLwJdMjv4UOH9377BbGFkyc0/0PJPhG69TqyyOInUCDNDyhzaYpH423GhlJy4uywrAgMBAAECggEAenw/jp+6gJ1VnKgxz/9eQ3Lv1SdiG8uqcVCZzllD4E7UwWoyhwzszg35ZNAqd/sRyK3/i03JGBgpKBjziCho74gYN5CBMZkbPHQRnFFfl7C210H0ggoAOmsJLob17GwGB0OyCpP4aFO4hi+1Ymzs2D2pYz0QPDRlCKB3yQ8louKjlykGSWwo58zwm935BHvv//JijHGbMbqDJGMfj/ogjhDP0txE7ZBiO9sEc1RjZ5Csg/81H8XSXCGyMowTX+I2M2ys59HMiuZFLM3pG5/UfOkqGKEJcv/ymsKILgL5h2XvLIFbgUqG4WMmHAX+moApnqmnkOtvSnE1u9hnBIkE+QKBgQDuerisalgfDlJ4wn3A7yQyX4cbT3ozLmqo/FZrlrd/ZJ/HgFrGBiEjaSxWRUxVUBGOgyQszOCzvhPySJjW6Y+xcai1MpC0z9fnvbpFM5GVVKUDIIA//O8+Ukd7wZyW20jebeFNk9I/kTAHs751wSJ8x60OET34r+ESk6aV+9xMDQKBgQCdHHK2XKgbUb+LtM0BUDq4KzPWW3/XYMrKpazDjwB+z2XWJSzch4nXyEa/8QAnUI3Atyn0fK1BmfyvFFtHpQtUpMUKtsswz9+RLwFrFrMspl3POlQEaU32fzl/RL7mybZyt71Mqcgq41DAtrVcyXWhgU1x6XrHcCxwZ0LROsDzFwKBgEolLbWteqhtM4cIMUEDGSXwPXloRH4VOGRB0DyzJ2ocRvEoHxDiZvszf+1yrkD4G/1LGLw1FsfLmTgDCkIHa/2ncOSlTAhrdp0+h+NsHR9oqcVHHZjHczrVKhR4Jc9hbk55q0sLYpsQ8PX0FItX+PkCu/NbuQDQ7hFwhqKrI9shAoGADU9LqIdQ9n+Gap92fpX9Y3zFd3No8SYSB/jhGfATaqrHRc0Ab+5Ljyw4UipoiOwaFiluNHgbdWNGNM7UrM0emJ0c1DuIGyqBFhuVUy0pIK83Y0bdt0H0iN1eUZnRUlvkSPOn5ca8XmXDgY/47VNj07rQhMXy0NJ/8UXOM0t27SECgYEAxERMjSKIjJ4VRcVcroBzdXZ2O3Pj9r1BLkyY8qKmptYvA+yinVWvvVzwjoHqLoqEkVZMq2ixrLYt7sl3esfGyUIdxjXUI1cbvCOpbDe7f0kJxvXyldC5Lrtama5gdJE36JFGbWrf2PRg4in1sizMjyY8G/SDMS0MNKpzos4pASQ=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoauF73gbBsJVQkFK/gmmVOWzYevEJZyPozl9L/49MvZKgo9oVOniBIJZq3+/ve6UZUKxLhKGFekP7mCsqMP3J+dr/a12gcVeBX8mu8J6ArwJnQ+pNsbZl9/dlpaob7qEGPd4gCZyr4J31ejpHrFJZBrUeHMtp3bo41YlMa7EKq4eoI8o8nm8yLFedtmtE5/LlY1uj3W0n6ZTGMjGfAOBQSICeoEJZPH+9u/NkLC/2FhRNNMwEAyp0xYQ3AjlX93GFL5F/1nc56oXDzpcIVzBXW+RP8Of1ISwFiXw6qF/P+zXLUNFmjDh03bJrdHoYuvS/Xygs53gwLYFIF+Qdo1KBwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 工程公网访问地址首页内网穿透客户端提供的域名
    public static String notify_url = "http://xsxpge.natappfree.cc/alipay_trade_page_pay_JAVA_UTF_8_Web_exploded//notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 工程公网访问地址首页内网穿透客户端提供的域名
    public static String return_url = "http://xsxpge.natappfree.cc/alipay_trade_page_pay_JAVA_UTF_8_Web_exploded//return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关（正式环境）
    /// public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

    // 支付宝网关（沙箱环境）
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 日志路径（win）
    // public static String log_path = "C:\\";

    // 日志路径（mac）
    public static String log_path = "/Users/chenjianglin/Desktop/";

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```



### 7.4 启动 `Tomcat`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662470792565-1bcf0af3-aa68-4aaa-a3a8-91d06181a5f6.png)



### 7.5 测试

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662475072176-b48c558d-30de-4783-8624-6e1aa38a5135.png)

- 点击付款

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662475191740-b3c1aafc-f482-4832-9f2e-1c889e776eeb.png)

- 扫码付款

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662475244057-c8bedc91-7ad7-4531-986c-3f06c8b1ba7f.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662475250302-1617b55a-5102-412d-a0b3-efd065ae10e0.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662475256993-041d2b26-8f41-42e0-814f-763be06c3ea2.png)



# 二十三 前台-订单

```
git checkout -b 23.0.0_order
```

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1662716619135-86e08dfc-6ffa-490a-a766-ca4864b3cfc8.jpeg)

## 1. 搭建 `order` 开发环境

### 1.1 追加代码 `pom.xml`

```xml
    <dependencies>
        <dependency>
            <groupId>com.atguigu.crowd</groupId>
            <artifactId>atcrowdfunding17-member-api</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <!-- 导入配置文件处理器, 配置文件进行绑定 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
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
        <!-- SpringBoot 测试 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
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



### 1.2 新建 `application.yml` 配置文件

```yaml
server:
  port: 6000

spring:
  application:
    name: atguigu-crowd-order
  session:
    store-type: redis

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



### 1.3 新建 `CrowdMainClass` 主启动类

```java
package com.atguigu.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 陈江林
 * @date 2022/9/7 17:13
 */
@EnableFeignClients
@SpringBootApplication
public class CrowdMainClass {

    public static void main(String[] args) {
        SpringApplication.run(CrowdMainClass.class, args);
    }

}
```



## 2. 配置 `zuul`

### 2.1 追加路由规则 `application.yml`

```yaml
zuul:
	routes:
  	crowd-order:
    	service-id: atguigu-crowd-order
    	path: /order/**
```



## 3. 建模

### 3.1 结构

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662543066363-188b6583-7953-4033-80eb-a03843aa127b.png)

-  不加外键



### 3.2 物理建模

```plsql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address_id` varchar(255) DEFAULT NULL COMMENT '收货地址表主键',
  `order_name` varchar(255) DEFAULT NULL COMMENT '订单号',
  `pay_order_num` varchar(255) DEFAULT NULL COMMENT '支付宝流水单号',
  `order_amount` double(10, 5) DEFAULT NULL COMMENT '订单金额',
  `invoice` varchar(255) DEFAULT NULL COMMENT '是否开发票 [{0: 不开发票}, {1: 开发票}]',
  `invoice_title` varchar(255) DEFAULT NULL COMMENT '发票抬头',
  `order_remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of t_order
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_address
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `receive_name` varchar(255) DEFAULT NULL COMMENT '收件人',
  `phone_num` varchar(255) DEFAULT NULL COMMENT '手机号',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `member_id` varchar(255) DEFAULT NULL COMMENT '会员表主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收货地址表';

-- ----------------------------
-- Records of t_address
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_order_project
-- ----------------------------
DROP TABLE IF EXISTS `t_order_project`;
CREATE TABLE `t_order_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `launch_name` varchar(255) DEFAULT NULL COMMENT '发起人',
  `return_content` varchar(255) DEFAULT NULL COMMENT '回报内容',
  `return_count` int(11) DEFAULT NULL COMMENT '回报数量',
  `support_price` int(11) DEFAULT NULL COMMENT '支持单价',
  `freight` int(11) DEFAULT NULL COMMENT '配送费用',
  `order_id` varchar(255) DEFAULT NULL COMMENT '订单表主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目信息表';

-- ----------------------------
-- Records of t_order_project
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
```



#### 3.2.1 订单表

```plsql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address_id` varchar(255) DEFAULT NULL COMMENT '收货地址表主键',
  `order_name` varchar(255) DEFAULT NULL COMMENT '订单号',
  `pay_order_num` varchar(255) DEFAULT NULL COMMENT '支付宝流水单号',
  `order_amount` double(10, 5) DEFAULT NULL COMMENT '订单金额',
  `invoice` varchar(255) DEFAULT NULL COMMENT '是否开发票 [{0: 不开发票}, {1: 开发票}]',
  `invoice_title` varchar(255) DEFAULT NULL COMMENT '发票抬头',
  `order_remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of t_order
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
```



#### 3.2.2 收货地址表

```plsql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_address
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `receive_name` varchar(255) DEFAULT NULL COMMENT '收件人',
  `phone_num` varchar(255) DEFAULT NULL COMMENT '手机号',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `member_id` varchar(255) DEFAULT NULL COMMENT '会员表主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收货地址表';

-- ----------------------------
-- Records of t_address
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
```



#### 3.2.3 项目信息表

```plsql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_order_project
-- ----------------------------
DROP TABLE IF EXISTS `t_order_project`;
CREATE TABLE `t_order_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `launch_name` varchar(255) DEFAULT NULL COMMENT '发起人',
  `return_content` varchar(255) DEFAULT NULL COMMENT '回报内容',
  `return_count` int(11) DEFAULT NULL COMMENT '回报数量',
  `support_price` int(11) DEFAULT NULL COMMENT '支持单价',
  `freight` int(11) DEFAULT NULL COMMENT '配送费用',
  `order_id` varchar(255) DEFAULT NULL COMMENT '订单表主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目信息表';

-- ----------------------------
-- Records of t_order_project
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
```



## 4. 生成实体类, 逆向工程【reverse】工程

### 4.1 追加配置

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662547661391-94d7cc3f-cc5b-48d2-b2ec-b2d4f7b419f1.png)

```xml
<table tableName="t_order" domainObjectName="OrderPO"/>
<table tableName="t_address" domainObjectName="AddressPO"/>
<table tableName="t_order_project" domainObjectName="OrderProjectPO"/>
```



### 4.2 将生成的文件移动到对应的位置

- 实体类记得加注解

```java
@NoArgsConstructor
@AllArgsConstructor
@Data
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662547628215-176ca0cc-f3d7-4757-8c1a-2853f9a6e613.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662547639422-494b0ad3-79ab-4b11-a498-15fde8a2f1da.png)



## 5. 目标1: 确认回报内容

### 5.1 思路

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662548296095-35379c7b-4f67-49b5-bbce-da689cc1e92a.png)



### 5.2 操作起点

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662548805196-18dc8521-1d13-477c-a7c5-f8e2804135e0.png)

- 关键代码

```html
<a th:href="@{{zuulPath}/order/confirm/return/info/{returnId}(zuulPath=${session.zuulPath}, returnId=${return.returnId})}"
                                           class="btn btn-warning btn-lg">支持</a>
```



### 5.3 新建 `OrderProjectVO`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662550297381-3e7f04fd-e86c-41a3-a803-eb1676a05f70.png)

```java
package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 陈江林
 * @date 2022/9/7 19:09
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderProjectVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 发起人
     */
    private String launchName;

    /**
     * 回报内容
     */
    private String returnContent;

    /**
     * 回报数量
     */
    private Integer returnCount;

    /**
     * 支持单价
     */
    private Integer supportPrice;

    /**
     * 配送费用
     */
    private Integer freight;

    /**
     * 订单表主键
     */
    private String orderId;

    /**
     * 是否设置单笔限购
     */
    private Integer signalPurchase;

    /**
     * 具体限购数量
     */
    private Integer purchase;

}
```



### 5.4 新建 `OderHandler`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662550385549-c5cab60c-31bc-4b67-a64b-345335402bd5.png)

```java
package com.atguigu.crowd.handler;

import com.atguigu.crowd.api.MySQLRemoteService;
import com.atguigu.crowd.entity.vo.OrderProjectVO;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author 陈江林
 * @date 2022/9/7 19:32
 */
@Controller
public class OderHandler {

    @Autowired
    private MySQLRemoteService mySQLRemoteService;

    /**
     * 首页 -> 项目详情（点击支持） -> 显示回报确认信息
     *
     * @param returnId 
     * @param session  
     * @return {@link String}
     */
    @RequestMapping("/confirm/return/info/{returnId}")
    public String showReturnConfirmInfo(@PathVariable("returnId") Integer returnId,
                                        HttpSession session) {
        // 查询数据
        ResultEntity<OrderProjectVO> resultEntity = mySQLRemoteService.getOrderProjectVORemote(returnId);

        // 判断查询结果
        if (ResultEntity.SUCCESS.equals(resultEntity.getResult())) {
            OrderProjectVO orderProjectVO = resultEntity.getData();

            // 为了能够在后续操作中保存 orderProjectVO 数据, 存入 Session 域中
            session.setAttribute("orderProjectVO", orderProjectVO);
        }

        return "confirm_return";
    }

}
```



### 5.5 追加接口 【`api` 工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662551959570-982a8924-388f-40d0-9ad9-2ee5bfb5515b.png)

```java
    /**
     * 获取订单项目
     *
     * @param returnId 回报id
     * @return {@link ResultEntity}<{@link OrderProjectVO}>
     */
    @RequestMapping("/get/order/project/vo/remote/{returnId}")
    ResultEntity<OrderProjectVO> getOrderProjectVORemote(@PathVariable("returnId") Integer returnId);
```



### 5.6 完成接口【`mysql` 工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662553043452-43062c10-507c-467b-a42a-8b89c887e654.png)

- 新建 `OrderProviderHandler`

```java
package com.atguigu.crowd.handler;

import com.atguigu.crowd.entity.vo.OrderProjectVO;
import com.atguigu.crowd.service.api.OrderService;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈江林
 * @date 2022/9/7 20:15
 */
@RestController
public class OrderProviderHandler {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/get/order/project/vo/remote/{returnId}")
    ResultEntity<OrderProjectVO> getOrderProjectVORemote(@PathVariable("returnId") Integer returnId) {
        try {
            OrderProjectVO orderProjectVO = orderService.getOrderProjectVO(returnId);
            return ResultEntity.successWithData(orderProjectVO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

}
```



- 新建 `OrderService`

```java
package com.atguigu.crowd.service.api;

import com.atguigu.crowd.entity.vo.OrderProjectVO;
import com.atguigu.crowd.util.ResultEntity;

/**
 * @author 陈江林
 * @date 2022/9/7 20:16
 */
public interface OrderService {

    /**
     * 获取订单项目视图对象
     *
     * @param returnId  回报id
     * @return {@link ResultEntity}<{@link OrderProjectVO}>
     */
    OrderProjectVO getOrderProjectVO(Integer returnId);

}
```



- 新建 `OrderServiceImpl`

```java
package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.entity.vo.OrderProjectVO;
import com.atguigu.crowd.mapper.AddressPOMapper;
import com.atguigu.crowd.mapper.OrderPOMapper;
import com.atguigu.crowd.mapper.OrderProjectPOMapper;
import com.atguigu.crowd.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 陈江林
 * @date 2022/9/7 20:17
 */
@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderProjectPOMapper orderProjectPOMapper;

    @Autowired
    private OrderPOMapper orderPOMapper;

    @Autowired
    private AddressPOMapper addressPOMapper;

    @Override
    public OrderProjectVO getOrderProjectVO(Integer returnId) {
        return orderProjectPOMapper.selectOrderProjectVO(returnId);
    }

}
```



- 追加

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662555210086-192721d6-1c1d-44d1-9428-3820736cd5d6.png)

```java
    /**
     * 查询订单项目视图对象
     *
     * @param returnId 回报id
     * @return {@link OrderProjectVO}
     */
    OrderProjectVO selectOrderProjectVO(Integer returnId);
```

- 追加

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662555252602-de1f0e6a-646b-4cd5-800e-6c5cbefe1d26.png)

```xml
  <select id="selectOrderProjectVO" resultType="com.atguigu.crowd.entity.vo.OrderProjectVO">
    select distinct project_name          projectName,
                    content               returnContent,
                    description_simple    launchName,
                    t_return.supportmoney supportPrice,
                    freight,
                    count                 returnCount,
                    signalpurchase        signalPurchase,
                    purchase
    from t_return
           left join t_project on t_return.projectid = t_project.id
           left join t_member_launch_info on t_project.memberid = t_member_launch_info.memberid
    where t_return.id = #{returnId}
  </select>
```



### 5.7 页面显示

#### 5.7.1 新建 `confirm_return.html`

```html
<!DOCTYPE html>
<html lang="zh-CN" xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <base th:href="@{/}"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/theme.css">
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="script/docs.min.js"></script>
    <script src="script/back-to-top.js"></script>
    <script type="text/javascript">
        var signalPurchase = [[${session.orderProjectVO.signalPurchase}]];
        var purchase = [[${session.orderProjectVO.purchase}]];

        $(function () {
            $('#myTab a').click(function (e) {
                e.preventDefault()
                $(this).tab('show')
            });

            $("#returnCountInput").change(function () {
                var returnCount = $.trim($(this).val());

                if (returnCount == null || returnCount == "") {
                    alert("请输入有效数据！");

                    $(this).val(this.defaultValue);

                    return;
                }

                if (signalPurchase == 1 && returnCount > purchase) {
                    alert("不能超过限购数量！");
                    return;
                }

                var supportPrice = [[${session.orderProjectVO.supportPrice}]];

                $("#totalAmount").text("￥" + (supportPrice * returnCount));
            });

            $("#submitBtn").click(function () {
                var returnCount = $("#returnCountInput").val();
                window.location.href = "order/confirm/order/" + returnCount;
            });
        })
    </script>
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

        .label-type, .label-status, .label-order {
            background-color: #fff;
            color: #f60;
            padding: 5px;
            border: 1px #f60 solid;
        }

        #typeList :not (:first-child ) {
            margin-top: 20px;
        }

        .label-txt {
            margin: 10px 10px;
            border: 1px solid #ddd;
            padding: 4px;
            font-size: 14px;
        }

        .panel {
            border-radius: 0;
        }

        .progress-bar-default {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<div class="navbar-wrapper">
    <div class="container">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.html" style="font-size: 32px;">尚筹网-创意产品众筹平台</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse"
                     style="float: right;">
                    <ul class="nav navbar-nav">
                        <li class="dropdown"><a href="#" class="dropdown-toggle"
                                                data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i>
                            [[${session.loginMember.username}]]<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="member.html"><i
                                        class="glyphicon glyphicon-scale"></i> 会员中心</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-comment"></i>
                                    消息</a></li>
                                <li class="divider"></li>
                                <li><a th:href="@{/auth/member/logout}"><i
                                        class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>

<div class="container theme-showcase" role="main">

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="panel panel-default">
                    <div class="panel-heading" style="text-align: center;">
                        <div class="container-fluid">
                            <div class="row clearfix">
                                <div class="col-md-3 column">
                                    <div class="progress"
                                         style="height: 50px; border-radius: 0; position: absolute; width: 75%; right: 49px;">
                                        <div class="progress-bar progress-bar-success"
                                             role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                             aria-valuemax="100" style="width: 100%; height: 50px;">
                                            <div style="font-size: 16px; margin-top: 15px;">1.
                                                确认回报内容
                                            </div>
                                        </div>
                                    </div>
                                    <div
                                            style="right: 0; border: 10px solid #ddd; border-left-color: #88b7d5; border-width: 25px; position: absolute; border-left-color: rgba(92, 184, 92, 1); border-top-color: rgba(92, 184, 92, 0); border-bottom-color: rgba(92, 184, 92, 0); border-right-color: rgba(92, 184, 92, 0);">
                                    </div>
                                </div>
                                <div class="col-md-3 column">
                                    <div class="progress"
                                         style="height: 50px; border-radius: 0; position: absolute; width: 75%; right: 49px;">
                                        <div class="progress-bar progress-bar-default"
                                             role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                             aria-valuemax="100" style="width: 100%; height: 50px;">
                                            <div style="font-size: 16px; margin-top: 15px;">2.
                                                确认订单
                                            </div>
                                        </div>
                                    </div>
                                    <div
                                            style="right: 0; border: 10px solid #ddd; border-left-color: #88b7d5; border-width: 25px; position: absolute; border-left-color: rgba(221, 221, 221, 1); border-top-color: rgba(221, 221, 221, 0); border-bottom-color: rgba(221, 221, 221, 0); border-right-color: rgba(221, 221, 221, 0);">
                                    </div>
                                </div>
                                <div class="col-md-3 column">
                                    <div class="progress"
                                         style="height: 50px; border-radius: 0; position: absolute; width: 75%; right: 49px;">
                                        <div class="progress-bar progress-bar-default"
                                             role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                             aria-valuemax="100" style="width: 100%; height: 50px;">
                                            <div style="font-size: 16px; margin-top: 15px;">3. 付款</div>
                                        </div>
                                    </div>
                                    <div
                                            style="right: 0; border: 10px solid #ddd; border-left-color: #88b7d5; border-width: 25px; position: absolute; border-left-color: rgba(221, 221, 221, 1); border-top-color: rgba(221, 221, 221, 0); border-bottom-color: rgba(221, 221, 221, 0); border-right-color: rgba(221, 221, 221, 0);">
                                    </div>
                                </div>
                                <div class="col-md-3 column">
                                    <div class="progress" style="height: 50px; border-radius: 0;">
                                        <div class="progress-bar progress-bar-default"
                                             role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                             aria-valuemax="100" style="width: 100%; height: 50px;">
                                            <div style="font-size: 16px; margin-top: 15px;">4. 完成</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div class="container-fluid">
                            <div class="row clearfix">
                                <div class="col-md-12 column">
                                    <blockquote
                                            style="border-left: 5px solid #f60; color: #f60; padding: 0 0 0 20px;">
                                        <b> 请确认您所选择的回报项信息和购买数量 </b>
                                    </blockquote>
                                </div>
                                <div class="col-md-12 column">
                                    <table class="table table-bordered"
                                           style="text-align: center;">
                                        <thead>
                                        <tr style="background-color: #ddd;">
                                            <td>项目名称</td>
                                            <td>发起人</td>
                                            <td width="300">回报内容</td>
                                            <td width="80">回报数量</td>
                                            <td>支持单价</td>
                                            <td>配送费用</td>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td th:text="${session.orderProjectVO.projectName}">活性富氢净水直饮机</td>
                                            <td th:text="${session.orderProjectVO.launchName}">深圳市博实永道电子商务有限公司</td>
                                            <td th:text="${session.orderProjectVO.returnContent}">
                                                每满1750人抽取一台活性富氢净水直饮机，至少抽取一台。抽取名额（小数点后一位四舍五入）=参与人数÷1750人，由苏宁官方抽取。
                                            </td>
                                            <td><input id="returnCountInput" type="text" class="form-control"
                                                       style="width: 60px;"
                                                       th:value="${session.orderProjectVO.returnCount}"></td>
                                            <td style="color: #F60" th:text="${session.orderProjectVO.supportPrice}">￥
                                                1.00
                                            </td>
                                            <td th:if="${session.orderProjectVO.freight == 0}">免运费</td>
                                            <td th:if="${session.orderProjectVO.freight != 0}"
                                                th:text="${session.orderProjectVO.freight}">免运费
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <div style="float: right;">
                                        <p>
                                            总价(含运费)：<span id="totalAmount" style="font-size: 16px; color: #F60;">￥[[${session.orderProjectVO.returnCount * session.orderProjectVO.supportPrice}]]</span>
                                        </p>
                                        <button id="submitBtn" type="button" class="btn btn-warning btn-lg"
                                                style="float: right;">
                                            <i class="glyphicon glyphicon-credit-card"></i> 去结算
                                        </button>
                                    </div>
                                </div>

                                <div class="container">
                                    <div class="row clearfix">
                                        <div class="col-md-12 column">
                                            <blockquote>
                                                <p>
                                                    <i class="glyphicon glyphicon-info-sign"
                                                       style="color: #2a6496;"></i> 提示
                                                </p>
                                                <br> <span style="font-size: 12px;">1.众筹并非商品交易，存在一定风险。支持者根据自己的判断选择、支持众筹项目，与发起人共同实现梦想并获得发起人承诺的回报。<br>
														2.众筹平台仅提供平台网络空间及技术支持等中介服务，众筹仅存在于发起人和支持者之间，使用众筹平台产生的法律后果由发起人与支持者自行承担。<br>
														3.本项目必须在2017-06-04之前达到 ￥1000000.00
														的目标才算成功，否则已经支持的订单将取消。订单取消或募集失败的，您支持的金额将原支付路径退回。<br>
														4.请在支持项目后15分钟内付款，否则您的支持请求会被自动关闭。<br>
														5.众筹成功后由发起人统一进行发货，售后服务由发起人统一提供；如果发生发起人无法发放回报、延迟发放回报、不提供回报后续服务等情况，您需要直接和发起人协商解决。<br>
														6.如您不同意上述风险提示内容，您有权选择不支持；一旦选择支持，视为您已确认并同意以上提示内容。
													</span>
                                            </blockquote>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="container" style="margin-top: 20px;">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div id="footer">
                    <div class="footerNav">
                        <a rel="nofollow" href="http://www.atguigu.com">关于我们</a> | <a
                            rel="nofollow" href="http://www.atguigu.com">服务条款</a> | <a
                            rel="nofollow" href="http://www.atguigu.com">免责声明</a> | <a
                            rel="nofollow" href="http://www.atguigu.com">网站地图</a> | <a
                            rel="nofollow" href="http://www.atguigu.com">联系我们</a>
                    </div>
                    <div class="copyRight">Copyright ?2010-2014atguigu.com 版权所有
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<!-- /container -->

</body>
</html>
```



## 6. 目标2: 确认订单

### 6.1 思路

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662561009155-9bd03ed2-f0ea-455d-a066-8513ae91741c.png)



### 6.2 新建 `AddressVO`【`entity` 工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662561152423-6cf43cbc-cf4d-40b3-8dc3-a6b9698506f1.png)

```java
package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 陈江林
 * @date 2022/9/7 22:30
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 收件人
     */
    private String receiveName;

    /**
     * 手机号
     */
    private String phoneNum;

    /**
     * 地址
     */
    private String address;

    /**
     * 会员表主键
     */
    private String memberId;

}
```



### 6.3 追加代码, Session 域合并回报数量【`order` 工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662561216453-e3af2e6d-4d60-4a1b-9166-d46084db65f5.png)

```java
    /**
     * 首页 -> 项目详情（点击支持） -> 显示回报确认信息 -> 显示返回确认信息
     *
     * @param returnCount 回报数量
     * @param session
     * @return {@link String}
     */
    @RequestMapping("/confirm/order/{returnCount}")
    public String showReturnOrderInfo(@PathVariable("returnCount") Integer returnCount,
                                      HttpSession session) {
        // 1. 把接收到的回报数量合并到 Session 域
        OrderProjectVO orderProjectVO = (OrderProjectVO) session.getAttribute("orderProjectVO");
        orderProjectVO.setReturnCount(returnCount);
        session.setAttribute("orderProjectVO", orderProjectVO);

        // 2. 获取当前已登录用户的 id
        MemberLoginVO memberLoginVO = (MemberLoginVO) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER);
        Integer memberId = memberLoginVO.getId();

        // /3.查询目前的收货地址数据
        ResultEntity<List<AddressVO>> resultEntity = mySQLRemoteService.getAddressVOListRemote(memberId);
        if (ResultEntity.SUCCESS.equals(resultEntity.getResult())) {
            List<AddressVO> addressVOList = resultEntity.getData();
            session.setAttribute("addressVOList", addressVOList);
        }

        return "confirm_order";
    }
```



### 6.4 新建 confirm_order.html

```html
<!DOCTYPE html>
<html lang="zh-CN" xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <base th:href="@{/}"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/theme.css">
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="script/docs.min.js"></script>
    <script src="script/back-to-top.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#payButton").click(function () {
                // 1.收集所有要提交的表单项的数据
                var addressId = $("[name=addressId]:checked").val();
                var invoice = $("[name=invoiceRadio]:checked").val();
                var invoiceTitle = $.trim($("[name=invoiceTitle]").val());
                var remark = $.trim($("[name=remark]").val());

                // 2.将上面收集到的表单数据填充到空表单中并提交
                $("#summaryForm")
                    .append("<input type='hidden' name='addressId' value='" + addressId + "'/>")
                    .append("<input type='hidden' name='invoice' value='" + invoice + "'/>")
                    .append("<input type='hidden' name='invoiceTitle' value='" + invoiceTitle + "'/>")
                    .append("<input type='hidden' name='orderRemark' value='" + remark + "'/>")
                    .submit();
            });

            $("#knowRoleCheckBox").click(function () {
                var currentStatus = this.checked;
                if (currentStatus) {
                    $("#payButton").prop("disabled", "");
                } else {
                    $("#payButton").prop("disabled", "disabled");
                }
            });

            $('#myTab a').click(function (e) {
                e.preventDefault()
                $(this).tab('show')
            })
        })
    </script>
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

        .label-type, .label-status, .label-order {
            background-color: #fff;
            color: #f60;
            padding: 5px;
            border: 1px #f60 solid;
        }

        #typeList :not (:first-child ) {
            margin-top: 20px;
        }

        .label-txt {
            margin: 10px 10px;
            border: 1px solid #ddd;
            padding: 4px;
            font-size: 14px;
        }

        .panel {
            border-radius: 0;
        }

        .progress-bar-default {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<div class="navbar-wrapper">
    <div class="container">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.html" style="font-size: 32px;">尚筹网-创意产品众筹平台</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse"
                     style="float: right;">
                    <ul class="nav navbar-nav">
                        <li class="dropdown"><a href="#" class="dropdown-toggle"
                                                data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i>
                            [[${session.loginMember.username}]]<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="member.html"><i
                                        class="glyphicon glyphicon-scale"></i> 会员中心</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-comment"></i>
                                    消息</a></li>
                                <li class="divider"></li>
                                <li><a th:href="@{/auth/member/logout}"><i
                                        class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>

<div class="container theme-showcase" role="main">

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="panel panel-default">
                    <div class="panel-heading" style="text-align: center;">
                        <div class="container-fluid">
                            <div class="row clearfix">
                                <div class="col-md-3 column">
                                    <div class="progress"
                                         style="height: 50px; border-radius: 0; position: absolute; width: 75%; right: 49px;">
                                        <div class="progress-bar progress-bar-default"
                                             role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                             aria-valuemax="100" style="width: 100%; height: 50px;">
                                            <div style="font-size: 16px; margin-top: 15px;">1.
                                                确认回报内容
                                            </div>
                                        </div>
                                    </div>
                                    <div
                                            style="right: 0; border: 10px solid #ddd; border-left-color: #88b7d5; border-width: 25px; position: absolute; border-left-color: rgba(221, 221, 221, 1); border-top-color: rgba(221, 221, 221, 0); border-bottom-color: rgba(221, 221, 221, 0); border-right-color: rgba(221, 221, 221, 0);">
                                    </div>
                                </div>
                                <div class="col-md-3 column">
                                    <div class="progress"
                                         style="height: 50px; border-radius: 0; position: absolute; width: 75%; right: 49px;">
                                        <div class="progress-bar progress-bar-success"
                                             role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                             aria-valuemax="100" style="width: 100%; height: 50px;">
                                            <div style="font-size: 16px; margin-top: 15px;">2.
                                                确认订单
                                            </div>
                                        </div>
                                    </div>
                                    <div
                                            style="right: 0; border: 10px solid #ddd; border-left-color: #88b7d5; border-width: 25px; position: absolute; border-left-color: rgba(92, 184, 92, 1); border-top-color: rgba(92, 184, 92, 0); border-bottom-color: rgba(92, 184, 92, 0); border-right-color: rgba(92, 184, 92, 0);">
                                    </div>
                                </div>
                                <div class="col-md-3 column">
                                    <div class="progress"
                                         style="height: 50px; border-radius: 0; position: absolute; width: 75%; right: 49px;">
                                        <div class="progress-bar progress-bar-default"
                                             role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                             aria-valuemax="100" style="width: 100%; height: 50px;">
                                            <div style="font-size: 16px; margin-top: 15px;">3. 付款</div>
                                        </div>
                                    </div>
                                    <div
                                            style="right: 0; border: 10px solid #ddd; border-left-color: #88b7d5; border-width: 25px; position: absolute; border-left-color: rgba(221, 221, 221, 1); border-top-color: rgba(221, 221, 221, 0); border-bottom-color: rgba(221, 221, 221, 0); border-right-color: rgba(221, 221, 221, 0);">
                                    </div>
                                </div>
                                <div class="col-md-3 column">
                                    <div class="progress" style="height: 50px; border-radius: 0;">
                                        <div class="progress-bar progress-bar-default"
                                             role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                             aria-valuemax="100" style="width: 100%; height: 50px;">
                                            <div style="font-size: 16px; margin-top: 15px;">4. 完成</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div class="container-fluid">
                            <div class="row clearfix">
                                <div class="col-md-12 column">
                                    <div class="alert alert-warning alert-dismissable"
                                         style="color: red;">
                                        <button type="button" class="close" data-dismiss="alert"
                                                aria-hidden="true">×
                                        </button>
                                        <i class="glyphicon glyphicon-info-sign"></i>
                                        <strong>请在下单后15分钟内付款，否则您的订单会被自动关闭。</strong>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div id="address" class="container-fluid">
                            <div class="row clearfix">
                                <div class="col-md-12 column">
                                    <blockquote
                                            style="border-left: 5px solid #f60; color: #f60; padding: 0 0 0 20px;">
                                        <b> 收货地址 </b>
                                    </blockquote>
                                </div>
                                <div class="col-md-12 column" style="padding: 0 120px;">
                                    <div th:if="${#lists.isEmpty(session.addressVOList)}">尚未创建收货地址</div>
                                    <div th:unless="${#lists.isEmpty(session.addressVOList)}" id="showAddress">
                                        <div th:each="address : ${session.addressVOList}" class="radio">
                                            <label> <input type="radio" name="addressId" th:value="${address.id}"
                                                           id="optionsRadios1"/> [[${address.receiveName}]]
                                                [[${address.phoneNum}]] [[${address.address}]]
                                            </label>
                                        </div>
                                    </div>
                                    <div class="radio">
                                        <label> <input type="radio" name="optionsRadios"
                                                       id="optionsRadios2" value="option2"> 新地址
                                        </label>
                                    </div>
                                    <div
                                            style="border: 10px solid #f60; border-bottom-color: #eceeef; border-width: 10px; width: 20px; margin-left: 20px; margin-top: -20px; border-left-color: rgba(221, 221, 221, 0); border-top-color: rgba(221, 221, 221, 0); border-right-color: rgba(221, 221, 221, 0);"></div>
                                    <div class="panel panel-default"
                                         style="border-style: dashed; background-color: #eceeef">
                                        <div class="panel-body">
                                            <div class="col-md-12 column">
                                                <form action="order/save/address" method="post" class="form-horizontal">
                                                    <input type="hidden" name="memberId"
                                                           th:value="${session.loginMember.id}"/>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">收货人（*）</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="receiveName" class="form-control"
                                                                 value="收货人" style="width: 200px;" placeholder="姓名：xxxx">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">手机（*）</label>
                                                        <div class="col-sm-10">
                                                            <input class="form-control" name="phoneNum" type="text"
                                                                   style="width: 200px;"
                                                                  value="18512341234" placeholder="请填写11位手机号码"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">地址（*）</label>
                                                        <div class="col-sm-10">
                                                            <input class="form-control" name="address" type="text"
                                                                   style="width: 400px;"
                                                                  value="收货地址" placeholder="请填写收货地址"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label"></label>
                                                        <div class="col-sm-10">
                                                            <button id="saveAddress" type="button"
                                                                    class="btn btn-primary">确认配送信息
                                                            </button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="container-fluid">
                            <div class="row clearfix">
                                <div class="col-md-12 column">
                                    <blockquote
                                            style="border-left: 5px solid #f60; color: #f60; padding: 0 0 0 20px;">
                                        <b> 发票信息 </b>
                                    </blockquote>
                                </div>
                                <div class="col-md-12 column" style="padding: 0 120px;">
                                    <div class="radio">
                                        <label> <input type="radio" name="invoiceRadio"
                                                       id="optionsRadios3" value="0" checked> 无需发票
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label> <input type="radio" name="invoiceRadio"
                                                       id="optionsRadios4" value="1"> 需要发票
                                        </label>
                                    </div>
                                    <div
                                            style="border: 10px solid #f60; border-bottom-color: #eceeef; border-width: 10px; width: 20px; margin-left: 20px; margin-top: -20px; border-left-color: rgba(221, 221, 221, 0); border-top-color: rgba(221, 221, 221, 0); border-right-color: rgba(221, 221, 221, 0);"></div>
                                    <div class="panel panel-default"
                                         style="border-style: dashed; background-color: #eceeef">
                                        <div class="panel-body">
                                            <div class="col-md-12 column">
                                                <form class="form-horizontal">
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">发票抬头（*）</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="invoiceTitle" class="form-control"
                                                                   style="width: 200px;" placeholder="个人">
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="container-fluid">
                            <div class="row clearfix">
                                <div class="col-md-12 column">
                                    <blockquote
                                            style="border-left: 5px solid #f60; color: #f60; padding: 0 0 0 20px;">
                                        <b> 项目信息 <a style="font-size: 12px;"
                                                    href="pay-step-1.html">修改数量</a>
                                        </b>
                                    </blockquote>
                                </div>
                                <div class="col-md-12 column">
                                    <table class="table table-bordered"
                                           style="text-align: center;">
                                        <thead>
                                        <tr style="background-color: #ddd;">
                                            <td>项目名称</td>
                                            <td>发起人</td>
                                            <td width="300">回报内容</td>
                                            <td width="80">回报数量</td>
                                            <td>支持单价</td>
                                            <td>配送费用</td>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td th:text="${session.orderProjectVO.projectName}">活性富氢净水直饮机</td>
                                            <td th:text="${session.orderProjectVO.launchName}">深圳市博实永道电子商务有限公司</td>
                                            <td th:text="${session.orderProjectVO.returnContent}">
                                                每满1750人抽取一台活性富氢净水直饮机，至少抽取一台。抽取名额（小数点后一位四舍五入）=参与人数÷1750人，由苏宁官方抽取。
                                            </td>
                                            <td th:text="${session.orderProjectVO.returnCount}">55</td>
                                            <td style="color: #F60" th:text="${session.orderProjectVO.supportPrice}">￥
                                                1.00
                                            </td>
                                            <td th:if="${session.orderProjectVO.freight == 0}">免运费</td>
                                            <td th:if="${session.orderProjectVO.freight != 0}"
                                                th:text="${session.orderProjectVO.freight}">免运费
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="col-md-12 column">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">备注</label>
                                        <div class="col-sm-10">
												<textarea class="form-control" name="remark" rows="1"
                                                          placeholder="填写关于回报或发起人希望您备注的信息"></textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-12 column">
                                    <blockquote
                                            style="border-left: 5px solid #f60; color: #f60; padding: 0 0 0 20px;">
                                        <b> 账单 </b>
                                    </blockquote>
                                </div>

                                <div class="col-md-12 column">
                                    <div class="alert alert-warning alert-dismissable"
                                         style="text-align: right; border: 2px solid #ffc287;">
                                        <ul style="list-style: none;">
                                            <li style="margin-top: 10px;">支持金额：<span
                                                    style="color: red;">￥[[${session.orderProjectVO.returnCount * session.orderProjectVO.supportPrice}]]</span>
                                            </li>
                                            <li style="margin-top: 10px;">配送费用：<span
                                                    style="color: red;">￥[[${session.orderProjectVO.freight}]]</span>
                                            </li>
                                            <li style="margin-top: 10px; margin-bottom: 10px;"><h2>
                                                支付总金额：<span style="color: red;">￥[[${session.orderProjectVO.returnCount * session.orderProjectVO.supportPrice+session.orderProjectVO.freight}]]</span>
                                            </h2></li>
                                            <li
                                                    style="margin-top: 10px; padding: 5px; border: 1px solid #F00; display: initial; background: #FFF;">
                                                <i class="glyphicon glyphicon-info-sign"></i> <strong>您需要先
                                                <a href="#address">设置配送信息</a> ,再提交订单
                                            </strong>
                                            </li>
                                            <li style="margin-top: 10px;">
                                                请在下单后15分钟内付款，否则您的订单会被自动关闭。
                                            </li>
                                            <li style="margin-top: 10px;">
                                                <button id="payButton" disabled="disabled" type="button"
                                                        class="btn btn-warning btn-lg">
                                                    <i class="glyphicon glyphicon-credit-card"></i> 立即付款
                                                </button>
                                            </li>
                                            <li style="margin-top: 10px;">
                                                <div class="checkbox">
                                                    <label>
                                                        <input id="knowRoleCheckBox" type="checkbox">我已了解风险和规则
                                                    </label>
                                                </div>
                                            </li>
                                        </ul>


                                    </div>
                                </div>
                                <div class="container">
                                    <div class="row clearfix">
                                        <div class="col-md-12 column">
                                            <blockquote>
                                                <p>
                                                    <i class="glyphicon glyphicon-info-sign"
                                                       style="color: #2a6496;"></i> 提示
                                                </p>
                                                <br> <span style="font-size: 12px;">1.众筹并非商品交易，存在一定风险。支持者根据自己的判断选择、支持众筹项目，与发起人共同实现梦想并获得发起人承诺的回报。<br>
														2.众筹平台仅提供平台网络空间及技术支持等中介服务，众筹仅存在于发起人和支持者之间，使用众筹平台产生的法律后果由发起人与支持者自行承担。<br>
														3.本项目必须在2017-06-04之前达到 ￥1000000.00
														的目标才算成功，否则已经支持的订单将取消。订单取消或募集失败的，您支持的金额将原支付路径退回。<br>
														4.请在支持项目后15分钟内付款，否则您的支持请求会被自动关闭。<br>
														5.众筹成功后由发起人统一进行发货，售后服务由发起人统一提供；如果发生发起人无法发放回报、延迟发放回报、不提供回报后续服务等情况，您需要直接和发起人协商解决。<br>
														6.如您不同意上述风险提示内容，您有权选择不支持；一旦选择支持，视为您已确认并同意以上提示内容。
													</span>
                                            </blockquote>
                                        </div>
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="container" style="margin-top: 20px;">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div id="footer">
                    <div class="footerNav">
                        <a rel="nofollow" href="http://www.atguigu.com">关于我们</a> | <a
                            rel="nofollow" href="http://www.atguigu.com">服务条款</a> | <a
                            rel="nofollow" href="http://www.atguigu.com">免责声明</a> | <a
                            rel="nofollow" href="http://www.atguigu.com">网站地图</a> | <a
                            rel="nofollow" href="http://www.atguigu.com">联系我们</a>
                    </div>
                    <div class="copyRight">Copyright ?2010-2014atguigu.com 版权所有
                    </div>
                </div>

            </div>
        </div>
    </div>

</div>
<!-- /container -->

<!-- 为了收集当前页面中的所有数据，构造空表单 -->
<form id="summaryForm" action="pay/generate/order" method="post"></form>


</body>
</html>
```



### 6.5 追加代码: 获取用户的收货地址【`api` 工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662562892028-2183653b-7154-4518-84c6-998da8c9aa4f.png)

```java
    /**
     * 获取用户的收货地址
     *
     * @param memberId
     * @return {@link ResultEntity}<{@link List}<{@link AddressVO}>>
     */
    @RequestMapping("/get/address/vo/list/remote")
    ResultEntity<List<AddressVO>> getAddressVOListRemote(@RequestParam("memberId") Integer memberId);
```

### 6.6 追加代码【`mysql` 工程】

- `OrderProviderHandler`

```java
    @RequestMapping("/get/address/vo/list/remote")
    ResultEntity<List<AddressVO>> getAddressVOListRemote(@RequestParam("memberId") Integer memberId) {
        try {
            List<AddressVO> addressVOList = orderService.getAddressVOList(memberId);
            return ResultEntity.successWithData(addressVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }
```

- `OrderService`

```java
    /**
     * 获取用户的收货地址
     *
     * @param memberId
     * @return {@link List}<{@link AddressVO}>
     */
    List<AddressVO> getAddressVOList(Integer memberId);
```

- `OrderServiceImpl`

```java
    @Override
    public List<AddressVO> getAddressVOList(Integer memberId) {
        return addressPOMapper.selectAddressVOList(memberId);
    }
```

- `AddressPOMapper`

```java
    /**
     * 查询用户的收货地址
     *
     * @param memberId 成员身份
     * @return {@link List}<{@link AddressVO}>
     */
    List<AddressVO> selectAddressVOList(Integer memberId);
```

- `AddressPOMapper.xml`

```xml
    <select id="selectAddressVOList" resultType="com.atguigu.crowd.entity.vo.AddressVO">
        select receive_name receiveName,
               phone_num    phoneNum,
               address,
               member_id    memberId
        from t_address
        where member_id = #{memberId}
    </select>
```



### 6.7 新增收货地址

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662653951804-f60903ed-f607-4c3c-9664-fd0430fb4448.png)

#### 6.7.1 思路

![img](https://cdn.nlark.com/yuque/__puml/20f231eeed4e4ef7ca78d3b85052e27c.svg)



#### 6.7.2 发起请求

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662718145479-737590ba-b02b-4c80-ae66-3789d7ec0f84.png)

```javascript
$(function () {
	$("#saveAddress").click(function () {
	    // 收集所有要提交的表单项的数据
	    var memberId = $("[name=memberId]").val();
	    var receiveName = $.trim($("[name=receiveName]").val());
	    var phoneNum = $.trim($("[name=phoneNum]").val());
	    var address = $.trim($("[name=address]").val());
	
	    // 发起请求
	    $.ajax({
	        url: "order/save/address",
	        type: "post",
	        data: JSON.stringify({
	            memberId,
	            receiveName,
	            phoneNum,
	            address
	        }),
	        contentType: "application/json;charset=UTF-8",
	        dataType: "json",
	        success: function (response) {
	            var result = response.result;
	            if ("SUCCESS" === result) {
	                var address = response.data;
	                $("#showAddress").append(`
	                            <div class="radio">
	                                <label> <input type="radio" name="addressId" value="${address.id}"
	                                               id="optionsRadios1"/> ${address.receiveName}
	                                    ${address.phoneNum} ${address.address}
	                                </label>
	                            </div>`);
	                layer.msg("新增收货地址成功!")
	            }
	
	            if ("FAILED" === result) {
	                layer.msg("保存收货地址失败, 请重试")
	            }
	        },
	        error: function (response) {
	            layer.msg(response.status + " " + response.statusText);
	        }
	    })
	})
})
```



#### 6.7.3 `OrderHandler` 远程调用接口

- 追加代码

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662686297761-87d3e1ee-490c-4165-adb2-7df78815d7c8.png)

```java
    /**
     * 首页 -> 项目详情（点击支持） -> 显示回报确认信息 -> 显示返回确认信息（收货地址, 点击确认配送信息）
     *
     * @param addressVO
     * @return {@link ResultEntity}<{@link AddressVO}>
     */
    @ResponseBody
    @RequestMapping("/save/address")
    public ResultEntity<AddressVO> saveAddressPO(@RequestBody AddressVO addressVO) {
        // 创建一个持久化对象
        AddressPO addressPO = new AddressPO();
        // 复制属性
        BeanUtils.copyProperties(addressVO, addressPO);
        // 保存
        ResultEntity<AddressPO> resultEntity = mySQLRemoteService.saveAddressPORemote(addressPO);
        if (ResultEntity.SUCCESS.equals(resultEntity.getResult())) {
            // 执行成功， 复制持久化对象给视图对象并返回
            // 保存成功会有一个 id 值, 所以要复制
            BeanUtils.copyProperties(addressPO, addressVO);
            return ResultEntity.successWithData(addressVO);
        } else {
            return ResultEntity.failed(resultEntity.getMessage());
        }
    }
```

- 声明接口【`api` 工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662686380607-2f83f269-e077-4c81-a453-f3c9ed239d99.png)

```java
    /**
     * 保存收货地址
     *
     * @param addressPO
     * @return {@link ResultEntity}<{@link AddressPO}>
     */
    @RequestMapping("/save/address/po/remote")
    ResultEntity<AddressPO> saveAddressPORemote(@RequestBody AddressPO addressPO);
```



#### 6.7.4 `OrderProviderHandler`: 保存收货地址【`mysql` 工程】

- 追加代码

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662686461999-4ab4e2de-111d-4e8b-89db-644e6923517c.png)

```java
    public ResultEntity<AddressPO> saveAddressPORemote(@RequestBody AddressPO addressPO){
        try {
            orderService.saveAddressPO(addressPO);
            return ResultEntity.successWithData(addressPO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }
```

- 声明接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662686573478-d385fc7a-051a-40d1-9aa0-9b97121b8564.png)

```java
    /**
     * 保存收货地址
     *
     * @param addressPO
     */
    void saveAddressPO(AddressPO addressPO);
```



- 实现接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662686585965-b70d3114-00f5-4bb5-89ba-67c20d345747.png)

```java
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public void saveAddressPO(AddressPO addressPO) {
        addressPOMapper.insert(addressPO);
    }
```



- `Mapper` 接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662686622385-198b3dfa-42e2-4d2a-a01d-6c296b6b4e7e.png)

```java
    int insert(AddressPO record);
```



- `SQL`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662686655986-8ceffabc-9055-4a55-9c66-d9b33211f843.png)

```xml
    <insert id="insert" useGeneratedKeys="true" keyProperty="id" parameterType="com.atguigu.crowd.entity.po.AddressPO">
        insert into t_address (id, receive_name, phone_num,
                               address, member_id)
        values (#{id,jdbcType=INTEGER}, #{receiveName,jdbcType=VARCHAR}, #{phoneNum,jdbcType=VARCHAR},
                #{address,jdbcType=VARCHAR}, #{memberId,jdbcType=VARCHAR})
    </insert>
```



#### 6.7.5 启用服务熔断机制【`mysql` 工程】

1.  追加依赖

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662718738763-9300205b-e4bb-4e5e-874c-95a6eb44c849.png)

```xml
<!-- 整合 Hystrix -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
```

1. 开启断路器功能

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662691525085-fe909800-81e8-46f2-80d7-f10320de7572.png)

```java
package com.atguigu.crowd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * `@EnableCircuitBreaker`: 开启断路器功能
 * 
 * @author 陈江林
 * @date 2022/8/19 05:02
 */
@EnableCircuitBreaker
@MapperScan("com.atguigu.crowd.mapper")
@SpringBootApplication
public class CrowdMainClass {

    public static void main(String[] args) {
        SpringApplication.run(CrowdMainClass.class, args);
    }

}
```

1. 修改代码: `OrderProviderHandler`: 保存收货地址【`mysql` 工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662718761183-ec26bf7c-ef7c-4475-8cd1-696cb8ccf842.png)

```java
    @HystrixCommand(fallbackMethod = "saveAddressPORemoteBackup")
    @RequestMapping("/save/address/po/remote")
    public ResultEntity<AddressPO> saveAddressPORemote(@RequestBody AddressPO addressPO){
        try {
            orderService.saveAddressPO(addressPO);
            return ResultEntity.successWithData(addressPO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    public ResultEntity<AddressPO> saveAddressPORemoteBackup(@RequestBody AddressPO addressPO){
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }
```



1. 追加代码

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662719594241-07dd2a12-45d6-4f73-a7d4-a348dce6f13d.png)

```java
public static final String MESSAGE_HYSTRIX_BACKUP = "熔断机制生效: 方法执行出现问题";
```



#### 6.7.6 启用服务降级机制

1. 追加依赖【`api` 工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662718779775-38d70866-f9e6-4283-b44f-c3384aa6a84e.png)

```xml
<!-- 整合 Hystrix -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
```

1. 新建 `MySQLFallBackFactory`【`api` 工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662692962241-c85ce7d3-04e9-4c4b-ba83-5b0f9148a7e4.png)

```java
package com.atguigu.crowd.factory;

import com.atguigu.crowd.api.MySQLRemoteService;
import com.atguigu.crowd.entity.po.AddressPO;
import com.atguigu.crowd.entity.po.MemberPO;
import com.atguigu.crowd.entity.vo.*;
import com.atguigu.crowd.util.ResultEntity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 陈江林
 * @date 2022/9/9 11:06
 */
@Component
public class MySQLFallBackFactory implements FallbackFactory<MySQLRemoteService> {

    @Override
    public MySQLRemoteService create(Throwable cause) {
        return new MySQLRemoteService() {
            @Override
            public ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(String loginacct) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<String> saveMember(MemberPO memberPO) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<String> saveProjectVORemote(ProjectVO projectVO, Integer memberId) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<List<PortalTypeVO>> getPortalTypeProjectDataRemote() {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<DetailProjectVO> getDetailProjectVORemote(Integer projectId) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<OrderProjectVO> getOrderProjectVORemote(Integer returnId) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<List<AddressVO>> getAddressVOListRemote(Integer memberId) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<AddressPO> saveAddressPORemote(AddressPO addressPO) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }
        };
    }

}
```

1. 追加代码

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662697390110-649a2213-7b76-4326-a030-e17fbd8fe77d.png)

```java
@FeignClient(value = "atguigu-crowd-mysql", fallbackFactory = MySQLFallBackFactory.class)
public interface MySQLRemoteService {
}
```

1. 追加配置【`order` 工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662693132577-8c51e8b3-ee98-4364-8cb4-4d5d34b6dc62.png)

```yaml
feign:
  hystrix:
    # 使用 Hystrix 断路器
    enabled: true
```





## 7. `Hystrix` 扩展

### 7.1 服务熔断机制

#### 7.1.1 `MemberProviderHandler` 的

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662699339886-b92b88d6-edc1-450a-b97c-c8739db548cb.png)

```java
package com.atguigu.crowd.handler;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.po.MemberPO;
import com.atguigu.crowd.service.api.MemberService;
import com.atguigu.crowd.util.ResultEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈江林
 * @date 2022/8/19 09:11
 */
@RestController
public class MemberProviderHandler {

    @Autowired
    private MemberService memberService;

    @HystrixCommand(fallbackMethod = "getMemberPOByLoginAcctRemoteBackup")
    @RequestMapping("/get/memberpo/login/acct/remote")
    public ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(@RequestParam("loginacct") String loginacct) {
        try {
            // 调用本地 Service 完成查询
            MemberPO memberPO = memberService.getMemberPOByLoginAcct(loginacct);
            // 如果没有抛异常, 那么就返回成功的结果
            return ResultEntity.successWithData(memberPO);
        } catch (Exception e) {
            // 如果捕获到异常则返回失败的结果
            return ResultEntity.failed(e.getMessage());
        }
    }

    public ResultEntity<MemberPO> getMemberPOByLoginAcctRemoteBackup(@RequestParam("loginacct") String loginacct) {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }

    /**
     * 保存
     *
     * @param memberPO 会员实体类
     * @return
     */
    @HystrixCommand(fallbackMethod = "saveMemberBackup")
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

    public ResultEntity<String> saveMemberBackup(@RequestBody MemberPO memberPO) {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }

}
```



#### 7.1.2 `OrderProviderHandler`的

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662718672237-46ea1f3d-b676-4c79-a0fa-e90ecb60e2d6.png)

```java
package com.atguigu.crowd.handler;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.po.AddressPO;
import com.atguigu.crowd.entity.vo.AddressVO;
import com.atguigu.crowd.entity.vo.OrderProjectVO;
import com.atguigu.crowd.service.api.OrderService;
import com.atguigu.crowd.util.ResultEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 陈江林
 * @date 2022/9/7 20:15
 */
@RestController
public class OrderProviderHandler {

    @Autowired
    private OrderService orderService;

    @HystrixCommand(fallbackMethod = "getOrderProjectVORemoteBackup")
    @RequestMapping("/get/order/project/vo/remote/{returnId}")
    ResultEntity<OrderProjectVO> getOrderProjectVORemote(@PathVariable("returnId") Integer returnId) {
        try {
            OrderProjectVO orderProjectVO = orderService.getOrderProjectVO(returnId);
            return ResultEntity.successWithData(orderProjectVO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    ResultEntity<OrderProjectVO> getOrderProjectVORemoteBackup(@PathVariable("returnId") Integer returnId) {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }

    @HystrixCommand(fallbackMethod = "getAddressVOListRemoteBackup")
    @RequestMapping("/get/address/vo/list/remote")
    ResultEntity<List<AddressVO>> getAddressVOListRemote(@RequestParam("memberId") Integer memberId) {
        try {
            List<AddressVO> addressVOList = orderService.getAddressVOList(memberId);
            return ResultEntity.successWithData(addressVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    ResultEntity<List<AddressVO>> getAddressVOListRemoteBackup(@RequestParam("memberId") Integer memberId) {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }

    @HystrixCommand(fallbackMethod = "saveAddressPORemoteBackup")
    @RequestMapping("/save/address/po/remote")
    public ResultEntity<AddressPO> saveAddressPORemote(@RequestBody AddressPO addressPO){
        try {
            orderService.saveAddressPO(addressPO);
            return ResultEntity.successWithData(addressPO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    public ResultEntity<AddressPO> saveAddressPORemoteBackup(@RequestBody AddressPO addressPO){
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }

}
```



#### 7.1.3 `ProjectProviderHandler` 的

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662718681948-b86b8d83-45c9-4222-a39e-642c0caaa778.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662699360510-d8849288-0cb0-4251-9492-2855b3cf966f.png)

```java
package com.atguigu.crowd.handler;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.vo.DetailProjectVO;
import com.atguigu.crowd.entity.vo.PortalTypeVO;
import com.atguigu.crowd.entity.vo.ProjectVO;
import com.atguigu.crowd.service.api.ProjectService;
import com.atguigu.crowd.util.ResultEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 陈江林
 * @date 2022/8/31 11:49
 */
@RestController
public class ProjectProviderHandler {

    @Autowired
    private ProjectService projectService;

    /**
     * 保存会员发起的众筹信息
     *
     * @param projectVO 众筹信息
     * @param memberId  会员 id
     * @return
     */
    @HystrixCommand(fallbackMethod = "saveProjectVORemoteBackup")
    @RequestMapping("/save/project/vo/remote")
    public ResultEntity<String> saveProjectVORemote(@RequestBody ProjectVO projectVO, @RequestParam("memberId") Integer memberId) {
        try {
            projectService.saveProject(projectVO, memberId);
            return ResultEntity.successWithoutData();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    public ResultEntity<String> saveProjectVORemoteBackup(@RequestBody ProjectVO projectVO, @RequestParam("memberId") Integer memberId) {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }

    @HystrixCommand(fallbackMethod = "getPortalTypeProjectDataRemoteBackup")
    @RequestMapping("/get/portal/type/project/data/remote")
    public ResultEntity<List<PortalTypeVO>> getPortalTypeProjectDataRemote() {

        try {
            List<PortalTypeVO> portalTypeVOList = projectService.getPortalTypeVO();
            return ResultEntity.successWithData(portalTypeVOList);
        } catch (Exception e) {
            return ResultEntity.failed(e.getMessage());
        }

    }

    public ResultEntity<List<PortalTypeVO>> getPortalTypeProjectDataRemoteBackup() {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }

    @HystrixCommand(fallbackMethod = "getDetailProjectVORemoteBackup")
    @RequestMapping("/get/project/detail/remote/{projectId}")
    ResultEntity<DetailProjectVO> getDetailProjectVORemote(@PathVariable("projectId") Integer projectId) {

        try {
            DetailProjectVO detailProjectVOById = projectService.getDetailProjectVO(projectId);
            return ResultEntity.successWithData(detailProjectVOById);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }

    }

    ResultEntity<DetailProjectVO> getDetailProjectVORemoteBackup(@PathVariable("projectId") Integer projectId) {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }

}
```



#### 7.1.4 `redis` 工程整合 `Hystrix`

1. 追加依赖

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662719291623-43379379-828f-4cd3-92c9-f71836d00a35.png)

```xml
<!-- 整合 Hystrix -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
```

1. 开启断路器， 修改 `CrowdMainClass`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662719277517-e5ffa535-d816-4353-abe6-d150f6ffb48b.png)

```java
package com.atguigu.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * `@EnableCircuitBreaker`: 开启断路器功能
 *
 * @author 陈江林
 * @date 2022/8/19 11:05
 */
@EnableCircuitBreaker
@SpringBootApplication
public class CrowdMainClass {

    public static void main(String[] args) {
        SpringApplication.run(CrowdMainClass.class, args);
    }

}
```



1. 修改 `RedisHandler`

```java
package com.atguigu.crowd.handler;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.util.ResultEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "setRedisKeyValueRemoteBackup")
    @RequestMapping("/set/redis/key/value/remote")
    public ResultEntity<String> setRedisKeyValueRemote(
            @RequestParam("key") String key,
            @RequestParam("value") String value) {
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key, value);

            return ResultEntity.successWithoutData();
        } catch (Exception e) {
            return ResultEntity.failed(e.getMessage());
        }
    }

    public ResultEntity<String> setRedisKeyValueRemoteBackup(
            @RequestParam("key") String key,
            @RequestParam("value") String value) {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }

    /**
     * 设置带超时时间的
     *
     * @param key
     * @param value
     * @param time     时间
     * @param timeUnit 时间单位
     * @return
     */
    @HystrixCommand(fallbackMethod = "setRedisKeyValueRemoteWithTimeoutBackup")
    @RequestMapping("/set/redis/key/value/remote/with/timeout")
    public ResultEntity<String> setRedisKeyValueRemoteWithTimeout(
            @RequestParam("key") String key,
            @RequestParam("value") String value,
            @RequestParam("time") long time,
            @RequestParam("timeUnit") TimeUnit timeUnit) {
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key, value, time, timeUnit);

            return ResultEntity.successWithoutData();
        } catch (Exception e) {
            return ResultEntity.failed(e.getMessage());
        }
    }

    public ResultEntity<String> setRedisKeyValueRemoteWithTimeoutBackup(
            @RequestParam("key") String key,
            @RequestParam("value") String value,
            @RequestParam("time") long time,
            @RequestParam("timeUnit") TimeUnit timeUnit) {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }
    
    /**
     * 根据 Key 获取
     *
     * @param key
     * @return
     */
    @HystrixCommand(fallbackMethod = "getRedisKeyValueByKeyBackup")
    @RequestMapping("get/redis/key/value/by/key")
    public ResultEntity<String> getRedisKeyValueByKey(@RequestParam("key") String key) {
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            String value = operations.get(key);

            return ResultEntity.successWithData(value);
        } catch (Exception e) {
            return ResultEntity.failed(e.getMessage());
        }
    }

    public ResultEntity<String> getRedisKeyValueByKeyBackup(@RequestParam("key") String key) {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }

    /**
     * 根据 Key 删除
     *
     * @param key
     * @return
     */
    @HystrixCommand(fallbackMethod = "removeRedisKeyRemoteBackup")
    @RequestMapping("remove/redis/key/remote")
    public ResultEntity<String> removeRedisKeyRemote(@RequestParam("key") String key) {
        try {
            redisTemplate.delete(key);

            return ResultEntity.successWithoutData();
        } catch (Exception e) {
            return ResultEntity.failed(e.getMessage());
        }
    }

    public ResultEntity<String> removeRedisKeyRemoteBackup(@RequestParam("key") String key) {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }
    
}
```



### 7.2 服务降级机制

1. 追加配置【`auth` 工程】和【`project`工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662699530657-7a4b9f12-a3ee-4ad8-9dd5-3765d0f9bfb6.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662699553501-c6d5e3f2-a7c2-492b-b27c-6ea48cf9ed73.png)

```yaml
feign:
  hystrix:
    # 使用 Hystrix 断路器
    enabled: true
```



#### 7.2.1 新建 `RedisFallBackFactory`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662698451200-749d530a-fa0d-4d24-bd8f-7cdcb781ca03.png)

```java
package com.atguigu.crowd.factory;

import com.atguigu.crowd.api.RedisRemoteService;
import com.atguigu.crowd.util.ResultEntity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author 陈江林
 * @date 2022/9/9 12:39
 */
@Component
public class RedisFallBackFactory implements FallbackFactory<RedisRemoteService> {

    @Override
    public RedisRemoteService create(Throwable cause) {
        return new RedisRemoteService() {
            @Override
            public ResultEntity<String> setRedisKeyValueRemote(String key, String value) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<String> setRedisKeyValueRemoteWithTimeout(String key, String value, long time, TimeUnit timeUnit) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<String> getRedisKeyValueByKey(String key) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }

            @Override
            public ResultEntity<String> removeRedisKeyRemote(String key) {
                return ResultEntity.failed("降级机制生效: " + cause.getMessage());
            }
        };
    }

}
```

#### 7.2.2 使用 `RedisFallBackFactory`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662698516382-b079754d-2271-4154-8bf3-7f63473fa7c6.png)

```java
@FeignClient(value = "atguigu-crowd-redis", fallbackFactory = RedisFallBackFactory.class)
public interface RedisRemoteService {
}
```


# 二十四 前台-支付

```
git checkout -b 24.0.0_pay
```



## 1. 思路

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662729509855-c54a3688-fe84-4b43-895e-27d5b4a73153.png)

## 2. 操作一: 搭建 `pay` 工程环境

### 2.1 追加依赖和插件

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662798182722-a79cc241-2cab-4342-95cf-14f8f09f3657.png)

```xml
    <dependencies>
        <!-- 支付宝 Alipay SDK -->
        <dependency>
            <groupId>com.alipay.sdk</groupId>
            <artifactId>alipay-sdk-java</artifactId>
            <version>4.33.39.ALL</version>
        </dependency>
        <dependency>
            <groupId>com.atguigu.crowd</groupId>
            <artifactId>atcrowdfunding17-member-api</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <!-- 导入配置文件处理器, 配置文件进行绑定 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
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
        <!-- SpringBoot 测试 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
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



### 2.2 新建 `CrowdMainClass`

```java
package com.atguigu.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 陈江林
 * @date 2022/9/10 16:23
 */
@EnableFeignClients
@SpringBootApplication
public class CrowdMainClass {

    public static void main(String[] args) {
        SpringApplication.run(CrowdMainClass.class, args);
    }

}
```

### 2.3 新建 `PayProperties`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662814685128-fc0fc509-2249-4700-8348-0660eaa8440a.png)

```java
package com.atguigu.crowd.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 陈江林
 * @date 2022/9/10 17:42
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@ConfigurationProperties(prefix = "ali.pay")
public class PayProperties {

    /**
     * 支付宝公钥
     */
    private String alipayPublicKey;

    /**
     * 应用 ID
     */
    private String appId;

    /**
     * 字符编码格式
     */
    private String charset;

    /**
     * 支付宝网关（沙箱环境）
     */
    private String gatewayUrl;

    /**
     * 商户私钥
     */
    private String merchantPrivateKey;

    /**
     * 支付宝服务器主动通知商户服务器里指定的页面 http/https 路径
     * 交易成功后，支付宝通过 post 请求 notifyUrl（商户入参传入），返回异步通知参数。
     */
    private String notifyUrl;

    /**
     * 用户确认支付后，支付宝通过 get 请求 returnUrl（商户入参传入），返回同步返回参数。
     */
    private String returnUrl;

    /**
     * 签名方式
     */
    private String signType;

}
```



### 2.4 新建 `application.yml`

```yaml
server:
  port: 7000

spring:
  application:
    name: atguigu-crowd-pay
  session:
    store-type: redis

eureka:
  client:
    service-url:
      defaultZone: http://localhost:1000/eureka

ribbon:
  # 10秒 - 处理请求的超时时间，默认为5秒
  ReadTimeout: 10000
  # 10秒 - 连接建立的超时时长，默认5秒
  ConnectTimeout: 10000

feign:
  hystrix:
    # 使用 Hystrix 断路器
    enabled: true

ali:
  pay:
    alipay-public-key: MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoauF73gbBsJVQkFK/gmmVOWzYevEJZyPozl9L/49MvZKgo9oVOniBIJZq3+/ve6UZUKxLhKGFekP7mCsqMP3J+dr/a12gcVeBX8mu8J6ArwJnQ+pNsbZl9/dlpaob7qEGPd4gCZyr4J31ejpHrFJZBrUeHMtp3bo41YlMa7EKq4eoI8o8nm8yLFedtmtE5/LlY1uj3W0n6ZTGMjGfAOBQSICeoEJZPH+9u/NkLC/2FhRNNMwEAyp0xYQ3AjlX93GFL5F/1nc56oXDzpcIVzBXW+RP8Of1ISwFiXw6qF/P+zXLUNFmjDh03bJrdHoYuvS/Xygs53gwLYFIF+Qdo1KBwIDAQAB
    app-id: 2016100100642012
    charset: utf-8
    gateway-url: https://openapi.alipaydev.com/gateway.do
    merchant-private-key: MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCSW8OKd+By+Ea7UP9yCbWtlhvr7QvgAfiG9joMwbZ+Zma2/YMOWaAPD6NowrnaNaNd9gWZB/qJ1oe5QAXUi4bi/J1n+1+T1giRSaFtpkfDeRBvKmTiSyYCeGk7aeT0FWODWQB7ZnPD9R6KCeJCVhzN2YmurNFHftiM1fFcRHUNb5Daw0m7xKrOebQwMIk7K3at5a/Yd5nMUcOqoUOKTXMjxXSW6CnFXMCirPhg/e5aAMD+GiOUOIKx/DTtnZjVBv5UF0MJ7Xg1/wtrkHi4k3ZPLwJdMjv4UOH9377BbGFkyc0/0PJPhG69TqyyOInUCDNDyhzaYpH423GhlJy4uywrAgMBAAECggEAenw/jp+6gJ1VnKgxz/9eQ3Lv1SdiG8uqcVCZzllD4E7UwWoyhwzszg35ZNAqd/sRyK3/i03JGBgpKBjziCho74gYN5CBMZkbPHQRnFFfl7C210H0ggoAOmsJLob17GwGB0OyCpP4aFO4hi+1Ymzs2D2pYz0QPDRlCKB3yQ8louKjlykGSWwo58zwm935BHvv//JijHGbMbqDJGMfj/ogjhDP0txE7ZBiO9sEc1RjZ5Csg/81H8XSXCGyMowTX+I2M2ys59HMiuZFLM3pG5/UfOkqGKEJcv/ymsKILgL5h2XvLIFbgUqG4WMmHAX+moApnqmnkOtvSnE1u9hnBIkE+QKBgQDuerisalgfDlJ4wn3A7yQyX4cbT3ozLmqo/FZrlrd/ZJ/HgFrGBiEjaSxWRUxVUBGOgyQszOCzvhPySJjW6Y+xcai1MpC0z9fnvbpFM5GVVKUDIIA//O8+Ukd7wZyW20jebeFNk9I/kTAHs751wSJ8x60OET34r+ESk6aV+9xMDQKBgQCdHHK2XKgbUb+LtM0BUDq4KzPWW3/XYMrKpazDjwB+z2XWJSzch4nXyEa/8QAnUI3Atyn0fK1BmfyvFFtHpQtUpMUKtsswz9+RLwFrFrMspl3POlQEaU32fzl/RL7mybZyt71Mqcgq41DAtrVcyXWhgU1x6XrHcCxwZ0LROsDzFwKBgEolLbWteqhtM4cIMUEDGSXwPXloRH4VOGRB0DyzJ2ocRvEoHxDiZvszf+1yrkD4G/1LGLw1FsfLmTgDCkIHa/2ncOSlTAhrdp0+h+NsHR9oqcVHHZjHczrVKhR4Jc9hbk55q0sLYpsQ8PX0FItX+PkCu/NbuQDQ7hFwhqKrI9shAoGADU9LqIdQ9n+Gap92fpX9Y3zFd3No8SYSB/jhGfATaqrHRc0Ab+5Ljyw4UipoiOwaFiluNHgbdWNGNM7UrM0emJ0c1DuIGyqBFhuVUy0pIK83Y0bdt0H0iN1eUZnRUlvkSPOn5ca8XmXDgY/47VNj07rQhMXy0NJ/8UXOM0t27SECgYEAxERMjSKIjJ4VRcVcroBzdXZ2O3Pj9r1BLkyY8qKmptYvA+yinVWvvVzwjoHqLoqEkVZMq2ixrLYt7sl3esfGyUIdxjXUI1cbvCOpbDe7f0kJxvXyldC5Lrtama5gdJE36JFGbWrf2PRg4in1sizMjyY8G/SDMS0MNKpzos4pASQ=
    notify-url: http://175.178.174.83/pay/notify
    return-url: http://175.178.174.83/pay/return
    sign-type: RSA2
```



### 2.5 新建 `OrderVO`【`entity` 工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662806372988-36a00d46-3771-4e0f-9e2c-63e009937995.png)

```java
package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 陈江林
 * @date 2022/9/10 16:14
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 收货地址表主键
     */
    private String addressId;

    /**
     * 订单号
     */
    private String orderName;

    /**
     * 支付宝流水单号
     */
    private String payOrderNum;

    /**
     * 订单金额
     */
    private Double orderAmount;

    /**
     * 是否开发票 [{0: 不开发票}, {1: 开发票}]
     */
    private String invoice;

    /**
     * 发票抬头
     */
    private String invoiceTitle;

    /**
     * 订单备注
     */
    private String orderRemark;

    private OrderProjectVO orderProjectVO;

}
```



### 2.6 追加路由规则【`zuul`工程】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662806357066-136c3a1b-33e6-4716-96ae-0bc091735ddf.png)

```yaml
zuul:
  routes:
    crowd-pay:
      service-id: atguigu-crowd-pay
      path: /pay/**
```



## 3. 操作二: 提交订单表单

### 3.1 提交表单 <关键代码>

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662797951303-17c4a519-451b-446c-b60a-cf5cf50bfdc8.png)

```javascript
$("#payButton").click(function () {
    // 1.收集所有要提交的表单项的数据
    var addressId = $("[name=addressId]:checked").val();
    var invoice = $("[name=invoiceRadio]:checked").val();
    var invoiceTitle = $.trim($("[name=invoiceTitle]").val());
    var remark = $.trim($("[name=remark]").val());

    // 2.将上面收集到的表单数据填充到空表单中并提交
    $("#summaryForm")
        .append("<input type='hidden' name='addressId' value='" + addressId + "'/>")
        .append("<input type='hidden' name='invoice' value='" + invoice + "'/>")
        .append("<input type='hidden' name='invoiceTitle' value='" + invoiceTitle + "'/>")
        .append("<input type='hidden' name='orderRemark' value='" + remark + "'/>")
        .submit();
});
<!-- 为了收集当前页面中的所有数据，构造空表单 -->
<form id="summaryForm" action="pay/generate/order" method="post"></form>
```



### 3.2 调用支付接口

#### 3.2.1 新建 `PayHandler`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662806449103-5f18e8a5-c419-41b2-8a38-b8d2e8486ad3.png)

```java
package com.atguigu.crowd.handler;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.atguigu.crowd.config.PayProperties;
import com.atguigu.crowd.entity.vo.OrderProjectVO;
import com.atguigu.crowd.entity.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author 陈江林
 * @date 2022/9/10 16:23
 */
@Controller
public class PayHandler {

    @Autowired
    private PayProperties payProperties;
    
    /**
     * 生成订单, 调用支付宝支付
     *
     * @param session
     * @param orderVO
     * @return {@link String}
     * @throws AlipayApiException
     */
    @ResponseBody
    @RequestMapping("/generate/order")
    public String generateOrder(HttpSession session, OrderVO orderVO) throws AlipayApiException {
        // 1. 从 Session 域获取 OrderProjectVO 对象
        OrderProjectVO orderProjectVO = (OrderProjectVO) session.getAttribute("orderProjectVO");

        // 2. 将 orderProjectVO 对象和 orderVO 对象组装到一起
        orderVO.setOrderProjectVO(orderProjectVO);

        // 3. 生成订单号并设置到 orderVO 对象中
        // 根据当前日期时间生成字符串
        String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // 使用 UUID 生成用户 ID 部分
        String user = UUID.randomUUID().toString().replace("-", "").toUpperCase();

        // 组装
        String orderNum = time + user;

        // 设置到 OrderVO 对象中
        orderVO.setOrderName(orderNum);

        // 4. 计算订单总金额设置到 orderVO 对象中
        Double orderAmount = (double) (orderProjectVO.getSupportPrice() * orderProjectVO.getReturnCount() + orderProjectVO.getFreight());
        orderVO.setOrderAmount(orderAmount);

        // 将 OrderVO 对象存入 Session 域
        session.setAttribute("orderVO", orderVO);

        // 5. 调用支付请求
        return sendRequestToAliPay(orderNum, orderAmount, orderProjectVO.getProjectName(), orderProjectVO.getReturnContent());
    }

    /**
     * 阿里支付发送请求
     *
     * @param outTradeNo  商户订单号，商户网站订单系统中唯一订单号，必填
     * @param totalAmount 付款金额，必填
     * @param subject     订单名称，必填
     * @param body        商品描述，可空
     * @throws AlipayApiException 支付宝api例外
     */
    private String sendRequestToAliPay(
            String outTradeNo,
            Double totalAmount,
            String subject,
            String body
    ) throws AlipayApiException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(payProperties.getGatewayUrl(), payProperties.getAppId(), payProperties.getMerchantPrivateKey(), "json", payProperties.getCharset(), payProperties.getAlipayPublicKey(), payProperties.getSignType());

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(payProperties.getReturnUrl());
        alipayRequest.setNotifyUrl(payProperties.getNotifyUrl());

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + outTradeNo + "\","
                + "\"total_amount\":\"" + totalAmount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        //请求
        return alipayClient.pageExecute(alipayRequest).getBody();
    }

}
```



#### 3.2.2 `out_trade_no`（商户订单号）参数说明

| **描述** | **说明**                                                     |
| -------- | ------------------------------------------------------------ |
| 参数说明 | 商家订单号。商户自定义生成，一个 `out_trade_no` 对应一个 `trade_no`（支付宝交易号）。 |
| 命名要求 | 64个字符以内。可以包含字母、数字、下划线。需保证在商户端不重复。 |
| 注意事项 | 该参数为商户对接支付宝支付接口定义传值的参数，需保证该参数不重复，所以不能使用同一个订单号去请求接口。 |

- 格式设计: `当前时间（年月日小时分秒）+ 用户ID`

- - 时间格式: `yyyyMMddHHmmss`（14位）
- 用户ID: 通过 `UUID` 生成（32位）



## 4. 操作三: `returnUrl`方法

### 4.1 追加代码

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662806708454-27edc086-d60f-46f1-aa38-d31a58b3e282.png)

```java
    @ResponseBody
    @RequestMapping("/return")
    public String returnUrlMethod(HttpServletRequest request, HttpSession session) throws
            UnsupportedEncodingException, AlipayApiException {
        //获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }

            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        //调用SDK验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(
                params,
                payProperties.getAlipayPublicKey(),
                payProperties.getCharset(),
                payProperties.getSignType());

        //——请在这里编写您的程序（以下代码仅作参考）——
        if (signVerified) {
            //商户订单号
            String orderName = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //支付宝交易号
            String payOrderNum = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //付款金额
            String orderAmount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            // 保存到数据库
            // ......
            return "trade_no:" + orderName + "<br/>out_trade_no:" + payOrderNum + "<br/>total_amount:" + orderAmount;
        } else {
            // 页面显示信息: 验签失败
            return "验签失败";
        }

    }
```



## 5. 操作四: `notifyUrl`方法

### 5.1 追加代码

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662806708454-27edc086-d60f-46f1-aa38-d31a58b3e282.png)

```java
    @RequestMapping("/notify")
    public void notifyUrlMethod(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {
        //获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }

            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        //调用SDK验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(
                params,
                payProperties.getAlipayPublicKey(),
                payProperties.getCharset(),
                payProperties.getSignType());
        //——请在这里编写您的程序（以下代码仅作参考）——

	    /* 实际验证过程建议商户务必添加以下校验：
	    1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
	    2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
	    3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
	    4、验证app_id是否为该商户本身。
	    */
        // 验证成功
        if (signVerified) {
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");

            logger.info("商户订单号 out_trade_no=" + out_trade_no);
            logger.info("支付宝交易号 trade_no=" + trade_no);
            logger.info("交易状态 trade_status=" + trade_status);

            // return "success";
        } else {//验证失败
            logger.info("验证失败");
            // return "fail";

            //调试用，写文本函数记录程序运行情况是否正常
            //String sWord = AlipaySignature.getSignCheckContentV1(params);
            //AlipayConfig.logResult(sWord);
        }
    }
```



### 5.2 触发通知类型

| 通知类型                     | 描述     | 默认开启 |
| ---------------------------- | -------- | -------- |
| `tradeStatus.TRADE_CLOSED`   | 交易关闭 | 0        |
| `tradeStatus.TRADE_FINISHED` | 交易完结 | 0        |
| `tradeStatus.TRADE_SUCCESS`  | 支付成功 | 1        |
| `tradeStatus.WAIT_BUYER_PAY` | 交易创建 | 0        |

## 6. 操作五: 订单信息保存到数据库

### 6.1 思路

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662831284650-59da73a5-ae2f-4389-98a6-12f0ec8f02eb.png)



### 6.2 `return` 方法

```java
    @ResponseBody
    @RequestMapping("/return")
    public String returnUrlMethod(HttpServletRequest request, HttpSession session) throws
            UnsupportedEncodingException, AlipayApiException {
        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }

            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        // 调用SDK验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(
                params,
                payProperties.getAlipayPublicKey(),
                payProperties.getCharset(),
                payProperties.getSignType());

        // ——请在这里编写您的程序（以下代码仅作参考）——
        if (signVerified) {
            // 商户订单号
            String orderName = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
            // 支付宝交易号
            String payOrderNum = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
            // 付款金额
            String orderAmount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            // 保存到数据库
            OrderVO orderVO = (OrderVO)session.getAttribute("orderVO");
            // 将支付宝及交易号设置到 OrderVO 中
            orderVO.setPayOrderNum(payOrderNum);

            // 发起请求
            ResultEntity<String> resultEntity = mySQLRemoteService.saveOrderRemote(orderVO);
            logger.info("Order save result" + resultEntity.getResult());

            return "trade_no:" + orderName + "<br/>out_trade_no:" + payOrderNum + "<br/>total_amount:" + orderAmount;
        } else {
            // 页面显示信息: 验签失败
            return "验签失败";
        }

    }
```



### 6.3 声明接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662831655752-72f5cb75-0f32-4147-b998-eca4204a2995.png)

```java
    /**
     * 保存订单
     *
     * @param orderVO
     * @return {@link ResultEntity}<{@link String}>
     */
    @RequestMapping("/save/order/remote")
    ResultEntity<String> saveOrderRemote(@RequestBody OrderVO orderVO);
```



#### 6.3.1 对应的降级机制

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1662831684904-0a10fe56-ad87-4381-a721-7592ec648c7b.png)

```java
@Override
public ResultEntity<String> saveOrderRemote(OrderVO orderVO) {
    return ResultEntity.failed("降级机制生效: " + cause.getMessage());
}
```



### 6.4 追加代码【`mysql` 工程】

- `OrderProviderHandler`

```java
    @HystrixCommand(fallbackMethod = "saveOrderRemoteBackup")
    @RequestMapping("/save/order/remote")
    public ResultEntity<String> saveOrderRemote(@RequestBody OrderVO orderVO) {
        try {
            orderService.saveOrder(orderVO);
            return ResultEntity.successWithoutData();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    public ResultEntity<String> saveOrderRemoteBackup(@RequestBody OrderVO orderVO) {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }
```

- `OrderService`

```java
    /**
     * 保存订单
     *
     * @param orderVO
     */
    void saveOrder(OrderVO orderVO);
```

- `OrderServiceImpl`

```java
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public void saveOrder(OrderVO orderVO) {
        OrderPO orderPO = new OrderPO();
        BeanUtils.copyProperties(orderVO, orderPO);

        OrderProjectPO orderProjectPO = new OrderProjectPO();
        BeanUtils.copyProperties(orderVO.getOrderProjectVO(), orderProjectPO);

        // 保存 orderPO 自动生成的主键是 orderProjectPO 需要的
        orderPOMapper.insert(orderPO);
        Integer id = orderPO.getId();
        orderProjectPO.setOrderId(id + "");

        orderProjectPOMapper.insert(orderProjectPO);
    }
```

- `OrderPOMapper.xml`

```xml
  <insert id="insert" useGeneratedKeys="true" keyProperty="id" parameterType="com.atguigu.crowd.entity.po.OrderPO" >
    insert into t_order (id, address_id, order_name, 
      pay_order_num, order_amount, invoice, 
      invoice_title, order_remark)
    values (#{id,jdbcType=INTEGER}, #{addressId,jdbcType=VARCHAR}, #{orderName,jdbcType=VARCHAR}, 
      #{payOrderNum,jdbcType=VARCHAR}, #{orderAmount,jdbcType=DOUBLE}, #{invoice,jdbcType=VARCHAR}, 
      #{invoiceTitle,jdbcType=VARCHAR}, #{orderRemark,jdbcType=VARCHAR})
  </insert>
```