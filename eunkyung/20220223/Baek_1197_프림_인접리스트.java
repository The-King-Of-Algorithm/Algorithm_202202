package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_1197_프림_인접리스트 {
	static class Edge {
		List<int[]> e;

		public Edge() {
			super();
			this.e = new ArrayList<int[]>();
		}

		public void Stringto() {
			for (int i = 0; i < e.size(); i++) {
				System.out.println(e.get(i)[0] + " " + e.get(i)[1]);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Edge[] edge = new Edge[V + 1];
		for (int i = 0; i < edge.length; i++) {
			edge[i] = new Edge();
		}

		boolean[] visit = new boolean[V + 1];
		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		visit[0] = true;

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edge[s].e.add(new int[] { e, w });
			edge[e].e.add(new int[] { s, w });

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

			for (int j = 0; j < edge[min_idx].e.size(); j++) {
				int[] n = edge[min_idx].e.get(j);
				if (!visit[n[0]]) {
					dist[n[0]] = Math.min(dist[n[0]], n[1]);
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
