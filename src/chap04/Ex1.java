package chap04;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        System.out.println("실습 4-2에서 사용하는 메서드는 size, getCapacity, push, pop, peek, dump뿐 입니다." +
                "클래스 IntStack의 모든 메서드를 사용하는 프로그램을 작성하세요");
        Scanner scanner = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while(true) {
            System.out.println();
            System.out.printf("현재 데이터 개수 : %d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (5) 검색 (6) 비움 (7) 출력 (0) 종료 : ");

            int menu = scanner.nextInt();
            if(menu == 0) break;

            int x;
            switch (menu) {
                case 1 : // 푸시
                    System.out.print("데이터 : ");
                    x = scanner.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackExeption e){
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;
                case 2 : // 팝
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e){
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3 : // 피크
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e){
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 4 : // 덤프
                    s.dump();
                    break;
                case 5: // 요소 찾기
                    System.out.print("검색할 데이터 : ");
                    x = scanner.nextInt();
                    int idx = s.indexOf(x);
                    if(idx >= 0) {
                        System.out.println("찾은 요소는 꼭대기에서 "+ (s.size() - idx) + "번째에 있습니다.");
                    } else {
                        System.out.println("해당 요소가 없습니다.");
                    }
                    break;
                case 6 :
                    s.clear();
                    break;
                case 7 :
                    System.out.println("용량 : " + s.getCapacity());
                    System.out.println("데이터 수 : " + s.size());
                    System.out.println("비어 " + (s.isEmpty() ? " 있습니다." : "있지 않습니다."));
                    System.out.println("가득 " + (s.isFull() ? "차 있습니다." : "차 있지 않습니다."));
                    break;
            }
        }
    }
}
