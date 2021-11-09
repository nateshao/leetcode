package com.nateshao.sword_offer.topic_00;

/**
 * @date Created by 邵桐杰 on 2021/11/9 23:09
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 定义链表
 */
public class ListNode {
    int val; // 数据
    ListNode next; // 下一个节点
    ListNode before; //
    public ListNode(){} // 创建一个无参数构造方法，用于初始化
    ListNode(int val){  // 创建一个有参数构造方法，便于给结点传数据
        this.val = val;
    }

}
