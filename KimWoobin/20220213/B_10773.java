package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("B_10773.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			//인자가 0이면 pop, 0이 아니면 push
			if (num != 0) {
				stack.push(num);
			}else {
				stack.pop();
			}
			//System.out.println(stack);
		}
		
		//스택 값 출력
		int sum = 0;
		
		for (Integer integer : stack) {
			sum += integer;
		}
		System.out.println(sum);
		
	}

}
