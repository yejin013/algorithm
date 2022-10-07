

import java.util.Scanner;

public class P024_BJ2563_색종이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 입력받기 위함 
		
		// 1 * 1 넓이는 1임을 바탕으로 계산 
		int N = sc.nextInt(); // 색종이 수 
		int[][] map = new int[101][101]; // 판 넓이 
		int answer = 0; // 넓이 
		
		for (int i = 0; i < N; i++) { // 색종이 수 만큼 
			int x = sc.nextInt(); // 색종이 x좌표 
			int y = sc.nextInt(); // 색종이 y좌표 
			for (int j = x; j < x + 10; j++) { // x부터 x + 10까지 
				for (int k = y; k < y + 10; k++) { // y부터 y + 10까지 
					if (map[j][k] == 1) { // (x, y)가 이미 계산 되어 있을 경우 
						continue; 
					}
					// (x, y)가 계산되어 있지 않기 때문에 계산하고 1 
					answer++;
					map[j][k] = 1;
				}
			}
		}
		

		System.out.println(answer);
	}

}
