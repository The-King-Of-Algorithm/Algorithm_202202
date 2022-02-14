package hw_20220214;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//규영이와 인영이의 카드게임
public class Solution_6808 {
	static int[] card_k, card_i;
	static int win = 0, lose = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/hw_20220214/6808.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			card_k = new int[9];
			card_i = new int[9];
			win = 0;
			lose = 0;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < 9; i++) {
				card_k[i] = Integer.parseInt(st.nextToken());
			}

			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				boolean state = true;
				for (int j = 0; j < card_k.length; j++) {
					if (i == card_k[j]) {
						state = false;
					}
				}
				if (state) {
					card_i[idx++] = i;
				}
			}

			permutation(new int[9], new boolean[9], 0);
			System.out.println("#" + tc + " " + win + " " + lose);
		}
	}

	private static void permutation(int[] sel, boolean[] v, int k) {
		if (k == sel.length) {
			operation(sel);
			return;
		}

		for (int i = 0; i < v.length; i++) {
			if (v[i] == false) {
				v[i] = true;
				sel[k] = card_i[i];
				permutation(sel, v, k + 1);
				v[i] = false;
			}
		}
	}

	private static void operation(int[] sel) {
		int total_k = 0;
		int total_i = 0;

		for (int i = 0; i < sel.length; i++) {
			if (card_k[i] > sel[i]) {
				total_k += card_k[i] + sel[i];
			} else {
				total_i += card_k[i] + sel[i];
			}
		}

		if (total_k > total_i) {
			win++;
		} else {
			lose++;
		}
	}
}
