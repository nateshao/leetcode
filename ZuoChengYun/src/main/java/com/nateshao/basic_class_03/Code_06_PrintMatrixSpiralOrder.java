package com.nateshao.basic_class_03;

/**
 * @date Created by 邵桐杰 on 2021/9/23 17:17
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 转圈打印矩阵
 * 【题目】 给定一个整型矩阵matrix，请按照转圈的方式打印它。
 * 例如： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 打印结果为：1，2，3，4，8，12，16，15，14，13，9，5，6，7，11， 10
 * 【要求】 额外空间复杂度为O(1)。
 *
 * 旋转正方形矩阵
 * 【题目】 给定一个整型正方形矩阵matrix，请把该矩阵调整成顺时针旋转90度的样子。
 * 【要求】 额外空间复杂度为O(1)。
 */
//
public class Code_06_PrintMatrixSpiralOrder {
	public static void main(String[] args) {
		int[][] matrix = {  { 1, 2, 3, 4 },
				{ 5, 6, 7, 8 },
				{ 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		spiralOrderPrint(matrix);

	}
	/**
	 * 转圈打印矩阵
	 * @param matrix  矩阵
	 */
	public static void spiralOrderPrint(int[][] matrix) {
		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;
		while (tR <= dR && tC <= dC) {
			printEdge(matrix, tR++, tC++, dR--, dC--);
		}
	}
	/**
	 * 顺时针旋转打印
	 * (a,b)左上角坐标
	 * (c,d)右下角坐标
	 *
	 * @param m			矩阵
	 * @param tR	矩阵左上角行
	 * @param tC	矩阵左上角列
	 * @param dR	矩阵右下角行
	 * @param dC	矩阵右下角列
	 */
	public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
		// 左上角的行 = 右下角的行  （在同一行）
		if (tR == dR) {
			for (int i = tC; i <= dC; i++) { // 从左上角的行 到 右下角的行 一直加加 输出打印
				System.out.print(m[tR][i] + " ");
			}
		// 左上角的列 = 右下角的列  （在同一列）
		} else if (tC == dC) {				//  从左上角的列 到 右下角的列 一直加加 输出打印
			for (int i = tR; i <= dR; i++) {
				System.out.print(m[i][tC] + " ");
			}
		} else {
			int curC = tC;
			int curR = tR;
			while (curC != dC) {
				System.out.print(m[tR][curC] + " ");
				curC++;
			}
			while (curR != dR) {
				System.out.print(m[curR][dC] + " ");
				curR++;
			}
			while (curC != tC) {
				System.out.print(m[dR][curC] + " ");
				curC--;
			}
			while (curR != tR) {
				System.out.print(m[curR][tC] + " ");
				curR--;
			}
		}
	}



}
