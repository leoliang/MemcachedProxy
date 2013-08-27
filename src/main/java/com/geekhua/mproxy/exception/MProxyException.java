/**
 * Project: memcached-proxy
 * 
 * File Created at 2013-8-19
 * 
 */
package com.geekhua.mproxy.exception;

/**
 * @author Leo Liang
 * 
 */
public class MProxyException extends Exception {

    private static final long serialVersionUID = -3353229547691897712L;

    public MProxyException() {
        super();
    }

    public MProxyException(String message) {
        super(message);
    }

    public MProxyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MProxyException(Throwable cause) {
        super(cause);
    }
}
