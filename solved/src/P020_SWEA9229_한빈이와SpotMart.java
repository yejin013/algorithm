import java.util.Scanner;

// 기초 문제
public class P020_SWEA9229_한빈이와SpotMart {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in); // 입력받기 위함 
		StringBuilder sb = new StringBuilder(); // 출력하기 위함 
		
		int TC = sc.nextInt(); //  테스트 케이스 
		
		for (int test_case = 1; test_case <= TC; test_case++) { // 테스트 케이스만큼 for문 돌리기 
			int N = sc.nextInt(); // N : 과자 개수 
			int M = sc.nextInt(); // M : 최대 과자 봉지 무게 합 
			
			int[] a = new int[N]; // 과자 봉지 무게 
			for (int i = 0; i < N; i++) { // 과자 봉지 무게 입력 받기 
				a[i] = sc.nextInt();
			}
			
			int answer = -1; // 해당 되는 거 없으면 -1
			for (int i = 0; i < N; i++) { // 과자 봉지 개수만큼 for문 완전 탐색 
				for (int j = 0; j < N; j++) {
					if (i == j) continue; // 같은 배열번호를 가리키면 다음 단계 진행 
					if (a[i] + a[j] <= M) { //  두 봉지의 무게 더해서 M 보다 작으면 max 구함 
						answer = Math.max(a[i] + a[j], answer);
					}
				}
			}
			
			sb.append("#" + test_case + " " + answer + "\n"); // 출력 
		}
		System.out.print(sb);
	}

}
