package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("B_1966.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			Queue<int[]> q = new LinkedList<int[]>();
			for (int i = 0; i < N; i++) {
				q.add(new int[]{i,Integer.parseInt(st.nextToken())});
			}
			
			int cnt = 0;
			while (true) {
				int max = 0;
				int ans = 0;
				
				for (int i = 0; i < q.size(); i++) {
					int[] temp = q.poll();
					if (temp[1] > max) {
						max = temp[1];
						ans = temp[0];
					}
					q.offer(temp);
				}
				
				for (int i = 0; i < q.size(); i++) {
					int[] temp = q.poll();
					if (temp[1] != max) {
						q.offer(temp);
					}
				}
				cnt++;
				
				if (ans == M) {
					break;
				}
			}
			System.out.println(cnt);
		}
		
	}

}
