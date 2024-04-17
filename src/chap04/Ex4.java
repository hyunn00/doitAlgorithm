package chap04;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        System.out.println("'배열로 큐 만들기'에 나타낸 아이디어를 기반으로 큐를 구현하는 프로그램을 작성하세요." +
                "이때 큐를 구현하는 클래스를 다음에 제시한 필드를 갖는 IntArrayQueue형으로 하고, 실습 4-3의 메서드에 대응하는 메서드를 모두 작성하세요.");
        Scanner scanner = new Scanner(System.in);
        IntArrayQueue q = new IntArrayQueue(64);

        while(true) {
            System.out.println();
            System.out.printf("현재 데이터 개수 : %d / %d\n", q.size(), q.getCapacity());
            System.out.print("(1) 인큐 (2) 디큐 (3) 피크 (4) 덤프 (5) 검색 (6) 비움 (7) 출력 (0) 종료 : ");

            int menu = scanner.nextInt();
            if(menu == 0) break;

            int x;
            switch (menu) {
                case 1 : // 푸시
                    System.out.print("데이터 : ");
                    x = scanner.nextInt();
                    try {
                        q.enqueue(x);
                    } catch (IntArrayQueue.OverflowIntQueueException e){
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;
                case 2 : // 팝
                    try {
                        x = q.dequeue();
                        System.out.println("디큐한 데이터는 " + x + "입니다.");
                    } catch (IntArrayQueue.EmptyIntQueueException e){
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 3 : // 피크
                    try {
                        x = q.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntArrayQueue.EmptyIntQueueException e){
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                case 4 : // 덤프
                    q.dump();
                    break;
                case 5: // 요소 찾기
                    System.out.print("검색할 데이터 : ");
                    x = scanner.nextInt();
                    int idx = q.indexOf(x);
                    if(idx >= 0) {
                        System.out.println("찾은 요소는 프런트에서 "+ (q.size() - idx) + "번째에 있습니다.");
                    } else {
                        System.out.println("해당 요소가 없습니다.");
                    }
                    break;
                case 6 :
                    q.clear();
                    break;
                case 7 :
                    System.out.println("용량 : " + q.getCapacity());
                    System.out.println("데이터 수 : " + q.size());
                    System.out.println("비어 " + (q.isEmpty() ? " 있습니다." : "있지 않습니다."));
                    System.out.println("가득 " + (q.isFull() ? "차 있습니다." : "차 있지 않습니다."));
                    break;
            }
        }
    }
}
