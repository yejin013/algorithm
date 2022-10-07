

import java.util.Scanner;

public class P051_SWEA3289_서로소집합 {

	static int n;
	static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			StringBuilder answer = new StringBuilder();
			
			n = sc.nextInt(); // n 개의 집합
			int m = sc.nextInt(); // 입력으로 주어지는 연산의 개수
			
			make(); // 서로소 집합 생성 
			
			for (int i = 0; i < m; i++) {
				int value = sc.nextInt(); // 0은 union의 의미, 1은 포함되어 있는지 확인하는 연산 
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if (value == 0) { // 0일 때
					union(a, b); // 집합 합치기 
				} else { // 1일 때 - 같은 부모인지 확인 
					if (check(a, b)) answer.append(1);
					else answer.append(0);
				}
			}
			
			sb.append("#" + t + " " + answer + "\n");
		}
		
		System.out.println(sb);
	}

	static void make() {
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int a) { // a의 대표자 찾기 
		if (parent[a] == a) return a;
		return parent[a] = find(parent[a]); // 우리의 대표자를 나의 부모로.. : path compression 
	}
	
	static void union(int a, int b) { // 집합 합치기 
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return;
		
		parent[bRoot] = aRoot;
	}
	
	static boolean check(int a, int b) { // 같은 부모인지 확인 
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return true;
		
		return false;
	}
}
