package com.nizouba.service.supports;

import com.nizouba.TxApplication;
import com.nizouba.domain.po.TxUser;
import com.nizouba.mapper.TxUserMapper;
import com.nizouba.service.UserService1;
import com.nizouba.service.UserService2;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * supports:支持当前事务，如果当前没有事务，就以非事务方式执行。
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("supports")
@SpringBootTest(classes = TxApplication.class,webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class NoTxCallTx {

	@Autowired
	private TxUserMapper txUserMapper;

	@Autowired
	private UserService2 userService2;


	/**
	 * 外层无事务，内层也没有事务
	 */
	@Test
	public void testTx1() {

		System.out.println("小丽来了");
		userService2.insert(new TxUser("小丽"));
		throw new RuntimeException("test外层异常");
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
