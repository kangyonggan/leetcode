package com.kangyonggan.leetcode;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的
 * 方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author kyg
 */
public class _0200Solution {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode r = new _0200Solution().addTwoNumbers(l1, l2);
        while (r != null) {
            System.out.print(r.val);
            r = r.next;
        }
        System.out.println();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r = new ListNode(0);
        ListNode p = r;
        ListNode q = p;

        int overNum = 0;
        while (l1 != null) {
            int sum = l1.val;
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += overNum;

            overNum = sum / 10;
            sum %= 10;

            p.val = sum;
            p.next = new ListNode(-1);
            q = p;
            p = p.next;

            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val;
            sum += overNum;

            overNum = sum / 10;
            sum %= 10;

            p.val = sum;
            p.next = new ListNode(-1);
            q = p;
            p = p.next;

            l2 = l2.next;
        }

        if (overNum > 0) {
            q = p;
            p.val = overNum;
        }

        if (p.val == -1) {
            q.next = null;
        }

        return r;
    }
}

