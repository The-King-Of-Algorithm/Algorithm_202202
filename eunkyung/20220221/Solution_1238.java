package day07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// Contact 
public class Solution_1238 {
	static int[] max = new int[2];

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/day07/1238.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {

			StringTokenizer st = new StringTokenizer(bf.readLine());
			int[][] map = new int[101][101];
			int N = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(bf.readLine());
			for (int n = 0; n < N / 2; n++) {
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				map[i][j] = 1;
			}
			bfs(map, V, new boolean[101]);
			System.out.println("#" + tc + " " + max[1]);
		}
	}

	private static void bfs(int[][] map, int V, boolean[] v) {
		Queue<Integer> q = new LinkedList<>();
		v[V] = true;
		int cnt = 1;
		q.offer(V);
		max[0] = 0;
		max[1] = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int i = 0; i < size; i++) {
				int n = q.poll();
				boolean state = false;
				for (int j = 1; j < map.length; j++) {
					if (map[n][j] == 1 && !v[j]) {
						q.offer(j);
						v[j] = true;
						state = true;
					}
				}
				if (!state) {
					if (max[0] < cnt) {
						max[0] = cnt;
						max[1] = n;
					} else if (max[0] == cnt) {
						max[1] = Math.max(max[1], n);
					}
				}
			}

		}
	}
}
