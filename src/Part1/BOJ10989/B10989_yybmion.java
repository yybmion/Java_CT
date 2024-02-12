package Part1.BOJ10989;

import java.io.*;

public class B10989_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];

        /**
         * 입력값을 인덱스로 하여 값을 저장하는데 같은 숫자가 있으면 +1을 해준다.
         */
        for(int i=0;i<N;i++) {
            int ret = Integer.parseInt(br.readLine());
            arr[ret] += 1;
        }

        /**
         * 출력 , arr[j]의 값이 0이 되기 전까지 계속 같은 인덱스 출력
         */
        for(int i=0;i<arr.length;i++) {
            int j = arr[i];
            while (j > 0) {
                str.append(i).append("\n");
                j--;
            }
        }
        System.out.println(str);
    }
}

/**
 * 먼저 시간초과와 메모리초과가 되지 않기 위해 생각한 방법은 전의 정렬문제에서 boolean을 통해서 풀어보있다.
 * 하지만 이번에는 중복되는 숫자 또한 있으니 boolean이 아닌 int형 배열을 만들어
 * 만약 중복되는 수가 있다면 그 인덱스 해당하는 배열 값을 1씩 늘린다.
 * 따라서 출력할때 그 배열의 값이 0이 될때까지 출력을 하면 되는 것이다.
 * 그러면 같은 숫자가 여러개 와도 여러번 출력이 될것이다.
 * 당연하지만 배열로 만들어주어서 따로 정렬을 할 필요는 없다.
 */
