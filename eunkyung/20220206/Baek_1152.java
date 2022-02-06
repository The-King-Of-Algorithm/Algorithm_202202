package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1152 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		// System.out.println(st.countTokens());
		int cnt = 0;

		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());;
			cnt++;
		}
		System.out.println(cnt);
	}
}
