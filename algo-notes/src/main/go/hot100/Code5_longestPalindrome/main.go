package main

func main() {

}

/**
 * 5. 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 寻找回文串的问题核心思想是：从中间开始向两边扩散来判断回文串，对于最长回文子串，就是这个意思
 */
func longestPalindrome(s string) string {
	if len(s) < 0 {
		return ""
	}
	res := ""
	for i := 0; i < len(s); i++ {
		s1 := palindrome(s, i, i)
		s2 := palindrome(s, i, i+1)
		if len(res) > len(s1) {
			res = res
		} else {
			res = s1
		}
		if len(res) > len(s2) {
			res = res
		} else {
			res = s2
		}
	}
	return res
}

func palindrome(s string, left int, right int) string {
	if len(s) < 0 {
		return ""
	}
	for left >= 0 && right < len(s) && s[left] == s[right] {
		left--
		right++
	}
	return s[left+1 : right]
}
