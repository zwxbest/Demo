package com.tuowazi.demo.spring.service.exception;

import com.tuowazi.tranaction.mapper.UserMapper;
import com.tuowazi.tranaction.service.trans.RequiredNewTrans;
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
public class RequiredNewTransException {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RequiredNewTrans requiredNewTrans;

    @Autowired
    private RequiredTrans requiredTrans;

    /**
     * 外层rollback,内层不rollback
     */
    @Transactional
    public void outerException(){
        userMapper.insert("john");
        requiredNewTrans.noException("bob");
        throw new RuntimeException("");
    }

    /**
     * 内层1rollback,内层2不rollback，外层rollback
     */
    @Transactional
    public void innerException(){
        userMapper.insert("john");
        requiredTrans.noException("dick");
        try {
            requiredNewTrans.throwException("bob");
        }catch (Exception e){
            log.error("requiredNewTrans.throwException(\"bob\");");
        }

    }

}
