package hw_20220215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//금민수의 개수
public class Baek_1527 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int cnt = 0;

		for (int i = A; i <= B; i++) {
			boolean state = true;
			int n = i;
			while (n > 0) {
				if (n % 10 == 4 || n % 10 == 7) {
					n /= 10;
				} else {
					state = false;
					break;
				}
			}
			if (state) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
