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
public class TouchCommand implements Command {
    protected String  key;
    protected long    expTime;
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
            this.expTime = Long.valueOf(args[2]);
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
        return "TouchCommand [key=" + key + ", expTime=" + expTime + ", noreply=" + noreply + "]";
    }

}
