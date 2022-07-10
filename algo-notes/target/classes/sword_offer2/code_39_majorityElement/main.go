package main

import "sort"

func main() {

}

func majorityElement(nums []int) int {
	num := sort.IntSlice(nums)
	sort.Sort(num)
	return num[len(num)/2]
}
