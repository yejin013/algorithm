import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// dfs
public class P072_BJ2239_스도쿠 {

	static int[][] arr;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9][9];
		
		// 입력받기
		for (int i = 0; i < 9; i++) {
			arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		flag = false;
		dfs(0, 0);
		
		// 출력 
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int row, int col) {

		if (flag) return; // 현재 위치에서 끊기 
		
		if (col == 9) { // 9열까지 갔을 경우 
			dfs(row + 1, 0); // 다음 행으로 이동 
			return;
		}
		
		if (row == 9) { // 9행 9열까지 탐색한 경우 
			flag = true;
			return;
		}
		
		if (arr[row][col] == 0) { // 값을 넣어야 함
			for (int i = 1; i <= 9; i++) {
				if (check(row, col, i)) { // 겹치지 않는다면 
					arr[row][col] = i;
					dfs(row, col + 1); // 다음 행으로 이동 
				}
			}
			
			if (flag) return; // 다 탐색했으면 더 이상 탐색하지 않음 
			
			arr[row][col] = 0; // 다음 숫자 넣기 위함. 기존에 넣었던 값이 틀릴 수 있으니까. 
			return;
		}
		
		dfs(row, col + 1); // 숫자가 있으면 그 다음으로 이동 
	}

	static boolean check(int row, int col, int value) {
		for (int c = 0; c < 9; c++) { // 한 행 확인
			if (value == arr[row][c]) return false;
		}

		for (int r = 0; r < 9; r++) { // 한 열 확인 
			if (value == arr[r][col]) return false;
		}

		// row와 col의 시작점 
		int nRow = (row / 3) * 3;
		int nCol = (col / 3) * 3;
				
		for (int r = nRow; r < nRow + 3; r++) { // 3*3 확인 
			for (int c = nCol; c < nCol + 3; c++) {
				if (value == arr[r][c]) {
					return false;
				}
			}
		}
		
		return true;
	}
}
