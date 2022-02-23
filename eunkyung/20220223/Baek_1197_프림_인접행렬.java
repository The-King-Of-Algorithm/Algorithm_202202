package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_1197_프림_인접행렬 {
//메모리 초과..
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] adj = new int[V + 1][V + 1];

		boolean[] visit = new boolean[V + 1];
		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		visit[0] = true;

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s][e] = w;
			adj[e][s] = w;
		}
		dist[1] = 0;

		for (int c = 0; c < V - 1; c++) {

			int min = Integer.MAX_VALUE;
			int min_idx = 0;
			for (int i = 1; i < dist.length; i++) {
				if (!visit[i] && dist[i] < min) {
					min = dist[i];
					min_idx = i;
				}
			}

			visit[min_idx] = true;

			for (int i = 1; i < adj[min_idx].length; i++) {
				if (!visit[i] && adj[min_idx][i] != 0) {
					dist[i] = Math.min(dist[i], adj[min_idx][i]);
				}
			}
		}
		int sum = 0;
		for (int i = 1; i < dist.length; i++) {
			sum += dist[i];
		}
		System.out.println(sum);

	}
}
