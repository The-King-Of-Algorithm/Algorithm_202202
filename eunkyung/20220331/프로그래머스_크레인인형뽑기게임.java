package day15;

import java.util.ArrayList;

public class 프로그래머스_크레인인형뽑기게임 {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(solution(board, moves));
	}
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		for (int i = 0; i < moves.length; i++) {
			int n = 0;
			for (int j = 0; j < board.length; j++) {
				if (board[j][moves[i] - 1] != 0) {
					n = board[j][moves[i] - 1];
					board[j][moves[i] - 1] = 0;
					break;
				}
			}
			if (n != 0) {
				if (tmp.size() != 0 && tmp.get(tmp.size() - 1) == n) {
					tmp.remove(tmp.size() - 1);
					answer += 2;
				} else {
					tmp.add(n);
				}
			}
		}
		return answer;
	}
}
