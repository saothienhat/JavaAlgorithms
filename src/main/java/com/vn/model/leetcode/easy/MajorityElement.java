package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.utils.TestHelper;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement extends LeetCodeTest {

    public MajorityElement() {
        super("https://leetcode.com/problems/majority-element/description/",
                "Majority Element",
                TestLevel.EASY.name());
    }

    @Override
    public void run() {
        TestHelper.expect(3, majorityElement(new int[] { 3, 2, 3}));
    }

    private int majorityElement(int[] nums) {
        if(nums.length == 1) return nums[0];

        int times = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int value: nums) {
            if(!map.containsKey(value)) {
                map.put(value, 1);
            } else {
                map.put(value, map.get(value) + 1);
                if(map.get(value) > times) return value;
            }
        }
        return 0;
    }

}
