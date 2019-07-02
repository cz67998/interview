package com.wangzhou.io;

import java.io.*;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/18
 * Time:16:07
 **/
public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        input();
    }

    private static void output() throws IOException {
        ObjectOutputStream objectOutputStream=null;
        try {
            objectOutputStream  =new ObjectOutputStream(new FileOutputStream("src/test.txt"));
            User u = new User(1L, "tom", 20);
            objectOutputStream.writeObject(u);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            objectOutputStream.close();
        }
    }

    private static void input() throws ClassNotFoundException {
        ObjectInputStream objectInputStream=null;
        try {
            objectInputStream =new ObjectInputStream(new FileInputStream("src/test.txt"));
            objectInputStream.read();

            User obj = (User) objectInputStream.readObject();

            System.out.println(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
