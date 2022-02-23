package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_1197_크루스칼_간선리스트 {
	static class Edge implements Comparable<Edge> {
		int s;
		int e;
		int w;

		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Edge [s=" + s + ", e=" + e + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}

	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Edge[] edge = new Edge[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edge[i] = new Edge(s, e, w);
		}
		Arrays.sort(edge);
		makeset(V + 1);
		int sum = 0;
		int cnt = 0;
		for (int c = 0; c < edge.length; c++) {
			if (findset(edge[c].s) != findset(edge[c].e)) {
				union(edge[c].s, edge[c].e);
				sum += edge[c].w;
				cnt++;
			}
			if(cnt== V-1) {
				break;
			}
		}
		System.out.println(sum);

	}

	private static void union(int s, int e) {
		int sp = findset(s);
		int ep = findset(e);
		parent[ep] = sp;
	}

	private static int findset(int c) {
		if (parent[c] == c)
			return c;
		parent[c] = findset(parent[c]);
		return findset(parent[c]);
	}

	private static void makeset(int v) {
		parent = new int[v];
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
	}
}
