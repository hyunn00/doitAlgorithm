package chap04;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        System.out.println("일반적으로 덱(deque)이라 하는 양방향 대기열(double ended queue)은 다음 그림처럼 맨 앞과 맨 뒤 양쪽에서 데이터를 인큐하거나 디큐하는 자료구조입니다." +
                "양방향 대기열을 구현하는 클래스 IntDeque를 만드세요." +
                "이때 덱에 저장하는 데이터의 자료형은 int형으로 합니다.");
        Scanner s = new Scanner(System.in);
        IntDeque q = new IntDeque(64);

        while(true) {
            System.out.println();
            System.out.printf("현재 데이터 개수 : %d / %d\n", q.size(), q.getCapacity());
            System.out.print("(1) 맨앞에 인큐 (2) 맨앞에 디큐 (3) 맨앞에 피크\n" +
                    "(4) 맨끝에 인큐 (5) 맨끝에 디큐 (6) 맨끝에 피크\n" +
                    "(7) 덤프 (8) 검색 (0) 종료 : ");

            int menu = s.nextInt();
            if(menu == 0) break;

            int x;
            switch(menu) {
                case 1 :
                    System.out.print("데이터 : ");
                    x = s.nextInt();
                    try {
                        q.enqueFront(x);
                    } catch (Queue.OverflowIntGqueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;
                case 2 :
                    try {
                        x = q.dequeFront();
                        System.out.println("맨앞에서 디큐한 데이터는 "+ x + "입니다.");
                    } catch (Queue.EmptyIntGqueueException e) {
                        System.out.println("큐가 비어 있습니다..");
                    }
                    break;
                case 3:
                    try {
                        x = q.peekFront();
                        System.out.println("맨앞에서 피크한 데이터는 "+ x + "입니다.");
                    } catch (Queue.EmptyIntGqueueException e) {
                        System.out.println("큐가 비어 있습니다..");
                    }
                    break;
                case 4 :
                    System.out.print("데이터 : ");
                    x = s.nextInt();
                    try {
                        q.enqueRear(x);
                    } catch (Queue.OverflowIntGqueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;
                case 5 :
                    try {
                        x = q.dequeRear();
                        System.out.println("맨뒤에서 디큐한 데이터는 "+ x + "입니다.");
                    } catch (Queue.EmptyIntGqueueException e) {
                        System.out.println("큐가 비어 있습니다..");
                    }
                    break;
                case 6:
                    try {
                        x = q.peekRear();
                        System.out.println("맨뒤에서 피크한 데이터는 "+ x + "입니다.");
                    } catch (Queue.EmptyIntGqueueException e) {
                        System.out.println("큐가 비어 있습니다..");
                    }
                    break;
                case 7 :
                    q.dump();
                    break;
                case 8 :
                    System.out.print("데이터 : ");
                    x = s.nextInt();
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
