package com.nateshao.hot100.code_two_pointers.code1_19_removeNthFromEnd;

/**
 * @date Created by 邵桐杰 on 2022/9/5 14:05
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class Solution {
    /**
     * 整体思路是让前面的指针先移动n步，之后前后指针共同移动直到前面的指针到尾部为止
     * 首先设立预先指针 pre，预先指针是一个小技巧，在第2题中进行了讲解
     * 设预先指针 pre 的下一个节点指向 head，设前指针为 start，后指针为 end，二者都等于 pre
     * start 先向前移动n步
     * 之后 start 和 end 共同向前移动，此时二者的距离为 n，当 start 到尾部时，end 的位置恰好为倒数第 n 个节点
     * 因为要删除该节点，所以要移动到该节点的前一个才能删除，所以循环结束条件为 start.next != null
     * 删除后返回 pre.next，为什么不直接返回 head 呢，因为 head 有可能是被删掉的点
     * 时间复杂度：O(n)
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //定义一个伪节点，用于返回结果
        ListNode pre = new ListNode(0);
        pre.next = head;
        //定义一个快慢指针,指向伪节点，用于遍历链表
        ListNode fast = pre, slow = pre;
        //让快指针先移动 n 步
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        // 只要快指针不指向空，就继续循环
        while (fast.next != null) {
            //让快慢指针同时移动
            slow = slow.next;
            fast = fast.next;
        }
        //这时慢指针移动到的位置就是，要删除节点的前一个节点
        //所以只要删除当前节点的下一个节点
        slow.next = slow.next.next;
        //返回为指针指向的头节点
        return pre.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
