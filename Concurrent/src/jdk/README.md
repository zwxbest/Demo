### JDK并发包
1. BlcokingQueue

队列为空时进行等待，有新的消息进入队列后，自动唤醒

插入元素用offer和put，对于array，队列满了offer返回false，put等待。
对于link，offer永远返回true，put永远成功。

取出用poll和take，如果空了，take等待


