package SWExpert;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class d3_9229 {
	static int N,M;
	static int ans = 0;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new BufferedInputStream(new FileInputStream("d3_9229")));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			ans = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			
			int[] arr = new int[N];
			int[] sel = new int[2];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			picksnack(arr,sel,0,0);
			
			if (ans == 0) {
				System.out.printf("#%d -1\n", tc);
			}
			else System.out.printf("#%d %d\n", tc, ans);
		}
	}

	private static void picksnack(int[] arr,int[] sel, int idx, int k) {
		if (k == sel.length) {
			if (sel[0]+sel[1] <= M) {
				ans = Math.max(sel[0]+sel[1], ans);
			}
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			picksnack(arr, sel, i+1, k+1);
		}
	}
}