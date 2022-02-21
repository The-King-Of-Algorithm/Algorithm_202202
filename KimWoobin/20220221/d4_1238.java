package SWExpert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class d4_1238 {
	static int N;
	static int start;
	static boolean[] v;
	static int[][] cell;
	static int max,ans;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("d4_1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			ArrayList<int[]> list = new ArrayList<int[]>();		
			v = new boolean[101];
			max = 0;
			cnt=0;
			ans=0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) {
				list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
//			for (int[] is : list) {
//				System.out.println(Arrays.toString(is));
//			}
			bfs(list, start);
			System.out.printf("#%d %d\n",tc,ans);
		}
		
		
	}
	
	private static void bfs(ArrayList<int[]> list, int start) {
		Queue<int[]> q = new LinkedList<int[]>();
		ArrayList<int[]> tmp = new ArrayList<int[]>();
		q.add(new int[] {0,start,0});
		v[start] = true;
		
		while (!q.isEmpty()) {
			cnt++;
			int size = q.size();
			for (int k = 0; k < size; k++) {
				int[] p = q.poll();
				tmp.add(p);
				for (int i = 0; i < list.size(); i++) {
					if (p[1] == list.get(i)[0] && !v[list.get(i)[1]]) {
						v[list.get(i)[1]] = true;
						q.add(new int[] {list.get(i)[0], list.get(i)[1],cnt});
						max = Math.max(max, cnt);
//						if (cnt==3) {
//							max = Math.max(max, list.get(i)[1]);
//						}
					}
				}
			}
		}
		
		for (int i = 0; i < tmp.size(); i++) {
			if (tmp.get(i)[2] == max) {
				ans = Math.max(ans, tmp.get(i)[1]);
			}
		}
		
//		for (int[] is : tmp) {
//			System.out.println(Arrays.toString(is));
//		}
		
	}

	

}
