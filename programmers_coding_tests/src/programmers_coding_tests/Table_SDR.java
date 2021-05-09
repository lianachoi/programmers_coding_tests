package programmers_coding_tests;

import java.util.LinkedList;
import java.util.Stack;

class grid{
	int one;
	int two;
	public grid(int one, int two) {
		this.one = one;
		this.two = two;
	}
}
public class Table_SDR {
	public static String solution(int n, int k, String[] cmd) {
        String answer = "";
        
        Stack<grid> stack = new Stack<>();
        
        LinkedList<Integer> Ll = new LinkedList<>();
        for (int i = 0; i < n; i++) {
			Ll.add(i);
		}
        int now = k;
        for (int c = 0; c < cmd.length; c++) {
        	if (cmd[c].charAt(0) == 'D') {
				int next = Integer.parseInt(cmd[c].substring(2));
				now = now+next;
        	}else if (cmd[c].charAt(0) == 'U') {
				int next = Integer.parseInt(cmd[c].substring(2));
				now = now-next;
        	}else if (cmd[c].charAt(0) == 'C') {
        		int Ll_get = Ll.get(now);
				stack.push(new grid(Ll_get,now));
				Ll.remove((Integer)Ll_get);
				if (Ll.size() < now+1) {
					now--;
				}
        	}else if (cmd[c].charAt(0) == 'Z') {
        		int a = Ll.get((Integer) now);
        		grid g = stack.pop();
				Ll.add(g.two,g.one);
				now = Ll.indexOf(a);
        	}
        }
        for (int i = 0; i < n; i++) {
			if (!Ll.isEmpty() && Ll.getFirst() == i) {
				answer += 'O';
				Ll.removeFirst();	
			}else {
				answer +='X';
			}
		}
        System.out.println(answer);
        return answer;
    }
	public static void main(String[] args) {
		int n = 8;
		int k = 2;
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		solution(n, k, cmd);
	}

}
