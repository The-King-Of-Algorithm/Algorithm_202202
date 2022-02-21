package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_4047_영준이의카드카운팅 {

	static int[][] dec;
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			dec = new int[4][13]; // 카드 수
			String str = br.readLine();
			flag = false;
			int S = 13, D = 13, H = 13, C = 13;
			String[][] input = new String[str.length() / 3][2];

			for (int i = 0; i < input.length; i++) {
				input[i][0] = str.substring(0+3*i, 1+3*i);
				input[i][1] = str.substring(1 + 3*i, 1 + 3*i + 2);
			}

			for (int i = 0; i < input.length; i++) {
				switch (input[i][0]) {
				case "S":
					check(0, Integer.parseInt(input[i][1]) - 1);
					break;
				case "D":
					check(1, Integer.parseInt(input[i][1]) - 1);
					break;
				case "H":
					check(2, Integer.parseInt(input[i][1]) - 1);
					break;
				case "C":
					check(3, Integer.parseInt(input[i][1]) - 1);
					break;
				}

				if (flag) {
					break;
				}
			}

			for (int i = 0; i < 13; i++) {
				S -= dec[0][i];
				D -= dec[1][i];
				H -= dec[2][i];
				C -= dec[3][i];
			}

			if (flag) {
				System.out.printf("#%d ERROR\n", tc);
			} else {
				System.out.printf("#%d %d %d %d %d\n", tc, S, D, H, C);
			}
		}
	}

	private static void check(int shape, int num) {
		if (dec[shape][num] == 1) {
			flag = true;
		} else {
			dec[shape][num]++;
		}
	}
}
