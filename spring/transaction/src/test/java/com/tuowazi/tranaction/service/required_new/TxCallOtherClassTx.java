package com.tuowazi.tranaction.service.required_new;

import com.tuowazi.tranaction.TxApplication;
import com.tuowazi.tranaction.domain.po.TxUser;
import com.tuowazi.tranaction.mapper.TxUserMapper;
import com.tuowazi.tranaction.service.UserService1;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * 当前有事务，挂起
 *Suspending current transaction, creating new transaction with name
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("required_new")
@SpringBootTest(classes = TxApplication.class,webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TxCallOtherClassTx {

	@Autowired
	private TxUserMapper txUserMapper;

	@Autowired
	private UserService1 userService1;

	/**
	 * 内层1 rollnback，内层2不rollback，外层rollback，数据库是小丽的姐姐
	 */
	@Test
	public void otherClassInsertInInsertWithInnnerException() {

		System.out.println("小丽来了");
		userService1.otherClassInsertInInsertWithInnnerException(new TxUser("小丽"));
	}


	/**
	 * 外层rollback，内层不rollback，数据库是小丽的姐姐和妹妹
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
