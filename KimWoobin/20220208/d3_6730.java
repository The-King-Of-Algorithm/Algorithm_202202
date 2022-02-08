package SWExpert;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class d3_6730 {

	public static void main(String[] args) throws IOException {
		//System.setIn(new BufferedInputStream(new FileInputStream("d3_6730")));
		BufferedReader br = new BufferedReader(new FileReader("d3_6730"));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
		
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] block = new int[N];
			int upmax = 0;
			int downmax = 0	;
			
			for (int i = 0; i < N; i++) {
				block[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N-1; i++) {
				if ((block[i]-block[i+1]) < 0) {
					upmax = Math.max(block[i+1]-block[i], upmax);
				}
				else {
					downmax = Math.max(block[i]-block[i+1], downmax);
				}
			}
			System.out.printf("#%d %d %d\n",tc,upmax,downmax);
			
		}
	}
}
