package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1931 {
	static class Time implements Comparable<Time>{
		int start;
		int end;
		public Time(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public String toString() {
			return "Time [start=" + start + ", end=" + end + "]";
		}
		@Override
		public int compareTo(Time o) {
			if (this.end == o.end) {
				return this.start - o.start;
			}
			return this.end-o.end;
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader br = new BufferedReader(new FileReader("B_1931.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Time[] time =  new Time[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = new Time(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(time);
		
		ArrayList<Time> list = new ArrayList<Time>();
		list.add(time[0]);
		for (int i = 1; i < time.length; i++) {
			if (list.get(list.size()-1).end <= time[i].start) {
				list.add(time[i]);
			}
		}
		
		System.out.println(list.size());
	}

}
