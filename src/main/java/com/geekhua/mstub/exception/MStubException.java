/**
 * Project: memcached-stub
 * 
 * File Created at 2013-8-19
 * 
 */
package com.geekhua.mstub.exception;

/**
 * @author Leo Liang
 * 
 */
public class MStubException extends Exception {

    private static final long serialVersionUID = -3353229547691897712L;

    public MStubException() {
        super();
    }

    public MStubException(String message) {
        super(message);
    }

    public MStubException(String message, Throwable cause) {
        super(message, cause);
    }

    public MStubException(Throwable cause) {
        super(cause);
    }
}
