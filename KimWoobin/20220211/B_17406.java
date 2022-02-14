package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_17406 {
	static int[][] cell;
	static int[][] Ocell;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	static int N;
	static int M;
	static int min = Integer.MAX_VALUE;
	
	static class RCS {
		int r;
		int c;
		int s;
		
		public RCS(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}
		
		@Override
		public String toString() {
			return "RCS [r=" + r + ", c=" + c + ", s=" + s + "]";
		}
		
		
	}
	

	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("B_17406"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Ocell = new int[N][M];
		cell = new int[N][M];
		
		//배열 값 넣기 
		for (int i = 0; i < Ocell.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < Ocell[i].length; j++) {
				Ocell[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		//사용할 배열 복사 
//		for (int i = 0; i < Ocell.length; i++) {
//			for (int j = 0; j < Ocell.length; j++) {
//				cell[i][j] = Ocell[i][j];
//			}
//		}
		
		//객체에 r,c,s값 넣기 
		RCS[] rcs = new RCS[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			rcs[i] = new RCS(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		P(rcs,new RCS[K], new boolean[K], 0);
		
		//배열 돌리는 함수 돌리기 
//		int cnt = (Math.min(N, M))/2;
//		for (int k = 0; k < K; k++) {
//			rotate(cnt);
//		}
		
		//배열 출력하기 
		//print(cell);
		
		//정답(최소값) 출력 
		System.out.println(min);
	}
	
	// 순열 생성 코드 
	private static void P(RCS[] rcs, RCS[] sel, boolean[] v, int k) {
		//base part
		if (k == sel.length) {
//			System.out.println(Arrays.toString(sel));
			
			//사용할 배열 복사 
			for (int i = 0; i < Ocell.length; i++) {
				for (int j = 0; j < Ocell[i].length; j++) {
					cell[i][j] = Ocell[i][j];
				}
			}
			
			//배열 돌리는 함수 돌리기 
			for (int i = 0; i < sel.length; i++) {
				rotate(sel[i].r, sel[i].c, sel[i].s);
			}
			
			//열의 합 구하기
			for (int i = 0; i < cell.length; i++) {
				int sum = 0;
				for (int j = 0; j < cell[i].length; j++) {
					sum += cell[i][j];
				}min = Math.min(min, sum);
			}
			
			//print(cell);
			return;
			
		}
		
		//inductive part
		for (int i = 0; i < rcs.length; i++) {
			if (v[i] == false) {
				v[i] = true;
				sel[k] = rcs[i];
				P(rcs, sel, v, k+1);
				v[i] = false;
			}
		}
		
	}

	//배열 돌리는 함수 
	static void rotate(int r, int c, int s) {
		//r,c,s에 따른 값 설정 
		int start_r = r-s-1;
		int start_c = c-s-1;
		int end_r = r+s-1;
		int end_c = c+s-1;
		int new_N = end_r - start_r + 1;
		int new_M = end_c - start_c + 1;
		int cnt = Math.min(new_N, new_M)/2;
		
		// cnt만큼돌리기 
		for (int i = 0; i < cnt; i++) {
			int dir = 0;
			int R = start_r+i;
			int C = start_c+i;
			int temp = cell[R][C];
			
			// 한바퀴돌리기 
			while(dir<4) {
				int nr = R+dr[dir];
				int nc = C+dc[dir];
				
				if (nr>=start_r+i && nr<=end_r-i && nc>=start_c+i && nc<=end_c-i) {
					cell[R][C] = cell[nr][nc];
					R = nr;
					C = nc;
				}
				else {
					dir++;
				}
				
			}
			cell[i+start_r][i+start_c+1] = temp;
			
		}//print(cell);
	}
	
	//배열 출력하는 함수 
	private static void print(int[][] cell2) {
		for (int i = 0; i < cell2.length; i++) {
			for (int j = 0; j < cell2[i].length; j++) {
				System.out.print(cell[i][j]+" ");
			}System.out.println();
		}System.out.println();
		
	}
	

}
