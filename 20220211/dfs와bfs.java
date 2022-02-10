package problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dfs와bfs {
	
	static class edge{
		int start;
		int end;
		edge(int start,int end){
			this.start =start;
			this.end = end;
		}
	}
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("dfs와bfs.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		boolean visit[] = new boolean[n+1];
		int [][] arr= new int [n+1][n+1];
		for(int i= 0; i<m ; i++) {
			st = new StringTokenizer(bf.readLine());
			int sta = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[sta][end]=1;
			arr[end][sta]=1;
		}
		System.out.print(start+" ");
		visit[start]=true;
		dfs(arr,visit,start);
		
		visit = new boolean[n+1];
		System.out.println();
		bfs(arr,start,visit);
		
	}
	
	private static void dfs(int[][] arr, boolean[] visit, int start) {
		for(int i=1; i<arr[0].length ; i++) {
			if(!visit[i] && arr[start][i]==1) {
				visit[i] = true;
				System.out.print(i+" ");
				dfs(arr,visit,i);
			}
		}
	}
	
	private static void bfs(int[][] arr, int start,boolean[] visit) {
		Queue<edge> queue =new LinkedList<>();
		visit[start]=true;
		queue.add(new edge(0,start));
		while(!queue.isEmpty()) {
			int ed=queue.peek().end;
			System.out.print(ed+" ");
			queue.poll();
			for(int i=1; i<arr[0].length; i++) {
				if(!visit[i] &&arr[ed][i]==1) {
					visit[i]=true;
					queue.add(new edge(ed,i));
				}
			}
		}
	}
	
	
	
}
