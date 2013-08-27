/**
 * Project: memcached-proxy
 * 
 * File Created at 2013-8-19
 * 
 */
package com.geekhua.mproxy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.geekhua.mproxy.server.MProxyServer;

/**
 * @author Leo Liang
 * 
 */
public class MProxyServerBootstrap {

    public static void main(String[] args) {
        final MProxyServer server = new ClassPathXmlApplicationContext("applicationContext.xml")
                .getBean(MProxyServer.class);
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                if (server.isRunning()) {
                    server.stop();
                }
            }
        }));
    }
}
