package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
//최대 문자 개수 세기
public class Baek_1157 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		List<Character> sl = new ArrayList<Character>();
		int[] cnt = new int[str.length()];

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			char C = ' ';
			int index = 0;
			
			if (c >= 97) {
				C = (char) (c - 32);
			} else {
				C = (char) (c + 32);
			}

			if (!sl.contains(c) && !sl.contains(C)) {
				sl.add(c);
				index = sl.indexOf(c);
				cnt[index]++;
			} else {
				if (sl.contains(c))
					index = sl.indexOf(c);
				else
					index = sl.indexOf(C);
				cnt[index]++;
			}
		}
		
		boolean state = true;
		int max = 0;
		int max_i = 0;
		
		for (int i = 0; i < cnt.length; i++) {
			if (max < cnt[i]) {
				state = true;
				max = cnt[i];
				max_i = i;
			} else if (max == cnt[i]) {
				state = false;
			}
		}

		if (state) {
			if (sl.get(max_i) >= 97) {
				System.out.println((char) (sl.get(max_i) - 32));
			} else
				System.out.println(sl.get(max_i));
		} else {
			System.out.println("?");
		}

	}
}
