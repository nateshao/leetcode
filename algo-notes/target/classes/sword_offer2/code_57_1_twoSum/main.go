package main

func main() {

}

func twoSum(nums []int, target int) []int {
	left := 0
	right := len(nums) - 1
	for left < right {
		sum := nums[left] + nums[right]
		if sum > target {
			right--
		} else if sum < target {
			left++
		} else if sum == target {
			return []int{nums[left], nums[right]}
		}
	}
	return nil
}

func twoSum2(nums []int, target int) []int {
	left := 0
	right := len(nums) - 1
	for left < right {
		sum := nums[left] + nums[right]
		if sum == target {
			return []int{nums[left], nums[right]}
		} else if sum > target {
			right--
		} else {
			left++
		}
	}
	return nil
}
