package com.nateshao.basic_class_03;
/**
 * @date Created by 邵桐杰 on 2021/9/20 10:06
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: “之”字形打印矩阵
 * 【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这 个矩阵，
 * 例如： 1 2 3 4 5 6 7 8 9 10 11 12
 * “之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11，
 */
public class Code_08_ZigZagPrintMatrix {

	public static void printMatrixZigZag(int[][] matrix) {
		int tR = 0; // t点行坐标
		int tC = 0; // t点列坐标
		int dR = 0;	// d点行坐标
		int dC = 0; // d点列坐标
		int endR = matrix.length - 1;
		int endC = matrix[0].length - 1;
		boolean fromUp = false;
		while (tR != endR + 1) { // a点往下走完，到最后一个点
			printLevel(matrix, tR, tC, dR, dC, fromUp);
			tR = tC == endC ? tR + 1 : tR; // 如果是走到最后一列，我就往下走，否则，我不变
			tC = tC == endC ? tC : tC + 1;
			dC = dR == endR ? dC + 1 : dC; // 来到最后一行，就++,否则不变
			dR = dR == endR ? dR : dR + 1; // 到最后一行不变，否则增加
			fromUp = !fromUp; // 一开始从对角线从上往下打印，然后从下往上打印。
		}
		System.out.println();
	}

	/**
	 * 打印 ，左上角到右下角打印or右下角到左上角打印
	 * @param m
	 * @param tR
	 * @param tC
	 * @param dR
	 * @param dC
	 * @param f
	 */
	public static void printLevel(int[][] m, int tR, int tC, int dR, int dC,
			boolean f) {
		if (f) {
			while (tR != dR + 1) {
				System.out.print(m[tR++][tC--] + " ");
			}
		} else {
			while (dR != tR - 1) {
				System.out.print(m[dR--][dC++] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printMatrixZigZag(matrix);

	}

}
