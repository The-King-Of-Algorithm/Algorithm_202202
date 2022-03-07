package day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1062_가르침 {

	static boolean[] alphabet;
	static char[][] str;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if (K < 5) {
			System.out.println(0);
			return;
		}
		alphabet = new boolean[26];
		alphabet['a' - 'a'] = true;
		alphabet['c' - 'a'] = true;
		alphabet['i' - 'a'] = true;
		alphabet['n' - 'a'] = true;
		alphabet['t' - 'a'] = true;

		int teach = (K - 5) > 0 ? K - 5 : 0;

		ArrayList<Character> list = new ArrayList<Character>();
		str = new char[N][];
		for (int i = 0; i < N; i++) {
			str[i] = bf.readLine().toCharArray();
			// System.out.println(Arrays.toString(str[i]));
			for (int j = 0; j < str[i].length; j++) {
				if (alphabet[str[i][j] - 'a'] != true) {
					if (!list.contains(str[i][j]))
						list.add(str[i][j]);
				}
			}
		}
		// System.out.println(list);
		teach = teach > list.size() ? list.size() : teach;
		combination(list, new char[teach], 0, 0);
		System.out.println(max);

	}

	private static void combination(ArrayList<Character> list, char[] sel, int start, int k) {
		if (k == sel.length) {
			//System.out.println(Arrays.toString(sel));
			operation(sel);
			return;
		}
		for (int i = start; i < list.size(); i++) {
			sel[k] = list.get(i);
			combination(list, sel, i + 1, k + 1);
		}
	}

	private static void operation(char[] sel) {
		int cnt = 0;
		if (sel != null) {
			for (int i = 0; i < sel.length; i++) {
				alphabet[sel[i] - 'a'] = true;
			}
		}

		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length; j++) {
				if (!alphabet[str[i][j] - 'a']) {
					break;
				}
				if (j == str[i].length - 1) {
					cnt++;
				}
			}
		}
		if (sel != null) {
			for (int i = 0; i < sel.length; i++) {
				alphabet[sel[i] - 'a'] = false;
			}
		}
		max = Math.max(max, cnt);
	}
}
