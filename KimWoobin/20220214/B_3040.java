package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_3040 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("B_3040.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		com(arr, new int[7], 0,0);
	}

	private static void com(int[] arr, int[] sel, int idx, int k) {
		if (k==sel.length) {
			int sum = 0;
			for (int i = 0; i < sel.length; i++) {
				sum+=sel[i];
			}
			if (sum == 100) {
				for (int i = 0; i < sel.length; i++) {
					System.out.println(sel[i]);
				}
			}
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			com(arr, sel, i+1, k+1);
			
		}
		
	}

}
