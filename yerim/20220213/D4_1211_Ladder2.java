package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1211_Ladder2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        for (int tc = 1; tc <= 10; tc++) {
            int T = Integer.parseInt(br.readLine());
            int[][] map = new int[100][100];
            int min = 987654321, min_idx = 0;
 
            // 입력
            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            for (int i = 0; i < map.length; i++) {
                int cnt = 0;
                int a = i;
                // 맨위에가 1이면 탐색 시작
                if (map[0][i] == 1) {                   
                    // 쭉 내려가기
                    for (int j = 0; j < 100; j++) {
                        // 좌
                        if(a - 1 >= 0 && map[j][a - 1] == 1) {
                            while (a - 1 >= 0 && map[j][a - 1] == 1) {
                                cnt++;
                                a--;
                            }
                        }
                        // 우
                        else if(a + 1 < 100 && map[j][a + 1] == 1) {
                            while (a + 1 < 100 && map[j][a + 1] == 1) {
                                cnt++;
                                a++;
                            }
                        }                       
                        cnt++;
                    }
                    if(cnt <= min) {
                        min = cnt;
                        min_idx = i;
                    }   
                }
            }
            System.out.printf("#%d %d\n", tc, min_idx);
        }
    }

}
