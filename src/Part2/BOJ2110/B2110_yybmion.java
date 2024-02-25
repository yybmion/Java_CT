package Part2.BOJ2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2110_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stt = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stt.nextToken());
        int C = Integer.parseInt(stt.nextToken());

        int[] houseLoc = new int[N];

        for(int i=0;i<N;i++){
            houseLoc[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houseLoc);    // 이분탐색을 위해 정렬


        int result = 0;   // 최대치 거리 담는 변수
        int start = 0;    // 이분탐색 변수 설정
        int end = houseLoc[N-1]-houseLoc[0];   // 설치 가능 거리 최대치 설정

        while(start <= end){        //  이분탐색 시작
            int count = 1;          // 첫번째는 고정으로 설치하니 일단 count == 1
            int prev = houseLoc[0];   //  공유기 하나는 첫번째에 계속 설치 가정

            int mid = (start + end)/2;

            for(int i=1;i<N;i++){
                if(houseLoc[i]-prev >= mid){    // 바로 전 집이랑 거리를 계산해서 mid보다 크면 설치가능하다는 얘기
                    count++;
                    prev = houseLoc[i];         // 그래서 count도 높히고 그다음 집이랑 거리 비교위해 prev 값 갱신
                }
            }

            if(count>=C){                       // 이후 이분탐색을 위한 start , end값 수정
                result = mid;

                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        System.out.println(result);

    }
}

/**
 * 먼저 mid를 무엇으로 잡을지 고민을 많이 해봤는데, 아깝게 틀린 부분이 있었다.
 * 나는 집 최대 좌표에서 집 최소 좌표의 차이에서 나누기 2를 하여 mid를 잡으려 했는데
 * 그게 아닌 애초에 두집 사이 공유기를 설치할 수 있는 최대 거리를 잡으려면 최대 집 좌표(end)는 맞지만 start값은 0으로 시작해야한다.
 * 이분탐색은 역시 start,end,mid를 어떻게 잡을지만 잡히면 문제는 쉽게 푸는 것 같다.
 *
 * 그렇게 잡고나서는 전 집 좌표와 비교하며 mid값을 설정해주면 되어 그렇게 어렵진 않았다.
 * 일단 이분탐색을 찾다보니 투포인터도 한번 정리해야겠다고 생각했다.
 *
 * https://st-lab.tistory.com/277
 */
