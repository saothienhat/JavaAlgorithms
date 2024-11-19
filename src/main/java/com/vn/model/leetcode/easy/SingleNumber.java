package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.utils.TestHelper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumber extends LeetCodeTest {

    public SingleNumber() {
        super("https://leetcode.com/problems/single-number/",
                "Single Number",
                TestLevel.EASY.name());
    }

    @Override
    public void run() {
        TestHelper.expect(1, singleNumber(new int[] {2, 2, 1}));
        TestHelper.expect(4, singleNumber(new int[] {4,1,2,1,2}));
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(!myMap.containsKey(nums[i])) {
                myMap.put(nums[i], 1);
            } else {
                myMap.put(nums[i], 2);
            }
        }
        for(Integer key: myMap.keySet()) {
            if(myMap.get(key) == 1) return key;
        }
        return 0;
    }
}
