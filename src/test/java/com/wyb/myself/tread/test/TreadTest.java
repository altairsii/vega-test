/** 
 * Project Name:vega_test 
 * File Name:TreadTest.java 
 * Package Name:com.wyb.myself.tread.test 
 * Date:2016年8月26日下午7:52:58 
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package com.wyb.myself.tread.test;

import java.lang.invoke.MethodHandles;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import ch.qos.logback.core.util.SystemInfo;

/**
 * ClassName:TreadTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年8月26日 下午7:52:58 <br/>
 * 
 * @author wangyongbing
 * @version
 * @since JDK 1.8
 * @see
 */
public class TreadTest implements Runnable
{

	AtomicInteger count = new AtomicInteger(0);
	AtomicInteger count1 = new AtomicInteger(0);

	@Test
	public void treadTest()
	{
		try
		{
			ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 10l, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(100));
			executor.execute(() ->
			{
				System.out.println(count.incrementAndGet());
			});
			for (int i = 0; i < 10000; i++)
			{
				if (!executor.getQueue().offer(() ->
				{
					System.out.println("this is queue job." + count.incrementAndGet());
					
				}, 1000, TimeUnit.MILLISECONDS))
				{
					System.out.println("full");
				}
				System.out.println("over:" + count1.incrementAndGet());
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public void run()
	{

		/**
		 * TODO Auto-generated method stub
		 */

	}
}
