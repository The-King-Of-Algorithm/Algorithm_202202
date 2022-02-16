package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1051 {
	static int max=1;
	static int dr[] = {0,1,1};
	static int dc[] = {1,0,1};

	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("B_1051.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] cell = new int[N][M];
		
		for (int i = 0; i < cell.length; i++) {
			String s = br.readLine();
			for (int j = 0; j < cell[i].length; j++) {
				cell[i][j] = s.charAt(j)-'0';
			}
		}
		for (int r = 0; r < cell.length; r++) {
			for (int c = 0; c < cell[r].length; c++) {
				int s=1;
				int nr=0;
				int nc=0;
				while (nr<N || nc<M) {
					int cnt=0;
					for (int d = 0; d < dr.length; d++) {
						nr = r+dr[d]*s;
						nc = c+dc[d]*s;
						if (nr<N && nc<M) {
							if (cell[nr][nc] == cell[r][c]) {
								cnt++;
							}
						}
					}
					if (cnt == 3) {
						max = Math.max(max, (s+1)*(s+1));
					}
					s+=1;
				}
			}
		}
		System.out.println(max);

	}

//	private static void print(int[][] cell) {
//		// TODO Auto-generated method stub
//		for (int i = 0; i < cell.length; i++) {
//			for (int j = 0; j < cell[i].length; j++) {
//				System.out.print(cell[i][j]);
//			}System.out.println();
//		}
//	}

}
