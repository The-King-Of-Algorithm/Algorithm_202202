package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW5656_벽돌깨기 {
	static int N, W, H, min;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			permutation(new int[N], 0);
			// print(map);
			System.out.println("#" + tc + " " + min);
		}
	}

	private static void permutation(int[] sel, int k) {
		if (k == sel.length) {
			//System.out.println(Arrays.toString(sel));
			int[][] tmp = new int[H][W];
			for (int i = 0; i < tmp.length; i++) {
				for (int j = 0; j < tmp[i].length; j++) {
					tmp[i][j] = map[i][j];
				}
			}
			for (int i = 0; i < sel.length; i++) {
				int n = -1;
				while (++n < H) {
					if (tmp[n][sel[i]] > 0) {
					//	print(tmp);
						//System.out.println(n+" "+sel[i]);
						bfs(n, sel[i], tmp);

						// 맵 내리기
						down(tmp);
						// print(tmp);

						break;
					}
				}
			}
			min = Math.min(min, count(tmp));
			return;
		}

		for (int i = 0; i < W; i++) {
			sel[k] = i;
			permutation(sel, k + 1);
		}
	}

	private static void down(int[][] tmp) {
		for (int i = 0; i < W; i++) {
			for (int j = H - 1; j >= 0; j--) {
				if (tmp[j][i] == 0) {
					for (int n = j - 1; n >= 0; n--) {
						if (tmp[n][i] != 0) {
							tmp[j][i] = tmp[n][i];
							tmp[n][i] = 0;
							break;
						}
					}
				}
			}
		}
	}

	private static int count(int[][] tmp) {
		int sum = 0;
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				if (tmp[i][j] > 0)
					sum++;
			}
		}
		return sum;
	}

	private static void bfs(int r, int c, int[][] tmp) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c, tmp[r][c] });
		tmp[r][c] = 0;
		while (!q.isEmpty()) {
			int[] point = q.poll();
			for (int d = 0; d < dx.length; d++) {
				for (int i = 1; i < point[2]; i++) {
					int nr = point[0] + dx[d] * i;
					int nc = point[1] + dy[d] * i;
					if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
						if (tmp[nr][nc] > 1)
							q.offer(new int[] { nr, nc, tmp[nr][nc] });
						tmp[nr][nc] = 0;
					}
				}
			}
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
