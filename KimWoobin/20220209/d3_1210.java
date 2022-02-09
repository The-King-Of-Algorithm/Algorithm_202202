package SWExpert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d3_1210 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int nc = 0;
	static int nr = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("d3_1210"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			int[][] lad = new int[100][100];
			boolean isladhere = true;
			boolean uppos = true;
			
			for (int i = 0; i < lad.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < lad.length; j++) {
					lad[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < lad.length; i++) {
				for (int j = 0; j < lad.length; j++) {
					//도착점 찾기
					if (lad[i][j] == 2) {
						nr = i+dr[0];
						nc = j+dc[0];
						//맨 위로 갈때까지 돌리기
						while (nr != 0) {
							isladhere = true;
							//죄우 탐색
							for (int d = 0; d < 2; d++) {
								int nnr = nr+dr[d+2];
								int nnc = nc+dc[d+2];
								if (nnc>=0 && nnc<100) {
									//좌,우에 1이 있으면 그쪽으로 가기
									if (lad[nnr][nnc] == 1) {
										int dir = 1;
										// 1이 계속 있으면 계속가기 
										while (isladhere) {
											nr = nnr+dr[d+2]*dir;
											nc = nnc+dc[d+2]*dir;
											if (nc>=0 && nc<100) {
												if (lad[nr][nc] != 1) {
													nc = nc - dc[d+2];
													isladhere = false;
												}else {
													dir+=1;
												}
											}
											else if(nc<0 || nc>=10) {
												nc = nc - dc[d+2];
												isladhere = false;
											}
										}
									}
								}
							}
							//위로 올라가기
							nr = nr+dr[0];
							nc = nc+dc[0];
						}
					}
				}
			}
			System.out.printf("#%d %d\n",tc,nc);
			
		}
	}
}
