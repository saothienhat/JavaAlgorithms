package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.utils.TestHelper;

public class LengthOfLastWord extends LeetCodeTest {

    public LengthOfLastWord() {
        super("https://leetcode.com/problems/length-of-last-word/",
                "Length of Last Word",
                TestLevel.EASY.name());
    }


    @Override
    public void run() {
        about();
        TestHelper.expect(5, lengthOfLastWord("Hello World"));
    }

    public int lengthOfLastWord(String s) {
        if(s.length() == 1) return 1;
        final String text = s.trim();
        String[] arr = text.split(" ");
        return arr[arr.length - 1].length();
    }
}
