package day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj12851_숨바꼭질2 {
	static int N, K, min = 9999999, cnt;
	static int a = 100000;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs();
		System.out.println(min);
		System.out.println(cnt);
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[] v = new boolean[100001];
		q.offer(new int[] { N, 0 });
		// v[N] = true;

		while (!q.isEmpty()) {
			int[] n = q.poll();
			v[n[0]] = true;
			//System.out.println(n[0] + " ,,,, " + n[1]);
			if (n[1] > min) {
				break;
			}
			if (n[0] == K && n[1] <= min) {
				min = n[1];
				cnt++;
				continue;
			}
//			boolean state1 = false;
//			boolean state2 = false;
//			boolean state3 = false;

			int n1 = n[0] - 1;
			int n2 = n[0] + 1;
			int n3 = n[0] * 2;
			if (n1 >= 0 && n1 <= a && !v[n1]) {
				/// state1 = true;
				// System.out.println(n1 + " " + (n[1]+1));
				q.offer(new int[] { n1, n[1] + 1 });
			}
			if (n2 >= 0 && n2 <= a && !v[n2]) {
				// state2 = true;
				// System.out.println(n2 + " " + (n[1]+1));
				q.offer(new int[] { n2, n[1] + 1 });
			}
			if (n3 >= 0 && n3 <= a && !v[n3]) {
				// state3 = true;
				// System.out.println(n3 + " " + (n[1]+1));
				q.offer(new int[] { n3, n[1] + 1 });
			}

//			if (state1)
//				v[n1] = true;
//			if (state2)
//				v[n2] = true;
//			if (state3)
//				v[n3] = true;
		}
	}

}
