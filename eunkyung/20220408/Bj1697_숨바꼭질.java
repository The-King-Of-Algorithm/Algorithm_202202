package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1697_숨바꼭질 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[100001];

		bfs(N, K);

	}

	private static void bfs(int n, int k) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[] v = new boolean[100001];
		int cnt = 1;
		q.offer(new int[] { n, cnt - 1 });
		v[n] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] current = q.poll();
				if (current[0] == k) {
					System.out.println(current[1]);
					return;
				}
				if (check(current[0] - 1) && !v[current[0] - 1]) {
					q.offer(new int[] { current[0] - 1, cnt });
					v[current[0] - 1] = true;
				}
				if (check(current[0] + 1) && !v[current[0] + 1]) {
					v[current[0] + 1] = true;
					q.offer(new int[] { current[0] + 1, cnt });
				}
				if (check(current[0] * 2) && !v[current[0] * 2]) {
					v[current[0] * 2] = true;
					q.offer(new int[] { current[0] * 2, cnt });
				}
			}
			cnt++;
		}
	}

	private static boolean check(int i) {
		if (i >= 0 && i < 100001) {
			return true;
		}
		return false;
	}
}
