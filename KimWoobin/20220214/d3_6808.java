package SWExpert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d3_6808 {
	static int[] gu;
	static int guwin;
	static int inwin;
	static int count=0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader br = new BufferedReader(new FileReader("d3_6808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int[] num = new int[19];
			gu = new int[9];
			int[] in = new int[9];
			guwin=0;
			inwin=0;
			
			for (int i = 0; i < num.length; i++) {
				num[i] = i;
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < gu.length; i++) { //규영이 카드숫자
				gu[i] = Integer.parseInt(st.nextToken());
				num[gu[i]] = 0;
			}
			
			int k=0;
			for (int i = 0; i < num.length; i++) { //인영이 카드숫자
				if (num[i] != 0) {
					in[k] = i;
					k++;
				}
			}
			
			Per(in,new int[gu.length],new boolean[gu.length],0);
			
			//System.out.println(guwin+" "+inwin);
			System.out.printf("#%d %d %d\n",tc,guwin,inwin);
			//System.out.println(count);
		}
		
		
	}

	private static void Per(int[] arr, int[] sel, boolean[] v, int k) {
		if (k==sel.length) {
			//System.out.println(Arrays.toString(sel));
			scorecal(sel);
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (v[i] == false) {
				v[i] = true;
				sel[k] = arr[i];
				Per(arr, sel, v, k+1);
				v[i] = false;
			}
		}
		
	}

	private static void scorecal(int[] sel) {
		int guscore=0;
		int inscore=0;
		
		for (int i = 0; i < sel.length; i++) { //9번의 게임진행
			if (gu[i] > sel[i]) {
				guscore = guscore + gu[i]+sel[i];
			}else {
				inscore = inscore + gu[i]+sel[i];
			}
		}
		
		if (guscore > inscore) { //승자정하기
			guwin++;
		}else if(guscore < inscore) {
			inwin++;
		}
	}

}
