package com.tuowazi.tranaction.service;

import com.tuowazi.tranaction.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 外层无事务
 *
 * @author zhangweixiao - 19-3-28
 */
@Service
public class TransServiceImpl implements TransService {

    @Autowired
    private UserMapper txUserMapper;


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void requiredTrans() {
        txUserMapper.insert("marry");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void requiredNewTrans() {
        txUserMapper.insert("marry");
    }

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void nestedTrans() {
        txUserMapper.insert("marry");
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void supportsTrans() {
        txUserMapper.insert("marry");
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public void notSupportedTrans() {
        txUserMapper.insert("marry");
    }

    @Transactional(propagation = Propagation.NEVER)
    @Override
    public void neverTrans() {
        txUserMapper.insert("marry");
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void mandatoryTrans() {
        txUserMapper.insert("marry");
    }
}
