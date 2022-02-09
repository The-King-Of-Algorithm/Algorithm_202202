package SWExpert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d3_1206 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("d3_1206"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] bul = new int[N];
			int sum = 0;
			
			
			for (int i = 0; i < N; i++) {
				bul[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 2; i < bul.length-2; i++) {
				if (bul[i-1] < bul[i] && bul[i+1] < bul[i] && bul[i-2] < bul[i] && bul[i+2] < bul[i]) {
					int max1 = Math.max(bul[i-2], bul[i-1]);
					int max2 = Math.max(bul[i+2], bul[i+1]);
					int max = Math.max(max1, max2);
					
					sum += (bul[i]-max);
				}
			}
			System.out.printf("#%d %d\n",tc, sum);
			
			
		}

	}

}
