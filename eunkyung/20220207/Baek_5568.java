package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//카드 뽑기
public class Baek_5568 {
	public static List<String> list = new ArrayList<String>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int k = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		int[] sel = new int[k];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		select(arr, sel, new boolean[N], 0);
		System.out.println(list.size());
	}

	private static void select(int[] arr, int[] sel, boolean[] v, int k) {
		if(k==sel.length) {
			String str = "";
			for (int i = 0; i < sel.length; i++) {
				str += Integer.toString(sel[i]);
			}
			if(!list.contains(str)) {
				list.add(str);
			}
			return;
		}
		for (int n = 0; n < arr.length; n++) {
			if (v[n] != true) {
				v[n] = true;
				sel[k] = arr[n];
				select(arr, sel, v, k + 1);
				v[n] = false;
			}
		}
	}
}
