package algo20220217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사탕게임 {
	static char arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		arr = new char[t][t];
		for (int i = 0; i < t; i++) {
			String s = bf.readLine();
			for(int j=0; j<t; j++) {
				arr[i][j]=s.charAt(j);
			}
		} 
		char tmp[][] = new char[t][t];
		changenew(tmp);
		int ans =0;
		for(int i =0; i<t; i++) {
			for(int j=0; j<t; j++) { // 0,0    t-1,t-1
				 // 밑 오른쪽 만 바꾸고 수행해보기
				changeright(i,j,tmp);
				ans=Math.max(ans,count(tmp));
				changenew(tmp);
				changeunder(i,j,tmp);
				ans=Math.max(ans,count(tmp));
				changenew(tmp);
			}
		}
		System.out.println(ans);
	}
	private static void changeunder(int row, int col, char[][] tmp) {
		// TODO Auto-generated method stub
		int nrow = row+1;
		int ncol = col;
		if(nrow>=0 && nrow<tmp.length) {
			char t = tmp[row][col];
			tmp[row][col]=tmp[nrow][ncol];
			tmp[nrow][ncol]=t;
		}
	}
	private static void changenew(char[][] tmp) {
		// TODO Auto-generated method stub
		for(int i =0; i<tmp.length ; i++) {
			for(int j=0; j<tmp.length; j++) {
				tmp[i][j]=arr[i][j];
			}
		}
	}
	private static void changeright(int row, int col, char[][] tmp) {
		// TODO Auto-generated method stub
		int nrow = row;
		int ncol = col+1;
		if(ncol>=0 && ncol<tmp.length) {
			char t = tmp[row][col];
			tmp[row][col]=tmp[nrow][ncol];
			tmp[nrow][ncol]=t;
		}
		
	}
	static void print(char[][] arr) {
		for(char [] tmp: arr) {
			for(char t: tmp) {
				System.out.print(t+" ");
			}
			System.out.println();
		}
	}
	
	
	static int count(char[][] arr) {
		int max = 0;
		for(int i =0; i<arr.length; i++) {
			int count =1;
			for(int j=0; j<arr.length-1 ; j++) {
				if(arr[i][j]==arr[i][j+1]) {
					count++;
				}
				else {
					count=1;
				}
				max=Math.max(max,count);
			}
		}
		for(int i =0; i<arr.length; i++) {
			int count =1;
			for(int j=0; j<arr.length-1 ; j++) {
				if(arr[j][i]==arr[j+1][i]) {
					count++;
				}
				else {
					count=1;
				}
				max=Math.max(max,count);
			}
		}
		return max;
	}
}
