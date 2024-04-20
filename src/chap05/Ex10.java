package chap05;

public class Ex10 {
    static boolean[] flag_a = new boolean[8]; // 각 행에 퀸을 배치했는지 체크
    static boolean[] flag_b = new boolean[15]; // / 대각선 방향으로 퀸을 배치했는지 체크
    static boolean[] flag_c = new boolean[15]; // \ 대각선 방향으로 퀸을 배치했는지 체크
    static int[] pos = new int[8]; // 각 열에 있는 퀸의 위치

    // 각 열에 있는 퀸을 위치를 출력
    static void print() {
        for(int i = 0; i<8; i++) {
            for(int j=0; j<8; j++)
                System.out.printf("%2c", pos[i] == j ? '■' : '◻');
            System.out.println();
        }
        System.out.println();

    }

    // i열에 알맞은 위치에 퀀을 배치
    static void set(int i) {
        int j;
        int[] jstk = new int[8];

        Start : while(true) {
            j = 0;
            while (true) {
                while (j < 8) {
                    if (!flag_a[j] && // 가로(j 행)에 아직 배치하지 않음
                            !flag_b[i + j] && // / 대각선에 아직 배치하지 않음
                            !flag_c[i - j + 7]) { // \ 대각선에 아직 배치하지 않음
                        pos[i] = j; // 퀸을 j행에 배치
                        if (i == 7) // 모든 열에 배치
                            print();
                        else {
                            flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
                            jstk[i++] = j;
                            continue Start;
                        }
                    }
                    j++;
                }
                if (--i == -1) return;
                j = jstk[i];
                flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        set(0); // 0열에 퀸을 배치
    }
}
