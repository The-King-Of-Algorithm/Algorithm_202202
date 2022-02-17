package algo20220218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빵집 {
	static int r,c;
	static char [][]  map; 
	static int dr [] = {-1, 0,1};
	static int dc [] = {1, 1,1};
	static int ans =0;
	static int flag =0;
	static boolean v[][];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (bf.readLine());
		r =Integer.parseInt(st.nextToken());
		c =Integer.parseInt(st.nextToken());
		map = new char[r][c];
		for(int i=0; i<r ; i++) {
			String s = bf.readLine();
			for(int j=0; j<c; j++) {
				map[i][j]=s.charAt(j);
			}
		}
		boolean [][] visit = new boolean[r][c];
		for(int i=0; i<r; i++) {
			visit[i][0]=true;
			flag=0;
			dfs(i,0,visit);
			}
		System.out.println(ans);
		}
	static void dfs(int row, int col,boolean visit[][]) {
		if(col==c-1) {
			flag=1;
			ans++;
			return;
		}
		
		for(int i=0; i<3; i++) {
			int nrow = row+dr[i];
			int ncol = col+dc[i];
			if(nrow>=0 && nrow<r && ncol>=0&&ncol<c&& map[nrow][ncol]=='.'&& !visit[nrow][ncol] &&flag==0) {
				visit[nrow][ncol]=true;
				dfs(nrow,ncol,visit);
			}
		}
		return;
	}
	
}
