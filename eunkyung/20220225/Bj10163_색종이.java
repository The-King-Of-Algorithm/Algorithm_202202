package day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj10163_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int M = 30;
		int[][] map = new int[M][M];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			for (int x = r; x < r + w; x++) {
				for (int y = c; y < c + h; y++) {
					map[x][y] = i;
				}
			}
		}
		int[] paper = new int[N + 1];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] != 0) {
					paper[map[i][j]]++;
				}
			}
		}
		for (int p = 1; p < paper.length; p++) {
			System.out.println(paper[p]);
		}
	}
}
