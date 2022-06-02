package day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj13549_숨바꼭질3 {
	static int s = 100001;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] memo = new int[s];
		Arrays.fill(memo, Integer.MAX_VALUE);
		memo[N] = 0;
		bfs(N, K, memo);
	}

	private static void bfs(int n, int k, int[] memo) {
		Queue<int[]> q = new LinkedList<int[]>();
		// boolean[] v = new boolean[100001];
		q.offer(new int[] { n, 0 });
		// v[n] = true;

		while (!q.isEmpty()) {
			int[] c = q.poll();
			if (c[0] == k)
				continue;
			if (c[0] - 1 >= 0 && c[0] - 1 < s && memo[c[0] - 1] > c[1] + 1) {
				memo[c[0] - 1] = c[1] + 1;
				q.offer(new int[] { c[0] - 1, c[1] + 1 });
			}
			if (c[0] + 1 >= 0 && c[0] + 1 < s && memo[c[0] + 1] > c[1] + 1) {
				memo[c[0] + 1] = c[1] + 1;
				q.offer(new int[] { c[0] + 1, c[1] + 1 });
			}
			if (c[0] * 2 >= 0 && c[0] * 2 < s && memo[c[0] * 2] > c[1]) {
				memo[c[0] * 2] = c[1];
				q.offer(new int[] { c[0] * 2, c[1] });
			}

		}
		//System.out.println(Arrays.toString(memo));
		System.out.println(memo[k]);

	}
}
