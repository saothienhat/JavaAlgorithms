package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.utils.TestHelper;

public class MySqrt extends LeetCodeTest {

    public MySqrt() {
        super("https://leetcode.com/problems/sqrtx/",
                "Remove Duplicates from Sorted Array",
                TestLevel.EASY.name());
    }


    @Override
    public void run() {
        about();

//        TestHelper.expect(1, mySqrt(2));
//        TestHelper.expect(1, mySqrt(3));
//        TestHelper.expect(2, mySqrt(4));
//        TestHelper.expect(2, mySqrt(5));
//        TestHelper.expect(2, mySqrt(6));
//        TestHelper.expect(2, mySqrt(7));
//        TestHelper.expect(2, mySqrt(8));
//        TestHelper.expect(3, mySqrt(9));
//        TestHelper.expect(3, mySqrt(10));
//        TestHelper.expect(3, mySqrt(11));
//        TestHelper.expect(3, mySqrt(12));
//        TestHelper.expect(3, mySqrt(13));
//        TestHelper.expect(3, mySqrt(15));
//        TestHelper.expect(10, mySqrt(101));
//        TestHelper.expect(46339, mySqrt(2147395599));
//        TestHelper.expect(46340, mySqrt(2147483647));



    }

    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        if(x == 2 || x == 3) return 1;
        for(int index = 2; index < x; index++) {
//            System.out.println(" index = " + index + " :: " + (x / index) + " - " + (x % index));
            final int xx = index * index;
            if(xx == x || (xx + 1 == x)) {
                return index;
            }

            final int xxx = (index + 1) * (index + 1);
            if(xxx > x) {
                return index;
            }
        }
        return 0;
    }


}

