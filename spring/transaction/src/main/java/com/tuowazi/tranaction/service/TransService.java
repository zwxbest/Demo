package com.tuowazi.tranaction.service;

/**
 * @author zhangweixiao - 19-3-28
 */
public interface TransService {

    /**
     * 有事务
     */
    void requiredTrans();

    void requiredNewTrans();

    void nestedTrans();

    void supportsTrans();

    void notSupportedTrans();

    void neverTrans();

    void mandatoryTrans();

}
