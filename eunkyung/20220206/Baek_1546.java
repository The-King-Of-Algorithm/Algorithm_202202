package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//OX 퀴즈
public class Baek_1546 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			String str = bf.readLine();
			int cnt = 0;
			int sum = 0;
			
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == 'X') {
					cnt = 0;
				} else {
					cnt++;
					sum += cnt;
				}
			}
			System.out.println(sum);
		}

	}
}
