package day07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//미로탐색
public class Baek_2178 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/day07/2178.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		for (int i = 0; i < map.length; i++) {
			String str = bf.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		bfs(map, new boolean[N][M]);
		System.out.println(map[N - 1][M - 1]);
		//print(map);

	}

	private static void bfs(int[][] map, boolean[][] v) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });
		v[0][0] = true;
		int cnt = 1;

		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int n = 0; n < size; n++) {
				int[] xy = q.poll();
				for (int d = 0; d < dx.length; d++) {
					int nr = xy[0] + dx[d];
					int nc = xy[1] + dy[d];
					if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length) {
						if (map[nr][nc] == 1 && !v[nr][nc]) {
							q.offer(new int[] { nr, nc });
							v[nr][nc] = true;
							map[nr][nc] = cnt;
						}
					}
				}
			}

		}

	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
