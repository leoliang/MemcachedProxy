/**
 * Project: memcached-stub
 * 
 * File Created at 2013-8-20
 * 
 */
package com.geekhua.mstub.protocol;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

import com.geekhua.mstub.command.AddCommand;
import com.geekhua.mstub.command.AppendCommand;
import com.geekhua.mstub.command.CasCommand;
import com.geekhua.mstub.command.Command;
import com.geekhua.mstub.command.DecrementCommand;
import com.geekhua.mstub.command.DeleteCommand;
import com.geekhua.mstub.command.GetCommand;
import com.geekhua.mstub.command.GetsCommand;
import com.geekhua.mstub.command.IncrementCommand;
import com.geekhua.mstub.command.PrependCommand;
import com.geekhua.mstub.command.ReplaceCommand;
import com.geekhua.mstub.command.SetCommand;
import com.geekhua.mstub.command.TouchCommand;
import com.geekhua.mstub.command.UnknownCommand;

/**
 * @author Leo Liang
 * 
 */
public class AsciiProtocolDecoder extends FrameDecoder {

    private static Map<String, Class<? extends Command>> commandTypeMap = new HashMap<String, Class<? extends Command>>();

    static {
        commandTypeMap.put("set", SetCommand.class);
        commandTypeMap.put("add", AddCommand.class);
        commandTypeMap.put("replace", ReplaceCommand.class);
        commandTypeMap.put("append", AppendCommand.class);
        commandTypeMap.put("prepend", PrependCommand.class);
        commandTypeMap.put("cas", CasCommand.class);
        commandTypeMap.put("get", GetCommand.class);
        commandTypeMap.put("gets", GetsCommand.class);
        commandTypeMap.put("delete", DeleteCommand.class);
        commandTypeMap.put("incr", IncrementCommand.class);
        commandTypeMap.put("decr", DecrementCommand.class);
        commandTypeMap.put("touch", TouchCommand.class);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer) throws Exception {

        String commandLine = decodeCommandLine(buffer);
        if (commandLine != null) {
            Command command = commandOf(commandLine);
            command.parseCommandLine(commandLine);

            if (!command.extractData(buffer)) {
                return null;
            } else {
                return command;
            }
        } else {
            return null;
        }
    }

    private Command commandOf(String commandLine) {
        String[] args = StringUtils.split(commandLine, " ");
        Command command = new UnknownCommand();
        if (args != null && args.length > 0) {
            if (StringUtils.isNotBlank(args[0]) && commandTypeMap.containsKey(args[0].toLowerCase())) {
                try {
                    command = commandTypeMap.get(args[0].toLowerCase()).newInstance();
                } catch (Exception e) {
                }
            }
        }

        return command;
    }

    private String decodeCommandLine(ChannelBuffer buffer) {
        final int eoc = findEndOfCommand(buffer);
        if (eoc >= 0) {
            final ChannelBuffer commandLine;
            final int length = eoc - buffer.readerIndex();

            try {
                commandLine = extractFrame(buffer, buffer.readerIndex(), length);
            } finally {
                buffer.skipBytes(length + 2);
            }
            return new String(commandLine.array());
        } else {
            return null;
        }
    }

    private int findEndOfCommand(ChannelBuffer buffer) {
        final int n = buffer.writerIndex();
        for (int i = buffer.readerIndex(); i < n; i++) {
            final byte b = buffer.getByte(i);
            if (b == '\r' && i < n - 1 && buffer.getByte(i + 1) == '\n') {
                return i;
            }
        }
        return -1; // Not found.
    }

}
