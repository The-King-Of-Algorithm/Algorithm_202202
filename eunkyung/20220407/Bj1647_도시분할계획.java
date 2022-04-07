package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bj1647_도시분할계획 {
	static class Edge implements Comparable<Edge> {
		int e, w;

		public Edge(int e, int w) {
			super();
			this.e = e;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Edge [e=" + e + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}

	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ArrayList<Edge>[] edge = new ArrayList[N + 1];

		for (int i = 0; i < edge.length; i++) {
			edge[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edge[s].add(new Edge(e, w));
			edge[e].add(new Edge(s, w));
		}
//		for (int i = 0; i < edge.length; i++) {
//			System.out.println(edge[i]);
//		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.addAll(edge[1]);
		boolean[] node = new boolean[N + 1];
		node[0] = true;
		node[1] = true;

		int cnt = 1;
		int sum = 0;
		int max = 0;
		while (cnt < N) {
			Edge current = pq.poll();
			if (!node[current.e]) {
				pq.addAll(edge[current.e]);
				sum += current.w;
				node[current.e] = true;
				cnt++;
				max = Math.max(max, current.w);
				//System.out.println(current.e + " " + cnt);
			}
		}
		System.out.println(sum - max);
	}

}
