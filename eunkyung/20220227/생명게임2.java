package day13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 생명게임2 {
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int[][] map;
	static boolean[][] check;
	static int N, M, x, y, z, k;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/day13/생명게임1.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(bf.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		z = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		k = Integer.parseInt(bf.readLine());

		for (int K = 0; K < k; K++) {
			check = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					operation(i, j);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(check[i][j]) map[i][j]=1;
					else map[i][j]=0;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}

	}

	private static void operation(int r, int c) {
		int cnt = 0;
		for (int d = 0; d < dx.length; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1) {
				cnt++;
			}
		}

		if (map[r][c] == 0) {
			if (cnt == x)
				check[r][c] = true;
		} else {
			if (cnt >= y && cnt < z)
				check[r][c] = true;
		}
	}
}
