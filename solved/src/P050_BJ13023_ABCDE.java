

import java.util.ArrayList;
import java.util.Scanner;

public class P050_BJ13023_ABCDE {

	static int N, M;
	static ArrayList<Integer>[] relations;
	static boolean[] visited;
	
	static void dfs(int depth, int idx) {
		
		if (depth == 4) { // depth 끝났을 경우
			System.out.println(1);
			System.exit(0);
		}
		
		for (int i: relations[idx]) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(depth + 1, i);
			}
		}
		visited[idx] = false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 사람의 수 
		M = sc.nextInt(); // 친구 관계의 수 
		
		relations = new ArrayList[N];
		for (int i = 0; i < N; i++) { // relations 초기화 
			relations[i] = new ArrayList<>();
		}
		
		for(int m = 0; m < M; m++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			// 양방향 추가 
			relations[a].add(b);
			relations[b].add(a);
		}
		
		visited = new boolean[N];
		
		for (int n = 0; n < N; n++) {
			visited[n] = true;
			dfs(0, n);
			visited[n] = false;
		}
		
		System.out.println(0);
	}
}
