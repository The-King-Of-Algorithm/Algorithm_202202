package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B_1197_kruskcal {
	static int V,E;
	static int[] parent;
	
	static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
	static void union(int a, int b) {
		int roota = find(a);
		int rootb = find(b);
		if (roota != rootb) {
			parent[rootb] = roota;
		}
	}
	
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int weight;
		
		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Node [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("B_1197.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		ArrayList<Node> list = new ArrayList<Node>();
		parent = new int[V+1];
		
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.add(new Node(from,to,weight));
		}
		Collections.sort(list);
		
		int sum=0;
		int cnt=0;
		for (int i = 0; i < E; i++) {
			if (find(list.get(i).from) != find(list.get(i).to)) {
				sum+=list.get(i).weight;
				cnt+=1;
				union(list.get(i).from, list.get(i).to);
			
			}
			if (cnt == V-1) {
				break;
			}
		}
		System.out.println(sum);
		
	}

}
