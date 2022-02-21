package BAEKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class silver2_1260_DFS와BFS {

	static int N, M, start;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점의 개수
		M = sc.nextInt(); // 간선의 개수
		start = sc.nextInt(); // 시작 정점 번호
		visited = new boolean[N+1];

		map = new int[N+1][N+1]; // from, to
		
		for (int i = 0; i < M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			// 양방향 간선
			map[r][c] = map[c][r] = 1;
		}
		
		dfs(start);
		System.out.println();
		bfs(start);
	}

	private static void bfs(int k) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] v = new boolean[N+1];
		
		v[k] = true;
		queue.offer(k);
		System.out.print(k + " ");
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for (int i = 1; i < map.length; i++) {
				if(map[temp][i] == 1 && !v[i]) {
					v[i] = true;
					queue.offer(i);
					System.out.print(i + " ");
				}
			}
		}
	}

	private static void dfs(int k) {
		
		visited[k] = true;
		System.out.print(k + " ");
		
		for (int i = 1; i < map.length; i++) {
			if(map[k][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}

}
