/**
 * Project: memcached-stub
 * 
 * File Created at 2013-8-20
 * 
 */
package com.geekhua.mstub.command;

import org.jboss.netty.buffer.ChannelBuffer;

/**
 * @author Leo Liang
 * 
 */
public interface Command {

    void parseCommandLine(String commandLine);

    boolean extractData(ChannelBuffer buffer);

}
