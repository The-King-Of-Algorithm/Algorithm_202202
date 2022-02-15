package algo20220216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 금민수의개수 {
	static int[] arr = {4,7};
	static int cnt =0;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		String n =st.nextToken();  // 첫자리수  10    47 74
		String m = st.nextToken(); // 두번째수  100   477 474
		int sel[] = new int [m.length()];
		permutation(sel,0,n.length(),m.length(),Integer.parseInt(n),Integer.parseInt(m));
	
		System.out.println(cnt);
	}
	static void permutation(int sel[],int idx,int n, int m,int ncost,int mcost){
		if(idx==m) {
			System.out.println(Arrays.toString(sel));
			long tmp = 0;
			for(int i =0; i<idx; i++) { 
				tmp=tmp+(long) (sel[i]*Math.pow(10, i));
			}
			if(tmp>=ncost && tmp<=mcost) {
				cnt++;
			}
			return;
		}
		if(idx>=n) {
			System.out.println(Arrays.toString(sel));
			long tmp = 0;
			for(int i =0; i<idx; i++) {
				tmp=tmp+(long) (sel[i]*Math.pow(10, i));
			}
			if(tmp>=ncost && tmp<=mcost) {
				cnt++;
			}
		}
		for(int i =0; i<arr.length; i++) {
			sel[idx]=arr[i];
			permutation(sel,idx+1,n,m,ncost,mcost);
			sel[idx]=0;
		}
	}
}
