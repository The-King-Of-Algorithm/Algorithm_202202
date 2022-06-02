package day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj16928_뱀과사다리게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[2][101];
		for (int i = 1; i < 101; i++) {
			map[1][i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			map[0][s] = e;
		}

		//print(map);
		map[1][1] = 0;
		bfs(1, map);
		System.out.println(map[1][100]);
	}

	private static void bfs(int k, int[][] map) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { k, 0 });

		while (!q.isEmpty()) {
			int[] c = q.poll();
			if (c[0] == 100)
				continue;
			for (int i = c[0] + 1; i <= c[0] + 6; i++) {
				if (i >= 101)
					continue;
				if (map[1][i] > c[1] + 1) {
					map[1][i] = c[1] + 1;
					if (map[0][i] != 0) {
						map[1][map[0][i]] = c[1] + 1;
						q.offer(new int[] { map[0][i], c[1] + 1 });
					} else {
						q.offer(new int[] { i, c[1] + 1 });
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
		System.out.println();
	}
}
