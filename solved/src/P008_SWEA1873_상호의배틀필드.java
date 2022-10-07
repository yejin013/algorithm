

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P008_SWEA1873_상호의배틀필드 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력 위함		
		StringBuilder sb = new StringBuilder(); // 출력 위함 
		
		int T = Integer.parseInt(reader.readLine()); // test_case
		
		for (int test_case = 1; test_case <= T; test_case++) { // test_case 만큼 반복 
			// H와 W 입력 받기 
			String[] HW = reader.readLine().split(" ");
			int H = Integer.parseInt(HW[0]);
			int W = Integer.parseInt(HW[1]);
			
			String[] answer = new String[H]; // test_case 별 답을 저장하기 위한 배열
			String[][] arr = new String[H][]; // 게임맵 저장을 위한 배열
			int curX = -1; // 현재 위치의 x 좌표
			int curY = -1; // 현재 위치의 y 좌표
			int direction = -1; // 0: 상, 1: 하, 2: 좌, 3: 우
			
			for (int i = 0; i < H; i++) {
				String read = reader.readLine(); // 한 줄씩 게임맵 입력
				arr[i] = read.split(""); // 게임맵 저장
				
				// 시작 위치를 저장하기 위함
				if (read.contains("^") || read.contains("v") || read.contains("<") || read.contains(">")) { // 한줄짜리 문자열에 ^v<>이 있다면?
					curX = i; // x 좌표 저장
					
					for (int j = 0; j < W; j++) { // y 좌표 저장하기 위함 
						if (arr[i][j].equals("^")) {
							direction = 0;
							curY = j;
						} else if (arr[i][j].equals("v")) {
							direction = 1;
							curY = j;
						} else if (arr[i][j].equals("<")) {
							direction = 2;
							curY = j;
						} else if (arr[i][j].equals(">")) {
							direction = 3;
							curY = j;
						}
					}
				}
			}
			arr[curX][curY] = "."; // 현재 위치를 알았으니 평지로 변경 
			
			int N = Integer.parseInt(reader.readLine()); // N 입력
			String[] nArr = reader.readLine().split(""); // 명령어 입력

			for (int i = 0; i < N; i++) {
				String action = nArr[i]; // 어떤 명령 입력값인지 하나씩 확인 및 수행하기 위함
				switch(action) { // 명령 입력값에 따른 수행
				case "U": // 위
					if (curX - 1 >= 0) { // 게임맵 밖으로 나가지 않는다면
						if (arr[curX - 1][curY].equals(".")) { // 평지를 만나면 이동
							curX--;
						}
					}
					direction = 0;
					break;
				case "D": // 아래
					if (curX + 1 < H) { // 게임맵 밖으로 나가지 않는다면
						if (arr[curX + 1][curY].equals(".")) { // 평지를 만나면 이동
							curX++;
						}
					}
					direction = 1;
					break;
				case "L": // 좌
					if (curY - 1 >= 0) { // 게임맵 밖으로 나가지 않는다면
						if (arr[curX][curY - 1].equals(".")) { // 평지를 만나면 이동
							curY--;
						}
					}
					direction = 2;
					break;
				case "R": // 우
					if (curY + 1 < W) { // 게임맵 밖으로 나가지 않는다면
						if (arr[curX][curY + 1].equals(".")) { // 평지를 만나면 이동
							curY++;
						}
					}
					direction = 3;
					break;
				case "S": // 포탄발사
					switch(direction) {
					case 0: // 상
						for (int j = curX; j >= 0; j--) { // 벽을 만날 때까지 위로 이동
							if (arr[j][curY].equals("*")) { // 벽돌로 만든 벽을 만날 경우 평지로 만들고, 다음 작업 수행
								arr[j][curY] = ".";
								break;
							} else if (arr[j][curY].equals("#")) { // 강철로 만든 벽을 만날 경우 더 이상 이동하지 않음
								break;
							}
						}
						break;
					case 1: // 하
						for (int j = curX; j < H; j++) { // 벽을 만날 때까지 아래로 이동
							if (arr[j][curY].equals("*")) { // 벽돌로 만든 벽을 만날 경우 평지로 만들고, 다음 작업 수행
								arr[j][curY] = ".";
								break;
							} else if (arr[j][curY].equals("#")) { // 강철로 만든 벽을 만날 경우 더 이상 이동하지 않음
								break;
							}
						}
						break;
					case 2: // 좌
						for (int j = curY; j >= 0; j--) { // 벽을 만날 때까지 좌측으로 이동
							if (arr[curX][j].equals("*")) { // 벽돌로 만든 벽을 만날 경우 평지로 만들고, 다음 작업 수행
								arr[curX][j] = ".";
								break;
							} else if (arr[curX][j].equals("#")) { // 강철로 만든 벽을 만날 경우 더 이상 이동하지 않음
								break;
							}
						}
						break;
					case 3: // 우
						for (int j = curY; j < W; j++) { // 벽을 만날 때까지 우측으로 이동
							if (arr[curX][j].equals("*")) { // 벽돌로 만든 벽을 만날 경우 평지로 만들고, 다음 작업 수행
								arr[curX][j] = ".";
								break;
							} else if (arr[curX][j].equals("#")) { // 강철로 만든 벽을 만날 경우 더 이상 이동하지 않음
								break;
							}
						}
						break;
					}
					break;
				}
			}
			
			switch(direction) { // 현 위치에 현재 바라보고 있는 값 저장
			case 0: // 상
				arr[curX][curY] = "^";
				break;
			case 1: // 하
				arr[curX][curY] = "v";
				break;
			case 2: // 좌
				arr[curX][curY] = "<";
				break;
			case 3: // 우
				arr[curX][curY] = ">";
				break;
			}
			
			for (int i = 0; i < H; i++) { // 한 줄씩 배열을 문자열로 변환
				answer[i] = String.join("", arr[i]);
			}
			
			// 출력
			sb.append("#" + test_case + " ");
			for (int i = 0; i < answer.length; i++) {
				sb.append(answer[i] + "\n");
			}
		}
		System.out.println(sb);
	}

}
