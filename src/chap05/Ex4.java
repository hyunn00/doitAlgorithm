package chap05;

import java.util.Scanner;

public class Ex4 {
    // 음이 아닌 정수 n의 팩토리얼 값을 반환
    static void recur2(int n) {
        if(n > 0) {
            recur2(n - 2);
            System.out.println(n);
            recur2(n - 1);
        }
    }

    // 하향식 분석
    //                      -> recur(0)
    //                      -> (2)
    // recur(4) -> recur(2) -> recur(1) -> recur(-1)
    //                                  -> (1)
    //                                  -> recur(0)
    //          -> (4)
    //                                  -> recur(-1)
    //                                  -> (1)
    //          -> recur(3) -> recur(1) -> recur(0)
    //                      -> (3)
    //                      -> recur(2)  -> recur(0)
    //                                   -> (2)
    //                                   -> recur(1) -> recur(-1)
    //                                               -> (1)
    //                                               -> recur(0)
    // 2 1 4 1 3 2 1

    // 상향식 분석
    // recur(1) : recur(-1) + (1) recur(0) => (1)
    // recur(2) : recur(0) + (2) recur(1) => (2) 1
    // recur(3) : recur(1) + (3) recur(2) => 1 (3) 2 1
    // recur(4) : recur(2) + (4) recur(3) => 2 1 (4) 1 3 2 1


    public static void main(String[] args) {
        System.out.println("다음의 recur2 메서드에 대한 하향식 분석과 상향식 분석을 수행하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = scanner.nextInt();

        recur2(x);
    }
}
