package algo20220215;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 최대상금 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("최대상금.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		System.out.println(t);
		for (int tc = 1; tc <= t; tc++) {

			StringTokenizer st = new StringTokenizer(bf.readLine());
			String num = st.nextToken();
			int k = Integer.parseInt(st.nextToken());
			
			char[] tmp = new char[num.length()];
			for(int i=0; i<tmp.length; i++) {
				tmp[i]=num.charAt(i);
			}
			int flag =0;
			int cmp =0;
			for(int i =0; i<tmp.length; i++) {// 시작인덱스
				int max =tmp[i]-'0'; //i 번째 시작하니까
				int idx = i;
				for(int j=i+1; j<tmp.length; j++) { // i+1 ~ length까지 최대값
					if(max<=tmp[j]-'0') {
						max= tmp[j]-'0';
						idx = j;
					}
				}
				if(idx!=i && k>0) {
					if(max==cmp) {
						flag=1;
					}
					cmp = max;
					k--;
					char temp = tmp[i];
					tmp[i]=tmp[idx];
					tmp[idx]=temp;
				}
			}
			if(flag==1) {
				 Arrays.sort(tmp);
				 char[] intTemp = new char[tmp.length];
				 for(int i =0; i<intTemp.length; i++){
					 intTemp[i]=tmp[intTemp.length-1-i];
			     }
				 tmp = intTemp;
			}
			while(k>0 && flag==0) { 
				k--;
				char temp = tmp[tmp.length-1];
				tmp[tmp.length-1]=tmp[tmp.length-2];
				tmp[tmp.length-2]=temp;
			}
			System.out.print("#"+tc+" ");
			for(char c: tmp) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
