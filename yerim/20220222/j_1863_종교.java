package d0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class j_1863_종교 {

	static int n, m;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parents = new int[n];
		int cnt = 0;
		
		makeSet();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			union(a, b);
		}
		
		for (int i = 0; i < n; i++) {
			if(i == parents[i]) {
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}

	private static void makeSet(){
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}
	
	private static int findSet(int i) {
		if(parents[i] == i) return i;
		return parents[i] = findSet(parents[i]);
	}
	
	private static void union(int a, int b) {
		int aRoot = parents[a];
		int bRoot = parents[b];
		
		if(aRoot != bRoot)
			parents[bRoot] = aRoot;
		return;
	}
}
