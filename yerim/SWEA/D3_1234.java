package SWEA;

import java.util.ArrayList;
import java.util.Scanner;

public class D3_1234 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 문자의 총 수
			// 문자열 입력받기
			String str = sc.next();
			ArrayList<String> list = new ArrayList<>();

			// 리스트에 문자열 넣기
			for (int i = 0; i < N; i++) {
				list.add(str.substring(i, i + 1));
			}

			for (int i = list.size()-1; i >= 0; i--) {
				if (list.get(i).equals(list.get(i - 1))) {
					list.remove(Integer.valueOf(i));
					list.remove(Integer.valueOf(i));
					i = list.size()-1;
				}
			}

			System.out.printf("#%d ", tc);
			for (String i : list) {
				System.out.print(i);
			}
			System.out.println();
		}

	}

}
