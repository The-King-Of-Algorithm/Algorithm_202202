package Solution;

//셀프넘버
public class Baek_4673 {
	public static void main(String[] args) {

		boolean[] notself = new boolean[10001];

		for (int i = 1; i < notself.length; i++) {
			int num = check(i);
			if (num <= 10000) {
				notself[num] = true;
			}
		}
		
		for (int i = 1; i < notself.length; i++) {
			if(!notself[i]) {
				System.out.println(i);
			}
		}
	}

	private static int check(int n) {
		int sum = n;
		while (n != 0) {
			sum += n % 10;
			n = n / 10;
		}
		return sum;
	}
}

