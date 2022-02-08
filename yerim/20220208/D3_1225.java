package edu.ssafy.chap04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D3_1225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		

		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			int t = sc.nextInt();
			boolean b = true;
			Queue<Integer> que = new LinkedList<Integer>();
			
			// 입력
			for(int i = 0; i < 8; i++) {
				que.offer(sc.nextInt());
//				System.out.println(que.peek());
//				que.poll();
			}			
			
			// 사이클
			while(b) {
				// 사이클
				for(int i = 1; i < 6; i++) {
					int temp = que.poll() - i;
					// 감소한 값이 0보다 작거나 같으면 break;
					if(temp <= 0) {
						que.offer(0);
						b = false;
						break;
					}
					que.offer(temp);
				}
			}
			
			System.out.printf("#%d ", tc);
			for(int i = 0; i < 8; i++) {
				System.out.printf("%d ", que.poll());
			}
			System.out.println();
			
			
		}
		
	}

}
