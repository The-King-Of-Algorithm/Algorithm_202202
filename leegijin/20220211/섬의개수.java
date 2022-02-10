package problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 섬의개수 {
	static int r, c;
	static int arr[][];
	static int dr[] = { 1, -1, 0, 0, 1, -1, 1, -1 };
	static int dc[] = { 0, 0, 1, -1, 1, -1, -1, 1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("섬의개수.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			c = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			if (r == 0 && c == 0) {
				break;
			}
			arr = new int[r][c];
			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < c; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// print(arr);
			boolean[][] visit = new boolean[r][c];
			int cnt= 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (!visit[i][j] && arr[i][j]!=0) {
						visit[i][j]=true;
						dfs(i, j, visit);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static void dfs(int row, int col, boolean[][] visit) {
		for (int i = 0; i < 8; i++) {
			int nrow = row + dr[i];
			int ncol = col + dc[i];
			if(nrow>=0 && nrow<arr.length && ncol>=0 && ncol<arr[0].length && !visit[nrow][ncol] && arr[nrow][ncol]!=0) {
				visit[nrow][ncol]=true;
				dfs(nrow,ncol,visit);
			}
		}
	}

	static void print(int[][] arr) {
		for (int[] tmp : arr) {
			for (int t : tmp) {
				System.out.print(t + " ");
			}
			System.out.println();
		}
	}

}
