package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_2493 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("B_2493"));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<int[]> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			int top = Integer.parseInt(st.nextToken());
			
			while (!stack.isEmpty()) {
				
				if (stack.peek()[0] < top) {
					stack.pop();
				}
				else if (stack.peek()[0] >= top){
					System.out.print(stack.peek()[1]+1 + " ");
					break;
				}
			}
			
			if (stack.isEmpty()) {
				System.out.print("0 ");
			}
			
			stack.push(new int[] {top,i});
		}
	}
}
