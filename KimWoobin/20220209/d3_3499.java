package SWExpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d3_3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("d3_3499"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int M = (N%2==0)?N/2:(N/2)+1;
			String[] card = new String[N];
			String[] card1 = new String[M];
			String[] card2 = new String[N-M];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				card[i] = st.nextToken();
			}
			
			for (int i = 0; i < M; i++) {
				card1[i] = card[i];
			}
			
			for (int i = M; i < N; i++) {
				card2[i-M] = card[i];
			}
			
			for (int i = 0; i < N; i++) {
				card[i] = (i%2)==0? card1[i/2]:card2[i/2];
			}
			
			System.out.printf("#%d ",tc);
			for (int i = 0; i < card.length; i++) {
				System.out.print(card[i]+ " ");
			}System.out.println();
		}
	}
}
