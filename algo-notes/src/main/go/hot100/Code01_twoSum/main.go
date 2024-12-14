package Code01_twoSum

import "fmt"

func main() {
	fmt.Print("----------")
}

// 方法一：暴力枚举
func twoSum(nums []int, target int) []int {
	for i, x := range nums {
		for j := i + 1; j < len(nums); j++ {
			if x+nums[j] == target {
				return []int{i, j}
			}
		}
	}
	return nil
}

// 方法二：哈希表
func twoSum2(nums []int, target int) []int {
	hashTable := map[int]int{}
	for i, x := range nums {
		if p, ok := hashTable[target-x]; ok {
			return []int{p, i}
		}
		hashTable[x] = i
	}
	return nil
}

func twoSum3(nums []int, target int) []int {
	hashMap := map[int]int{}
	for i, num := range nums {
		if p, ok := hashMap[target-num]; ok {
			return []int{p, i}
		}
		hashMap[num] = i
	}
	return nil
}
