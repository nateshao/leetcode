package main

func main() {

}
func singleNumbers(nums []int) []int {
	res := 0
	div := 1
	a, b := 0, 0
	for _, v := range nums {
		res ^= v
	}
	for (div & res) == 0 {
		div <<= 1
	}
	for _, v := range nums {
		// 通过与运算进行分组
		if (v & div) == 0 {
			a ^= v
		} else {
			b ^= v
		}
	}
	return []int{a, b}
}
