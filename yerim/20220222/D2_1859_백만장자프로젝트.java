package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1859_백만장자프로젝트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("백만장자프로젝트.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			long[] m = new long[N];
			long result = 0;
			st  = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				m[i] = (long)Integer.parseInt(st.nextToken());
			}
			

			int i = m.length-1;
			while(i>0) {
				int cnt = 0;
				int p = i;
				for (int j = p-1; j >= 0; j--) {
					if(m[p] > m[j]) {
						cnt++;
						result -= m[j];
						i = j;
					} else if(m[p] <= m[j]){
						i = j;
						break;
					}
				}
				result += m[p] * cnt;
			}
			
			System.out.printf("#%d %d\n", tc, result);
		}

	}

}
