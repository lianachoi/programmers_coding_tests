package programmers_coding_tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*�ڿ��� N�� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 1���� N���� �ڿ��� �߿��� �ߺ� ���� M���� �� ����
 * �� ������ ���������̾�� �Ѵ�.
 * 
 * ���� nCm�� ���ϴ� ����, 
 * ������ ���������� �����ϹǷ� 1243, 4321 ���� ���� �� ����.
*/

public class BJ15650_NandM_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int M;
	static int[] arr;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		//������ ��ġ ����� ���ؼ� ������ �ϳ� �߰���.
		backTracking(1,0);
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static void backTracking(int at, int depth) {
		if (depth == M) {
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = at; i <= N; i++) {
			arr[depth] = i;
			backTracking(i+1, depth+1);
		}
	}
}
