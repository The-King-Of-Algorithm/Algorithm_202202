package day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj11404_플로이드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int V = Integer.parseInt(bf.readLine());
		int E = Integer.parseInt(bf.readLine());
		int[][] adj = new int[V + 1][V + 1];

		for (int i = 0; i < adj.length; i++) {
			Arrays.fill(adj[i], Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s][e] = Math.min(adj[s][e], w);
		}
		
	//	print(adj);

		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				if (i == k) continue;
				for (int j = 1; j <= V; j++) {
					if (i == j || k == j) continue;
					if(adj[i][k] != Integer.MAX_VALUE && adj[k][j] != Integer.MAX_VALUE)
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);						
				}
			}
		}

		print(adj);

	}

	private static void print(int[][] adj) {
		for (int i = 1; i < adj.length; i++) {
			for (int j = 1; j < adj[i].length; j++) {
				if(adj[i][j] == Integer.MAX_VALUE)
					System.out.print("0 ");
				else
					System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}
	}
}
