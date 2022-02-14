package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.IllegalFormatCodePointException;
import java.util.StringTokenizer;

public class B_2961 {
	static int min = Integer.MAX_VALUE;
	
	static class Food{
		int s;
		int b;
		
		public Food(int s, int b) {
			super();
			this.s = s;
			this.b = b;
		}
		
		@Override
		public String toString() {
			return "Food [s=" + s + ", b=" + b + "]";
		}
		
		
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("B_2961.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Food[] food = new Food[N];
		for (int i = 0; i < food.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			food[i] =  new Food(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		powerset(food, new Food[N],0,0);
		System.out.println(min);
	}


	private static void powerset(Food[] food, Food[] sel, int k, int idx) {
		if (k==food.length) {
			for (int i = 0; i < sel.length; i++) {
				if (sel[i].s == 1 && sel[i].b == 1) {
					sel[i] = food[i];
				}
			}
			//System.out.println(Arrays.toString(sel));
			
			int cnt=0;
			for (int i = 0; i < sel.length; i++) {
				if (sel[i].s != 0 && sel[i].b != 0) {
					cnt++;
				}
			}
			
			if (cnt != 0) {
				foodcal(sel);
			}
			//System.out.println(sel.length);
			return;
		}
		
		sel[k] = new Food(1,1);
		powerset(food, sel, k+1, idx+1);
		sel[k] = new Food(0,0);
		powerset(food, sel, k+1, idx);
		
	}


	private static void foodcal(Food[] sel) {
		int S = 1;
		int B = 0;
		int flavor = 0;
		for (int i = 0; i < sel.length; i++) {
			if (sel[i].s == 0) {
				sel[i].s = 1;
			}
			S*=sel[i].s;
			B+=sel[i].b;
		}
		//System.out.println("S: "+S+" "+"B : "+B);
		flavor = Math.abs(S-B);
		//System.out.println("flavor : "+flavor);
		min = Math.min(flavor, min);
	}

}
