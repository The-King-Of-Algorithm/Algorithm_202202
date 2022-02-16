package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1992 {
	static int[][] cell;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader br = new BufferedReader(new FileReader("B_1992.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		cell = new int[N][N];
		
		
		for (int i = 0; i < cell.length; i++) {
			String s = br.readLine();
			for (int j = 0; j < cell.length; j++) {
				cell[i][j] = s.charAt(j)-'0';
			}
		}
		//print(cell);
		
		recursive(0,0,N);
		System.out.println(sb);
	}

	private static void recursive(int r, int c, int n) {
		if (n==1) {
			sb.append(cell[r][c]);
			return;
		}
		
		int cnt = 0;
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if (cell[r][c] == cell[i][j]) {
					cnt++;
				}
			}
		}
		if (cnt == n*n) {
			sb.append(cell[r][c]);
			return;
		}else {
			sb.append("(");
			recursive(r,c,n/2);
			recursive(r,c+n/2,n/2);
			recursive(r+n/2,c,n/2);
			recursive(r+n/2,c+n/2,n/2);
			sb.append(")");
		}
	}

//	private static boolean check(int r, int c, int n) {
//		int cnt = 0;
//		for (int i = r; i < r+n; i++) {
//			for (int j = c; j < c+n; j++) {
//				if (cell[r][c] == cell[i][j]) {
//					cnt++;
//				}
//			}
//		}
//		if (cnt == n*n) {
//			return true;
//		}else {
//			return false;
//		}
//	}

	private static void print(int[][] cell) {
		for (int i = 0; i < cell.length; i++) {
			for (int j = 0; j < cell.length; j++) {
				System.out.print(cell[i][j]+" ");
			}System.out.println();
		}
	
	}

}
