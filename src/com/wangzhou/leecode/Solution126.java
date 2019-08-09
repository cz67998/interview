package com.wangzhou.leecode;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/16
 * Time:17:08
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution126 {
    private List<List<String>> lists;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ladderLength(beginWord, endWord, wordList);
        return lists;
    }

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


    /**
     * 和leetcode127一样 只不过各自保存已经处理过的列表和字典集合
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return new ArrayList<>();
        }
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)){
            return new ArrayList<>();
        }

        List<List<String>> totalList = new ArrayList<>();
        List<String> beginList = new ArrayList<>();
        beginList.add(beginWord);
        totalList.add(beginList);
        dict.remove(beginWord);

        List<List<String>> result = new ArrayList<>();
        bfs(totalList, endWord, dict, result);
        return result;
    }

    /**
     * 同一个key可能会有多条路径 外层需要包一个list
     * @param totalList
     * @param endWord
     * @param dict
     * @param result
     */
    public void bfs(List<List<String>> totalList, String endWord, Set<String> dict, List<List<String>> result) {
        if(totalList.isEmpty() || dict.isEmpty()){
            return;
        }
        List<List<String>> totalTempList = new ArrayList<>();
        Set<String> removeSet = new HashSet<>();
        boolean findMin = false;
        for(List<String> begin : totalList){
            String ns = begin.get(begin.size() - 1);
            char[] arr = ns.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char tmp = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (tmp == c) {
                        continue;
                    }
                    arr[i] = c;
                    String nstr = new String(arr);
                    if (dict.contains(nstr)) {
                        List<String> resTemp = new ArrayList<>(begin);
                        resTemp.add(nstr);
                        if (endWord.equals(nstr)) {
                            result.add(resTemp);
                            findMin = true;
                        } else {
                            totalTempList.add(resTemp);
                            removeSet.add(nstr);
                        }
                    }
                }
                arr[i] = tmp;
            }
        }
        if(!findMin){
            dict.removeAll(removeSet);
            bfs(totalTempList, endWord, dict, result);
        }
    }

    /**
     * 类似leetcode126的优化 需要两头计算 然后根据中间结果集构造结果
     * 比上一个方案时间短的原因是在bfs的时候不用每次都构造一个新的List
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public  List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if(wordList == null) {
            return res;
        }
        Set<String> dicts = new HashSet<>(wordList);
        if(!dicts.contains(endWord)) {
            return res;
        }
        dicts.remove(beginWord);

        Set<String> endList = new HashSet<>();
        Set<String> beginList = new HashSet<>();

        Map<String, List<String>> map = new HashMap<>();
        beginList.add(beginWord);
        endList.add(endWord);

        bfs(map, beginList, endList, dicts, false);

        List<String> tempList = new ArrayList<>();
        tempList.add(beginWord);

        dfs(map, res, tempList, beginWord, endWord);

        return res;
    }

    /**
     * 保存map是关键 是一个中间结果集 相当于预处理的一个序列
     * @param map
     * @param handleSet
     * @param receiveSet
     * @param wordList
     * @param reverse
     */
    private void bfs(Map<String, List<String>> map, Set<String> handleSet, Set<String> receiveSet, Set<String> wordList, boolean reverse){
        if(handleSet.size() == 0) {
            return;
        }

        wordList.removeAll(handleSet);
        boolean findMin = false;
        Set<String> handleTempSet = new HashSet<>();

        for(String str : handleSet){
            char[] arr = str.toCharArray();
            for(int i = 0; i < arr.length; i++){
                char temp = arr[i];
                for(char ch = 'a'; ch <= 'z'; ch++){
                    if(ch == temp){
                        continue;
                    }
                    arr[i] = ch;
                    String newstr = new String(arr);
                    if(!wordList.contains(newstr)){
                        continue;
                    }
                    if(receiveSet.contains(newstr)){
                        findMin = true;
                    }else{
                        handleTempSet.add(newstr);
                    }

                    //key = pre value = after reverse为true时是从后往前算的
                    String key = reverse ? newstr : str;
                    String value = reverse ? str : newstr;

                    if(!map.containsKey(key)){
                        map.put(key, new ArrayList<>());
                    }
                    map.get(key).add(value);

                }
                arr[i] = temp;
            }
        }
        if(!findMin) {
            if(handleTempSet.size() > receiveSet.size()){
                bfs(map, receiveSet, handleTempSet, wordList, !reverse);
            }else{
                bfs(map, handleTempSet, receiveSet, wordList, reverse);
            }
        }
    }

    /**
     * 根据中间结果集构造结果
     * @param map
     * @param result
     * @param tempList
     * @param beginWord
     * @param endWord
     */
    private void dfs (Map<String, List<String>> map, List<List<String>> result, List<String> tempList, String beginWord, String endWord) {
        if(beginWord.equals(endWord)) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        if (!map.containsKey(beginWord)) {
            return;
        }
        for (String word : map.get(beginWord)) {
            tempList.add(word);
            dfs(map, result, tempList, word, endWord);
            tempList.remove(tempList.size() - 1);
        }
    }

}
