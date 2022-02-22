package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//서로소 집합
public class Solution_3289 {
	static int n, m;
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			sb.append("#" + tc + " ");
			makeset();
			for (int M = 0; M < m; M++) {
				st = new StringTokenizer(bf.readLine());
				int o = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (o == 0) {
					union(a, b);
				} else {
					if (findset(a) == findset(b)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			System.out.println(sb);
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
