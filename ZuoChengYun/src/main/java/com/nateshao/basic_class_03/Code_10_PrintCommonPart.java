package com.nateshao.basic_class_03;

/**
 * @date Created by 邵桐杰 on 2021/9/18 20:03
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 题目十 打印两个有序链表的公共部分
 * 【题目】 给定两个有序链表的头指针head1和head2，打印两个 链表的公共部分。
 * <p>
 * 解题思路：链表的公共部分，其实就是两个链表重合的地部分。重合的情况有好几种，
 * 1、完全重合。两个链表的首尾node都一样。
 * 2、部分重合。呈一字型，也就是某个链表的尾部与另一个链表的前半部分有重合。
 * 3、部分重合。呈Y字型，两个链表的尾部完全重合
 * 这道题很简单，因为有序，所以就比较大小，小的指针往后移动。直到发现有指针为空到达尾部。
 */
public class Code_10_PrintCommonPart {

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printLinkedList(node1);
        printLinkedList(node2);
        printCommonPart(node1, node2);

    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void printCommonPart(Node head1, Node head2) {
        System.out.print("Common Part: ");
        if (head1 == null || head2 == null) return;
        while (head1 != null && head2 != null) {
            // head1 = (head1.value < head2.value) ? head2.next : head1.next;

            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }


}
