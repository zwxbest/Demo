package com.tuowazi.tranaction.service.not_supported.impl;

import com.tuowazi.tranaction.domain.po.TxUser;
import com.tuowazi.tranaction.mapper.TxUserMapper;
import com.tuowazi.tranaction.service.UserService1;
import com.tuowazi.tranaction.service.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zwxbest on 2018/8/11.
 */
@Profile(value = "not_supported")
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class UserService1Impl implements UserService1 {

    @Autowired
    private TxUserMapper txUserMapper;

    @Autowired
    private UserService2 userService2;



    public void insert(TxUser user)
    {
        txUserMapper.insert(user);
    }

    @Override
    public void insertException(TxUser user) {
        txUserMapper.insert(user);
        throw new RuntimeException("UserService1的insertException（）抛出异常");
    }

       @Override
    public void sameClassInsertInInsertWithInsideException(TxUser user) {
        txUserMapper.insert(user);
        System.out.println("小丽的妹妹来了");
        insertException(new TxUser("小丽的妹妹"));

    }
    @Override
    public void sameClassInsertInInsertWithOutterException(TxUser user) {
        txUserMapper.insert(user);
        System.out.println("小丽的妹妹来了");
        insert(new TxUser("小丽的妹妹"));
        throw new RuntimeException("UserService1的外层异常");

    }

    @Override
    public void otherClassInsertInInsertWithInnnerException(TxUser user) {
        txUserMapper.insert(user);
        System.out.println("小丽的妹妹来了");
        userService2.insertException(new TxUser("小丽的妹妹"));
    }

    @Override
    public void otherClassInsertInInsertWithOutterException(TxUser user) {
        txUserMapper.insert(user);
        System.out.println("小丽的妹妹来了");
        userService2.insert(new TxUser("小丽的妹妹"));
        throw new RuntimeException("UserService1的外层异常");

    }

}
