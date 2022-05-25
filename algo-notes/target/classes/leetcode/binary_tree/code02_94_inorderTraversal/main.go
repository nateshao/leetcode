package main

func main() {

}
func inorderTraversal(root *TreeNode) (res []int) {
	var preorder func(*TreeNode)
	preorder = func(node *TreeNode) {
		if node == nil {
			return
		}
		preorder(node.Left)
		res = append(res, node.Val)
		preorder(node.Right)
	}
	preorder(root)
	return
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
