/**
 * Project: memcached-proxy
 * 
 * File Created at 2013-8-19
 * 
 */
package com.geekhua.mproxy.server;

import java.net.InetSocketAddress;

import org.apache.log4j.Logger;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.ChannelGroupFuture;
import org.jboss.netty.channel.socket.ServerSocketChannelFactory;

/**
 * @author Leo Liang
 * 
 */
public class DefaultMProxyServer implements MProxyServer {

    private static Logger              log     = Logger.getLogger(DefaultMProxyServer.class);
    private InetSocketAddress          addr;
    private ChannelGroup               allChannels;
    private ServerSocketChannelFactory channelFactory;
    private ServerBootstrap            serverBootstrap;

    private volatile boolean           running = false;

    public DefaultMProxyServer(ServerSocketChannelFactory channelFactory, ChannelGroup allChannels,
            ServerBootstrap serverBootstrap, InetSocketAddress addr) {
        this.channelFactory = channelFactory;
        this.allChannels = allChannels;
        this.serverBootstrap = serverBootstrap;
        this.addr = addr;
    }

    @Override
    public void start() {
        log.info("Starting...");

        Channel serverChannel = serverBootstrap.bind(addr);
        allChannels.add(serverChannel);

        log.info(String.format("%s started at %s:%d", this.getClass().getSimpleName(), addr.getHostName(),
                addr.getPort()));

        running = true;
    }

    @Override
    public void stop() {
        log.info("Stoping...");

        ChannelGroupFuture future = allChannels.close();
        future.awaitUninterruptibly();
        if (!future.isCompleteSuccess()) {
            throw new RuntimeException("Fail to close all channels");
        }

        log.info("All Channels closed");
        channelFactory.releaseExternalResources();

        running = false;
        log.info("Stopped...");
    }

    @Override
    public boolean isRunning() {
        return running;
    }

}
