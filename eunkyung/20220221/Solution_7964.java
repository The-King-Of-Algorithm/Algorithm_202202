package day07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//부먹 왕국의 차원 관문
public class Solution_7964 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/day07/7964.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int[] arr = new int[N + 2];
			int cnt = 0;
			st = new StringTokenizer(bf.readLine());
			for (int i = 1; i < arr.length - 1; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			arr[0] = 1;
			arr[N + 1] = 1;
			int j = 1;
			while (j < arr.length - 1) {
				if (arr[j] == 0) {
					boolean state = false;
					for (int d = 1; d < D; d++) {
						int n = j - d;
						if (n >= 0 && arr[n] == 1) {
							j++;
							state = true;
							break;
						}
					}
					if (!state) {
						arr[j] = 1;
						cnt++;
					}
				} else {
					j++;
				}
			}

			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println("#" + tc + " " + cnt);
		}

	}
}
