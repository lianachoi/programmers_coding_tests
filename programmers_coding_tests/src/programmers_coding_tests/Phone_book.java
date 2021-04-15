package programmers_coding_tests;

import java.util.HashMap;

public class Phone_book {
		
	private static boolean solution(String[] phone_book) {
		boolean answer = true;
		HashMap<String, Integer> ph = new HashMap<String, Integer>();
		for (String Prefix : phone_book) {
			ph.put(Prefix, 1);
		}
		for (String Prefix : phone_book) {
			for (int i = 0; i < Prefix.length(); i++) {
				if(ph.getOrDefault(Prefix.substring(0,i), 0) > 0) {
					answer = false;
					return answer;
				}	
			}
		}
        return answer;
	}
		
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "195624421","1956"};
    	solution(phone_book);
	}
}
