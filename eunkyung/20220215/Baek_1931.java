package hw_20220215;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//회의실 배정
//그리디
public class Baek_1931 {
	static class meet implements Comparable<meet> {
		int start;
		int end;

		public meet(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(meet o) {
			if (this.end == o.end) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
	}

	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		meet[] m = new meet[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			m[i] = new meet(start, end);
		}

		Arrays.sort(m);
		greedy(m);
	}

	private static void greedy(meet[] m) {
		int cnt = 1;
		int start = m[0].start;
		int end = m[0].end;

		for (int i = 1; i < m.length; i++) {
			int nextstart = m[i].start;
			int nextend = m[i].end;
			if (end <= nextstart) {
				cnt++;
				start = nextstart;
				end = nextend;
			}
		}
		System.out.println(cnt);
	}
}
