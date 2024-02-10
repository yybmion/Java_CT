package Part1.BOJ2750;

import java.util.Arrays;
import java.util.Scanner;

public class B2750_limjunhyuk97 {

    public static final int MAX_N = 1005;

    public static int N;

    public static int arr[];

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        N = sc.nextInt();

        arr = new int[N];

        for(int i=0; i<N; ++i) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for(int i=0; i<N; ++i) {
            System.out.println(arr[i]);
        }
    }

}

/**
 * [정렬] Arrays.sort() (https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#sort-java.lang.Object:A-)
 * - public static void sort(Object[] a)
 * - public static void sort(Object[] a, int fromIndex, int toIndex)
 * - public static <T> void sort(T[] a, Comparator <? super T> c)
 * - public static <T> void sort(T[] a, int fromIndex, int toIndex, Comparator <? super T> c)
 *
 * (1) public static void sort(Object[] a)
 * - 기본적으로 오름차순(Natural Ordering)으로 정렬함
 * - 이러한 정렬이 가능하기 위해서는 배열 각 element 에 "Comparable" Interface가 존재해야 함
 * - 정렬에는 Merge Sort 정도의 O(NlogN) ~ O(N^2) 의 시간 복잡도가 소요됨
 *
 * (1-1) Interface Comparable<T> (https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html)
 * - int compareTo(T o1, T o2) 라는 메서드를 필요에 따라 재정의 해야 한다.
 * - (개념적으로) o1 < o2 라면 negative return 해야 함 / 순서 뒤집힘 X
 * - (개념적으로) o1 == o2 라면 zero 해야 함 / 순서 뒤집힘 X
 * - (개념적으로) o1 > o2 라면 positive return 해야 함 / sort 메서드에 의한 element 간 순서 뒤집힘을 일으킨다.
 *
 * public class Test {
 *
 *     // Comparable implement 수행
 *     public static class Coordinate implements Comparable<Coordinate>{
 *         public int x;
 *         public int y;
 *
 *         public Coordinate(int x, int y) {
 *             this.x = x;
 *             this.y = y;
 *         }
 *
 *         public String toString() {
 *             return "(x: " + this.x + ", y: " + this.y + ")";
 *         }
 *
 *         // Comparable 활용 위한 compareTo 재정의
 *         public int compareTo(Coordinate o2) {
 *             if(this.x != o2.x) return o2.x - this.x;
 *             else return o2.y - this.y;
 *         }
 *     }
 *
 *     public static void main(String[] args) {
 *         Coordinate coo[] = new Coordinate[5];
 *
 *         for(int i=0; i<5; ++i) {
 *             coo[i] = new Coordinate((int)(Math.random()* 10), (int)(Math.random()* 10));
 *         }
 *
 *         // sort 전
 *         System.out.println("Before Sorting");
 *         for(int i=0; i<5; ++i) {
 *             System.out.println(coo[i]);
 *         }
 *
 *         // sort
 *         // this.x == o2.x 일 때는 순서 안바꾸고, o2.x - this.x > 0 일 때만 순서를 바꾸므로, x 내림차순 우선 정렬
 *         // this.y == o2.y 일 때는 순서 안바꾸고, o2.y - this.y > 0 일 때만 순서를 바꾸므로, 차순위로 y 내림차순 우선 정렬
 *         Arrays.sort(coo);
 *
 *         // sort 후
 *         System.out.println("After Sorting");
 *         for(int i=0; i<5; ++i) {
 *             System.out.println(coo[i]);
 *         }
 *     }
 * }
 *
 * (2) public static void sort(Object[] a, int fromIndex, int toIndex)
 * - fromIndex 이상 ~ toIndex 미만 사이의 값을 정렬함
 *
 * (3) public static <T> void sort(T[] a, Comparator <? super T> c)
 * - Comparator Interface 를 건네 주어, Comparator 의 방식대로 정렬을 수행한다.
 * - 구체적으로는 Comparator Interface 내의 compare 메서드가 ClassCastException을 발생시키지 않도록 "total Ordering" 을 제공해야 한다
 *
 * (3-1) Interface Comparator<T> (https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html)
 * - int compare(T o1, T o2) 라는 메서드를 재정의 해야 한다
 * - (개념적으로) o1 < o2 라면 negative return 해야 함 / 순서 뒤집힘 X
 * - (개념적으로) o1 == o2 라면 zero 해야 함 / 순서 뒤집힘 X
 * - (개념적으로) o1 > o2 라면 positive return 해야 함 / sort 메서드에 의한 element 간 순서 뒤집힘을 일으킨다.
 *
 * public class Test {
 *
 *     public static class Coordinate {
 *         public int x;
 *         public int y;
 *
 *         public Coordinate(int x, int y) {
 *             this.x = x;
 *             this.y = y;
 *         }
 *
 *         public String toString() {
 *             return "(x: " + this.x + ", y: " + this.y + ")";
 *         }
 *     }
 *
 *     public static void main(String[] args) {
 *         Coordinate coo[] = new Coordinate[5];
 *
 *         for(int i=0; i<5; ++i) {
 *             coo[i] = new Coordinate((int)(Math.random()* 10), (int)(Math.random()* 10));
 *         }
 *
 *         // sort 전
 *         System.out.println("Before Sorting");
 *         for(int i=0; i<5; ++i) {
 *             System.out.println(coo[i]);
 *         }
 *
 *         // sort
 *         // o1.x == o2.x 일 때는 순서 안바꾸고, o1.x - o2.x > 0 일 때만 순서를 바꾸므로, x 오름차순 우선 정렬
 *         // o2.x == o2.y 일 때는 순서 안바꾸고, o1.y - o2.y > 0 일 때만 순서를 바꾸므로, 차순위로 y 오름차순 우선 정렬
 *         Arrays.sort(coo, new Comparator<Coordinate>() {
 *             @Override
 *             public int compare(Coordinate o1, Coordinate o2) {
 *                 if(o1.x != o2.x) return o1.x - o2.x;
 *                 else return o1.y - o2.y;
 *             }
 *         });
 *
 *         // sort 후
 *         System.out.println("After Sorting");
 *         for(int i=0; i<5; ++i) {
 *             System.out.println(coo[i]);
 *         }
 *     }
 * }
 *
 * (4) public static <T> void sort(T[] a, Comparator <? super T> c)
 * - fromIndex 이상 ~ toIndex 미만 사이의 값을 정렬함
 *
 * (5) 정리
 * - Arrays.sort() 메서드를 통해 정렬하기 위해서는 ...
 *      - 배열의 요소들에 'Comparable' Interface 가 존재해야 한다
 *      - sort() 메서드에 'Comparator' Interface 를 넘겨주어야 한다
 *      - fromIndex <= elements < toIndex 사이를 정렬할 수 있다.
 *
 *
 * [추가 정리] Generic Programming
 *
 * (1) Generic Class
 * - Polymorphism 의 일종이다
 * - 다양한 type 으로 확장될 수 있는 Class 를 정의하는 방식
 * - 기존에는 Object class 를 통해서 이를 구현하려 하였으나, Compiler 의 type checking 이 엄밀히 이루어지지 못하는 것이 한계였다.
 *
 * public class Pair {
 *
 *     private Object field;
 *
 *     public Pair() { field = null; }
 *
 *     public Pair(Object obj) { field = obj; }
 *
 *     public Object getField() { return this.field; }
 *
 *     public void setField(Object obj) { this.field = obj; }
 * }
 *
 * - Generic Class 를 활용하면
 *      - type 에 따라 여러 Class 를 형성해야 하는 번거로움 제거
 *      - Object class 를 활용할 경우 발생하는 컴파일러의 타입 체크 불가능 문제 해결
 *
 * (2) Generic Method
 * - 마찬가지로 다양한 type으로 확장할 수 있는 Method 를 정의하는 방식
 *
 * (3) Type Variable
 * - Class 나 Method 의 Definition 전반에 Type Variable 을 사용하여 유연한 타입 확장을 가능하게 할 수 있다
 * - Type Variable 명칭 예시 : T(ype), E(lement), K(ey), N(umber) 등등 ...
 * - 이때 T가 어떤 필드, 메서드를 갖는지 모호할 수 있는데 이를 해결하기 위해 Inheritance Rules 를 활용할 수 있다.
 *
 *
 * (4) Inheritance Rules
 * - Upper Bounded WildCard : <? extends superClass>
 *      - superClass 가 super 의 마지노
 *      - 이 경우 setter 메서드에서 문제 발생할 수 있다.
 * - Lower Bounded WildCard : <? super subClass>
 *      - subClass 가 child 의 마지노
 *      - 이 경우 getter 메서드에서 문제 발생할 수 있다.
 * - 이런 wildCard에 대한 개념들은 Java 공식문서 (Collection Framework) 에서 개념들을 살펴볼 때 중요함
 *
 */
