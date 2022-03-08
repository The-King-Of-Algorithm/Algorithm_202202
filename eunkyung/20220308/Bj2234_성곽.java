package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2234_성곽 {
	static class Wall {
		int r, c;
		int[] dir = new int[4];

		public Wall(int r, int c, int s, int e, int n, int w) {
			this.r = r;
			this.c = c;
			dir[0] = s; // 남
			dir[1] = e; // 동
			dir[2] = n; // 북
			dir[3] = w; // 서
		}
	}

	static Wall[][] wall;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] v;
	static int N, M;
	static int[][] map;
	static int sumArea = 0;
	static ArrayList<ArrayList<int[]>> save = new ArrayList<ArrayList<int[]>>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		wall = new Wall[M][N];
		v = new boolean[M][N];
		map = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				String binary = String.format("%04d",
						Integer.parseInt(Integer.toBinaryString(Integer.parseInt(st.nextToken()))));
				wall[i][j] = new Wall(i, j, binary.charAt(0) - '0', binary.charAt(1) - '0', binary.charAt(2) - '0',
						binary.charAt(3) - '0');
			}
		}
		
		int cnt = 0;
		int max = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j]) {
					cnt++;
					map[i][j] = cnt;
					int area = bfs(wall[i][j], cnt);
					max = Math.max(max, area);
				}
			}
		}
		print(map);

		for (int i = 0; i < cnt - 1; i++) {
			for (int j = i + 1; j < cnt; j++) {
				breakwall(i, j);// i가 1번부터 j가 2345탐색
			}
		}
		System.out.println(cnt);
		System.out.println(max);
		System.out.println(sumArea);

	}

	private static void breakwall(int i, int j) {
		for (int q = 0; q < save.get(i).size(); q++) {
			int[] point = save.get(i).get(q);
			for (int d = 0; d < dx.length; d++) {
				int nr = point[0] + dx[d];
				int nc = point[1] + dy[d];
				if (nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] == j+1) {
					sumArea = Math.max(sumArea, save.get(i).size() + save.get(j).size());
					return;
				}
			}
		}

	}

	private static int bfs(Wall current, int c) {
		ArrayList<int[]> p = new ArrayList<int[]>();
		Queue<Wall> q = new LinkedList<Wall>();
		v[current.r][current.c] = true;
		q.offer(current);
		p.add(new int[] { current.r, current.c });

		int cnt = 1;
		while (!q.isEmpty()) {
			Wall point = q.poll();
			for (int d = 0; d < point.dir.length; d++) {
				if (point.dir[d] != 1) {
					int nr = point.r + dx[d];
					int nc = point.c + dy[d];
					if (nr >= 0 && nr < M && nc >= 0 && nc < N && !v[nr][nc]) {
						cnt++;
						map[nr][nc] = c;
						v[nr][nc] = true;
						q.offer(wall[nr][nc]);
						p.add(new int[] { nr, nc });
					}
				}
			}
		}
		save.add(p);
		return cnt;
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
