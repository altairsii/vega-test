/** 
 * Project Name:vega_test 
 * File Name:MultiplexerTimeServer.java 
 * Package Name:com.wyb.myself.nio.test 
 * Date:2016年8月21日上午9:05:57 
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package com.wyb.myself.nio.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Set;

/**
 * ClassName:MultiplexerTimeServer <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年8月21日 上午9:05:57 <br/>
 * 
 * @author wangyongbing
 * @version
 * @since JDK 1.8
 * @see
 */
public class MultiplexerTimeServer implements Runnable
{

	private Selector selector;

	private ServerSocketChannel serverSocketChannel;

	private volatile boolean stop;

	public MultiplexerTimeServer(int port)
	{
		try
		{
			selector = Selector.open();
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("The time server is start in port :" + port);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void stop()
	{
		this.stop = true;
	}

	@Override
	public void run()
	{
		while (!stop)
		{
			try
			{
				selector.select(1000);
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				selectedKeys.forEach((SelectionKey selectionKey) ->
				{
					try
					{
						handleInput(selectionKey);
					} catch (Exception e)
					{
						if (selectionKey != null)
						{
							selectionKey.cancel();
							if (selectionKey.channel() != null)
							{
								try
								{
									selectionKey.channel().close();
								} catch (Exception e1)
								{
									e1.printStackTrace();
								}
							}
						}
						e.printStackTrace();
					}
				});
			} catch (IOException e)
			{
				e.printStackTrace();
			}

			if (selector != null)
			{
				try
				{
					selector.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}

		}

	}

	private void handleInput(SelectionKey key) throws IOException
	{
		if (key.isValid())
		{
			if (key.isAcceptable())
			{
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				SocketChannel sc = ssc.accept();
				sc.configureBlocking(false);
				sc.register(selector, SelectionKey.OP_READ);
			}

			if (key.isReadable())
			{
				SocketChannel sc = (SocketChannel) key.channel();
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(readBuffer);
				if (readBytes > 0)
				{
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes, "UTF-8");
					System.out.println("The time server receive order : " + body);
					String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
					doWriter(sc, currentTime);
				}
			}
		}
	}

	private void doWriter(SocketChannel channel, String response) throws IOException
	{
		if (response != null && response.trim().length() > 0)
		{
			byte[] bytes = response.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			channel.write(writeBuffer);
		}

	}

}
