package algo20220216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실배정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		Integer arr[][] = new Integer[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Comparator<Integer[]> com = new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				}
				return o1[1] - o2[1];
			}
		};
		Arrays.sort(arr, com);
		print(arr);
		int endtime = arr[0][1];
		int cnt = 1;
		for (int i = 1; i < n; i++) {
			if (endtime <= arr[i][0]) {
				cnt++;
				endtime = arr[i][1];
			}
		}
		System.out.println(cnt);
	}

	static void print(Integer[][] arr) {
		for (Integer[] tmp : arr) {
			for (int t : tmp) {
				System.out.print(t + " ");
			}
			System.out.println();
		}
	}
}
