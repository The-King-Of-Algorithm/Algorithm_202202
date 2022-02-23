package IMTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 참외밭 {
	static int[] dr = {0,0,0,1,-1};
	static int[] dc = {0,1,-1,0,0};
 
	static class Cham {
		int dir;
		int len;
		
		public Cham(int dir, int len) {
			super();
			this.dir = dir;
			this.len = len;
		}
		
		@Override
		public String toString() {
			return "Cham [dir=" + dir + ", len=" + len + "]";
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("참외밭.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Cham[] cham = new Cham[6];
		
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cham[i] = new Cham(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int maxw=0;
		int maxwidx=0;
		int maxh=0;
		int maxhidx=0;
		
		for (int i = 0; i < cham.length; i++) {
			if (cham[i].dir == 3 || cham[i].dir == 4) {
				if (cham[i].len > maxh) {
					maxh = cham[i].len;
					maxhidx=i;
				}
			}
			if (cham[i].dir == 1 || cham[i].dir == 2) {
				if (cham[i].len > maxw) {
					maxw = cham[i].len;
					maxwidx=i;
				}
			}
		}
		System.out.println("maxh:"+maxh+" maxw:"+maxw);
		int minw=0;
		int minwidx=0;
		int minh=0;
		int minhidx=0;
		
		if (cham[(maxwidx+1)%6].len != maxh) {
			minh = cham[(maxwidx+3)%6].len;
			minw = cham[(maxwidx+2)%6].len;
		}
		if (cham[(maxwidx+1)%6].len == maxh) {
			minh = cham[(maxwidx+3)%6].len;
			minw = cham[(maxwidx+4)%6].len;
		}
		//System.out.println("minh:"+minh+" minw:"+minw);
		System.out.println(N*((maxh*maxw)-(minh*minw)));
		
	}

}
