package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_1197_프림_우선순위큐 {
	static class Edge implements Comparable<Edge> {
		int e;
		int w;

		public Edge(int e, int w) {
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		ArrayList<Edge>[] edge = new ArrayList[V + 1];

		for (int i = 1; i < edge.length; i++) {
			edge[i] = new ArrayList<>();
		}

		boolean[] visit = new boolean[V + 1];
		visit[0] = true;

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edge[s].add(new Edge(e, w));
			edge[e].add(new Edge(s, w));
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.addAll(edge[1]);
		visit[1] = true;
		int cnt = 1;
		int sum = 0;
		while (cnt < V) {
			Edge p = pq.poll();
			if (!visit[p.e]) {
				pq.addAll(edge[p.e]);
				sum += p.w;
				visit[p.e] = true;
				cnt++;
			}
		}

		System.out.println(sum);
	}
}
