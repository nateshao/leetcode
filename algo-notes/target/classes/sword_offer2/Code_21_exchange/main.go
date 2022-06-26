package main

import "fmt"

func main() {
	nums := []int{1, 2, 3, 4}
	res := exchange(nums)
	for _, re := range res {
		fmt.Print(re)
	}
}
func exchange(nums []int) []int {
	left, right := 0, len(nums)-1
	for left < right { //循环条件
		if nums[left]%2 == 0 && nums[right]%2 != 0 { //满足则发生交换
			nums[left], nums[right] = nums[right], nums[left]
		}
		if nums[left]%2 != 0 { //i往后走
			left++
		}
		if nums[right]%2 == 0 { //j往前走
			right--
		}
	}
	return nums
}
