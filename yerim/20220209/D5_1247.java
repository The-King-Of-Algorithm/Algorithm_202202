package edu.ssafy.chap04;

import java.util.Scanner;

public class D5_1247 {
	
	static int N, min;
	static int[][] map;
	static int[] sel;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N+2][2]; // 0 : 회사, 1: 집
			sel = new int[N];
			v = new boolean[N];
			min = Integer.MAX_VALUE;
			
			// 좌표 입력
			for(int i = 0; i < map.length; i++) {
				for(int j = 0; j < map[i].length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
								
			permutation(0);
			System.out.printf("#%d %d\n", tc, min);
			
		}

	}

	private static void permutation(int k) {
		
		if(k == sel.length) {
			int sum = 0;
			for(int i = 0; i < sel.length; i++) {
				// 회사에서 출발했을때
				if(i == 0) {
					sum += (Math.abs(map[sel[i]+2][0] - map[0][0])) + (Math.abs(map[sel[i]+2][1] - map[0][1]));
					
				} 
				// 마지막 원소는 집 까지 간것도 더함
				else if(i == sel.length-1) {
					sum += (Math.abs(map[sel[i]+2][0] - map[1][0])) + (Math.abs(map[sel[i]+2][1] - map[1][1]));
					sum += (Math.abs(map[sel[i]+2][0] - map[sel[i-1]+2][0])) + (Math.abs(map[sel[i]+2][1] - map[sel[i-1]+2][1]));
					//System.out.println(sum);
					
				} else {
					sum += (Math.abs(map[sel[i]+2][0] - map[sel[i-1]+2][0])) + (Math.abs(map[sel[i]+2][1] - map[sel[i-1]+2][1]));
					//System.out.println(sum);
				}
			}
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(v[i] == false) {
				v[i] = true;
				sel[k] = i;
				permutation(k+1);
				v[i] = false;
			}
			
		}
	}

}
