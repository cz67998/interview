package com.wangzhou.throwable;

import java.io.IOException;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/17
 * Time:10:54
 **/
public class ErrorAndException {
    private void throwError(){
        throw new StackOverflowError();
    }
    private void throwRuntimeException(){
        throw new RuntimeException();
    }
    private static void throwCheckEdException() throws IOException {
        throw new IOException();
    }
    public static void main(String[] args) throws IOException {
        throwCheckEdException();
    }


}
