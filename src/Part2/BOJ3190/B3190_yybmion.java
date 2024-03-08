package Part2.BOJ3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B3190_yybmion {

    static int row=0;
    static int col=0;
    public static void main(String[] args) throws IOException {

        class Snake{
            int row;      // 행  가로
            int col;      // 열  세로

            public Snake(int row, int col) {
                this.row = row;
                this.col = col;
            }

            /**
             * 이게 진짜 중요한데 이제야 이 의미를 알겠다.
             * 일단 나는 contains를 이용해서 Snake 클래스 객체의 컬럼값들이 동일한 객체가 있는지 없는지 판단하려했는데
             * 컬럼 값이 같더라도 객체의 메모리 주소가 다르면 다르다고 나오는 것이다.
             * 그래서 이 equals() 메서드를 오버라이드하여 컬럼 값을 비교하도록 합니다.
             */
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Snake snake = (Snake) o;
                return row == snake.row && col == snake.col;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sec =0;

        boolean[][] boolArr = new boolean[N][N];        // 2차원 배열 생성
        Deque<Snake> deque = new LinkedList<>();        // deque는 뱀을 나타낼거임
        String direc = "T";                             // 나중에 D나 L이 나오기 전에 T로 설정

        int rightSnk=1;                                 // 뱀의 진행 방향을 나타내기 위한 변수임
        int leftSnk=1;

        int K = Integer.parseInt(br.readLine());
        int[][] apple = new int[N][N];                  // 사과 위치 배열
        while(K>0) {                                    // 사과 위치 나타냄! 그냥 편하게 정수 `3`으로 사과 위치 나타냄
            StringTokenizer stt = new StringTokenizer(br.readLine(), " ");
            apple[Integer.parseInt(stt.nextToken()) - 1][Integer.parseInt(stt.nextToken()) - 1] = 3;
            K--;
        }

        deque.add(new Snake(0,0));              // 처음은 일단 0,0에서 뱀이 시작하니 먼저 추가해줌

        boolArr[0][0]= true;                            // 방문했으니 TRUE로 해줌

        int L = Integer.parseInt(br.readLine());
        HashMap<Integer, String> locMap = new HashMap<>();      // 이 Map은 입력에서 언제 방향을 바꾸고, 어느방향으로 바꾸는지 나타내는 입력 받는 변수


        for(int i=0;i<L;i++){
            StringTokenizer stt2 = new StringTokenizer(br.readLine()," ");
            locMap.put(Integer.parseInt(stt2.nextToken()), stt2.nextToken());
        }

        while(true){                                            // 본격적으로 뱀 움직여보자
            if(locMap.containsKey(sec)){                        // 먼저 map에서 key만 보려면 containsKey(sec)을 해주면 된다. sec은 매초 ++ 해줄거다.
                if(locMap.get(sec).equals("D")){                // 어짜피 입력에서 sec은 순서대로 입력받으니 이렇게 해도 된다. 그 sec의 value가 `D`인지 `L`인지 판단

                    direc = "D";                                // direc `D`면

                    if(!(apple[row][col]==3)){                  // 먼저 지금 있는 곳에 사과 있는지 부터 판단
                        deque.pollFirst();                      // 있으면 꼬리 잘라줌
                    }else{
                        apple[row][col]=0;  // 먹은 사과 처리     // 그리고 이게 중요한데 사과먹었으면 없애줘야함!!
                    }

                    if(rightSnk==1 && leftSnk ==1) {  //마지막 오른쪽 꺽을때의 콤마 // 이게 진짜 너무 중요하다. 해당 row,col은 마지막에 오른방향을 항상 한번 해준 row,col이다.
                        deque.add(new Snake(++row, col));
                    }else if(rightSnk==1 && leftSnk==2){            // 즉 이걸 예를 들면 이미 left로 한번 뱀이 튼 상태이다. 그럼 뱀은 위를 바라보고있을것이다. 그 상태에서 오른쪽을 한번 볼것이니까 col++이다!!
                        deque.add(new Snake(row,col++));
                    }else if(rightSnk ==1 && leftSnk==3){
                        deque.add(new Snake(row--,col));
                    }else if(rightSnk==1&&leftSnk==4){
                        deque.add(new Snake(row,col--));
                    }
                    if(rightSnk==2 && leftSnk ==1) {
                        deque.add(new Snake(row,col--));
                    }else if(rightSnk==2 && leftSnk==2){
                        deque.add(new Snake(++row,col));
                    }else if(rightSnk ==2 && leftSnk==3){
                        deque.add(new Snake(row, col++));
                    }else if(rightSnk==2&&leftSnk==4){
                        deque.add(new Snake(row--,col));
                    }
                    if(rightSnk==3 && leftSnk ==1) {
                        deque.add(new Snake(row--,col));
                    }else if(rightSnk==3 && leftSnk==2){
                        deque.add(new Snake(row,col--));
                    }else if(rightSnk ==3 && leftSnk==3){
                        deque.add(new Snake(++row,col));
                    }else if(rightSnk==3&&leftSnk==4){
                        deque.add(new Snake(row, col++));
                    }
                    if(rightSnk==4 && leftSnk ==1) {
                        deque.add(new Snake(row, col++));
                    }else if(rightSnk==4 && leftSnk==2){
                        deque.add(new Snake(row--,col));
                    }else if(rightSnk ==4 && leftSnk==3){
                        deque.add(new Snake(row,col--));
                    }else if(rightSnk==4&&leftSnk==4){
                        deque.add(new Snake(++row,col));
                    }

                    rightSnk++;                             // 동서남북 다 한번씩 돌았다면 다시 반복
                    if(rightSnk==5){
                        rightSnk=1;
                    }


                    if((row>(N-1)||row<0||col>(N-1)||col<0)){       // 배열 밖으로 나갔을때
                        System.out.println(sec+1);                  // 초 반환
                        break;
                    }
                    if(boolArr[row][col] == true){          // 벽에 부딪히는거 확인, 그러니까 이미 true인건 꼬리,몸통중간이 있을 수도 있다는 의미이므로 자기 몸통이랑 부딪히는거 확인해준다.
                        Snake pollLast = deque.pollLast();  // 이건 이미 add.deque(row,col)을 한 상태라 무조건 deque에 contains되어있으니 잠시 빼주고 그래도 아직 contains 되어있으면 그건 자기 몸통에 부딪힌거
                        if(deque.contains(new Snake(row,col))){     // 큐에 row,col아직 존재하면 부딪혔다는 의미
                            System.out.println(sec+1);
                            break;
                        }
                        deque.addLast(pollLast);            // 뺴준거 다시 넣어준다.
                    }
                    boolArr[row][col] = true;               // 방문 체크!

                }else{
                    direc="L";

                    if(!(apple[row][col]==3)){
                        deque.pollFirst();
                    }else{
                        apple[row][col]=0;  // 먹은 사과 처리
                    }

                    if(rightSnk==1 && leftSnk ==1) {
                        deque.add(new Snake(row--, col));
                    }else if(rightSnk==2 && leftSnk ==1){
                        deque.add(new Snake(row,col++));
                    }else if(rightSnk ==3 && leftSnk ==1){
                        deque.add(new Snake(row++, col));
                    }else if(rightSnk==4&&leftSnk ==1){
                        deque.add(new Snake(row, col--));
                    }
                    if(rightSnk==1 && leftSnk ==2) {
                        deque.add(new Snake(row, col--));
                    }else if(rightSnk==2 && leftSnk==2){
                        deque.add(new Snake(row--, col));
                    }else if(rightSnk ==3 && leftSnk==2){
                        deque.add(new Snake(row,col++));
                    }else if(rightSnk==4&&leftSnk==2){
                        deque.add(new Snake(row++, col));
                    }
                    if(rightSnk==1 && leftSnk ==3) {
                        deque.add(new Snake(row++, col));
                    }else if(rightSnk==2 && leftSnk==3){
                        deque.add(new Snake(row, col--));
                    }else if(rightSnk ==3 && leftSnk==3){
                        deque.add(new Snake(row--, col));
                    }else if(rightSnk==4&&leftSnk==3){
                        deque.add(new Snake(row,col++));
                    }
                    if(rightSnk==1 && leftSnk ==4) {
                        deque.add(new Snake(row,col++));
                    }else if(rightSnk==2 && leftSnk==4){
                        deque.add(new Snake(row++, col));
                    }else if(rightSnk ==3 && leftSnk==4){
                        deque.add(new Snake(row, col--));
                    }else if(rightSnk==4&&leftSnk==4){
                        deque.add(new Snake(row--, col));
                    }

                    leftSnk++;
                    if(leftSnk==5){
                        leftSnk=1;
                    }


                    if((row>(N-1)||row<0||col>(N-1)||col<0)){
                        System.out.println(sec+1);
                        break;
                    }
                    if(boolArr[row][col] == true){          // 벽에 부딪히는거 확인
                        Snake pollLast = deque.pollLast();
                        if(deque.contains(new Snake(row,col))){     // 큐에 row,col아직 존재하면 부딪혔다는 의미
                            System.out.println(sec+1);
                            break;
                        }
                        deque.addLast(pollLast);
                    }
                    boolArr[row][col] = true;

                }
            }else {  // sec 아닐때 그냥 움직여줄거임
                // 밑에 뱀 움직여주는게 좋을듯?? 그래서 위에 sec 맞을때 저기서 미리 이동시키고 continue해버리게
                if(!(apple[row][col]==3)){
                    deque.pollFirst();
                }else{
                    apple[row][col]=0;  // 먹은 사과 처리
                }

                if(direc=="T"){                         // `R` `D` 나오기 전
                    deque.add(new Snake(row,col++));
                }else {                                 // 여기는 이제 right,left 개수에 따라 움직이는거라 따로 `L` , `D` 분기점 안만들어줘도 됨

                    if(rightSnk==1 && leftSnk ==1) {
                        deque.add(new Snake(row, col++));
                    }else if(rightSnk==1 && leftSnk==2){
                        deque.add(new Snake(--row,col));
                    }else if(rightSnk ==1 && leftSnk==3){
                        deque.add(new Snake(row,col--));
                    }else if(rightSnk==1&&leftSnk==4){
                        deque.add(new Snake(row++,col));
                    }
                    if(rightSnk==2 && leftSnk ==1) {
                        deque.add(new Snake(++row,col));
                    }else if(rightSnk==2 && leftSnk==2){
                        deque.add(new Snake(row,col++));
                    }else if(rightSnk ==2 && leftSnk==3){
                        deque.add(new Snake(row--, col));
                    }else if(rightSnk==2&&leftSnk==4){
                        deque.add(new Snake(row,col--));
                    }
                    if(rightSnk==3 && leftSnk ==1) {
                        deque.add(new Snake(row,col--));
                    }else if(rightSnk==3 && leftSnk==2){
                        deque.add(new Snake(row++,col));
                    }else if(rightSnk ==3 && leftSnk==3){
                        deque.add(new Snake(row,col++));
                    }else if(rightSnk==3&&leftSnk==4){
                        deque.add(new Snake(row--, col));
                    }
                    if(rightSnk==4 && leftSnk ==1) {
                        deque.add(new Snake(row--, col));
                    }else if(rightSnk==4 && leftSnk==2){
                        deque.add(new Snake(row,col--));
                    }else if(rightSnk ==4 && leftSnk==3){
                        deque.add(new Snake(row++,col));
                    }else if(rightSnk==4&&leftSnk==4){
                        deque.add(new Snake(row,col++));
                    }

                }

                if((row>(N-1)||row<0||col>(N-1)||col<0)){
                    System.out.println(sec+1);
                    break;
                }

                if(boolArr[row][col] == true){          // 몸통에 부딪히는거 확인
                    Snake pollLast = deque.pollLast();
                    if(deque.contains(new Snake(row,col))){     // 큐에 row,col아직 존재하면 부딪혔다는 의미
                        System.out.println(sec+1);
                        break;
                    }
                    deque.addLast(pollLast);
                }
                boolArr[row][col] = true;


            }
            sec++;
        }
    }

}

/**
 * 초기 생각
 *
 * 먼저 visit 방문했는지 여부를 알아보기 위해 N*N 2중배열 만들어준다.
 * 만약 방문한곳 또 갔는데 몸통이 여전히 그곳에 있으면 바로 게임 종료
 *
 * 당연히 벽에 부딪히면 게임 종료
 * 이것은 배열 n*n으로 정해져있으니 잘 계산하면 됨
 *
 * 뱀을 큐로 생각하면 될듯??
 * 사과를 먹으면 뒤에 꼬리 부분을 poll해주지 않아도 되고
 * 안먹으면 매초마다 뒤에 꼬리부분 자르고 새로운 머리 add
 *
 * 아니 방향 전환했으면 그방향으로 쭉 내려가야지 뭐하냐... 다시 수정하자
 *
 *
 * 일단 런타임에러가 나서 봤더니
 * 이런 System.exit(0) 쓰지 말란다....
 */