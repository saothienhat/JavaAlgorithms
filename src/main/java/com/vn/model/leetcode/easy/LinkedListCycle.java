package com.vn.model.leetcode.easy;

import com.vn.model.TestLevel;
import com.vn.model.leetcode.LeetCodeTest;
import com.vn.model.leetcode.ListNode;
import com.vn.utils.TestHelper;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle extends LeetCodeTest {

    public LinkedListCycle() {
        super("https://leetcode.com/problems/linked-list-cycle/",
                "Linked List Cycle",
                TestLevel.EASY.name());
    }

    @Override
    public void run() {

//        ListNode list = TestHelper.createListNode(new int[]{3,2,0,-4});
         ListNode list = TestHelper.createListNode(new int[]{-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5});

        list.display();
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
