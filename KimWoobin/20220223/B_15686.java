package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_15686 {
	static int N,M,sum,ans;
	static int[][] cell;
	static int[][] copy;
	static ArrayList<int[]> list;
	
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("B_15686.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cell = new int[N][N];
		list = new ArrayList<int[]>();
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < cell.length; i++) { //배열 채워주기
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < cell.length; j++) {
				cell[i][j] = Integer.parseInt(st.nextToken());
				if (cell[i][j] == 2) { //치킨집좌표는 리스트에 따로 저장
					list.add(new int[] {i,j});
				}
			}
		}
//		for (int[] is : list) {
//			System.out.println(Arrays.toString(is));
//		}
		
		Com(new int[M][2],0, 0); //M개의 치킨집을 뽑기위해 조합재귀를 돌린다.
		System.out.println(ans);
	}

	private static void Com(int[][] sel,int k, int idx) { //M개의 치킨집을 뽑는코드
		if (k == M) {
			copy = new int[N][N]; //원본배열을 남기기 위해 배열 복사
			for (int i = 0; i < cell.length; i++) {
				for (int j = 0; j < cell.length; j++) {
					copy[i][j] = cell[i][j];
				}
			}
			distancecal(sel); //치킨거리 계산을 위한 함수
			ans = Math.min(ans, sum); //M빼고 치킨집을 모두 없앤 경우의수 중 가장 작은 치킨거리 구하기.
			return;
		}
		
		for (int i = idx; i < list.size(); i++) {
			sel[k][0] = list.get(i)[0];
			sel[k][1] = list.get(i)[1];
			Com(sel,k+1, i+1);
		}
	}

	private static void distancecal(int[][] sel) {
		sum=0;
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy.length; j++) {
				if (copy[i][j] == 1) {
					int dis=0;
					int mindis=Integer.MAX_VALUE;
					for (int k = 0; k < sel.length; k++) { //치킨거리 계산
						dis = Math.abs(i-sel[k][0]) + Math.abs(j-sel[k][1]);
						mindis = Math.min(mindis, dis);
					}
					sum+=mindis;
				}
			}
		}
	}

	private static void print(int[][] cell2) {
		for (int i = 0; i < cell2.length; i++) {
			for (int j = 0; j < cell2.length; j++) {
				System.out.print(cell2[i][j]+" ");
			}System.out.println();
		}
	}

}
