package Part3.BOJ11725;

import java.io.*;
import java.util.*;

public class B11725_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>(); // 그래프를 구현하는데 다음과 같은 방법으로도 많이 한다.
        for(int i=0;i<N;i++){                                           // 2차원 배열과 비슷하다고 보면 된다.
            tree.add(new ArrayList<>());                        // 먼저 껍대기를 만들어놓고
        }

        for(int i=0;i<N-1;i++){
            StringTokenizer stt = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(stt.nextToken())-1;
            int n2 = Integer.parseInt(stt.nextToken())-1;
            tree.get(n1).add(n2);                               // 양방향으로 만들어준다.
            tree.get(n2).add(n1);                               // 서로의 간선을 보기 위해서다.

        }
        int[] parent = new int[N];
        boolean[] visit = new boolean[N];
        //int[] value = new int[N*2-1];

        queue.add(0);                                           // 첫번째 루트는 먼저 넣어준다.
        visit[0] = true;
        while(!queue.isEmpty()){
            int v = queue.poll();                               // 하나 뽑아서 이어져있는 노드를 모두 확인한다.
            for(int node : tree.get(v))
                if(!visit[node]){                               // 그 노드들 방문 확인하고 안했다면
                    visit[node] = true;
                    queue.add(node);                            // 큐에 넣어주며 부모는 방금 큐에서 꺼낸 값이다.
                    parent[node] = v;
                }
        }

        for (int i = 1; i < N; i++)
            System.out.println(parent[i] + 1);
    }

//        for(int i=1;i< value.length-1;i++) {
//            StringTokenizer stt = new StringTokenizer(br.readLine());
//            int n = Integer.parseInt(stt.nextToken());
//            int m = Integer.parseInt(stt.nextToken());
//            value[i]=n;
//            value[++i]=m;
//
//        }
//        queue.add(1);
//        visit[1] = true;
//
//        int i=1;
//        while(!queue.isEmpty()) {
//                if (value[i] == queue.peek()) {
//                    if(i%2!=0){//홀수
//                        if (visit[value[i+1]] == false) {
//
//                            visit[value[i+1]] = true;
//                            parent[value[i+1]] = queue.peek();
//                            queue.add(value[i+1]);
//                        }
//                    }else {
//                        if (visit[value[i-1]] == false) {
//
//                            visit[value[i-1]] = true;
//                            parent[value[i-1]] = queue.peek();
//                            queue.add(value[i-1]);
//                        }
//                    }
//                }
//            i++;
//                if(i == value.length-1){
//                    queue.poll();
//                    i=1;
//                }
//
//        }
//        for (i=2;i<N+1;i++) {
//            sb.append(parent[i]+"\n");
//        }
//        System.out.println(sb);

}

/**
 * ;;; 밑에 주석 코드는 시간초과난 코드이다.
 * 답은 맞았는데 시간초과난다...
 * 같은 BFS로 풀었는데 초과나서 화났다.
 * https://newbie-in-softengineering.tistory.com/m/entry/SilverII-11725-%ED%8A%B8%EB%A6%AC%EC%9D%98-%EB%B6%80%EB%AA%A8-%EC%B0%BE%EA%B8%B0-Java
 */
