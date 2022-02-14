package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_6808_규영이와인영이의카드게임 {

	static int[] card_K, card_I, sel;
	static int win, lose;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			card_K = new int[9]; // 규영's 카드
			card_I = new int[9]; // 인영's 카드
			boolean[] v = new boolean[18];
			sel = new int[9];
			win = 0;
			lose = 0;

			// 규영이 카드 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				card_K[i] = Integer.parseInt(st.nextToken());
				v[card_K[i] - 1] = true;
			}
			// 인영이 카드 입력
			int a = 0;
			for (int i = 0; i < 18; i++) {
				if (!v[i]) {
					card_I[a] = i + 1;
					a++;
				}
			}

			permutation(0, 0);

			System.out.printf("#%d %d %d\n", tc, win, lose);
		}

	}

	private static void permutation(int k, int flag) {

		int kyu = 0, in = 0;
		
		if (k == sel.length) {
			for (int i = 0; i < 9; i++) {
				if (sel[i] > card_K[i]) {
					in += sel[i] + card_K[i];
				} else if (sel[i] < card_K[i]) {
					kyu += sel[i] + card_K[i];
				}
			}
			
			if(kyu > in) {
				win++;
			} else {
				lose++;
			}
			return;
		}

		for (int i = 0; i < 9; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			
			sel[k] = card_I[i];
			permutation(k + 1, (flag | 1 << i));

		}
	}

}
