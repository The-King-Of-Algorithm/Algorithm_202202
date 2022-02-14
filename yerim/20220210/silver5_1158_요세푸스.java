package BAEKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class silver5_1158_요세푸스 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> queue = new LinkedList();
		// 입력
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		// queue가 비었을 때까지 돌기
		while(!queue.isEmpty()) {
			// 숫자 뒤로보냄
			for(int i = 0; i < K-1; i++) {
				queue.offer(queue.poll());
			}
			// 추출
			sb.append(Integer.toString(queue.poll())).append(", ");
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		
		System.out.println(sb);
	}

}
