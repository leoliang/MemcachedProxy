/**
 * Project: memcached-stub
 * 
 * File Created at 2013-8-20
 * 
 */
package com.geekhua.mstub.command;

import org.apache.commons.lang.StringUtils;
import org.jboss.netty.buffer.ChannelBuffer;

/**
 * @author Leo Liang
 * 
 */
public class DeleteCommand implements Command {
    private String  key;
    private boolean noreply = false;

    @Override
    public void parseCommandLine(String commandLine) {
        String[] args = StringUtils.split(commandLine, " ");
        if (args != null && args.length > 1) {
            key = args[1];
        }
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

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @return the noreply
     */
    public boolean isNoreply() {
        return noreply;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DeleteCommand [key=" + key + ", noreply=" + noreply + "]";
    }

}
