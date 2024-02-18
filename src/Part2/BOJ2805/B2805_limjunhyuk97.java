package Part2.BOJ2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class B2805_limjunhyuk97 {

    public static final int MAX_HEIGHT = 2000000000;

    public static int N, M;

    public static int trees[];

    public static int height;

    public static String[] input;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static boolean aIsBiggerThanB (BigInteger a, BigInteger b) {
        if(a.compareTo(b) > 0) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {

        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        // Arrays.stream(String[]).mapToInt(Integer::parseInt).toArray() : String 배열을 Int형 배열로 변환해 줌
        input = br.readLine().split(" ");
        trees = Arrays.stream(input).mapToInt(tree -> Integer.parseInt(tree)).toArray();

        int left=0, right=MAX_HEIGHT, mid=(left+right)>>1;
        BigInteger remainer = new BigInteger("0");

        // 이분탐색
        // 경우 1 : ~를 만족하는 조건 중 가장 큰 값
        // 경우 2 : ~를 만족하는 조건 중 가장 작은 값
        // 해당 문제는 "경우 1" 에 해당함
        while(left<=right) {

            mid = (left+right)>>1;
            remainer = new BigInteger("0");

            for(int tree : trees) {
                if(tree > mid) remainer = remainer.add(BigInteger.valueOf(tree-mid));
                else continue;
            }

            // 나무들 자른게 아직 부족하다면, 나무를 더 자른다
            // 나무를 더 자르는 것은 mid(자르는 길이)를 내리는 것과 같다.
            // 이는 left, right 를 왼쪽으로 옮기는 것이다.
            if(aIsBiggerThanB(BigInteger.valueOf(M), remainer)) {
                right=mid-1;
            }

            // 나무를 자른게 넉넉하다면, 나무를 덜 자른다
            // 나무를 덜 자르는 것은 mid(자르는 길이)를 올리는 것과 같다.
            // 이는 left, right 를 오른쪽으로 옮기는 것이다.
            else {
                left=mid+1;
            }
        }

        System.out.println(right);

    }

}

/**
 *
 * 1) BigInteger 범위에 대한 고려 필요
 *
 * - BigInteger 생성
 *      - new BigInteger(String)
 *      - BigInteger(long)
 *
 * 2) BufferedReader, String.split(), Integer.parseInt()
 *
 * - BufferedReader.readline() 으로 문자열 읽어들임
 * - String.split() 으로 쪼개기
 * - Integer.parseInt() 로 int type 으로 변경
 *
 * 3) Arrays.stream(String<Stream> val).mapToInt(ToIntFunction<? super T> mapper).toArray()
 *
 * - Arrays.stream()
 *      - public static <T> Stream<T> stream(T[] array)
 *          - T 타입의 배열을 Stream<T> 타입으로 바꿔서 return 해준다.
 * - Stream<T>
 *      - Interface Stream<T>
 *      - Stream 은 sequential operation (순차적 연산) 이나, parallel 한 aggregation operation (병렬 집계 작업) 을 가능하게 해준다.
 *      - 주로 살펴 봐야 할 것은 sequential operation 부분임
 *          - Stream.forEach(Consumer<? super T> action) : void
 *          - Stream.filter(Predicate<? super T> predicate) : Stream<T>
 *          - Stream.mapToInt(Integer::parseInt) : Stream<int>
 *          - Stream.mapToInt(val -> Integer.parseInt(val)) : Stream<int>
 * - Stream<T>.toArray()
 *      - Stream 타입에서 배열 형태로 반환
 *
 * 4) 이분탐색
 *
 * - [정리본1] (https://github.com/limjunhyuk97/algorithm-practice/tree/main/BinarySearch)
 * - [정리본2] (https://github.com/limjunhyuk97/problem-solving-space/blob/main/%EC%9C%A0%ED%98%95_CPP_VER/%EC%9D%B4%EB%B6%84%ED%83%90%EC%83%89(CPP).md)
 *
 */