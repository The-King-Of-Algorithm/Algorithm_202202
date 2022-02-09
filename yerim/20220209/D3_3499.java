package edu.ssafy.chap04;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class D3_3499 {
	
	static String[] card1, card2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("퍼펙트셔플.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			System.out.printf("#%d ", tc);
			// 카드 입력
			if(N%2 == 0) {
				card1 = new String[N/2];
				card2 = new String[N/2];
				
				for(int i = 0; i < N/2; i++) {
					card1[i] = sc.next();
				}
				for(int i = 0; i < N/2; i++) {
					card2[i] = sc.next();
				}
				
				// 출력
				for(int i = 0; i < N/2; i++) {
					System.out.printf("%s ", card1[i]);
					System.out.printf("%s ", card2[i]);
				}
				System.out.println();
				
			} else {
				card1 = new String[N/2+1];
				card2 = new String[N/2];
				
				for(int i = 0; i < N/2+1; i++) {
					card1[i] = sc.next();
				}
				for(int i = 0; i < N/2; i++) {
					card2[i] = sc.next();
				}
				// 출력
				for(int i = 0; i < N/2; i++) {
					System.out.printf("%s ", card1[i]);
					System.out.printf("%s ", card2[i]);
				}
				System.out.println(card1[N/2]);
			}
		}

	}

}
