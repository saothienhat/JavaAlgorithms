package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.utils.TestHelper;

import java.util.Arrays;

public class LongestCommonPrefix extends LeetCodeTest {

    public LongestCommonPrefix() {
        super("https://leetcode.com/problems/longest-common-prefix/description/",
                "Longest Common Prefix",
                TestLevel.EASY.name());
    }


    @Override
    public void run() {
        about();

//        TestHelper.expect("flower", longestCommonPrefix(new String[] {"flower"}));
//        TestHelper.expect("fl", longestCommonPrefix(new String[] {"flower","flow","flight"}));
//        TestHelper.expect("", longestCommonPrefix(new String[] {"dog","racecar","car"}));
//         TestHelper.expect("", longestCommonPrefix(new String[] {"", "c"}));
//        TestHelper.expect("c", longestCommonPrefix(new String[] {"ca", "c"}));
//        TestHelper.expect("ca", longestCommonPrefix(new String[] {"ca", "ca"}));
//        TestHelper.expect("", longestCommonPrefix(new String[] {"a", "b"}));
    }


    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];

        final int size = strs.length;
        int minSize = strs[0].length();
        for(int i = 0; i < size; i++) {
            if("".equalsIgnoreCase(strs[i])) return "";
            if(minSize > strs[i].length()) minSize = strs[i].length();
        }

        final int beginIndex = 0;
        int nextIndex = 1;
        boolean isFound = false;
        String temp = "";
        String nextStr = "";

        final String firstStr = strs[0];
        do {
            temp = firstStr.substring(beginIndex, nextIndex);
            for(int i = 1; i < size; i++) {
                if(!temp.equalsIgnoreCase(strs[i].substring(beginIndex, nextIndex))) {
                    isFound = true;
                    if(nextIndex == 1) {
                        return "";
                    } else {
                        return nextStr;
                    }
                }
            }

            nextStr = temp;
            if(minSize == nextIndex) return nextStr;
            nextIndex++;
        } while(!isFound);

        return "";
    }

    // Best Solution
//    public String longestCommonPrefix(String[] strs) {
//        Arrays.sort(strs);
//        String start = strs[0];
//        String end = strs[strs.length-1];
//        int prefixLen = 0;
//        while (prefixLen < start.length() && prefixLen < end.length()) {
//            if (start.charAt(prefixLen) == end.charAt(prefixLen)) {
//                prefixLen++;
//            }
//            else {
//                break;
//            }
//        }
//        return start.substring(0, prefixLen);
//    }

}
