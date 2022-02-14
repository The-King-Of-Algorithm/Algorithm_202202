package hw_20220214;

import java.util.Scanner;
//도영이가 만든 맛있는 음식
public class Baek_2961 {
	static int min = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] food = new int[N][2];

		for (int i = 0; i < N; i++) {
			int S = sc.nextInt();
			int B = sc.nextInt();
			food[i][0] = S;
			food[i][1] = B;
		}

		powerset(food, new boolean[N], 0, 0);
		System.out.println(min);

	}

	private static void powerset(int[][] food, boolean[] v, int idx, int k) {
		if (idx == food.length) {
			if (k != 0) {
				int[][] sel = new int[k][2];
				int n = 0;
				for (int i = 0; i < v.length; i++) {
					if (v[i] == true) {
						sel[n++] = food[i];
					}
				}				
				cooking(sel);
			}
			return;
		}
		v[idx] = true;
		powerset(food, v, idx + 1, k + 1);

		v[idx] = false;
		powerset(food, v, idx + 1, k);

	}

	private static void cooking(int[][] sel) {
		int S = 1;
		int B = 0;
		for (int i = 0; i < sel.length; i++) {
			if (sel[i][0] != 0 && sel[i][1] != 0) {
				S *= sel[i][0];
				B += sel[i][1];
			}
		}
		min = Math.min(min, Math.abs(S - B));
	}
}
