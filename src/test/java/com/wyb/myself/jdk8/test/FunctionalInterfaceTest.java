/** 
 * Project Name:vega_test 
 * File Name:FunctionalInterfaceTest.java 
 * Package Name:com.wyb.myself.jdk8.test 
 * Date:2016年8月19日上午10:23:24 
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package com.wyb.myself.jdk8.test;

/**
 * ClassName:FunctionalInterfaceTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年8月19日 上午10:23:24 <br/>
 * 
 * @author wangyongbing
 * @version
 * @since JDK 1.6
 * @see
 */
@FunctionalInterface
public interface FunctionalInterfaceTest
{
	public default void run()
	{
		System.out.println("this is FunctionInterfaceTest.");
	}

	public boolean isTest();

	public static String getName()
	{
		System.out.println("you name is ...");
		return "";
	}
}
