package programmers_coding_tests;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 코딩테스트 연습> 완전탐색> 모의고사
 */
public class Mock_test {
	 public static int[] solution(int[] answers) {
	        int[] answer = {};
	        int[] supoja1 = {1,2,3,4,5};
	        int[] supoja2 = {2,1,2,3,2,4,2,5};
	        int[] supoja3 = {3,3,1,1,2,2,4,4,5,5};
	        
	        int[] score = {0,0,0};
	        
	        for (int i = 0; i < answers.length; i++) {
				if (answers[i] == supoja1[i%5]) {
					score[0]++;
				}
				if (answers[i] == supoja2[i%8]) {
					score[1]++;
				}
				if (answers[i] == supoja3[i%10]) {
					score[2]++;
				}
			}
	        
	        List<Integer> bestScore = new ArrayList<Integer>();
	        if (score[0] >= score[1] && score[0] >= score[2]) {
				bestScore.add(1);
			}
	        if (score[1] >= score[0] && score[1] >= score[2]) {
				bestScore.add(2);
			}
	        if (score[2] >= score[0] && score[2] >= score[1]) {
				bestScore.add(3);
			}
	        
	        answer = new int[bestScore.size()];
	        for (int i = 0; i < bestScore.size(); i++) {
				answer[i] = bestScore.get(i);
			}
	        System.out.println(Arrays.toString(answer));
	        return answer;
	    }
	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		solution(answers);
	}

}
