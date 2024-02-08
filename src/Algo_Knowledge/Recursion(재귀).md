# Recursion (재귀)
```markdown
목차

1. What is Recursion?
2. Example about recursion
3. why & why not(Pros & Cons)
4. Understanding Call Stack
5. Variable recursion example
   
    - String reversal
    - Palindrome
    - Decimal To Binary
    - Divide & Conquer
    - Binary Search
    - Fibonacci
    - Merge Sort
    - Linked List
    - Tree
    - Graph
    - Memoization


```
## 1.What is Recursion?
- 재귀함수는 함수내에서 **자기 자신**을 다시 호출하는 함수를 의미한다.
- 예시는 아래서 알아보겠다.
- 자기자신을 호출하기 때문에 **종료조건**이 없으면 무한루프를 돌 수가 있다.
- 따라서 재귀함수에는 **재귀의 탈출조건**을 반드시 작성해주어야한다.

## 2. Example about recursion
```java
public void recursion(int someValue){
	if(someValue == 10){
		return;	
	}
	return recursion(someValue + 1);
}
```

- 계속해서 자기 자신을 호출하다가 someValue 가 10이 되면(**종료조건**) 재귀를 끝낸다.
## 3. Why & Why Not (Pros & Cons)
✔️ 재귀를 **사용하려는 이유**와 **사용하지 않으려는 이유**에 대해 얘기해보자.

- **1. PROS**: 우선 코드가 **간결**해진다.
    - 앞으로 **트리나 그래프**와 같은 복잡한 데이터 구조를 탐색하는 다양한 문제를 살펴볼것이다.
    - 이는 만약 우리가 명령형 접근법을 사용한다면 수많은 **반복문과 변수**를 사용해서 처리해야하는 어쩌면 아주 더러워질 수 있는 **코드를 간결**하게 만들어준다.
  
- **2. PROS**: 재귀는 **최적화**와 관련된 많은 이점을 가진다.
  - **메모이제이션**(Memoization)이라는 개념과 관련있으며
  - 중복 호출을 빠르게 처리하는 데 도움이 된다.

- **1. CONS**: 메소드 호출에 따른 **CPU 오버헤드**
  - 루프를 통한 반복문 처리에 비해 조금 느릴 수 있다.
  - **Stack Overflow** 발생할 수 있다.

## 4. Understanding Call Stack
- 콜 스택은 **메모리 구조**를 보았으면 쉽게 이해할 수 있을것이다.
- 메모리 구조는 다음과 같다.

![img.png](img.png)

- 우리가 함수를 호출할 때 마다 저 스택 영역에 함수가 차곡차곡 쌓인다.
- 예를 들어보자

```java
public String A(){  
    return "hello " + B();  
}  
  
public String B(){  
    return "my " + C();  
}  
  
public String C(){  
    return "friends.";  
}
```

실행을 한다면

![img_1.png](img_1.png)

- 다음과 같이 **Stack**에 쌓일 것이다.
- 그럼 마지막 C는 더 이상 어떤 함수를 호출하지 않고 값을 반환하니
- "friends"를 반환하고 **call stack**에서 **POP**된다.
- C()의 반환값이 friends에 들어가며 B()는 "my friends" 를 반환하고 똑같이 **call stack**에서 **pop**된다.
- 마지막 A()는 "hello my friends" 를 반환하고 프로그램은 종료된다.

✔️ 종료조건이 없으면?
- 종료조건이 없으면 계속해서 메소드를 호출(Push)하고 **이용가능한 메모리**를 넘어 **힙**(Heap)까지 메모리 영역을 침범하는
- **Stack Overflow**가 발생한다.
- 따라서 **Base case**(종료조건)을 꼭 설정해주자.

## 5. Variable recursion example
### ✔️ 1. String Reversal

> input : plain
> 
> output : nialp

다음과 같이 출력이 입력의 역순으로 나타내야 할 때 사용할 수 있다.

- 먼저 우리가 재귀함수를 작성할 때 항상 두 가지 질문에 대한 해답을 찾아야한다.
    - **종료조건은 무엇인가?**
    - **다음 재귀를 부를때 어떻게 프레임을 줄여 나갈 것인가?**

```java
public String reverseString(String input){  
    // 종료조건  
    if(input.equals("")){  
        return "";  
    }  
    // 다음 재귀를 위해 종료조건 까지의 프레임 줄여나가기   
return reverseString(input.substring(1)) + input.charAt(0);  
}
```

**스택**으로 보자면

![img_2.png](img_2.png)

- 다음과 같이 subString으로 첫번째 문자를 제외한 문자열을 다음 재귀함수로 보낸다.
- 계속해서 맨 첫번째 문자를 제외하고 재귀를 호출하다보면
- 언젠가 ""를 마주하고 이는 **종료조건** 이므로 값을 반환하기(**Stack PoP**) 시작한다.
- "hello"를 입력하면 역순인 "olleh"를 반환할 것이다.

### ✔️ 2. Palindrome
> 팰린드롬은 앞으로 읽어도 뒤로 읽어도 동일한 단어를 의미한다.
> 이 문제는 양쪽 끝을 살펴보고, 이 글자들이 일치하는지 확인하고, 일치한다면 양쪽 끝을 줄여나가며 계속 확인한다. 최종적으로 한글자 or 글자가 딱 맞는다면 팰린드롬이다.
> 
> input : racecar
> 
> output : true

```java
public static boolean isPalindrome(String input){  
      
    // 종료조건  
    if(input.length() == 0 || input.length() == 1){  
        return true;  
    }  
    // 종료조건 까지 줄여나가기  
    if(input.charAt(0) == input.charAt(input.length()-1)){  
        return isPalindrome(input.substring(1,input.length()-1));  
    }  
      
    // 추가 종료조건  
    return false;  
}
```

![img_3.png](img_3.png)

- 글자가 더이상 없거나 하나만 남을때는 팰린드롬 이므로 true반환
- 양쪽 끝 값들끼리 비교해가며 동일하면 그다음 양쪽끝을 **재귀로 보내 또 확인**
- 반복

### ✔️ 3. Demical To Binary
> 10진수를 2진수로 변환한다.
> input: 233
> output: 11101001

```java
public static String findBinary(int decimal, String result){  
    if(decimal == 0){  
        return result;  
    }  
      
    result = decimal % 2 + result;  
    return findBinary(decimal / 2, result);  
}
```

![img_4.png](img_4.png)

- 2를 나누고 그 값의 결과를 다음 재귀에서 사용해야하므로
- 파라미터로 보내준다.

### ✔️ Divide & Conquer
- 재귀의 대표적인 예시인 분할 정복(Divide and conquer) 알고리즘에 대해 알아보자
- 분할 정복은 큰 문제를 여러 개의 작은 문제로 나누는 것이다.
- 작은 문제들을 독립적으로 해결한 후에 결과를 병합하여 종합적인 문제를 해결한다.
- 이는 재귀적인 방식으로 이루어진다.
- 이는 이진탐색(Binary search)로 알아보자.

### ✔️ 4. Binary Search
> 이진 탐색은 정렬된 숫자 목록을 살펴본다. 예를 들어 배열이라 하면 꼭 숫자가 정렬되어있어야한다.

![img_5.png](img_5.png)

해당 ARRAY에서 10이라는 숫자를 찾는다고 해보자

```java
public static int binarySearch(int[] A, int left, int right, int x){  
    if(left > right){  
        return -1;  
    }  
    int mid = (left + right) / 2;  
    
        if(x == A[mid]){  // 해당 값을 찾으면 그 인덱스 반환
        return mid;  
    }  
      
    if(x < A[mid]){   // 잘랐을때 그 mid인덱스의 값이 찾는 값보다 크면
        return binarySearch(A,left,mid -1, x);  
    }  
      // 잘랐을때 그 mid인덱스의 값이 찾는 값보다 작으
    return binarySearch(A,mid + 1, right, x);  
}
```

- MID즉 반을 나누어 그 INDEX의 값이 찾는 10보다 작은지 큰지 확인한다.
- 정렬되어있기 때문에 쉽게 찾을 수 있다.
- 찾는 값이 더 크기 때문에 마지막 15줄 재귀함수를 실행한다.
- 이렇게 계속해서 반으로 나누고 찾는 값의 크기를 비교해간다.

![img_6.png](img_6.png)

- 마지막 STACK 함수에서 10을 찾았으니(종료조건) 순서대로 POP해 나아간다.

### ✔️ 5. Fibonacci (Non-Optimized)
> 나중에 **Memoization**을 통해 최적화를 해보자. 여기서는 최적화되지 않은 버젼을 볼것이다. **피보나치**(Fibonacci)는 어떤 입력 값이 n인 경우, 해당 인덱스의 값은 그 이전 두 인덱스의 값의 합으로 구성된다는 것을 알고있을 것이다.


![img_7.png](img_7.png)

- 예를 들어 위의 그림을 보면 13의 값은 이전 두개의 인덱스의 값의 5와 8의 합으로 나타낼 수 있다.

```java
public static long fib(long n){  
    if((n==0) || (n==1))  
        return n;  
    else
	    return fib(n-1) + fib(n-2);  
}
```

- n=5로 예를 들어보자
- 즉, 5의 인덱스의 피보나치 값을 찾을 것이다.
- 어쩃든 해당 값을 찾으려면 바로 전의 인덱스 값과 또 그전의 인덱스 값을 모두 알필요가 있다.
- 그러므로 일단 fib(n-1)과 fib(n-2)를 하면 종료조건까지 모든 이전의 값들을 찾을 수 있다.
- 이후 종료조건을 만나면 인덱스 0,1부터 값을 더해나가기 시작한다.
- 그러면 결국 5번째 인덱스의 값을 찾을 때 그 전 인덱스 4,3의 값을 반환하며 더해 결과를 얻을 수 있다.
- 그림을 보면 이해가 쉬울 것이다.

![img_8.png](img_8.png)

- 다음과 같은 구조로 이루어져 있다.
- 하지만 여기서 문제가 있다. **중복되는 값**들이 존재한다는 것이다.
- 이러한 값들을 찾기 위해 다시 밑으로 뿌리를 내리며 재귀를 호출하는 것은 매우 **낭비**이다.
- 따라서 이후 **Memoization** 기법을 이용해 최적화를 해볼것이다.
### 6. Merge Sort
> 정렬되지 않은 값들을 입력으로 받는다. 그리고 배열을 나누너 정렬된 결과를 병합하여 배열을 오름차순으로 정렬하는 알고리즘이다.

과정은 다음과 같다.

예를 들어 다음과 같이 1부터 8까지 총 8개의 숫자가 들어있는 배열이 있다고 가정해보자

```java
[6, 5, 3, 1, 8, 7, 2, 4]
```

배열을 반으로 계속해서 쪼갠다.

```java
[6, 5, 3, 1] [8, 7, 2, 4]
```

```java
[6, 5] [3, 1] [8, 7] [2, 4]
```

```java
[6] [5] [3] [1] [8] [7] [2] [4]
```

더이상 쪼갤 수 없을때 아까 쪼갠 그룹대로 정렬해가며 merge합니다.

```java
[5, 6] [1, 3] [7, 8] [2, 4]
```

```java
[1, 3, 5, 6] [2, 4, 7, 8]
```

최종적으로 2개의 배열도 마찬가지로 크기 순으로 정렬하면 하나의 정렬된 배열을 얻을 수 있다.

```java
[1, 2, 3, 4, 5, 6, 7, 8]
```

- 코드를 통해 알아보자

```java
  static int[] sortArr; // 정렬한 리스트를 담을 임시배열
  public static void merge(int[] arr, int left, int mid, int right){
    /* 2개의 부분배열 arr[left ... mid] 와 arr[mid+1 ... right] 의 합병정렬 */
        int i = left; // 정렬된 왼쪽 리스트에 대한 인덱스
        int j = mid + 1; // 정렬된 오른쪽 리스트에 대한 인덱스
        int k = left; // 정렬될 리스트에 대한 인덱스
        sortArr = new int [arr.length];
        while(i<=mid && j<=right){   // 5개와 5개가 마지막에 MERGE된다고 생각하면 먼저 왼쪽 5개가 임시 배열에 SORT되어 들어가면 이 WHILE문이 끝나기에
            if(arr[i] <= arr[j])
                sortArr[k++] = arr[i++];
            else
                sortArr[k++] = arr[j++];
        }

        // 남아있는 값들 일괄 복사                  // 여기 남아있는 오른쪽 값들을 임시 배열에 넣어준다고 생각하면 된다.
        if(i>mid) {
            for(int l = j; l<=right;l++)
                sortArr[k++] = arr[l];
        } else {
            for(int l = i; l <=mid;l++)
                sortArr[k++] = arr[l];
        }

        // 임시배열 (sortArr)의 리스트를 배열 arr로 재복사
        for(int l=left; l<=right; l++){
            arr[l] = sortArr[l];
        }}

  public static void merge_sort(int[] arr, int left, int right){
        if(left < right) {
            int mid = (left + right) /2; // 리스트를 균등한 크기로 분할 (Divide)
            merge_sort(arr, left, mid); // 앞 부분 배열 정렬 (Conquer)
            merge_sort(arr, mid+1, right); // 뒷 부분 배열 정렬 (Conquer)
            merge(arr, left, mid, right); // 정렬된 2개의 부분 배열을 합병 (Combine)
  }}
    
  public static void main(String[] args) throws IOException {
  
        int[] arr = {5,4,3,2,6};

        merge_sort(arr, 0, arr.length-1);

        for(int i : arr){
            System.out.println(i);
  }}
```

- 배열 5,4,3,2,6
- merge_sort 메소드에 `배열`과 `0인덱스` `마지막 인덱스`를 파라미터로 보내준다.
- 그러면 이 나누는 작업의 **재귀의 종료시점**은 무엇일까?
- 바로 **left>right**이다.  그러므로 **left<right**일 때는 계속해서 나눈다.
- mid를 구해서 왼쪽 오른쪽으로 나누어 **merge_sort**(블록 나누기)를 계속해서 진행한다.
- 그러다 왼쪽이 더이상 나누어지지 않고(`첫번째 merge_sort`) 오른쪽을 나누고 그 오른쪽도 다 나누어지면(`두번쨰 merge_sort`) `merge메소드`를 실행하여 **merge**를 진행한다.

- merge도 살펴보자
- 일단 제일 최근 오른쪽이 더이상 쪼개지지 않아서 merge단계에 들어왔으니 **오른쪽을 merge**할것이다.
- 값을 임시로 저장할 **sortArr**을 만들어주고 왼쪽이나 오른쪽 중 어느 한쪽이 sortArr에 모두 정렬된 상태로 들어가면 while문을 빠져나오고
- 이후 남아있는 값을 sortArr에 정렬해준다.
- 그리고 그 임시 배열 sortArr값들을 이제 우리 원래의 arr에 다시 저장한다.

### ✔️ 7. Linked List

### ✔️ 8. Tree
> 이진트리(Binary Tree)는 위에서부터 아래로 시작하여 여러 연결이 형성되어있다.
> 하나의 노드에서 가질 수 있는 자식의 수는 최대로 2이고 최소로 0이다. 여기에 여러 숫자를 추가하며 트리의 특성을 분석해보자

![img_9.png](img_9.png)

다음과 같은 이진트리가 있다고 가정해보자

- 루트 노드 100의 왼쪽에 있는 모든 것은 100보다 작고, 오른쪽에 있는 모든 것은 100보자 크다.
- 이 속성은 재귀적으로 계속 성립한다.
- 이 규칙에서 우리는 노드 108을 삽입한다고 가정해보자
- 우린 108 루트노드 부터 계속해서 값을 비교해가며 108이 어떤 자리에 들어갈지 재귀적으로 판단할 수 있다.

![img_10.png](img_10.png)

```java
public Node insertNode(Node head, int data){  
    if(head == null){  
        head = new Node();  
        head.data = data;  
        return head;  
    }  
      
    if(head.data < data){  
        head.right = insertNode(head.right,data);  
    }else{  
        head.left = insertNode(head.left, data);  
    }  
    return head;  
}
```

- 콜스택을 보며 흐름을 이해해보면 쉬울것이다.
- 예시는 아까 그림에서 108의 값을 새로운 노드로 추가하기 위한 알고리즘이다.

![img_11.png](img_11.png)

- insert_node 함수를 호출한다.
- 100과 108을 비교한다. 108이 100보다 크다는 것을 알고 오른쪽 재귀로 이동한다.
- 또 다른 스택 프레임이 쌓인다.
- 그리고 120과 108을 비교한다. 108이 120보다 작은 것을 알고 왼쪽 재귀로 이동한다.
- 스택 프레임이 쌓이며 108과 110을 비교한다. 작으므로 왼쪽 재귀이동
- 비교대상이 더이상 없다 그래서 이는 종료조건이므로 108 노드를 생성하고 반환한다.
- 콜스택 반환

##### ✔️ Print All Leaf Node
이 노드를 다 출력하고 싶다면 어떻게 해야할까?

코드로 바로 살펴보자 . 참고로 insert_Node가 되었다고 가정하고 다음코드를 실행하는 것이다.

```java
public static void printLeaves(Node root){  
    if(root == null) return;  
        if(root.left == null && root.right == null){  
        System.out.println(root.val + ", ");  
        return;    }  
      
    if(root.left != null)  
        printLeaves(root.left);  
    if(root.right != null)  
        printLeaves(root.right);  
}
```

간단하다 계속해서 노드를 내려가서 null을 만나면 그 노드를 print하는 알고리즘이다.
자세한 설명은 생략하겠다.
### ✔️ 9. Graph (DFS)
> 그래프는 DFS라는 아주 인기있는 알고리즘을 통해 알아보자

![img_12.png](img_12.png)

- 우린 노드 A에서 시작해서 노드 H를 찾고 있다고 가정한다.

A에서 시작해서 이 값이 내가 찾는 값인지 확인하기 위해 모든 이웃을 살펴본다.
A는 내가 찾는 값이 아니므로 이웃인 B로 이동한다. B 역시 내가 찾는 값이 아니므로 C로 이동한다. D도 내가 찾는 값이 아니지만 이웃들을 모두 확인해보자. 이 과정에서 흥미로운 점은 나는 H를 찾고 있는데, H는 아주 먼 곳에 있다. 이웃들을 살펴보면, 첫 번째 이웃이 E라고 가정해보자 그래서 나는 H로 가기 전에 실제로 E의 깊이를 탐색해야한다. 그래서 내려가서 E를 확인하고 F로 이동한다. 그리고 F의 모든 이웃을 살펴봐야 한다. 첫 번째 이웃인 K로 이동한다. K에 이웃이 있다면 그 이웃들도 모두 탐색해야 한다.
이러한 과정을 반복하다 보면 결국 H를 찾을것이다.

```java
boolean dfs(Node node, Set<Node> visited, int goal){  
    if(node == null) return false;  
        if(node.val == goal){  
        return true;  
    }  
      
    for(Node neighbor : node.getNeighbors()){  
        if(visited.contains(neighbor)) continue;  
        visited.add(neighbor);  
        boolean isFound = dfs(neighbor,visited,goal);  
        
        if(isFound) return true;  
    }  
    return false;  
 }
```

- 추후 설명...
### ✔️ 10. Memoization
> 피보나치를 작성할 때 간단히 언급한 내용이다. 어떻게 하면 계산한 것이나 처음으로 계산한 것을 저장하여 프로그램을 빠르게 할 수 있을까? 매우 Cost가 많이 드는 작업을 계산했다면, 다음 재귀 호출에서 다시 계산해야 할 때, 이미 해당 작업을 수행했는지 확인하고, 이미 계산한 결과를 반환하면 된다.

```java
Map<Integer,Integer> memoizedCache = new HashMap<>();  
memoizedCache(1,1);  
memoizedCache.put(0,1);  
  
public static long fib(long n){  
    if(memoizedCache.containsKey(n)){   // 전에 계산했던 값인지 체크
        return memoizedCache.get(n);    // 그러면 바로 값 호출
    }  
    int result = fib(n-1) + fib(n-2);   // 아니라면 fib 재귀호출하고
    memoizedCache.put(n,result);        // 그 값들도 저장
    return result;  
}
```

⭐️ 더욱 자세한 설명은 추후 추가하도록 하겠다.

출처
> https://www.youtube.com/watch?v=IJDJ0kBx2LM&t=2740s