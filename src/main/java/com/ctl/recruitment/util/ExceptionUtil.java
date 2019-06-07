package com.ctl.recruitment.util;

public class ExceptionUtil {
    public static String getExceptionInformation(Exception ex){
        StringBuilder sOut = new StringBuilder();
        sOut.append(ex.getMessage()).append(ex.getClass().toString()).append("\r\n");
        StackTraceElement[] trace = ex.getStackTrace();
        for (StackTraceElement s : trace) {
            sOut.append("\tat ").append(s).append("\r\n");
        }
        return sOut.toString();
    }
}
