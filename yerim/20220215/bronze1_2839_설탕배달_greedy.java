package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bronze1_2839_설탕배달_greedy {

	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		cnt = 0;
		
		greedy(N);
		
		System.out.println(cnt);
	}

	private static void greedy(int n) {
		
		while(true) {
			// 3씩 빼다가 5로 나눠지면 
			if(n%5 == 0) {
				cnt += n/5;
				break;
			} else {
				cnt++;
				n -= 3;
			}
			
			if(n < 0) {
				cnt = -1;
				break;
			}
		}
	}
}