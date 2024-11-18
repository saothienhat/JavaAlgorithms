package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.utils.TestHelper;

public class ValidPalindrome extends LeetCodeTest {

    public ValidPalindrome() {
        super("https://leetcode.com/problems/valid-palindrome/",
                "Valid Palindrome",
                TestLevel.EASY.name());
    }

    @Override
    public void run() {
        TestHelper.expect(true, isPalindrome("A man, a plan, a canal: Panama"));
        TestHelper.expect(false, isPalindrome("race a car"));
        TestHelper.expect(true, isPalindrome("a."));
    }

    public boolean isPalindrome(String s) {
        final String text = s.trim().toLowerCase()
                .replaceAll(",", "")
                .replaceAll(";", "")
                .replaceAll("\\.", "")
                .replaceAll(" ", "")
                .replaceAll(":", "")
                .replaceAll("@", "")
                .replaceAll("#", "")
                .replaceAll("%", "")
                .replaceAll("&", "")
                .replaceAll("^", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .replaceAll("!", "")
                .replaceAll("\"", "")
                .replaceAll("'", "")
                .replaceAll("`", "")
                .replaceAll("\\\\", "")
                .replaceAll("\\/", "")
                .replaceAll("\\{", "")
                .replaceAll("\\}", "")
                .replaceAll("]", "")
                .replaceAll("\\[", "")
                .replaceAll("-", "")
                .replaceAll("_", "")
                .replaceAll("\\?", "")
                .replaceAll("$", "");

        final int size = text.length();
        if(size == 1) return true;
        for (int i = 0; i < size; i++) {
            if(text.charAt(i) != text.charAt(size - 1 -i)) {
                return false;
            }
        }
        return true;
    }
}
