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
public class UnknownCommand implements Command {

    @Override
    public void parseCommandLine(String commandLine) {

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "UnknownCommand []";
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.geekhua.mproxy.command.Command#extractData(org.jboss.netty.buffer
     * .ChannelBuffer)
     */
    @Override
    public boolean extractData(ChannelBuffer buffer) {
        return true;
    }

}
