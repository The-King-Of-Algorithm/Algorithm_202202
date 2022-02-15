package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_5212 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("B_5212.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<Integer>();
		
		char[][] cell = new char[N][M];
		
		for (int i = 0; i < cell.length; i++) { // 바다 생성하기
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < cell[i].length; j++) {
				cell[i][j] = temp[j];
			}
		}
		
		for (int i = 0; i < cell.length; i++) { //없어지는 섬들의 좌표값 받기
			for (int j = 0; j < cell[i].length; j++) {
				int cnt = 0;
				if (cell[i][j] == 'X') {
					for (int d = 0; d < dr.length; d++) {
						int nr = i+dr[d];
						int nc = j+dc[d];
						
						if (nr>=0 && nr<N && nc>=0 && nc<M) {
							if (cell[nr][nc] == '.') {
								cnt++;
							}
						}
						else if (nr>=0 || nr<N || nc>=0 || nc<M) {
							cnt++;
						}
					}
					if (cnt >= 3) {
						q.add(i);
						q.add(j);
					}
				}
			}
		}
		int l1 = q.size();
		for (int i = 0; i < l1/2; i++) { //없어져야하는 섬들 없애기
			cell[q.poll()][q.poll()] = '.';
		}
		//print(cell);
		//System.out.println("-------------------------");
		
		int minr = 9999999;
		int maxr = 0;
		int minc = 9999999;
		int maxc = 0;
		
		for (int i = 0; i < cell.length; i++) {
			for (int j = 0; j < cell[i].length; j++) {
				if (cell[i][j] == 'X') {
					minr = Math.min(minr, i);
					maxr = Math.max(maxr, i);
					minc = Math.min(minc, j);
					maxc = Math.max(maxc, j);
				}
			}
		}
//		System.out.println("minr : "+minr);
//		System.out.println("maxr : "+maxr);
//		System.out.println("minc : "+minc);
//		System.out.println("maxc : "+maxc);
		
		for (int i = minr; i <= maxr; i++) {
			for (int j = minc; j <= maxc; j++) {
				System.out.print(cell[i][j]);
			}System.out.println();
		}
		
	}

	private static void print(char[][] cell) {
		for (int i = 0; i < cell.length; i++) {
			for (int j = 0; j < cell[i].length; j++) {
				System.out.print(cell[i][j]);
			}System.out.println();
		}
		
	}

}
