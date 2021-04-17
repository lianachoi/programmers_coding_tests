package programmers_coding_tests;

/*
 * 코딩테스트 연습> 탐욕법(Greedy)> 체육복
 */
import java.util.Arrays;

public class PE_clothes {

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		// 배열의 양 끝에서도 탐색할 수 있도록 배열 크기를 +2로 잡아준다.
		// 배열 값이 0이상이면 수업을 들을 수 있는 학생이다.
		int[] take_class = new int[n + 2];
		// 모든학생이 체육복이 있다고 가정하고 1로 채움
		Arrays.fill(take_class, 1);
		// 분실 체육복과 여분 체육복 여부를 더해준다.
		for (int i = 0; i < lost.length; i++) {
			take_class[lost[i]]--;
		}
		for (int i = 0; i < reserve.length; i++) {
			take_class[reserve[i]]++;
		}
		// 배열의 두 번째(1)부터 마지막 전(전체길이-2)까지 탐색한다.
		// 양 끝은 1이 들어있어서 없는 체육복으로 치지 않음
		for (int i = 1; i < take_class.length - 1; i++) {
			// 여분 체육복이 있는 경우만 본다.
			if (take_class[i] == 2) {
				//먼저 앞에 있는 학생이 체육복이 없는지 확인하고
				//있으면 뒤에 있는 학생이 없는지 확인한다.
				if (take_class[i - 1] == 0) {
					take_class[i - 1]++;
					take_class[i]--;
				} else if (take_class[i + 1] == 0) {
					take_class[i + 1]++;
					take_class[i]--;
				}
			}
		}
		for (int i = 1; i < take_class.length - 1; i++) {
			if (take_class[i] > 0) {
				answer++;
			}
		}
		// System.out.println(Arrays.toString(take_class));
		// System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		int n = 3;
		int[] lost = { 3 };
		int[] reserve = { 1 };

		solution(n, lost, reserve);
	}

}
