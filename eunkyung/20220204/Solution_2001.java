package hw_20220204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_2001 {
//파리퇴치
	public static void main(String args[]) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(bf.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int [][] map = new int [N][N];
			int max =0;
			int sum =0;
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<=N-M;i++) { //기준점을 정하는 이중반복문
				for(int j=0;j<=N-M;j++) { //파리채 영역을 고려해 N-M까지
					sum=0;
					for(int x = 0; x<M;x++) { //파리채 영역만큼 루프돌며 계산
						for(int y = 0; y<M;y++) {
							sum += map[i+x][j+y];
						}		
					}
					if(max<sum) {
						max = sum;
					}
				}
			}
			System.out.println("#" + test_case + " " + max);
		}
	}
}