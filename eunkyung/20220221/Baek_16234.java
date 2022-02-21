package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//인구 이동
public class Baek_16234 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, L, R, cnt;
	static boolean state = true;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		cnt = 0;

		int[][] map = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (state) {
			state = false;
			v = new boolean[N][N];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (!v[i][j]) {
						bfs(map, i, j);
					}
				}
			}
			if (state)
				cnt++;
		}
		System.out.println(cnt);
	}

	private static void bfs(int[][] map, int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		List<int[]> save = new ArrayList<>();
		q.offer(new int[] { r, c });
		save.add(new int[] { r, c });
		v[r][c] = true;

		while (!q.isEmpty()) {
			int[] n = q.poll();
			for (int d = 0; d < dx.length; d++) {
				int nr = n[0] + dx[d];
				int nc = n[1] + dy[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					int people = Math.abs(map[n[0]][n[1]] - map[nr][nc]);
					if (!v[nr][nc] && people >= L && people <= R) {
						q.offer(new int[] { nr, nc });
						save.add(new int[] { nr, nc });
						state = true;
						v[nr][nc] = true;
					}
				}
			}
		}

		if (save.size() > 1) {
			int sum = 0;
			for (int Lsum = 0; Lsum < save.size(); Lsum++) {
				sum += map[save.get(Lsum)[0]][save.get(Lsum)[1]];
			}
			for (int Lsum = 0; Lsum < save.size(); Lsum++) {
				map[save.get(Lsum)[0]][save.get(Lsum)[1]] = sum / save.size();
			}
		}

	}

}
