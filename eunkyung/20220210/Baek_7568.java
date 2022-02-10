package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//덩치 비교
public class Baek_7568 {
	static class Person {
		int w;
		int h;

		public Person(int w, int h) {
			this.w = w;
			this.h = h;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		Person[] p = new Person[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			p[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < p.length; i++) {
			int rank = 0;
			for (int n = 0; n < p.length; n++) {
				if (i == n)
					continue;
				if (p[i].w < p[n].w && p[i].h < p[n].h) {
					rank++;
				}
			}
			System.out.print((rank + 1) + " ");
		}

	}
}