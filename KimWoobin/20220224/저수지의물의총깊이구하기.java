package IMTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 저수지의물의총깊이구하기 {
	static int N;
	static char[][] cell;
	static int[] dr = {-1,1,0,0,-1,-1,1,1};
	static int[] dc = {0,0,-1,1,1,-1,1,-1};
	static int gcnt,wcnt,ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("저수지의물의총깊이구하기.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			cell = new char[N][N];
			ans=0;
			
			for (int i = 0; i < cell.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < cell.length; j++) {
					cell[i][j] = st.nextToken().charAt(0);
				}
			}
			
			for (int i = 0; i < cell.length; i++) {
				for (int j = 0; j < cell.length; j++) {
					if (cell[i][j] == 'W') {
						gcnt=0;
						wcnt=0;
						cal(i,j);
						ans = Math.max(ans,wcnt);
					}
					
				}
			}
			 
			System.out.printf("#%d %d\n",tc,ans);
		}
		

	}

	private static void cal(int r, int c) {
		for (int d = 0; d < dr.length; d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			if (nr>=0 && nr<N && nc>=0 && nc<N) {
				if (cell[nr][nc] == 'G') {
					gcnt+=1;
				}
				if (cell[nr][nc] == 'W') {
					wcnt+=1;
				}
			}
		}
		
		if (gcnt == 8) {
			wcnt = 1;
		}
	}

	private static void print(char[][] cell) {
		for (int i = 0; i < cell.length; i++) {
			for (int j = 0; j < cell.length; j++) {
				System.out.print(cell[i][j]+" ");
			}System.out.println();
		}
	}

}
