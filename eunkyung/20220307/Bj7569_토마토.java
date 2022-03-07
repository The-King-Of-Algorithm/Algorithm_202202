package day14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj7569_토마토 {
	static int M, N;
	static Queue<int[]> tomato = new LinkedList<int[]>();
	static int[] dx = { -1, 0, 1, 0, 0, 0 };
	static int[] dy = { 0, 1, 0, -1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/day14/토마토.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][][] map = new int[N][M][H];
		int res = 0;
		int zero = 0;

		for (int h = H - 1; h >= 0; h--) {
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < map[i].length; j++) {
					map[i][j][h] = Integer.parseInt(st.nextToken());
					if (map[i][j][h] == 1)
						tomato.add(new int[] { i, j, h });
					if (map[i][j][h] == 0)
						zero++;
				}
			}
		}
		if (zero == 0) {
			System.out.println(0);
			return;
		}

		while (!tomato.isEmpty()) {
			int size = tomato.size();
			res++;
			for (int i = 0; i < size; i++) {
				int[] point = tomato.poll();
				// System.out.println(point[0]+" "+point[1]);
				for (int d = 0; d < dx.length; d++) {
					int nr = point[0] + dx[d];
					int nc = point[1] + dy[d];
					int nh = point[2] + dh[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && nh >= 0 && nh < H && map[nr][nc][nh] == 0) {
						map[nr][nc][nh] = 1;
						tomato.add(new int[] { nr, nc, nh });
					}
				}
			}
		}
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j][h] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(res - 1);
	}

	private static void print(int[][][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
