package SWExpert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class d3_6958 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("d3_6958"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
				
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] jumsu = new int[N][M];
			int max = 0;
			int winner = 0;
			
			for (int i = 0; i < N; i++) {
				int cnt=0;
				
				for (int j = 0; j < M; j++) {
					jumsu[i][j] = sc.nextInt();
					
					if (jumsu[i][j] == 1) { //맞춘문제 세기
						cnt++;
					}
				}
				
				// 우승자 명수세기
				if (cnt > max) {
					max = cnt;
					winner = 1;
				}else if(cnt == max) {
					max = cnt;
					winner++;
				}
				
			}
			
			System.out.printf("#%d %d %d\n",tc,winner,max);
			
		}
	}

}
