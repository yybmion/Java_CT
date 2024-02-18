package Part1.BOJ8958;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B8958_llocr {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i<testCase; i++) {
            String str = br.readLine();
            int points = 0;
            int addition = 0;

            for(int j = 0; j<str.length(); j++) {
                char c = str.charAt(j);
                if (c == 'O') {
                    points += addition + 1;
                    addition++;
                } else {
                    addition = 0;
                }
            }
            System.out.println(points);
        }
    }
}