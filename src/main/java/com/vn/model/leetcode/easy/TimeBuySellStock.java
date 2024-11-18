package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.utils.TestHelper;

public class TimeBuySellStock extends LeetCodeTest {

    public TimeBuySellStock() {
        super("https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/",
                "Best Time to Buy and Sell Stock",
                TestLevel.EASY.name());
    }


    @Override
    public void run() {
        about();

        TestHelper.expect(5, maxProfit(new int[] {7,1,5,3,6,4}));

        TestHelper.expect(7, maxProfit2(new int[] {7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    // Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
    // Title: Best Time to Buy and Sell Stock II
    public int maxProfit2(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {

        }
        return maxProfit;
    }
}
