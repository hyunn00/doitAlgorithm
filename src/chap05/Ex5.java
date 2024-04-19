package chap05;

import java.util.Arrays;
import java.util.Scanner;

public class Ex5 {
    static String[] memo;
    static int[] countMemo;
    static int[] count;
    static void recurMemo(int n) {
        countMemo[n + 1]++;
        if(memo[n + 1] != null) {
//            System.out.println(memo[n + 1]); // 메모를 출력
        } else {
            if(n > 0) {
                recurMemo(n - 1);
//                System.out.println(n);
                recurMemo(n - 2);
                memo[n + 1] = memo[n] + n + "\n" + memo[n -1]; // 메모화
            } else {
                memo[n + 1] = ""; // 메모화 : recur(0)과 recur(-1)은 빈 문자열
            }
        }
    }
    static void recur(int n) {
        count[n + 1]++;
        if(n > 0) {
            recur(n - 1);
//            System.out.println(n);
            recur(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println("실습 5-3과 실습 5-6을 각각 수정하여 메서드 호출 횟수를 카운트해 출력하도록 프로그램을 작성하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = scanner.nextInt();

        memo = new String[x + 2];
        countMemo = new int[x + 2];
        count = new int[x + 2];

        recur(x);
        recurMemo(x);
        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(countMemo));
    }
}
