package pratice2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상호의배틀필드 {
	/*
	 * 1 3 7 .... -..#** #<.**** 23 SURSSSSUSLSRSSSURRDSRDS
	 */
	static class Tank {
		int row;
		int col;
		int direction;

		public Tank() {

		}
	}

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			char[][] map = new char[row][col];

			for (int i = 0; i < row; i++) {
				String s = bf.readLine();
				for (int j = 0; j < s.length(); j++) {
					map[i][j] = s.charAt(j);
				}
			}
			// 초기 전차 위치 찾기
			Tank tank = new Tank();
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (map[i][j] == '<') {
						tank.row = i;
						tank.col = j;
						tank.direction = 2;
					} else if (map[i][j] == '^') {
						tank.row = i;
						tank.col = j;
						tank.direction = 0;
					} else if (map[i][j] == 'v') {
						tank.row = i;
						tank.col = j;
						tank.direction = 1;
					} else if (map[i][j] == '>') {
						tank.row = i;
						tank.col = j;
						tank.direction = 3;
					}
				}
			}

			int cnt = Integer.parseInt(bf.readLine());
			String movestring = bf.readLine();
			char move[] = new char[movestring.length()];
			for (int i = 0; i < move.length; i++) {
				move[i] = movestring.charAt(i);
			}
			int count = 0;
			while (count < cnt) {
				tankmove(tank, move[count], map);
				//System.out.println(move[count] + "무브후");
				count++;
			}
			System.out.print("#" + t + " ");
			for (char[] tmp : map) {
				for (char tmp1 : tmp) {
					System.out.print(tmp1);
				}
				System.out.println();
			}
		}
		
	}

	static void tankmove(Tank tank, char ch, char[][] map) {
		int row = tank.row;
		int col = tank.col;

		if (ch == 'S') {
			while (true) {
				int nrow = row + dr[tank.direction];
				int ncol = col + dc[tank.direction];

				// System.out.println(nrow);
				// System.out.println(ncol);
				if (nrow >= 0 && nrow < map.length && ncol >= 0 && ncol < map[0].length) {
					row = nrow;
					col = ncol;
					if (map[nrow][ncol] == '*') {
						map[nrow][ncol] = '.';
						// System.out.println(nrow+" "+ncol+"삭제");
						break;
					} else if (map[nrow][ncol] == '#') {
						// System.out.println(nrow+" "+ncol+"벽만남");
						break;
					}
				} else
					// System.out.println(nrow+" "+ncol+"범위나감");
					break;
			}
		} else {
			if (ch == 'U') {
				tank.direction = 0;
			} else if (ch == 'D') {
				tank.direction = 1;
			} else if (ch == 'L') {
				tank.direction = 2;
			} else if (ch == 'R') {
				tank.direction = 3;
			}
			// System.out.println("현재 탱크 위치");
			// System.out.println(tank.row +" "+tank.col);
			// System.out.println(tank.direction);
			int nrow = tank.row + dr[tank.direction];
			int ncol = tank.col + dc[tank.direction];
			if (nrow >= 0 && nrow < map.length && ncol >= 0 && ncol < map[0].length) {
				if (map[nrow][ncol] == '.') {
					map[tank.row][tank.col] = '.';
					tank.row = nrow;
					tank.col = ncol;
				}
			}
			if (tank.direction == 0) {
				map[tank.row][tank.col] = '^';
			} else if (tank.direction == 1) {
				map[tank.row][tank.col] = 'v';
			} else if (tank.direction == 2) {
				map[tank.row][tank.col] = '<';
			} else if (tank.direction == 3) {
				map[tank.row][tank.col] = '>';
			}
		}
	}

}
