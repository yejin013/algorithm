import java.util.Scanner;

public class A003_BJ16463_13일의_금요일 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 입력 위함 
		int N = sc.nextInt(); // 연도 
		
		int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 배열 1번부터 1월 
		
		// 2019년부터 N년까지의 13일의 금요일 수 
		int answer = 0; // 답 
		int date = 13; // 13일 
		
		for (int year = 2019; year <= N; year++) { // 연도 
			for (int month = 1; month <= 12; month++) { // 월 
				if(date % 7 == 4) answer++;// 13일의 금요일인지 - 화요일부터 시작이기 때문에 4 
				date += days[month]; // 다음달 13일 업데이트 
				if (month == 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) date++; // 윤년마다 + 1
			}
		}
		
		System.out.println(answer); // 출력 
	}

}
