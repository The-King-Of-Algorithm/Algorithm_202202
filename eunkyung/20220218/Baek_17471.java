package Solution2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//게리맨더링
public class Baek_17471 {
	static class Edge {
		int n; //번호
		int np; //인구수
		List<Integer> edge;

		public Edge(int n, int np) {
			this.n = n;
			this.np = np;
			this.edge = new ArrayList<Integer>();
		}

		@Override
		public String toString() {
			return "Edge [n=" + n + ", np=" + np + " edge=" + edge + "]";
		}
	}

	static int min = 987654321;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		List<Edge> list = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(bf.readLine());

		list.add(null);
		for (int i = 1; i <= N; i++) {
			list.add(new Edge(i, Integer.parseInt(st.nextToken())));
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			int k = Integer.parseInt(st.nextToken());

			for (int j = 0; j < k; j++) {
				int num = Integer.parseInt(st.nextToken());
				list.get(i).edge.add(num);
			}
		}
		powerset(list, new boolean[N + 1], 1, 0);
		if (min != 987654321) {
			System.out.println(min);
		} else {
			System.out.println(-1);
		}
	}

	private static void powerset(List<Edge> list, boolean[] v, int idx, int k) {
		if (idx == list.size()) {
			if (k != 0 && k != list.size() - 1) {
				List<Edge> A = new ArrayList<>();
				List<Edge> B = new ArrayList<>();
				for (int i = 1; i < v.length; i++) {
					if (v[i]) {
						A.add(list.get(i));
					} else {
						B.add(list.get(i));
					}
				}
				if(check(A) && check(B)) {
					sum(A, B);
				}
			}

			return;
		}

		v[idx] = true;
		powerset(list, v, idx + 1, k + 1);
		v[idx] = false;
		powerset(list, v, idx + 1, k);

	}

	private static void sum(List<Edge> A, List<Edge> B) {
		int sumA = 0;
		int sumB = 0;
		for (int i = 0; i < A.size(); i++) {
			sumA += A.get(i).np;
		}
		for (int i = 0; i < B.size(); i++) {
			sumB += B.get(i).np;
		}
		min = Math.min(min, Math.abs(sumA - sumB));
	}

	private static boolean check(List<Edge> E) {
		Queue<Edge> q = new LinkedList<Edge>();
		boolean[] v = new boolean[E.size()];
		q.offer(E.get(0));
		v[0] = true;
		while (!q.isEmpty()) {
			Edge e = q.poll();
			for (int edge = 0; edge < e.edge.size(); edge++) {
				for (int i = 0; i < E.size(); i++) {
					if (e.edge.get(edge) == E.get(i).n) {
						if (!v[i]) {
							v[i] = true;
							q.offer(E.get(i));
						}
					}
				}
			}
		}

		for (int i = 1; i < v.length; i++) {
			if (!v[i])
				return false;
		}
		return true;
	}
}
