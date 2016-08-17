/** 
 * Project Name:vega_test 
 * File Name:WebSocketServerHandler.java 
 * Package Name:com.wyb.myself.websocket 
 * Date:2016年8月21日上午11:50:20 
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package com.wyb.myself.websocket;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFlushPromiseNotifier;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.util.CharsetUtil;

/**
 * ClassName:WebSocketServerHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年8月21日 上午11:50:20 <br/>
 * 
 * @author wangyongbing
 * @version
 * @since JDK 1.8
 * @see
 */
public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object>
{

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().getClass());

	private WebSocketServerHandshaker handshaker;

	@Override
	protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception
	{
		if (msg instanceof FullHttpRequest)
		{

		} else if (msg instanceof WebSocketFrame)
		{

		}
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception
	{
		ctx.flush();
	}

	private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req)
	{
		if (!req.decoderResult().isSuccess() || (!"websocket".equals(req.headers().get("Upgrade"))))
		{
//			sendHttpResponse(ctx, req, new DefaultFullHttpResponse("",400));
		}
		WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory("ws://localhost:8070/websocket", null, false);
		handshaker = wsFactory.newHandshaker(req);
		if (handshaker == null)
		{
			WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
		} else
		{
			handshaker.handshake(ctx.channel(), req);
		}
	}

	private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame)
	{
		if (frame instanceof CloseWebSocketFrame)
		{
			handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
			return;
		} else if (frame instanceof PingWebSocketFrame)
		{
			ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
			return;
		} else if (frame instanceof TextWebSocketFrame)
		{
			String request = ((TextWebSocketFrame) frame).text();
			ctx.channel().write(new TextWebSocketFrame(request + "hello."));
		}
	}

	private static void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, FullHttpResponse res)
	{
		if (res.status().code() != 200)
		{
			ByteBuf buf = Unpooled.copiedBuffer(res.status().toString(), CharsetUtil.UTF_8);
			res.content().writeBytes(buf);
			buf.release();
		}
		ChannelFuture f = ctx.channel().writeAndFlush(res);
		if (res.status().code() != 200)
		{
			f.addListener(ChannelFutureListener.CLOSE);
		}

	}

}
