package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_7964_부먹왕국의차원관문 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 부먹 왕국의 도시 수
			int D = Integer.parseInt(st.nextToken()); // 이동 제한 거리
			int[] city = new int[N+2];
			city[0] = 1;
			city[N+1] = 1;
			int result = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < city.length-1; i++) {
				city[i] = Integer.parseInt(st.nextToken());
			}

			int cnt = 0;
			for (int i = 0; i < city.length; i++) {
				if (city[i] == 0) {
					cnt++;
					continue;
				}
				result += cnt / D;
				cnt = 0;
			}

			System.out.printf("#%d %d\n", tc, result);
		}
	}

}
