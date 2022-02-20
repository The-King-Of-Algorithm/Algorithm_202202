package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//영준이의 카드 카운팅
public class Solution_4047 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = bf.readLine();
			int[][] card = new int[4][14];
			StringBuilder sb = new StringBuilder();
			boolean state = true;

			int i = 0;
			while (i < str.length()) {
				char c = str.charAt(i++);
				String s = String.valueOf(str.charAt(i++)) + String.valueOf(str.charAt(i++));
				int n = Integer.parseInt(s);

				if (c == 'S') {
					if (card[0][n] != 1) {
						card[0][n] = 1;
					} else {
						state = false;
						break;
					}
				} else if (c == 'D') {
					if (card[1][n] != 1) {
						card[1][n] = 1;
					} else {
						state = false;
						break;
					}
				} else if (c == 'H') {
					if (card[2][n] != 1) {
						card[2][n] = 1;
					} else {
						state = false;
						break;
					}
				} else if (c == 'C') {
					if (card[3][n] != 1) {
						card[3][n] = 1;
					} else {
						state = false;
						break;
					}
				}
			}

			sb.append("#" + tc + " ");
			if (state) {
				for (int j = 0; j < card.length; j++) {
					int cnt = 0;
					for (int j2 = 1; j2 < card[j].length; j2++) {
						if (card[j][j2] == 0) {
							cnt++;
						}
					}
					sb.append(cnt + " ");
				}
			} else {
				sb.append("ERROR");
			}

			System.out.println(sb);

		}
	}
}
