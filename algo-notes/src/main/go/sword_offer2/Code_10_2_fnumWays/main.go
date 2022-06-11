package main

import "fmt"

func main() {
	ways := numWays(7)
	fmt.Println(ways)
}

func numWays(n int) int {
	if n == 0 || n == 1 {
		return 1
	}
	dp := make([]int, n+1)
	dp[1] = 1
	dp[2] = 2
	for i := 3; i <= n; i++ {
		dp[i] = (dp[i-1] + dp[i-2]) % 1000000007
	}
	return dp[n]
}
