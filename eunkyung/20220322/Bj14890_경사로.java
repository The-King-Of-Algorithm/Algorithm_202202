package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj14890_경사로 {
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < map.length; i++) {
			operation(map[i], L);
		}

		for (int i = 0; i < map.length; i++) {
			int[] arr = new int[N];
			for (int j = 0; j < map.length; j++) {
				arr[j] = map[j][i];
			}
			operation(arr, L);
		}
		System.out.println(cnt);
	}

	private static void operation(int[] arr, int L) {
		boolean[] v = new boolean[arr.length];
		int i = 0;
		int current = arr[0];
		while (++i < arr.length) {
			if (current == arr[i]) continue;
			else if (arr[i] - 1 == current) { // 뒤가 큰경우 앞에꺼 탐색
				for (int j = i - L; j < i; j++) {
					if (j < 0 || v[j] || arr[j] != current) return;
				}
				for (int j = i - L; j < i; j++) {
					v[j] = true;
				}
				current = arr[i];
			} else if (arr[i] + 1 == current) { // 뒤가 작은 경우 뒤에꺼 탐색
				current = arr[i];
				for (int j = i; j < i + L; j++) {
					if (j >= arr.length || v[j] || arr[j] != current) return;
				}
				for (int j = i; j < i + L; j++) {
					v[j] = true;
				}
				i += L - 1;
			} else return;
		}
		cnt++;
	}
}
