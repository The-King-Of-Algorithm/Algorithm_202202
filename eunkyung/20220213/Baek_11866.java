package day09;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//요세푸스
public class Baek_11866 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		while (!queue.isEmpty()) {
			for (int i = 1; i < K; i++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll() + ", ");
		}

		sb.setLength(sb.length() - 2);
		sb.append(">");
		
		System.out.println(sb);
	}
}
