import java.util.Scanner;

// dfs
public class P030_BJ2961_도영이가만든맛있는음식 {

	static int N;
	static int[] S;
	static int[] B;
	static int min;
	
	static void dfs(int index, int totalS, int totalB) {
		if (index == N) {
			
			if (totalS == 1 && totalB == 0) { // 아무것도 선택 안 한 것을 제거 
				return;
			}
			
			min = Math.min(min, Math.abs(totalB - totalS)); // 가장 차이가 작은 값으로 
			return;
		}
		
		dfs(index + 1, totalS * S[index], totalB + B[index]); // 왼쪽 자식 탐색 
		dfs(index + 1, totalS, totalB); // 오른쪽 자식 탐색 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		// static 변수 초기화 
		S = new int[N];
		B = new int[N];
		
		min = Integer.MAX_VALUE; // 가장 차이가 작은 요리를 만들어야 해서. 
		
		for(int n = 0; n < N; n++) { // 입력받기 
			S[n] = sc.nextInt();
			B[n] = sc.nextInt();
		}
		
		dfs(0, 1, 0);
		
		System.out.println(min);
	}

}
