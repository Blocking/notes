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