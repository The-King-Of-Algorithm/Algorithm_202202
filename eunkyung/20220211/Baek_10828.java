package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//스택
public class Baek_10828 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String token = st.nextToken();
			switch (token) {
			case "push":
				int n = Integer.parseInt(st.nextToken());
				stack.push(n);
				break;
			case "pop":
				if (!stack.isEmpty()) {
					System.out.println(stack.pop());
				} else {
					System.out.println(-1);
				}
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if (stack.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case "top":
				if (!stack.isEmpty()) {
					System.out.println(stack.peek());
				} else {
					System.out.println(-1);
				}
				break;
			}

		}

	}

}
