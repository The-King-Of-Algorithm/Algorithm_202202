package SWExpert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class d3_1873 {
	public static int[] dr = {-1,1,0,0};
	public static int[] dc = {0,0,-1,1};
	public static int H;
	public static int W;
	public static char[][] map;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("d3_1873"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][W];
			
			for (int i = 0; i < H; i++) {
				String temp = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = temp.charAt(j);
				}
			}
			
			int N= sc.nextInt();
			char[] move = new char[N];
			String temp = sc.next();
			for (int i = 0; i < move.length; i++) {
				move[i] = temp.charAt(i);
			}
			//print(map);
			
			
			int up = 0;
			int down = 1;
			int left = 2;
			int right = 3;
			int dir = 0;
			int sdir = 0;
			int sleng = 0;
			
			for (int m = 0; m < move.length; m++) {
				int nr = 0;
				int nc = 0;
				
				a:for (int r = 0; r < H; r++) {
					for (int c = 0; c < W; c++) {
						if (map[r][c] == '^' || map[r][c] == 'v' || map[r][c] == '<' || map[r][c] == '>') {
							if (move[m] == 'S') {
								if (map[r][c] == '^') {
									dir = up;
									sdir = r;
									sleng=nr;
								}else if (map[r][c] == 'v') {
									dir = down;
									sdir = H-1-r;
									sleng=nr;
								}else if (map[r][c] == '<') {
									dir = left;
									sdir = c;
									sleng=nc;
								}else if (map[r][c] == '>') {
									dir = right;
									sdir = W-1-c;
									sleng=nc;
								}
								for (int k = 1; k <= sdir; k++) {
									nr = r+dr[dir]*k;
									nc = c+dc[dir]*k;
									if (ccheck(sleng) && (map[nr][nc] == '#')) {
										break a;
									}
									else if (ccheck(sleng) && map[nr][nc] == '*') {
										map[nr][nc] = '.';
										break a;
									}
								}
							}
							if (move[m] == 'U') {
								nr = r+dr[up];
								nc = c+dc[up];
								if (rcheck(nr)) {
									if (map[nr][nc] == '.') {
										map[nr][nc] = '^';
										map[r][c] = '.';
										break a;
									}
									else if (map[nr][nc] != '.') {
										map[r][c] = '^';
									}
								}
								else if (nr<0 || nr>=H) {
									map[r][c] = '^';
								}
							}
							if (move[m] == 'D') {
								nr = r+dr[down];
								nc = c+dc[down];
								if (rcheck(nr)) {
									if (map[nr][nc] == '.') {
										map[nr][nc] = 'v';
										map[r][c] = '.';
										break a;
									}
									else if (map[nr][nc] != '.') {
										map[r][c] = 'v';
									}
								}
								else if (nr<0 || nr>=H) {
									map[r][c] = 'v';
								}
							}
							if (move[m] == 'L') {
								nr = r+dr[left];
								nc = c+dc[left];
								if (ccheck(nc)) {
									if (map[nr][nc] == '.') {
										map[nr][nc] = '<';
										map[r][c] = '.';
										break a;
									}
									else if (map[nr][nc] != '.') {
										map[r][c] = '<';
									}
								}
								else if (nc<0 || nc>=W) {
									map[r][c] = '<';
								}
							}
							if (move[m] == 'R') {
								nr = r+dr[right];
								nc = c+dc[right];
								if (ccheck(nc)) {
									if (map[nr][nc] == '.') {
										map[nr][nc] = '>';
										map[r][c] = '.';
										break a;
									}
									else if (map[nr][nc] != '.') {
										map[r][c] = '>';
									}
								}
								else if (nc<0 || nc>=W) {
									map[r][c] = '>';
								}
							}
						}
					}
				}
			}
			System.out.print("#"+tc+" ");
			print(map);
		}
	}

	private static void print(char[][] map) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j]);
			}System.out.println();
		}
	}
	
	private static boolean ccheck(int a) {
		if (a>=0 && a<W) {
			return true;
		}
		return false;	
	}
	
	private static boolean rcheck(int a) {
		if (a>=0 && a<H) {
			return true;
		}
		return false;	
	}

}
