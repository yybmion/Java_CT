package Part1.BOJ10819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10819_yybmion {
    static int max=0;         // max 값 갱신
    static int result= 0;     // 배열 차이 값의 합을 담는 변수
    static int[] resultArr = new int[50000]; // 위의 결과를 담는 배열
    static int m=0;
    static int prune=1;  // 나올 수 있는 가지수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer stt = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] permArr = new int[N];
        boolean[] visit = new boolean[N];


        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(stt.nextToken());
        }
        /**
         * 나올 수 있는 가지수 셈 ex) 4라면  4*3*2*1 = 24가지 있음
         */
        for(int i=1;i<=N;i++){
            prune*=i;
        }

        findMax(arr,permArr,visit,0);
    }

    static void findMax(int[] arr, int[] permArr, boolean[] visit, int depth){
        /**
         * 종료조건
         * depth가 입력값과 같을때 종료 하지만 그 배열에서 절대값의 차이를 계산하고 또 합을 구해 result에 대입
         * 그 후 결과를 result Arr에 저장 후 max와 비교해 최대값을 계속 갱신한다.
         */
        if(depth==permArr.length){
            for(int w=0;w<permArr.length-1;w++) {
                result += Math.abs(permArr[w]-permArr[w+1]);
            }
            resultArr[m]=result;

            max=Math.max(resultArr[m],max);  // 최대값 갱신

            /**
             * 가지수가 모두 나오면 최대값 출력하고 종료
             */
            if(prune==m+1) {
                System.out.println(max);
                System.exit(0);
            }

            m++;
            result=0;
        }
        /**
         * 재귀 호출 (방문 체크 중요!)
         */
        for(int i=0;i<arr.length;i++){
            if(visit[i]==true) continue;
            visit[i]=true;
            permArr[depth]=arr[i];
            findMax(arr, permArr, visit, depth+1);
            visit[i]=false;
        }
    }
}

/**
 * 앞서 푼 2390 문제와 매우 비슷했다.
 * 어짜피 순열은 순서가 다르면 다른 가지수로 보기때문 (ex.{1,2,3}과 {2,1,3}은 다름) 에 모든 경우의 수를 배열로 나타낸 뒤
 * 그냥 |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]| 이 계산을 진행해주면된다.
 * 그 결과를 계속해서 최대값인지 확인하며 갱신하면 된다.
 * 이외에는 2390문제와 다를 게 없다고 생각한다.
 *
 * 하지만 시간이 좀 걸린것 같아 코드를 조금 더 빠른방법으로 수정해볼 필요는 있는 것 같다. ㅜㅜ
 */
