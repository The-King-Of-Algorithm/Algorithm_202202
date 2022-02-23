package IMTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 방배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("방배정.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] mv = new int[7];
		int[] wv = new int[7];
		int sum=0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			if (s==1) {
				mv[g]+=1;
			}
			if (s==0) {
				wv[g]+=1;
			}
		}
		//System.out.println(Arrays.toString(mv));
		//System.out.println(Arrays.toString(wv));
		
		for (int i = 1; i < mv.length; i++) {
			if (mv[i] != 0) {
				int room = ((mv[i]-1)/M)+1;
				sum+=room;
			}
			
		}
		for (int i = 1; i < mv.length; i++) {
			if (wv[i] != 0) {
				int room = ((wv[i]-1)/M)+1;
				sum+=room;
			}
			
		}
		System.out.println(sum);

	}

}
