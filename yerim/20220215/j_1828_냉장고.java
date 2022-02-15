package JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class j_1828_냉장고 {
	
	static class Bio implements Comparable<Bio>{
		int min, max;

		public Bio(int min, int max) {
			this.min = min;
			this.max = max;
		}

		@Override
		public int compareTo(Bio o) {
			return this.max != o.max? this.max-o.max : this.min-o.min;
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Bio[] bio = new Bio[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			bio[i] = new Bio(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		List<Bio> result = getRefri(bio);
		
		System.out.println(result.size());
	}

	private static List<Bio> getRefri(Bio[] bio) {
		
		ArrayList<Bio> result = new ArrayList<Bio>();
		
		Arrays.sort(bio);
		result.add(bio[0]);
		
		for(int i = 1, size = bio.length; i < size; i++) {
			if(result.get(result.size()-1).max < bio[i].min) {
				result.add(bio[i]);
			}
		}
		
		return result;
	}

}