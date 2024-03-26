package Part3.BOJ1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1707_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> list;
        Queue<Integer> queue;
        boolean[] visited;
        int[] colorRes;
        int findVisit = 0;
        int breakPoint = 0;
        String sValue = "YES";

        while (K-- > 0) {
            sValue = "YES";
            breakPoint = 0;
            StringTokenizer stt = new StringTokenizer(br.readLine());
            list = new ArrayList<>();
            queue = new LinkedList<>();
            int V = Integer.parseInt(stt.nextToken());
            int E = Integer.parseInt(stt.nextToken());
            visited = new boolean[V];
            colorRes = new int[V];
            for (int j = 0; j < V; j++) {
                list.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                stt = new StringTokenizer(br.readLine());
                int e1 = Integer.parseInt(stt.nextToken()) - 1;
                int e2 = Integer.parseInt(stt.nextToken()) - 1;

                list.get(e1).add(e2);
                list.get(e2).add(e1);
            }

            colorRes[0] = 1;

            for (int j = 0; j < V; j++) {
                if(visited[j]==false){
                    queue.add(j);
                    visited[j] = true;
                }else{
                    for(int kop : list.get(j)){
                        if(colorRes[j]==1){
                            if(colorRes[kop] ==1){
                                sValue = "NO";
                                breakPoint = 1;
                                break;
                            }
                        }else{
                            if(colorRes[kop] == 2){
                                sValue = "NO";
                                breakPoint = 1;
                                break;
                            }
                        }
                    }
                    if(breakPoint==1){
                        break;
                    }
                    continue;
                }
                if(breakPoint==1){
                    break;
                }

                Integer value = queue.poll();
                if(colorRes[value]==0) colorRes[value]=1;
                for (int ret : list.get(value)) {
                    if (visited[ret] == false) {
                        visited[ret] = true;

                        if (colorRes[value] == 1) {
                            colorRes[ret] = 2;
                        } else {
                            colorRes[ret] = 1;
                        }

                       // queue.add(ret);
                    }
//                    if (colorRes[value] == colorRes[ret]) {
//                        sValue = "NO";
//                        breakPoint = 1;
//                        break;
//                    }
                }
//                if (breakPoint == 1) break;
//                if (queue.isEmpty()) {
//                    findVisit = 0;
//                    while (visited[findVisit] != false) {
//                        if (findVisit == V - 1) break;
//                        findVisit++;
//                    }
//                    queue.add(findVisit);
//                    if (findVisit == V - 1) queue.clear();
//                }

            }
//            for(int r=0;r<V-1;){
//                if(colorRes[r]==1) {
//                    if (colorRes[++r] == 1) {
//                        sValue = "NO";
//                        break;
//                    }
//                }else{
//                    if(colorRes[++r]==2) {
//                        sValue = "NO";
//                        break;
//                    }
//                }
//            }
            sb.append(sValue + "\n");
        }

        System.out.println(sb.toString());

    }
}
