# Spring事务测试

|--- | 外层无事务，新建事务| 外层无事务，非事务运行 | 外层无事务，抛异常|
|--- | --- | --- | --- |
|外层有事务，加入 | REQUIRED| SUPPORTS | MANADATORY|
|外层有事务，挂起外层|REQUIRED_NEW|NOT_SUPPORTED|-|
|外层有事务，抛异常|-|NEVER|-|
|外层有事务，嵌套事务运行|NESTED|-|-|