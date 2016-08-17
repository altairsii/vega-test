/** 
 * Project Name:vega_test 
 * File Name:MethodObjectTest.java 
 * Package Name:com.wyb.myself 
 * Date:2016年8月17日下午5:07:35 
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package com.wyb.myself.test;

import java.beans.MethodDescriptor;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wyb.myself.model.MethodHandleModelTest;

/**
 * ClassName:MethodObjectTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年8月17日 下午5:07:35 <br/>
 * 
 * @author wangyongbing
 * @version
 * @since JDK 1.6
 * @see
 */
public class MethodObjectTest
{

	static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Test
	public void methodHandleTest()
	{
		MethodHandle mh = null;
		MethodHandle mh1 = null;
		MethodType mt = MethodType.methodType(void.class);// 1.返回参数类型 2.传入参数类型列表
		MethodType mt1 = MethodType.methodType(void.class, String.class);
		MethodHandles.Lookup lk = MethodHandles.lookup();
		MethodHandleModelTest mhmt = new MethodHandleModelTest();
		try
		{
			mh = lk.findVirtual(MethodHandleModelTest.class, "sayHello", mt);
			mh1 = lk.findVirtual(MethodHandleModelTest.class, "sayHello", mt1);
			mh.invokeExact(mhmt);
			mh1.invokeExact(mhmt, "wyb");
		} catch (NoSuchMethodException | IllegalAccessException e)
		{
			e.printStackTrace();
		} catch (Throwable e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
