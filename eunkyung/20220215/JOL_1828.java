package hw_20220215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//냉장고
public class JOL_1828 {
	static class Chemical implements Comparable<Chemical> {
		int x;
		int y;

		public Chemical(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Chemical [x=" + x + ", y=" + y + "]";
		}

		@Override
		public int compareTo(Chemical o) {
			if (this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		Chemical[] c = new Chemical[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			c[i] = new Chemical(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(c);

		greedy(c);
	}

	private static void greedy(Chemical[] c) {
		int cnt = 1;
		int min = c[0].x;
		int max = c[0].y;

		for (int i = 1; i < c.length; i++) {
			int nextmin = c[i].x;
			int nextmax = c[i].y;
			if (max < nextmin) {
				cnt++;
				min = nextmin;
				max = nextmax;
			} else {
				min = Math.max(min, nextmin);
				max = Math.min(max, nextmax);
			}
		}
		System.out.println(cnt);
	}
}
