package com.tuowazi.tranaction.service.required_new;

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
 * mandatory:新建事务，如果当前存在事务，把当前事务挂起。
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("required_new")
@SpringBootTest(classes = TxApplication.class,webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class NoTxCallTx {

	@Autowired
	private TxUserMapper txUserMapper;

	@Autowired
	private UserService2 userService2;


	/**
	 * 当前无事务，新建
	 *  Creating new transaction with name
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
