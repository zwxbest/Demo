package com.tuowazi.zookeeper.retry;

import com.tuowazi.zookeeper.ConnectionWatcher;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;
import org.slf4j.LoggerFactory;

public class ChangedActiveKeyValueStore extends ConnectionWatcher {
    private static final Charset CHARSET = Charset.forName("UTF-8");
    private static final int MAX_RETRIES = 5;
    private static final long RETRY_PERIOD_SECONDS = 5;
    private Random random=new Random();

    public void write(String path, String value) throws InterruptedException, KeeperException {
        int retries = 0;
        while (true) {
            try {
                Stat stat = zk.exists(path, false);
                if (stat == null) {
                    System.out.println("create "+ path+",data "+ value);
                    zk.create(path, value.getBytes(CHARSET), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                } else {
                    System.out.println("set data on "+ path+",data "+ value);
                    zk.setData(path, value.getBytes(CHARSET), stat.getVersion());
                }
            } catch (KeeperException.SessionExpiredException e) {
                throw e;
            } catch (KeeperException e) {
                if (retries++ == MAX_RETRIES) {
                    throw e;
                }
                System.out.println("retry !!!");
                //sleep then retry
                TimeUnit.SECONDS.sleep(RETRY_PERIOD_SECONDS);
            }
            TimeUnit.SECONDS.sleep(random.nextInt(10));
        }
    }

    public String read(String path, Watcher watch) throws KeeperException, InterruptedException {
        byte[] data = zk.getData(path, watch, null);
        return new String(data, CHARSET);
    }
}