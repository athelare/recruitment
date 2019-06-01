package com.ctl.recruitment.pojo.result;

public class ResultType {

    private static int SUCCESS = 0;
    private static int ERROR = 1;
    private int status;
    private String message;
    private Object data;

    /*静态方法，相当于对象工厂，便捷创建状态对象*/
    public static ResultType Success(){
        ResultType s = new ResultType();
        s.status = SUCCESS;
        return s;
    }
    public static ResultType Success(Object data){
        ResultType s = new ResultType();
        s.status = SUCCESS;
        s.data = data;
        return s;
    }
    public static ResultType Error(){
        ResultType s = new ResultType();
        s.status = ERROR;
        return s;
    }
    public static ResultType Error(String message){
        ResultType s = new ResultType();
        s.status = ERROR;
        s.message = message;
        return s;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
