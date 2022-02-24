package IMTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 줄세우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("줄세우기.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> list = new LinkedList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			if (i==0) {
				list.add(i+1);
				continue;
			}
			
			if (n!=0) {
				list.add(list.size()-n, i+1);
				//System.out.println(list);
			}else if (n==0){
				list.add(i+1);
			}
			
		}
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
		
		
	}

}
