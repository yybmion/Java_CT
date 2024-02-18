package Part1.BOJ2390;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class B2309_jjeonghak {

	private static final int SIZE = 9;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		List<Integer> input = new ArrayList<>();
		for (int i = 0; i < SIZE; i++) {
			input.add(Integer.parseInt(br.readLine()));
		}
		int total = input.stream().reduce(0, Integer::sum);
		int diff = total - 100;

		boolean check = false;
		for (int i = 0; i < SIZE - 1; i++) {
			if (check) {
				break;
			}
			for (int j = i + 1; j < SIZE; j++) {
				int lValue = input.get(i);
				int rValue = input.get(j);

				if (lValue + rValue == diff) {
					input.stream()
							.filter(h -> !h.equals(lValue) && !h.equals(rValue))
							.sorted()
							.forEach(h -> sb.append(h).append("\n"));
					check = true;
					break;
				}
			}
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
