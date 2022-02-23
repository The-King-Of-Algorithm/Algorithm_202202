package SWExpert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class d3_1220 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader br = new BufferedReader(new FileReader("d3_1220.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int[][] cell = new int[N][N];
			
			for (int i = 0; i < cell.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < cell.length; j++) {
					cell[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ArrayList<StringBuilder> list = new ArrayList<StringBuilder>();
			for (int i = 0; i < cell.length; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < cell.length; j++) {
					if (cell[j][i]==1 || cell[j][i]==2) {
						sb.append(cell[j][i]);
					}
				}list.add(sb);
			}
			
			int cnt=0;
			for (int i = 0; i < list.size(); i++) {
				int k = list.get(i).length();
				for (int j = 1; j < k; j++) {
						if (list.get(i).charAt(j-1) == '1' && list.get(i).charAt(j) == '2') {
							cnt+=1;
						}
					}
					
				}
			
			System.out.printf("#%d %d\n",tc,cnt);
		
		}
	}

}
