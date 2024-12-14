package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/**
 * 方法一：深度优先搜索：递归
 * 先序遍历 ：根左右
 * @param root1
 * @param root2
 * @return
 */
func mergeTrees(root1 *TreeNode, root2 *TreeNode) *TreeNode {
	// 如果一棵树有，另一棵树没有，接上去
	if root1 == nil {
		return root2
	}
	if root2 == nil {
		return root1
	}
	// 两棵树都有的节点，叠加节点值
	root1.Val += root2.Val
	// 递归合并左右子树
	root1.Left = mergeTrees(root1.Left, root2.Left)
	root1.Right = mergeTrees(root1.Right, root2.Right)
	return root1
}
