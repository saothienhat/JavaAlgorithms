package com.vn.utils;

import com.vn.model.ConsoleColors;
import com.vn.model.leetcode.ListNode;

public final class TestHelper {
    public static ListNode createListNode(int[] values) {
        return ListNode.createListNode(values);
    }

    public static String display(int[] values) {
        final StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]).append(", ");
        }
        sb.append(" }");
        return sb.toString();
    }
    public static void expect(int expectedValue, int actualValue) {
        if(expectedValue == actualValue) {
            System.out.println(ConsoleColors.GREEN + "[PASS] Expected: " + expectedValue + " - Actual: " + actualValue + ConsoleColors.RESET);
        } else {
            System.err.println(ConsoleColors.RED + "[FAIL] Expected: " + expectedValue + " - Actual: " + actualValue + ConsoleColors.RESET);
        }
    }
    public static void expect(boolean expectedValue, boolean actualValue) {
        if(expectedValue == actualValue) {
            System.out.println(ConsoleColors.GREEN + "[PASS] Expected: " + expectedValue + " - Actual: " + actualValue + ConsoleColors.RESET);
        } else {
            System.err.println(ConsoleColors.RED + "[FAIL] Expected: " + expectedValue + " - Actual: " + actualValue + ConsoleColors.RESET);
        }
    }
    public static void expect(String expectedValue, String actualValue) {
        if(expectedValue != null && expectedValue.equalsIgnoreCase(actualValue)) {
            System.out.println(ConsoleColors.GREEN + "[PASS] Expected: " + expectedValue + " - Actual: " + actualValue + ConsoleColors.RESET);
        } else {
            System.err.println(ConsoleColors.RED + "[FAIL] Expected: " + expectedValue + " - Actual: " + actualValue + ConsoleColors.RESET);
        }
    }

}
