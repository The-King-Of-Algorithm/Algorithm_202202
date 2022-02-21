package improblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부먹왕국 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			int[] arr = new int[n];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			int count = 0;
			int ans = 0;
			for (int i = 0; i < n; i++) {
				count++;
				if (arr[i] == 1 || count >= d) {
					if (count >= d && arr[i] != 1) {
						ans = ans+ 1;
					}
					count = 0;
					continue;
				}
			}
			System.out.println(ans);
		}
	}
}