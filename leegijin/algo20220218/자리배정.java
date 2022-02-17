package algo20220218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 자리배정 {
	static int dr[] = { 1, 0, -1, 0 };
	static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(bf.readLine());

		int arr[][] = new int[row][col];
		int num = row * col;
		int r = -1;
		int c = 0;
		int dir = 0;
		int n = 1;
		if (cnt > num) {
			System.out.println(0);
		} else {
			while (true) {

				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if (nr >= 0 && nr < row && nc >= 0 && nc < col && arr[nr][nc] == 0) {
					arr[nr][nc] = n++;
					r = nr;
					c = nc;
				} else {
					dir = (dir + 1) % 4;
				}
				if (arr[r][c] == cnt) {
					System.out.println((c + 1) + " " + (r + 1));
					break;
				}

			}
		}
	}

	static void print(int arr[][]) {
		for (int tmp[] : arr) {
			for (int t : tmp) {
				System.out.print(t + " ");
			}
			System.out.println();
		}
	}
}
