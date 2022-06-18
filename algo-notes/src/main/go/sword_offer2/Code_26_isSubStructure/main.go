package main

func main() {

}

func isSame(A, B *TreeNode) bool {
	if A == nil && B != nil {
		return false
	}
	if B == nil {
		return true
	}
	if A.Val == B.Val {
		return isSame(A.Left, B.Left) && isSame(A.Right, B.Right)
	}
	return false
}

func isSubStructure(A *TreeNode, B *TreeNode) bool {
	//分类讨论所有情况
	if A == nil && B != nil {
		return false
	}
	if A != nil && B == nil {
		return false
	}
	//题目预定的空树不满足情况
	if A == nil && B == nil {
		return false
	}
	if isSame(A, B) {
		return true
	}
	return isSubStructure(A.Left, B) || isSubStructure(A.Right, B)
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
