#redis
## 介绍
redis 是一个开源的内存存储，常被用于数据存储、缓存、事件通道。
redis提供了一些数据存储结构 其中包括：strings、hashes、lists、sets、sorted sets（可以进行范围查询）
、bitmaps（位图）, hyperloglogs（超日志）, geospatial indexes（地理索引）, and streams（流）.
redis本身良好支持集群扩展、lua脚本、LRU驱逐策略、事物、以及不同层级的磁盘持久、并通过Redis Sentinel提供高可用性，并通过Redis Cluster自动分区。
## 特性
**1. Transactions**  
**2. Pub/Sub**  
**3. Lua scripting**  
**4. Keys with a limited time-to-live**  
**5. LRU eviction of keys**  
**6. Automatic failover**


##01 | 基本架构：一个键值数据库包含什么？  
+ **数据结构**
+ **基本的操作 如：增删改查**
+ **基本内部结构**
![base_struct](https://static001.geekbang.org/resource/image/ec/d5/ec18bf4b8afef2fa8b99af252d95a2d5.jpg)

#### 采用什么访问模式？
+ 动态库
+ socket 网络通信（redis采用）
#### 如何定位键值对的位置？
采用索引 redis采用hash表索引
#### 持久化
- 一种方式是，对于每一个键值对都进行落盘保存，这虽然让数据更加可靠，但是因为每次都要写盘会造成密集的io操作，导致性能下降。  
- 另一种方式是，周期性的将内存种的键值对保存到磁盘上，这样可以避免频繁磁盘操作带来的性能影响，但是会造成数据丢失的风险。

#### simple KV 到 redis
![compare](https://static001.geekbang.org/resource/image/30/44/30e0e0eb0b475e6082dd14e63c13ed44.jpg)

##02 ｜数据结构：快速的Redis有哪些慢操作
redis解决hash的方式是链表、rehash（渐进式hash 每处理一份请求顺带着将索引位置的所有entries拷贝到hash表2中 不阻塞redis线程，使得线程可以处理其它请求）
+ redis 的基本数据类型：
+ String-简单动态字符串  
+ List - 双向链表、压缩列表   
+ Hash - 哈希表、压缩列表
+ Set - 哈希表、整数数组
+ SortedSet - 压缩列表、跳表
+ stream
![base_struct](https://static001.geekbang.org/resource/image/82/01/8219f7yy651e566d47cc9f661b399f01.jpg)
  > 压缩列表 类似与一个数组 与数组不同的是表头有三个字段zlbytes、zltail、zlen分别表示列表长度、列表偏移量以及列表中entry数量，在表尾还有一个zlend表示结束
  ![zList](https://static001.geekbang.org/resource/image/95/a0/9587e483f6ea82f560ff10484aaca4a0.jpg)
  > 跳表 跳表在链表的基础上增加了多级索引、通过索引位置的几个跳转，实现数据的快速定位.
  ![zTable](https://static001.geekbang.org/resource/image/1e/b4/1eca7135d38de2yy16681c2bbc4f3fb4.jpg)
  
#### 数据查找的时间复杂度
![Time_Complex](https://static001.geekbang.org/resource/image/fb/f0/fb7e3612ddee8a0ea49b7c40673a0cf0.jpg)