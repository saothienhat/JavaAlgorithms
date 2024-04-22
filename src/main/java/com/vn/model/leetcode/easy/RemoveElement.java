package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.utils.TestHelper;

public class RemoveElement extends LeetCodeTest {

    public RemoveElement() {
        super("https://leetcode.com/problems/remove-element/",
                "Remove Element",
                TestLevel.EASY.name());
    }


    @Override
    public void run() {
        about();

        TestHelper.expect(2, removeElement(new int[] {3,2,2,3}, 3));
    }

    public int removeElement(int[] nums, int val) {
        int differentNums = nums.length;
        int index = 0;

        while (index < differentNums) {
            if (val == nums[index]) {
                differentNums--;
                if (index+1 >= nums.length) return differentNums;
                for (int j = index + 1; j<nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
            }
            else index++;
        }
        return differentNums;
    }

}
