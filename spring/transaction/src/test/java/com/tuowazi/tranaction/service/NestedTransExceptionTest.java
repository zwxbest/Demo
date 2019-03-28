package com.tuowazi.tranaction.service;

import com.tuowazi.tranaction.mapper.UserMapper;
import com.tuowazi.tranaction.service.exception.NestedTransException;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhangweixiao - 19-3-28
 */
@Log4j2
public class NestedTransExceptionTest extends BaseTest {

    @Autowired
    private NestedTransException nestedTransException;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        nestedTransException.catchException();
        assertEqual(userMapper.selectAll().size(),1);
    }


    @After
    public void after() {
        userMapper.deleteAll();
    }
}
