package programmers_coding_tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ5214 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer>[] Ll = new LinkedList[N+M+1];
		for (int i = 0; i <= N+M; i++) {
			Ll[i] = new LinkedList<>();
		}
		int[] visited = new int[N+M+1];
		visited[0] = visited[1] = 1;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				int station = Integer.parseInt(st.nextToken());
				Ll[N+i].add(station);
				Ll[station].add(N+i);
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == N) {
				bw.write(visited[now]+"");
				break;
			}
			for (int i = 0; i < Ll[now].size(); i++) {
				int next =  Ll[now].get(i);
				if (visited[next] == 0) {
					if (next>N) {
						visited[next] = visited[now];
					}else{
						visited[next] = visited[now]+1;
						
					}
					q.add(next);
				}
			}
			
		}
		if (visited[N] == 0) {
			bw.write("-1");			
		}
		bw.close();
		br.close(); 
	}
}

