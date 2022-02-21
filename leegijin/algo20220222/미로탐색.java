package problem_dfsbfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
	static int row;
	static int col;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("미로탐색.txt"));
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		row  = Integer.parseInt(st.nextToken());
		col  = Integer.parseInt(st.nextToken());
		
		
		int map [][] = new int[row][col];
		for(int i =0; i<row; i++) {
			String s = bf.readLine();
			for(int j=0; j<col; j++) {
				map[i][j]=s.charAt(j)-'0';
			}
		}
		//print(map);
		bfs(map);
	}
	static void print(int map[][]) {
		for(int []tmp : map) {
			for(int t: tmp) {
				System.out.print(t+" ");
			}
			System.out.println();
		}
	}
	
	static void bfs(int [][]map) {
		Queue<int[]> que = new LinkedList<>();
		int visit[][] = new int[row][col];
		visit[0][0]=1;
		que.add(new int [] {0,0});
		while(!que.isEmpty()) {
			int [] current = que.poll();		
			int cr = current[0];
			int cc = current[1];
			print(visit);
			if(cr==row-1 && cc==col-1) {
				System.out.println(visit[row-1][col-1]);
				break;
			}
			for(int i =0; i<4; i++) {
				int nr = cr+dr[i];
				int nc = cc+dc[i];
				if(nr>=0 && nr<row && nc>=0 && nc<col && visit[nr][nc]==0 && map[nr][nc]==1) {
					visit[nr][nc]=visit[cr][cc]+1;
					que.add(new int[] {nr,nc});
				}
			}
			
	
		}
	}
}
