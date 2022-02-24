package algo20220225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 조커 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		ArrayList<Integer>al = new ArrayList<Integer>();
		int joker =0;
		for(int i=0; i<t; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp!=0) {
				if(!al.contains(tmp))
				al.add(tmp);
			}
			else {
				joker++;
			}
		}
		Collections.sort(al);
		int ans = joker;
		for(int i=0; i<al.size(); i++) {
			int cnt =0;
			int tmp = joker;
			int idx =-1;
			for(int j=i; j<al.size()-1; j++) {
				idx=j;
				if(al.get(j+1)-al.get(j)==1) {
					continue;
				}
				else if(al.get(j+1)-al.get(j)-1<=tmp) {
					tmp = tmp- (al.get(j+1)-al.get(j)-1);
				}
				else {
					break;
				}
			}
			if(idx==al.size()-2) {
				if(al.get(idx)+1==al.get(al.size()-1)) {
					cnt=1;
				}
			}
			cnt = cnt+idx-i+1+joker;
			ans=Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
}
