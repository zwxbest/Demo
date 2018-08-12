package com.nizouba.service.required_new.impl;

import com.nizouba.domain.po.TxUser;
import com.nizouba.mapper.TxUserMapper;
import com.nizouba.service.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zwxbest on 2018/8/11.
 */
@Profile(value = "required_new")
@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class UserService2Impl implements UserService2 {

    @Autowired
    private TxUserMapper txUserMapper;

    public void insert(TxUser user)
    {
        txUserMapper.insert(user);
    }

    @Override
    public void insertException(TxUser user) {
        txUserMapper.insert(user);
        throw new RuntimeException("UserService2的insertException（）抛出异常");
    }

}
