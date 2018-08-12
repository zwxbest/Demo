package com.nizouba.service.not_supported;

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
 * 外层有事务，挂起外层，内层无事务，怎么都不会影响内层
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("not_supported")
@SpringBootTest(classes = TxApplication.class,webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TxCallOtherClassTx {

	@Autowired
	private TxUserMapper txUserMapper;

	@Autowired
	private UserService1 userService1;

	@Test
	public void otherClassInsertInInsertWithInnnerException() {

		System.out.println("小丽来了");
		userService1.otherClassInsertInInsertWithInnnerException(new TxUser("小丽"));
	}


	/**
	 * 和required一样，数据库无数据
	 *  Participating in existing transaction
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
