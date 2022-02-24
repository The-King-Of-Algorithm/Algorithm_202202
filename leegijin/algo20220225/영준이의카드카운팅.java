package algo20220225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 영준이의카드카운팅 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			ArrayList<String> sl = new ArrayList<>();
			String s = bf.readLine();
			int count[] = { 13, 13, 13, 13 }; // s d h c
			int flag = 0;
			for (int i = 0; i <= (s.length()/3)-1; i++) {
				String card = s.substring(3 * i, 3 * i + 3);
				if (sl.contains(card)) {
					flag = 1;
				}
				sl.add(card);
			}
			for (int i = 0; i < sl.size(); i++) {
				if (sl.get(i).charAt(0) == 'S') {
					count[0]--;
				}
				if (sl.get(i).charAt(0) == 'D') {
					count[1]--;
				}
				if (sl.get(i).charAt(0) == 'H') {
					count[2]--;
				}
				if (sl.get(i).charAt(0) == 'C') {
					count[3]--;
				}
			}
			if (flag == 1) {
				System.out.println("#" + t + " ERROR");
			} else {
				System.out.print("#" + t + " ");
				for(int i=0; i<4; i++) {
					System.out.print(count[i]+" ");
				}
				System.out.println();
			}
		}
	}
}
