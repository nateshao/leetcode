package com.nateshao.sword_offer.topic_28_copyRandomList;

import java.util.HashMap;
import java.util.Map;

/**
 * @date Created by 邵桐杰 on 2021/12/2 14:05
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:  复杂链表的复制
 */
public class Solution {
    /**
     * 精选解答
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4. 构建新链表的 next 和 random 指向
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(head);
    }


    /**
     * 思路：先复制链表的 next 节点，将复制后的节点接在原节点后，然后复制其它的
     * 节点，最后取偶数位置的节点（复制后的节点）。
     *
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        Node node = new Node(head.val);
        Node temp = node;

        while (head.next != null) {
            temp.next = new Node(head.next.val);
            if (head.random != null) {
                temp.random = new Node(head.random.val);
            }
            head = head.next;
            temp = temp.next;
        }
        return head;
    }

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
