package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.utils.TestHelper;

import java.util.LinkedList;

public class PlusOne extends LeetCodeTest {

    public PlusOne() {
        super("https://leetcode.com/problems/plus-one/description/",
                "Plus One",
                TestLevel.EASY.name());
    }


    @Override
    public void run() {
        about();
        //int[] result = plusOne(new int[] {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3});
//        int[] result = plusOne(new int[] { 7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6 });
//        int[] result = plusOne(new int[] {1, 0, 3});
//        int[] result = plusOne(new int[] {9}); // Output: [1, 0]
//        int[] result = plusOne(new int[] {9, 9}); // Output: [1, 0, 0]
    }

    public int[] plusOne(int[] digits) {
        final int size = digits.length;
        int[] result = new int[size];

        boolean rememberOne = false;
        int count = 0;
        for(int i = size - 1; i >= 0; i--) {
            int value = digits[i];
            int valuePlusOne = count == 0 ? (value + 1) : value;

            if(rememberOne) {
                valuePlusOne += 1;
                //valuePlusOne = value;
                rememberOne = false;
            }

            if(valuePlusOne > 9) {
                rememberOne = true;
                result[i] = 0;
            } else {
                result[i] = valuePlusOne;
            }

            count++;

        }

        if(rememberOne) {
            // add (1)
            int[] result_1 = new int[size + 1];
            result_1[0] = 1;
            int resultSize = result.length;
            for (int i = 0; i < resultSize; i++) {
                result_1[i + 1] = result[i];
            }
            return result_1;
        }

        return result;
    }


}
