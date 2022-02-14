package SWEA;

import java.util.Scanner;

public class D2_1284_수도요금경쟁 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int P = sc.nextInt(); // a사 1리터 당 요금
			int Q = sc.nextInt(); // b사 r리터 이하 요금
			int R = sc.nextInt(); 
			int S = sc.nextInt(); // b사 1리터 당 요금
			int W = sc.nextInt(); // 한 달간 사용한 수도양
			int a_fee = 0;
			int b_fee = 0;
			
			a_fee = W * P;
			b_fee = Q;
			if(W > R) {
				b_fee += (W-R)*S;
			}
			
			if(a_fee >= b_fee) {
				System.out.printf("#%d %d\n", tc, b_fee);
			} else {
				System.out.printf("#%d %d\n", tc, a_fee);
			}
			
		}
		

	}

}
