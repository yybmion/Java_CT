package Part1.BOJ2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B2751_99hyeon {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> list = new ArrayList<>();

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for(int i = 0; i < num; i++){
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}

/**
 * 시간 초과가 총 2번이 났다.
 * 첫 번째는 아래 코드로 Arrays.sort함수를 사용해서 시간초과가 났다.
 * 찾아보니
 * Arrays.sort()는 Dual Pivot QuickSort를 사용한 정렬 방식으로 보통 QuickSort보다 빠르지만
 * 최악의 경우 O(n^2)가 발생할 수 있다.
 * 그래서 Arrays.sort()대신 Collections.sort()를 사용하였다.
 * Collections.sort()는 TimeSort라는 삽입정렬과 병합정렬을 결합한 정렬방식을 사용하였고
 * 시간복잡도는 평균, 최악의 상황에 상관없이 O(nlogn)을 가진다.
 *
 * Arrays.sort() 대신 Collections.sort()를 사용해도 시간초과가 났다.
 * 찾아보니 출력부분에서 시간초과가 발생하였다.
 * System.out.println()은 synchronized bolck으로 씌워져 있어 동기화가 이루어져 오버헤드가 따른다고 한다.
 * StringBuilder를 사용하면 시간적인 측면과 메모리적인 측면에서 더 효율적이라고 한다.
 * 그래서 출력을 StringBuilder를 사용해서 하였다.
 * 참고로
 * sb.append("출력할내용\n")보단 sb.append("출력할내용").append("\n");이 더 효율적이라고 한다.
 *
 */

//  시간 초과 코드
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int num = Integer.parseInt(br.readLine());
//        int[] list2 = new int[num];
//
//        for(int i = 0; i < num; i++){
//            list2[i] = Integer.parseInt(br.readLine());
//        }
//
//        Arrays.sort(list2);
//
//        for(int i = 0; i < num; i++){
//            System.out.println(list2[i]);
//        }
//        br.close();
//    }
