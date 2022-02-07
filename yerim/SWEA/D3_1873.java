package SWEA;

import java.util.Scanner;

public class D3_1873 {
	// up, down, left, right
//	static int[] row = {-1, 1, 0, 0};
//	static int[] col = {0, 0, -1, 1};

	public static void main(String[] args) {
		//System.setIn(new File);
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] map = new char[H][W];
			int h_idx = 0, w_idx = 0; // 현재 전차위치 저장

			// map에 입력받기
			for (int i = 0; i < map.length; i++) {
				String strW = sc.next();
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = strW.charAt(j);
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						h_idx = i;
						w_idx = j;
					}
				}
			}
			// System.out.println(h_idx + " " + w_idx);
			// print(map);

			int N = sc.nextInt(); // 문자열 크기
			char[] chr = sc.next().toCharArray(); // 문자열 입력받음
//			int[] dir = {0, 1, 2, 3}; // 전차 방향 ( 

			// 입력값받아서 탱크 움직이기..
			for (int i = 0; i < N; i++) {
				switch (chr[i]) {
				case 'U': {
					map[h_idx][w_idx] = '^';
					if (h_idx - 1 >= 0 && h_idx - 1 < H) {
						if(map[h_idx-1][w_idx] == '.') {
							map[h_idx][w_idx] = '.';
							h_idx = h_idx - 1;
							map[h_idx][w_idx] = '^';
						}					
					} break;
				}
				case 'D':{
					map[h_idx][w_idx] = 'v';
					if (h_idx + 1 >= 0 && h_idx + 1 < H) {
						if(map[h_idx+1][w_idx] == '.') {
							map[h_idx][w_idx] = '.';
							h_idx = h_idx + 1;
							map[h_idx][w_idx] = 'v';
						}						
					} break;
				}
				case 'L':{
					map[h_idx][w_idx] = '<';
					if (w_idx - 1 >= 0 && w_idx - 1 < W) {
						if(map[h_idx][w_idx-1] == '.') {
							map[h_idx][w_idx] = '.';
							w_idx = w_idx - 1;
							map[h_idx][w_idx] = '<';
						}						
					} break;
				}
				case 'R':{
					map[h_idx][w_idx] = '>';
					if (w_idx + 1 >= 0 && w_idx + 1 < W) {
						if(map[h_idx][w_idx+1] == '.') {
							map[h_idx][w_idx] = '.';
							w_idx = w_idx + 1;
							map[h_idx][w_idx] = '>';
						}						
					} break;
				}
				
				// Shoot
				case 'S':{
					switch(map[h_idx][w_idx]) {
					case '^':{
						for(int m = h_idx; m >= 0; m--) {
							if(map[m][w_idx] == '#') {
								break;
							} else if(map[m][w_idx] == '*') {
								map[m][w_idx] = '.';
								break;
							}
						}
						break;
					}
					case 'v':{
						for(int m = h_idx; m < H; m++) {
							if(map[m][w_idx] == '#') {
								break;
							} else if(map[m][w_idx] == '*') {
								map[m][w_idx] = '.';
								break;
							}
						}
						break;
					}
					case '<':{
						for(int m = w_idx; m >= 0; m--) {
							if(map[h_idx][m] == '#') {
								break;
							} else if(map[h_idx][m] == '*') {
								map[h_idx][m] = '.';
								break;
							}
						}
						break;
					}
					case '>':{
						for(int m = w_idx; m < W; m++) {
							if(map[h_idx][m] == '#') {
								break;
							} else if(map[h_idx][m] == '*') {
								map[h_idx][m] = '.';
								break;
							}
						}
						break;
					}
					}
				}
				}
			}
			
			System.out.printf("#%d ", tc);
			print(map);
		}
	}

	private static void print(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
