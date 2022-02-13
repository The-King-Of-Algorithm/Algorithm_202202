package day09;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//색종이 만들기
public class Baek_2630 {
	static int cnt_w = 0;
	static int cnt_b = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/day09/2630.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] paper = new int[N][N];

		for (int i = 0; i < paper.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < paper.length; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// print(paper);
		recursive(paper, N);
		System.out.println(cnt_w);
		System.out.println(cnt_b);

	}

	private static void recursive(int[][] paper, int N) {
		if (N == 1) {
			if (paper[0][0] == 0)
				cnt_w++;
			else
				cnt_b++;
			return;
		}

		if (!check(paper)) {
			// print(paper);
			// System.out.println();
			N = N / 2;
			int[][] paper1 = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					paper1[r][c] = paper[r][c];
				}
			}

			int[][] paper2 = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = N; c < paper.length; c++) {
					paper2[r][c - N] = paper[r][c];
				}
			}

			int[][] paper3 = new int[N][N];
			for (int r = N; r < paper.length; r++) {
				for (int c = 0; c < N; c++) {
					paper3[r - N][c] = paper[r][c];
				}
			}

			int[][] paper4 = new int[N][N];
			for (int r = N; r < paper.length; r++) {
				for (int c = N; c < paper.length; c++) {
					paper4[r - N][c - N] = paper[r][c];
				}
			}

			recursive(paper1, N);
			recursive(paper2, N);
			recursive(paper3, N);
			recursive(paper4, N);
		} else {
			if (paper[0][0] == 0)
				cnt_w++;
			else
				cnt_b++;
		}

	}

	private static boolean check(int[][] paper) {
		int color = paper[0][0];
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper.length; j++) {
				if (paper[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}

	private static void print(int[][] paper) {
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper.length; j++) {
				System.out.print(paper[i][j] + " ");
			}
			System.out.println();
		}
	}

}
