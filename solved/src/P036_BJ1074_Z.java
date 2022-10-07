

import java.util.Scanner;

public class P036_BJ1074_Z {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		int answer = 0;
		
		while(N >= 1) { // N이 1보다 클 때 
			int size = (int) Math.pow(2, N); // N
			int	area = (int) Math.pow(2, 2 * N); // 넓이 
			
			if (r < size / 2 && c < size / 2) { // 1사분면 
				answer += area / 4 * 0;
			} else if (r < size / 2 && c >= size / 2) { // 2사분면 
				answer += area / 4 * 1;
				c -= size / 2;
			} else if (r >= size / 2 && c < size / 2) { // 3사분면 
				answer += area / 4 * 2;
				r -= size / 2;
			} else if (r >= size / 2 && c >= size / 2) { // 4사분면 
				answer += area / 4 * 3;
				r -= size / 2;
				c -= size / 2;
			}
			
			N--;
		}
		
		System.out.println(answer);
	}

}
