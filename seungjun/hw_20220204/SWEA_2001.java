package edu.ssafy.chap02;

import java.util.Scanner;
import java.io.FileInputStream;

/*
 * SWEA 2001. 파리 퇴치
 */

public class SWEA_2001 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("./src/input_2001.txt"));
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] arr = new int[N][N];
            int sum = 0, res = 0;
            
            for(int i=0; i<N; i++){
            	    for(int j=0; j<N; j++){
                    	arr[i][j] = sc.nextInt();    
                    }
            }
            for(int K=0; K<=N-M; K++){
                for(int L=0; L<=N-M; L++){
                    if(res < sum) res = sum;
               		sum = 0;
                	for(int i=K; i<M+K; i++){
            	    	for(int j=L; j<M+L; j++){
                    		sum += arr[i][j];
                    	}
            		}
                }
            }
            System.out.println("#"+test_case+" "+res);

		}
	}
}
