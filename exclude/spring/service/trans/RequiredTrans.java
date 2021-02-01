package com.tuowazi.demo.spring.service.trans;

import com.tuowazi.tranaction.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhangweixiao - 19-3-28
 */
@Service
@Transactional
public class RequiredTrans {

    @Autowired
    private UserMapper userMapper;

    public void throwException(String name) {

        userMapper.insert(name);
        throw new RuntimeException("");

    }

    public void noException(String name) {
        userMapper.insert(name);

    }
}
