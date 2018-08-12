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
 * nested:如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("nested")
@SpringBootTest(classes = TxApplication.class,webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class NoTxCallTx {

	@Autowired
	private TxUserMapper txUserMapper;

	@Autowired
	private UserService2 userService2;


	/**
	 * 新建事务，数据库有数据
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
