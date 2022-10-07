

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P039_BJ1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 파싱 
		String s = br.readLine().replace("-", " - ");
		s = s.replace("+", " + ");
		String[] sList = s.split(" ");
		
		// 양방향 진행 
		ArrayDeque<String> q = new ArrayDeque<>();
		q.add(sList[0]); // 첫 번째 원소 넣기 

		int i = 1;
		int answer = 0;
		while(!q.isEmpty()) {
			if (i < sList.length) { // 식 만큼 돌기 
				switch(sList[i]) { 
				case "+": // 더해서 큐에 넣기 
					int temp = 0;
					String st = q.pollLast();
					temp = Integer.parseInt(st) + Integer.parseInt(sList[++i]);
					q.add(String.valueOf(temp));
					i++;
					break;
				default: // 큐에 넣
					q.add(sList[i++]);
				}
			} else { // 식을 다 큐에 넣고 계산하면, FO 방식으로 빼기 
				String str = q.poll();
				if ("-".equals(str)) { // -면 계산하기 
					answer -= Integer.parseInt(q.poll());
				} else {
					answer += Integer.parseInt(str);
				}
			}
		}
		
		System.out.println(answer);
	}
}

