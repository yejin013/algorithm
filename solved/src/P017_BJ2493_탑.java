

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class P017_BJ2493_탑 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in); // 입력받기 위함 
		StringBuilder sb = new StringBuilder(); // 출력하기 위함 
		int n = sc.nextInt(); // 탑의 수 

		Stack<Integer[]> stack = new Stack<>(); // add, pop을 사용하기 위한 자료구조 
		
		for (int i = 1; i <= n; i++) { // 1부터 n까지! index가 1부터 시작하기 때문 
			int input = sc.nextInt(); // 탑의 높이 입력 받기 
			
			while (!stack.isEmpty()) { // stack이 비어있지 않다면 
				if (stack.peek()[1] > input) {
					sb.append(stack.peek()[0] + " "); // 남아있는 스택의 가장 상단 부분의 index 뽑기 
					break;
				}
				stack.pop(); // 더 작다면 그 다음 것을 확인해보기 위해 pop을 해야한다 
			}
			if(stack.isEmpty()) { // 스택이 비어 있다면 0 출력 
				sb.append(0 + " ");
			}
			stack.add(new Integer[] {i, input}); // 스택에 값 추가 
		}
		System.out.println(sb); // 출력 
	}

}
