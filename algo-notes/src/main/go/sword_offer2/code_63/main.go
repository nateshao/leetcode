package main

func main() {

}

func maxProfit(prices []int) int {
	max := 0
	for i := 0; i < len(prices); i++ {
		for j := i + 1; j < len(prices); j++ {
			if max < prices[j]-prices[i] {
				max = prices[j] - prices[i]
			}
		}
	}
	return max
}
