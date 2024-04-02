package com.vn.model.leetcode;

import java.util.ArrayList;
import java.util.List;
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    /// ---------------------------------------
    public void display() {
        // How to add node ? Example: 1 -> 2 -> 3 -> 4
        /**
         ListNode n4 = new ListNode(4);
         ListNode n3 = new ListNode(3, n4);
         ListNode n2 = new ListNode(2, n3);
         ListNode head = new ListNode(1, n2);
         */
        ListNode temp = new ListNode(this.val, this.next);
        List<Integer> list = new ArrayList<>();
        do {
            list.add(temp.val);
            temp = temp.next;
            if(temp.next == null) {
                list.add(temp.val);
            }
        } while(temp.next != null);
        final StringBuffer sb = new StringBuffer();
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" -> ");
        }
        System.out.println("ListNode: " + sb.toString());
    }
    public static void display(ListNode head) {
        ListNode temp = new ListNode(head.val, head.next);
        List<Integer> list = new ArrayList<>();
        do {
            list.add(temp.val);
            temp = temp.next;
            if(temp.next == null) {
                list.add(temp.val);
            }
        } while(temp.next != null);
        final StringBuffer sb = new StringBuffer();
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" -> ");
        }
        System.out.println("[INFO] ListNode: " + sb.toString());
    }
    public static ListNode createListNode(int[] values) {
        ListNode[] arr = new ListNode[values.length];
        for(int i = 0; i < values.length; i++) {
            arr[i] = new ListNode(values[i]);
        }
        for(int i = 0; i < values.length; i++) {
            if(i != values.length - 1) {
                arr[i].next = arr[i + 1];
            }
        }
        return arr[0];
    }
}

