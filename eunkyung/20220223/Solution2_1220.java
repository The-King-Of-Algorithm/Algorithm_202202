package day06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2_1220 {
//마그네틱
	static int[][] map;
	static int N, d, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/다시풀어볼문제/Magnetic.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(bf.readLine());
			map = new int[N][N];
			cnt = 0;
			for (int i = 0; i < map.length; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int j = 0; j < map.length; j++) {
				List<Integer> list = new ArrayList<Integer>();
				for (int i = 0; i < map.length; i++) {
					if (map[i][j] != 0) {
						list.add(map[i][j]);
					}
				}
				//System.out.println(list);
				int i = 0;
				while (i + 1 < list.size()) {
					if (list.get(i) == 1 && list.get(i + 1) == 2) {
						cnt++;
						i = i + 2;
					} else {
						i++;
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);

		}
	}
}
