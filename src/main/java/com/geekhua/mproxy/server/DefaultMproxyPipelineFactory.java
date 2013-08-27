/**
 * Project: memcached-proxy
 * 
 * File Created at 2013-8-20
 * 
 */
package com.geekhua.mproxy.server;

import java.util.concurrent.Executor;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.codec.frame.FrameDecoder;
import org.jboss.netty.handler.execution.ExecutionHandler;

/**
 * @author Leo Liang
 * 
 */
public class DefaultMproxyPipelineFactory implements ChannelPipelineFactory {
    private FrameDecoder decoder;
    private Executor     executor;

    public DefaultMproxyPipelineFactory(FrameDecoder decoder, Executor executor) {
        this.decoder = decoder;
        this.executor = executor;
    }

    @Override
    public ChannelPipeline getPipeline() throws Exception {
        ChannelPipeline pipeline = Channels.pipeline();
        pipeline.addLast("decoder", decoder);
        pipeline.addLast("pipelineExecutor", new ExecutionHandler(executor));
        return pipeline;
    }
}
