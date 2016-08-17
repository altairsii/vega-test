/** 
 * Project Name:vega_test 
 * File Name:WebSocketServer.java 
 * Package Name:com.wyb.myself.websocket 
 * Date:2016年8月21日上午11:29:09 
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package com.wyb.myself.websocket;

import org.junit.Test;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * ClassName:WebSocketServer <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年8月21日 上午11:29:09 <br/>
 * 
 * @author wangyongbing
 * @version
 * @since JDK 1.8
 * @see
 */
public class WebSocketServer
{
	public void run(int port)
	{
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		ServerBootstrap b = new ServerBootstrap();
		b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>()
		{
			@Override
			protected void initChannel(SocketChannel ch) throws Exception
			{
				ChannelPipeline pipeLine = ch.pipeline();
				pipeLine.addLast("http-codec", new HttpServerCodec());
				pipeLine.addLast("aggregator", new HttpObjectAggregator(65536));
				pipeLine.addLast("http-chunked", new ChunkedWriteHandler());
				pipeLine.addLast("", new WebSocketServerHandler());
			}
		});
		try
		{
			Channel ch = b.bind(port).sync().channel();
			System.out.println("Web socket server started at port " + port + ".");

			ch.closeFuture().sync();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		} finally
		{
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}

	}

	@Test
	public void webSocketServerTest()
	{
		new WebSocketServer().run(8070);
	}
}
