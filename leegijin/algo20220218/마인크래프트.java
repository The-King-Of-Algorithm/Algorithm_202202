package algo20220218;
import java.io.*;
import java.util.*;

public class 마인크래프트{
	static int n;
	static int m;
	static int B;
	static int min_time = Integer.MAX_VALUE;
	static int max_height = Integer.MIN_VALUE;
	static int max = 0;
	static int min = 500;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0 ; j < m ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] < min) min = arr[i][j];
				if(arr[i][j] > max) max = arr[i][j];
			}
		}
		
		for(int i = min ; i <= max ; i++) {
			int time = 0;
			int block = B;
			
			for(int j = 0 ; j < n ; j++) {
				for(int k = 0 ; k < m ; k++) {
					if(arr[j][k] < i) {
						time += i-arr[j][k];
						block -= i-arr[j][k];
					}
					if(arr[j][k] > i) {
						time += (arr[j][k]-i)*2;
						block += arr[j][k]-i;
					}
				}
			}
			
			if(block < 0) continue;
			
			if(time <= min_time) {
				min_time = time;
				max_height = i;
			}
		}
		
		System.out.println(min_time + " " + max_height);
	}
}