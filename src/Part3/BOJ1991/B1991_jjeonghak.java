package Part3.BOJ1991;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class B1991_jjeonghak {

	private static Boolean[] children;
	private static Map<Integer, List<Integer>> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		children = new Boolean[n];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			List<Integer> child = Stream.of(getKey(input[1]), getKey(input[2]))
					.collect(Collectors.toList());
			map.put(getKey(input[0]), child);
			children[getKey(input[0])] = true;
		}

		int parent = 0;
		for (int i = 0; i < n; i++) {
			if (!children[i]) {
				parent = i;
				break;
			}
		}

		preorder(parent, sb);
		sb.append("\n");
		inorder(parent, sb);
		sb.append("\n");
		postorder(parent, sb);
		sb.append("\n");

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static int getKey(String input) {
		if (input.equals(".")) {
			return -1;
		}
		return input.charAt(0) - 'A';
	}

	private static Character getValue(int key) {
		return (char)(key + 'A');
	}

	private static void preorder(int key, StringBuilder sb) {
		if (key == -1) {
			return;
		}
		sb.append(getValue(key));
		map.get(key).forEach(c -> preorder(c, sb));
	}

	private static void inorder(Integer key, StringBuilder sb) {
		if (key == -1) {
			return;
		}
		List<Integer> child = map.get(key);
		if (child.size() > 0) {
			inorder(child.get(0), sb);
		}
		sb.append(getValue(key));
		if (child.size() > 1) {
			inorder(child.get(1), sb);
		}
	}

	private static void postorder(int key, StringBuilder sb) {
		if (key == -1) {
			return;
		}
		map.get(key).forEach(c -> postorder(c, sb));
		sb.append(getValue(key));
	}

}
