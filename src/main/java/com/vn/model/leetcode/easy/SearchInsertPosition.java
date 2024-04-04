package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.utils.TestHelper;

public class SearchInsertPosition extends LeetCodeTest {

    public SearchInsertPosition() {
        super("https://leetcode.com/problems/search-insert-position/",
                "Search Insert Position",
                TestLevel.EASY.name());
    }


    @Override
    public void run() {
        about();

//        TestHelper.expect(2,searchInsert(new int[]{1,3,5,6}, 5));
//        TestHelper.expect(1,searchInsert(new int[]{1,3,5,6}, 2));
//        TestHelper.expect(4,searchInsert(new int[]{1,3,5,6}, 7));
    }


    public int searchInsert(int[] nums, int target) {
        final int size = nums.length;
        for (int i = 0; i < size; i++) {
            if(nums[i] >= target) return i;
        }
        return size;
    }
}
