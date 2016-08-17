/** 
 * Project Name:vega_test 
 * File Name:LambdaTest.java 
 * Package Name:com.wyb.myself.jdk8.test 
 * Date:2016年8月19日上午10:09:51 
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package com.wyb.myself.jdk8.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.junit.Test;

import com.wyb.myself.model.MethodHandleModelTest;

/**
 * ClassName:LambdaTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年8月19日 上午10:09:51 <br/>
 * 
 * @author wangyongbing
 * @version
 * @since JDK 1.6
 * @see
 */
public class LambdaTest
{
	@Test
	public void lambdaTest()
	{
		new Thread(() ->
		{
			System.out.println("this is a Thread.");
		}).run();
	}

	@Test
	public void functionalInterfaceTest()
	{
		new FunctionalInterfaceTest()
		{
			@Override
			public boolean isTest()
			{

				/**
				 * TODO Auto-generated method stub
				 */
				return false;
			}
		}.run();

		FunctionalInterfaceTest ft = () ->
		{
			return false;
		};
		ft.run();
	}

	@Test
	public void functionLambdaTest()
	{

		// 匿名内部类
		Function<Integer, String> f = new Function<Integer, String>()
		{
			@Override
			public String apply(Integer t)
			{

				return String.valueOf(t);
			}
		};

		// lambda表达式
		f = (t) -> String.valueOf(t);

		// 方法引用
		f = String::valueOf;

	}

	@Test
	public void hamTest()
	{
		List<MethodHandleModelTest> hamList = new ArrayList<>();
		List<MethodHandleModelTest> ham = new ArrayList<>();
		HamTest ht = null;
		ham.forEach((MethodHandleModelTest mt) ->
		{
			if (ht.isHam(mt))
			{
				hamList.add(mt);
				System.out.println("yes");
			}
		});
	}

	@Test
	public void streamTest()
	{
		List<String> list = new ArrayList<>();
		double d = 0;
		for (int i = 0; i < 10000; i++)
		{
			d = Math.random() * 1000;
			list.add(d + "");
		}
		long start = System.currentTimeMillis();
		int count = (int) list.stream().parallel().sorted().count();
		System.out.println("并行排序耗时：" + (System.currentTimeMillis() - start));

	}

	@Test
	public void streamTest1()
	{
		List<String> list = new ArrayList<>();
		double d = 0;
		for (int i = 0; i < 10000; i++)
		{
			d = Math.random() * 1000;
			list.add(d + "");
		}
		long start = System.currentTimeMillis();
		int count = (int) list.stream().sequential().sorted().count();
		System.out.println("串行排序耗时：" + (System.currentTimeMillis() - start));
		list.stream().filter((s) -> s.startsWith("1")).forEach(System.out::println);
	}
}
