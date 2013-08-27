/**
 * Project: memcached-proxy
 * 
 * File Created at 2013-8-20
 * 
 */
package com.geekhua.mproxy.protocol;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * @author Leo Liang
 *
 */
public class AsciiProtocolEncoder extends SimpleChannelHandler {
    /* (non-Javadoc)
     * @see org.jboss.netty.channel.SimpleChannelHandler#writeRequested(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.MessageEvent)
     */
    @Override
    public void writeRequested(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        super.writeRequested(ctx, e);
    }
    
    
}
