package main

func main() {

}

/**
剑指 Offer 66. 构建乘积数组
*/

func constructArr(a []int) []int {
	res := 1
	b := make([]int, len(a))
	for i := range b {
		b[i] = 1
	}
	for i := 1; i < len(a); i++ {
		b[i] = b[i-1] * a[i-1] // 下三角
	}
	for i := len(a) - 2; i >= 0; i-- {
		res *= a[i+1] // 上三角
		b[i] *= res
	}
	return b
}

func constructArr2(a []int) []int {
	res := make([]int, len(a))
	for i, cur := 0, 1; i < len(a); i++ {
		res[i] = cur
		cur *= a[i]
	}
	for i, cur := len(a)-1, 1; i >= 0; i-- {
		res[i] *= cur
		cur *= a[i]
	}
	return res
}
