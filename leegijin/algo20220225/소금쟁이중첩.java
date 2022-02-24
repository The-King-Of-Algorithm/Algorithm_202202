package algo20220225;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 소금쟁이중첩 {
	static int dr[] = { 0, 1, 0 }; // 1 하 //2우
	static int dc[] = { 0, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("소금쟁이.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int arr[][] = new int[m][3];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(bf.readLine());
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				arr[i][0] = row;
				arr[i][1] = col;
				arr[i][2] = dir;

			}
			for (int cnt = 3; cnt > 0; cnt--) {
				for (int i = 0; i < m; i++) {
					int cr=arr[i][0];
					int cc=arr[i][0];
					int dir=arr[i][0];
					
				}
			}
			for (int[] tmp : arr) {
				for (int p : tmp) {
					System.out.print(p + " ");
				}
				System.out.println();
			}

		}
	}
}
