package pratice2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비밀이메일 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int n = s.length();
		int max= 1;
		for(int i =2; i< n; i++) {
			if(n%i==0) {
				int c = n/i;
				if(i<=c) {
					max=Math.max(max, i);
				}
			}
		}
		int row = max;
		int col = n/max;
		int cnt=0;
		char arr[][] = new char [row][col];
		for(int i=0; i<col; i++) {
			for(int j=0; j<row ; j++) {
				arr[j][i]=s.charAt(cnt);
				cnt++;
			}
		}
		
		for(char[] t: arr) {
			for(char t1: t) {
				System.out.print(t1);
			}
		}
	}
}
