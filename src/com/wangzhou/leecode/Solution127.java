package com.wangzhou.leecode;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/16
 * Time:14:51
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        HashMap<String, ArrayList<String>> dict = new HashMap<>();
        wordList.add("hit");
        wordList.forEach(word -> {
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                ArrayList<String> transformations = dict.getOrDefault(newWord, new ArrayList<String>());
                transformations.add(word);
                dict.put(newWord, transformations);
            }
        });
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                for (String adjacentWord : dict.get(newWord)) {
                    if (adjacentWord.equals(endWord)) return level + 1;
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        queue.add(new Pair<>(adjacentWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args){
        Solution127 solution127=new Solution127();
        List<String> list=new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println( solution127.ladderLength("hit", "cog",list ));

    }
}
