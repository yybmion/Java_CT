package Part3.BOJ1260;

import java.io.*;
import java.util.*;

public class B1260_yybmion {

    static int N;
    static int M;
    static int V;
    static StringBuilder sb;
    static boolean[] visited;
    static ArrayList<Integer> arr[];        // 배열에 list를 담을 것이다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stt = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stt.nextToken());
        M = Integer.parseInt(stt.nextToken());
        V = Integer.parseInt(stt.nextToken());

        sb = new StringBuilder();
        visited = new boolean[N+1];         // 0 제외하고 생성해야하기때문에 N+1
        arr= new ArrayList[N+1];

        for(int i=0;i< arr.length;i++){
            arr[i] = new ArrayList<>();     // 배열에 ArrayList 객체 담는다.
        }


        for(int i=0;i<M;i++){
            stt = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stt.nextToken());
            int b = Integer.parseInt(stt.nextToken());
            arr[a].add(b);          // 양방향, 각 노드에 어떤 child가 있는지 다음과 같이 추가해준다.
            arr[b].add(a);          // 쉽게 말해 arr[i]는 parent 노드라 생각하고 거기에 child를 add해준다.
        }

        for(int i=0;i<arr.length;i++){
            Collections.sort(arr[i]);       // 작은 값부터 방문이므로 뒤에 값을 sort 해준다.
        }

        DFS(V);
        visited = new boolean[N+1];         // 초기화
        sb.append("\n");
        BFS(V);

        System.out.print(sb.toString());
    }

    static void DFS(int start){
        visited[start] = true;          // 방문
        sb.append(start + " ");

        for (int list : arr[start]){        // 해당 값에서 의 child를 다 뽑아서
            if(!visited[list]==true) DFS(list);     // 방문안했으면 DFS로 다시 돌린다. 그럼 밑으로 계속 들어갈것이다.
        }
    }

    static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();      // 큐를 이용해 방문 체크한다.
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int target = queue.poll();          // 방금 넣은 값 빼주고
            sb.append(target + " ");
            for(int list : arr[target]){        // 그 값의 자식들을 또 list로 뽑고
                if(!visited[list]==true) {
                    queue.add(list);            // add 해준다.  -> 이게 중요한데 큐를 이용하기 때문에 어짜피 DFS처럼 계속해서 밑으로 들어가 출력하는 것이 아니라 먼저 같은 선상에 있는 노드를 먼저 다 출력하고 그다음 밑에 있는 값을 출력한다.
                    visited[list] = true;       // 방문
                }
            }
        }
    }

}


/**
 * https://codesign.tistory.com/6
 */
