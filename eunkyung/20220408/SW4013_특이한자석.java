package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW4013_특이한자석 {
	static int[] dir = { -1, 1 };
	static ArrayList<Integer>[] magnet = new ArrayList[5];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(bf.readLine());
			for (int i = 0; i < magnet.length; i++) {
				magnet[i] = new ArrayList<Integer>();
			}
			for (int i = 1; i < 5; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i].add(Integer.parseInt(st.nextToken()));
				}
			}

			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				int n = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				boolean[] v = new boolean[5];
				dfs(v, n, d);
			}

			int sum = 0;
			for (int i = 1; i < 5; i++) {
				if (magnet[i].get(0) == 1) {
					sum += Math.pow(2, i - 1);
				}
			}
			System.out.println("#" + tc + " " + sum);

			// print(magnet);

		}

	}

	private static void dfs(boolean[] v, int n, int d) {
		v[n] = true;

		for (int D = 0; D < dir.length; D++) {
			int c = n + dir[D]; // 좌우 확인
			if (c >= 1 && c < 5 && !v[c]) {
				if (D == 0 && magnet[n].get(6) != magnet[c].get(2)) {// 좌
					dfs(v, c, (-1) * d);
				}
				if (D == 1 && magnet[n].get(2) != magnet[c].get(6)) {// 우
					dfs(v, c, (-1) * d);
				}
			}
		}
		// 본인 돌리기..
		if (d == 1) { // 시계방향
			magnet[n].add(0, magnet[n].get(magnet[n].size() - 1));
			magnet[n].remove(magnet[n].size() - 1);
		} else { // 반시계방향
			magnet[n].add(magnet[n].get(0));
			magnet[n].remove(0);
		}
	}

	private static void print(ArrayList<Integer>[] magnet) {
		for (int i = 1; i < magnet.length; i++) {
			System.out.println(magnet[i]);
		}
		System.out.println();
	}
}
