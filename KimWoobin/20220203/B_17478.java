package BAEKJOON;

import java.util.Scanner;

public class B_17478 {
	static Scanner sc = new Scanner(System.in);
	static int t = sc.nextInt();
	static int temp = t;
	
	static String s = '\u0022'+"재귀함수가 뭔가요?"+'\u0022';
	static String f1 = '\u0022'+"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
	static String f2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
	static String f3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."+'\u0022';
	static String f = f1+f2+f3;
	static String f4 = '\u0022'+"재귀함수는 자기 자신을 호출하는 함수라네"+'\u0022';
	static String f5 = "라고 답변하였지.";
	
	public static void prof(int n) {
		if (n==1) {
			s = "____" + s;
			f4 = "____" + f4;
			f5 = "____" + f5;
			System.out.println(s+"\n"+f4+"\n"+f5);
			for (int i = 0; i <temp ; i++) {
				f5 = f5.substring(4);
				System.out.println(f5);
			}
			return;
		}
		
		else {
			s = "____" + s;
			f1 = "____" + f1;
			f2 = "____" + f2;
			f3 = "____" + f3;
			f4 = "____" + f4;
			f5 = "____" + f5;
			System.out.println(s+"\n"+f1+"\n"+f2+"\n"+f3);
			prof(n-1);
		}
	}

	public static void main(String[] args) {
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		System.out.println(s);
		System.out.println(f1+"\n"+f2+"\n"+f3);
		prof(t);
	}
}