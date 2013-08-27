/**
 * Project: memcached-stub
 * 
 * File Created at 2013-8-19
 * 
 */
package com.geekhua.mstub;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.geekhua.mstub.server.MStubServer;

/**
 * @author Leo Liang
 * 
 */
public class MStubServerBootstrap {

    public static void main(String[] args) {
        final MStubServer server = new ClassPathXmlApplicationContext("applicationContext.xml")
                .getBean(MStubServer.class);
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
