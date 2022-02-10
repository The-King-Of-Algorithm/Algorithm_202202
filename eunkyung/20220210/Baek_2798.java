package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//카드뽑기
public class Baek_2798 {
	static int N, M;
	static int[] card, sel;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		card = new int[N];
		sel = new int[3];

		st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < card.length; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		combination(0, 0, 0);
		System.out.println(max);
	}

	private static void combination(int start, int k, int sum) {
		if (sum > M)
			return;
		if (k == sel.length) {
			max = Math.max(max, sum);
			return;
		}
		for (int i = start; i < card.length; i++) {
			sel[k] = card[i];
			combination(i + 1, k + 1, sum + card[i]);
		}

	}
}
