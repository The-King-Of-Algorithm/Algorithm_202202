package day11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//요리사
public class Solution_4012 {
	static int[][] food;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/day11/요리사.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			food = new int[N][N];
			min = Integer.MAX_VALUE;

			for (int i = 0; i < food.length; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < food.length; j++) {
					food[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			combination(new int[N / 2], 0, 0);
			System.out.println("#" + tc + " " + min);
		}
	}

	private static void combination(int[] sel, int idx, int k) {
		if (k == sel.length) {
			operation(sel);
			return;
		}

		for (int i = idx; i < food.length; i++) {
			sel[k] = i;
			combination(sel, i + 1, k + 1);
		}
	}

	private static void operation(int[] sel) {
		int sumA = 0;
		int sumB = 0;
		int k = 0;
		for (int i = 0; i < food.length; i++) {
			if (i == sel[k]) {
				for (int j = 0; j < sel.length; j++) {
					sumA += food[i][sel[j]];
				}
				if (k < sel.length - 1) {
					k++;
				}
			} else {
				int k2 = 0;
				for (int j = 0; j < food.length; j++) {
					if (j != sel[k2]) {
						sumB += food[i][j];
					} else {
						if (k2 < sel.length - 1) {
							k2++;
						}
					}
				}
			}
		}

		min = Math.min(min, Math.abs(sumA - sumB));

	}

	private static void print(int[][] food) {
		for (int i = 0; i < food.length; i++) {
			for (int j = 0; j < food[i].length; j++) {
				System.out.print(food[i][j] + " ");
			}
			System.out.println();
		}
	}
}
