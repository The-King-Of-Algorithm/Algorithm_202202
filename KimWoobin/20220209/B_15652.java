package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15652 {
	static int[] arr;
	static int[] sel;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		sel = new int[M];
		
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		H(0,0);
		System.out.println(sb);

	}

	private static void H(int idx, int k) {
		if (k==sel.length) {
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i]).append(" ");
			}sb.append("\n");
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			H(i, k+1);
		}
		
	}
	
}
