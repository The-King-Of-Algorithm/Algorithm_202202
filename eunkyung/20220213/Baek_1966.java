package day09;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//프린터 큐

public class Baek_1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<int[]> q = new LinkedList<int[]>();
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int c = 0;
			int cnt = 0;
			q.clear();

			for (int n = 0; n < N; n++) {
				int p = sc.nextInt();
				q.offer(new int[] { n, p });
			}

			while (true) {
				int[] k = q.poll();
				boolean state = true;

				for (int i = 0; i < N - 1; i++) {
					int[] p = q.poll();
					if (k[1] < p[1]) {
						state = false;
					}
					q.offer(p);
				}
				if (state) {
					cnt++;
					N--;
					if (k[0] == M) {
						System.out.println(cnt);
						break;
					}
				} else {
					q.offer(k);
				}

			}

		}
	}
}
