package com.nizouba.service.supports;

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
@ActiveProfiles("supports")
@SpringBootTest(classes = TxApplication.class,webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TxCallSameClassTx {

	@Autowired
	private TxUserMapper txUserMapper;

	@Autowired
	private UserService1 userService1;

	@Autowired
	private UserService2 userService2;


	/**
	 * 和required一样，数据库无数据
	 */
	@Test
	public void sameClassInsertInInsertWithInsideException() {

		System.out.println("小丽来了");
		userService1.sameClassInsertInInsertWithInsideException(new TxUser("小丽"));
	}

	/**
	 * 和required一样，数据库无数据
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
		if(allUsers.size()==0)
		{
			System.out.println("数据库中没有数据");
		}
		allUsers.stream().forEach(System.out::println);
		txUserMapper.delete();
	}

}
