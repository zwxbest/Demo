package com.nizouba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@EnableScheduling
@SpringBootApplication
public class SpringScheduleApplication {

	private AtomicInteger number=new AtomicInteger();
	public static void main(String[] args) {
		SpringApplication.run(SpringScheduleApplication.class, args);
	}

	@Bean
	public TaskScheduler taskScheduler()
	{
		ThreadPoolTaskScheduler taskScheduler=new ThreadPoolTaskScheduler();
		taskScheduler.setPoolSize(5);
		return taskScheduler;
	}

	public void job()
	{
		LocalTime start=LocalTime.now();
		System.out.println(Thread.currentThread()+" start "+number.incrementAndGet()+"@ "+start);
		try {
			Thread.sleep(ThreadLocalRandom.current().nextInt(15)*1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

	}




}
