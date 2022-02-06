package hw_20220204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//농작물 수확하기
public class Solution_2805 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int test_case =1;test_case<=T;test_case++) {
			int N = Integer.parseInt(bf.readLine());
			int sum=0;
			int [][] map = new int[N][N];
			int length = (N-1)/2;

			for(int i = 0;i < N;i++) {
				String str = bf.readLine();
				for(int j = 0;j < str.length();j++) {
					map[i][j] =str.charAt(j)-'0';
				}
			}
			
			for(int i = 0; i <= (N-1)/2; i++) {
					for(int k =length;k<N-length;k++) {
						sum += map[i][k];
					}
					if(length > 0) length--;
				}
			
			for (int j = (N-1)/2 + 1; j < N; j++) {
				for(int k =length+1;k<N-length-1;k++) {
					sum += map[j][k];
				}
				length++;
			}
			
			System.out.println("#"+test_case+" "+sum);
		}
	}
}