package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 모의SW역량테스트_4012_요리사 {
	
	static int N, result;
	static int[][] map;
	static int[] sel1, sel2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("요리사.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N+1][N+1];
			sel1 = new int[N/2];
			sel2 = new int[N/2];
			result = 987654321;
			
			for (int i = 1; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			comb(1, 0);
			
			System.out.printf("#%d %d\n", tc, result);
		}
		
		

	}

	private static void comb(int idx, int k) {
		boolean[] v = new boolean[N+1];
		
		if(k == sel1.length) {
			int a = 0;
			int sum1 = 0, sum2 = 0;
			
			// sel2 배열 만들어주기
			for(int i = 1; i <= N; i++) {
				for(int j = 0; j < sel1.length; j++) {
					if(sel1[j] == i) {
						v[i] = true;
					}
				}
				if(v[i] == false) {
					sel2[a] = i;
					a++;
				}
			}
			
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < N/2; j++) {
					if(i==j) continue;
					sum1 += map[sel1[i]][sel1[j]];
					sum2 += map[sel2[i]][sel2[j]];
				}
			}
			
			result = Math.min(result, Math.abs(sum1 - sum2));
			
			return;
		}
		
		for(int i = idx; i <= N; i++) {
			sel1[k] = i;
			comb(i+1, k+1);
		}
		
	}

}
