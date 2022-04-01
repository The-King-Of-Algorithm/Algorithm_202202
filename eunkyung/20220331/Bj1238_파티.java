package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1238_파티 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[][] edgemap = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edgemap[s][e] = w;
		}

		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] v = new boolean[N + 1];
		v[0] = true;
		dist[X] = 0;

		for (int c = 0; c < N - 1; c++) {
			int min = Integer.MAX_VALUE;
			int min_idx = 0;
			for (int i = 1; i < dist.length; i++) {
				if (dist[i] < min && !v[i]) {
					min = dist[i];
					min_idx = i;
				}
			}
			v[min_idx] = true;

			for (int i = 1; i <= N; i++) {
				if (edgemap[min_idx][i] != 0 && !v[i]) {
					dist[i] = Math.min(dist[i], edgemap[min_idx][i] + dist[min_idx]);
				}
			}
		}

		int[] dist2 = new int[N + 1];
		Arrays.fill(dist2, Integer.MAX_VALUE);
		boolean[] v2 = new boolean[N + 1];
		v2[0] = true;
		dist2[X] = 0;
		for (int c = 0; c < N - 1; c++) {
			int min = Integer.MAX_VALUE;
			int min_idx = 0;
			for (int i = 1; i < dist2.length; i++) {
				if (dist2[i] < min && !v2[i]) {
					min = dist2[i];
					min_idx = i;
				}
			}
			v2[min_idx] = true;

			for (int i = 1; i <= N; i++) {
				if (edgemap[i][min_idx] != 0 && !v2[i]) {
					dist2[i] = Math.min(dist2[i], edgemap[i][min_idx] + dist2[min_idx]);
				}
			}
		}

		for (int i = 1; i < dist2.length; i++) {
			dist2[i] += dist[i];
		}

		Arrays.sort(dist2);
		for (int i = dist2.length - 1; i >= 0; i--) {
			if (dist2[i] != Integer.MAX_VALUE) {
				System.out.println(dist2[i]);
				break;
			}
		}
	}
}
