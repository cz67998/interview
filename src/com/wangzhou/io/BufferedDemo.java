package com.wangzhou.io;

import java.io.*;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/18
 * Time:16:36
 **/
public class BufferedDemo {
    public static void input() throws IOException {
        BufferedInputStream bufferedInputStream=null;
        try {
            bufferedInputStream=new BufferedInputStream(new FileInputStream("src/test.txt"));
            byte[] b=new byte[256];
            while (( bufferedInputStream.read(b))!=-1){
                System.out.println(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            bufferedInputStream.close();
        }
    }
    public static void main(String[] args) throws IOException {
        output();
    }
    public static void output() throws IOException {
        BufferedOutputStream bufferedOutputStream=null;
        try {
            bufferedOutputStream=new BufferedOutputStream(new FileOutputStream("src/test.txt"));
            bufferedOutputStream.write( "tet".getBytes());
            bufferedOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedOutputStream.close();
        }
    }
}
