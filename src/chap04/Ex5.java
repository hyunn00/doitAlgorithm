package chap04;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        System.out.println("클래스 IntQueue에 임의의 데이터를 검색하는 메서드 search를 추가하세요." +
                "메서드 indexOf처럼 찾은 위치의 배열 인덱스를 반환하는 것이 아니라 큐 안에서 논리적으로 몇 번째인가를 양수(큐의 프런트에 있으면 1로 함)로 반환합니다." +
                "검색에 실패하면 0을 반환합니다.");
        Scanner s = new Scanner(System.in);
        IntQueue q = new IntQueue(64);

        while(true) {
            System.out.println();
            System.out.printf("현재 데이터 개수 : %d / %d\n", q.size(), q.getCapacity());
            System.out.print("(1) 인큐 (2) 디큐 (3) 피크 (4) 덤프 (5) 검색 (0) 종료 : ");

            int menu = s.nextInt();
            if(menu == 0) break;

            int x;
            switch(menu) {
                case 1 :
                    System.out.print("데이터 : ");
                    x = s.nextInt();
                    try {
                        q.enque(x);
                    } catch (IntQueue.OverflowIntQueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;
                case 2 :
                    try {
                        x = q.deque();
                        System.out.println("디큐한 데이터는 "+ x + "입니다.");
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비어 있습니다..");
                    }
                    break;
                case 3:
                    try {
                        x = q.peek();
                        System.out.println("피크한 데이터는 "+ x + "입니다.");
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비어 있습니다..");
                    }
                    break;
                case 4 :
                    q.dump();
                    break;
                case 5 :
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
