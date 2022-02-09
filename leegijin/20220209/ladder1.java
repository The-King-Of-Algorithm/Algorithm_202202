package problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ladder1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("ladder.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for(int tc =1 ; tc<=10; tc++) {
			int t = Integer.parseInt(bf.readLine());
			int row =0;
			int col =0;
			int [][] map = new int[100][100];
			for(int i=0; i<100; i++) {
				StringTokenizer st= new StringTokenizer(bf.readLine());
				for(int j=0; j<100; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]==2) {
						row=i;
						col=j;
					}
				}
			}
			int cnt=0;
			//row!=0
			while(row!=0) {
				if(col+1<100 && map[row][col+1]==1) {
					// 좌우 먼저 검사
					map[row][col]=5;
					col++;
				}
				if(col-1>=0 && map[row][col-1]==1) {
					// 좌우 먼저 검사
					map[row][col]=5;
					col--;
				}
					
				if(map[row-1][col]==1) {
					map[row][col]=5;
					row--;
				}
			}
			//System.out.println(row);
			System.out.println("#"+tc+" "+col);
		}
		
	}
	static void print(int[][] map) {
		for(int [] tmp: map) {
			for(int t: tmp) {
				System.out.print(t+" ");
			}
			System.out.println();
		}
	}
}
