

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P005_SWEA1210_Ladder1 {
	
	static int[][] arr = new int[100][]; // 100 * 100 배열 
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 버퍼리더

		for (int tc = 1; tc <= 10; tc++) { // test_case 횟수만큼 반복 
			int num = Integer.parseInt(in.readLine()); // 덤프 횟수 입력
			
			int start = -1;
			for (int i = 0; i < 100; i++) { // 입력 받기 
				String input = in.readLine(); // 한 줄 받기 
				int[] newArr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray(); // String 배열을 int 배열로 변환
				arr[i] = newArr;
			}
			
			start = function(start);
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + num + " " + start);
			System.out.println(sb);
		}
	}
		
	public static int function(int start) { // 이중 for문 탈출하기 위해 함수로 정의 
		for (int i = 0; i < 100; i++) { // column 100
			if (arr[0][i] == 1) { // 1일 경우 실행
				int x = i;
				int y = 0;
				int dx = 0; // x 방향
				int dy = 1; // y 방향 

				while (true) {
					if (y == arr.length - 1) { // 끝에 도달했을 때.
						if (arr[y][x] == 2) {
							start = i; 
							return start;
						}
						break; // 1이 아니면 다음 column으로 이동 
					}
					
					if (x + dx < 0 || x + dx > (arr.length - 1) || arr[y + dy][x + dx] == 0) { // 끝에 도달했거나 다음 이동하려고 하는 곳이 0일 때 (보통 dx가 1이거나 -1일 때)
						dx = 0;
						dy = 1; // 아래로 내려감 
					} else if (dx == 0 && x + 1 < arr.length && arr[y][x + 1] == 1) { // 오른쪽으로 이동하기 위한 조건
						dx = 1;
						dy = 0;
					} else if (dx == 0 && x - 1 >= 0 && arr[y][x - 1] == 1) { // 왼쪽으로 이동하기 위한 조건 
						dx = -1;
						dy = 0;
					}

					x += dx;
					y += dy;
				}
			}
		}
		return start;
	}
}
