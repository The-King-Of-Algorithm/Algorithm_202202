package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_10026 {
	static int N,cnt1,cnt2;
	static char[][] cell;
	static boolean[][] v;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader br = new BufferedReader(new FileReader("B_10026.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cell = new char[N][N];
		
		
		for (int i = 0; i < cell.length; i++) { //배열 값 넣어주기
			String s = br.readLine();
			for (int j = 0; j < cell.length; j++) {
				cell[i][j] = s.charAt(j);
			}
		}
		
		cnt1=0;
		v = new boolean[N][N];
		for (int i = 0; i < cell.length; i++) { //색약 아닐때 분할찾기
			for (int j = 0; j < cell.length; j++) {
				if (v[i][j] == false) {
					cnt1+=1;
					v[i][j] = true;
					dfs(i,j);
				}
			}
		}
		
		for (int i = 0; i < cell.length; i++) { //G -> R로 바꾸기
			for (int j = 0; j < cell.length; j++) {
				if (cell[i][j] == 'G') {
					cell[i][j] = 'R';
				}
			}
		}
		
		cnt2=0;
		v = new boolean[N][N];
		for (int i = 0; i < cell.length; i++) { //색약일때 분할 찾기
			for (int j = 0; j < cell.length; j++) {
				if (v[i][j] == false) {
					cnt2+=1;
					v[i][j] = true;
					dfs(i,j);
				}
			}
		}
		
		
		System.out.println(cnt1+" "+cnt2);

	}
	private static void dfs(int r, int c) {
		
		for (int d = 0; d < dr.length; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if (nr>=0 && nr<N && nc>=0 && nc<N && v[nr][nc] == false && cell[nr][nc] == cell[r][c]) {
				v[nr][nc] = true;
				dfs(nr, nc);
			}
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
