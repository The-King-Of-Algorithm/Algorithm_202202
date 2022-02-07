package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


/*
 * 해결못해서 구글에 쳐보고 코드를 이해하면서 stack 공부하였습니다...
 */

public class gold5_2493 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> top = new Stack<>();  // Stack에 int형 배열 저장 가능..........!!!!!!!!!!

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			int cur = Integer.parseInt(st.nextToken());

			// 스택이 비어있지 않는 동안 진행
			while(!top.isEmpty()) {
				// 이전 탑의 높이가 현재 높이보다 클 때 -> 이전 탑의 높이 출력
				if(top.peek()[1] >= cur) {
					System.out.print(top.peek()[0] + " ");
					break;
				}
				top.pop();
			}
			// 스택이 비어있으면 0 출력
			if(top.isEmpty()) {
				System.out.print("0 ");
			}
			top.push(new int[] {i, cur});
		}
	}

//	private static void 

}
