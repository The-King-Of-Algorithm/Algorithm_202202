package day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1759_암호만들기 {
	static char[] arr;
	static char[] arr2 = { 'a', 'e', 'i', 'o', 'u' };
	static StringBuilder sb = new StringBuilder();
	static int L, C;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(arr);

		combination(0, new ArrayList<Character>());
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	private static void combination(int start, ArrayList<Character> list) {
		if (list.size() == L) {
			int cnt = 0;
			for (int i = 0; i < arr2.length; i++) 
				if(list.contains(arr2[i])) cnt++;
			if(cnt < 1) return;
			if(list.size() - cnt < 2) return;
			for (int i = 0; i < list.size(); i++) sb.append(list.get(i));
			sb.append("\n");
			return;
		}
		for (int i = start; i < arr.length; i++) {
			list.add(arr[i]);
			combination(i + 1, list);
			list.remove(list.get(list.size() - 1));
		}

	}
}
