package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//평균은 넘겠지
public class Baek_4344 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			double sum = 0.0;

			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}

			double avg = sum / N;
			int cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > avg) {
					cnt++;
				}
			}
			double per = (double) cnt / N * 100;
			System.out.printf("%.3f%%\n", per);

		}

	}
}
