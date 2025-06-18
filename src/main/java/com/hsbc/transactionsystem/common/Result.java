package com.hsbc.transactionsystem.common;

import lombok.Data;

@Data
public class Result<T> {

    private static final String SUCCESS = "SUCCESS";
    private static final String SYSTEM_ERROR = "SYSTEM_ERROR";
    private static final Integer SUCCESS_CODE = 200;
    private static final Integer FAILURE_CODE = -1;

    private boolean success;

    private String message;

    private int code;

    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.setSuccess(true);
        result.setCode(SUCCESS_CODE);
        result.setMessage(SUCCESS);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(String message) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setCode(FAILURE_CODE);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> systemFail() {
        return fail(SYSTEM_ERROR);
    }


}
