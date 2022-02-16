package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//숫자 정사각형
public class Baek_1051 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int max = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		Queue<Integer> q = new LinkedList<Integer>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		for (int i = 0; i < map.length; i++) {
			String str = bf.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		for (int r = 0; r < map.length; r++) {
			q.clear();
			for (int c = 0; c < map[r].length; c++) {
				int nc = c + 1;
				while (nc < M) {					
					if (map[r][c] == map[r][nc]) {
						q.offer(nc);
					}
					nc++;
				}
				while (!q.isEmpty()) {
					int n = q.poll(); // 좌표값이지..
					int length = n - c;
					int x = r + length;
					int size = 0;
					if (x < N) {
						if (map[x][c] == map[r][c] && map[x][n] == map[r][c]) {
							size = (length + 1) * (length + 1);
							max = Math.max(max, size);
						}
					}
				}
			}
		}
		System.out.println(max);

	}

//	private static void print(int[][] map) {
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//
//	}
}
