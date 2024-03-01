package Part1.BOJ2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2309_llocr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[9];
        int sum = 0;

        for(int i = 0; i<9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);
        int a = 0;
        int b = 0;

        for(int i = 0; i<8; i++) {
            for(int j=i+1; j<9; j++) {
                if(sum - arr[i] - arr[j] == 100) {
                    a = i;
                    b = j;
                    break;
                }
            }
        }

        for(int i = 0; i<9; i++) {
            if(i != a && i != b) {
                sb.append(arr[i]).append("\n");
            }

        }

        System.out.println(sb);
    }
}

/*
* 정답인 7명을 찾으려는 코드를 짜다보니,, 이건 아니다 좀 이상하는 생각이 펀뜩 들었음다
* 결국 풀이과정 참조해서 범인인 2명을 찾는 것에 집중했어요 :(
*
* 이런 문제는 "브루트 포스 알고리즘"을 이용해서 푸는 문제
*
* 브루트 포스
* 브루트 포스(brute force), 키 전수조사(exhaustive key search) 또는 무차별 대입(無差別代入)은 조합 가능한 모든 문자열을 하나씩 대입해 보는 방식으로 암호를 해독하는 방법이다.
* 흔히 암호학에서 연구되나, 다른 알고리즘 분야에서도 사용되고 있다.
* 흔히 수학 문제를 원시적으로 푸는 방법인 '수 대입 노가다'의 학술적 버전이다.
* */