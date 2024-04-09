package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.utils.AppLogger;
import com.vn.utils.TestHelper;

public class TimeNeededToBuyTickets extends LeetCodeTest {

    public TimeNeededToBuyTickets() {
        super("https://leetcode.com/problems/time-needed-to-buy-tickets/description/?envType=daily-question&envId=2024-04-09",
                "Time Needed to Buy Tickets",
                TestLevel.EASY.name());
    }

    @Override
    public void run() {
        about();

        // TestHelper.expect(6, timeRequiredToBuy(new int[]{2, 3, 2}, 2));
//         TestHelper.expect(8, timeRequiredToBuy(new int[]{5,1,1,1}, 0));
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        final int size = tickets.length;

        boolean isFinish = false;
        int totalTime = 0;
        do {
            for(int index = 0; index < size; index++) {
                if(tickets[k] == 0) {
                    isFinish = true;
                    break;
                }
                tickets[index] = tickets[index] - 1;
                if(tickets[index] >= 0) totalTime++;
            }
        } while(isFinish != true);

        return totalTime;
    }
}
