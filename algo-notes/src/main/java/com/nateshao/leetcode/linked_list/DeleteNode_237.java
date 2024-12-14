package com.nateshao.leetcode.linked_list;

/**
 * @date Created by 邵桐杰 on 2021/11/4 23:25
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: 237. 删除链表中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * <p>
 * 请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。
 * <p>
 * 题目数据保证需要删除的节点 不是末尾节点 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：指定链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [4,5,1,9], node = 1
 * 输出：[4,5,9]
 * 解释：指定链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9
 * 示例 3：
 * <p>
 * 输入：head = [1,2,3,4], node = 3
 * 输出：[1,2,4]
 * 示例 4：
 * <p>
 * 输入：head = [0,1], node = 0
 * 输出：[1]
 * 示例 5：
 * <p>
 * 输入：head = [-3,5,-99], node = -3
 * 输出：[5,-99]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [2, 1000]
 * -1000 <= Node.val <= 1000
 * 链表中每个节点的值都是唯一的
 * 需要删除的节点 node 是 链表中的一个有效节点 ，且 不是末尾节点
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteNode_237 {


    /**
     * 方法一：和下一个节点交换
     * 删除链表中的节点的常见的方法是定位到待删除节点的上一个节点，修改上一个节点的 \textit{next}next 指针，使其指向待删除节点的下一个节点，即可完成删除操作。
     * <p>
     * 这道题中，传入的参数 \textit{node}node 为要被删除的节点，无法定位到该节点的上一个节点。注意到要被删除的节点不是链表的末尾节点，因此 \textit{node}.\textit{next}node.next 不为空，可以通过对 \textit{node}node 和 \textit{node}.\textit{next}node.next 进行操作实现删除节点。
     * <p>
     * 在给定节点 \textit{node}node 的情况下，可以通过修改 \textit{node}node 的 \textit{next}next 指针的指向，删除 \textit{node}node 的下一个节点。但是题目要求删除 \textit{node}node，为了达到删除 \textit{node}node 的效果，只要在删除节点之前，将 \textit{node}node 的节点值修改为 \textit{node}.\textit{next}node.next 的节点值即可。
     * <p>
     * 例如，给定链表 4 \rightarrow 5 \rightarrow 1 \rightarrow 94→5→1→9，要被删除的节点是 55，即链表中的第 22 个节点。可以通过如下两步操作实现删除节点的操作。
     * <p>
     * 将第 22 个节点的值修改为第 33 个节点的值，即将节点 55 的值修改为 11，此时链表如下：
     * 4 \rightarrow 1 \rightarrow 1 \rightarrow 9
     * 4→1→1→9
     * <p>
     * 删除第 33 个节点，此时链表如下：
     * 4 \rightarrow 1 \rightarrow 9
     * 4→1→9
     * <p>
     * 达到删除节点 55 的效果。
     * <p>
     * JavaC#C++JavaScriptTypeScriptPython3Golang
     * <p>
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list/solution/shan-chu-lian-biao-zhong-de-jie-dian-by-x656s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
