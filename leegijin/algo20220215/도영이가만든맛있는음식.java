package algo20220215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 도영이가만든맛있는음식 {
	static int min =Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		int arr [][] = new int [t][2];
		for(int i =0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			arr[i][0]= Integer.parseInt(st.nextToken());
			arr[i][1]= Integer.parseInt(st.nextToken());
		}
		com(arr,0,0,1,0);
		System.out.println(min);
	}

	private static void com(int[][] arr, int idx, int spicy,int sour,int k) {
		if(idx==arr.length && k>=1) {
			min = Math.min(min, Math.abs(spicy-sour));
			return;
		}
		if(idx==arr.length) {
			return;
		}
			
		com(arr,idx+1,spicy+arr[idx][1],sour*arr[idx][0],k+1);
		com(arr,idx+1,spicy,sour,k);
	}
	
}
