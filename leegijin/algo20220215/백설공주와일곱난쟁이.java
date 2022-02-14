package algo20220215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 백설공주와일곱난쟁이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[9];
		int ans[] = new int[7];
		for (int i = 0; i < 9; i++) {
			int t = Integer.parseInt(bf.readLine());
			arr[i] = t;
		}

		com(arr, ans, 0, 0, 0);
	}

	private static void com(int[] arr, int[] ans, int current, int idx, int start) {
		//System.out.println(idx+" "+current);
		if(idx == 7 && current == 100) {
			for (int i = 0; i < ans.length; i++) {
				System.out.println(ans[i]);
			}
			return;
		}
		
		if (idx == 7) {
			return;
		} 
		

		for (int i = start; i < arr.length; i++) {
			ans[idx] = arr[i];
			com(arr, ans, current + arr[i], idx + 1, i + 1);
		}
	}

}
