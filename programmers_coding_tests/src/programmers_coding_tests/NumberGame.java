package programmers_coding_tests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class NumberGame {
	
	public static int solution(String s) {
        int answer = 0;
        
        String[] numbers = {"zero","one"
        		,"two","three","four","five","six"
        		,"seven","eight","nine"};
        
        HashMap<String, Integer> hm = new HashMap<>();
        for (int n = 0; n < numbers.length; n++) {
			hm.put(numbers[n], n);
		}
        
        String numberString = "";
        String answerNum = "";
        for (int i = 0; i < s.length(); i++) {
        	char now = s.charAt(i);
			if (s.charAt(i) > 57) {
				numberString += now;
				if (hm.containsKey(numberString)) {
					answerNum += hm.get(numberString);
					numberString = "";
				}
			}else {
				answerNum += now;
			}
		}
        answer = Integer.parseInt(answerNum);
        return answer;
    }
	public static void main(String[] args) {
		String s = "one4seveneight";
		solution(s);
	}

}
