# Spring事务测试

|--- | 外层无事务，新建事务| 外层无事务，非事务运行 | 外层无事务，抛异常|
|--- | --- | --- | --- |
|外层有事务，加入 | REQUIRED| SUPPORTS | MANADATORY|
|外层有事务，挂起外层|REQUIRED_NEW|NOT_SUPPORTED|-|
|外层有事务，抛异常|-|NEVER|-|
|外层有事务，嵌套事务运行|NESTED|-|-|


Required等只是事物传播级别,真正建立的事务都是一样的,符合ACID原则.

## 日志

看控制台或者日志文件,主要是`org.springframework.jdbc.datasource.DataSourceTransactionManager`
打印的日志.

## 外层无事务

test方法均没有事务,被调用方法有事务

## 外层有事务

参考具体隔离级别的方法


## 异常回滚传播

参考日志,下面是nested异常被捕获的情况

```
2019-03-28 14:17:29 [org.springframework.jdbc.datasource.DataSourceTransactionManager]-[DEBUG] - Creating new transaction with name [com.tuowazi.tranaction.service.exception.NestedTransException.catchException]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT; ''
2019-03-28 14:17:29 [com.zaxxer.hikari.HikariDataSource]-[INFO] - HikariPool-1 - Starting...
2019-03-28 14:17:29 [com.zaxxer.hikari.HikariDataSource]-[INFO] - HikariPool-1 - Start completed.
2019-03-28 14:17:29 [org.springframework.jdbc.datasource.DataSourceTransactionManager]-[DEBUG] - Acquired Connection [HikariProxyConnection@626941486 wrapping com.mysql.jdbc.JDBC4Connection@12abdfb] for JDBC transaction
2019-03-28 14:17:29 [org.springframework.jdbc.datasource.DataSourceTransactionManager]-[DEBUG] - Switching JDBC Connection [HikariProxyConnection@626941486 wrapping com.mysql.jdbc.JDBC4Connection@12abdfb] to manual commit
2019-03-28 14:17:29 [com.tuowazi.tranaction.service.interceptor.MyBatisLogInterceptor]-[WARN] - com.tuowazi.tranaction.mapper.UserMapper.insert:insert into tx_user (username) values( 'john' )
2019-03-28 14:17:29 [org.springframework.jdbc.datasource.DataSourceTransactionManager]-[DEBUG] - Creating nested transaction with name [com.tuowazi.tranaction.service.trans.NestedTrans.throwException]
2019-03-28 14:17:29 [com.tuowazi.tranaction.service.interceptor.MyBatisLogInterceptor]-[WARN] - com.tuowazi.tranaction.mapper.UserMapper.insert:insert into tx_user (username) values( 'bob' )
2019-03-28 14:17:29 [org.springframework.jdbc.datasource.DataSourceTransactionManager]-[DEBUG] - Rolling back transaction to savepoint
2019-03-28 14:17:29 [com.tuowazi.tranaction.service.exception.NestedTransException]-[ERROR] - catch exception
2019-03-28 14:17:29 [org.springframework.jdbc.datasource.DataSourceTransactionManager]-[DEBUG] - Initiating transaction commit
2019-03-28 14:17:29 [org.springframework.jdbc.datasource.DataSourceTransactionManager]-[DEBUG] - Committing JDBC transaction on Connection [HikariProxyConnection@626941486 wrapping com.mysql.jdbc.JDBC4Connection@12abdfb]
2019-03-28 14:17:29 [org.springframework.jdbc.datasource.DataSourceTransactionManager]-[DEBUG] - Releasing JDBC Connection [HikariProxyConnection@626941486 wrapping com.mysql.jdbc.JDBC4Connection@12abdfb] after transaction
```