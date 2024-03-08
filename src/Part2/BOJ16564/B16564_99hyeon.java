package Part2.BOJ16564;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B16564_99hyeon {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] character = new int[Integer.parseInt(st.nextToken())];
        long upgrade = Integer.parseInt(st.nextToken());

        for(int i = 0; i < character.length; i++){
            character[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Arrays.sort(character);

        int start = character[0];
        int end = character[character.length - 1];
        int min = 0;

        while(start <= end){
            int mid = (start + end) / 2;
            long sum = 0;

            for(int i = 0; i < character.length; i++){
                if(character[i] < mid){
                    sum += (mid - character[i]);
                }
            }

            if(sum <= upgrade){
                min = Math.max(min, mid);
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        System.out.println(min);
    }
}

/**
 * 수정 필요
 */