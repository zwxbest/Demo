package com.nizouba.service.required;

import com.nizouba.TxApplication;
import com.nizouba.domain.po.TxUser;
import com.nizouba.mapper.TxUserMapper;
import com.nizouba.service.UserService1;
import com.nizouba.service.UserService2;
import com.sun.media.sound.SoftTuning;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 事务方法调用同一个Service的事务方法
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("required")
@SpringBootTest(classes = TxApplication.class,webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TxCallSameClassTx {

	@Autowired
	private TxUserMapper txUserMapper;

	@Autowired
	private UserService1 userService1;

	@Autowired
	private UserService2 userService2;


	/**
	 * required：如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
	 * 同一个方法事务调用，没有particapating加入的log日志，默认为同一个事务，不需要加入，内层异常，外层跟着回退。
	 * 数据库没有插入数据
	 */
	@Test
	public void sameClassInsertInInsertWithInsideException() {

		System.out.println("小丽来了");
		userService1.sameClassInsertInInsertWithInsideException(new TxUser("小丽"));
	}

	/**
	 * required：如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
	 * 同一个方法事务调用，没有particapating加入的log日志，默认为同一个事务，不需要加入，外层异常，内层rollback。
	 * 数据库没有插入数据
	 */
	@Test
	public void sameClassInsertInInsertWithOutterException() {

		System.out.println("小丽来了");
		userService1.sameClassInsertInInsertWithOutterException(new TxUser("小丽"));
	}

	/**
	 * 数据库还原
	 */
	@After
	public void restoreDb()
	{
		//小丽正常插入
		System.out.println("事务执行后数据库情况");
		List<TxUser> allUsers = txUserMapper.select();
		allUsers.stream().forEach(System.out::println);
		txUserMapper.delete();
	}

}
