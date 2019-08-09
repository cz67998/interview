//package com.wangzhou.leecode;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by IDEA
// * author:wangzhou
// * Date:2019/7/24
// * Time:15:02
// * Blog:https://blog.csdn.net/qq_38522268
// **/
//public class Solution93 {
//    private List<String> list = new ArrayList<>();
//
//    public List<String> restoreIpAddresses(String s) {
//        if (s.length() == 0) return list;
//        findComb(s, 0, 3, "");
//        return list;
//    }
//
//    private void findComb(String s, int start, int end, String s1) {
//        int length = s.length();
//        if (end == length) {
//            list.add(s1.substring(0, s1.length() - 1));
//            return;
//        }
//        for (int i = start + 1; i < length; i++) {
//
//        }
//
//    }
//
//    public boolean valid(String segment) {
//        int m = segment.length();
//        if (m > 3) return false;
//        return segment.charAt(0) != 0 ? Integer.valueOf(segment) <= 255 : (m == 1);
//    }
//
//
//    public static void main(String[] args) {
//        Solution93 solution93 = new Solution93();
//        System.out.println(solution93.valid("611"));
//    }
//}
