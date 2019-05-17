package com.ishop.miaosha.result;

/**
 * 请求返回结果集
 * @param <T>
 */
public class Result<T> {

    private int code;
    private String msg;
    private T data;

    private Result(T data) {
        this.code =0;
        this.msg = "success";
        this.data = data;
    }

    private Result(CodeMsg codeMsg) {
        if(codeMsg==null){
            return;
        }
        this.code=codeMsg.getCode();
        this.msg=codeMsg.getMsg();
    }

    /**
     * 成功时候调用
     * @param data
     * @param <T>
     * @return
     */
    public static  <T> Result<T> success(T data){
        return new Result<>(data);
    }

    /**
     * 失败的时候调用
     * @param <T>
     * @return
     */
    public static  <T> Result<T> error(CodeMsg codeMsg){
        return new Result<T>(codeMsg);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
