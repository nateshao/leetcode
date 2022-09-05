package main

func main() {

}
func singleNumber(nums []int) (ans int) {
	var left int
	mp := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		mp[nums[i]]++
		for mp[nums[left]] == 3 {
			left++
		}
	}
	return nums[left]
}
