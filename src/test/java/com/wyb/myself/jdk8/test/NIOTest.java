/** 
 * Project Name:vega_test 
 * File Name:NIOTest.java 
 * Package Name:com.wyb.myself.jdk8.test 
 * Date:2016年8月19日下午12:46:32 
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package com.wyb.myself.jdk8.test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

/**
 * ClassName:NIOTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年8月19日 下午12:46:32 <br/>
 * 
 * @author wangyongbing
 * @version
 * @since JDK 1.8
 * @see
 */
public class NIOTest
{

	@Test
	public void nioTest()
	{
		try
		{
			Files.lines(new File("E:\\workspace\\workerspace\\nettyserver\\pom.xml").toPath()).forEach(System.out::println);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
