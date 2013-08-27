/**
 * Project: memcached-proxy
 * 
 * File Created at 2013-8-20
 * 
 */
package com.geekhua.mproxy;

import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

/**
 * @author Leo Liang
 * 
 */
public class TestServer {
    public static void main(String[] args) throws Exception {
        MemcachedClient mc = new MemcachedClient(new InetSocketAddress("localhost", 11211));
        // mc.set("aa", 1, "bb");
        // mc.add("dddd", 22, "dwfwefwfwwewf");
        // mc.replace("aa",3, "cc");
        // mc.append("dddd", "dddd");
        // mc.prepend("aa", "ff");
        // mc.cas("ff", 111, "ddd");
        // mc.get("aaa");
        // mc.gets("aaa");
        // mc.getBulk("a", "b", "c", "d");
        // mc.delete("aa");
        // mc.incr("a", 111L, 112L);
        // mc.decr("a", 111L, 112L);
        mc.touch("aa", 10);
        mc.flush();
    }

}
