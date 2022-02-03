package BAEKJOON;

import java.util.Scanner;

public class bronze1_2999 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int N = str.length();
		int a = (int) Math.sqrt(N);
		int R = 0, C = 0;		
		
		// R과 C의 값 구하기 (R <= C, R*C=N)
		for(int i = 1; i <= a; i++) {
			if(N%i == 0) {
				R = i;
				C = N / R;
			}
		}
		
		// 행렬
		char[][] map = new char[R][C];
		int cnt = 0;
		
		for(int i = 0; i < C; i++) {
			for(int j = 0; j < R; j++) {
				map[j][i] = str.charAt(cnt);
				cnt++;
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
		}
		
	}

}
