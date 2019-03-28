package com.tuowazi.tranaction.service;

import com.tuowazi.tranaction.mapper.UserMapper;
import com.tuowazi.tranaction.service.exception.RequiredTransException;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.UnexpectedRollbackException;

/**
 * @author zhangweixiao - 19-3-28
 */
@Log4j2
public class RequiredTransExceptionTest extends BaseTest {

    @Autowired
    private RequiredTransException requiredTransException;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        try {
            requiredTransException.requireCatchException();

        }catch (UnexpectedRollbackException e){
            log.error("Transaction rolled back because it has been marked as rollback-only");
        }
        assertEqual(userMapper.selectAll().size(),0);

    }

    @Test
    public void test2(){
        try {
            requiredTransException.requireNotCatchException();
        }catch (Exception e){
            log.error("catch requireNotCatchException");
        }
        assertEqual(userMapper.selectAll().size(),0);

    }

    @After
    public void after() {
        userMapper.deleteAll();
    }
}
