package day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj2458_키순서_플로이드워샬 {
	static int N, M, cnt=0;;
	static int[][] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new int[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adj[s - 1][e - 1] = 1;
		}

		// print(adj);

		floyd();
	//	print(adj);

		int[] sum = new int[N];
		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj.length; j++) {
				if (adj[i][j] == 1) {
					sum[i]++;
					sum[j]++;
				}
			}
		}
		
		for (int i = 0; i < sum.length; i++) {
			if(sum[i] == N-1) cnt++;
		}
		System.out.println(cnt);
	}

	private static void floyd() {
		// 경출도..
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (i == k || adj[i][k] == 0) continue;
				for (int j = 0; j < N; j++) {
					if (adj[k][j] == 1) {
						adj[i][j] = 1;
					}
				}
			}
		}

	}

	private static void print(int[][] adj) {
		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj.length; j++) {
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
