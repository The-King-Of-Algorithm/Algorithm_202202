package IMTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱난쟁이 {
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("일곱난쟁이.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		com(0,0,new int[7]);

	}
	private static void com(int idx, int k,int[] sel) {
		if (k==sel.length) {
			if (cal(sel) == 100) {
				Arrays.sort(sel);
				for (int i = 0; i < sel.length; i++) {
					System.out.println(sel[i]);
				}return;
			}
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			com(i+1, k+1, sel);
		}
	}
	private static int cal(int[] sel) {
		int sum=0;
		for (int i = 0; i < sel.length; i++) {
			sum+=sel[i];
		}
		return sum;
		
	}

}
