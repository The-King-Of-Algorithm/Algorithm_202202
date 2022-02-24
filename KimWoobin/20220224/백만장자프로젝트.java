package IMTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백만장자프로젝트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("백만장자프로젝트.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] cell = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < cell.length; i++) {
				cell[i] = Integer.parseInt(st.nextToken());
			}
			
			int i = N-1;
			long buy=0;
			long cnt=0;
			long sell=0;
			int n=1;
			while(i-n >= 0) {
				int ni = i-n;
				//System.out.println("ni -> i:"+i+" n:"+n);
				if (cell[ni] <= cell[i]) {
					buy+=cell[ni];
					cnt+=1;
					n+=1;
					//System.out.println("buy:"+buy+ " cnt:"+cnt);
				}
				if (cell[ni] > cell[i] || ni==0) {
					sell = sell+(cell[i]*cnt)-buy;
					buy=0;
					cnt=0;
					i = ni;
					n=1;
				}
			}
			System.out.printf("#%d %d\n",tc,sell);
			
		}
		
		
		

	}

}
