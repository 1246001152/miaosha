package com.ishop.miaosha.result;

public class CodeMsg {

    private int code;
    private String msg;

    public static CodeMsg SUCCESS=new CodeMsg(100,"success");
    public static CodeMsg SERVER_ERROR= new CodeMsg(500100,"服务端异常");
//    500200 登录模块异常

//    500300 商品模块异常

//    500400 订单模块异常

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }
}
