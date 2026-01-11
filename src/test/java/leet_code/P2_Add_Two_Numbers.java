package leet_code;

import org.junit.jupiter.api.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

LodeList라는것으로 덧셈 올림(carry) 처리 계산
 */
public class P2_Add_Two_Numbers {

    static class ListNode {
        int val;
        P2_Add_Two_Numbers.ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, P2_Add_Two_Numbers.ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            P2_Add_Two_Numbers.ListNode current = this;
            while (current != null) {
                sb.append(current.val);
                if (current.next != null) {
                    sb.append(" -> ");
                }
                current = current.next;
            }
            return sb.toString();
        }
    }

    static ListNode fromArray(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : arr) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }

    @Test
    void testExample1(){
        ListNode l1 = fromArray(new int[]{2, 4, 3});
        ListNode l2 = fromArray(new int[]{5, 6, 4});

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    @Test
    void testExample2(){
        ListNode l1 = fromArray(new int[]{0});
        ListNode l2 = fromArray(new int[]{0});

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    @Test
    void testExample3(){
        ListNode l1 = fromArray(new int[]{9,9,9,9,9,9,9});
        ListNode l2 = fromArray(new int[]{9,9,9,9});

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }
}
