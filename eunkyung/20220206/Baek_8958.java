package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//평균
public class Baek_8958 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		int max = 0;
		int index = 0;

		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] > max) {
				max = arr[i];
				index = i;
			}
		}

		double[] arr2 = new double[N];
		double sum = 0.0;
		for (int i = 0; i < arr.length; i++) {
			if (i == index)
				arr2[i] = arr[i];
			arr2[i] = (double) arr[i] / max * 100;
			sum += arr2[i];
		}

		System.out.println(sum / N);

	}
}
