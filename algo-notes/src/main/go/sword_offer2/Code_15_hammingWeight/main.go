package main

import "fmt"

func main() {
	num := 00000000000000000000000000001011
	weight := hammingWeight(uint32(num))
	fmt.Println(weight)

	println(hammingWeight2(uint32(num)))
}

// num和num-1进行&运算
func hammingWeight(num uint32) int {
	res := 0
	for ; num > 0; num &= (num - 1) { //让num和num-1进行&运算，并把值赋给num，条件为num>0
		res++ //做几次运算就有几个1
	}
	return res
}

func hammingWeight2(num uint32) int {
	res := 0
	for i := 0; i < 32; i++ { //做一个32次的循环即可
		if 1<<i&num > 0 { //i每次向左移一位
			res++
		}
	}
	return res
}
