package pratice2;


import java.io.*;
 
public class  달팽이숫자 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int num=1;
            int row=0;
            int col=-1;
            int trans =1;
             
            while(n>0) {
                for(int i =0; i<n; i++) {
                    col  = col+ trans;
                    arr[row][col]=num;
                    num=num+1;
                }
                n=n-1;
                for(int i =0; i<n; i++) {
                    row  = row+ trans;
                    arr[row][col]=num;
                    num=num+1;
                }
                trans*=-1;
            }
            System.out.println("#"+t);
            for(int tmp[] :arr) {
                for(int t1: tmp) {
                    System.out.print(t1+" ");
                }
                System.out.println();
            }
                 
        }
    }
}