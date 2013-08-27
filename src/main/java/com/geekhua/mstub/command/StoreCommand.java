/**
 * Project: memcached-stub
 * 
 * File Created at 2013-8-20
 * 
 */
package com.geekhua.mstub.command;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.jboss.netty.buffer.ChannelBuffer;

/**
 * @author Leo Liang
 * 
 */
public abstract class StoreCommand implements Command {
    protected String  key;
    protected int     flags;
    protected long    exptime;
    protected int     dataLength;
    protected boolean noreply = false;
    protected byte[]  data;

    /**
     * @return the data
     */
    public byte[] getData() {
        return data;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @return the flags
     */
    public int getFlags() {
        return flags;
    }

    /**
     * @return the exptime
     */
    public long getExptime() {
        return exptime;
    }

    /**
     * @return the dataLength
     */
    public int getDataLength() {
        return dataLength;
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
     * @see
     * com.geekhua.mproxy.command.Command#parseCommandLine(java.lang.String)
     */
    @Override
    public void parseCommandLine(String commandLine) {
        String[] args = StringUtils.split(commandLine, " ");
        if (args != null && args.length >= 5) {
            this.key = args[1];
            this.flags = Integer.valueOf(args[2]);
            this.exptime = Long.valueOf(args[3]);
            this.dataLength = Integer.valueOf(args[4]);
            doParseCommandLine(args);
        }
    }

    protected abstract void doParseCommandLine(String[] args);

    /*
     * (non-Javadoc)
     * 
     * @see com.geekhua.mproxy.command.Command#extractData(byte[])
     */
    @Override
    public boolean extractData(ChannelBuffer buffer) {
        ChannelBuffer dataBuf = buffer.slice();

        if (dataBuf != null && dataBuf.readableBytes() >= this.dataLength + 2) {
            if (dataBuf.getByte(this.dataLength) == '\r' && dataBuf.getByte(this.dataLength + 1) == '\n') {
                this.data = dataBuf.copy(0, this.dataLength).array();
                buffer.skipBytes(this.dataLength + 2);
                return true;
            }
        }

        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [key=" + key + ", flags=" + flags + ", exptime=" + exptime
                + ", dataLength=" + dataLength + ", noreply=" + noreply + ", data=" + Arrays.toString(data) + "]";
    }

}
