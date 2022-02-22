package d0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_7465_창용마을무리의개수 {

	static int N, M;
	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			boolean[] check = new boolean[N+1];
			int result = 0;
			
			makeSet();
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b);
			}
			
			for (int i = 1; i <= N; i++) {
				if(!check[findSet(i)]) {
					result++;
					check[findSet(i)] = true;
				}
			}
			
			System.out.printf("#%d %d\n", tc, result);
		}
		
	}

	private static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot != bRoot)
			parents[bRoot] = aRoot;			
		return;
				
	}

	private static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}

	private static void makeSet() {
		parents = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}		
	}

}
