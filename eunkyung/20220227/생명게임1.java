package day13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 생명게임1 {
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int[][] map;
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/day13/생명게임1.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		map = new int[25][25];
		check = new boolean[25][25];
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				operation(i, j);
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(check[i][j]) {
					System.out.print("1 ");
				}
				else System.out.print("0 ");
			}
			System.out.println();
		}

	}

	private static void operation(int r, int c) {
		int cnt = 0;
		for (int d = 0; d < dx.length; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];
			if (nr >= 0 && nr < map.length && nc >= 0 && nc < map.length && map[nr][nc] == 1) {
				cnt++;
			}
		}

		if (map[r][c] == 0) {
			if(cnt == 3) check[r][c] = true;
		} else {
			if(cnt == 2 || cnt == 3) check[r][c] = true;
		}
	}
}
