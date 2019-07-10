## 实验目的

建立jhipster-labs的目的是希望通过实验的方式测试jhipster生成的microservices中的component，依次达到熟悉jhipster microservices 各component的目的。

## 实验主题

jhipster生成的服务中与jhipster-framework依赖相关实验：

- [x] 实验01：基于jhipster-framework构建Springboot应用

jihipster生成的gateway中spring cloud相关实验：

- [x] 实验01：jhipster生成的gateway中zuul组件的实验
- [x] 实验02：jhipster生成的gateway中hystrix组件的实验
- [x] 实验03：jhipster生成的gateway中eureka组件的实验
- [x] 实验04：jhipster生成的gateway中feign组件的实验
- [x] 实验05：jhipster生成的gateway中ribbon组件的实验

jihipster生成的gateway中spring相关实验：

- [x] 实验01：@ConditionalOnProperty使用

- [x] 实验02：springboot单元测试与集成测试实验

- [x] 实验03：spring web 及 webmvc相关使用

- [x] 实验04：spring data jpa & hibernate相关

- [x] 实验05：安全审计

- [x] 实验06：异步任务

  

jhipster生成的gateway中security相关实验：

- [ ] 实验01：uaa实验

maven相关实现：

- [x] maven多环境配置
- [x] maven生命周期与插件

其他组件相关实验：

- [ ] 实验01：基于logback和slf4j日志组件的使用
- [ ] 实验02：ddd、spring data jpa、spring mvc rest

## 实验列表

### 面向jhipster-framework的实验

#### 实验01：基于jhipster-framework构建SpringBoot应用

代码仓库：jhipster-project

实验过程简述:

（1）创建maven工程

（2）添加jhipster-dependencies依赖管理

（3）添加jhipster-framework依赖

实验分析：

（1）通过分析jhipster-framework依赖可知，该framework包含了jhipster生成的SpringBoot工程所需的通用依赖。

（2）jhipster-framework的工程结构如下：

io.github.jhipster

​	|-- async

​	|-- config

​		|-- apidoc     # Springfox configuraiton to generate Swagger documentation.

​		|-- h2            #  H2 configuration helper.

​		|-- info

​		|-- liquibase 

​                |-- locale

​		|-- logging    # Utility methods to add appenders to a LoggerContext.

​		|-- metric     # micrometer related

​		|-- JhipsterConstants.java # Spring profiles Constants

​		|-- JHipsterDefaults.java    # Jhipster appliaction default configuration

​		|-- JHipsterProperties.java # Properties specific to JHipster

​	|-- domain/util   # Utilities for JHipster domain objects

​	|-- security  # Security classes and helpers used in JHipster applications

​	|-- service   # Service related class

### 面向Spring的实验

#### 实验01：@ConditionalOnProperty使用

实验代码：spring-project

过程：略

总结：

（1）使用该注解可以根据application.yml中配置来选择使用启动@configuration

#### 实验02：springboot单元测试与集成测试实验

实验代码：spring-project

实验过程：

（1）引入spring-boot-starter-test依赖

（2）编写service代码逻辑

（3）编写service代码集成测试

（4）编写controller代码逻辑

（5）编写controller接口测试

总结：

（1）测试分为：1.单元测试，如测试某一个方法或者工具类接口；2.集成测试，如调用毛某一个服务测试；3.接口测试，如controller接口测试

（2）测试是保障程序健壮性的重要手段之一

#### 实验03：spring web 及 webmvc相关使用

实验代码：spring-mvc

实验过程：

（1）添加jhipster-framework和spring-boot-starter-undertow依赖

（2）添加WebConfigurer类

​	该类的作用包含两个：1.初始化缓存http header拦截器；2.初始化h2-console

（3）添加LocaleConfiguration类

​	该类实现了WebMvcConfigurer。提供如下两个作用：

​	a.创建一个LocaleResovler Bean

​	b.添加LocaleChangeInterceptor到web容器中

（4）添加DateTimeFormatConfiguration类

​	该类主要是向register中注册一个ISO格式的解析器

总结：

​	spring web主要设计到spring web应用依赖的第三方web容器

​	spring webmvc主要设计到日志格式、本地化问题

#### 实验04：spring data jpa & hibernate相关

略

#### 实验05：安全审计

代码：spring-data

实验过程：

（1）添加spring-boot-stater-data-jpa和spring-boot-stater-security依赖

（2）添加AbstractAuditingEntity类

​	用于对某些表进行安全审计，用于记录创建时间，创建人，更新时间，更新人。

（3）添加PersistentAuditEvent类

​	持久化被Spring Boot Actuator管理的AuditEvent，记录用户的行为。包含如下内容：事件Id，事件人，事件时间，事件类型，事件详情内容

（4）使用AbstractAuditingEntity实现实体的审计功能

​	参见代码中的User实体

​	

### 面向SpringCloud的实验

#### 实验01：jhipster生成的gateway中zuul组件的实验

实验代码：spring-cloud-zuul

实验过程：

（1）引入spring-cloud-starter-netflix-zuul

（2）添加限流拦截器

RateLimitingFilter是基于用户请求的拦截器，可用于限定用户在规定时间的请求数量

由于拦截器需要基于用户ID或者用户的IP地址进行限流，因此需要获取到用户ID

当用户认证成功后，用户的ID会存放于SecurityContext中，故而基于用户请求的限流工具需要依赖于spring-boot-starter-security来获取用户信息

（3）添加访问控制拦截器

AccessControlFilter用于限制对后端微服务端点的访问

通过在application-dev.yml中的配置信息驱动AccessControlFilter对后端微服务的访问控制。例如：

```
authorized-microservices-endpoints：
	app1: /api，/v2/api-docs
```

表示允许访问微服务app1的/api和/v2/api-docs接口

（4）添加Swagger根路径重写拦截器

SwaggerBasePathRewritingFilter用于重写后端微服务的根路径，使微服务Swagger API数据可通过Gateway进行统一管理。

（5）通过Gateway获取服务实例信息

​	操作：1.添加RouteVM，2.添加GatewayResource

​	注：在GetewayResource中的activeRoutes接口会被Spring Security保护，只能被Admin类型用户访问

总结：zuul主要提供动态路由和拦截器的功能，可与Swagger配合实现重定向微服务api地址；可与bucket4j配合使用实现限制在单位时间内对特定用户的请求进行链路操作；可实现对后端微服务的访问控制；可与Spring Security实现特定权限的用户能够获取后端服务实例信息。



#### 实验02：jhipster生成的gateway中hystrix组件的实验

实验代码：spring-cloud-zuul

功能：熔断、降级

实验流程：

（1）引入spring-cloud-starter-netflix-hystrix依赖

（2）在applicaiton.yml中配置hystrix

（3）在主类上加上@EnableCircuitBreaker

总结：

hystrix的用法主要有以下三种：

1.hystrix的常规用法，也就是当某个接口或者服务出现异常时进行降级处理

2.feign整合hystrix，使用feign进行第三方调用时可以结合hystrix的断路由一起使用

3.在项目中引入hystrix-dashboard，用于查看服务的断路器异常情况

#### 实验03：jhipster生成的gateway中eureka组件的实验

总结：

在gateway中使用eureka十分简单，只需在启动类上加入启动注解，在配置文件中配置eureka-client相关信息即可。

#### 实验04：jhipster生成的gateway中feign组件的实验

略

#### 实验05：jhipster生成的gateway中ribbon组件的实验

略

### 面向Maven的实验

#### 实验01：build模块

在build模块主要包含三个部分：（1）defaultGoal；（2）plugins；（3）pluginManagement

其中defaultGoal表示maven构建工具在默认情况下执行的命令。



#### 实验02：Maven生命周期与插件

除了坐标、依赖以及仓库之外，Maven另外两个核心概念是生命周期和插件。在有关Maven的日常使用中，命令行的输入往往就对应了生命周期，如mvn package就表示执行默认生命周期阶段package。Maven的声明周期是抽象的，其实际行为都是由插件来完成，如package阶段的任务可能是由maven-jar-plugin完成。生命周期和插件两者协同工作，密不可分。

Maven声明周期：clean、default、site

clean声明周期的目的是清理项目

default生命周期的目的是构建项目

site声明周期的目的是建立项目站点

每个生命周期都包含一些阶段（phase），这些阶段是有顺序的，并且后面的阶段依赖前面的阶段，用户和Maven最直接的交互就是调用这些生命周期阶段。以clean生命周期为例，它包含



插件与生命周期阶段的绑定

执行任务  <execution></execution>

####  实验01：uaa实验

uaa包含的许可类型：

（1）资源拥有者凭证许可类型（用户调用）

（2）客户端凭证许可类型（机器调用）



