	package algo20220225;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.ArrayList;
	import java.util.StringTokenizer;
	
	public class 방배정 {
		public static void main(String[] args) throws IOException {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n  = Integer.parseInt(st.nextToken());
			int k  = Integer.parseInt(st.nextToken());
			ArrayList<Integer> ml = new ArrayList<>();
			ArrayList<Integer> ll = new ArrayList<>();
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(a==1) {
					ml.add(b);
				}
				else {
					ll.add(b);
				}
			}
			
			//System.out.println(ml.toString());
			int []arr = new int[7];
			for(int i =0; i<ml.size(); i++) {
				arr[ml.get(i)]++;
			}
			int ans = 0;
			for(int i =1; i<=6; i++) {
				if(arr[i]%k==0) {
					ans=ans+arr[i]/k;
				}
				else {
					ans=ans+(arr[i]/k)+1;
				}
			}
			
			//System.out.println(ll.toString());
			arr = new int[7];
			for(int i =0; i<ll.size(); i++) {
				arr[ll.get(i)]++;
			}
			for(int i =1; i<=6; i++) {
				if(arr[i]%k==0) {
					ans=ans+arr[i]/k;
				}
				else {
					ans=ans+(arr[i]/k)+1;
				}
			}
			System.out.println(ans);
		}
	}
