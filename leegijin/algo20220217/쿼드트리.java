package algo20220217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리 {
	static int [][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		arr = new int[t][t];
		for (int i = 0; i < t; i++) {
			String s = bf.readLine();
			for(int j= 0; j< t; j++) {
				arr[i][j]=s.charAt(j)-'0';
			}
		}
		quad(0,0,t);
	}
	
	
	private static void quad(int row, int col, int t) {
		if(t==1) {
			System.out.print(arr[row][col]);
			return;
		}
		if(!check(row,col,t)) {
			System.out.print("(");
			quad(row,col,t/2);
			quad(row,col+t/2,t/2);
			quad(row+t/2,col,t/2);
			quad(row+t/2,col+t/2,t/2);
			System.out.print(")");
		}
		else {
			System.out.print(arr[row][col]);
		}
	}

	static boolean check(int row,int col,int t) {
		for(int i = row ; i<row+t; i++) {
			for(int j=col ; j<col+t; j++) {
				if(arr[row][col]!=arr[i][j]) {
					return false;
				}
					
			}
		}
		return true;
	}
	static void print(int arr[][]) {
		for(int tmp[] : arr) {
			for(int t : tmp) {
				System.out.print(t+" ");
			}
			System.out.println();
		}
	}
}
