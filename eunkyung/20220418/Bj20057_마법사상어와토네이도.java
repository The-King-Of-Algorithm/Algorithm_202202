package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj20057_마법사상어와토네이도 {
	static int N, sum = 0, count = 0;
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dr = { -2, -1, -1, -1, 0, 0, 0, 0, 1, 1, 1, 2 };
	static int[] dc = { 0, -1, 0, 1, -2, -1, 1, 2, -1, 0, 1, 0 };
	static int[][] dir = { { 3, 10, 0, 11, 2, 9, 4, 1, 8 }, { 1, 3, 4, 7, 5, 6, 11, 8, 10 },
			{ 1, 8, 0, 11, 2, 9, 7, 3, 10 }, { 8, 10, 4, 7, 5, 6, 0, 1, 3 } };
	static int[] percent = { 1, 1, 2, 2, 7, 7, 5, 10, 10 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	//	print(map);

		tornado(N / 2, N / 2, 0, 0, 1);
		System.out.println(sum);
	}

	private static void tornado(int r, int c, int d, int cnt, int limit) {
		if (r == 0 && c == 0)
			return;
		if (cnt == limit) {
			cnt = 0;
			count++;
			d = (d + 1) % 4;
			if (count % 2 == 0)
				limit++;
		}

		r += dx[d];// y좌표
		c += dy[d];
		int y = map[r][c];
		for (int i = 0; i < percent.length; i++) {
			int nr = r + dr[dir[d][i]];
			int nc = c + dc[dir[d][i]];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				map[nr][nc] += (int) (y * (percent[i] / 100.0));
			} else {
				sum += (int) (y * (percent[i] / 100.0));
			}
			map[r][c] -= (int) (y * (percent[i] / 100.0));
		}
		if (r + dx[d] >= 0 && r + dx[d] < N && c + dy[d] >= 0 && c + dy[d] < N) {
			map[r + dx[d]][c + dy[d]] += map[r][c];
		} else {
			sum += map[r][c];
		}
		map[r][c] = 0;
		tornado(r, c, d, cnt + 1, limit);
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
