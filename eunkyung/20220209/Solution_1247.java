package hw_20220209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//최적경로
public class Solution_1247 {
	static int N;
	static int[][] arr, sel;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/최적경로.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(bf.readLine());
			arr = new int[N + 2][2];
			sel = new int[N][2];
			min = Integer.MAX_VALUE;

			StringTokenizer st = new StringTokenizer(bf.readLine());

			for (int i = 0; i < N + 2; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			select(new boolean[N], 0);
			System.out.println("#" + test_case + " " + min);
		}
	}

	private static void select(boolean[] v, int k) {
		if (k == sel.length) {
			sum();
			return;
		}

		for (int i = 0; i < arr.length - 2; i++) {
			if (v[i] == false) {
				v[i] = true;
				sel[k] = arr[i + 2];
				select(v, k + 1);
				v[i] = false;
			}
		}
	}

	private static void sum() {
		int sum = 0;
		int x = arr[0][0];
		int y = arr[0][1];

		for (int i = 0; i < sel.length; i++) {
			sum += Math.abs(x - sel[i][0]) + Math.abs(y - sel[i][1]);
			x = sel[i][0];
			y = sel[i][1];
		}
		sum += Math.abs(x - arr[1][0]) + Math.abs(y - arr[1][1]);
		min = Math.min(min, sum);

	}
}
