package com.tuowazi.tranaction.service.required.impl;

import com.tuowazi.tranaction.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhangweixiao - 19-3-28
 */
@Service
public class TransServiceImpl implements TransService{

    @Autowired
    private UserMapper txUserMapper;

    @Override
    public void trans() {
        txUserMapper.insert("mike");
    }

    @Override
    public void nonTrans() {
        txUserMapper.insert("moss");
        trans();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void requiredTrans() {
        txUserMapper.insert("marry");
        trans();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void requiredNewTrans() {
        txUserMapper.insert("marry");
        trans();
    }

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void nestedTrans() {
        txUserMapper.insert("marry");
        trans();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void supportsTrans() {
        txUserMapper.insert("marry");
        trans();
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public void notSupportedTrans() {
        txUserMapper.insert("marry");
        trans();
    }

    @Transactional(propagation = Propagation.NEVER)
    @Override
    public void neverTrans() {
        txUserMapper.insert("marry");
        trans();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void manadatoryTrans() {
        txUserMapper.insert("marry");
        trans();
    }
}
