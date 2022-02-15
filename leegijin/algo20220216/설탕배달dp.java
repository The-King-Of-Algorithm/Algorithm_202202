package algo20220216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달dp {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		int arr[] = new int[5001];
		arr[0] = 0;
		arr[1] = 987654321;
		arr[2] = 987654321;
		arr[3] = 1;
		arr[4] = 987654321;
		arr[5] = 1;
		arr[8] = 2;
		arr[10] = 2;

		for (int i = 5; i <= t; i++) {
			arr[i] = Math.min(arr[i - 3] + 1, arr[i - 5] + 1);
		}
		if (arr[t] >= 987654321) {
			System.out.println(-1);
		} else {
			System.out.println(arr[t]);
		}
	}

}
