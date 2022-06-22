package main

func main() {

}
func verifyPostorder(postorder []int) bool {
	if len(postorder) < 2 {
		return true
	}

	index := len(postorder) - 1   // 区分左右子树：左子树上的值全都比根节点小，右子树上的值全都比根节点大
	rootValue := postorder[index] // 用来记录根节点的值

	for k, v := range postorder {
		// 当出现第一个大于根节点的值时，这个值往后全是右子树
		if index == len(postorder)-1 && v > rootValue {
			index = k
		}
		// 在右子树中出现小于根节点的值时，则该树不是二叉搜索树
		if index != len(postorder)-1 && rootValue > v {
			return false
		}
	}
	return verifyPostorder(postorder[:index]) && verifyPostorder(postorder[index:len(postorder)-1])
}
