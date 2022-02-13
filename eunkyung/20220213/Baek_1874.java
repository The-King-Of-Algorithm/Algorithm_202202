package day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//스택 수열
public class Baek_1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		List<Character> op = new ArrayList<Character>();

		int N = Integer.parseInt(bf.readLine());
		int n = 1;
		for (int i = 0; i < N; i++) {
			int k = Integer.parseInt(bf.readLine());
			while (n <= k) {
				stack.push(n++);
				op.add('+');
			}
			if (stack.peek() == k) {
				stack.pop();
				op.add('-');
			}
		}
		if (!stack.isEmpty()) {
			System.out.println("NO");
		} else {
			for (int i = 0; i < op.size(); i++) {
				System.out.println(op.get(i));
			}
		}
	}
}
