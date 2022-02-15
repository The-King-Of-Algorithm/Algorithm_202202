package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2839_recursive {
	static int[] arr = {3,5};
	static int min = 999999999;
	static int cnt=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		recursive(0,new int[N],N);
		
		if (cnt == 0) { 
			min = -1; 
		} 
		System.out.println(min);
		 
		
		
	}
	private static void recursive(int idx, int[] sel,int N) {
		if (N == 0) {
			cnt++;
			min = Math.min(min, idx);
			return;
		}
		if (N < 0) {
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			sel[idx] = arr[i];
			recursive(idx+1, sel,N-arr[i]);
			sel[idx]=0;
		}
		
	}

}