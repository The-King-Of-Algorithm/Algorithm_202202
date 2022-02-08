package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//ATM
public class Beak2_11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		List<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		int res = 0;
		
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);

		for (int i = 0; i < N; i++) {
			sum += list.get(i);
			res += sum;
		}
		System.out.println(res);
	}
}
