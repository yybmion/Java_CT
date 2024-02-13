package Part1.BOJ1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1152_llocr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");     //str을 공백에 따라 나눔
        int word = 0;

        while(st.hasMoreTokens()) {
            String a = st.nextToken();
            word++;
        }

        System.out.println(word);
    }
}
