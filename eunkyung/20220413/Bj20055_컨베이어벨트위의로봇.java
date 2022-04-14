package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj20055_컨베이어벨트위의로봇 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int[] robot = new int[N];
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < 2 * N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int level = 0;
		while (true) {
			// 1번 회전
			list.add(0, list.get(list.size() - 1));
			list.remove(list.size() - 1);
			for (int i = N - 1; i >= 1; i--) {
				robot[i] = robot[i - 1];
			}
			robot[0] = 0;
			
			// 2번 로봇이동
			robot[N - 1] = 0;
			for (int i = robot.length - 2; i >= 0; i--) {
				if (list.get(i + 1) >= 1 && robot[i] != 0 && robot[i + 1] == 0) {
					list.set(i + 1, list.get(i + 1) - 1);
					robot[i] = 0;
					robot[i + 1] = 1;
				}
			}
			// 3번 로봇 올리기
			if (list.get(0) != 0) {
				list.set(0, list.get(0) - 1);
				robot[0] = 1;
			}
			level++;
			// 갯수
			int cnt = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) == 0)
					cnt++;
			}
			if (cnt >= K) break;
		}
		System.out.println(level);
	}
}
