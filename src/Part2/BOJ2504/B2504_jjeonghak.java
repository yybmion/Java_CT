package Part2.BOJ2504;

import java.io.*;
import java.util.Map;
import java.util.Stack;

public class B2504_jjeonghak {

	private static final Map<Character, Integer> SCORE = Map.of('(', 2, '[', 3);
	private static final Map<Character, Character> BRACKET = Map.of(')', '(', ']', '[');

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		char[] input = br.readLine().toCharArray();
		int result = 0, term = 1;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < input.length; i++) {
			char iter = input[i];
			if (!BRACKET.containsKey(iter)) {
				term *= SCORE.get(iter);
				stack.push(iter);
			} else {
				char openBracket = BRACKET.get(iter);
				if (stack.isEmpty() || !stack.pop().equals(openBracket)) {
					result = 0;
					break;
				}
				result += input[i - 1] == openBracket ? term : 0;
				term /= SCORE.get(openBracket);
			}
		}
		result = stack.isEmpty() ? result : 0;
		sb.append(result);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
