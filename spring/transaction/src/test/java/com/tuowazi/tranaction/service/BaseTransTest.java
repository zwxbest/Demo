package com.tuowazi.tranaction.service;

import com.tuowazi.tranaction.mapper.UserMapper;
import com.tuowazi.tranaction.service.required.impl.TransService;
import org.junit.After;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhangweixiao - 19-3-28
 */
@Ignore
public class BaseTransTest extends BaseTest{

    @Autowired
    private UserMapper txUserMapper;

    @Autowired
    private TransService transService;

    /**
     * 外层无事务
     */
    protected void nonTransTest(){
        transService.nonTrans();
    }

    /**
     * 有事务
     */
    protected void requiredTransTest(){
        transService.requiredTrans();
    }

    protected void requiredNewTransTest(){
        transService.requiredNewTrans();
    }

    protected void nestedTransTest(){
        transService.nestedTrans();
    }

    protected void supportsTransTest(){
        transService.supportsTrans();
    }

    protected void notSupportedTransTest(){
        transService.notSupportedTrans();
    }

    protected void neverTransTest(){
        transService.neverTrans();
    }

    protected void manadatoryTransTest(){
        transService.manadatoryTrans();
    }

    @After
    public void after(){
        txUserMapper.deleteAll();
    }
}
