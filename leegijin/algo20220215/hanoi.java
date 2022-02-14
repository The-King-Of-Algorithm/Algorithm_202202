package algo20220215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class hanoi {
	static int cnt=0;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(bf.readLine());
		move(t,	1,2,3);
		System.out.println(cnt);
		System.out.println(sb);
	}

	public static void move(int n , int from ,int temp, int to) {
		if(n==0) {
			return;
		}
		move(n-1,from,to,temp);
		cnt++;
		String s =Integer.toString(from)+" "+Integer.toString(to);
		sb.append(s);
		sb.append("\n");
		move(n-1,temp,from,to);
	}
}
