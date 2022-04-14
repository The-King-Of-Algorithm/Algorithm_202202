package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj6087_레이저통신 {

	static int W, H, sr, sc, dr, dc, min = Integer.MAX_VALUE;
	static char[][] map;
	static int[][] tmp;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		tmp = new int[H][W];
		boolean state = false;
		for (int i = 0; i < tmp.length; i++) {
			Arrays.fill(tmp[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < H; i++) {
			String str = bf.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'C' && !state) {
					state = true;
					dr = i;
					dc = j;
				}
				if (map[i][j] == 'C' && state) {
					sr = i;
					sc = j;
				}
			}
		}

		tmp[sr][sc] = 0;
		bfs(sr, sc);
		System.out.println(tmp[dr][dc]);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c, 0, 9 });

		while (!q.isEmpty()) {
			int[] current = q.poll();
			//if (current[0] == dr && current[1] == dc) continue;
			for (int d = 0; d < dx.length; d++) {
				int nr = current[0] + dx[d];
				int nc = current[1] + dy[d];
				if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != '*' && (d + 2) % 4 != current[3]) {
					if (check(d, current[3])) {
						if (tmp[nr][nc] >= current[2] + 1) {
							tmp[nr][nc] = current[2] + 1;
							q.offer(new int[] { nr, nc, current[2] + 1, d });
						}
					} else {
						if (tmp[nr][nc] >= current[2]) {
							tmp[nr][nc] = current[2];
							q.offer(new int[] { nr, nc, current[2], d });
						}
					}
				}

			}
		}
	}

	private static boolean check(int d, int dir) {
		if (Math.abs(d - dir) == 3 || Math.abs(d - dir) == 1) {
			return true;
		}
		return false;
	}

}
