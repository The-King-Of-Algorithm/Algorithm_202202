package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_1989_초심자의회문검사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			int size = str.length();
			int result = 1;
			
			for(int i = 0; i < size/2; i++) {
				if(str.charAt(i) != str.charAt(size-1-i)){
					result = 0;
					break;
					
				}
			}
			
			System.out.printf("#%d %d\n", tc, result);
		}
	}

}
