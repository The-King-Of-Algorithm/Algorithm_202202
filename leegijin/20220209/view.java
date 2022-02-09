package pratice2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class view {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("view.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1; tc<=10; tc++) {
			int n = Integer.parseInt(bf.readLine());
			int arr[] = new int [n];
			StringTokenizer st =new StringTokenizer(bf.readLine());
			for(int i=0; i<n; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			int total=0;
			for(int i=0 ; i<n ; i++) {
				int cnt =Integer.MAX_VALUE;
				int col = i;
				if(col-2<0) {  // 0 1
					for(int j= 0; j<=1; j++) {
						if(j==col) {
							continue;
						}
						if(arr[col]-arr[j]<0) {
							cnt=0;
							break;
						}
						cnt=Math.min(cnt,arr[col]-arr[j]);
					}
				}
				
				//col = 0 , 1 , 97 ,98 따로 검사
				if(col-2>=0 && col+2<n) {
					for(int j= col-2; j<=col+2; j++) {
						if(j==col) {
							continue;
						}
						if(arr[col]-arr[j]<0) {
							cnt=0;
							break;
						}
						cnt=Math.min(cnt,arr[col]-arr[j]);
					}
				}
				
				if(col+2>=n) { // 97 98
					for(int j= 97; j<=98; j++) {
						if(j==col) {
							continue;
						}
						if(arr[col]-arr[j]<0) {
							cnt=0;
							break;
						}
						cnt=Math.min(cnt,arr[col]-arr[j]);
					}
				}
				total+=cnt;
			}
			System.out.println("#"+tc+" "+total);
		}
		
	}
}
