package com.nizouba.service.nested.impl;

import com.nizouba.domain.po.TxUser;
import com.nizouba.mapper.TxUserMapper;
import com.nizouba.service.UserService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zwxbest on 2018/8/12.
 */
@Profile(value = "nested")
@Transactional(propagation = Propagation.NESTED)
@Service
public class UserService3Impl implements UserService3 {

    @Autowired
    private TxUserMapper txUserMapper;
    @Override
    public void insert(TxUser user) {
        txUserMapper.insert(user);
    }
}
