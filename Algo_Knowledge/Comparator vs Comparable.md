# Comparable vs Comparator

Comparable 과 Comparator은 모두 인터페이스다.
즉, **Comparable** 혹은 **Comparator을** 사용하고자 한다면 인터페이스 내에 선언된 메소드를 반드시 구현해 주어야한다.

> **Comparable** 은 compareTo(T o) 메소드 하나가 선언되어있다. 우린 이를 메소드 재정의(override)를 해주어야한다.

> **Comparator**은 compare(T o1, T o2) 하나만 재정의(오버라이드) 해주면 된다.

## Comparable

> **Comparable**은 "*자기 자신과 매개변수 객체를 비교*"  > **(compareTo(T o))**

아까 말한 compareTo를 재정의 해주어 객체를 비교할 기준을 정해준다.
만약 Student라는 객체가 있고 column은 **age**인 나이와 **classNumber**인 학급이 있다고 해보자
객체에는 age도 있고 classNumber가 있으니 무엇을 통해 비교할지 compareTo를 통해 정의해주는것이다.

- 코드를 통해 이해해보자

```java
public class Test {
    public static void main(String[] args)  {

        Student a = new Student(17, 2);	// 17살 2반
        Student b = new Student(18, 1);	// 18살 1반


        int isBig = a.compareTo(b);	// a자기자신과 b객체를 비교한다.

        if(isBig > 0) {
            System.out.println("a객체가 b객체보다 큽니다.");
        }
        else if(isBig == 0) {
            System.out.println("두 객체의 크기가 같습니다.");
        }
        else {
            System.out.println("a객체가 b객체보다 작습니다.");
        }

    }

}

class Student implements Comparable<Student> {

    int age;			// 나이
    int classNumber;	// 학급

    Student(int age, int classNumber) {
        this.age = age;
        this.classNumber = classNumber;
    }

    /*
     * 만약 자신의 age가 o의 age보다 크다면 양수가 반환 될 것이고,
     * 같다면 0을, 작다면 음수를 반환할 것이다.
     * 쉽게 말해 이 코드는 자기자신을 기준으로 삼아 대소관계를 파악하는 것이다.
     */
    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}
```

- compareTo에서는 **Student age**를 통해 비교를 했다. 
- 위에서 Student의 객체를 2개를 정의하였는데 
- 하나는 **17살 2반** 하나는 **18살 1반**이다.
- 그러므로 a객체가 더 작다고 반환을 한다.
- 학급 기준으로 비교하고 싶다면 compareTo 메소드에서 **return this.classNumber - o.classNumber;** 를 해주면 될 것이다.

## Comparator

> **Comparator**은 "*두 매개변수 객체를 비교*" 한다. > (compare(T o1, T o2))

차이점은 앞서 말했듯 자기자신과의 비교가 아니라는 점이다.

앞서 Comparable의 compareTo()와는 다르게, 두 객체를 비교하는 것이기 때문에 파라미터로 들어오는 o1과 o2의 classNumber을 비교해주는 것이다.
**o1과 o2를 비교함에 있어 자기 자신은 두 객체 비교에 영향이 없다는 뜻**이다.

- 어떤 의미인지 코드를 통해 알아보자

```java
import java.util.Comparator;
 
public class Test {
	public static void main(String[] args)  {
 
		Student a = new Student(17, 2);	// 17살 2반
		Student b = new Student(18, 1);	// 18살 1반
		Student c = new Student(15, 3);	// 15살 3반
			
		// a객체와는 상관 없이 b와 c객체를 비교한다.
		int isBig = a.compare(b, c);
		
		if(isBig > 0) {
			System.out.println("b객체가 c객체보다 큽니다.");
		}
		else if(isBig == 0) {
			System.out.println("두 객체의 크기가 같습니다.");
		}
		else {
			System.out.println("b객체가 c객체보다 작습니다.");
		}
		
	}
}
 
class Student implements Comparator<Student> {
 
	int age;			// 나이
	int classNumber;	// 학급
	
	Student(int age, int classNumber) {
		this.age = age;
		this.classNumber = classNumber;
	}
    /*
     * 만약 o1의 classNumber가 o2의 classNumber보다 크다면 양수가 반환 될 것이고,
     * 같다면 0을, 작다면 음수를 반환할 것이다.
     */
	@Override
	public int compare(Student o1, Student o2) {
		return o1.classNumber - o2.classNumber;
	}
}
```

- **a.compare(b, c)** 이 보일것이다.
- 이때 a객체는 비교에 아무 의미없고 그저 b와 c만 비교에 참여한다는 의미이다.
- 즉, 객체 자체와는 상관 없이 **독립적으로 매개변수로 넘겨진 두 객체를 비교**하는 것이 포인트다.

- 결과를 보자면 일단 b와 c를 비교하는데 학급으로 비교하기 때문에 
- "**b객체가 c객체보다 작습니다.**" 가 출력될 것이다.

___

> 하지만 생각해보면 b,c를 비교하는데 a객체를 굳이 생성하는게 좀 낭비같다.
이럴때 "**익명 클래스**" 를 활용한다.
> 
> **익명 클래스**는 다음 블로그를 통해 공부해보자! (https://zrr.kr/vh08)

- 코드를 통해 이해해보자

```java
import java.util.Comparator;
 
public class Test {
	public static void main(String[] args)  {
 
		Student a = new Student(17, 2);	// 17살 2반
		Student b = new Student(18, 1);	// 18살 1반
		Student c = new Student(15, 3);	// 15살 3반
			
		// comp 익명객체를 통해 b와 c객체를 비교한다.
        // 따라서 쓸대없는 객체를 생성할 필요가 없어졌다.
		int isBig = comp.compare(b, c);
		
		if(isBig > 0) {
			System.out.println("b객체가 c객체보다 큽니다.");
		}
		else if(isBig == 0) {
			System.out.println("두 객체의 크기가 같습니다.");
		}
		else {
			System.out.println("b객체가 c객체보다 작습니다.");
		}
		
	}
	// 익명 객체 생성
	public static Comparator<Student> comp = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			return o1.classNumber - o2.classNumber;
		}
	};
}

// 외부에서 익명 객체로 Comparator가 생성되기 때문에 클래스에서 Comparator을 구현 할 필요가 없어진다.
class Student {
 
	int age;			// 나이
	int classNumber;	// 학급
	
	Student(int age, int classNumber) {
		this.age = age;
		this.classNumber = classNumber;
	}
	
}

```

> 외부에서 익명 객체로 Comparator가 생성되기 때문에 Student 클래스에서 Comparator을 구현 할 필요가 없어진다.
> 

- Student가 **배열 객체**로 이루어져있고, 이를 정렬하고 싶다면 다음과 같이 파라미터를 통해서도 익명객체를 바로 작성할 수 있다.
```java
/**
 * student변수는 Student객체 배열
 * Student[] student ={
 *      new Student(17,1),
 *      new Student(18,2),
 *      new Student(19,3),
 *  };
 */
Arrays.sort(student, new Comparator<Student>() {
    @Override
    public int compare(User u1, User u2) {
        return u1.age - u2.age;   // Integer 클래스에 정의된 compare 함수로 두 가격 정수 원시값을 비교
    }
});
```

#### 출처
https://st-lab.tistory.com/243
