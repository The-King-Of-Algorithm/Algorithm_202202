package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class silver2_18111_마인크래프트 {

	static int N, M, B, time = 987654321, height = -1;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int max = 0, min = 257;

		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}			
		}

		for (int i = min; i <= max; i++) {
			getTime(i);
		}

		System.out.printf("%d %d", time, height);
	}

	private static void getTime(int h) {
		int block = B;
		int time_a = 0;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] < h) {
					time_a += h - map[i][j];
					block -= h - map[i][j];
				} else if (map[i][j] > h) {
					time_a += 2 * (map[i][j] - h);
					block += map[i][j] - h;
				}
			}			
		}
		
		if(block < 0) time_a = 987654321; 
		
		if (time_a <= time) {
			time = time_a;
			height = h;
		}
	}
}
