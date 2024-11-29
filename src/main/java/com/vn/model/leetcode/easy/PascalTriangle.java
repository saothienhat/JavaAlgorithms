package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeTest;

import java.util.*;

public class PascalTriangle extends LeetCodeTest {

    public PascalTriangle() {
        super("https://leetcode.com/problems/pascals-triangle/",
                "Pascal's Triangle",
                TestLevel.EASY.name());
    }

    @Override
    public void run() {
        List<List<Integer>> list = generate(4);
        System.out.println(list);

    }

    private List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();

        for(int i = 1; i <= numRows; i++) {
            if(i == 1) {
                currList = Collections.singletonList(1);
                list.add(currList);
            } else if(i == 2) {
                currList = Arrays.asList(1, 1);
                list.add(currList);
            } else {
                    Integer[] arr = new Integer[i];
                    int begin = 0;
                    int next = begin + 1;

                    arr[begin] = 1;
                    arr[i - 1] = 1;
                    for(int j = 1; j < i - 1; j++) {
                        arr[j] = currList.get(begin) + currList.get(next);
                        begin++;
                        next++;
                    }
                    List<Integer> myList = Arrays.asList(arr);
                    list.add(myList);
                    currList = myList;
            }
        }

        return list;
    }
}



