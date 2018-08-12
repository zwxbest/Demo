package com.nizouba.service.nested;

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
 * 外层有事务，在嵌套事务内执行
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("nested")
@SpringBootTest(classes = TxApplication.class,webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TxCallOtherClassTx {

	@Autowired
	private TxUserMapper txUserMapper;

	@Autowired
	private UserService1 userService1;

	/**
	 * 内层1 rollback，外层rollback，内层2 也rolllback，
	 */
	@Test
	public void otherClassInsertInInsertWithInnnerException() {

		System.out.println("小丽来了");
		userService1.otherClassInsertInInsertWithInnnerException(new TxUser("小丽"));
	}


	/**
	 * 外层rollback，内层1，2 rollback
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
