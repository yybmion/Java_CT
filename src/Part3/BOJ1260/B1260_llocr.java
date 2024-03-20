package Part3.BOJ1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1260_llocr {
    static boolean visitedDFS[];
    static boolean visitedBFS[];
    static StringBuilder resultDFS = new StringBuilder();
    static StringBuilder resultBFS = new StringBuilder();
    static int N, M, V;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visitedDFS = new boolean[N+1];
        visitedBFS = new boolean[N+1];

        arr = new ArrayList[N+1];

        for(int i = 1; i<N+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x].add(y);
            arr[y].add(x);
        }

        for (int i = 1; i < arr.length; i++) {
            Collections.sort(arr[i]);
        }

        DFS(V);
        BFS(V);
        System.out.println(resultDFS);
        System.out.println(resultBFS);
    }

    private static void DFS(int v) {
        visitedDFS[v] = true;
        resultDFS.append(v).append(" ");

        for(int next : arr[v]) {
            if(!visitedDFS[next]) {
                DFS(next);
            }
        }
    }

    private static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visitedBFS[v]=true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            resultBFS.append(now).append(" ");

            for(int next : arr[now]) {
                if(!visitedBFS[next]) {
                    visitedBFS[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
