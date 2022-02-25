package day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj13300_방배정 {
//	static class Student implements Comparable<Student> {
//		int gender;
//		int grade;
//
//		public Student(int gender, int grade) {
//			super();
//			this.gender = gender;
//			this.grade = grade;
//		}
//
//		@Override
//		public String toString() {
//			return "Student [gender=" + gender + ", grade=" + grade + "]";
//		}
//
//		@Override
//		public int compareTo(Student o) {
//			if (this.gender == o.gender) {
//				return this.grade - o.grade;
//			}
//			return this.gender - o.gender;
//		}
//	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// Student[] s = new Student[N];
		int[][] s = new int[2][7];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			s[gender][grade]++;
		}
		int sum = 0;
		for (int i = 0; i < s.length; i++) {
			for (int j = 1; j < s[i].length; j++) {
				if(s[i][j]==0)continue;
				if(s[i][j]%K == 0) sum+= s[i][j]/K;
				else sum+= s[i][j]/K+1;
			}
		}
		System.out.println(sum);

		for (int i = 0; i < s.length; i++) {
			for (int j = 1; j < s[i].length; j++) {
				System.out.print(s[i][j] + " ");
			}
			System.err.println();
		}

	}
}
