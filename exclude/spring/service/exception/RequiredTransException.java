package com.tuowazi.demo.spring.service.exception;

import com.tuowazi.tranaction.mapper.UserMapper;
import com.tuowazi.tranaction.service.trans.RequiredTrans;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 不同传播级别出现异常以及是否捕获异常的情况
 * @author zhangweixiao - 19-3-28
 */
@Service
@Log4j2
public class RequiredTransException {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RequiredTrans requiredTrans;

    @Transactional
    public void requireCatchException(){
        userMapper.insert("john");
        try {
            requiredTrans.throwException("bob");
        }catch (Exception e){
            log.error("catch exception");
        }

    }

    @Transactional
    public void requireNotCatchException(){
        userMapper.insert("john");
        requiredTrans.throwException("bob");
    }


}
