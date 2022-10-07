

import java.util.Scanner;

public class P023_SWEA1861_정사각형방 {

	static int[][] room;
	static int count;
	static final int[] dx = {-1, 1, 0, 0}; // 상하좌우 
	static final int[] dy = {0, 0, -1, 1}; // 상하좌우 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int TC = sc.nextInt();
		
		for (int test_case = 1; test_case <= TC; test_case++) {
		
			int start = 0; // 처음에 출발해야 하는 방 번호 
			int max = 0; // 최대 몇 개의 방 
			
			int N = sc.nextInt(); // N^2의 방에서 N 입력 받기 
			room = new int[N][N]; // N^2의 방 
			
			for (int i = 0; i < N; i++) { // n * n 입력 받기 
				for (int j = 0; j < N; j++) {
					room[i][j] = sc.nextInt();
				}
 			}
			
			for (int i = 0; i < N; i++) { // n * n 탐색 
				for (int j = 0; j < N; j++) {
					count = 1; // 본인 방 
					function(i, j);
					
					if (max < count) { // 기존의 Max 값보다 계산 결과 값이 더 크다면 업데이트 
						start = room[i][j];
						max = count;
					} else if (max == count) { // 계산 결과 값이 같을 경우 방의 값이 더 작은 것이 시작점  
						start = (start < room[i][j]) ? start : room[i][j];
					}
				}
			}
			
			sb.append("#" + test_case + " " + start +  " " + max + "\n"); // 출력 
		}
		
		System.out.println(sb);
	}
	
	public static void function(int x, int y) {	// 상하좌우 탐색 
		for(int d = 0; d < 4; d++) {
			int nx = dx[d] + x;
			int ny = dy[d] + y;
			if(nx >= 0 && nx < room.length && ny >= 0 && ny < room.length) { // 범위 내에 있으면 
				if (room[nx][ny] == room[x][y] + 1) {
					count++; // 계산 업데이트 
					function(nx, ny); // 새로운 지점에서 탐색 
				}
			}
		}
	}
	
}
