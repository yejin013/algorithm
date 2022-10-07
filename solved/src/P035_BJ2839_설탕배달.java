

import java.util.Scanner;

public class P035_BJ2839_설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int answer = 0; // 봉지 
		
		while(true) {
			if (N % 5 == 0) { // 5로 나눠지면 나누기 
				answer += N / 5; // 5로 나눈 몫 
				break;
			}
			
			N -= 3; // 3으로 빼기 
			answer++; // 봉지 하나 추가 
			
			if (N < 0) { // 0보다 작아지면
				answer = -1;
				break;
			}
		}
		
		System.out.println(answer);
	}

}
