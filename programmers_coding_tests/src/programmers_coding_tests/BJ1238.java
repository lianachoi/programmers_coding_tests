package programmers_coding_tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Neighbor implements Comparable<Neighbor>{
	int to;
	int t;
	public Neighbor(int to, int t) {
		this.to = to;
		this.t = t;
	}
	@Override
	public int compareTo(Neighbor o) {
		if (this.t < o.t) {
			return -1;
		}
		if (this.t > o.t) {
			return 1;
		}
		return 0;
	}
}
public class BJ1238 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Neighbor>> AL_go = new ArrayList<>();
		ArrayList<ArrayList<Neighbor>> AL_back = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			AL_go.add(new ArrayList<Neighbor>());
			AL_back.add(new ArrayList<Neighbor>());
		}

		int[] timeList_go = new int[N+1];
		int[] timeList_back = new int[N+1];
		
		Arrays.fill(timeList_go, Integer.MAX_VALUE);
		Arrays.fill(timeList_back, Integer.MAX_VALUE);
		timeList_go[0] = timeList_back[0] = timeList_go[X] = timeList_back[X] = 0;
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			AL_go.get(to).add(new Neighbor(from, t));
			AL_back.get(from).add(new Neighbor(to, t));
		}
		
		PriorityQueue<Neighbor> pq = new PriorityQueue<>();
		pq.add(new Neighbor(X, 0));
		while (!pq.isEmpty()) {
			Neighbor now = pq.poll();
			for (int i = 0; i < AL_go.get(now.to).size(); i++) {
				Neighbor next = AL_go.get(now.to).get(i);
				if (timeList_go[next.to] > timeList_go[now.to] + next.t) {
					timeList_go[next.to] = timeList_go[now.to] + next.t;
					pq.add(next);
				}
			}
		}
		pq.add(new Neighbor(X, 0));
		while (!pq.isEmpty()) {
			Neighbor now = pq.poll();
			for (int i = 0; i < AL_back.get(now.to).size(); i++) {
				Neighbor next = AL_back.get(now.to).get(i);
				if (timeList_back[next.to] > timeList_back[now.to] + next.t) {
					timeList_back[next.to] = timeList_back[now.to] + next.t;
					pq.add(next);
				}
			}
		}
		int max = 0;
		for (int i = 1; i < timeList_back.length; i++) {
			if(max < timeList_go[i]+timeList_back[i]) {
				max = timeList_go[i]+timeList_back[i];
			}
		}
		bw.write(max+"");
		bw.close();
		br.close();

	}

}
