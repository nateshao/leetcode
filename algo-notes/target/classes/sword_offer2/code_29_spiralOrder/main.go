package main

func main() {

}

func spiralOrder(matrix [][]int) []int {
	if len(matrix) == 0 { // 长度为0，返回nil
		return nil
	}
	res := []int{}
	top, bottom, left, right := 0, len(matrix)-1, 0, len(matrix[0])-1 //初始各个边界
	for bottom >= top && right >= left {                              //循环条件，下大于等于上，右大于等于左
		for i := left; i <= right; i++ { //top行的从左到右遍历
			res = append(res, matrix[top][i])
		}
		top++                            //top行遍历完了，top往下移动
		for i := top; i <= bottom; i++ { //right列的从上到下遍历
			res = append(res, matrix[i][right])
		}
		right--                           //right列遍历完了，right向左移动
		if left > right || top > bottom { //这里一定要做一个判断，因为如果只剩下一个元素就会出错
			break
		}
		for i := right; i >= left; i-- { //bottom行的从右往左遍历
			res = append(res, matrix[bottom][i])
		}
		bottom--                         //bottom往上移动
		for i := bottom; i >= top; i-- { //left列的从下到上遍历
			res = append(res, matrix[i][left])
		}
		left++ //left向右移动
	}
	return res
}
