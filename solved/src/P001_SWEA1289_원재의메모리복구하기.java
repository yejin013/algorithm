

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P001_SWEA1289_원재의메모리복구하기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			
			String input = in.readLine();
			char[] arr = input.toCharArray();
			char[] check = new char[arr.length];
			Arrays.fill(check, '0');
			
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != check[i]) {
					count++;
					char k = arr[i];
					for (int j = i; j < check.length; j++) {
						check[j] = k;
					}
				}
			}
			System.out.println("#" + tc + " " + count);
		}
		
	}
}
