package day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1753_최단경로 {
	static class Edge {
		int v, w;

		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Edge [v=" + v + ", w=" + w + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(bf.readLine());

		ArrayList<Edge>[] edge = new ArrayList[V + 1];
		for (int i = 0; i < edge.length; i++) {
			edge[i] = new ArrayList<>();
		}
		int[] dist = new int[V + 1];
		boolean[] visit = new boolean[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edge[u].add(new Edge(v, w));
		}

		dist[K] = 0;
		for (int cnt = 0; cnt < V; cnt++) {

			int min = Integer.MAX_VALUE;
			int min_idx = 0;
			for (int i = 1; i < dist.length; i++) {
				if (!visit[i] && dist[i] < min) {
					min = dist[i];
					min_idx = i;
				}
			}

			visit[min_idx] = true;

			ArrayList<Edge> current = edge[min_idx];
			for (int i = 0; i < current.size(); i++) {
				dist[current.get(i).v] = Math.min(dist[current.get(i).v], dist[min_idx] + current.get(i).w);
			}
		}

		for (int i = 1; i < dist.length; i++) {
			if (dist[i] != Integer.MAX_VALUE)
				System.out.println(dist[i]);
			else {
				System.out.println("INF");
			}
		}
	}

}
