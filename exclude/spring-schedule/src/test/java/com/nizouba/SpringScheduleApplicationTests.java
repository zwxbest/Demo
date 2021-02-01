package com.nizouba;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringScheduleApplicationTests {

	@Test
	public void contextLoads() {
		//以某个时间点为参考点，计算纳秒数，不同jvm不同，可能为复数
		System.out.println(System.nanoTime());
		//Random()随机数采用这个作为种子
	}

}
