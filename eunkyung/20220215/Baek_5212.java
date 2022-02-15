package hw_20220215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//지구온난화
public class Baek_5212 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		List<int[]> list = new ArrayList<int[]>();
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];

		for (int i = 0; i < map.length; i++) {
			String str = bf.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int cnt = 0;
				if (map[i][j] == 'X') {
					for (int d = 0; d < dx.length; d++) {
						int nr = i + dx[d];
						int nc = j + dy[d];
						if (isMap(nr, nc)) {
							if (map[nr][nc] == '.') {
								cnt++;
							}
						} else {
							cnt++;
						}
					}
					if (cnt >= 3) {
						list.add(new int[] { i, j });
					}
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			map[list.get(i)[0]][list.get(i)[1]] = '.';
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 'X') {
					list1.add(i);
					list2.add(j);
				}
			}
		}
		
		Collections.sort(list1);
		Collections.sort(list2);
		

		for (int i = list1.get(0); i <= list1.get(list1.size() - 1); i++) {
			for (int j = list2.get(0); j <= list2.get(list2.size() - 1); j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

	private static boolean isMap(int nr, int nc) {
		if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
			return true;
		}
		return false;
	}

}
