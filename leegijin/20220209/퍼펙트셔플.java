package problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 퍼펙트셔플 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("퍼펙트셔플.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			ArrayList<String> al = new ArrayList<>();
			ArrayList<String> ans = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				al.add(st.nextToken());
			}
			if (al.size() % 2 == 0) {
				for (int i = 0; i < (al.size()) / 2; i++) {
					ans.add(al.get(i));
					//System.out.println(i);
					ans.add(al.get(i + al.size() / 2));
					//System.out.println(i + al.size() / 2);
				}
			}
			else {
				for (int i = 0; i < (al.size()+1) / 2; i++) {
					ans.add(al.get(i));
					//System.out.println(i);
					if(i + (al.size()+1 )/ 2<al.size()) {
					ans.add(al.get(i + (al.size()+1 )/ 2));
					//System.out.println(i + (al.size()+1) / 2);
					}
				}
			}
			System.out.print("#"+tc+" ");
			for (String tmp : ans) {
				System.out.print(tmp + " ");
			}
			System.out.println();
		}
	}
}
