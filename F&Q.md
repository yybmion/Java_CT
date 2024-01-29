## F&Q (자주하는 질문)

### 1. 알고리즘(코딩테스트) 진행 방식

1-1. 각자 Part 1~4 문제들을 일주일에 정해진 양만큼 푼다.

1-2. 푼 문제들을 어떻게 풀었는지 /** 주석을 통해 설명한다. (ex. 사용한 라이브러리(API), 시간복잡도 - 더 빨리 풀 수 있는 방법이 있는가? , 전체적인 동작 알고리즘 등등... )  

1-3. 또한 자신이 이 문제를 풀며 안 새로운 사실에 대해서도 공유하면 좋을 것 같다. (ex. 블로그 공유 등등... )

1-4. 문제를 도저히 풀지 못하고 답안을 보았을 때는 풀지 못한 문제라고 표시를 해둔 후 자신이 풀지 못한 간단한 이유와 함께 다시 혼자만의 힘으로 풀어 제출한다.

1-5. 제출은 Pull Request를 통해 제출한다.

1-6. 스터디는 같은 문제에 대해 여러 다른 코드를 보기 위해 제작하였다. (ps. 이후 파이썬, c++ 인원도 구해볼까 한다.)

### 2. Pull Request하는 방법?

2-1. 먼저 지금 이 조직의 리포지토리를 나의 origin(내 깃허브)에 Fork해온다.

![1](https://github.com/Algorithms-CT/Java_CT/assets/113106136/c2c9e0b6-c5a2-4b88-8886-d169ddb80e53)
![2](https://github.com/Algorithms-CT/Java_CT/assets/113106136/9e65ff4f-cc47-49c0-93c4-dbda66207c40)
![3](https://github.com/Algorithms-CT/Java_CT/assets/113106136/d0cc9fd3-74f9-48c6-95a9-9523a00087f1)

- Repository 이름은 원하는대로 설정하면 된다.

2-2. 이후 자신인 사용하는 IDE (IntelliJ, Eclipse ...)를 통해 Java 클래스를 만들 수 있는 폴더를 하나 만든다.

![image](https://github.com/Algorithms-CT/Java_CT/assets/113106136/3fdbf096-613c-4fef-ba8b-484f1be9b134)

- 원하는 local 장소에 project를 만들면 폴더가 하나 생길 것이다.

2-3. 그럼 폴더를 IDE에서 열어서 Terminal을 열어준다.

- 아래 그림은 Intellij terminal 여는 방법이다.

![image](https://github.com/Algorithms-CT/Java_CT/assets/113106136/edab7bc8-e0f2-4c4c-a554-c219ffc8995b)

2-4. 다음은 그 폴더에 아까 Fork해온 리포지토리를 Clone 해올 것이다.

```bash
git clone <레포지토리 URL>     // 혹시 몰라서 말하는 거지만 <> 는 작성하면 안된다.
```

- 레포지토리 url은 Fork 해온 내 리포지토리!!! 에 url을 복사해와서 Terminal에 작성해야한다.

![image](https://github.com/Algorithms-CT/Java_CT/assets/113106136/00073543-b61e-45e2-83a2-bca175842959)

2-5. git init한다.

```bash
git init
```

2-6. remote 설정

```bash
git remote add father <원본 저장소 url>   // 원본 저장소 url은 조직의 url을 작성한다.
```

- 위에서도 말했지만 원본 저장소 url은 조직의 url을 가져와야한다.

![image](https://github.com/Algorithms-CT/Java_CT/assets/113106136/519328cd-8d24-44c0-9b1c-9d2f9d3c597a)

- 앞에 설정한 url 두개는 서로 다르니 주의하자!!!! 꼭
- git remote -v 를 통해 origin하고 upstream 리포지토리가 설정된 것을 볼 수 있을것이다.
- 결과는 다음과 같아야한다.

![image](https://github.com/Algorithms-CT/Java_CT/assets/113106136/56f2a8dc-25b3-4fde-a2f9-081f3f3e323f)

- 물론 자신의 리포지토리 url은 다르다. 조직만 같다.

