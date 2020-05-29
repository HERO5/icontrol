package com.mrl.network.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 服务端启动类
 * • 配置服务器功能，如线程、端口
 * • 实现服务器处理程序，它包含业务逻辑，决定当有一个请求连接或接收数据时该做什么
 */
public class EchoServer {

    private ServerBootstrap mServerBootstrap;
    private EventLoopGroup mWorkerGroup;
    private ChannelFuture channelFuture;
    private boolean isInit;

    private static EchoServer INSTANCE;

    private Integer port;

    private EchoServer(int port) {
        this.port = port;
    }

    public static EchoServer getInstance(int port) {
        if (INSTANCE == null) {
            synchronized (EchoServer.class) {
                if (INSTANCE == null) {
                    INSTANCE = new EchoServer(port);
                }
            }
        }
        return INSTANCE;
    }

    public void init() throws Exception {
        if (isInit) {
            return;
        }
        //创建worker线程池，这里只创建了一个线程池，使用的是netty的多线程模型
        mWorkerGroup = new NioEventLoopGroup();
        //服务端启动引导类，负责配置服务端信息
        mServerBootstrap = new ServerBootstrap();
        mServerBootstrap.group(mWorkerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<Channel>() {
            //设置childHandler执行所有的连接请求
            @Override
            protected void initChannel(Channel ch) {
                ch.pipeline()
                        .addLast(new StringEncoder())
                        .addLast(new StringDecoder())
                        .addLast(new EchoServerHandler());
            }
        });
        channelFuture = mServerBootstrap.bind(port);
        isInit = true;
    }

    public void shutDown() {
        if (channelFuture != null && channelFuture.isSuccess()) {
            isInit = false;
            channelFuture.channel().closeFuture();
            mWorkerGroup.shutdownGracefully();
        }
    }

}
