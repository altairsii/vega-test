/** 
 * Project Name:vega_test 
 * File Name:MethodHandleModelTest.java 
 * Package Name:com.wyb.myself.model 
 * Date:2016年8月17日下午5:09:38 
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package com.wyb.myself.model;

import java.io.Serializable;

/**
 * ClassName:MethodHandleModelTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年8月17日 下午5:09:38 <br/>
 * 
 * @author wangyongbing
 * @version
 * @since JDK 1.6
 * @see
 */
public class MethodHandleModelTest implements Serializable
{
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @author wangyongbing
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String name;

	public void sayHello(String name)
	{
		System.out.println("hi," + name);
	}

	public void sayHello()
	{
		sayHello("");
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
