package chap05;

public class QueenBB {
    static boolean[] flag = new boolean[8]; // 각 행에 퀸을 이미 배치했는지 체크
    static int[] pos = new int[8]; // 각 열에 있는 퀸의 위치

    // 각 열에 있는 퀸을 위치를 출력
    static void print() {
        for(int i = 0; i<8; i++) {
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }

    // i열에 알맞은 위치에 퀀을 배치
    static void set(int i) {
        for(int j = 0; j < 8; j++) {
            if(flag[j] == false) {
                pos[i] = j; // 퀸을 j행에 배치
                if(i == 7) // 모든 열에 배치
                    print();
                else {
                    flag[j] = true;
                    set(i + 1); // 다음 열에 퀸을 배치
                    flag[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        set(0); // 0열에 퀸을 배치
    }
}