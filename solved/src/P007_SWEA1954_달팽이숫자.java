import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 구현
public class P007_SWEA1954_달팽이숫자 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		
		int[] dr = {0, 1, 0, -1}; // 우 하 좌 상
		int[] dc = {1, 0, -1, 0}; // 우 하 좌 상
		
		for (int tc = 1; tc <= TC; tc++) {
			
			int n = Integer.parseInt(in.readLine()); // 덤프 횟수 입력
			
			int[][] snail = new int[n][n]; // 배열 변수 선언 
			for (int[] s : snail) Arrays.fill(s, 0); // 0으로 초기화 
			
			int r = 0; // row
			int c = 0; // column
			int dist = 0; // 0 : 우, 1 : 하, 2: 좌, 3: 상
			
			for (int i = 1; i < n * n + 1; i++) { // 달팽이 숫자
				snail[r][c] = i; // 현재 위치에 숫자 부여 
				r += dr[dist]; // row 이동
				c += dc[dist]; // column 이동
				
				if (r < 0 || c < 0 || r >= n || c >= n || snail[r][c] != 0) { // 끝에 도달했을 때 또는, 값이 이미 있을 때
					// 이전의 값으로 이동
					r -= dr[dist];
					c -= dc[dist];
					
					dist = (dist + 1) % 4; // 어느 방향으로 이동할지 
					
					// 새로운 이동 
					r += dr[dist];
					c += dc[dist];
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + "\n");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(snail[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
		}
	}

}
