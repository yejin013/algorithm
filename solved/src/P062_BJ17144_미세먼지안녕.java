

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P062_BJ17144_미세먼지안녕 {

	static int R, C;
	static int[][] map;
	
	static int[] dx = {-1, 1, 0, 0}; // 상하좌우 
	static int[] dy = {0, 0, -1, 1};
	
	static void pollution() {
		int[][] temp = new int[R][C];
		
		// 인접한 네 방향으로 확산 
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == -1) {
					temp[r][c] = -1;
					continue;
				}
				if (map[r][c] > 0) {
					int count = 0;
					for (int d = 0; d < 4; d++) { // 방향 확인 
						int nx = r + dx[d];
						int ny = c + dy[d];
						if (nx < 0 ||ny < 0 || nx >= R || ny >= C) continue;
						
						if (map[nx][ny] == -1) continue;
						temp[nx][ny] += map[r][c] / 5; // 확산된 미세먼지를 복사된 곳에 넣기 
						count++;
					}
					temp[r][c] += map[r][c] - (map[r][c] / 5) * count; 
				}
			}
		}
		
		map = temp;
	}
	
	static void refreshAir(int upX, int upY) { // 바람의 방향대로 모두 한 칸씩 이동, 공기청정기로 들어간 미세먼지는 모두 정화된다.
		
		// 위쪽 공기청정기 
		// 아래로 이동
		for (int down = upX - 1; down > 0; down--) {
			map[down][0] = map[down - 1][0];
		}
		
		// 왼쪽으로 이동 
		for (int left = 0; left < C - 1; left++) {
			map[0][left] = map[0][left + 1];
		}
		
		// 위로 이동
		for (int up = 0; up < upX; up++) {
			map[up][C - 1] = map[up + 1][C - 1];
		}
		
		// 오른쪽으로 이동
		for (int right = C - 1; right > 1; right--) {
			map[upX][right] = map[upX][right - 1];
		}
		map[upX][1] = 0;
		
		// 아래쪽 공기청정기
		
		int bottomX = upX + 1;

		// 위로 이동
		for (int up = bottomX + 1; up < R - 1; up++) {
			map[up][0] = map[up + 1][0];
		}
		
		// 왼쪽으로 이동 
		for (int left = 0; left < C - 1; left++) {
			map[R - 1][left] = map[R - 1][left + 1];
		}	
		
		// 아래로 이동
		for (int down = R - 1; down > bottomX; down--) {
			map[down][C - 1] = map[down - 1][C - 1];
		}

		// 오른쪽으로 이동
		for (int right = C - 1; right > 1; right--) {
			map[bottomX][right] = map[bottomX][right - 1];
		}
		map[bottomX][1] = 0;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		int T = Integer.parseInt(input[2]);
		
		map = new int[R][C];
		// 공기청정기가 설치된 곳  x, y 좌표 
		int aX = -1;
		int aY = -1;
		for (int r = 0; r < R; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(input[c]);
				
				if (map[r][c] == -1 && aX == -1 && aY == -1) { // 공기청정기 시작 위치 저장 - 가장 윗 행과 아랫행과 두 칸이상 떨어져있음
					aX = r;
					aY = c;
				}
			}
		}
		
		for (int t = 0; t < T; t++) {
			// 미세먼지 확산
			pollution();
			
			// 공기청정기 작동
			refreshAir(aX, aY);
		}

		// 계산
		int sum = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] > 0) sum += map[r][c];
			}
		}
		
		System.out.println(sum);
	}

}
