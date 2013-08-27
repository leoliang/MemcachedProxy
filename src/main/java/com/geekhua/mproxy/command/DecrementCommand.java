/**
 * Project: memcached-proxy
 * 
 * File Created at 2013-8-20
 * 
 */
package com.geekhua.mproxy.command;

import org.apache.commons.lang.StringUtils;
import org.jboss.netty.buffer.ChannelBuffer;

/**
 * @author Leo Liang
 * 
 */
public class DecrementCommand implements Command {
    protected String  key;
    protected long    value;
    protected boolean noreply = false;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.geekhua.mproxy.command.Command#parseCommandLine(java.lang.String)
     */
    @Override
    public void parseCommandLine(String commandLine) {
        String[] args = StringUtils.split(commandLine, " ");
        if (args != null && args.length >= 3) {
            this.key = args[1];
            this.value = Long.valueOf(args[2]);
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DecrementCommand [key=" + key + ", value=" + value + ", noreply=" + noreply + "]";
    }

}
