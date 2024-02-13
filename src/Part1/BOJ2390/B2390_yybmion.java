package Part1.BOJ2390;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class B2390_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int[] sortArr = new int[7];   // 합이 100인 7명의 난쟁이 뽑고 나서 정렬하기 위한 배열
        boolean[] visit = new boolean[9]; // 배열 들렸는지 안들렸는지 체크

        int depth = 0; // 7이 되면 종료 (7명 골랐다는 의미)

        for(int i=0;i<9;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        findTall(arr,sortArr,visit,depth);
    }

    static void findTall(int[] arr,int[] sortArr, boolean[] visit, int depth){
        /**
         * 종료조건 7명 선택시 합 100 확인하고 맞으면 sorting 후 출력
         */
        if(depth==7){
            int result = 0;  // 합 100 확인 변수
            int j=0;        // sortArr 배열 인덱스
            for(int i=0;i<9;i++){
                if(visit[i]) result+=arr[i];  // visit=true 일때 result에 값 더해줌
            }
            if(result==100){
                for(int i=0;i<9;i++){
                    if(visit[i]) {
                        sortArr[j] = arr[i];
                        j++;
                    }
                }

                Arrays.sort(sortArr);  // 합 100 확인후 7난쟁이 순서대로 정렬
                for (int res : sortArr) {
                    System.out.println(res);
                }
                System.exit(0);  // 강제 종료 (더 이상 확인 필요 X)
            }
        }
        /**
         * 재귀 : arr배열에 방문을 체크하면서 7명이 선택될 때까지 반복
         */
        for(int j=0;j< arr.length;j++){
            if(visit[j]) continue;
            visit[j]=true;
            findTall(arr, sortArr, visit, depth+1);
            visit[j]=false;
        }
    }
}

/**
 * 먼저 힌트에서 완전탐색 종류중 하나인 순열을 사용해야한다고 나와있었다.
 * 문제를 보면 9명의 난쟁이 중에 7명을 선택해서 합이 100이되는 경우를 찾는것이다.
 * 쉽게 생각해서 9p7이라고 생각하고 풀어보면 될것이다.
 *
 * 그럼 이걸 어떻게 구현하냐??
 * 일단 배열 인덱스를 depth로 보자 그리고 그 depth에 따라서 그 인덱스를 방문했는지 안했는지도 표시하기 위한 visit boolean 배열도 생성
 * 먼저 재귀함수를 보면 종료조건은 depth가 7일때 종료한다. 이 의미는 9개의 배열중 7명의 난쟁이를 골랐을 때 종료한다는 의미인데 거기에 더 들어가
 * 그냥 종료가 아닌 true라고 체크된 배열을 다 합해서 100이 되면 그걸 출력하고 종료하는 것이다.
 *
 * 이제 재귀부분을 보자 for문으로 먼저 돌리고 만약 방문한 곳이라면 인덱스를 늘려 false인곳을 찾아 true로 만들어준다. 그리고 재귀함수를 call 하면
 * 언젠가 7개가 골라질 때가 올것이다. 그럼 합 100 체크 ! 만약 아니라면 밑에 visit[j]=false 로 내려가 최근 true를 false로 바꾼다. 그리고 for문 인덱스를 또 늘려
 * 방문 체크하고 false면 true로 변경하고 다시 재귀함수 call! 이걸 반복하면 모든  7명의 난쟁이를 살펴볼 수 있다.
 *
 */
