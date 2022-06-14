package day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1022_소용돌이예쁘게출력하기 {
	static int r1, c1, r2, c2, len, N;
	static int[][] map;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		N = Math.max(Math.abs(r1), Math.max(Math.abs(r2), Math.max(Math.abs(c1), Math.abs(c2))));
		map = new int[r2 - r1 + 1][c2 - c1 + 1];
		tornado(0 - r1, 0 - c1);

		print(map);
		System.out.println(sb);
	}

	private static void tornado(int r, int c) {
		if (r >= 0 && r < map.length && c >= 0 && c < map[0].length) {
			map[r][c] = 1;
		}
		int L = 1;
		int n = 0;
		int d = 0;
		int cnt = 2;
		int count = 0;
		while (true) {
			if (r == N * 2 && c == N * 2) {
				break;
			}
			n++;
			r += dx[d];
			c += dy[d];
			if (r >= 0 && r < map.length && c >= 0 && c < map[0].length) {
				map[r][c] = cnt++;
				String str = map[r][c] + "";
				len = Math.max(len, str.length());
			} else {
				cnt++;
			}

			if (n == L) {
				d = (d + 1) % 4;
				n = 0;
				count++;
				if (count % 2 == 0) {
					L++;
				}
			}
		}

	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				String str = map[i][j] + "";
				for (int k = 0; k < len - str.length(); k++) {
					sb.append(" ");
				}
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
	}
}
