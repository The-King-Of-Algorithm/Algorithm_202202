package edu.ssafy.chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//암호생성기
public class Solution_1225 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = Integer.parseInt(bf.readLine());
			Queue<Integer> q = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(bf.readLine());

			boolean state = false;

			for (int n = 0; n < 8; n++) {
				int a = Integer.parseInt(st.nextToken());
				q.offer(a);
			}

			while (!state) {
				for (int i = 1; i <= 5; i++) {
					int a = q.poll();
					if (a - i > 0) {
						q.offer(a - i);
					} else {
						q.offer(0);
						state = true;
						break;
					}
				}
			}

			System.out.print("#" + test_case + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}
}
