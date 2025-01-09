package Part3.BOJ1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return weight-o.weight;
    }
}
public class B1197_yybmion {
    static StringTokenizer stt;
    static int v;
    static int e;
    static int[] parent;
    static PriorityQueue<Edge> queue;
    static int count;
    static int value;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        stt = new StringTokenizer(br.readLine());

        v=Integer.parseInt(stt.nextToken()); //3
        e=Integer.parseInt(stt.nextToken()); //3
        queue = new PriorityQueue<>();
        parent = new int[v+1];
        count=0;
        value=0;

        for(int i=1;i<=v;i++){              // 초반에는 parent를 모두 자기 번호로 다 초기화시켜준다.
            parent[i]=i;
        }
        // 1|2|3
        // 1|2|3
        for(int i=0;i<e;i++){               // 이제 우선순위큐에 위에 정렬 기준(가중치)를 통해 큐에 넣어준다. 그러면 가중치가 적은 순서대로 들어갈것이다.
            stt = new StringTokenizer(br.readLine());

            queue.offer(new Edge(Integer.parseInt(stt.nextToken()),Integer.parseInt(stt.nextToken()),Integer.parseInt(stt.nextToken())));

        }
        while(!queue.isEmpty()){            // 큐가 빌때까지 가중치 적은 것 부터 가져와 그것의 부모(parent)가 다르면 union할수있는것이므로 하주고 가중치도 더해준다.
            Edge edge = queue.poll();
            if(find(edge.start)!=find(edge.end)){
                union(edge.start,edge.end);
                count+=edge.weight;
            }
        }

        System.out.println(count);

    }

    static void union(int e1,int e2){
        int x = find(e1);
        int y = find(e2);

            if(x<y){            // union해줄때는 작은 값을 parent로 초기화시켜준다.
                parent[y]=x;
            }else{
                parent[x]=y;
            }

    }
    static int find(int i){     // Parent가 누군지 찾아주는 메서드     // 쉽게 생각해서 만약 연결되어있으면 계속 타고 올라가서 parent찾아줌
        if(parent[i]==i) return i;
        return find(parent[i]);
    }
}
