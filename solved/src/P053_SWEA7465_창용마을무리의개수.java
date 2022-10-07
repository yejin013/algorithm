

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P053_SWEA7465_창용마을무리의개수 {

	static int N;
	static int M;
	
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			String[] s = br.readLine().split(" ");
			
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			
			make(); // 서로소 집합 생성 
			for (int m = 0; m < M; m++) {
				s = br.readLine().split(" ");
				
				int A = Integer.parseInt(s[0]);
				int B = Integer.parseInt(s[1]);
				
				union(A, B); // 집합 합치기 
			}

			int answer = 0;
			for (int i = 1; i <= N; i++) {
				if (find(i) == i) // 부모가 본인일 경우 
					answer++;
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}
	
	static int find(int a) { // a의 대표자 찾기 
		if (parent[a] == a) return a;
		return parent[a] = find(parent[a]); // 우리의 대표자를 나의 부모로.. : path compression 
	}
	

	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return;
		
		parent[bRoot] = aRoot;
	}
	
	static void make() {
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}
}