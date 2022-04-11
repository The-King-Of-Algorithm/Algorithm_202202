package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj17143_낚시왕 {
	static int R, C, M;
	static Shark[][] map;
	static int[] dx = { 0, -1, 1, 0, 0 }; // 상하 우좌
	static int[] dy = { 0, 0, 0, 1, -1 };
	static ArrayList<Shark> shark = new ArrayList<>();

	static class Shark {
		int r, c, s, d, z;
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Shark[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = new Shark(r, c, s, d, z);
			shark.add(map[r][c]);
		}

		// print(map);
		int cnt = 0;
		for (int sc = 1; sc < C + 1; sc++) {
			// 상어 잡기
			for (int i = 1; i < R + 1; i++) {
				if (map[i][sc] != null) {
					cnt += map[i][sc].z;
					shark.remove(map[i][sc]);
					map[i][sc] = null;
					break;
				}
			}
			// 상어 이동..
			moveshark();
		}
		System.out.println(cnt);
	}

	private static void moveshark() {
		Shark[][] tmp = new Shark[R + 1][C + 1];
		int n = 0;
		while (n < shark.size()) {
			Shark current = shark.get(n++);
			map[current.r][current.c] = null;
			for (int dist = 0; dist < current.s; dist++) {
				int nr = current.r + dx[current.d];
				int nc = current.c + dy[current.d];
				if (nr >= 1 && nr <= R && nc >= 1 && nc <= C) {
					current.r = nr;
					current.c = nc;
				} else {
					if (current.d % 2 == 0)
						current.d--;
					else
						current.d++;
					dist--;
				}
			}
			if (tmp[current.r][current.c] != null) {
				if (tmp[current.r][current.c].z > current.z) {
					shark.remove(current);
				} else {
					shark.remove(tmp[current.r][current.c]);
					tmp[current.r][current.c] = current;
				}
				n--;
			} else {
				tmp[current.r][current.c] = current;
			}
			// print(tmp);
		}

		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				if (tmp[i][j] != null)
					map[i][j] = tmp[i][j];
			}
		}
	}

	private static void print(Shark[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
