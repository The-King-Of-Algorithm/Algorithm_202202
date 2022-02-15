package algo20220216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달greedy {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(bf.readLine());
		int cnt = 0;

		while (true) {
			if (n % 5 == 0) { // 5로 나누어 떨어지면 계산할 필요 없음
				System.out.println(n / 5 + cnt);
				break;
			} else if (n <= 0) {
				System.out.println(-1);
				break;
			}
			n = n - 3;
			cnt++;
		}
	}
}