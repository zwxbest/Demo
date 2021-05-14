package com.tuowazi.zookeeper;

import com.tuowazi.zookeeper.ConnectionWatcher;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;

public class JoinGroup extends ConnectionWatcher {
    public void join(String groupName, String memberName) throws KeeperException, InterruptedException {
        String path = "/" + groupName + "/" + memberName;
        String createdPath = zk.create(path, null, Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("Created:" + createdPath);
    }

    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        JoinGroup joinGroup = new JoinGroup();
        joinGroup.connect("127.0.0.1:2181");
        joinGroup.join("test0425", "zwx");

        //stay alive until process is killed or thread is interrupted
        Thread.sleep(Long.MAX_VALUE);
    }
}