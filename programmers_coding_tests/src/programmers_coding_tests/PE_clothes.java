package programmers_coding_tests;

/*
 * �ڵ��׽�Ʈ ����> Ž���(Greedy)> ü����
 */
import java.util.Arrays;

public class PE_clothes {

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		// �迭�� �� �������� Ž���� �� �ֵ��� �迭 ũ�⸦ +2�� ����ش�.
		// �迭 ���� 0�̻��̸� ������ ���� �� �ִ� �л��̴�.
		int[] take_class = new int[n + 2];
		// ����л��� ü������ �ִٰ� �����ϰ� 1�� ä��
		Arrays.fill(take_class, 1);
		// �н� ü������ ���� ü���� ���θ� �����ش�.
		for (int i = 0; i < lost.length; i++) {
			take_class[lost[i]]--;
		}
		for (int i = 0; i < reserve.length; i++) {
			take_class[reserve[i]]++;
		}
		// �迭�� �� ��°(1)���� ������ ��(��ü����-2)���� Ž���Ѵ�.
		// �� ���� 1�� ����־ ���� ü�������� ġ�� ����
		for (int i = 1; i < take_class.length - 1; i++) {
			// ���� ü������ �ִ� ��츸 ����.
			if (take_class[i] == 2) {
				//���� �տ� �ִ� �л��� ü������ ������ Ȯ���ϰ�
				//������ �ڿ� �ִ� �л��� ������ Ȯ���Ѵ�.
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
