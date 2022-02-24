package IMTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오목판정 {
	static int N;
	static char[][] cell;
	static int[] dr = {-1,0,1,1};
	static int[] dc = {1,1,1,0};
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("오목판정.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			cell = new char[N][N];
			for (int i = 0; i < cell.length; i++) {
				String s = br.readLine();
				for (int j = 0; j < cell.length; j++) {
					cell[i][j] = s.charAt(j);
				}
			}
			
			boolean a = false;
			la:for (int r = 0; r < cell.length; r++) {
				for (int c = 0; c < cell.length; c++) {
					if (cell[r][c] == 'o') {
						for (int d = 0; d < dr.length; d++) {
							int n=1;
							int cnt=1;
							while(n<5) {
								int nr = r+dr[d]*n;
								int nc = c+dc[d]*n;
								if (nr>=0 && nr<N && nc>=0 && nc<N) {
									if (cell[nr][nc] == 'o') {
										n+=1;
										cnt+=1;
									}else {
										break;
									}
								}else {
									break;
								}
							}
							if (cnt == 5) {
								//System.out.println(r+" "+c);
								int nr = r-dr[d];
								int nc = c-dc[d];
								if (nr>=0 && nr<N && nc>=0 && nc<N) {
									if (cell[nr][nc] == 'o') {
									}else {
										System.out.printf("#%d %s\n",tc,"YES");
										a = true;
										break la;
									}
								}else {
									System.out.printf("#%d %s\n",tc,"YES");
									a = true;
									break la;
								}
							}
						}
					}
				}
			}
			if (a==false) {
				System.out.printf("#%d %s\n",tc,"NO");
			}
			
			
		}

	}

//	private static void omok(int r, int c) {
//		for (int d = 0; d < dr.length; d++) {
//			int n=1;
//			int cnt=1;
//			while(n<5) {
//				int nr = r+dr[d]*n;
//				int nc = c+dc[d]*n;
//				if (nr>=0 && nr<N && nc>=0 && nc<N) {
//					if (cell[nr][nc] == 'o') {
//						n+=1;
//						cnt+=1;
//					}else {
//						break;
//					}
//				}else {
//					break;
//				}
//			}
//			if (cnt == 5) {
//				//System.out.println(r+" "+c);
//				int nr = r-dr[d];
//				int nc = c-dc[d];
//				if (nr>=0 && nr<N && nc>=0 && nc<N) {
//					if (cell[nr][nc] == 'o') {
//					}else {
//						System.out.println("YES");
//						cnt+=1;
//					}
//				}else {
//					System.out.println("YES");
//					cnt+=1;
//				}
//			}
//		}
//		
//	}

	private static void print(char[][] cell) {
		for (int i = 0; i < cell.length; i++) {
			for (int j = 0; j < cell.length; j++) {
				System.out.print(cell[i][j]+" ");
			}System.out.println();
		}
		
	}

}
