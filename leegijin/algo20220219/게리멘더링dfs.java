package algo20220219;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게리멘더링dfs {
	static int n;
	static ArrayList<Integer>[] edge;
	static int person[];
	static int ans;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("개리멘더링.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		person = new int[n + 1];
		edge = new ArrayList[n + 1];
		ans = 987654321;
		for (int i = 1; i <= n; i++) {
			edge[i] = new ArrayList<>();
		}
		for (int i = 1; i <= n; i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());
			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				edge[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		powerset(new boolean[n], 0, 0);
		if (ans == 987654321) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	private static void powerset(boolean[] sel, int idx, int k) {

		if (idx == sel.length) {
			if (k >= 1 && k < sel.length) {

				ArrayList<Integer> al = new ArrayList<>();
				ArrayList<Integer> bl = new ArrayList<>();
				for (int i = 0; i < sel.length; i++) {
					if (sel[i]) {
						al.add(i + 1);
					} else {
						bl.add(i + 1);
					}
				}
				boolean[] visit = new boolean[n + 1];
				visit[al.get(0)] = true;
				dfs(al.get(0), visit, sel, 0);
				visit[bl.get(0)]= true;
				dfs(bl.get(0),visit,sel,1);
				for (int i = 1; i <= n; i++) {
					if (!visit[i]) {
						return;
					}
				}
				// 인구수계산
				int asum = 0;
				for (int i = 0; i < al.size(); i++) {
					asum += person[al.get(i)];
				}
				int bsum = 0;
				for (int i = 0; i < bl.size(); i++) {
					bsum += person[bl.get(i)];
				}
				ans = Math.min(ans, Math.abs(asum - bsum));

			}
			return;
		}
		sel[idx] = true;
		powerset(sel, idx + 1, k + 1);
		sel[idx] = false;
		powerset(sel, idx + 1, k);
	}

	private static void dfs(int st, boolean[] visit, boolean[] sel, int flag) {
		if (flag == 0) {
			for (int i = 0; i < edge[st].size(); i++) {
				if (visit[edge[st].get(i)]) {
					continue;
				}
				if (!sel[edge[st].get(i) - 1]) {
					continue;
				}
				visit[edge[st].get(i)] = true;
				dfs(edge[st].get(i), visit, sel, 0);
			}
		}
		if (flag==1) {
			for (int i = 0; i < edge[st].size(); i++) {
				if (visit[edge[st].get(i)]) {
					continue;
				}
				if (sel[edge[st].get(i) - 1]) {
					continue;
				}
				visit[edge[st].get(i)] = true;
				dfs(edge[st].get(i), visit, sel, 1);
			}
		}
	}

}
