package chap04;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        System.out.println("하나의 배열을 공유하여 2개의 스택을 구현하는 int형 데이터용 스택 클래스를 만드세요." +
                "스택에 저장하는 데이터는 int형 값으로 아래 그림처럼 배열의 처음과 끝을 모두 사용하세요.");
        Scanner scanner = new Scanner(System.in);
        DoubleHeadIntStack s = new DoubleHeadIntStack(64);

        while(true) {
            System.out.println();
            System.out.printf("현재 데이터 개수 : A -> %d / B -> %d\n",
                    s.size(DoubleHeadIntStack.AorB.StackA),
                    s.size(DoubleHeadIntStack.AorB.StackB));
            System.out.print("(1) A푸시 (2) A팝 (3) A피크 (4) A덤프 (5) A검색 (6) A비움\n : " +
                    "(7) B푸시 (8) B팝 (9) B피크 (10) B덤프 (11) B검색 (12) B비움\n" +
                    "(13) 출력 (0) 종료 : ");

            int menu = scanner.nextInt();
            if(menu == 0) break;

            int n, x;
            switch (menu) {
                case 1 : // 푸시
                    System.out.print("데이터 : ");
                    x = scanner.nextInt();
                    try {
                        s.push(DoubleHeadIntStack.AorB.StackA, x);
                    } catch (DoubleHeadIntStack.OverflowDoubleHeadIntStackExeption e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;
                case 2 : // 팝
                    try {
                        x = s.pop(DoubleHeadIntStack.AorB.StackA);
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (DoubleHeadIntStack.EmptyDoubleHeadIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3 : // 피크
                    try {
                        x = s.peek(DoubleHeadIntStack.AorB.StackA);
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (DoubleHeadIntStack.EmptyDoubleHeadIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 4 : // 덤프
                    s.dump(DoubleHeadIntStack.AorB.StackA);
                    break;
                case 5: // 요소 찾기
                    System.out.print("검색할 데이터 : ");
                    x = scanner.nextInt();
                    n = s.indexOf(DoubleHeadIntStack.AorB.StackA, x);
                    if(n >= 0) {
                        System.out.println("찾은 요소는 꼭대기에서 "+ (s.size(DoubleHeadIntStack.AorB.StackA) - n) + "번째에 있습니다.");
                    } else {
                        System.out.println("해당 요소가 없습니다.");
                    }
                    break;
                case 6 :
                    s.clear(DoubleHeadIntStack.AorB.StackA);
                    break;
                case 7 : // 푸시
                    System.out.print("데이터 : ");
                    x = scanner.nextInt();
                    try {
                        s.push(DoubleHeadIntStack.AorB.StackB, x);
                    } catch (DoubleHeadIntStack.OverflowDoubleHeadIntStackExeption e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;
                case 8 : // 팝
                    try {
                        x = s.pop(DoubleHeadIntStack.AorB.StackB);
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (DoubleHeadIntStack.EmptyDoubleHeadIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 9 : // 피크
                    try {
                        x = s.peek(DoubleHeadIntStack.AorB.StackB);
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (DoubleHeadIntStack.EmptyDoubleHeadIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 10 : // 덤프
                    s.dump(DoubleHeadIntStack.AorB.StackB);
                    break;
                case 11: // 요소 찾기
                    System.out.print("검색할 데이터 : ");
                    x = scanner.nextInt();
                    n = s.indexOf(DoubleHeadIntStack.AorB.StackB, x);
                    if(n >= 0) {
                        System.out.println("찾은 요소는 꼭대기에서 "+ (s.size(DoubleHeadIntStack.AorB.StackA) - n) + "번째에 있습니다.");
                    } else {
                        System.out.println("해당 요소가 없습니다.");
                    }
                    break;
                case 12 :
                    s.clear(DoubleHeadIntStack.AorB.StackB);
                    break;
                case 13 :
                    System.out.println("용량 : " + s.getCapacity());
                    System.out.println("A의 데이터 수 : " + s.size(DoubleHeadIntStack.AorB.StackA));
                    System.out.println("B의 데이터 수 : " + s.size(DoubleHeadIntStack.AorB.StackB));
                    System.out.println("A는 비어 " + (s.isEmpty(DoubleHeadIntStack.AorB.StackA) ? " 있습니다." : "있지 않습니다."));
                    System.out.println("B는 비어 " + (s.isEmpty(DoubleHeadIntStack.AorB.StackB) ? " 있습니다." : "있지 않습니다."));
                    System.out.println("가득 " + (s.isFull() ? "차 있습니다." : "차 있지 않습니다."));
                    break;
            }
        }
    }
}
