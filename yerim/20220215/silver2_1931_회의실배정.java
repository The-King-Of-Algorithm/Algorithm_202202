package edu.ssafy.chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class silver2_1931_회의실배정 {

	static class Meeting implements Comparable<Meeting>{
		int start, end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			return this.end != o.end? this.end - o.end : this.start - o.start;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		Meeting[] meetings = new Meeting[N];
		
		// 회의 시작, 끝 시간 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		List<Meeting> result = getSchedule(meetings);
		
		System.out.println(result.size());
	}

	private static List<Meeting> getSchedule(Meeting[] meetings) {
		
		ArrayList<Meeting> result = new ArrayList<Meeting>();
		
		// 회의 목록을 end 기준으로 오름차순, 같으면 start 기준으로 오름차순 (compareTo)
		Arrays.sort(meetings);
		result.add(meetings[0]);
		
		for (int i = 1, size = meetings.length; i < size; i++) {
			// 직전 회의의 end와 현재 회의의 start 비교
			if(result.get(result.size()-1).end <= meetings[i].start) {
				result.add(meetings[i]);
			}
		}
		
		return result;
	}

}
