package com.wangzhou.leecode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/15
 * Time:20:13
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution341 implements Iterator<Integer> {
    private List<Integer> list;
    private int index;

    public Solution341(List<NestedInteger> nestedList) {
        list = integerIterator(nestedList);
        index = -1;
    }

    private List<Integer> integerIterator(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                list.addAll(integerIterator(nestedInteger.getList()));

            }
        }
        return list;
    }

    @Override
    public boolean hasNext() {
        if (index + 1 < list.size()) return true;
        return false;
    }

    @Override
    public Integer next() {
        if (this.hasNext()) return list.get(++index);
        return null;
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}