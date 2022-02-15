package Jungol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class J_1828{
	static class Chem implements Comparable<Chem>{
		int mintemp;
		int maxtemp;
		
		public Chem(int mintemp, int maxtemp) {
			super();
			this.mintemp = mintemp;
			this.maxtemp = maxtemp;
		}
		
		@Override
		public String toString() {
			return "Chem [mintemp=" + mintemp + ", maxtemp=" + maxtemp + "]";
		}

		@Override
		public int compareTo(Chem o) {
			if (this.maxtemp == o.maxtemp) {
				return this.mintemp - o.mintemp;
			}
			return this.maxtemp-o.maxtemp;
		}
		
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Chem[] chem = new Chem[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			chem[i] = new Chem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		
		Arrays.sort(chem);
		//System.out.println(Arrays.toString(chem));
		
		ArrayList<Chem> list = new ArrayList<Chem>();
		list.add(chem[0]);
		for (int i = 1; i < chem.length; i++) {
			if (list.get(list.size()-1).maxtemp < chem[i].mintemp) {
				list.add(chem[i]);
			}
		}
		
		System.out.println(list.size());
		
		
	}
}