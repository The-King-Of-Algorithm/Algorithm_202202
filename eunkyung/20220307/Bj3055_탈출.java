package day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj3055_탈출 {
	static char[][] map;
	static int R, C, min = Integer.MAX_VALUE;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean flag;
	static Queue<int[]> water = new LinkedList<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		int r = 0, c = 0;
		for (int i = 0; i < map.length; i++) {
			String str = bf.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') {
					r = i;
					c = j;
				}
				if (map[i][j] == '*')
					water.add(new int[] { i, j });
			}
		}
		int res = bfs(r, c, 0);
		if(res != 0) System.out.println(res);
		else System.out.println("KAKTUS");

	}

	private static int bfs(int r, int c, int time) {

		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c });
		boolean[][] v = new boolean[R][C];
		v[r][c]=true;
		
		while(!q.isEmpty()) {
			water();
//			print(map);
//			System.out.println();
			int size = q.size();
			time++;
			for (int i = 0; i < size; i++) {
				int[] point = q.poll();
				for (int d = 0; d < dx.length; d++) {
					int nr = point[0] + dx[d];
					int nc = point[1] + dy[d];
					if (nr >= 0 && nr < R && nc >= 0 && nc < C && !v[nr][nc] && map[nr][nc] != '*' && map[nr][nc] != 'X') {
						if(map[nr][nc]=='D') return time;
						if(map[nr][nc]=='.') {
							q.offer(new int[] {nr, nc});
							v[nr][nc] = true;
						}
					}
				}
			}
		}
		return 0;

	}
	private static void water() {
		int size = water.size();
		for (int i = 0; i < size; i++) {
			int[] point = water.poll();
			for (int d = 0; d < dx.length; d++) {
				int nr = point[0] + dx[d];
				int nc = point[1] + dy[d];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') {
					map[nr][nc]='*';
					water.add(new int[] { nr, nc });
				}
			}
		}
	}

	private static void print(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}