package com.vn.model.hackerrank.easy;

import com.vn.model.BaseTest;
import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeTest;

import java.util.Scanner;

public class StringBase extends BaseTest {

    public StringBase() {
        super("https://leetcode.com/problems/minimum-depth-of-binary-tree",
                "Minimum Depth of Binary Tree",
                TestLevel.EASY.name());
    }

    @Override
    public void run() {

//        Scanner sc = new Scanner(System.in);
//        String A = sc.next();
//        String B = sc.next();
        String A = "h";
        String B = "world";

//        A.charAt(0) > B.charAt(0)
        int aValue = Integer.valueOf(A.charAt(0));
        int bValue = Integer.valueOf(B.charAt(0));

        System.out.println(A.length() + B.length());
        if(aValue < bValue) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }

        System.out.println(capitalize(A) + " " + capitalize(B));

    }

    private String capitalize(String text) {
        String a = text.toLowerCase();
        return String.valueOf(text.charAt(0)).toUpperCase() + a.substring(1, a.length());
    }
}
