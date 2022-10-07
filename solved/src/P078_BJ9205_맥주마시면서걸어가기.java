import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// bfs
public class P078_BJ9205_맥주마시면서걸어가기 {
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			
			Point house = new Point(sc.nextInt(), sc.nextInt());
			
			List<Point> lst = new ArrayList<>();
			for (int n = 0; n < N; n++) {
				Point conv = new Point(sc.nextInt(), sc.nextInt());
				lst.add(conv);
			}

			Point festival = new Point(sc.nextInt(), sc.nextInt());
			
			if (Math.abs(house.x - festival.x) + Math.abs(house.y - festival.y) <= 50 * 20) { // 집부터 페스티벌까지 한 번에 갈 수 있는 경우 
				sb.append("happy\n");
				continue;
			}
			
			boolean flag = false;
			boolean[] visited = new boolean[N]; // 편의점 방문 표시 visited 배열
			
			// 집에서 편의점을 거쳐서 페스티벌에 가야하는 경우 
			Queue<Point> q = new ArrayDeque<>();
			q.offer(house); // 집이 시작점이기 때문에 집 먼저 queue에 넣기 
			while(!q.isEmpty()) {
				Point cur = q.poll();
				
				if (Math.abs(cur.x - festival.x) + Math.abs(cur.y - festival.y) <= 50 * 20) { // 페스티별에 도착했을 경우 
					flag = true;
					break;
				}
				
				for (int i = 0; i < lst.size(); i++) {
					if (visited[i]) continue;
					
					if (Math.abs(cur.x - lst.get(i).x) + Math.abs(cur.y - lst.get(i).y) <= 50 * 20) { // 맥주를 추가적으로 안 사고 갈 수 있는 경우 
						visited[i] = true;
						q.offer(lst.get(i));
					}
				}
			}
			if (flag) sb.append("happy\n");
			else sb.append("sad\n");
		}
		System.out.println(sb);
	}

}
