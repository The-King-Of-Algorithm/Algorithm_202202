package day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bj11559_PuyoPuyo {
	static char[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean state = false;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		for (int i = 0; i < map.length; i++) {
			map[i] = bf.readLine().toCharArray();
		}
		int cnt = 0;
		while (true) {
			state = false;
			boolean[][] tmp = new boolean[12][6];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] != '.'&&!tmp[i][j]) {
						bfs(i, j, tmp);
					}
				}
			}

			if (!state) break;
			cnt++;
			down();
		}

		System.out.println(cnt);
	}

	private static void bfs(int i, int j, boolean[][] v) {
		Queue<int[]> q = new LinkedList<int[]>();
		ArrayList<int[]> list = new ArrayList<int[]>();
		list.add(new int[] { i, j });
		q.offer(new int[] { i, j });
		v[i][j] = true;

		while (!q.isEmpty()) {
			int[] c = q.poll();
			for (int d = 0; d < dx.length; d++) {
				int nr = c[0] + dx[d];
				int nc = c[1] + dy[d];
				if (nr >= 0 && nr < 12 && nc >= 0 && nc < 6 && !v[nr][nc] && map[nr][nc] == map[c[0]][c[1]]) {
					v[nr][nc] = true;
					q.offer(new int[] { nr, nc });
					list.add(new int[] { nr, nc });
				}
			}
		}
		if (list.size() >= 4) {
			state = true;
			for (int k = 0; k < list.size(); k++) {
				map[list.get(k)[0]][list.get(k)[1]] = '.';
			}
		}
	}

	private static void down() {
		for (int j = 0; j < map[0].length; j++) {
			Queue<Character> q = new LinkedList<Character>();
			for (int i = map.length - 1; i >= 0; i--) {
				if (map[i][j] != '.')
					q.offer(map[i][j]);
				map[i][j] = '.';
			}
			int k = map.length - 1;
			while (!q.isEmpty()) {
				map[k--][j] = q.poll();
			}
		}
	}
}
