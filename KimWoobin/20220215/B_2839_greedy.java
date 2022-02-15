package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2839_greedy {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt=0;
		
		while(N>0) {
			if (N%5 == 0) {
				N = N-5;
				cnt++;
			}else {
				N = N-3;
				cnt++;
			}
			
			if (N==1 || N==2) {
				cnt=-1;
				break;
			}
		}
		System.out.println(cnt);

	}

}
