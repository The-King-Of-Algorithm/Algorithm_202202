package SWEA;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class D1_2063 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			num[i] = sc.nextInt();
		}
		
		Arrays.sort(num);
		
		System.out.println(num[N/2+1]);
	}

}
