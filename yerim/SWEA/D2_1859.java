package SWEA;

import java.util.Scanner;

public class D2_1859 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] price = new int[N];
			int max = 0, max_Idx = 0;
			
			// 매매가 입력받기
			for(int i = 0; i < price.length; i++) {
				price[i] = sc.nextInt();
				if(max < price[i]) {
					max_Idx = i;
					max = price[i];
				}
				
			}
			
			
		}

	}

}
