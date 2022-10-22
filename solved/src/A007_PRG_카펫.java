import java.util.Arrays;

public class A007_PRG_카펫 {

	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2]; // 카펫 가로, 세로 
		
		int total = brown + yellow;
		for (int row = 3; row <= Math.sqrt(total); row++) { 
			int col = total / row; // 작은 수부터 하니까

			if ((col - 2) * (row - 2) == yellow) {
				answer[0] = col;
				answer[1] = row;
				break;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10, 2)));
		System.out.println(Arrays.toString(solution(8, 1)));
		System.out.println(Arrays.toString(solution(24, 24)));
	}

}
