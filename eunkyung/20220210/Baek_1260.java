package day06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
//DFS, BFS
public class Baek_1260 {
	static int[][] map;
	static int N;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/1260.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		map = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			map[start][end] = 1;
			map[end][start] = 1;
		}
		dfs(V);
		bfs(V);
	}

	private static void dfs(int V) {
		Stack<Integer> s = new Stack<Integer>();
		boolean[] visit = new boolean[N + 1];
		s.push(V);
		visit[V] = true;
		System.out.print(V+" ");

		while (!s.isEmpty()) {
			int n = s.peek();
			boolean state = false;

			for (int i = 1; i <= N; i++) {
				if (map[n][i] == 1 || map[i][n] == 1) {
					if (!visit[i]) {
						System.out.print(i+" ");
						s.push(i);
						state = true;
						visit[i] = true;
						break;
					}
				}
			}
			if (!state) {
				s.pop();
			}
		}
		System.out.println();
	}

	private static void bfs(int V) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visit = new boolean[N + 1];
		q.offer(V);
		visit[V] = true;

		while (!q.isEmpty()) {
			int n = q.poll();
			for (int i = 1; i <= N; i++) {
				if (map[n][i] == 1 || map[i][n] == 1) {
					if (!visit[i]) {
						q.offer(i);
						visit[i] = true;
					}
				}
			}
			System.out.print(n + " ");
		}
		System.out.println();
	}
}
