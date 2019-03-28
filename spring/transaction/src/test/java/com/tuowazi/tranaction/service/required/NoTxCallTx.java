package com.tuowazi.tranaction.service.required;

import com.tuowazi.tranaction.TxApplication;
import com.tuowazi.tranaction.domain.po.TxUser;
import com.tuowazi.tranaction.mapper.TxUserMapper;
import com.tuowazi.tranaction.service.UserService1;
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
 * 无事务方法调用事务方法
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("required")
@SpringBootTest(classes = TxApplication.class,webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class NoTxCallTx {

	@Autowired
	private TxUserMapper txUserMapper;

	@Autowired
	private UserService1 userService1;

	@Autowired
	private UserService2 userService2;


	/**
	 * required：如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
	 * 外层无事务，调用事务方法会新建一个全新的事务，详细看log，外层的异常不会影响事务。
	 *  Creating new transaction with name [UserService1Impl.insert]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT; ''
	 * 小丽插入，因为是新建的独立的事务。
	 */
	@Test
	public void testTx1() {

		System.out.println("小丽来了");
		userService1.insert(new TxUser("小丽"));
		throw new RuntimeException("外层异常");
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
