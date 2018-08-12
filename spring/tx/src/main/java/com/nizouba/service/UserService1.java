package com.nizouba.service;

import com.nizouba.domain.po.TxUser;

/**
 * Created by zwxbest on 2018/8/11.
 */

public interface UserService1 {

    /**
     * 正常插入
     * @param user
     */
     void insert(TxUser user);

     /**
      * 抛出异常的事务
      * @param user
      */
     void insertException(TxUser user);

    /**
      * 同一个service下的事务方法调用，内层事务抛出异常，
      */
     void sameClassInsertInInsertWithInsideException(TxUser user);

    /**
     * 同一个service下的事务方法调用，外层事务抛出异常
      * @param user
      */
     void sameClassInsertInInsertWithOutterException(TxUser user);

    /**
     * 不同service，内层异常
      * @param user
      */
     void otherClassInsertInInsertWithInnnerException(TxUser user);

    /**
     * 不同service，外层异常
      * @param user
      */
     void otherClassInsertInInsertWithOutterException(TxUser user);
}
