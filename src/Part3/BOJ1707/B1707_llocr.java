package Part3.BOJ1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1707_llocr {
    static ArrayList<Integer>[] arr;
    static int[] check;
    static boolean[] visited;
    static boolean IsEven;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for(int t = 0; t < testCase; t++) { // 주어진 테스트 케이스만큼 돌림
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr = new ArrayList[v+1];
            visited = new boolean[v+1];
            check = new int[v+1];
            IsEven = true;

            for(int i=1; i<=v; i++) { //배열 초기화
                arr[i] = new ArrayList<>();
            }

            //에지 데이터 저장
            for(int i=0; i<e; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                arr[start].add(end);
                arr[end].add(start);
            }

            // 모든 노드에서 DFS 실행
            // 그래프의 모든 노드가 이어져 있지 않고, 여러 개의 부분 그래프로 이뤄진 케이스가 존재할 수도 있기 때문
            for(int i=1; i<=v; i++) {
                if(IsEven) {
                    DFS(i);
                } else {
                    break;
                }
            }

            if(IsEven) System.out.println("YES");
            else System.out.println("NO");
        }

    }

    private static void DFS(int start) {
        visited[start] = true;
        for(int i : arr[start]) {
            if(!visited[i]) {
                // 바로 직전에 있는 노드와 다른 집합으로 분류
                check[i] = (check[start] + 1) % 2;
                DFS(i);
            } else {
                if(check[start] == check[i]) {
                    IsEven = false;
                    // 이미 방문한 노드인데, 현재 나의 노드와 같은 집합이면 이분 그래프가 아님
                }
            }
        }
    }
}

/*
* 참고 : https://www.youtube.com/watch?v=mDSQfb5Rqc4&ab_channel=%ED%95%98%EB%A3%A8%EC%BD%94%EB%94%A9
* 이분 그래프 : 노드끼리 서로 인접하지 않은 두 집합으로 그래프의 노드를 나눌 수 있을 때
*
* 분명히 몇 달 전에 풀었던 문제인데 기억 안 나는 나.. 반성해
* 코테는 알고리즘별로 나눠서 공부하고 천천히 쌓아가야 한다는 걸 많이 느끼는 중!
*
* DFS를 알고 제대로 활용할 줄 알면 쉽게 풀었을 것 같다! 반복학습 하면서 문제 푸는 방식을 많이 익혀야겠다
* */
