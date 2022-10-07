

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P016_BJ2023_신기한소수 {

	static StringBuilder sb = new StringBuilder(); // 출력하기 위함 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위함 
		
		int n = Integer.parseInt(br.readLine());
		
		dfs(0, n);

		System.out.println(sb);
	}
	
	static void dfs(int num, int n) {
		if (n == 0) { // 다 끝나면 종료 
			sb.append(num + "\n");
			return;
		}
		for (int i = 1; i < 10; i++) { // 한자리숫자
			if (n > 0 && isPrime(10 * num + i) ) { // num은 이미 체크를 했기 때문에 한 자리씩 더 올라가야해서 * 10 진행,
				dfs(10 * num + i, n - 1);
			}
		}
	}
	
	static boolean isPrime(int num) {
		if (num < 2) { // 0, 1은 소수가 아니다. 
			return false;
		}
		
		int sqrt = (int) Math.sqrt(num); // 소수는 1과 자기자신으로만 나누어지는 숫자이기 때문에 sqrt진행 
		
		for (int i = 2; i <= sqrt; i++) { // 소수 구하기 
			if (num % i == 0) { // num이 i의 배수면 소수가 아님
				return false;
			}
		}
		return true; // 소수가 아닌 것은 다 걸려졌으므로 for문과 if문을 빠져나온 것은 소수 
	}

}
