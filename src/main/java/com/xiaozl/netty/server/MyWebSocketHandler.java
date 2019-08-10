package com.changlan.netty;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class MyWebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame>{
	
		private Logger logger = LoggerFactory.getLogger(MyWebSocketHandler.class);
	
		@Override
		protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
			  Channel channel = ctx.channel();
		      System.out.println(channel.remoteAddress() + ": " + msg.text());
		      ctx.channel().writeAndFlush(new TextWebSocketFrame("来自服务端: " + LocalDateTime.now()));
		} 

		@Override
	    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
	        System.out.println("ChannelId" + ctx.channel().id().asLongText());
//	        ctx.channel().writeAndFlush(new TextWebSocketFrame("来自服务端: " + LocalDateTime.now()));
	    }
	    
	    @Override
	    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
	        System.out.println("用户下线: " + ctx.channel().id().asLongText());
	    }
	    
	    @Override
	    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
	        ctx.channel().close();
	    }

	    /**
	     * 在建立连接时
	     *
	     * @param ctx
	     * @throws Exception
	     */
	    @Override
	    public void channelActive(ChannelHandlerContext ctx) throws Exception {
	        Channel channel = ctx.channel();
	        boolean active = channel.isActive();
	        if (active) {
	        	 logger.info("[" + channel.remoteAddress() + "] is online channelActive");
	        } else {
	        	 logger.info("[" + channel.remoteAddress() + "] is offline channelActive");
	        }
//	        ctx.channel().writeAndFlush(new TextWebSocketFrame("来自服务端: " + LocalDateTime.now()));
	        HttpNettyServer.messageChannelMap.put("messageBox", channel);
	    }


}
