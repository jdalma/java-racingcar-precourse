# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항

1. 자동차들의 이름 입력 받기
   - 자동차 이름은 `, (쉼표)`를 기준으로 구분하며 이름은 5자 이하만 가능
2. 시도할 회수 입력 받기
   - 숫자만
3. 회수만큼 0 ~ 9까지 랜덤 값을 구하여 4 이상일 경우 전진, 3 이하의 값은 멈춘다
4. 많이 전진한 자동차의 이름을 출력한다
   - 우승자가 여러명이면 `, (쉼표)`로 구분해 출력한다.
5. 사용자가 잘못된 값을 입력한다면 IllegalArgumentException이 발생하고 `"[ERROR]"`로 시작하는 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
