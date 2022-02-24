package day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class JOL1205_조커 {
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("src/day08/조커.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		List<Integer> list = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int zero = 0;
		int res = 0;

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n != 0) {
				if (!list.contains(n))
					list.add(n);
			} else {
				zero++;
			}
		}

		Collections.sort(list);

		if (list.isEmpty()) {
			res = zero;
		} else {
			int i = 0;
			while (i < list.size() - 1) {
				int max = 1;
				int cnt = 0;
				int current = list.get(i) + 1;
				List<Integer> tmp = new ArrayList<Integer>();
				int j = i + 1;
				while (cnt <= zero) {
					if (j >= list.size()) {
						if (++cnt > zero) {
							break;
						}
					} else {
						if (current != list.get(j)) {
							if (++cnt > zero) {
								break;
							}
						} else {
							j++;
						}
					}
					tmp.add(current);
					current++;
					max++;
				}
				res = Math.max(res, max);
				i++;
			}
		}
		System.out.println(res);
	}
}
