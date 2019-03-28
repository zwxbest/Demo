package com.tuowazi.tranaction.service.required.impl;

/**
 * @author zhangweixiao - 19-3-28
 */
public interface TransService {


    void trans();

    /**
     * 外层无事务
     */
    void nonTrans();

    /**
     * 有事务
     */
    void requiredTrans();

    void requiredNewTrans();

    void nestedTrans();

    void supportsTrans();

    void notSupportedTrans();

    void neverTrans();

    void manadatoryTrans();

}
