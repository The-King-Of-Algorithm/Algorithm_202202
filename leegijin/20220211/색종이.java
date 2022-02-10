package problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("색종이.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int arr[][] = new int[100][100];
		int n = Integer.parseInt(bf.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			for(int r=h ;r <h+10; r++) {
				for(int c=w; c<w+10; c++) {
					arr[r][c]=1;
				}
			}
		}
		int cnt=0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[i][j]==1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	static void print(int arr[][]) {
		for(int tmp[] :arr) {
			for(int t: tmp) {
				System.out.print(t+" ");
			}
			System.out.println();
		}
	}
}
