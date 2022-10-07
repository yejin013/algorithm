

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class P012_SWEA1218_괄호짝짓기 {

	static int N; // 입력받은 문자 개수 
	static int check; // 유효 검사 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위함 
		StringBuilder sb = new StringBuilder(); // 출력하기 위함
		
		for (int test_case = 1; test_case <= 10; test_case++) { // test_case만큼 반복 
			
			check = 0; // 유효하지 않다를 default로 
			N = Integer.parseInt(br.readLine()); // 괄호 개수  
		
			
			String[] st = br.readLine().split(""); // 괄호 입력 받고 문자배열로 변경 
			
			function(st); // 괄호 유효 검사 
			
			
			sb.append("#" + test_case + " " + check + "\n");
		}
		
		System.out.println(sb);
	}

	// 함수로 처리한 이유 : switch를 쓰면서 for문의 break가 case 안에서 되지 않아 return을 사용하기 위해서 
	static void function(String[] st) {
		Stack<String> stack1 = new Stack<>(); // () 
		Stack<String> stack2 = new Stack<>(); // []
		Stack<String> stack3 = new Stack<>(); // {}
		Stack<String> stack4 = new Stack<>(); // <>
		
		for (int i = 0; i < N; i++) { // 괄호 개수만큼 for문 돌기 
			switch(st[i]) { // 괄호 
			case "(":
				stack1.add(st[i]); // 짝을 찾기 위해 스택에 저장 
				break;
			case ")":
				if(stack1.isEmpty()) { // 짝이 없다는 의미 
					return; 
				} 
				stack1.pop(); // 짝이 있을 경우, 짝이 만들어졌으니 스택에서 빼기 
				break;
			case "[":
				stack2.add(st[i]);
				break;
			case "]":
				if(stack2.isEmpty()) { 
					return;
				}
				stack2.pop();
				break;
			case "{":
				stack3.add(st[i]);
				break;
			case "}":
				if(stack3.isEmpty()) {
					return;
				}
				stack3.pop();
				break;
			case "<":
				stack4.add(st[i]);
				break;
			case ">":
				if(stack4.isEmpty() ) {
					return;
				}
				stack4.pop();
				break;
			}
		}
		check = 1; // 중간에 유효하지 않은 경우는 return을 하기 때문에 마지막까지 도착했다는 것은 유효하다는 것을 의미
	}
}
