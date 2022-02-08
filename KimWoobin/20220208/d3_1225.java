package SWExpert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class d3_1225 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//System.setIn(new BufferedReader(new FileReader("d3_1225")));
		//Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			Queue<Integer> pw = new LinkedList<Integer>();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int temp = 0;
			boolean a = true;
			
			for (int i = 0; i < 8; i++) {
				pw.offer(Integer.parseInt(st.nextToken()));
			}
			
			while(a) {
				for (int i = 1; i <= 5; i++) {
					temp = pw.poll();
					temp = temp-i;
					if (temp > 0) {
						pw.offer(temp);
					}
					if (temp <= 0) {
						pw.offer(0);
						a = false;
						break;
					}
					
				}
				
			}
			System.out.print("#"+tc+" ");
			for(int i=0 ; i< 8 ; i++) {
				System.out.print(pw.poll()+" ");
			}System.out.println();
		}
		
	}

}
