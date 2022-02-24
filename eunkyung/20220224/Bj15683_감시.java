package day06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj15683_감시 {
	static class CCTV {
		int r, c, t;

		public CCTV(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}

		@Override
		public String toString() {
			return "CCTV [r=" + r + ", c=" + c + ", t=" + t + "]";
		}

	}

	static ArrayList<CCTV> cctv;
	static int[][] map;
	static int N, M, min = 989898989;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/day06/cctv.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctv = new ArrayList<>();
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctv.add(new CCTV(i, j, map[i][j]));
				}
			}
		}

		// print(map);
		int tmp[][] = copy(map);
		recursive(tmp, 0);
		System.out.println(min);

	}

//	static int[] dx = { 0, 0, -1, 1 };
//	static int[] dy = { 1, -1, 0, 0 };
//	static int[][] dir = { {}, { 0 }, { 0, 1 }, { 0, 2 }, { 0, 1, 2 }, { 0, 1, 2, 3 } };
	
//	static int[] dr = { -1, 0, 1, 0 };
//	static int[] dc = { 0, 1, 0, -1 };
//	static int[][] type = { {}, { 1 }, { 1, 3 }, { 0, 1 }, { 0, 1, 3 }, { 0, 1, 2, 3 } };
//	
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[][] dir = { {}, { 2 }, { 0, 2 }, { 1, 2 }, { 0, 1, 2 }, { 0, 1, 2, 3 } };
//	   0 1
//	0  0 1
//	1  1 2  =>  1 2
//	2  2 3  =>  2 0 
//	3  3 4  =>  0 1
	//  2
	// 1 0
	//  3
	private static void recursive(int[][] map, int idx) {
		if (idx == cctv.size()) {
			print(map);
			System.out.println();
			operation(map);
			return;
		}

		CCTV c = cctv.get(idx);
		for (int d = 0; d < 4; d++) {
			int[][] tmp = copy(map); // 왜 복사하는것 여기서?
			for (int i = 0; i < dir[c.t].length; i++) {
				int n = 1;
				while (true) {
					int nd = (dir[c.t][i] + d) % 4; // 방향 이상한데 이게 맞나...
					System.out.println(nd);
					int nr = c.r + dx[nd] * n;
					int nc = c.c + dy[nd] * n;
					// System.out.println(nr + " " + nc);
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && tmp[nr][nc] != 6) {
						tmp[nr][nc] = 9;
						n++;
					} else
						break;
				}

			}
			recursive(tmp, idx + 1);
			// map = copy();
		}

	}

	private static void operation(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0) {
					cnt++;
				}
			}
		}
		min = Math.min(min, cnt);

	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] copy(int[][] map) {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		return tmp;
	}
}
