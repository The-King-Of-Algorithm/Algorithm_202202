package day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//괄호
public class Baek_9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			boolean state = true;
			stack.clear();
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if (c == '(') {
					stack.push(c);
					//System.out.println(stack);
				} else {
					if (stack.isEmpty()) {
						state = false;
						break;
					} else {
						if (stack.peek() == '(') {
							stack.pop();
							//System.out.println(stack);
						}
					}
				}
			}
			if (state && stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}
}
