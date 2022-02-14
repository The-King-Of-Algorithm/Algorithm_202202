package algo20220215;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 최대상금dfs {
	static int max ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("최대상금.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		System.out.println(t);
		for (int tc = 1; tc <= t; tc++) {
			max=-1;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String num = st.nextToken();
			int k = Integer.parseInt(st.nextToken());
			char[] tmp = new char[num.length()];
			if(k>tmp.length) {
				k=tmp.length;
			}
			for (int i = 0; i < num.length(); i++) {
				tmp[i]=num.charAt(i);
			}
			dfs(tmp,k,0);
			System.out.println("#"+tc+" "+max);
		}

	}

	static void dfs(char[] tmp, int k,int cnt) {
		if(cnt==k){
			String s="";
			for(int i =0; i<tmp.length; i++) {
				s+=tmp[i];
			}
			max=Math.max(max,Integer.parseInt(s));
			return;
		}
		for(int i =0; i<tmp.length; i++) {
			for(int j=i+1; j<tmp.length; j++) {
				char temp=tmp[i];
				tmp[i]=tmp[j];
				tmp[j]=temp;
				dfs(tmp,k,cnt+1);
				temp=tmp[i];
				tmp[i]=tmp[j];
				tmp[j]=temp;
			}
		}
	}
}
