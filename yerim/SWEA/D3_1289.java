package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class D3_1289 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			char[] fir = sc.next().toCharArray();
			char[] def = new char[fir.length];
			
			int cnt = 0;
			
			// '0'으로 채우기
//			for(int i = 0; i < def.length; i++) {
//				def[i] = '0';
//			}
			Arrays.fill(def, '0');

			for(int i = 0; i < fir.length; i++) {
				if(fir[i] != def[i]) {
					cnt++;
					for(int j = i; j < fir.length; j++) {
						def[j] = fir[i];
					}					
				}
			}
			
			System.out.printf("#%d %d\n", tc, cnt);
			
		}

	}

}
