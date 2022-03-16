package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj17281_야구공 {
	static int[][] 이닝;
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		이닝 = new int[N][9];

		for (int i = 0; i < 이닝.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 이닝[i].length; j++) {
				이닝[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		permutation(new ArrayList<>(), new boolean[9], 0);
		System.out.println(max);
	}

	private static void permutation(ArrayList<Integer> sel, boolean[] v, int k) {
		if (k == v.length - 1) {
			sel.add(3, 0);
			operation(sel);
			sel.remove(3);
			return;
		}
		for (int i = 1; i < 9; i++) {
			if (!v[i]) {
				sel.add(i);
				v[i] = true;
				permutation(sel, v, k + 1);
				v[i] = false;
				sel.remove(sel.size() - 1);
			}
		}
	}

	private static void operation(ArrayList<Integer> sel) {
		int idx = 0;
		double jumsu = 0;
		for (int n = 0; n < 이닝.length; n++) {
			ArrayList<Integer> home = new ArrayList<Integer>();
			int cnt = 0;
			while (cnt != 3) {
				if (이닝[n][sel.get(idx)] == 0) cnt++;
				else {
					int c = 이닝[n][sel.get(idx)];
					int i=0;
					while(i < home.size()) {
						if(home.get(i) + c >= 4) {
							home.remove(i);
							jumsu++;
						} else {
							home.set(i, home.get(i++) + c); 
						}
					}
					if(c == 4) jumsu++;
					else home.add(c);
				}
				if (++idx == 9) idx = 0;
			}
		}
		max = Math.max(max, (int) jumsu);
	}
}
