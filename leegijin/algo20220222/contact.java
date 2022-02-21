package problem_dfsbfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class contact {
	static int ans;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("contact.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			ans = -1;
			st = new StringTokenizer(bf.readLine());
			ArrayList<int[]> al = new ArrayList<>();
			for (int i = 0; i < n / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				al.add(new int[] { from, to });
			}

			bfs(start, al);
			System.out.println("#"+tc+" "+ans);
		}
	}

	static void bfs(int start, ArrayList<int[]> al) {
		Queue<int[]> que = new LinkedList<>();
		ArrayList<int[]> t = new ArrayList<>();
		boolean[] visit = new boolean[101];
		que.add(new int[] { 0, start, 0 });  
		int cnt = 0;
		while (!que.isEmpty()) {
			int size = que.size();
			cnt++;
			for (int k = 0; k < size; k++) {
				int[] current = que.poll();
				t.add(current);
				for (int i = 0; i < al.size(); i++) {
					if (current[1] == al.get(i)[0] && !visit[al.get(i)[1]]) {
						visit[al.get(i)[1]] = true;
						que.add(new int[] { al.get(i)[0], al.get(i)[1], cnt });
					}
				}
			}
		}
		
		for (int[] tmp : t) {
			if (tmp[2] == cnt - 1) {
				ans = Math.max(tmp[1], ans);
			}
		}
		
	}
}
