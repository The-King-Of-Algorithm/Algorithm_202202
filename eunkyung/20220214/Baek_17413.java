package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
//단어 뒤집기
public class Baek_17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		Stack<Character> s = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		int i = 0;

		while (i < str.length()) {
			char c = str.charAt(i);
			if (c == '<') {
				sb.append("<");
				char c2;
				++i;
				while (i < str.length() && (c2 = str.charAt(i)) != '>') {
					sb.append(c2);
					++i;
				}
				sb.append(">");
				++i;
			} 
			else {
				s.push(c);
				char c3;
				++i;
				while (i < str.length() && (c3 = str.charAt(i)) != ' ' && (c3 = str.charAt(i)) != '<') {
					s.push(c3);
					++i;
				}
				while (!s.isEmpty()) {
					sb.append(s.pop());
				}
				if (i < str.length() && (c3 = str.charAt(i)) != '<') {
					++i;
					sb.append(" ");
				}
			}
		}
		System.out.println(sb);
	}
}
