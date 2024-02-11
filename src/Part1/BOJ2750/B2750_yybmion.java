package Part1.BOJ2750;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2750_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(stt.nextToken());
        }

        Arrays.sort(arr);   // 배열을 정렬하기 위해 Arrays.sort 라이브러리 사용

        for (int res : arr) {
            bw.write(res+"\n");
        }

        bw.flush();
    }
}

/**
 * 간단하다.
 * N을 통해서 값을 입력받고 Arrays.sort 정렬 라이브러리를 사용하기 위해
 * 값을 배열로 저장하고
 * 그냥 arr을 넣어주면 정렬된다.
 * 출력하면 끝!!
 */
