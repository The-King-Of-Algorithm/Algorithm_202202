package SWExpert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d4_1861 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader br = new BufferedReader(new FileReader("d4_1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] cell = new int[N][N];
			int min = Integer.MAX_VALUE;
			int maxans = 0;
			
			for (int i = 0; i < cell.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < cell.length; j++) {
					cell[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < cell.length; i++) {
				for (int j = 0; j < cell.length; j++) {
					int ni = i;
					int nj = j;
					int ans=1;
					int cnt=1;
					
					while(cnt != 5) {
						cnt = 1;
						for (int d = 0; d < 4; d++) {
							int nr = ni+dr[d];
							int nc = nj+dc[d];
							if (nr>=0 && nr<N && nc>=0 && nc<N) {
								if (cell[ni][nj]+1 == cell[nr][nc]) {
									ans++;
									ni = nr;
									nj = nc;
								}
								else cnt++;
							}
							else cnt++;
						}
					}
					if (ans > maxans) {
						maxans = ans;
						min = cell[i][j];
					}
					else if (ans == maxans) {
						min = Math.min(cell[i][j], min);
					}
				}
			}
			System.out.printf("#%d %d %d\n",tc,min,maxans);
		}
	}
}
