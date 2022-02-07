package hw_20220207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Baek_2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());

		Stack<int[]> s = new Stack<>();

		for (int i = 0; i < N; i++) {
			int[] arr = {Integer.parseInt(st.nextToken()), i + 1}; //스택에 인덱스 저장하기 위해 int 배열

			while (!s.isEmpty()) {

				if (s.peek()[0] < arr[0]) { //top보다 크면 top은 앞으로 수신받을 수 없음.. 그니까 pop
					s.pop();
				} else {
					System.out.print(s.peek()[1]+" "); //top보다 작으면 top이 수신 받는다는 뜻
					break;
				}
			}
			if(s.isEmpty()) {//스택이 비어있으면 앞에 아무것도 없다는 뜻이므로 0출력
				System.out.print("0 ");
			}
			s.push(arr);
		}
	}
}
