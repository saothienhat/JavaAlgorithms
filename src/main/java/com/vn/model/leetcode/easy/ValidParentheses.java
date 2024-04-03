package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.utils.TestHelper;

import java.util.Stack;

public class ValidParentheses extends LeetCodeTest {

    public ValidParentheses() {
        super("https://leetcode.com/problems/valid-parentheses/description/",
                "Valid Parentheses",
                TestLevel.EASY.name());
    }


    @Override
    public void run() {
        about();

//        TestHelper.expect(true, isValid("()"));
//        TestHelper.expect(true, isValid("()[]{}"));
//        TestHelper.expect(false, isValid("(]"));
//        TestHelper.expect(true, isValid("{[]}"));
//        TestHelper.expect(false, isValid("){"));
//        TestHelper.expect(false, isValid("))"));
//        TestHelper.expect(false, isValid("()))"));
    }

    public boolean isValid(String s) {
        final int size = s.length();
        if (size % 2 != 0) return false;
        int beginIndex = 0;
        int nextIndex = 1;

        final String firstStr = s.substring(beginIndex, nextIndex);
        if (firstStr.equals(")") || firstStr.equals("}") || firstStr.equals("]")) {
            return false;
        }

        Stack<String> stack = new Stack<String>();
        int aCount = 0; // {, [, (
        int bCount = 0; // }, ], )

        while (beginIndex < size || nextIndex < size) {
            String b = s.substring(beginIndex, nextIndex);
            if (b.equalsIgnoreCase("(") || b.equalsIgnoreCase("{") || b.equalsIgnoreCase("[")) {
                stack.push(b);
                aCount++;
            } else {
                bCount++;
                if (
                        (b.equals(")") && !stack.empty() && !stack.peek().equals("(")) ||
                                (b.equals("}") && !stack.empty() && !stack.peek().equals("{")) ||
                                (b.equals("]") && !stack.empty() && !stack.peek().equals("["))
                ) {
                    return false;
                }
                if (!stack.empty())
                    stack.pop();
            }

            beginIndex = nextIndex;
            nextIndex += 1;
        }

        return aCount == bCount && stack.empty();
    }
}
