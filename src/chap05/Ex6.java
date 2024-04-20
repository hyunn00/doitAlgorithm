package chap05;

import java.util.Scanner;

public class Ex6 {
    static void recur3(int n) {
        int[] nstk = new int[100];
        int[] sstk = new int[100];
        int ptr = -1;
        int sw = 0;

        while(true) {
            if (n > 0) {
                ptr++;
                nstk[ptr] = n;
                sstk[ptr] = sw;

                if(sw == 0)
                    n = n - 1;
                else if(sw == 1) {
                    n = n - 2;
                    sw = 0;
                }

                continue;
            }

            do {
                n = nstk[ptr];
                sw = sstk[ptr--] + 1;
                if(sw == 2) {
                    System.out.println(n);
                    if(ptr < 0)
                        return;
                }
            } while(sw == 2);
        }
    }

    public static void main(String[] args) {
        System.out.println("오른쪽 recur3 메서드를 비재귀적으로 구현한 프로그램을 작성하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = scanner.nextInt();

        recur3(x);
    }
}
