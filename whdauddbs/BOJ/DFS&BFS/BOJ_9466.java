import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9466 {
	static int n, arr[], result;
	static boolean vis[], finished[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			vis = new boolean[n+1];
			finished = new boolean[n+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			result = 0;
			for (int i = 1; i <= n; i++) {
				if(!vis[i]) {
					vis[i] = true;
					dfs(i);
				}
			}
			System.out.println(n - result);
		}
		br.close();
	}
	
	static void dfs(int here) {
		int next = arr[here];
		if(!vis[next]) {
			vis[next] = true;
			dfs(next);
		} else if(vis[next] && !finished[next]) {
			result++;
			finished[next] = true;
			dfs(next);
		}
		finished[here] = true;			
	}
}