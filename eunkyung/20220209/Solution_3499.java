package hw_20220209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
//퍼펙트 셔플
public class Solution_3499 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(bf.readLine());
			LinkedList<String> list = new LinkedList<String>();

			StringTokenizer st = new StringTokenizer(bf.readLine());

			for (int i = 0; i < N; i++) {
				list.add(st.nextToken());
			}
			int center = N / 2;
			while (center >= 1) {
				list.add(center, list.get(list.size() - 1));
				list.removeLast();
				center--;
			}
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();

		}
	}
}
