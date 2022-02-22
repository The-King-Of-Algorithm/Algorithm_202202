package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백만장자의 사재기
public class Solution_1859 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// System.setIn(new FileInputStream("src/day06/1859.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			long sell = arr[arr.length - 1];
			long buy = 0L;
			long sum = 0L;
			int cnt = 0;
			for (int i = arr.length - 2; i >= 0; i--) {

				if (arr[i] > sell) {// 앞이 셀보다 크면
					// 더하고 셀값 변경
					sum += sell * cnt - buy;
					cnt = 0;
					buy = 0;
					sell = arr[i];
				} else {
					buy += arr[i];
					cnt++;
				}
			}

			sum += sell * cnt - buy;
			System.out.println("#" + tc + " " + sum);
		}
	}
}
