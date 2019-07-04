package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/3
 * Time:22:31
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution54 {
    int count[] = new int[256];
    int index = 1;

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (count[ch] == 0) {
            count[ch] = index++;
        } else {
            count[ch] = -1;
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int temp = Integer.MAX_VALUE;
        char ch='#';
        for (int i = 0; i < 256; i++) {
            if(count[i]!=-1&&count[i]!=0&&count[i]<temp){
                temp=count[i];
                ch=(char) i;
            }
        }
        System.out.println(ch);
        return ch;
    }

    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();
        solution54.Insert('g');
        solution54.FirstAppearingOnce();
        solution54.Insert('o');
        solution54.FirstAppearingOnce();
        solution54.Insert('o');
        solution54.FirstAppearingOnce();
        solution54.Insert('g');
        solution54.FirstAppearingOnce();
        solution54.Insert('l');
        solution54.FirstAppearingOnce();
        solution54.Insert('e');
        solution54.FirstAppearingOnce();
    }
}
