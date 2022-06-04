package day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S571922년도탐사보고서의건 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int F = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N + 1];
			int Ans = 0;
			st = new StringTokenizer(bf.readLine());
			ArrayList<int[]> list = new ArrayList<int[]>();
//			Queue<int[]> q = new LinkedList<int[]>();
			int num = 1;
			while (st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				list.add(new int[] { n, num++ });
				arr[n]++;
			}
//			System.out.println(Arrays.toString(arr));
//			System.out.println(list);

			int top = list.get(list.size() - 1)[1];
			int[] poll = null;
			boolean state = true;
			ArrayList<Integer> big = new ArrayList<Integer>();
			for (int f = 0; f < F; f++) {
				if (list.size() == 1) {
					Ans = list.get(0)[0];
					break;
				}

				if (state) {
					if (list.get(list.size() - 1)[1] == top) { // 1턴 ㅋ끝
						// max계산
//						System.out.println("한턴끝");
						int max = 0;
						for (int i = 1; i < arr.length; i++) {
							max = Math.max(max, arr[i]);
						}
						big = new ArrayList<Integer>();
						for (int i = 0; i < arr.length; i++) {
							if (arr[i] == max)
								big.add(i);
						}
					}
				}
//
//				System.out.println(Arrays.toString(arr));
//				System.out.println("big" + big);

				poll = list.remove(0);
//				System.out.println(poll[0]);
				if (big != null && big.contains(poll[0])) {
//					System.out.println("DDD");
					big = null;
					arr[poll[0]]--;
					state = false;
				} else {
					list.add(poll);
					state = true;
				}

//				for (int i = 0; i < list.size(); i++) {
//					System.out.print(list.get(i)[0] + " ");
//				}
//				System.out.println();
			}

			System.out.println("#" + tc + " " + (Ans == 0 ? poll[0] : Ans));

		}

	}
}
