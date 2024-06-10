package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.utils.TestHelper;

public class FindIndexOfFirstOccurrenceInString extends LeetCodeTest {

    public FindIndexOfFirstOccurrenceInString() {
        super("https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/",
                "Find the Index of the First Occurrence in a String",
                TestLevel.EASY.name());
    }


    @Override
    public void run() {
        about();

//        TestHelper.expect(0, strStr("sadbutsad", "sad"));
         // TestHelper.expect(0, strStr("abcsadbutsad", "sad"));
        TestHelper.expect(0, strStr("a", "a"));
    }

    public int strStr(String haystack, String needle) {
        if(!haystack.contains(needle)) return -1;

        String[] arr = haystack.split(needle);
        if(arr.length == 0 || arr[0] == "") return 0;
        else {
            String ok = arr[0];
            return ok.length();
        }
    }

    // Other solution
    public int strStr_1(String haystack, String needle) {
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;
    }
}

