package com.notes.leetcode;

import org.junit.Test;

/**
 *
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxiaoyu
 * @date 2021/2/23
 */
public class Question2 {

    @Test
    public void testTwoNumbers(){
        ListNode l1 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9)))))));
        ListNode l2 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))));
         ListNode twoNumbers = addTwoNumbers(l1, l2);
        do {
            System.out.print(twoNumbers.val+"->");
            twoNumbers = twoNumbers.next;
        } while (twoNumbers != null);

    }

    @Test
    public void testTwoNumbers1(){
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        ListNode twoNumbers = addTwoNumbers(l1, l2);
        do {
            System.out.print(twoNumbers.val+"->");
            twoNumbers = twoNumbers.next;
        } while (twoNumbers != null);

    }

    public static void main(String[] args) {
        final int i = 23;
        System.out.println(i/10);
        System.out.println(i%10);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null && l2 != null){
            return l2;
        }
        if(l1 != null && l2 == null){
            return l1;
        }
        ListNode result = new ListNode();
        ListNode firstNode = new ListNode();
        boolean isUp = false;
        for (int i = 0; i < 100; i++) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            result.val = val1 + val2;
            if(isUp){
                result.val += 1;
            }
            if(result.val > 9){
                result.val = result.val % 10;
                isUp = true;
            }else {
                isUp = false;
            }
            if(i == 0){
                firstNode = result;
            }
            if(l1.next == null && l2.next == null && !isUp){
                break;
            }
            ListNode resultNext = new ListNode();
            result.next = resultNext;
            result = resultNext;
            l1 = l1.next;
            if(l1 == null){
                l1 = new ListNode(0);
            }
            l2 = l2.next;
            if(l2 == null){
                l2 = new ListNode(0);
            }
        }

        return firstNode;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
