package SWEA;

import java.util.Scanner;

public class D3_7272 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			// 문자열 두개 입력받기
			String a = sc.next();
			String b = sc.next();
			//System.out.println(a);
			//System.out.println(b);
			// 경근이가 생각하는 문자열 저장 (0, 1, 2)
			char[] chr_a = new char[a.length()];
			char[] chr_b = new char[b.length()];
			
			
			for(int i = 0; i < chr_a.length; i++) {
				chr_a[i] = compare(a.charAt(i));
				//System.out.println(String.valueOf(chr_a[i]));
			}		
			
			for(int i = 0; i < chr_b.length; i++) {
				chr_b[i] = compare(b.charAt(i));
			}
			
			if((a.length() == b.length()) && (String.valueOf(chr_a) == String.valueOf(chr_b))) {
				System.out.printf("#%d SAME\n", tc);
			} else {
				System.out.printf("#%d DIFF\n", tc);
			}
		}
	}
	
	public static char compare(char chr) {
		switch(chr) {
		case 'A':
		case 'D':
		case 'O':
		case 'P':
		case 'Q': 
		case 'R': chr = '1'; break;
		case 'B': chr = '2'; break;
		default: chr = '0'; break;
		}
		
		return chr;
	}

}
