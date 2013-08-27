/**
 * Project: memcached-stub
 * 
 * File Created at 2013-8-20
 * 
 */
package com.geekhua.mstub.command;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jboss.netty.buffer.ChannelBuffer;

/**
 * @author Leo Liang
 * 
 */
public class RetrieveCommand implements Command {
    private List<String> keys = new ArrayList<String>();

    @Override
    public void parseCommandLine(String commandLine) {
        String[] args = StringUtils.split(commandLine, " ");
        if (args != null && args.length > 0) {
            for (int i = 1; i < args.length; i++) {
                keys.add(args[i]);
            }
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
        return this.getClass().getSimpleName() + " [keys=" + keys + "]";
    }

}
