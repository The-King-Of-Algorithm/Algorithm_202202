package algo20220215;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 규영이와인영이의카드게임 {
	static int [] arr,arr2;
	static int awin,bwin;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for(int tc=1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			arr = new int [9];
			arr2= new int [9];
			awin =0;
			bwin=0;
			for(int i=0; i<9; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			int cnt =0;
			for(int i=1; i<19; i++) {
				int flag =1;
				for(int j=0; j<9; j++) {
					if(arr[j]==i) {
						flag =0;
						break;
					}
				}
				if(flag==1) {
					arr2[cnt]=i;
					cnt++;
				}
			}
//			System.out.println();
//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(arr2));
			boolean visit [] = new boolean[9];
			int sel [] = new int [9];
			permutation(0,visit,sel);
			System.out.println("#"+tc+" "+awin+" "+bwin);
		}
		
		
		
	}
	private static void permutation(int idx, boolean[] visit, int[] sel) {
		// TODO Auto-generated method stub
		if(idx==9) {
			int ascore =0;
			int bscore =0;
			for(int i=0; i<sel.length; i++) {
				if(arr[i]>sel[i]) {
					ascore=ascore+arr[i]+sel[i];
				}
				else if(arr[i]<sel[i]) {
					bscore=bscore+sel[i]+arr[i];
				}
			}
			if(ascore>=bscore) {
				awin++;
			}
			else if(ascore<bscore) {
				bwin++;
			}
			return;
		}
		
		
		for(int i =0; i<arr2.length;i++) {
			if(!visit[i]) {
				visit[i]=true;
				sel[idx]=arr2[i];
				permutation(idx+1,visit,sel);
				visit[i]=false;
			}
		}
	}
}
