## Java核心技术

> 本代码库是将```Java```开发中常用的一些技术汇总并提供封装，旨在为大家提供一个清晰详细的学习教程和开箱即用，侧重点更倾向编写Java核心内容。

**Hello, Java Core！**

首先说明，这只是Java核心技术中的部分内容，后期可能会陆续补充。

**阅读建议**

此代码库属于实战型而不是理论讲解，每一模块都有相关常用技术的封装、对比和文档说明，建议使用前先学习了解并运行代码，如果有更好的方式也可以添加进来或修改代码实现。

### 一、数据结构与算法模块 [data-structure-algorithm]

- 对常用数据结构与算法进行归纳总结

### 二、公共服务模块 [common-server]

- json解析对比：对Jackson、Gson、Fastjson三种json解析方式对比，选择您所需要的方式

### 三、Java核心模块 [java-core]

- 对集合、多线程、IO、JVM和JDk8新特性等进行归纳整理

### 四、定时任务服务模块 [cron-server]

- Timer
- 线程的等待来实现
- ScheduledExecutorService
- Quartz
- SpringTask @Scheduled
- XXL-Job
- Elastic-Job

### 五、设计模式模块 [design-pattern]

- 创建型模式
- 结构型模式
- 行为型模式

### 六、文件服务模块 [file-server]

- Local
- SFTP
- HDFS

### 七、日志服务模块 [log-server]

- Slf4j (适配器，日志实现门面)
- JDKLog
- Log4j
- Log4j2
- LogBack

### 八、中间件模块 [middleware]

#### 1、缓存服务模块 [cache-server] 

- Ehcache
- Redis
- Memcached

#### 2、消息队列服务模块 [mq-server]

- Kafka
- RabbitMQ
- RocketMQ
- ZeroMQ
- ActiveMQ

#### 3、搜索服务模块 [search-server]

- Lucene
- Solr
- ElasticSearch

#### 4、数据库中间件服务模块 [sql-server]

- MyCat
- ShardingSphere

### 九、Spring家族模块 [spring-all]

- Spring
- SpringMVC
- SpringSecurity
- SpringData
- SpringBoot
- SpringCloud

### 十、单点登录模块 [sso-server]

- 基于Session实现
- 基于Token实现

### 十一、工作流服务模块 [workflow-server]

- 基于Activiti实现
- 基于Flowable实现

### 十二、大数据模块 [big-data-server]

- Hadoop
- Flink

---