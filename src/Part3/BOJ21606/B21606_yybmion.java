package Part3.BOJ21606.B21606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B21606_yybmion {
    static ArrayList<ArrayList<Integer>> tree;  // 그래프 양방향 연결 위한 변수
    static int[] inOut;                         // 실내외 표현
    static boolean[] visited;                   // 방문 체크
    static int N;                               // 정점 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        N = Integer.parseInt(br.readLine());
        inOut = new int[N+1];
        tree = new ArrayList<>();

        for(int i=0;i<=N;i++){
            tree.add(new ArrayList<>());
        }

        String str = br.readLine();

        for(int i=1;i<N+1;i++){
            inOut[i] = Integer.parseInt(String.valueOf(str.charAt(i-1)));       // 실내외 표현
        }

        for(int i=0;i<N-1;i++){
            StringTokenizer stt = new StringTokenizer(br.readLine());

            int e1 = Integer.parseInt(stt.nextToken());
            int e2 = Integer.parseInt(stt.nextToken());

            tree.get(e1).add(e2);
            tree.get(e2).add(e1);                               // 양방향 트리 표현

            if(inOut[e1] == 1 && inOut[e2] == 1){               // 예외 사항 COUNT 따로 해준다. 실내실내끼리 인접하면 바로 2개 더해준다. 실내 실내는 바로 산책을 끝내기 때문이다.
                count+=2;
            }
        }

        visited = new boolean[N+1];

        for(int i=1;i<=N;i++){
            int in = 0;
            if(inOut[i] == 0){                              // 실외 기준으로 우리는 살펴볼 것이다.
                if(!visited[i]){                            // 방문 된적이 없다면
                    visited[i] = true;
                    in = dfs(i);                            // 거기서 부터 우린 DFS를 시작할 것이다.
                }
            }
            count += in*(in-1);                             // 마지막에 결과값을 N(N-1) 하면 답이 구해진다. -> 수학적 지식이다...
        }
        System.out.println(count);
    }
    static int dfs(int start){
        int in =0;
        for(int e : tree.get(start)){
            if(inOut[e] == 0){                              // 실외면 계속 탐색 실내 나올 때 까지
                if(!visited[e]){
                    visited[e] = true;
                    in += dfs(e);
                }
            }else{
                in++;                                       // 실내 나오면 IN 카운트 업!!
            }
        }

        return in;
    }
}

/**
 * 실내 기준으로 DFS를 했는데 108점....
 * 결국 블로그의 힘을 빌려 200점 짜리 답을 보았다.
 * 음... 실외 기준으로 하란다 이걸 어떻게 생각해내야지??
 * ㅎㅎ
 *
 * https://velog.io/@kimgunwooo/%EB%B0%B1%EC%A4%80-21606%EB%B2%88-%EC%95%84%EC%B9%A8-%EC%82%B0%EC%B1%85
 */
