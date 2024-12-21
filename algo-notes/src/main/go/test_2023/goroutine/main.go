package main

import (
	"fmt"
	"sync"
)

func printChar(wg sync.WaitGroup, ch string, times int, done chan struct{}) {
	defer wg.Done()
	for i := 0; i < times; i++ {
		<-done
		print(ch)
		done <- struct{}{}
	}

}
func main() {
	var n int
	fmt.Scan(&n)
	var wx sync.WaitGroup
	done := make(chan struct{}, 1)
	done <- struct{}{}
	wx.Add(3)
	go printChar(wx, "A", n, done)
	go printChar(wx, "B", n, done)
	go printChar(wx, "C", n, done)
	wx.Wait()
	fmt.Println()
}
