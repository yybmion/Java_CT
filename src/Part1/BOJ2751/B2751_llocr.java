package Part1.BOJ2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2751_llocr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] arr = new boolean[2000001];

        int n = Integer.parseInt(br.readLine()); //숫자 개수 입력 받기

        for(int i = 0; i<n; i++) { //배열에 숫자 입력
            arr[Integer.parseInt(br.readLine()) + 1000000] = true;
        }

        for(int i = 0; i<arr.length; i++){ //순서대로 출력
            if(arr[i]) {
                sb.append(i - 1000000).append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}

/*
* 시간초과,,를 극복하기 위해 여러 자료들을 봤고!
* Collections.sort() 말고 다른 방식을 사용해보고 싶었기에
* yybmion님이 공유해주신 블로그를 참고해서 문제를 풀어보았다!
* */
