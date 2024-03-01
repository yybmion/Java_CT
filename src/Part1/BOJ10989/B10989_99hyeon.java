package Part1.BOJ10989;

import java.io.*;

public class B10989_99hyeon {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] count = new int[10001];

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            count[Integer.parseInt(br.readLine())]++;
        }
        br.close();

        for(int i = 1; i < 10001; i++){
            while(count[i] > 0){
                sb.append(i).append("\n");
                count[i]--;
            }
        }

        System.out.println(sb);
    }
}


/**
 * 2751번 문제와 같은 코드(Collections.sort())로 푸니 메모리 초과가 떴다.
 * 출력 부분은 문제가 없는 거 같아서 정렬부분에 대해 찾아봤다.
 *
 * 이 문제는 시간, 메모리 제한이 빡세기 때문에 Collections.sort()를 사용하기보다
 * 다른 방식으로 풀어야했다.
 *
 * 찾아보니 데이터의 값이 몇 번 나왔는지 세어주는 카운팅 정렬방법을 사용하면 되었다.
 * 카운팅 정렬 방식을 사용하면 메모리를 효율적으로 사용할 수 있을 뿐 아니라
 * 시간적으로도 더 효율적이였다.
 *
 *
 */
