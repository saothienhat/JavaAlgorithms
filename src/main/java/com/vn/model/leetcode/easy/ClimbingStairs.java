package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.utils.TestHelper;

import java.util.LinkedList;

public class ClimbingStairs extends LeetCodeTest {

    public ClimbingStairs() {
        super("https://leetcode.com/problems/climbing-stairs/",
                "Climbing Stairs",
                TestLevel.EASY.name());
    }


    @Override
    public void run() {
        about();

        TestHelper.expect(2, climbStairs(2));
        TestHelper.expect(3, climbStairs(3));

        TestHelper.expect(5, climbStairs(4));

        TestHelper.expect(8, climbStairs(5));

    }

    // Hint: Fibonance
    public int climbStairs(int n) {
        final int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i < arr.length; i++) {
            arr[i] = arr[i -1] + arr[i - 2];
        }
        return arr[arr.length - 1];
    }



}
