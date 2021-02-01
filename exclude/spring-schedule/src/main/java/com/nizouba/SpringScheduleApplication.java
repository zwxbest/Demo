package com.nizouba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@EnableScheduling
@SpringBootApplication
public class SpringScheduleApplication {

	private AtomicInteger number=new AtomicInteger();
	private AtomicBoolean firstTime=new AtomicBoolean(true);

	public static void main(String[] args) {
		SpringApplication.run(SpringScheduleApplication.class, args);
	}

//	https://unmi.cc/understand-spring-schedule-fixedrate-fixeddelay/#more-8252
	@Bean
	public TaskScheduler taskScheduler()
	{
		ThreadPoolTaskScheduler taskScheduler=new ThreadPoolTaskScheduler();
		taskScheduler.setPoolSize(5);
		return taskScheduler;
	}

//	@Scheduled(fixedRate = 5000)
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
		LocalTime end=LocalTime.now();
		System.out.println(Thread.currentThread()+" end "+number.get()+" @,seconds cost "+ ChronoUnit.SECONDS.between(start,end)+"s");

	}
//	@Scheduled(fixedRate = 5000)
	@Scheduled(fixedDelay = 5000)
	public void job2()
	{
		LocalTime start=LocalTime.now();
		System.out.println(Thread.currentThread()+" start "+number.incrementAndGet()+"@ "+start);
		if(firstTime.getAndSet(false))
		{
			try {
				Thread.sleep(15000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		LocalTime end=LocalTime.now();
		System.out.println(Thread.currentThread()+" end "+number.get()+" @,seconds cost "+ ChronoUnit.SECONDS.between(start,end)+"s");

	}




}
