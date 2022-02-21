package IM기출;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sol22_소금쟁이합계 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Solution22.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 배열 크기
			int num = sc.nextInt(); // 소금쟁이 수
			// int[][] map = new int[N][N]; // 연못
			int[][] check = new int[N][N]; // 자리에 있는지 없는지 체크 (밟으면 1, 안밟았으면 0)
			int count = 0; // 살아있는 소금쟁이 수
			
			for(int i = 0; i < num; i++) {
				// 소금쟁이 수만큼 행, 열, 방향 입력받기
				int row = sc.nextInt(); // 열
				int colunm = sc.nextInt(); // 행
				int direction = sc.nextInt(); // 방향
				

					
				// 3, 2, 1 순서로 뛰는거 반복
				for(int j = 3; j > 0; j--) {
					// 처음 자리가 이미 뛰었던 자리인가?
					if(check[row][colunm] == 1) {
						break;
					}
										
					// 위치에 따라 이동!
					// 상
					if(direction == 1) {
						// 뛸 자리가 배열안에 있고, 밟았던 자리가 아니면 점프
						if(row-j >= 0 && check[row-j][colunm] == 0) {
							row -= j;
						} else{ break; }
					}
					// 하
					else if(direction == 2) {
						if(row+j < N && check[row+j][colunm] == 0) {
							row += j;
						} else{ break; }
					} 
					// 좌
					else if(direction == 3) {
						if(colunm-j >= 0 && check[row][colunm-j] == 0) {
							colunm -= j;
						} else{ break; }
					} 
					// 우
					else if(direction == 4){
						if(colunm+j < N && check[row][colunm+j] == 0) {
							colunm += j;
						} else{ break; }
					}
					
					// 마지막에는 check 값 저장 ( 1 )
					if(j == 1) {
						check[row][colunm] = 1;
						count++;
					}
				}
			}
			
			System.out.println("#" + tc + " " + count);
		}
		
		
	}
}