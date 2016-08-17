/** 
 * Project Name:vega_test 
 * File Name:AIOForFuture.java 
 * Package Name:com.wyb.myself.isaio 
 * Date:2016年8月22日上午9:56:45 
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package com.wyb.myself.isaio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;

/**
 * ClassName:AIOForFuture <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年8月22日 上午9:56:45 <br/>
 * 
 * @author wangyongbing
 * @version
 * @since JDK 1.8
 * @see
 */
public class AIOForFutureTest
{

	/**
	 * aioFutureTest:(测试AIO将来式). <br/>
	 * 
	 * 如果文件读取够快，则result.isDone()会处理为false
	 * 
	 * 
	 * @author wangyongbing
	 * @since JDK 1.8
	 */
	@Test
	public void aioFutureTest()
	{
		Path file = Paths.get("C:\\Users\\wangyongbing\\Desktop\\rzrq.sql");
		try
		{
			AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);// 异步打开文件
			ByteBuffer buffer = ByteBuffer.allocate(10_000);// 读取指定长度字节

			Future<Integer> result = channel.read(buffer, 0);

			while (result.isDone())// 判断读取是否结束
			{
				System.out.println("I can do other things.");
			}

			Integer bytesRead = result.get();
			System.out.println("bytes read [" + bytesRead + "]");
		} catch (IOException | InterruptedException | ExecutionException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * aioCallBackTest:(测试AIO回调式). <br/>
	 * 
	 * 
	 * @author wangyongbing
	 * @since JDK 1.8
	 */
	@Test
	public void aioCallBackTest()
	{
		Path file = Paths.get("C:\\Users\\wangyongbing\\Desktop\\rzrq.sql");
		try
		{
			AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);
			ByteBuffer buffer = ByteBuffer.allocate(10_000);// 读取指定长度字节
			channel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>()
			{

				@Override
				public void completed(Integer result, ByteBuffer attachment)
				{
					System.out.println("Bytes read:" + result);
				}

				@Override
				public void failed(Throwable exc, ByteBuffer attachment)
				{
					System.out.println(exc.getMessage());
				}
			});
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
