
package edu.ssafy.chap04;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class D3_1228 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			LinkedList<Integer> list = new LinkedList<Integer>();
			
			// 암호문 입력
			for(int i = 0; i < N; i++) {
				list.add(sc.nextInt());
				//System.out.println(list.get(i));
			}
			
			int C = sc.nextInt();
			// 명령어 입력
			for(int i = 0; i < C; i++) {
				String s = sc.next(); // | 입력
				int x = sc.nextInt(); // x위치 바로 다음에
				int y = sc.nextInt(); // y개 숫자 삽입
				
				for(int j = 0; j < y; j++) {
					list.add(x+j, sc.nextInt());
				}
			}
			
			System.out.print("#" + tc + " ");
			for(int i = 0; i < 10; i++) {
				System.out.printf("%d ", list.get(i));;
			}
			System.out.println();
		}
	}

}
