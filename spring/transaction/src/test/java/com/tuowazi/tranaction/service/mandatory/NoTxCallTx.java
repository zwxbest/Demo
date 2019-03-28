package com.tuowazi.tranaction.service.mandatory;

import com.tuowazi.tranaction.TxApplication;
import com.tuowazi.tranaction.domain.po.TxUser;
import com.tuowazi.tranaction.mapper.TxUserMapper;
import com.tuowazi.tranaction.service.UserService2;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * mandatory:使用当前的事务，如果当前没有事务，就抛出异常。
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("mandatory")
@SpringBootTest(classes = TxApplication.class,webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class NoTxCallTx {

	@Autowired
	private TxUserMapper txUserMapper;

	@Autowired
	private UserService2 userService2;


	/**
	 * 当前无事务，抛出异常
	 * No existing transaction found for transaction marked with propagation 'mandatory'
	 */
	@Test
	public void testTx1() {

		System.out.println("小丽来了");
		userService2.insert(new TxUser("小丽"));
	}


	/**
	 * 数据库还原
	 */
	@After
	public void restoreDb()
	{
		//小丽正常插入
		List<TxUser> allUsers = txUserMapper.select();
		allUsers.stream().forEach(System.out::println);
		txUserMapper.delete();
	}

}
