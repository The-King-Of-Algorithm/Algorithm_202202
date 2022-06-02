package day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2606_바이러스 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(bf.readLine());
		int E = Integer.parseInt(bf.readLine());
		ArrayList<Integer>[] adj = new ArrayList[V + 1];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adj[s].add(e);
			adj[e].add(s);			
		}


		boolean[] node = new boolean[V + 1];
		node[1] = true;

		Queue<Integer> q = new LinkedList<Integer>();
		q.addAll(adj[1]);
		int cnt = 0;

		while (!q.isEmpty()) {
			int n = q.poll();
			if (node[n]) continue;
			q.addAll(adj[n]);
			node[n]=true;
			cnt++;
		}
		System.out.println(cnt);

	}
}
