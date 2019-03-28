package com.tuowazi.tranaction.service;

import com.tuowazi.tranaction.mapper.UserMapper;
import com.tuowazi.tranaction.service.BaseTest;
import com.tuowazi.tranaction.service.TransService;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 外层无事务
 * @author zhangweixiao - 19-3-28
 */
@Log4j2
public class NoTransCallTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TransService nonTransCallService;

    @Test
    public void requiredTransTest() {
        nonTransCallService.requiredTrans();
        assertEqual(userMapper.selectAll().size(), 1);

    }

    @Test
    public void requiredNewTransTest() {
        nonTransCallService.requiredNewTrans();
        assertEqual(userMapper.selectAll().size(), 1);
    }

    @Test
    public void nestedTransTest() {
        nonTransCallService.nestedTrans();
        assertEqual(userMapper.selectAll().size(), 1);
    }

    @Test
    public void supportsTransTest() {

        nonTransCallService.supportsTrans();
        assertEqual(userMapper.selectAll().size(), 1);
    }

    @Test
    public void notSupportedTransTest() {

        nonTransCallService.notSupportedTrans();
        assertEqual(userMapper.selectAll().size(), 1);
    }

    @Test
    public void neverTransTest() {

        nonTransCallService.neverTrans();
        assertEqual(userMapper.selectAll().size(), 1);
    }

    @Test
    public void mandatoryTransTest() {
        try {
            nonTransCallService.mandatoryTrans();
        } catch (Exception e) {
            log.error("外层无事物,抛出异常");
        }
        assertEqual(userMapper.selectAll().size(), 0);
    }

    @After
    public void after(){
        userMapper.deleteAll();
    }

}
