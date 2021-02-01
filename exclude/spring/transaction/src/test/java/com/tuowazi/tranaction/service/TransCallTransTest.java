package com.tuowazi.demo.spring.transaction.src.test.java.com.tuowazi.tranaction.service;

import com.tuowazi.tranaction.mapper.UserMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 外层无事务
 *
 * @author zhangweixiao - 19-3-28
 */
@Log4j2
public class TransCallTransTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TransCallTransService transCallTransService;

    @Test
    public void requiredTransTest() {
        transCallTransService.callRequired();
        assertEqual(userMapper.selectAll().size(), 1);

    }

    @Test
    public void requiredNewTransTest() {
        transCallTransService.callRequiredNew();
        assertEqual(userMapper.selectAll().size(), 1);
    }

    @Test
    public void nestedTransTest() {
        transCallTransService.callNested();
        assertEqual(userMapper.selectAll().size(), 1);
    }

    @Test
    public void supportsTransTest() {
        transCallTransService.callSupports();
        assertEqual(userMapper.selectAll().size(), 1);
    }

    @Test
    public void notSupportedTransTest() {
        transCallTransService.callNotSupported();
        assertEqual(userMapper.selectAll().size(), 1);
    }

    @Test
    public void neverTransTest() {
        try {
            transCallTransService.callNever();
        }catch (Exception e){
            log.error("外层有事务,never抛出异常");
        }

        assertEqual(userMapper.selectAll().size(), 0);
    }

    @Test
    public void mandatoryTransTest() {
        transCallTransService.callMandatory();
        assertEqual(userMapper.selectAll().size(), 1);
    }

    @After
    public void after() {
        userMapper.deleteAll();
    }

}
