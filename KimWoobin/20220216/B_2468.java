package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_2468 {
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int N;
	static int[][] cell;
	static int[][] gnd;
	static boolean[][] v;
	static int cnt;
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader br = new BufferedReader(new FileReader("B_2468.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cell = new int[N][N];
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		for (int i = 0; i < cell.length; i++) { //값 담기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < cell.length; j++) {
				cell[i][j] = Integer.parseInt(st.nextToken());
				list1.add(cell[i][j]);
			}
		}
		
		for (int i = 0; i < list1.size(); i++) { //지형 종류 뽑기
			if (list2.contains(list1.get(i)) == false) {
				list2.add(list1.get(i));
			}
		}
		Collections.sort(list2);
		//System.out.println(list2);
		
		
		int listidx=0;
		while (listidx != list2.size()) {
			gnd = Arrays.copyOf(cell, cell.length);	
			v = new boolean[N][N];
			cnt = 0;
			
			for (int i = 0; i < gnd.length; i++) {
				for (int j = 0; j < gnd.length; j++) {
					if (gnd[i][j] < list2.get(listidx)) {
						gnd[i][j] = 0;
					}
				}
			}
			print(gnd);
			System.out.println("--------------");
			for (int r = 0; r < gnd.length; r++) {
				for (int c = 0; c < gnd.length; c++) {
					if (gnd[r][c] != 0 && v[r][c] == false) {
						dfs(r,c);
						cnt++;
					}
				}
			}
			max = Math.max(max, cnt);
			listidx+=1;
		}
		System.out.println(max);

	}

	private static void dfs(int r, int c) {
		v[r][c] = true;
		
		for (int d = 0; d < dr.length; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if (nr>=0 && nr<N && nc>=0 && nc<N && gnd[nr][nc] != 0 && v[nr][nc] == false) {
				dfs(nr, nc);
			}
		}
		
	}

	private static void print(int[][] cell) {
		for (int i = 0; i < cell.length; i++) {
			for (int j = 0; j < cell.length; j++) {
				System.out.print(cell[i][j]+" ");
			}System.out.println();
		}
		
	}

}
