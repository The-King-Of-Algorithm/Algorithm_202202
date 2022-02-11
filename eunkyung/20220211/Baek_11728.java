package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//배열 합치기
public class Baek_11728 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> res = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			list1.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < M; i++) {
			list2.add(Integer.parseInt(st.nextToken()));
		}

		int a = 0;
		int b = 0;
		while (a < list1.size() && b < list2.size()) {
			if (list1.get(a) < list2.get(b)) {
				sb.append(list1.get(a++) + " ");
			} else {
				sb.append(list2.get(b++) + " ");
			}
		}

		while (a < list1.size()) {
			sb.append(list1.get(a++) + " ");
		}
		while (b < list2.size()) {
			sb.append(list2.get(b++) + " ");
		}
		System.out.println(sb);

	}

}
