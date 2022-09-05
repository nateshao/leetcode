package main

import "math"

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

func maxProfit2(prices []int) int {
	profix := 0
	buyPrice := math.MaxInt32
	for _, price := range prices {
		if buyPrice > price {
			buyPrice = price
		}
		if price-buyPrice > profix {
			profix = price - buyPrice
		}
	}
	return profix
}

func maxProfit3(prices []int) int {
	maxProfit := 0
	buyPrice := math.MaxInt32
	for _, price := range prices {
		if buyPrice > price {
			buyPrice = price
		}

		if price-buyPrice > maxProfit {
			maxProfit = price - buyPrice
		}
	}
	return maxProfit
}
