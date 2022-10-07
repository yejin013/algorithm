

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P022_SWEA6808_규영이와인영이의카드게임 {
	
	static int win;
	static int lose;
	static boolean[] cards;
	static int[] KY;
	
	static int[] ranIY;
	static int[] IY;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기 위함 
		StringBuilder sb = new StringBuilder(); // 출력하기 위함 
		
		int TC = Integer.parseInt(br.readLine()); // 테스트 케이스 횟수 
		
		for (int test_case = 1; test_case <= TC; test_case++) { // 테스트 케이스만큼 반복 
			
			// 값 초기화 
			win = 0;
			lose = 0;
			cards = new boolean[19];
			KY = new int[9];
			ranIY = new int[9];
			IY = new int[9];
			isSelected = new boolean[9];
			
			String[] str = br.readLine().split(" "); // 한 줄 입력받기 
			for (int i = 0; i < str.length; i++) { // 입력 받은 만큼 반복문 
				int card = Integer.parseInt(str[i]); // 숫자로 변환 
				cards[card] = true; // true, false로 이후에 인영의 카드 만들기 
				KY[i] = card; // 규영 카드 번호 
			}
			
			int num = 0; // 인영 배열 인덱스 
			for (int i = 1; i <= 18; i++) { // 18개의 카드 
				if (!cards[i]) { // 규영의 카드가 아니면 인영의 카드 번호 
					IY[num++] = i;
				}
			}
			permutation(0); // 인영의 카드 순열 
			sb.append("#" + test_case + " " + win + " " + lose + "\n"); // 출력 
		}
		
		System.out.println(sb);
	}
	
	public static void permutation(int cnt) { // 순열 
		if(cnt == 9) { // 배열 9까지 채웠을 때 
			int totalKY = 0; // 규영 합 
			int totalIY = 0; // 인영 합 
			for (int i = 0; i < 9; i++) { // 규영과 인영의 카드는 각각 9장 
				if (KY[i] > ranIY[i]) { // 규영이 이겼을 경우 
					totalKY += KY[i] + ranIY[i];
				} else if (KY[i] < ranIY[i]) { // 인영이 이겼을 경우 
					totalIY += KY[i] + ranIY[i];
				}
			}
			
			if (totalKY > totalIY) { // 규영의 총합이 이겼을 경우 
				win++;
			} else {
				lose++;
			}
			return;
		}
		// 가능한 모든 수에 대해 시도
		for (int i = 0; i < 9; i++) { // 선택지
			// 시도하는 수가 선택되었는지 판단 
			if (isSelected[i]) continue;
			// 선택되지 않았다면 수를 사용
			ranIY[cnt] = IY[i];
			isSelected[i] = true;
			// 다음 수 뽑으러 가기 
			permutation(cnt + 1);
			// 사용했던 수에 대한 선택 되돌리기 
			isSelected[i] = false;
		}
	}

}
