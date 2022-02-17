package algo20220218;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 요리사 {
	static int n;
	static int map[][];
	static int asel[];
	static int bsel[];
	static int min;
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("요리사.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(bf.readLine());
			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			asel = new int[n/2];  //먼저 조합 n/2개 뽑은뒤
			bsel = new int[n/2];  
			min =987654321;
			//print(map);
			combination(1, 0);
			System.out.println("#"+tc+" "+min);
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

	static void combination(int idx, int k) {
		if (k == asel.length) {
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				int flag = 0;
				for (int j = 0; j < asel.length; j++) {
					if (i == asel[j]) {
						flag = 1;
						break;
					}
				}
				if (flag == 0) {
					bsel[cnt] = i;
					cnt++;
				}
			}
			int aans = 0;
			for(int i=0; i<asel.length; i++) {
				for(int j=0; j<asel.length; j++) {
					if(i==j) {
						continue;
					}
					aans+=map[asel[i]-1][asel[j]-1];
				}
			}
			int bans = 0;
			for(int i=0; i<bsel.length; i++) {
				for(int j=0; j<bsel.length; j++) {
					if(i==j) {
						continue;
					}
					bans+=map[bsel[i]-1][bsel[j]-1];
				}
			}
		//	System.out.println(Arrays.toString(asel));

		//	System.out.println(Arrays.toString(bsel));

			min=Math.min(min, Math.abs(aans-bans));
			return;
		}
		for (int i = idx; i <= n; i++) {
			asel[k] = i;
			combination(i+1, k + 1);
		}
	}
}
