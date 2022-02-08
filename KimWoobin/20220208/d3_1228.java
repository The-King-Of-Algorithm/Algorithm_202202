package SWExpert;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class d3_1228 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new BufferedInputStream(new FileInputStream("d3_1228")));
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			LinkedList<String> pw = new LinkedList<String>();
			
			for (int i = 0; i < N; i++) {
				pw.add(sc.next());
			}
			
			int M = sc.nextInt();
			
			for (int i = 0; i <M; i++) {
				String order = sc.next();
				int insertidx = sc.nextInt();
				int insertnum = sc.nextInt();
				String temp;
				
				for (int k = insertidx; k < insertidx+insertnum; k++) {
					temp = sc.next();
					pw.add(k, temp);
				}
			}
			
			System.out.print("#" + tc+ " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(pw.get(i)+" ");
			}System.out.println();
		}
		
	}
}
