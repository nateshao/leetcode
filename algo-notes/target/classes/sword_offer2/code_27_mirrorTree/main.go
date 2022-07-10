package main

func main() {

}

/**
递归
*/
func mirrorTree(root *TreeNode) *TreeNode {
	// 递归终止条件
	if root == nil {
		return nil
	}
	// 交换左右子树
	root.Left, root.Right = root.Right, root.Left
	root.Left = mirrorTree(root.Left) // 递归
	root.Right = mirrorTree(root.Right)
	return root
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
