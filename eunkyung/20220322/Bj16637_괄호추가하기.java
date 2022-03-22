package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Bj16637_괄호추가하기 {
	static ArrayList<Character> arr = new ArrayList<Character>();
	static int N, max = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		String str = bf.readLine();
		for (int i = 0; i < str.length(); i++) {
			arr.add(str.charAt(i));
		}
		ArrayList<int[]> list = new ArrayList<int[]>();
		int n = N;
		while (n - 3 >= 0) {
			list.add(new int[] { n, n - 3 });
			n -= 2;
		}

		powerset(list, new boolean[list.size()], new boolean[N], 0, 0);

		System.out.println(max);

	}

	private static void powerset(ArrayList<int[]> list, boolean[] sel, boolean[] v, int idx, int k) {
		if (idx == sel.length) {
			operation(sel, list);
			return;
		}
		boolean state = true;
		for (int i = list.get(idx)[0]; i >= list.get(idx)[1]; i--) {
			if (i >= N) continue;
			if (v[i]) {
				state = false;
				break;
			}
		}

		if (state) {
			for (int i = list.get(idx)[0]; i >= list.get(idx)[1]; i--) {
				if (i >= N)continue;
				v[i] = true;
			}
			sel[idx] = true;
			powerset(list, sel, v, idx + 1, k + 1);
			
			for (int i = list.get(idx)[0]; i >= list.get(idx)[1]; i--) {
				if (i >= N)continue;
				v[i] = false;
			}
			sel[idx] = false;
			powerset(list, sel, v, idx + 1, k);

		} 
			else {
			sel[idx] = false;
			powerset(list, sel, v, idx + 1, k + 1);
		}
	}
	
	private static void operation(boolean[] sel, ArrayList<int[]> list) {
		ArrayList<Character> tmp = new ArrayList<Character>();
		for (int i = 0; i < arr.size(); i++) {
			tmp.add(arr.get(i));
		}
		for (int i = 0; i < sel.length; i++) {
			if (sel[i]) {
				if (list.get(i)[0] >= N) tmp.add(')');
				else tmp.add(list.get(i)[0], ')');
				tmp.add(list.get(i)[1], '(');
			}
		}
		//System.out.println(tmp);
		sum(tmp);
	}

	private static void sum(ArrayList<Character> tmp) {
		Stack<Integer> num = new Stack<Integer>();
		Stack<Character> C = new Stack<Character>();
		int i = 0;
		while (true) {
			char c = tmp.get(i);
			if (c != '+' && c != '*' && c != '-' && c != '(' && c != ')') {
				num.add(c - '0');
			} else {
				if (c != '(') {
					if (num.size() > 1) {
						num.add(solving(C.pop(), num.pop(), num.pop()));
					}
					C.add(c);
				} else {
					int n1 = tmp.get(++i) - '0';
					char cc = tmp.get(++i);
					int n2 = tmp.get(++i) - '0';
					if (num.isEmpty())
						num.add(solving(cc, n2, n1));
					else
						num.add(solving(C.pop(), solving(cc, n2, n1), num.pop()));
					++i;
				}
			}
			if (++i == tmp.size()) {
				if (num.size() == 1) {
					max = Math.max(max, num.peek());
				} else {
					max = Math.max(max, solving(C.pop(), num.pop(), num.pop()));
				}
				break;
			}
		}
	}

	/*
	 * 17 2*6+9-8*6+1*2*9-3
	 */
	private static int solving(char c, int second, int first) {
		if (c == '+')
			return first + second;
		else if (c == '*')
			return first * second;
		else
			return first - second;
	}
}
