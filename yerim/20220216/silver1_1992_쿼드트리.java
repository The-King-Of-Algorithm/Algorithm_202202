package edu.ssafy.chap06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class silver1_1992_쿼드트리 {
	
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < map.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		Quad(N, 0, 0);
	}
	private static void Quad(int N, int r, int c) {
		
		if(N==1) {
			System.out.print(map[r][c]);
			return;
		}
		
		boolean flag = true;
		
		// 값 비교
		for(int i = r; i < r+N; i++) {
			for (int j = c; j < c+N; j++) {
				if(map[i][j] != map[r][c])
					flag = false;
			}
		}
		
		if(!flag) {
			System.out.print("(");
			Quad(N/2, r, c);
			Quad(N/2, r, c+N/2);
			Quad(N/2, r+N/2, c);
			Quad(N/2, r+N/2, c+N/2);
			System.out.print(")");
		} else {
			System.out.print(map[r][c]);
		}
	}

}
