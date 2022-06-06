package day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1085_직사각형에서탈출 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int min = Integer.MAX_VALUE;

		min = Math.min(min, Math.abs(0 - x));
		min = Math.min(min, Math.abs(0 - y));
		min = Math.min(min, Math.abs(w - x));
		min = Math.min(min, Math.abs(h - y));

		System.out.println(min);

	}
}
