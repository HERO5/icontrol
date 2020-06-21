package com.mrl.network.echo;

import android.util.Log;

import com.mrl.network.model.Message;
import com.mrl.network.business.OnReceiveListener;
import com.mrl.network.business.OnServerConnectListener;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class EchoClient {

    public final static String TAG = EchoClient.class.getSimpleName();

    private InetSocketAddress mServerAddress;
    private Bootstrap mBootstrap;
    private Channel mChannel;
    private EventLoopGroup mWorkerGroup;
    private OnServerConnectListener onServerConnectListener;
    private EchoClientHandler clientHandler;

    private static EchoClient INSTANCE;

    public EchoClient(OnReceiveListener listener) {
        clientHandler = new EchoClientHandler(listener);
    }

    public static EchoClient getInstance(OnReceiveListener listener) {
        if (INSTANCE == null) {
            synchronized (EchoClient.class) {
                if (INSTANCE == null) {
                    INSTANCE = new EchoClient(listener);
                }
            }
        }
        return INSTANCE;
    }

    public static void destroy(){
        INSTANCE = null;
    }

    public void connect(String host, int port, OnServerConnectListener onServerConnectListener) {
        if (mChannel != null && mChannel.isActive()) {
            return;
        }
        mServerAddress = new InetSocketAddress(host, port);
        this.onServerConnectListener = onServerConnectListener;

        if (mBootstrap == null) {
            mWorkerGroup = new NioEventLoopGroup();
            mBootstrap = new Bootstrap();
            mBootstrap.group(mWorkerGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline
                                    .addLast(new StringEncoder())
                                    .addLast(new StringDecoder())
                                    .addLast("handler", clientHandler);

                        }
                    })
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
        }

        ChannelFuture future = mBootstrap.connect(mServerAddress);
        future.addListener(mConnectFutureListener);
    }

    private ChannelFutureListener mConnectFutureListener = new ChannelFutureListener() {
        @Override
        public void operationComplete(ChannelFuture pChannelFuture) throws Exception {
            if (pChannelFuture.isSuccess()) {
                mChannel = pChannelFuture.channel();
                if (onServerConnectListener != null) {
                    onServerConnectListener.onConnectSuccess();
                }
                Log.i(TAG, "operationComplete: connected!");
            } else {
                if (onServerConnectListener != null) {
                    onServerConnectListener.onConnectFailed();
                }
                Log.i(TAG, "operationComplete: connect failed!");
            }
        }
    };

    public synchronized void send(Message msg) {
        if (mChannel == null) {
            Log.e(TAG, "send: channel is null");
            return;
        }

        if (!mChannel.isWritable()) {
            Log.e(TAG, "send: channel is not Writable");
            return;
        }

        if (!mChannel.isActive()) {
            Log.e(TAG, "send: channel is not active!");
            return;
        }

        if (mChannel != null) {
            mChannel.writeAndFlush(msg.getContent());
        }

    }

}
