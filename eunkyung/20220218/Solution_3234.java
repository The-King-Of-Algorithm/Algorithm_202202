package Solution2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3234 {
//준환이의 양팔저울
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			cnt = 0;

			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			permutation(arr, new int[N], new boolean[N], 0);
			System.out.println("#" + tc + " " + cnt);
		}

	}

	private static void permutation(int[] arr, int[] sel, boolean[] v, int k) {
		if (k == sel.length) {
			recursive(sel, 0, 0, 0);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[k] = arr[i];
				permutation(arr, sel, v, k + 1);
				v[i] = false;
			}
		}
	}

	private static void recursive(int[] sel, int leftsum, int rightsum, int idx) {
		if (rightsum > leftsum) {
			return;
		}
		if (idx == sel.length) {
			cnt++;
			return;
		}

		recursive(sel, leftsum + sel[idx], rightsum, idx + 1);
		recursive(sel, leftsum, rightsum + sel[idx], idx + 1);
	}
}
