

import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P032_BJ15686치킨배달 {
	
	static int M;
	static int chickenNum;
	static int[] numbers;
	static List<int[]> house;
	static List<int[]> chicken;
	static int answer;
	
	static void comb(int cnt, int start) { // 치킨 조합 찾기 
		if (cnt == M) {
			int sumMin = 0;
			for (int i = 0; i < house.size(); i++) { // 집
				int min = Integer.MAX_VALUE; // 각 치킨집마다 최소값 구하기 

				for (int j = 0; j < M; j++) { // 뽑은 치킨집만큼 
					int abs = Math.abs(chicken.get(numbers[j])[0] - house.get(i)[0]) + Math.abs(chicken.get(numbers[j])[1] - house.get(i)[1]);
					if (abs < min) { // 작은 값으로 업데이트 
						min = abs;
					}
				}
				sumMin += min; // 집마다 치킨집 거리를 더하는 거
			}
			
			answer = sumMin < answer ? sumMin : answer; // 조합끼리 비교해서 최소값을 답으로 
			return;
		}
		
		for (int i = start; i < chickenNum; i++) { // nCr에서 n개까지 for문 돌기 
			numbers[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]); // 배열 줄 수 
		M = Integer.parseInt(s[1]); // 뽑아야하는 치킨 집 수
		house = new ArrayList<>(); //집 배열 
		chicken = new ArrayList<>(); // 치킨 배열
		answer = Integer.MAX_VALUE; // 답
		
		for (int i = 0; i < N; i++) { // 입력받기 
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(line[j]);
				if (num == 1) house.add(new int[] {i, j}); // 집이면 넣기 
				else if (num == 2) chicken.add(new int[] {i, j}); // 치킨집이면 넣기 
			}
		}
		
		chickenNum = chicken.size(); // nCr에서 n
		numbers = new int[M]; // 조합 배열 초기화 
		
		comb(0, 0);

		System.out.println(answer);
	}
}
