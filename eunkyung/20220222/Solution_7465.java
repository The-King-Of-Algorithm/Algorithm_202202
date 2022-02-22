package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//창용 마을 무리의 개수
public class Solution_7465 {
	static int n, m;
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int cnt = 0;
			makeset();
			for (int M = 0; M < m; M++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				union(a, b);

			}
			for (int i = 1; i < parent.length; i++) {
				if (parent[i] == i) {
					cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}

	private static int findset(int c) {
		if (parent[c] == c)
			return c;
		parent[c] = findset(parent[c]);
		return parent[c];
	}

	private static void union(int a, int b) {
		if (findset(a) != findset(b)) {
			parent[findset(b)] = findset(a);
		}
	}

	private static void makeset() {
		parent = new int[n + 1];
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
	}
}
