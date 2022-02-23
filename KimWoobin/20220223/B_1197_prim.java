package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B_1197_prim {
	static int V,E;
	
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int w;
		
		public Node(int from, int to, int w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}
		@Override
		public String toString() {
			return "Node [from=" + from + ", to=" + to + ", weight=" + w + "]";
		}
		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("B_1197.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
//		ArrayList<Node> list = new ArrayList<Node>();
//		
//		for (int i = 0; i < E; i++) {
//			st = new StringTokenizer(br.readLine());
//			int from = Integer.parseInt(st.nextToken());
//			int to = Integer.parseInt(st.nextToken());
//			int w = Integer.parseInt(st.nextToken());
//			list.add(new Node(from,to,w));
//		}
		ArrayList<ArrayList<int[]>> list = new ArrayList<>();
		list.add(new ArrayList<int[]>());
		for (int i = 0; i < V; i++) {
			list.add(new ArrayList<int[]>());
		}
		
		for (int i = 0; i < E; i++) {
			st=new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(from).add(new int[]{to, w});
			list.get(to).add(new int[]{from, w});
		}
//		for (ArrayList<int[]> arrayList : list) {
//			for (int[] is : arrayList) {
//				System.out.print(Arrays.toString(is));
//			}System.out.println();
//		}
		
		
		
		boolean[] v = new boolean[V+1];
		int[] weight = new int[V+1];
		Arrays.fill(weight, Integer.MAX_VALUE);
		weight[1] = 0;
		
		for (int cnt = 0; cnt < V-1; cnt++) {
			int minw = Integer.MAX_VALUE;
			int minidx = 0;
			for (int i = 1; i <= V; i++) {
				if (!v[i] && weight[i] < minw) {
					minw = weight[i];
					minidx = i;
				}
			}
			v[minidx] = true;
			
			for (int i = 0; i < list.get(minidx).size(); i++) {
				int[] node = list.get(minidx).get(i);
				if (!v[node[0]] && node[1] < weight[node[0]]) {
					weight[node[0]] = node[1];
					
				}
			}
		}
		//System.out.println(Arrays.toString(weight));
		int sum=0;
		for (int i = 1; i <= V; i++) {
			sum+=weight[i];
		}
		System.out.println(sum);
		
	}

}
