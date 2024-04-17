package chap04;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        System.out.println("임의의 객체형 데이터를 쌓아 놓을 수 있는 제네릭 큐 클래스 Queue<E>를 작성하세요.");
        Scanner s = new Scanner(System.in);
        Queue<String> q = new Queue<>(64);

        while(true) {
            System.out.println();
            System.out.printf("현재 데이터 개수 : %d / %d\n", q.size(), q.getCapacity());
            System.out.print("(1) 인큐 (2) 디큐 (3) 피크 (4) 덤프 (5) 검색 (0) 종료 : ");

            int menu = s.nextInt();
            if(menu == 0) break;

            String x;
            switch(menu) {
                case 1 :
                    System.out.print("데이터 : ");
                    x = s.next();
                    try {
                        q.enque(x);
                    } catch (Queue.OverflowIntGqueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;
                case 2 :
                    try {
                        x = q.deque();
                        System.out.println("디큐한 데이터는 "+ x + "입니다.");
                    } catch (Queue.EmptyIntGqueueException e) {
                        System.out.println("큐가 비어 있습니다..");
                    }
                    break;
                case 3:
                    try {
                        x = q.peek();
                        System.out.println("피크한 데이터는 "+ x + "입니다.");
                    } catch (Queue.EmptyIntGqueueException e) {
                        System.out.println("큐가 비어 있습니다..");
                    }
                    break;
                case 4 :
                    q.dump();
                    break;
                case 5 :
                    System.out.print("데이터 : ");
                    x = s.next();
                    int idx = q.search(x);
                    if(idx != 0)
                        System.out.printf("%d번째 데이터로 인덱스 %d의 위치에 저장되어 있습니다.\n", idx, q.indexOf(x));
                    else
                        System.out.println("그 데이터는 등록되어 있지 않습니다.");
                    break;
            }
        }
    }
}
