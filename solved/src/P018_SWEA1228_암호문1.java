

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P018_SWEA1228_암호문1 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in); // 입력 받기 위함 
		StringBuilder sb = new StringBuilder(); // 출력 하기 위함 
		
		for (int test_case = 1; test_case <= 10; test_case++) { // 10개의 케이스 
			int N = sc.nextInt(); // N : 원본 암호문의 길이 
			
			List<Integer> statm = new ArrayList<>(); // 명령어에 맞게 쉽게 삽입하기 위해 arraylist 사용 
			for (int i = 0; i < N; i++) { // 원본 암호문 입력 받기  
				statm.add(sc.nextInt());
			}
			
			int M = sc.nextInt(); // 명령어의 개수 

			for (int i = 0; i < M; i++) { // 명령어의 개수만큼 for문 돌기 
				String s = sc.next(); // I를 받기 위함 
				if ("I".equals(s)) { // I 일 경우, 
					int index = sc.nextInt(); // 수정할 암호문 위치 받기 
					int n = sc.nextInt(); // 추가할 암호문의 개수 
					for (int j = 0; j < n; j++) { // n의 수만큼 암호문 개수 받고, index에 값 추가 
						statm.add(index + j, sc.nextInt());
					}
				}
			}
			
			sb.append("#" + test_case + " "); // 출력 
			for (int i = 0; i < 10; i++) { // 10개만 출력 
				sb.append(statm.get(i) + " ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

}
