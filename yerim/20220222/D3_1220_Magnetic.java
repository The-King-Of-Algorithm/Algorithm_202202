package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D3_1220_Magnetic {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("Magnetic.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int result = 0;
			
			for (int r = 0; r < map.length; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < map[r].length; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int r = 0; r < map.length; r++) {
				ArrayList<Integer> check = new ArrayList<>();
				for (int c = 0; c < map[r].length; c++) {
					if(map[c][r] != 0) {
						check.add(map[c][r]);
					}
				}
				
				for (int i = 1; i < check.size(); i++) {
					if(check.get(i-1) == 1 && check.get(i) == 2) {
						result++;
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, result);
		}
	}
}
