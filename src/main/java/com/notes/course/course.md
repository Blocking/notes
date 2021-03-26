# 刺激计划

## JVM
1. JVM 基础知识、Java 字节码技术、JVM 类加载器、JVM 内存模型、JVM 启动参数详解；
2. JDK 内置命令行工具、JDK 内置图形界面工具、JDWP 简介、JMX 与相关工具；
3. 常见的 JVM GC 算法（Parallel GC/CMS GC/G1 GC）基本原理和特点；
4. 新一代 GC 算法（Java11 ZGC/Java12 Shenandoah) 和 Oracle GraalVM；
5. GC 日志解读与分析、JVM 的线程堆栈等数据分析、内存 dump 和内存分析工具；
6. fastThread 相关工具以及面临复杂问题时的几个高级工具的使用；
7. JVM 问题排查分析的常用手段、性能调优的最佳实践经验等；
8. JVM 相关的常见面试问题必知必会、全面分析。

## NIO
1. 同步/异步、阻塞/非阻塞、BIO、NIO、AIO、Reactor/Proactor；
2. ByteBuff/Acceptor/Channel/Handler、NioEventLoopGroup/EventLoop、bossGroup/workerGroup；
3. Netty 的启动和执行过程、线程模型、事件驱动、服务端和客户端的使用方式；
4. 常见的 API Gateway/HTTP Server、SEDA 原理、业务 API 网关的功能和结构；
5. Throughout/TPS/QPS、Latency/P99/P95/P90、ApacheBench/Wrk/JMeter/LoadRunner。

### 案例分析

+ 基于 Netty 和 NIO 实现高吞吐 HTTP 服务器。
+ 使用 HttpClient 实现高效的后端接口访问。
+ API 网关的典型路由策略设计和实现。
+ 使用 Wrk 工具进行 API 网关的性能压测。

### 核心要点
+ Netty 和 HttpClient 用法最佳实践。
+ API Gateway 设计，Router 设计。
+ Wrk 工具使用，性能压测，吞吐量 TPS 和延迟 P99。



