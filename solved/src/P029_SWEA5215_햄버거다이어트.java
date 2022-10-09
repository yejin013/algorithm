import java.util.Scanner;

// dfs
public class P029_SWEA5215_햄버거다이어트 {

	static int N;
	static int L;
	static int[] arrT;
	static int[] arrK;
	
	static int tMax;
	
	public static void dfs(int index, int tasty, int kcal) {
		
		if (kcal > L) { // 칼로리를 넘겼을 경우 
			return;
		}
		
		if (index == N) { // 리프노드에 도착했을 경우 
			if (tasty > tMax) { // 맛 점수 비교 
				tMax = tasty;
			}
			return;
		}
		
		// 원소 선택 
		dfs(index + 1, tasty + arrT[index], kcal + arrK[index]);
		
		// 원소 미선택 
		dfs(index + 1, tasty, kcal);
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			L = sc.nextInt(); // 칼로리 
			tMax = 0;
			
			arrT = new int[N]; // 점수 
			arrK = new int[N];
			for (int n = 0; n < N; n++) {
				arrT[n] = sc.nextInt();
				arrK[n] = sc.nextInt();
			}
			
			// 부분 집합
			
			dfs(0, 0, 0); // index, 맛 (T), 칼로리 (L) 
			
			System.out.println("#" + t + " " + tMax); // 출력 
		}
	}

}
