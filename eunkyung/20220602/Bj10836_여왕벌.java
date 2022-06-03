package day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj10836_여왕벌 {
	static int M, N;
	static int[] dx = { 0, -1, -1 };
	static int[] dy = { -1, -1, 0 };
	static int[] rdata, cdata;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		rdata = new int[M];
		cdata = new int[M];

		Arrays.fill(rdata, 1);
		Arrays.fill(cdata, 1);

		for (int i = 0; i < N; i++) {
			// 왼쪽열, 왼쪽행 값 더하기
			int cnt = 0;
			int rindex = M - 1;
			int cindex = 1;
			st = new StringTokenizer(bf.readLine());
			while (st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				for (int j = 0; j < n; j++) {
					if (rindex != -1) {
						rdata[rindex--] += cnt;
					} else {
						cdata[cindex++] += cnt;
					}
				}
				cnt++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rdata.length; i++) {
			sb.append(rdata[i] + " ");
			for (int j = 1; j < cdata.length; j++) {
				sb.append(cdata[j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}
}
