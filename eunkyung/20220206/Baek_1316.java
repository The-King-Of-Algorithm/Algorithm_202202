package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//연속된 문자인지..
//baba는 아님
public class Baek_1316 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			ArrayList<String> list = new ArrayList<String>();
			boolean state = true;

			for (int j = 0; j < str.length(); j++) {
				String s = str.substring(j, j + 1);
				if (list.isEmpty()) {
					list.add(s);
				} else {
					if (list.get(list.size() - 1).equals(s)) {
						list.add(s);
					} else {
						if (list.contains(s)) {
							state = false;
							break;
						} else {
							list.add(s);
						}
					}
				}
			}
			if (state) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
