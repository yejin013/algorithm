

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P021_SWEA1233_사칙연산유효성검사 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기 위함 
		StringBuilder sb = new StringBuilder(); // 출력하기 위함 
		
		for (int test_case = 1; test_case <= 10; test_case++) { // test case만큼 반복 
			int n = Integer.parseInt(br.readLine()); // 총 노드 수 
			int answer = 1; // 유효성 있음을 기반으로 함 
			for (int i = 0; i < n; i++) { // 총 노드 수 만큼 입력 받으면서 처리 
				String[] input = br.readLine().split(" "); // 입력 받기 
				if (input.length >= 3) { // 왼쪽 노드, 오른쪽 노드가 있을 경우 
					if (Character.isDigit(input[1].charAt(0))) { // 정점 (루트)가 연산자가 아니면 제대로 된 연산 불가능  
						answer = 0;
					}
				}
			}
			sb.append("#" + test_case + " " + answer + "\n"); // 출력 
		}
		
		System.out.println(sb);
	}
}
