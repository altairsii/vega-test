/** 
 * Project Name:vega_test 
 * File Name:AioTtest.java 
 * Package Name:com.wyb.myself.nio.test 
 * Date:2016年8月21日下午12:40:01 
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved. 
 * 
 */  
  
package com.wyb.myself.nio.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;

import org.junit.Test;

/** 
 * ClassName:AioTtest <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年8月21日 下午12:40:01 <br/> 
 * @author   wangyongbing 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
public class AioTtest
{

	@Test
	public void aioTest(){
		try
		{
			AsynchronousServerSocketChannel async = AsynchronousServerSocketChannel.open();
			async.bind(new InetSocketAddress(8071));
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
  
