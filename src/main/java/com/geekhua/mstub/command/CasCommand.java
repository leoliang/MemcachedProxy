/**
 * Project: memcached-stub
 * 
 * File Created at 2013-8-20
 * 
 */
package com.geekhua.mstub.command;

/**
 * @author Leo Liang
 * 
 */
public class CasCommand extends StoreCommand {
    private long unique;

    @Override
    protected void doParseCommandLine(String[] args) {
        this.unique = Long.valueOf(args[5]);
    }

    /**
     * @return the unique
     */
    public long getUnique() {
        return unique;
    }

}
