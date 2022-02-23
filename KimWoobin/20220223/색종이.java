package IMTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("색종이.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] cell = new int[20][20];
		
		for (int k = 1; k <= N; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int nr = cell.length-c-1;
			int nc = r;
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for (int i = nr; i > nr-h; i--) {
				for (int j = nc; j < nc+w; j++) {
					cell[i][j] = k;
				}
			}
			
		}
		
		int[] cnt = new int[N+1];
		for (int i = 0; i < cell.length; i++) {
			for (int j = 0; j < cell.length; j++) {
				int n = cell[i][j];
				if (n!=0) {
					cnt[n]+=1;
				}
			}
		}
//		print(cell);
		for (int i = 1; i < cnt.length; i++) {
			System.out.println(cnt[i]);
		}
		
		
	}

	private static void print(int[][] cell) {
		for (int i = 0; i < cell.length; i++) {
			for (int j = 0; j < cell.length; j++) {
				System.out.print(cell[i][j]+" ");
			}System.out.println();
		}
		
	}

}
