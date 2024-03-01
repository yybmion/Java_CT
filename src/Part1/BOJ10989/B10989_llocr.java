package Part1.BOJ10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10989_llocr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10002];

        for(int i = 0; i<n; i++) {
            arr[Integer.parseInt(br.readLine())] += 1;
        }

        for(int i = 0; i<arr.length; i++) {
            if(arr[i] == 0) continue;
            for(int j = 0; j<arr[i]; j++) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}

/*
* 앞에 있던 2751번 문제를 풀었던 방식을 적용해서 풀어보았다!
* 이 문제는 중복되는 수도 중복되는 만큼 출력해주어야 하기 때문에
* int 배열에서 해당 값의 인덱스 값을 +1 해 주고,
* 이후에 해당 값의 인덱스만큼 반복해서 출력해주면 된다!
* */