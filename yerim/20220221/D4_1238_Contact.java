package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D4_1238_Contact {
	
	static class Node{
		int vertex; // 정점 번호
		Node link; // 다음 노드로의 연결 번호
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt(); // 입력받는 데이터의 길이
			int C = N / 2; // 간선 수
			int start = sc.nextInt(); // 시작 노드
			d = 0; result = 0;
			
			
			Node[] adjList = new Node[101];
			
			for (int i = 0; i < C; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				// 단방향 저장
				adjList[from] = new Node(to, adjList[from]);
			}
			
			bfs(adjList, start);
			System.out.printf("#%d %d\n", tc, result);
		}
	}
	
	static int cnt = 0, d, result;
	public static void bfs(Node[] adjList, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[adjList.length];
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			cnt++;
			int current = queue.poll();
			//System.out.println(current + " " + cnt);
			
			// current 정점의 인접정점 처리 (단, 방문하지않은 인접정점만)
			for(Node temp = adjList[current]; temp != null; temp = temp.link) {
				if(!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
					if(d < cnt) {
						d = cnt;
						result = temp.vertex;
					} else if(d == cnt) {
						result = Math.max(result, temp.vertex);
					}
				}
			}
		}
	}

}
