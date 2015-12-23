package com.self.learn.exception;

public class DaoException extends BaseException{

    private static final long serialVersionUID = -6329948833359456351L;

    public DaoException(String message, String code) {
        super(message, null, code, null);
    }

    public DaoException(String message, Throwable cause, String code) {
        super(message, cause, code, null);
    }

    public DaoException(String message, String code, Object[] values) {
        super(message, null, code, values);
    }

    public DaoException(String message, Throwable cause, String code, Object[] values) {
        super(message, cause, code, values);
    }
}
