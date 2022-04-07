package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW5643_키순서 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(bf.readLine()); // 학생수
			int M = Integer.parseInt(bf.readLine()); // 간선수
			int[][] adj = new int[N + 1][N + 1];

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				adj[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}

			// print(adj);
			int cnt = 0;
			for (int n = 1; n <= N; n++) {
				boolean[] node = new boolean[N + 1];
				node[n] = true;
				// System.out.println("node" + n);

				// 나가는 애
				Queue<Integer> q = new LinkedList<Integer>();
				q.offer(n);
				while (!q.isEmpty()) {
					int current = q.poll();
					for (int i = 1; i < adj[current].length; i++) {
						if (adj[current][i] == 1 && !node[i]) {
							node[i] = true;
							q.offer(i);
							// System.out.println(q);
						}
					}
				}

				// 들어오는 애
				q = new LinkedList<Integer>();
				q.offer(n);
				while (!q.isEmpty()) {
					int current = q.poll();
					for (int i = 1; i < adj[current].length; i++) {
						if (adj[i][current] == 1 && !node[i]) {
							node[i] = true;
							q.offer(i);
							// System.out.println(q);
						}
					}
				}

				for (int i = 1; i < node.length; i++) {
					if (!node[i]) {
						cnt++;
						break;
					}
				}
			}

			System.out.println("#" + tc + " " + (N - cnt));

		}
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
