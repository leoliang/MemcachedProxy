package com.geekhua.mproxy.server;


/**
 * @author Leo Liang
 * 
 */
public interface MProxyServer {
    void start();

    void stop();

    boolean isRunning();
}
