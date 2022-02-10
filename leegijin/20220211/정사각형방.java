package problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정사각형방 {
	static int dr[] = { 1, 0, -1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static int n;
	static int max;
	static int idx;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("정사각형방.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(bf.readLine());
			int arr[][] = new int[n][n];
			max = -1;
			idx = -1;
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					boolean[][] visit = new boolean [n][n];
					visit[i][j]=true;
					dfs(arr,i,j,1,visit,i,j);
				}
			}
			System.out.println("#" + tc + " " + idx + " " + max);
		}
	}

	static void print(int[][] arr) {
		for (int tmp[] : arr) {
			for (int t : tmp) {
				System.out.print(t + " ");
			}
			System.out.println();
		}
	}

	static void dfs(int[][] arr, int row, int col, int cnt,boolean visit[][],int r , int c) {
		for (int i = 0; i < 4; i++) {
			int nrow = row + dr[i];
			int ncol = col + dc[i];
			if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n&& !visit[nrow][ncol]) {
				if (arr[nrow][ncol] == arr[row][col] + 1 || arr[nrow][ncol] == arr[row][col] - 1) {
					visit[nrow][ncol]=true;
					dfs(arr, nrow, ncol, cnt+1,visit,r,c);
				}
			}
		}
		if(cnt>max) {
			max= cnt;
			idx =arr[r][c];
		}
		else if(cnt==max) {
			idx=Math.min(idx, arr[r][c]);
		}
	}
}
