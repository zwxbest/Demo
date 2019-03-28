package com.tuowazi.tranaction.service;

import com.tuowazi.tranaction.mapper.UserMapper;
import com.tuowazi.tranaction.service.exception.RequiredNewTransException;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhangweixiao - 19-3-28
 */
@Log4j2
public class RequiredNewTransExceptionTest extends BaseTest {

    @Autowired
    private RequiredNewTransException requiredNewTransException;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        try {
            requiredNewTransException.outerException();
        }catch (Exception e){
            log.error("requiredNewTransException.outerException");
        }
        assertEqual(userMapper.selectAll().size(),1);
    }


    @Test
    public void test1(){
        try {
            requiredNewTransException.innerException();
        }catch (Exception e){
            log.error("requiredNewTransException.innerException");
        }
        assertEqual(userMapper.selectAll().size(),2);
    }


    @After
    public void after() {
        userMapper.deleteAll();
    }
}
