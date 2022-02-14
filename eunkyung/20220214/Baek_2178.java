package day07;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

//DFS로 풀어버렸네.. 이건 BFS로 풀어야된대....... 다풀고 발견했다
//다시풀기
//미로탐색
public class Baek_2178 {
	static int res = Integer.MAX_VALUE - 1;
	static int[][] map;
	static Stack<Point> stack = new Stack<Point>();

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/2178.txt"));
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		map = new int[N][M];
		boolean[][] v = new boolean[N][M];

		for (int i = 0; i < map.length; i++) {
			String str = sc.next();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		stack.push(new Point(0, 0));
		v[0][0] = true;

		dfs(0, 0, v, 1);
		System.out.println(res);
	}

	private static void dfs(int r, int c, boolean[][] v, int cnt) {
		if (r == map.length - 1 && c == map[0].length - 1) {
			System.out.println(cnt);
			res = Math.min(res, cnt);
			return;
		}

		while (!stack.isEmpty()) {
			r = stack.peek().x;
			c = stack.peek().y;
			boolean state = false;

			for (int dir = 0; dir < dx.length; dir++) {
				int nr = r + dx[dir];
				int nc = c + dy[dir];
				if (isMap(nr, nc)) {
					if (map[nr][nc] == 1 && !v[nr][nc]) {
						System.out.println("#" + r + " " + c);
						System.out.println(nr + " " + nc);
						stack.push(new Point(nr, nc));
						v[nr][nc] = true;
						state = true;
						dfs(nr, nc, v, cnt + 1);
						break;
					}
				}
			}
			if (!state) {
				System.out.println("pop" + stack.pop());
			}
		}
	}

	private static boolean isMap(int nr, int nc) {
		if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length) {
			return true;
		}
		return false;
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
