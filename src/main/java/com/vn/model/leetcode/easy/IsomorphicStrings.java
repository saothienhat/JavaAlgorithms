package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.utils.TestHelper;

import java.util.HashMap;
import java.util.Map;



public class IsomorphicStrings extends LeetCodeTest {

    public IsomorphicStrings() {
        super("https://leetcode.com/problems/isomorphic-strings/?envType=daily-question&envId=2024-04-02",
                "Isomorphic Strings",
                TestLevel.EASY.name());
    }


    @Override
    public void run() {
        about();

//        TestHelper.expect(true, isIsomorphic("e", "a"));
//        TestHelper.expect(true, isIsomorphic("ed", "ad"));
//        TestHelper.expect(true, isIsomorphic("egg", "add"));
//        TestHelper.expect(false, isIsomorphic("foo", "bar"));
//        TestHelper.expect(true, isIsomorphic("paper", "title"));
        TestHelper.expect(false, isIsomorphic("badc", "baba"));

//        assertEquals(1, 1);
//        assertTrue(1 == 1);

    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.length() == 1) return true;

        int value = 0;
        Map<String, Integer> sMap = new HashMap<String, Integer>();
        Map<String, Integer> tMap = new HashMap<String, Integer>();

        int beginIndex = 0;
        int nextIndex = 1;

        while (beginIndex < s.length()) {
            String sChar = s.substring(beginIndex, nextIndex);
            String tChar = t.substring(beginIndex, nextIndex);
            if (!sMap.containsKey(sChar) && !tMap.containsKey(tChar)) {
                sMap.put(sChar, value);
                tMap.put(tChar, value);
                value++;

            } else {
                Integer sValue = sMap.get(sChar);
                Integer tValue = tMap.get(tChar);
                if (tValue == null || !tValue.equals(sValue)) return false;
            }
            beginIndex = nextIndex;
            nextIndex += 1;
        }

        return true;
    }
}
