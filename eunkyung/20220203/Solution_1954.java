package hw_20220203;

import java.util.Scanner;

public class Solution_1954 {
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int a = 1;
			int x = 0, y = 0;
			map[x][y] = a;
			
			while(a < N*N) {
				for (int move = 0; move < dx.length; move++) {
					int cnt = 1;
					while (cnt <= N) {
						int nx = x + dx[move] * cnt;
						int ny = y + dy[move] * cnt;
						if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0) {
							a++;
							if(a > N*N) break;
							map[nx][ny] = a;
							cnt++;
						} else {
							x = nx - dx[move];
							y = ny - dy[move];
							break;
						}
					}
				}
			}
			System.out.println("#" + test_case + " ");
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
