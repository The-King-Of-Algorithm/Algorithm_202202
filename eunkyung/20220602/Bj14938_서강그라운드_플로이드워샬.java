package day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj14938_서강그라운드_플로이드워샬 {


	static int n, m, r, max;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		int[] node = new int[n + 1];
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i < node.length; i++) {
			node[i] = Integer.parseInt(st.nextToken());
		}
//System.out.println(Arrays.toString(node));
		int[][] adj = new int[n + 1][n + 1];
		for (int i = 0; i < adj.length; i++) {
			Arrays.fill(adj[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s][e] = w;
			adj[e][s] = w;
		}
		//print(adj);

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (i == k)
					continue;
				for (int j = 1; j <= n; j++) {
					if (i == j || j == k)
						continue;
					if (adj[i][k] != Integer.MAX_VALUE && adj[k][j] != Integer.MAX_VALUE)
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
				}
			}
		}

		//print(adj);

		for (int i = 1; i < adj.length; i++) {
			int sum = 0;
			for (int j = 1; j < adj.length; j++) {
				if (i == j)
					sum += node[i];
				else if (adj[i][j] <= m)
					sum += node[j];
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(max);

	}

	private static void print(int[][] adj) {
		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj[i].length; j++) {
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
