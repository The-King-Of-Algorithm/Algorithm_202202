package hw_20220210;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//요세푸스
public class Baek_1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();

		sb.append("<");
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}

		while (!q.isEmpty()) {
			for (int i = 1; i < K; i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll() + ", ");
		}
		sb.setLength(sb.length() - 2);
		System.out.println(sb.append(">"));

	}
}
