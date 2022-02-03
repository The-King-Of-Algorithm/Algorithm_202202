package pratice2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 농작물수확하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= t; i++) {
			int n = Integer.parseInt(bf.readLine());
			int arr[][] = new int[n][n];
			for (int j = 0; j < n; j++) {
				String s = bf.readLine();
				for (int k = 0; k < n; k++) {
					arr[j][k] = s.charAt(k) - '0';
				}
			}
			int mid = n / 2;
			int sum=0;
			for (int j = 1; j < (n / 2) + 1; j++) {
				int row = mid-j;
				int col = mid;
				// 밑 오 대각선 이동
				for (int k = 0; k < j; k++) {	
					sum = sum+arr[row+(k+1)][col+(k+1)];
				}
				row =mid;
				col =mid+j;
				// 밑 왼 대각선이동
				for (int k = 0; k < j; k++) {
					sum = sum+arr[row+(k+1)][col-(k+1)];
				}
				row= mid+j;
				col= mid;
				// 위 왼 대각선
				for (int k = 0; k < j; k++) {
					sum = sum+arr[row-(k+1)][col-(k+1)];
				}
				row=mid;
				col=mid-j;
				// 위 오 대각선
				for (int k = 0; k < j; k++) {
					sum = sum+arr[row-(k+1)][col+(k+1)];
				}
			}
			System.out.println("#"+i+" "+(sum+arr[mid][mid]));
		}
	}
}
