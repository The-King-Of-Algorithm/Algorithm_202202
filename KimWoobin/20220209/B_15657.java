package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_15657 {
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
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		H(0,0);
		System.out.println(sb);

	}

	private static void H(int idx, int k) {
		if (k==sel.length) {
			for (int i = 0; i < sel.length; i++) {
				//System.out.print(sel[i]+" ");
				sb.append(sel[i]).append(" ");
			}//System.out.println();
			sb.append("\n");
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			H(i, k+1);
		}
		
	}
	
}
