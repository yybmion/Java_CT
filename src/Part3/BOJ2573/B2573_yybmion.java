package Part3.BOJ2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2573_yybmion {
    static int N;
    static int M;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] bool;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stt = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stt.nextToken());
        M = Integer.parseInt(stt.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;i++){
            stt = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(stt.nextToken());
            }
        }

        boolean flag = false;
        int year = 0;

        while(true){

            if(flagC()){
                flag=true;
                break;
            }

            year++;
            melt();

            int ice = 0;
            bool = new boolean[N][M];

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(!bool[i][j] && map[i][j]>0){
                        ice++;
                        dfs(i,j);
                    }
                }
            }

            if(ice >=2){
                break;
            }


        }

        if(flag){
            System.out.println("0");
        }else{
            System.out.println(year);
        }
    }
    static void dfs(int x,int y){
        bool[x][y] = true;
        for(int d=0;d<4;d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(0<=nx && 0<=ny && nx<N && ny <M) {
                if (!bool[nx][ny] && map[nx][ny] > 0) {
                    dfs(nx, ny);
                }
            }
        }
    }

    static void melt(){
        int[][] copy = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int count = 0;
                if(map[i][j]>0){
                    for(int d=0;d<4;d++){
                        int nx = i+dx[d];
                        int ny = j+dy[d];
                        if(0<=nx && 0<= ny && nx < N && ny < M){
                            if(map[nx][ny]==0) count++;
                        }
                    }
                    if(map[i][j]<count){
                        copy[i][j] = 0;
                    }else{
                        copy[i][j] = (map[i][j] - count);
                    }
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j] = copy[i][j];
            }
        }
    }

    static boolean flagC(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]>0) return false;
            }
        }
        return true;
    }
}

/**
 * too hard ~~~
 * 해당 블로그를 참고하였고
 * 더욱 깊은 이해 후 작성 예정
 * https://developer-ellen.tistory.com/97
 */
