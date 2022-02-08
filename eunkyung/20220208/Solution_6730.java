package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//장애물 경주 난이도
public class Solution_6730 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(bf.readLine());
			int[] arr = new int[N];
			int up = 0;
			int down = 0;

			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N - 1; i++) {
				if (arr[i] > arr[i + 1]) //앞이 크면 내려가야함
					down = Math.max(down, arr[i] - arr[i + 1]);
				else //뒤에가 크면 올라가야함
					up = Math.max(up, arr[i + 1] - arr[i]);
			}

			System.out.println("#" + test_case + " " + up + " " + down);
		}
	}
}
