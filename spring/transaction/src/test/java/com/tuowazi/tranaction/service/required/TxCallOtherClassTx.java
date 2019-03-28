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
 * 事务方法调用另外一个Service的事务方法
 *  Participating in existing transaction
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("required")
@SpringBootTest(classes = TxApplication.class,webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TxCallOtherClassTx {

	@Autowired
	private TxUserMapper txUserMapper;

	@Autowired
	private UserService1 userService1;

	@Autowired
	private UserService2 userService2;


	/**
	 * required：如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
	 *
	 * 数据库没有插入数据
	 */
	@Test
	public void otherClassInsertInInsertWithInnnerException() {

		System.out.println("小丽来了");
		userService1.otherClassInsertInInsertWithInnnerException(new TxUser("小丽"));
	}

	/**
	 * required：如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
	 * 数据库没有插入数据
	 */
	@Test
	public void otherClassInsertInInsertWithOutterException() {

		System.out.println("小丽来了");
		userService1.otherClassInsertInInsertWithOutterException(new TxUser("小丽"));
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
